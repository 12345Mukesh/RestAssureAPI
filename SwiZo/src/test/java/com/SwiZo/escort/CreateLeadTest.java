package com.SwiZo.escort;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

@Listeners(com.SwiZo.GenericLib.ReportListeners.class)
public class CreateLeadTest extends BaseTest
{

	@Test
	public void main() throws Throwable
	{
		
		
		Filelib flib= new Filelib();
		
		LoginPage lp= new LoginPage();
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord") );
		
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "homeTitle"),"Home Page");
		
		HomePage hp= new HomePage();
		hp.clickLeadsTab();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Create Lead Page");
		
		Customviewpage cv= new Customviewpage();
		cv.clickNewLeadBtn();
		
		CreateLeadPage cl= new CreateLeadPage();
		cl.createLeadwithMandatoryDetails(flib.ReadExcelData(EXCEL_PATH, "Account", 0, 1), flib.ReadExcelData(EXCEL_PATH, "Account", 1, 1));
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "leadDetailsTitle"), "Lead Details page");
		driver.close();
		
		
	}
	
	
	
	
	
}
