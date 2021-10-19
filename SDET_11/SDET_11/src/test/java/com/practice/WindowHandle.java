package com.practice;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		
		WebElement element=driver.findElement(By.id("newWindowBtn"));
		Point loc=element.getLocation();
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy"+ loc);
		
	//1.first window handle
		//getting the title
		String parenttitle= driver.getTitle();
		String parent=driver.getWindowHandle();
//	//	clicking on button
//		WebElement awh=driver.findElement(By.id("newWindowBtn"));
//	    awh.click();
//		//storing all window handles in one string
//		Set<String> allwhs=driver.getWindowHandles();
//		System.out.println(allwhs);
//	//	switching handle starts here
//		for(String wh:allwhs)
//		{
//		//	
//		String title=driver.switchTo().window(wh).getTitle();
//		System.out.println(title);
//		if(title.equalsIgnoreCase("Basic Controls - H Y R Tutorials"))
//		{
//			driver.manage().window().maximize();
//			driver.close();
//		}
//		
//		}
//		
//		
//		
//		
//	//2.second window handle
//		
//		driver.switchTo().window(parent);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		//clicking on button which is shifting to next window
//		WebElement window=driver.findElement(By.id("newTabBtn"));
//		window.click();
//		//switching to string
//		Set<String> allwindow=driver.getWindowHandles();
//		System.out.println(allwindow);
//		
//		for(String whs:allwindow)
//		{
//			String title=driver.switchTo().window(whs).getTitle();
//			System.out.println(title);
//			if(title.equalsIgnoreCase("AlertsDemo - H Y R Tutorials"))
//			{
				
//				driver.close();
//				
//			}
//			
//		}
//		
		//3.Third window handle
		driver.switchTo().window(parent);
		WebElement window1=driver.findElement(By.id("newWindowsBtn"));
		window1.click();
		Set<String> allwindowhandles=driver.getWindowHandles();
		System.out.println(allwindowhandles);
		for(String windows:allwindowhandles)
		{
			String tit=driver.switchTo().window(windows).getTitle();
			if(tit.equals("XPath Practice - H Y R Tutorials"))
			{     
				driver.manage().window().maximize();
				driver.close();
     		}
			driver.switchTo().window(parent);
			
			String tit1=driver.switchTo().window(windows).getTitle();
			if(tit1.equals("Basic Controls - H Y R Tutorisals"))
			{
				driver.manage().window().maximize();
				driver.close();	
			}
			
		}
		
		
		//4.Fourth window handle
		driver.switchTo().window(parent);
		WebElement window2= driver.findElement(By.id("newTabsBtn"));
		window2.click();
		Set<String> allwindowhandles1=driver.getWindowHandles();
		for(String w:allwindowhandles1)
		{
			String value=driver.switchTo().window(w).getTitle();
			if(value.equals("AlertsDemo - H Y R Tutorials"))
			{
				driver.close();
			}
			driver.switchTo().window(parent);
			
			if(value.equals("Basic Controls - H Y R Tutorials"))
			{
				driver.close();
			}
			
		}
		
		
		
		
		
		
		
		
		
		

	}

}
