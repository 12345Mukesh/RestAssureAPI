package com.SwiZo.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class HomePage 
{
	@FindBy(xpath="//a[text()='Leads']") private WebElement leadsTab;
	@FindBy(xpath="//a[text()=\"Accounts\"]") private WebElement accountsTab;
	@FindBy(xpath="//a[text()='Contacts']") private WebElement cont;
	@FindBy(xpath="//img[@id=\"scrollright\"]") private WebElement ctl;
	@FindBy(xpath="//a[text()=\"Cases\"]") private WebElement cas;
	@FindBy(xpath="//a[text()=\"Invoices\"]") private WebElement invoic;
	@FindBy(xpath="//a[text()='Potentials']") private WebElement potent;
    @FindBy(xpath="//a[text()='Reports']")private WebElement Report;
    @FindBy(xpath="//a[text()=\"Purchase Orders\"]") private WebElement purchase;
    @FindBy(xpath="//a[text()='Campaigns']") private WebElement camp;
    @FindBy(xpath="//a[text()='Dashboards']") private WebElement dash;	
    @FindBy(xpath="//a[text()='Sales Orders']") private WebElement sales;
	
	
	public HomePage()
	{
		PageFactory.initElements(BaseTest.driver,this);
		
	}
	
	
	public void clickLeadsTab()
	{
		leadsTab.click();
	}

	
 public void  clickAccountsTab()
 {
	accountsTab.click();
	 
 }
 public void clickContactTab()
	{
		cont.click();
	}
 
 
 
	 public void  cas()
	{
	      for(int i=1;i<=20;i++)
		 {
			 ctl.click();
		 }
		 cas.click();
	}


	public void invoice()
	{
		 for(int i=1;i<=90;i++)
		 {
			 ctl.click();
		 }
		
		invoic.click();	
	}
 
 

public void potential() 
{
	 potent.click();
	
	
}
	


public void Report()
{
	Report.click();
}

public void Purchase()
{
	for(int i=1;i<=90;i++)
	 {
		 ctl.click();
	 }

  purchase.click();

}


public void campaign() 
{
	
	camp.click();
}



public void Dash()
{
	dash.click();
}



public void salesorder()
{
	 for(int i=1;i<=75;i++)
	 {
		 ctl.click();
	 }
	
	sales.click();	
}


	
	
	
	
	
	
	
}
