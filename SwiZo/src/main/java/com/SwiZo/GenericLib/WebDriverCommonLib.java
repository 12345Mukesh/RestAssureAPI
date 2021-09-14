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
		if(actual.equals(expected))
		{
			System.out.println(page + " is Displayed : Pass");
		}
		else
		{
			System.out.println(page + " is not Displayed: Fail ");
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
	
	public void getElementPageScreenshot(String screenshotpath)
	{
		TakesScreenshot ts=(TakesScreenshot)BaseTest.driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
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
	
	
	
	public void getFullPageScreenshot(String screenshotpath)
	{
		TakesScreenshot ts=(TakesScreenshot)BaseTest.driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
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
