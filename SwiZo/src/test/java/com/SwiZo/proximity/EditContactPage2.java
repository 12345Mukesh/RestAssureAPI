package com.SwiZo.proximity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class EditContactPage2 
{

	// @FindBy(xpath="//input[@name='property(Vendor Name)']") private WebElement Vendor;
			@FindBy(xpath="//img[@src='/crm/images/Vendors_small.gif']") private WebElement vend;
			@FindBy(xpath="//a[text()='Mukesh']") private WebElement muk;
		  @FindBy(xpath="//input[@name=\"property(Mobile)\"]") private WebElement Mobile;
		  @FindBy(xpath="//input[@name='property(Mailing Street)']") private WebElement street;
		  @FindBy(xpath="//input[@name='property(Mailing City)']") private WebElement city;
		  @FindBy(xpath="//input[@name='property(Mailing State)']") private WebElement state;
		  @FindBy(xpath="(//input[ @value=\'Save\'])[1]") private WebElement savebtn;
			

		  
			public EditContactPage2()
			{
				PageFactory.initElements(BaseTest.driver,this);
				
			}
			
//			public void EditVendorname()
//			{
//				//Vendor.sendKeys(name);
//				vend.click();
//				WebDriverCommonLib wlib= new WebDriverCommonLib();
//				wlib.getWindowHandleclick("Zoho CRM - Vendor Name Lookup", muk);
//				
//				
//			}
			
			public void EditContactDetails(String mob,String str,String ci,String st )
			{
				
				Mobile.clear();
				Mobile.sendKeys(mob);
				street.clear();
				street.sendKeys(str);
				city.clear();
				city.sendKeys(ci);
				state.clear();
				state.sendKeys(st);
				savebtn.click();
				
			}
			
			
			
			
			
		
		
	
	
	
}
