package com.SwiZo.importunity;

import org.testng.annotations.Test;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

public class PurchaseTest extends BaseTest
{
   
	@Test
	public  void main() throws Throwable 
	{
		BaseTest bt =new BaseTest();
		bt.openBrowser();
		
		Filelib flib= new Filelib();
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		
		LoginPage lp= new LoginPage();
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord") );
		
		
		
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "homeTitle"),"Home Page");
		
		HomePage hp= new HomePage();
		hp.Purchase();
		
wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
		
		Customviewpage cv= new Customviewpage();
		cv.selectOption("My Purchase Orders");
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
		
		PurchaseOrder p= new PurchaseOrder();
		p.view();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "createcustomTitle"), "Create Custom View");
		Purchase1 p1= new Purchase1();
		p1.customname(flib.ReadExcelData(EXCEL_PATH, "Account", 4, 0));
		p1.radio();
		p1.SearchFieldOption("Contact Name");
		p1.valueOption("contains");
		p1.searchtext(flib.ReadExcelData(EXCEL_PATH, "Account", 7, 1));
		p1.availOption("Due Date");
		
		p1.addbtn();
		p1.savebtn();
		
	//	wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
	//	driver.close();
		
	}
	
	
	
	
	
	
	
}
