package com.SwiZo.ability;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class PotentialPage2 
{

	@FindBy(xpath="//textarea[@name=\"property(Description)\"]")private WebElement prop;
	@FindBy(xpath="(//input[@value=\"Save\"][1])") private WebElement sav;
	
   public PotentialPage2()
   {
   	PageFactory.initElements(BaseTest.driver, this);
   }
	
   public void Property(String text)
   {
	   prop.clear();
	   prop.sendKeys(text);
	   sav.click();
	   
   }
	
	
	
	
	
}
