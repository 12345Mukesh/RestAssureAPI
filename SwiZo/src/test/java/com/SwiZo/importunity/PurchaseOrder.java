package com.SwiZo.importunity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class PurchaseOrder 
{
@FindBy(xpath="//a[text()=\"Create View\"]") private WebElement view;
	
	
	public PurchaseOrder()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	
	public void view()
	{
		view.click();
	}
	
	  

	
	
	
	
	
	
}
