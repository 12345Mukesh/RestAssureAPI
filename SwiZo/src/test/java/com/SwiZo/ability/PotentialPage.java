package com.SwiZo.ability;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class PotentialPage
{

	@FindBy(xpath="(//a[text()=\"rashmi\"][1])") private WebElement link;
    
    
    public PotentialPage()
    {
    	PageFactory.initElements(BaseTest.driver, this);
    }
    
	public void name()
	{
		link.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
