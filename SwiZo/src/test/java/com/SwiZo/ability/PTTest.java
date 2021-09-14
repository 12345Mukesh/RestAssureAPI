package com.SwiZo.ability;

import org.testng.annotations.Test;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

public class PTTest extends BaseTest
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
		hp.potential();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
		
		Customviewpage cv= new Customviewpage();
		cv.NewPotential();
		  
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "createpotentialTitle"), "Create Potential");
	 
		PTHandle p1= new PTHandle();
		
		p1.Details(flib.ReadExcelData(EXCEL_PATH, "Account", 3, 0));
		p1.Details1("Qualification", "New Business", "Cold Call");
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
