package com.Vtiger.pomscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
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

import com.Vtiger.Generic.ExcelUtility;
import com.Vtiger.Generic.FileUtility;
import com.Vtiger.ObjectRepo.ContactInfopage;
import com.Vtiger.ObjectRepo.CreateNewContactPage;
import com.Vtiger.ObjectRepo.HomePage;
import com.Vtiger.ObjectRepo.LoginPage;

public class Tc_002_CreateContact_org_Test {
	WebDriver driver;

	@Test
	public void CreateContactTestWindowHandle() throws Throwable 
	{
		FileUtility flib= new FileUtility();
		ExcelUtility Elib= new ExcelUtility();
		//open the browser
		String browsername = flib.readDatafromPropfile("browser");
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
			System.out.println("chrome is opened");
		} else if (browsername.equals("ff")) {

		} else {
			System.out.println("please enter proper browser name");
		}
		
		//Enter the url
		driver.get(flib.readDatafromPropfile("url"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);           
		driver.manage().window().maximize();                                       
		
       //Giving username and password
		LoginPage lp= new LoginPage(driver);
		lp.logintoApp();

        HomePage hp =new HomePage(driver);
        hp.getContactslink().click();
		
        ContactInfopage cip= new ContactInfopage(driver);
        cip.createcont();  
      
		//clicking on dropdown
        
		String abc1 = Elib.readDatafromExcel(0, 4, "Sheet1");
		CreateNewContactPage cnp= new CreateNewContactPage(driver);
		cnp.firstdropdown(abc1);
		
		String abc4 = Elib.readDatafromExcel(1, 1, "Sheet1");
		String abc5 = Elib.readDatafromExcel(1, 2, "Sheet1");
		cnp.lastname().sendKeys(abc4);
		cnp.mobile().sendKeys(abc5);

		//Window Handling
		WebElement abc = driver.findElement(By.xpath("(//img[@title='Select'])[1]"));
		abc.click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();

		String parentWindow = window.next();
		String childWindow = window.next();

		driver.switchTo().window(childWindow);

		driver.findElement(By.id("search_txt")).sendKeys(Elib.readDatafromExcel(1, 0, "Sheet1"));

		driver.findElement(By.name("search")).click();

		driver.findElement(By.xpath("//a[@id='1' and text()='" + Elib.readDatafromExcel(1, 0, "Sheet1") + "']"))
		.click();

		driver.switchTo().window(parentWindow);

		String abc2 = Elib.readDatafromExcel(0, 5, "Sheet1");
		cnp.seconddropdown(abc2);

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


				//Close the browser
				driver.close();
	}

}
