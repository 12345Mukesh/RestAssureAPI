package com.SwiZo.escort;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class CreateLeadPage
{
	 @FindBy(xpath="//input[@name=\'property(Company)\']") private WebElement companytb;
		@FindBy(xpath="//input[@name=\'property(Last Name)\']") private WebElement lastnametb; 
		@FindBy(xpath="(//input[ @value=\'Save\'])[1]") private WebElement savebtn;
		
		
		public CreateLeadPage()
		{
			PageFactory.initElements(BaseTest.driver,this);
		
		}
		
		  public void createLeadwithMandatoryDetails(String companyname, String ln)
		  {
			  companytb.sendKeys(companyname);
			  lastnametb.sendKeys(ln);
			  savebtn.click();
			  
		  }
	
	
	
	
	
}
