package com.SwiZo.communique;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

public class CreateAccountTest extends BaseTest
{
  
	 @Test
		public  void main() throws Throwable 
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
			hp.clickAccountsTab();
		
			wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), " Displaying Custom View Details");
			
			Customviewpage cv= new Customviewpage();
			cv.checkbox();
			cv.createTask();
			
			wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "createtask"), "Create Task");
			
			CreateAccountPage c1= new CreateAccountPage();
			c1.createNewTask(flib.ReadExcelData(EXCEL_PATH, "Account", 0, 1),flib.ReadExcelData(EXCEL_PATH, "Account", 1, 1));
			c1.Calhandle();
			driver.close();

		}	
			
	
	
	
	
}
