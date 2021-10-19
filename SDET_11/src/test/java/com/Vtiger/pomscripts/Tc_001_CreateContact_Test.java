package com.Vtiger.pomscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.Generic.ExcelUtility;
import com.Vtiger.Generic.FileUtility;
import com.Vtiger.Generic.JavaUtility;
import com.Vtiger.ObjectRepo.ContactInfopage;
import com.Vtiger.ObjectRepo.CreateNewContactPage;
import com.Vtiger.ObjectRepo.HomePage;
import com.Vtiger.ObjectRepo.LoginPage;

public class Tc_001_CreateContact_Test 
{
	WebDriver driver;
	@Test
    public void TC001_CreateContact() throws Throwable
    {
	
	JavaUtility jv = new JavaUtility();	
	int randomnumber =jv.generateRandomNo();

	String orgname="QSPHYD"+randomnumber;
	System.out.println(orgname);



	FileUtility fileutility= new FileUtility();
	ExcelUtility Elib= new ExcelUtility();

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
	
	 HomePage hp =new HomePage(driver);
     hp.getContactslink().click();
		
     ContactInfopage cip= new ContactInfopage(driver);
     cip.createcont();  
     
     //selecting the dropdown
     String abc1 = Elib.readDatafromExcel(0, 4, "Sheet1");
		CreateNewContactPage cnp= new CreateNewContactPage(driver);
		cnp.firstdropdown(abc1);
		
       String abc2=Elib.readDatafromExcel(3, 0, "Sheet1");
         cnp.firstname().sendKeys(abc2);
		
		
		//Entering the last name
		String abc4 = Elib.readDatafromExcel(1, 1, "Sheet1");
		cnp.lastname().sendKeys(abc4);
    
		cnp.getSavecontbtn().click();
    
		//Again clicking on Contacts
		 hp.getContactslink().click();		
      //sending data in text boz
		 cip.contactname().sendKeys(abc4);
	
		String abc3 = Elib.readDatafromExcel(0, 6, "Sheet1");
	    cip.selectdropdown(abc3);

	    cip.submit();

		WebElement contactname = driver.findElement(By.xpath("//a[@title='Contacts' and text()='" + abc4+ "']"));

		if (contactname.isDisplayed()) {
			Assert.assertTrue(true);
		}

		//logout from app
				hp.logoutfromApp();

    
				driver.close();
    
    
    
    
    
    
    
    
    
    
    
    }
	
}
