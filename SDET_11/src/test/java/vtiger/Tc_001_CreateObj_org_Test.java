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

import com.Vtiger.Generic.ExcelUtility;
import com.Vtiger.Generic.FileUtility;
import com.Vtiger.Generic.JavaUtility;

@Test
public class Tc_001_CreateObj_org_Test {
	WebDriver driver;

	public void TC001_CreateObjwithDropdown() throws InterruptedException, Throwable 
	{

		FileUtility flib= new FileUtility();
		ExcelUtility Elib= new ExcelUtility();
		JavaUtility jlib= new JavaUtility();
		//open the browser
		String browsername = flib.readDatafromPropfile("browser");
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
			System.out.println("chrome is opened");
		} else if (browsername.equals("ff")) {

		} else {
			System.out.println("please enter proper browser name");
		}
		
		//Enter the url
		driver.get(flib.readDatafromPropfile("url"));

		String abc = Elib.readDatafromExcel(0, 0, "Sheet1");
		String abc1 = Elib.readDatafromExcel(0, 1, "Sheet1");
		String abc2 = Elib.readDatafromExcel(0, 2, "Sheet1");
		String abc3 = Elib.readDatafromExcel(0, 3, "Sheet1");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("user_name")).sendKeys(flib.readDatafromPropfile("username"));
		driver.findElement(By.name("user_password")).sendKeys(flib.readDatafromPropfile("password"));
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		
		String orgname = abc + jlib.generateRandomNo();
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
