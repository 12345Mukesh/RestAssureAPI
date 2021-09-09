package com.SwiZo.IndicatorPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class Dashboards1 
{
	@FindBy(xpath="//input[@value='Add Component']") private WebElement Addcomponent;



	public Dashboards1()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}


	public void Addcomponent()
	{
		Addcomponent.click();
	}
	
	
	
	
	
	
	
	
	
}
