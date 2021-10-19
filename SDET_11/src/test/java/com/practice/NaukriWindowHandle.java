package com.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaukriWindowHandle {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver= new ChromeDriver();
//		driver.get("https://www.naukri.com");
//		String parenttitle=driver.getTitle();
//		
//		Set<String> allwhs=driver.getWindowHandles();
//		Iterator<String> iterator=allwhs.iterator();
//		System.out.println(allwhs);
//		 
//	    while(iterator.hasNext())
//	    {
//	    	String currentwindow=iterator.next();
//	    	String currenttitle=driver.switchTo().window(currentwindow).getTitle();
//	    	if(currenttitle.contains("Tech Mahindra1"))
//	    	{
//	    		driver.manage().window().maximize();
//	    		driver.close();
//	    		break;
//	    	}
//	    	
//	    	else
//	    		if(currenttitle.equals("Tech Mahindra"))
//	    		{
//	    			driver.manage().window().maximize();
//	    			driver.close();
//	    			break;
//	    		}
//	    	
//	    	
//	}	
driver.get("http:www.amazon.in");		
driver.manage().window().maximize();
driver.findElement(By.xpath("//select[@id='searchDropdownBox']")).click();
driver.findElement(By.xpath("//option[text()='Apps & Games']")).click();	    
	}

}
