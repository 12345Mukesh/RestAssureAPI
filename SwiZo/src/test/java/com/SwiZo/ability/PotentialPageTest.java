package com.SwiZo.ability;

import org.testng.annotations.Test;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.Filelib;
import com.SwiZo.GenericLib.WebDriverCommonLib;
import com.SwiZo.POM.Customviewpage;
import com.SwiZo.POM.HomePage;
import com.SwiZo.POM.LoginPage;

public class PotentialPageTest extends BaseTest
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
		cv.search(flib.ReadExcelData(EXCEL_PATH, "Account", 4, 0));
		cv.Go();
		
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "customViewTitle") , "Displaying Custom View Details");
		PotentialPage p= new PotentialPage();
		p.name();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "potentialTitle"), "Potential Details");
		PotentialPage1 p1= new PotentialPage1();
		p1.Edi();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "EditPotential"), "Edit Potential");
		PotentialPage2 p2= new PotentialPage2();
		p2.Property(flib.ReadExcelData(EXCEL_PATH, "Account", 4, 1));
		driver.close();
		
		
		
	}	
	
	
	
	
}
