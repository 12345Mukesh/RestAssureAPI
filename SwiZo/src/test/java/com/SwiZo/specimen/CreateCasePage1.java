package com.SwiZo.specimen;

import org.testng.annotations.Test;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

public class CreateCasePage1 extends BaseTest
{

	 @Test
		public  void main() throws Throwable 
			  {
				  BaseTest bt =new BaseTest();
					bt.openBrowser();
					
					Filelib flib= new Filelib();
					WebDriverCommonLib wlib= new WebDriverCommonLib();
					
					LoginPage lp= new LoginPage();
					lp.loginToApp(flib.readPropertyData(PROP_PATH,"userName"), flib.readPropertyData(PROP_PATH, "passWord") );
					
					
					
					wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "homeTitle"),"Home Page");
					
					HomePage hp= new HomePage();
					hp.cas();
					
					wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
					
					Customviewpage cv= new Customviewpage();
					//cv.
					cv.edit();
					
					wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customTitle"),"Edit Custom View" );
					CreateCasepage c1= new CreateCasepage();
					c1.selectCaseOwnerOption("Case Owner");
					c1.add();
					c1.save();
					driver.close();
					
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
			  }
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
}
