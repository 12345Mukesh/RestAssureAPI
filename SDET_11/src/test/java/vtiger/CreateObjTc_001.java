package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CreateObjTc_001 {
	WebDriver driver;

	public void TC001_CreateObjwithDropdown() throws InterruptedException, Throwable {

		FileInputStream fis = new FileInputStream("../SDET_11/src/test/resources/data/config1.properties");
		Properties prop = new Properties();
		prop.load(fis);

		FileInputStream fs = new FileInputStream("../SDET_11/src/test/resources/data/Input Data.xlsx");
		Workbook wb = WorkbookFactory.create(fs);

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
			System.out.println("chrome is opened");
		} else if (browsername.equals("ff")) {

		} else {
			System.out.println("please enter proper browser name");
		}
		driver.get(prop.getProperty("url"));

		String abc = wb.getSheet("Sheet1").getRow(0).getCell(0).toString();
		String abc1 = wb.getSheet("Sheet1").getRow(0).getCell(1).toString();
		String abc2 = wb.getSheet("Sheet1").getRow(0).getCell(2).toString();
		String abc3 = wb.getSheet("Sheet1").getRow(0).getCell(3).toString();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		Random random = new Random();
		int randomnumber = random.nextInt(1000);
		System.out.println(randomnumber);
		String orgname = abc + randomnumber;
		driver.findElement(By.name("accountname")).sendKeys(orgname);

		WebElement industrydropdown = driver.findElement(By.name("industry"));
		Select industrydd = new Select(industrydropdown);
		industrydd.selectByVisibleText(abc1);

		WebElement ratingdropdown = driver.findElement(By.name("rating"));
		Select ratingdd = new Select(ratingdropdown);
		ratingdd.selectByValue(abc2);

		WebElement typedropdown = driver.findElement(By.name("accounttype"));
		Select typedd = new Select(typedropdown);
		typedd.selectByIndex(3);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.name("search_text")).sendKeys(orgname);

		WebElement searchfldDropdown = driver.findElement(By.name("search_field"));

		Select searchdd = new Select(searchfldDropdown);
		searchdd.selectByVisibleText(abc3);

		driver.findElement(By.name("submit")).click();

		WebElement organisationname = driver
				.findElement(By.xpath("//a[@title='Organizations' and text()= '" + orgname + "']"));

		if (organisationname.isDisplayed()) {
			Assert.assertTrue(true);
		}

		driver.close();

	}

}
