package com.SwiZo.sellorder;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.WebDriverCommonLib;

public class SalesOrder
{

	@FindBy(xpath="//select[@name='stdDateFilterField']")private WebElement stdDate;
	@FindBy(xpath="//select[@name='stdDateFilter']")private WebElement stdFilter;
 	@FindBy(xpath="//a[@img[@src='images/cal_day.gif']")private WebElement startdate;
 	@FindBy(xpath="//a[@class='calCurrDay'and text()='05']") private WebElement stdt;
    @FindBy(xpath="//a[@img[@src='images/cal_day.gif']")private WebElement enddate;
    @FindBy(xpath="//a[@class='calCurrDay'and text()='30']") private WebElement endt;
	@FindBy(xpath="//input[@value='Apply Filter']")private WebElement ApFilter;
	
	
	
	//id='startdateimg']/descendant::
	//id='enddateimg']/descendant::
	
	public SalesOrder()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}

   public void salesorderOption(String text)
   {
	   WebDriverCommonLib wlib= new WebDriverCommonLib();
	   wlib.selectoption(text, stdDate);
   }
   
   public void customOption(String a)
   {
	   WebDriverCommonLib wlib= new WebDriverCommonLib();
	   wlib.selectoption(a, stdFilter);
   }
  
   public void Date()
   {
	   WebDriverCommonLib wlib= new WebDriverCommonLib();
	   wlib.getWindowHandleclick("", stdt);
	   wlib.getWindowHandleclick("", endt);
   }
   public void Apply()
   {
	   ApFilter. click();
   }

  




	
	
}
