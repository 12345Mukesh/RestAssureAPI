//package com.SwiZo.escort;
//
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//import com.SwiZo.GenericLib.BaseTest;
//import com.SwiZo.GenericLib.Filelib;
//import com.SwiZo.GenericLib.WebDriverCommonLib;
//import com.SwiZo.POM.Customviewpage;
//import com.SwiZo.POM.HomePage;
//import com.SwiZo.POM.LoginPage;
//
//@Listeners(com.SwiZo.GenericLib.ReportListeners.class)
//public class DeleteLead extends BaseTest
//{
//   
//	@Test
//	public void deleteleads() throws Throwable 
//	{
//		Filelib flib= new Filelib();
//		LoginPage lp= new LoginPage();
//		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"),flib.readPropertyData(PROP_PATH, "passWord"));
//		WebDriverCommonLib wlib= new WebDriverCommonLib();
//		HomePage hp= new HomePage();
//		wlib.elementStatus(hp.clickLeadsTab(), 1, "Leads Button");
//		hp.clickLeadsTab();
//		Customviewpage cv= new Customviewpage();
//		wlib.elementStatus(cv.clickcheckbox(), 3, "checkbox");
//		cv.clickcheckbox();
//		wlib.elementStatus(cv.deletebutton(), 1, "Delete button");
//		cv.deletebutton();
//		
//		
//	}
//	
//	
//	
//	
//	
//	
//}
