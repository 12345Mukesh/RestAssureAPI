package com.practice;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
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

public class Windowpractice
{

   WebDriver driver;
	   
		@Test
		public void Tc_CreateContactDatawithAddress() throws Throwable
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

			
			//clicking on contact tab
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();

			//click on + button
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			
			//selecting first name in dropdown
					String d1 = wb.getSheet("Sheet1").getRow(5).getCell(0).toString();
					WebElement First = driver.findElement(By.name("salutationtype"));
					Select Firstdd = new Select(First);
					Firstdd.selectByValue(d1);
			
					//selecting the first name
					String d2 = wb.getSheet("Sheet1").getRow(5).getCell(1).toString();
					driver.findElement(By.name("firstname")).sendKeys(d2);
			
					//Entering the lastname
					String d3 = wb.getSheet("Sheet1").getRow(5).getCell(2).toString();
					driver.findElement(By.name("lastname")).sendKeys(d3);
					
					//selecting the organisation using window handle
					WebElement abc = driver.findElement(By.xpath("(//img[@title='Select'])[1]"));
					abc.click();
					
                    String window=driver.getWindowHandle();
					Set<String> windows = driver.getWindowHandles();
					System.out.println(windows);
					for(String whs:windows)
					{
						
							String title=driver.switchTo().window(whs).getTitle();
							if(title.contains("Contacts"))
							{
					             driver.findElement(By.id("search_txt")).sendKeys(wb.getSheet("Sheet1").getRow(1).getCell(0).toString());
					             driver.findElement(By.name("search")).click();
					//selecting from the list in whole table, select 7th table and all the rows and select 1st column
					             List<WebElement> names=	driver.findElements(By.xpath("(//table)[7]//tr[*]//td[1]//a"));
					             System.out.println(names);
					//In that what the element id is there give in the get
					             names.get(1).click();
					
						}
					  driver.switchTo().window(window);
					}
						   
					
					
					//clicking the dropdown of leadsource
					String d5 = wb.getSheet("Sheet1").getRow(5).getCell(3).toString();
					WebElement Leadsource = driver.findElement(By.name("leadsource"));
					Select Lead = new Select(Leadsource);
					Lead.selectByValue(d5);
					
					
					//Entering mobile number
					String d6 = wb.getSheet("Sheet1").getRow(5).getCell(4).toString();
					driver.findElement(By.id("mobile")).sendKeys(d6);
					
					
					//click checkbox of Do not call
					driver.findElement(By.name("donotcall")).click();
					
					//scrolldown
					WebElement element= driver.findElement(By.xpath("//textarea[@name='mailingstreet']"));
					Point loc= element.getLocation();
					JavascriptExecutor jse= (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy"+loc);
		
					
					//Entering address 
					
					//Street
					String d7 = wb.getSheet("Sheet1").getRow(5).getCell(5).toString();
					driver.findElement(By.xpath("//textarea[@name='mailingstreet']")).sendKeys(d7);
					
					//city
					String d8 = wb.getSheet("Sheet1").getRow(5).getCell(6).toString();
					driver.findElement(By.id("mailingcity")).sendKeys(d8);
					
					//State
					String d9 = wb.getSheet("Sheet1").getRow(5).getCell(7).toString();
					driver.findElement(By.id("mailingstate")).sendKeys(d9);
					
					//country
					String d10 = wb.getSheet("Sheet1").getRow(5).getCell(8).toString();
					driver.findElement(By.id("mailingcountry")).sendKeys(d10);
					
					
					//clicking on save button
					driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
					
					//clicking on again contacts
					driver.findElement(By.xpath("//a[text()='Contacts']")).click();
					
					//Entering data into textbox
					driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(d3);
				
					
					
					//selecting value from dropdown
					String abc3 = wb.getSheet("Sheet1").getRow(0).getCell(6).toString();
					WebElement Indropdown = driver.findElement(By.id("bas_searchfield"));
					Select Indd = new Select(Indropdown);
					Indd.selectByVisibleText(abc3);
	
					//click on submit button
					driver.findElement(By.xpath("//input[@name='submit']")).click();
	
				WebElement contactname = driver.findElement(By.xpath("//a[@title='Contacts' and text()='" + d3+ "']"));
	
				if (contactname.isDisplayed()) 
				{
					Assert.assertTrue(true);
     			}
			       
				driver.close();
		
					
					
					
			
		}
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	

