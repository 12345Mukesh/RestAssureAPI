package com.SwiZo.importunity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.WebDriverCommonLib;

public class Purchase1
{
	@FindBy(id="customviewname") private WebElement custom;
	  @FindBy(xpath="//input[@value='radiobutton']") private WebElement rd;
	  @FindBy(xpath="//select[@name=\"searchfield1\"]") private WebElement search;
	  @FindBy(xpath="//select[@name='textcondition1']") private WebElement tex;
	  @FindBy(id="searchtext1") private WebElement searchtext;
	  @FindBy(xpath="//select[@name=\"availList\"]") private WebElement avail;
	  @FindBy(xpath="//input[@value=\"Add\"]") private WebElement add;
	  @FindBy(xpath="//input[@value=\"Save\"]") private WebElement save;
	  
	  
	  public Purchase1()
	  {
		  PageFactory.initElements(BaseTest.driver, this);
	  }
	  
		public void customname(String value)
		{
			custom.sendKeys(value);
		}
		
		public void radio()
		{
			rd.click();
		}
		
		public void SearchFieldOption(String text)
		{
			WebDriverCommonLib wlib= new WebDriverCommonLib();
			wlib.selectoption(text, search);
		}	
			
		public void valueOption(String a)
		{
			WebDriverCommonLib wlib= new WebDriverCommonLib();
			wlib.selectoption(a, tex);	
		}
		
		public void searchtext(String b)
		{
			searchtext.sendKeys(b);
		}
		
		public void availOption(String c)
		{
			WebDriverCommonLib wlib= new WebDriverCommonLib();
			wlib.scrolldown(avail);
			wlib.selectoption(c, avail);
			
		}
		
		
		public void addbtn()
		{
			add.click();
		}
		
		public void savebtn()
		{
			save.click();
		}
			
	
	
	
	
}
