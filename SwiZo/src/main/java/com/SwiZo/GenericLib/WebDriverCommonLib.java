package com.SwiZo.GenericLib;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.io.Files;

public class WebDriverCommonLib
{

	public String getPageTitle()
	{
		String pagetitle=BaseTest.driver.getTitle();
		return pagetitle;
		
	}

	public void verify(String actual, String expected, String page)
	{
//		if(actual.equals(expected))
//		{
//			System.out.println(page + " is Displayed : Pass");
//		}
//		else
//		{
//			System.out.println(page + " is not Displayed: Fail ");
//		}
		if(actual.equals(expected))
		{
		Assert.assertTrue(true);
		ExtentTest test = ReportListeners.extent.createTest("verify");
		test.pass(MarkupHelper.createLabel(" is Displayed, PASS", ExtentColor.GREEN));
		}
		else
		{
			Assert.assertTrue(false);
			ReportListeners.test=ReportListeners.extent.createTest("verify");
			ReportListeners.test.pass(MarkupHelper.createLabel(" is not  Displayed, FAIL", ExtentColor.RED));
		}
		
	}
	
	
	
	public void selectoption(WebElement element, int index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(index);
		
	}
	
	public void selectoption(WebElement element, String value)
	{
		Select sel= new Select(element);
		sel.selectByValue(value);
		
	}
	
	public void selectoption( String text,WebElement element)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
		
	}
	
	
	public void mouseHover(WebElement element)
	{
		Actions ac= new Actions(BaseTest.driver);
		ac.moveToElement(element).perform();
	}
	
	public void rightclick(WebElement element)
	{
		Actions ac= new Actions(BaseTest.driver);
		ac.contextClick(element).perform();
	}
	public void dragAnddrop(WebElement source, WebElement target)
	{
		Actions ac= new Actions(BaseTest.driver);
		ac.dragAndDrop(source, target).perform();
		
	}
	
	
	public void switchToFrame(int index)
	{
		BaseTest.driver.switchTo().frame(index);
	}
	
	public void switchToFrame(String value)
	{
		BaseTest.driver.switchTo().frame(value); 
	}
	
	public void switchToFrame(WebElement element)
	{
		BaseTest.driver.switchTo().frame(element);
	}
	
	public void switchToAlertpopup()
	{
		Alert al = BaseTest.driver.switchTo().alert();
		al.accept();
	}
	
	public void getElementPageScreenshot(WebElement element,String screenshotpath)
	{
		
		File src=element.getScreenshotAs(OutputType.FILE);
		File dest=new File(screenshotpath);
		
		try 
		{
			Files.copy(src, dest);
		}
		catch (IOException e)
		{
			
			e.printStackTrace();
		}	
			
	}
	
	
	
	public String getFullPageScreenshot(String screenshotName)
	{
		TakesScreenshot ts=(TakesScreenshot)BaseTest.driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String dest="C:\\Users\\L e n o v o\\git\\repository\\SwiZo\\screenshots\\"+screenshotName+".png";
		File destination=new File(dest);
		
		try 
		{
			Files.copy(src, destination);
		}
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
		return dest;	
			
	}
			
	
	
	public void elementStatus(WebElement element, int checkType, String elementName)
	{
		switch(checkType)
		{
		case 1:
			try {
				element.isDisplayed();
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is Displayed", ExtentColor.PURPLE));
			}
			catch (Exception e) {
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is not Displayed", ExtentColor.ORANGE));
			}
			
			break;
		case 2:
			try {
				element.isEnabled();
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is Enabled", ExtentColor.PURPLE));
			}
			catch (Exception e) {
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is not Enabled", ExtentColor.ORANGE));
			}
			break;
		case 3: 
			try {
				element.isSelected();
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is Selected", ExtentColor.PURPLE));
			}
			catch (Exception e) {
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is not Selected", ExtentColor.ORANGE));
			}
			break;
		}
	}

	
	public void getWindowHandleclick(String targetbrowsertitle, WebElement element)
	{
	  String mainwindow = BaseTest.driver.getWindowHandle();	
	  Set<String> allwindows=BaseTest.driver.getWindowHandles();	
	  
	  for(String currentwindow:allwindows)
	  {
		  String title=BaseTest.driver.switchTo().window(currentwindow).getTitle();
		  if(title.equalsIgnoreCase(targetbrowsertitle))
		  {
			  element.click();
			  
		  }
	  }
	    BaseTest.driver.switchTo().window(mainwindow);
	
	}
	
	
	
	public void getWindowHandleclose(WebElement element,String targetbrowsertitle)
	{
	  Set<String> allwindows=BaseTest.driver.getWindowHandles();	
		
	  for(String currentwindow:allwindows)
	  {
		  String title=BaseTest.driver.switchTo().window(currentwindow).getTitle();
		  if(title.equalsIgnoreCase(targetbrowsertitle))
		  {
			  BaseTest.driver.close();
		  }  
	  }
	}
	
	public void scrolldown(WebElement element)
	{
		Point location = element.getLocation();
		JavascriptExecutor jse= (JavascriptExecutor)BaseTest.driver;
		jse.executeScript("window.scrollBy"+location);
	}
	
	
	public void waitforPageTitle(String Title)
	{
		WebDriverWait wait= new WebDriverWait(BaseTest.driver,30);
		wait.until(ExpectedConditions.titleContains(Title));
	}
	
	public void verifySuccessMsg(WebElement element, String eleName)
	{
		if(element.isDisplayed())
		{
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log(eleName+"is not Displayed,FAIL", true);
			Assert.assertTrue(false);
		}
	
	
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
