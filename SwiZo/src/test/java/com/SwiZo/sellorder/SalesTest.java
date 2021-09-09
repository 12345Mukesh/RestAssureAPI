package com.SwiZo.sellorder;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

public class SalesTest extends BaseTest
{
    public void main() throws Throwable
    {
	BaseTest bt= new BaseTest();
	bt.openBrowser();
	Filelib flib= new Filelib();
	WebDriverCommonLib wlib= new WebDriverCommonLib();
	LoginPage lp= new LoginPage();
	lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord") );
	
	wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "homeTitle"),"Home Page");
	
	HomePage hp= new HomePage();
	hp.salesorder();
	wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
	
	Customviewpage cv= new Customviewpage();
	cv.salesorder();
	wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "ReportTitle"), "Reports");
	
	SalesOrder s= new SalesOrder();
	s.salesorderOption("Sales Order Due Date");
	s.customOption("Previous FY");
	
	s.Date();
	
	s.Apply();
	wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "ReportTitle"), "Reports");
	
    SalesOrder2 s1= new SalesOrder2();
    s1.save(); 
    
    s1.filter("Zoho CRM - Save Report",s1.getreport() , flib.ReadExcelData(EXCEL_PATH, "Account", 8, 1), flib.ReadExcelData(EXCEL_PATH, "Account", 8, 2));
    
    driver.quit();






}


	
	
	
}
