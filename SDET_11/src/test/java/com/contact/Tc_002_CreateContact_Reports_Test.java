package com.contact;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc_002_CreateContact_Reports_Test
{
   WebDriver driver;
   @Test
   public void Tc002_CreateContactwithReports() throws Throwable
   {
	   FileInputStream fis = new FileInputStream("../SDET_11/src/test/resources/data/config1.properties");
		Properties prop = new Properties();
		prop.load(fis);

		FileInputStream fs = new FileInputStream("../SDET_11/src/test/resources/data/Input Data.xlsx");
		Workbook wb = WorkbookFactory.create(fs);

		//open the browser
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

		//Entering the username and password
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		//selecting first name in dropdown
				String a1 = wb.getSheet("Sheet1").getRow(2).getCell(0).toString();
				WebElement First = driver.findElement(By.name("salutationtype"));
				Select Firstdd = new Select(First);
				Firstdd.selectByValue(a1);
				
				String a2 = wb.getSheet("Sheet1").getRow(2).getCell(1).toString();
				driver.findElement(By.name("firstname")).sendKeys(a2);
				
	   //selecting the last name in the dropdown
				String a3 = wb.getSheet("Sheet1").getRow(2).getCell(2).toString();
				driver.findElement(By.name("lastname")).sendKeys(a3);
	   
		//selecting the organisation using window handle
				WebElement abc = driver.findElement(By.xpath("(//img[@title='Select'])[1]"));
				abc.click();

				Set<String> windows = driver.getWindowHandles();
				Iterator<String> window = windows.iterator();

				String parentWindow = window.next();
				String childWindow = window.next();

				driver.switchTo().window(childWindow);

				driver.findElement(By.id("search_txt")).sendKeys(wb.getSheet("Sheet1").getRow(0).getCell(0).toString());

				driver.findElement(By.name("search")).click();

				driver.findElement(By.xpath("//a[@id='1' and text()='" + wb.getSheet("Sheet1").getRow(0).getCell(0) + "']"))
				.click();

				driver.switchTo().window(parentWindow);
	   
	            //Entering the office phone
				String a4 = wb.getSheet("Sheet1").getRow(2).getCell(3).toString();
				driver.findElement(By.id("phone")).sendKeys(a4);
	   
	           //Reports to Window Handle
				
				WebElement abc1 = driver.findElement(By.xpath("(//img[@title='Select'])[2]"));
				abc1.click();

				Set<String> allwindows = driver.getWindowHandles();
				Iterator<String> onewindow = allwindows.iterator();
				String parentWindow1 = onewindow.next();
				String childWindow1 = onewindow.next();
	   
				driver.switchTo().window(childWindow1);
				String a=wb.getSheet("Sheet1").getRow(1).getCell(3).toString();
				driver.findElement(By.id("search_txt")).sendKeys(a);
				driver.findElement(By.name("search")).click();
				
				//selecting from the list in whole table, select 7th table and all the rows and select 1st column
			List<WebElement> names=	driver.findElements(By.xpath("(//table)[7]//tr[*]//td[1]"));
			//In that what the element id is there give in the get
			names.get(2).click();
				driver.switchTo().window(parentWindow1);
	   
	            //selecting the secondary email	
				String a5 = wb.getSheet("Sheet1").getRow(2).getCell(4).toString();
				driver.findElement(By.id("secondaryemail")).sendKeys(a5);
				
				//Assign to Group click radio button
				driver.findElement(By.name("assigntype")).click();
				
				//clicking on save button
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				//clicking on again contacts
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//Entering data into textbox
				driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(a3);
			
				String abc3 = wb.getSheet("Sheet1").getRow(0).getCell(6).toString();
				
				//selecting value from dropdown
				WebElement Indropdown = driver.findElement(By.id("bas_searchfield"));
				Select Indd = new Select(Indropdown);
				Indd.selectByVisibleText(abc3);

				//click on submit button
				driver.findElement(By.xpath("//input[@name='submit']")).click();

			WebElement contactname = driver.findElement(By.xpath("//a[@title='Contacts' and text()='" + a3+ "']"));

			if (contactname.isDisplayed()) 
			{
				Assert.assertTrue(true);
				}
				
				
				driver.close();
   }
	
	
	
	
	
	
	
}
