package com.SwiZo.crusade;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.WebDriverCommonLib;

public class Campaign2 
{
	 @FindBy(xpath="//input[@name='property(subject)']") private WebElement prop;
	    @FindBy(xpath="//textarea[@name='property(comments)']")private WebElement comments;
	    @FindBy(xpath="//img[@title='Calendar']")private WebElement calendar;
	    @FindBy(xpath="//a[@class='calCurrDay']") private WebElement calday;
//	    @FindBy(xpath="//input[@name='property(leContModName)']")private WebElement cont;
//	    @FindBy(xpath="//input[@name='property(notify)']")private WebElement notify;
	    @FindBy(xpath="//input[@value='Save']") private WebElement save;
	    
	    
	    public Campaign2()
	    {
	    	PageFactory.initElements(BaseTest.driver, this);
	    }
		
	    public void property(String text)
		{
			prop.sendKeys(text);
		}
		
		public void comments(String co)
		{
			comments.sendKeys(co);
		}
		
		public void calendar()
		{
			calendar.click();
			WebDriverCommonLib wlib =  new WebDriverCommonLib();
			wlib.getWindowHandleclick("", calday);
		   	
		}
		
//		public void contact(String ab)
//		{
//			cont.sendKeys(ab);
//		}
	//	
//		public void notif()
//		{
//			notify.click();
//		}
		
		public void save()
		{
			save.click();
		}
		
		
	
	
	
	
}
