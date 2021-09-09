package com.SwiZo.ability;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class PotentialPage1 
{

	@FindBy(xpath="(//input[@name=\"edit2\"][1])") private WebElement ED;
	 
	   public PotentialPage1()
	   {
	   	PageFactory.initElements(BaseTest.driver, this);
	   }
	   
		public void Edi()
		{
			ED.click();
		}
	
	
	
	
}
