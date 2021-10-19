package com.practice;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_001_DeleteOrganization_Test 
{

	WebDriver driver;
	@Test
	
	public void Tc001_DeleteOrganization() throws Throwable
	{
		FileInputStream fis = new FileInputStream("../SDET_11/src/test/resources/data/config1.properties");
		Properties prop = new Properties();
		prop.load(fis);

		FileInputStream fs = new FileInputStream("../SDET_11/src/test/resources/data/Input Data.xlsx");
		Workbook wb = WorkbookFactory.create(fs);

		//opening the browser
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) 
		{
			driver = new ChromeDriver();
			System.out.println("chrome is opened");
		} 
		else if (browsername.equals("ff"))
		{

		}
		else
		{
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
	
	
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//selecting one organization and deleting it     //i)selecting the table having the list
		WebElement checkbox=driver.findElement(By.xpath("(//table)[46]/tbody/tr[*]/td/a[@title='Organizations' and text()='QSPHYD912']/preceding::input[@name='selected_id' and @value='21' ]"));
		checkbox.click();                                             //ii) in table body and selecting all table rows
		                                                                              //iii)in table data selecting the organization name
		                                                                                   // by giving two ids text and organization
		//Normal type of deleting data                                                                                                  //iv) preceding forward and selecting the checkbox by 
		//a[text()='QSPHYD402']//preceding::input[@id='20' and @value='20']                                                                     giving name and value
	                                                                      
		//clicking on Delete button                                               
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		//For clicking ok we will use accept button
		driver.switchTo().alert().accept();
	     
		driver.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
}
