package com.SwiZo.proximity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class EditContactPage1
{

@FindBy (xpath="//input[@name=\"edit2\" and @value=\"Edit\"]") WebElement edi;
	  
	
	public EditContactPage1()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	
	

	public void Edit()
	{
		edi.click();	
	}



	
	
}
