package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

public class Tc_001_CreateContact_org_Test {
	WebDriver driver;

	@Test
	public void CreatecontactTest() throws Throwable {

		FileUtility flib= new FileUtility();
		ExcelUtility Elib= new ExcelUtility();
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

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);           
		driver.manage().window().maximize();                                       
		
       //Giving username and password
		driver.findElement(By.name("user_name")).sendKeys(flib.readDatafromPropfile("username"));
		driver.findElement(By.name("user_password")).sendKeys(flib.readDatafromPropfile("password"));
		driver.findElement(By.id("submitButton")).click();

		//clicking on contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		 //clicking on + button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		//Selecting first name in Dropdown
		String abc1 = Elib.readDatafromExcel(0, 4, "Sheet1");
		WebElement First = driver.findElement(By.name("salutationtype"));
		Select Firstdd = new Select(First);
		Firstdd.selectByValue(abc1);

		Random random = new Random();
		int randomnumber = random.nextInt(1000);
		System.out.println(randomnumber);

		//selecting last name and mobile number
		String abc4 = Elib.readDatafromExcel(1, 1, "Sheet1");
		String abc5 = Elib.readDatafromExcel(1, 2, "Sheet1");
		driver.findElement(By.name("lastname")).sendKeys(abc4);
		driver.findElement(By.id("mobile")).sendKeys(abc5);

		//clicking the dropdown of leadsource
		String abc2 = Elib.readDatafromExcel(0, 5, "Sheet1");
		WebElement Leadsource = driver.findElement(By.name("leadsource"));
		Select Lead = new Select(Leadsource);
		Lead.selectByValue(abc2);

		//clicking on save button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		Thread.sleep(4000);

		//-----------verifying process-------------------
		//clicking on again contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Entering data into textbox
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(abc4);
		String abc3 = Elib.readDatafromExcel(0, 6, "Sheet1");
		
		//selecting value from dropdown
		WebElement Indropdown = driver.findElement(By.id("bas_searchfield"));
		Select Indd = new Select(Indropdown);
		Indd.selectByVisibleText(abc3);

		//click on submit button
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		//
		WebElement contactname = driver.findElement(By.xpath("//a[@title='Contacts' and text()='" + abc4+ "']"));

		if (contactname.isDisplayed()) {
			Assert.assertTrue(true);
		}

		driver.close();

	}

}
