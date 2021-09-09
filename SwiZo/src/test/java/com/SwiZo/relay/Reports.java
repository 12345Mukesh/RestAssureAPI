package com.SwiZo.relay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.WebDriverCommonLib;

public class Reports 
{

	@FindBy(xpath="//select[@id=\"primarymodule\"]") private WebElement primary;
	  @FindBy(xpath="//select[@id=\"Accountsrelatedmodule\"]") private WebElement Arm;
	  @FindBy(xpath="//input[@value=\"Continue\"]") private WebElement cont;
		
	  
	  
	  public Reports()
	  {
		  PageFactory.initElements(BaseTest.driver, this);
	  }
	  
	  
	  
	  
	  public void selectCaseOwnerOption(String text) 
		{
			WebDriverCommonLib wlib=new WebDriverCommonLib();
			wlib.selectoption(text, primary);
			
		}
		
	  public void SelectCaseOwnerOption(String text1) 
	 	{
	 		WebDriverCommonLib wlib=new WebDriverCommonLib();
	 		wlib.selectoption(text1, Arm);
	 		
	 	}
		
		public void Continue()
		{
			cont.click();
		}
		
	
	
	
	
	
	
}
