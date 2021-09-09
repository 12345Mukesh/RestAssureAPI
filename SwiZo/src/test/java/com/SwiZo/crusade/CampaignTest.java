package com.SwiZo.crusade;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

public class CampaignTest extends BaseTest
{
	@Test
	public void run() throws Throwable 
	{
	   
		BaseTest bt =new BaseTest();
		bt.openBrowser();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Filelib flib= new Filelib();
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		
		LoginPage lp= new LoginPage();
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord") );
		
		
		
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "homeTitle"),"Home Page");
		
		HomePage hp= new HomePage();
		hp.campaign();
		
wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
		
      Customviewpage c= new Customviewpage();
      c.checkbox1();
		c.createTask();
		
		
//		Campaign1 c1= new Campaign1();
//		c1.Task();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "createTask")," Create Task");
		Campaign2 c2= new Campaign2();
		c2.property(flib.ReadExcelData(EXCEL_PATH, "Account", 1, 2));
		c2.comments(flib.ReadExcelData(EXCEL_PATH, "Account", 1, 3));
        c2.calendar();
        
        //c2.notif();
       c2.save();
		
		driver.close();
		
		
		

	}
	
	
	
	
	
	
	
	
}
