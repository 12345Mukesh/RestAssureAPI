package com.SwiZo.specimen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.WebDriverCommonLib;

public class CreateCasepage
{

	@FindBy (xpath="//select[@id=\"availList\"]") private WebElement availlist;
	@FindBy(xpath="//input[@type=\"button\" and @value=\"Add\"]") private WebElement add;
	  @FindBy(xpath="(//input[ @value=\'Save\'])") private WebElement savebtn;
	public CreateCasepage()
	{
		PageFactory.initElements(BaseTest.driver,this);
		
	}
	
	
	public void selectCaseOwnerOption(String text)
	{
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		wlib.selectoption(text, availlist);
	}

	public void add()
	{
		add.click();
	}
	
	public void save()
	{
		savebtn.click();
	}
	
	
	
	
	
	
	
	
	
}
