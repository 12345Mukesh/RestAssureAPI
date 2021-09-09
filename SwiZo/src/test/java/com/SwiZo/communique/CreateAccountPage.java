package com.SwiZo.communique;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwiZo.GenericLib.BaseTest;
import com.SwiZo.GenericLib.WebDriverCommonLib;

public class CreateAccountPage 
{
	@FindBy(xpath="//input[@name='property(subject)']") private WebElement subjectdata;
    @FindBy(xpath="//textarea[@name=\"property(comments)\" and @class=\"textField\"]") private WebElement desc;
    @FindBy(xpath="//img[@src='/crm/images/cal.gif']") private WebElement cal;
    @FindBy(xpath="//a[@class='calDay' and text()=25]") private WebElement calday;
    @FindBy(xpath="(//input[ @value=\'Save\'])") private WebElement savebtn;
    
    public CreateAccountPage()
    {
    	PageFactory.initElements(BaseTest.driver,this); 	 	
   	 }
	
	public void createNewTask(String sub, String des)
	{
		subjectdata.sendKeys(sub);
		desc.sendKeys(des);
		cal.click();
	}
    
	public void Calhandle()
	{
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		wlib.getWindowHandleclick("", calday);
		savebtn.click();
	}
	
	
	
	
	
	
}
