package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tc_002_Clicking_Checkboxes_Test
{
   WebDriver driver;
   @Test
   
   public void Tc002_Clickingallcheckboxes() throws Throwable
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
		
	   List<WebElement> chkbxes= driver.findElements(By.xpath("(//table)[46]/tbody/tr[*]/td[1]"));
	   
	   System.out.println(chkbxes.size());
	   
	   int count=0;
	   
	   for(int i=3;i<chkbxes.size()+1;i++)
	   {
		    driver.findElement(By.xpath("(//table)[46]/tbody/tr["+i+"]/td[1]/input")).click();
		    count++;
		    
	   }
	   
	   System.out.println(count);
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
   }
	
	
}
