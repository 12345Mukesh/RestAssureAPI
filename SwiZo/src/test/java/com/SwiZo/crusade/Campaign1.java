package com.SwiZo.crusade;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class Campaign1 
{

	@FindBy(xpath="//input[@value='New Task']")private WebElement Task;
	
	
	
	public Campaign1()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	
	public void Task()
	{
		Task.click();
	}
	
	  
	
	
	
}
