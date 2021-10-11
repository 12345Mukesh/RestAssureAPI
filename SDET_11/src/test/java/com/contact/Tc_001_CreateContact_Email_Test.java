package com.contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class Tc_001_CreateContact_Email_Test
{     
	WebDriver driver;
	
	@Test
	public void Tc001_CreateContactwithEmail() throws Throwable
	{
		FileInputStream fis = new FileInputStream("../SDET_11/src/test/resources/data/config1.properties");
		Properties prop = new Properties();
		prop.load(fis);

		FileInputStream fs = new FileInputStream("../SDET_11/src/test/resources/data/Input Data.xlsx");
		Workbook wb = WorkbookFactory.create(fs);

		
		//Enter the browser
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
			System.out.println("chrome is opened");
		} else if (browsername.equals("ff")) {

		} else {
			System.out.println("please enter proper browser name");
		}
		
		//Enter the url
		driver.get(prop.getProperty("url"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//Enter the username and password
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		//selecting first name in dropdown
		String abc1 = wb.getSheet("Sheet1").getRow(0).getCell(4).toString();
		WebElement First = driver.findElement(By.name("salutationtype"));
		Select Firstdd = new Select(First);
		Firstdd.selectByValue(abc1);
		
		//selecting last name and mobile number
		
//		Random random = new Random();
//		int randomnumber = random.nextInt(1000);
//		System.out.println(randomnumber);
//		String orgname = abc4 + randomnumber;
		
		String abc4 = wb.getSheet("Sheet1").getRow(1).getCell(3).toString();
		String abc5 = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();
		driver.findElement(By.name("lastname")).sendKeys(abc4);
		driver.findElement(By.id("mobile")).sendKeys(abc5);
		
		//selecting title and department
		String abc6 = wb.getSheet("Sheet1").getRow(1).getCell(4).toString();
		driver.findElement(By.id("title")).sendKeys(abc6);
		String abc7 = wb.getSheet("Sheet1").getRow(1).getCell(5).toString();
		driver.findElement(By.id("department")).sendKeys(abc7);
		
		//selecting Email id and Emailoptout
		
		String abc8 = wb.getSheet("Sheet1").getRow(1).getCell(6).toString();
		driver.findElement(By.id("email")).sendKeys(abc8);
		
		driver.findElement(By.name("emailoptout")).click();
		
		//clicking on Reference checkbox
		driver.findElement(By.name("reference")).click();
		
		//clicking on save button
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				//clicking on again contacts
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//Entering data into textbox
				driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(abc4);
			
				String abc3 = wb.getSheet("Sheet1").getRow(0).getCell(6).toString();
				
				//selecting value from dropdown
				WebElement Indropdown = driver.findElement(By.id("bas_searchfield"));
				Select Indd = new Select(Indropdown);
				Indd.selectByVisibleText(abc3);

				//click on submit button
				driver.findElement(By.xpath("//input[@name='submit']")).click();

			WebElement contactname = driver.findElement(By.xpath("//a[@title='Contacts' and text()='" + abc4+ "']"));

			if (contactname.isDisplayed()) 
			{
				Assert.assertTrue(true);
				}

				
				
				
		driver.close();
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
