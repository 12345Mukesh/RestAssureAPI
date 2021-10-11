package com.contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc_004_CreateContact_Description_Test
{

	WebDriver driver;
	@Test
	public void Tc004_CreateContactwithDescription() throws Throwable
	{
		FileInputStream fis = new FileInputStream("../SDET_11/src/test/resources/data/config1.properties");
		Properties prop = new Properties();
		prop.load(fis);

		FileInputStream fs = new FileInputStream("../SDET_11/src/test/resources/data/Input Data.xlsx");
		Workbook wb = WorkbookFactory.create(fs);

		//opening the browser
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
			System.out.println("chrome is opened");
		} else if (browsername.equals("ff")) {

		} else {
			System.out.println("please enter proper browser name");
		}
		
		//Entering the url
		driver.get(prop.getProperty("url"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//Entering the username and password
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();

		
		//clicking on contact tab
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		//click on + button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		
		//selecting first name in dropdown
				String c1 = wb.getSheet("Sheet1").getRow(4).getCell(0).toString();
				WebElement First = driver.findElement(By.name("salutationtype"));
				Select Firstdd = new Select(First);
				Firstdd.selectByValue(c1);
		
				//Entering the lastname
				String c2 = wb.getSheet("Sheet1").getRow(4).getCell(1).toString();
				driver.findElement(By.name("lastname")).sendKeys(c2);
		
				//clicking the dropdown of leadsource
				String c3 = wb.getSheet("Sheet1").getRow(4).getCell(2).toString();
				WebElement Leadsource = driver.findElement(By.name("leadsource"));
				Select Lead = new Select(Leadsource);
				Lead.selectByValue(c3);
		
		        //Entering fax id
				String c4 = wb.getSheet("Sheet1").getRow(4).getCell(3).toString();
	         	driver.findElement(By.id("fax")).sendKeys(c4);
		
               // clicking on checkbox reference
	         	driver.findElement(By.name("reference")).click();
	         	
	         	//clicking on checkbox of notify owner
	         	driver.findElement(By.name("notify_owner")).click();
	         	
	         	//scrolldown
				WebElement element= driver.findElement(By.name("portal"));
				Point loc= element.getLocation();
				JavascriptExecutor jse= (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy"+loc);
	
		      
				
				//Entering data in Description
				String c5 = wb.getSheet("Sheet1").getRow(4).getCell(4).toString();
		        driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[3]")).sendKeys(c5);
		
		        //clicking on save button
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

				//clicking on again contacts
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//Entering data into textbox
				driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(c2);
			
				
				
				//selecting value from dropdown
				String abc3 = wb.getSheet("Sheet1").getRow(0).getCell(6).toString();
				WebElement Indropdown = driver.findElement(By.id("bas_searchfield"));
				Select Indd = new Select(Indropdown);
				Indd.selectByVisibleText(abc3);

				//click on submit button
				driver.findElement(By.xpath("//input[@name='submit']")).click();

			WebElement contactname = driver.findElement(By.xpath("//a[@title='Contacts' and text()='" + c2+ "']"));

			if (contactname.isDisplayed()) 
			{
				Assert.assertTrue(true);
				}
		        driver.close();
		
		
		
		
		
		
	}







}
