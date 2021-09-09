package com.SwiZo.relay;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

public class Reports1 extends BaseTest
{
    @Test
	public  void main(String[] args) throws Throwable 
	{
		BaseTest bt =new BaseTest();
		bt.openBrowser();
		
		Filelib flib= new Filelib();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp= new LoginPage();
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord") );
		
		
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "homeTitle"),"Home Page");
		
		HomePage hp= new HomePage();
		hp.Report();
		
wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), " Displaying Custom View Details");
		
		Customviewpage cv= new Customviewpage();
		cv.CreateNewReport();
  wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "ReportTitle"), "Reports");		
		Reports r1= new Reports();
		r1.selectCaseOwnerOption("Accounts");
		r1.SelectCaseOwnerOption("Contacts");
		r1.Continue();
		
		
		driver.close();

	}
	
	
	
}
