package com.SwiZo.GenericLib;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SwiZo.POM.LoginPage;

@Listeners(com.SwiZo.GenericLib.ReportListeners.class)
public class CreateChartCustom extends BaseTest
{
	@Test
	public void runReports()
	{
		LoginPage lp=new LoginPage();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		ReportListeners.extent.createTest("runReports").assignAuthor("Mukesh");
		wlib.elementStatus(lp.getuntb(), 1, "Username TextBox");
		wlib.elementStatus(lp.getpwtd(), 2, "Password textbox");
		Assert.fail();
		//wlib.elementStatus(lp.getChkbox(), 3, "Checkbox");
	}

	
	
	
}
