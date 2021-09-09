package com.SwiZo.sellorder;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class SalesOrder2 
{

	@FindBy(xpath="//input[@value='Save As']") private WebElement saveas;
	@FindBy(xpath="//input[@name='reportName']") private WebElement report;
	@FindBy(xpath="//input[@name='reportDesc']")private WebElement desc;
	@FindBy(xpath="//input[@value='Save']") private WebElement sa;
	
	public SalesOrder2()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public WebElement getreport()
	{
		return report;
	}
	

	public void save() 
	{
		
		saveas.click();
		
		
	}

	public void filter(String targetbrowsertitle, WebElement element, String a, String b)
	{
//		WebDriverCommonLib wlib= new WebDriverCommonLib();
//		wlib.getWindowHandleclick("Zoho CRM - Save Report", report);
//		report.sendKeys(a);
//		desc.sendKeys(b);
//		sa.click();
		Set<String> allwindows=BaseTest.driver.getWindowHandles();	
		  
		  for(String currentwindow:allwindows)
		  {
			  String title=BaseTest.driver.switchTo().window(currentwindow).getTitle();
			  if(title.equalsIgnoreCase(targetbrowsertitle))
			  {
				  element.click();
				  report.sendKeys(a);
					desc.sendKeys(b);
					sa.click();
			  }
	}
	
	}
	
	
	
	
	
}
