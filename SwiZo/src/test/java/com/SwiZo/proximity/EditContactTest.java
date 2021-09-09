package com.SwiZo.proximity;

import org.testng.annotations.Test;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

public class EditContactTest extends BaseTest
{

	@Test
	public void main() throws Throwable 
	{
	
		BaseTest bt =new BaseTest();
		bt.openBrowser();
		
		Filelib flib= new Filelib();
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		
		LoginPage lp= new LoginPage();
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord") );
		
		
		
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "homeTitle"),"Home Page");
		
		HomePage hp= new HomePage();
		hp.clickContactTab();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
		
		Customviewpage cv= new Customviewpage();
		cv.name();
		
		EditContactPage1 e=new EditContactPage1();
		e.Edit();
		
		
		EditContactPage2 ed=new EditContactPage2();
		//ed.EditVendorname();
		ed.EditContactDetails( flib.ReadExcelData(EXCEL_PATH, "Account", 2, 4),flib.ReadExcelData(EXCEL_PATH, "Account", 2, 1),
				flib.ReadExcelData(EXCEL_PATH, "Account", 2, 2),flib.ReadExcelData(EXCEL_PATH, "Account", 2, 3));
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "contactDetailsTitle"),"Contact Details" );
		
		driver.close();
		
		
		
		
		
		
		
		

	}

	
  
	
	
	
	
	
	
}
