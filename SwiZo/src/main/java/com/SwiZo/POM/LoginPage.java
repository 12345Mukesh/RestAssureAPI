package com.SwiZo.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;

public class LoginPage
{
	@FindBy(id="userName") private WebElement untb;
	@FindBy(id="passWord") private WebElement pwtd;
	@FindBy(xpath="//input[@title='Sign In']") private WebElement signbtn;
	
	public LoginPage()
	{
		 PageFactory.initElements(BaseTest.driver, this);
		 
	}
	
	public WebElement getuntb()
	{
		return untb;
		
	}
	
	
	public void setuntb(WebElement untb)
	{
		this.untb=untb;
	}
	
	public WebElement getpwtd()
	{
		return pwtd;
	}
	
	public void setpwtd(WebElement pwtd)
	{
		this.pwtd=pwtd;
	}
	
	public WebElement getsignbtn()
	{
		return signbtn;
		
	}
  
     public void setsignbtn(WebElement signbtn)
     {
    	 this.signbtn=signbtn;
     }

   

public void loginToApp(String un, String pwd) 
{
	 untb.sendKeys(un);
	   pwtd.sendKeys(pwd);
	   signbtn.click();
	
}

public WebElement getChkbox() {
	// TODO Auto-generated method stub
	return null;
}



	

	
}
