package com.SwiZo.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.WebDriverCommonLib;

public class Customviewpage
{
	//clicking on New LEad button
	
		@FindBy(xpath="//input[@value=\"New Lead\"]") private WebElement newleadsbtn;
	//	
//		//clicking on checkbox and clicking on Create Task button in
		@FindBy(xpath="//input[@type='checkbox' and @value='304']") private WebElement cb;
		@FindBy(xpath="//input[@class=\"button\" and @value=\"Create Task\"]") private WebElement createtaskbtn;
	   
		//campaign	
		@FindBy(xpath="//input[@type=\"checkbox\" and @value=\"1\"]") private WebElement cb1 ;

		@FindBy(xpath="//a[@class=\"link\" and text()='shruthi anu']") private WebElement d;
		
		//click on Edit in Case page
		@FindBy(xpath="(//a[text()=\"Edit\"][1])") private WebElement ed;
		
		//clicking on the drop down
		@FindBy(xpath="//select[@name=\"cvid\"]")  private WebElement drop;
	    
		//clicking on Search button in potential
		@FindBy(xpath="//input[@name=\"searchString\"]") private WebElement search;
		//clicking on Go button in potential
		@FindBy(xpath="//input[@name=\"Go\"]") private WebElement Go;
		
		@FindBy(xpath="//input[@value=\"Create New Report\"]") private WebElement CreateNew;
		
		//clicking on view drop down in purchase list
		@FindBy(xpath="//select[@name=\"cvid\"]")  private WebElement purchase;
		
		//clicking on television in campaign page
		@FindBy(xpath="//a[text()='television add']") private WebElement television;
		
		//clicking on Dropdown of Dashboard
		@FindBy(xpath="//select[@name='dashboards']") private WebElement dash;
		
		
		//clicking on sales order by status link
		@FindBy(xpath="//a[text()='Sales Orders by Status']")private WebElement sales;
		
		//clicking on new potential
		@FindBy(xpath="//input[@value='New Potential']") private WebElement pt;
		
		public Customviewpage()
		{
			PageFactory.initElements(BaseTest.driver, this);
			
		}
		

		public void clickNewLeadBtn()
		{
			newleadsbtn.click();
		}
		
		
		public void checkbox()
		{
			cb.click();
		}
		
		public void checkbox1()
		{
			cb1.click();
		}
		
		public void createTask() 
		{
			
			createtaskbtn.click();
		     	
		}
		
		public void name() 
		{
			d.click();		
		}
		
		
		public void edit()
		{
			ed.click();
		}
		
		


		public void selectCaseOption(String text) 
		{
			WebDriverCommonLib wlib=new WebDriverCommonLib();
			wlib.selectoption(text, drop);
			
		}
		
		public void search(String text)
		{
			search.sendKeys(text);
		}
		
		public void Go()
		{
			Go.click();
		}
		
		
		public void CreateNewReport()
		{
			CreateNew.click();
		}
		
		
		public void selectOption(String p) 
		{
			WebDriverCommonLib wlib=new WebDriverCommonLib();
			wlib.selectoption(p, purchase);
			
		}
		
		public void television()
		{
			television.click();
		}
		
		//Dashboard dropdown
		public void Campaignselectoption(String e)
		{
			WebDriverCommonLib wlib=new WebDriverCommonLib();
		    wlib.selectoption(e, dash); 
		}
		
		
		


		public void salesorder() 
		{
			sales.click();
			
		}
		
		
		public void NewPotential()
		{
			pt.click();
		}
		
		
		
		
		
	
	
	
	
	
	
	
}
