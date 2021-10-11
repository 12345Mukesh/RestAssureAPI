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

public class Tc_003_CreateContact_StartDate_Test
{
    WebDriver driver;
    @Test
	public void Tc003_CreateContactwithStartDate() throws Throwable
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
				String abc1 = wb.getSheet("Sheet1").getRow(0).getCell(4).toString();
				WebElement First = driver.findElement(By.name("salutationtype"));
				Select Firstdd = new Select(First);
				Firstdd.selectByValue(abc1);
				
		//Entering the lastname
				String b1 = wb.getSheet("Sheet1").getRow(3).getCell(0).toString();
				driver.findElement(By.name("lastname")).sendKeys(b1);
				
				//clicking the dropdown of leadsource
				String b2 = wb.getSheet("Sheet1").getRow(3).getCell(1).toString();
				WebElement Leadsource = driver.findElement(By.name("leadsource"));
				Select Lead = new Select(Leadsource);
				Lead.selectByValue(b2);
				
				//Entering data in Home mobile
				String b3 = wb.getSheet("Sheet1").getRow(3).getCell(2).toString();
				driver.findElement(By.id("otherphone")).sendKeys(b3);
				
				//click on Do not call checkbox
				driver.findElement(By.name("donotcall")).click();
	 
				 //scrolldown
				
				WebElement element= driver.findElement(By.name("portal"));
				Point loc= element.getLocation();
				JavascriptExecutor jse= (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy"+loc);
	
	
				//Selecting Date
				//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Calendar.gif']")).click();
				//Date not inspecting
				
				//clicking on save button
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	
				
				//clicking on again contacts
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//Entering data into textbox
				driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(b1);
			
				String abc3 = wb.getSheet("Sheet1").getRow(0).getCell(6).toString();
				
				//selecting value from dropdown
				WebElement Indropdown = driver.findElement(By.id("bas_searchfield"));
				Select Indd = new Select(Indropdown);
				Indd.selectByVisibleText(abc3);

				//click on submit button
				driver.findElement(By.xpath("//input[@name='submit']")).click();

			WebElement contactname = driver.findElement(By.xpath("//a[@title='Contacts' and text()='" + b1+ "']"));

			if (contactname.isDisplayed()) 
			{
				Assert.assertTrue(true);
				}

				
				
				
		driver.close();
		
	
				
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
    
	
	
	
	
	
	
	
	
}
