

package com.SwiZo.reckoring;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

@Listeners(com.SwiZo.GenericLib.ReportListeners.class)
public class InvoicePage extends BaseTest
{

	@Test
	public  void invoice() throws Throwable 
	{
		Filelib flib= new Filelib();
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		String explt= flib.readPropertyData(PROP_PATH, "logintitle");
		//WebDriverCommonLib.verify(wlib.getPageTitle(),explt,"Loginpage");
//		BaseTest bt =new BaseTest();
//		bt.openBrowser();
		

		
		LoginPage lp= new LoginPage();
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord") );
		
		
		
	
		
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "homeTitle"),"Home Page");
		
		HomePage hp= new HomePage();
		hp.invoice();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
		
		
		Customviewpage cv= new Customviewpage();
		cv.selectCaseOption("My Invoices");
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	}
	
	
	
}
