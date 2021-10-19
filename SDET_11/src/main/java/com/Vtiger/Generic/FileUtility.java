package com.Vtiger.Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Mukesh
 *
 */
public class FileUtility 
{
	/**
	 * This Method will read the the data from prop file
	 * @param key
	 * @return
	 * @throws Throwable 
	 * @throws IOException
	 */
	public String readDatafromPropfile(String key) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("../SDET_11/src/test/resources/data/config1.properties");
		Properties prop = new Properties();
		prop.load(fis);

		return prop.getProperty(key);
	}

		
		
		
	}