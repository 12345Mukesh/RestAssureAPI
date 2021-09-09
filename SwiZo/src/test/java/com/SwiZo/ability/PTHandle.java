package com.SwiZo.ability;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.WebDriverCommonLib;

public class PTHandle
{
	@FindBy(xpath="//input[@name='property(Potential Name)']") private WebElement name;
	@FindBy(xpath="//img[@src='/crm/images/calc.gif']")private WebElement calci;
	@FindBy(xpath="//input[@value='5']") private WebElement fi;
	@FindBy(xpath="//input[@value='5']") private WebElement fiv;
	@FindBy(xpath="//input[@value='5']") private WebElement five;
	@FindBy(xpath="//img[@src='/crm/images/Accounts_small.gif']")private WebElement acc;
	@FindBy(xpath="//a[text()='QSpiders Bull Temple']") private WebElement qspi;
	@FindBy(xpath="//img[@src='/crm/images/cal.gif']") private WebElement cal;
	@FindBy(xpath="//a[text()='28']") private WebElement date;
	@FindBy(xpath="//select[@name='property(Stage)']")private WebElement stage;
	@FindBy(xpath="//select[@name='property(Type)']")private WebElement type;
	@FindBy(xpath="//input[@name='property(Campaign Source)']/following::img[@src='/crm/images/Campaigns_small.gif']")
	private WebElement campaign;
	@FindBy(xpath="//a[text()='television add']")private WebElement television;
	@FindBy(xpath="//select[@name='property(Lead Source)']")private WebElement leadname;
	@FindBy(xpath="//input[@value='Save']")private WebElement save;
	
	
	public PTHandle()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}

	
	 public void Details(String a)
	 {
		 name.sendKeys(a);
		 WebDriverCommonLib wlib= new WebDriverCommonLib();
		 calci.click();
		 wlib.getWindowHandleclick("Amount", fi);
		 wlib.getWindowHandleclick("Amount", fiv);
		 wlib.getWindowHandleclick("Amount", five);
		 acc.click();
		 wlib.getWindowHandleclick("Zoho CRM - Account Name Lookup", qspi);
		 cal.click();
		 wlib.getWindowHandleclick("Closing Date", date);
	 }
	 public void Details1(String b,String c,String d)
	 {
		 WebDriverCommonLib wlib= new WebDriverCommonLib();
		 wlib.selectoption(b, stage);
		 wlib.selectoption(c, type);
		 campaign.click();
		 wlib.getWindowHandleclick("Zoho CRM - Campaign Name Lookup",television );
		 wlib.selectoption(d, leadname);
		 save.click();
		 
	 }
	
	
}
