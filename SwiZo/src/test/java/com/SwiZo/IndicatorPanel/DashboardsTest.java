package com.SwiZo.IndicatorPanel;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

@Listeners(com.SwiZo.GenericLib.ReportListeners.class)

public class DashboardsTest extends BaseTest
{
	

	@Test
	public  void verifydashboard() throws Throwable 
	{
		
		
		Filelib flib= new Filelib();
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		LoginPage lp= new LoginPage();
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord") );
		
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "homeTitle"),"Home Page");
		
		HomePage hp= new HomePage();
		hp.Dash();
		
wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "showingDashboardTitle"), "Showing Dashboards");
		
		Customviewpage cv= new Customviewpage();
		cv.Campaignselectoption("Campaign Dashboards");
		
		Dashboards1 i1= new Dashboards1();
		i1.Addcomponent();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "selectDashboardTitle"), "Select Dashboard Component:Step 1");
		Dashboards2 i2= new Dashboards2();
		i2.table();
		i2.component(flib.ReadExcelData(EXCEL_PATH, "Account", 2, 0));
		i2.srcselectoption("Contact Mailing List");
		i2.Nextbtn();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "selectDashboardTitle"), "Select Dashboard Component:Step 1");
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
}
