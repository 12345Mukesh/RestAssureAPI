package com.practice;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tc_001_ICCMENSTEAM_Test 
{

	WebDriver driver;
	@Test
	
	public void Tc001_ICCTEAMRANKINGS() throws Throwable
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
		driver.get(prop.getProperty("url1"));
		driver.manage().window().maximize();
		
		List<WebElement> list=driver.findElements(By.xpath("(//table)[1]//tr[*]"));
		
		for(int i=0;i<=list.size()-1;i++)
		{
			System.out.println(list.get(i).getText());
		}
		
		
		
		
		
	}
	
	
	
	
}
