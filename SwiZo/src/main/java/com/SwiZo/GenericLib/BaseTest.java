package com.SwiZo.GenericLib;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IACo 
{

	
	public static WebDriver driver;
	
	@BeforeMethod
	
	public void openBrowser() throws Throwable
	{
		Filelib flib= new Filelib();
		String browsername=flib.readPropertyData(PROP_PATH, "browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver= new ChromeDriver();
		}
		else
			if(browsername.equalsIgnoreCase("firefox"))
			{
				System.setProperty(GECKO_KEY, GECKO_VALUE);
				driver = new FirefoxDriver();
				
			}
			else
			{
				System.out.println("Enter proper browser name");
			}
		
		driver.manage().window().maximize();
		String appurl = flib.readPropertyData(PROP_PATH, "url");
		driver.get(appurl);
//		String appurl1= flib.ReadExcelData(EXCEL_PATH, "Account", 4, 2);
//		driver.get(appurl1);
		
		
	}

   @AfterMethod
    public void closeBrowser()
    {
    	driver.quit();
    }

	
	
	
	
	
	
	
	
	
	
	
	
}
