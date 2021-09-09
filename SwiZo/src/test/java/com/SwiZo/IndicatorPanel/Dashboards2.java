package com.SwiZo.IndicatorPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.WebDriverCommonLib;

public class Dashboards2 
{

	@FindBy(xpath="//input[@value=\"table\"]")private WebElement table;
	@FindBy(xpath="//input[@class=\"textField\"]") private WebElement text;
	@FindBy(xpath="//select[@name='srcReport']") private WebElement src;
	@FindBy(xpath="//input[@value=\"Next\"]")private WebElement next;
	
	
	public Dashboards2()
	{
		
		PageFactory.initElements(BaseTest.driver, this);
		
	}
	
	public void table()
	{
		table.click();
	}
	
	
	public void component(String a)
	{
		text.sendKeys(a);
	}
	
	
	public void srcselectoption(String b)
	{
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		wlib.selectoption(b, src);
		
	}
	
	public void Nextbtn()
	{
		next.submit();
	}
	
	
	
	
	
	
	
}
