package com.Vtiger.pomscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import com.Vtiger.Generic.FileUtility;
import com.Vtiger.Generic.JavaUtility;
import com.Vtiger.Generic.WebDriverUtility;
import com.Vtiger.ObjectRepo.CreateNewOrg;
import com.Vtiger.ObjectRepo.HomePage;
import com.Vtiger.ObjectRepo.LoginPage;
import com.Vtiger.ObjectRepo.OrgInfoPage;

public class Tc_001_CreateOrg_DD_Test 
{
   WebDriver driver;
   @Test
	public void Tc001_CreateOrgDDTest() throws Throwable
	{
		JavaUtility jv = new JavaUtility();	
		int randomnumber =jv.generateRandomNo();

		String orgname="QSPHYD"+randomnumber;
		System.out.println(orgname);



		FileUtility fileutility= new FileUtility();


		//Step 1 Launch App
		if
		(fileutility.readDatafromPropfile("browser").equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if
		(fileutility.readDatafromPropfile("browser").equalsIgnoreCase("ff"))
		{
			driver = new FirefoxDriver();
		}
		else if
		(fileutility.readDatafromPropfile("browser").equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}

		else
		{
			driver= new ChromeDriver();
		}


		driver.get(fileutility.readDatafromPropfile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//Step 2 Login to app
		LoginPage lp= new LoginPage(driver);
		lp.logintoApp();

		//step 3 click on org link
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		//step 4 click on + btn
		OrgInfoPage oip= new OrgInfoPage(driver);
		oip.createorg();
		
		
		//Step 5 Fill the details and select value from DD
		// organaization name
		CreateNewOrg cno= new CreateNewOrg(driver);
		cno.getOrgname().sendKeys(orgname);

		cno.getIndustry("Education");
		
		WebDriverUtility webulity = new WebDriverUtility();
		WebElement ratingDropdown=driver.findElement(By.name("rating"));
		webulity.selectelementfromDropdown(ratingDropdown, "Active");

		
		WebElement typeDropdown=driver.findElement(By.name("accounttype"));
		webulity.selectelementfromDropdown(typeDropdown, 3);

            cno.getSaveorgbtn().click();

		Thread.sleep(3000);

		//Click on org link
		hp.getOrglink().click();
       //sending data in text box
         oip.orgname().sendKeys(orgname);
         
         //clicking on dropdown and selecting organization name
         oip.selectdropdown("Organization Name");
         
         //click on submit button
         oip.submit();
         
		WebElement actualelement=driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+orgname+"']"));

		System.out.println(actualelement.isDisplayed());

		AssertJUnit.assertEquals(actualelement.isDisplayed(), true);

		//logout from app
		hp.logoutfromApp();


		//Close the browser
		driver.close();
		
		
		
		
		
	}
	
	
}
