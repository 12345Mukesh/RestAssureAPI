package vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateObjTc_001
{
	@Test
	   public void TC001_CreateObjwithDropdown() throws InterruptedException 
	   {
		  WebDriver driver= new ChromeDriver();
		  driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		   driver.findElement(By.name("user_name")).sendKeys("admin");
		   driver.findElement(By.name("user_password")).sendKeys("12345");
		   driver.findElement(By.id("submitButton")).click();
		   
		   driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		   
		   driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		   
		   driver.findElement(By.name("accountname")).sendKeys("QSPHYD3");
		   
		  WebElement industrydropdown= driver.findElement(By.name("industry"));
		  Select industrydd= new Select(industrydropdown);
		  industrydd.selectByVisibleText("Education");
		  
		  WebElement ratingdropdown=driver.findElement(By.name("rating"));
		  Select ratingdd= new Select(ratingdropdown);
		  ratingdd.selectByValue("Active");
		  
		  WebElement typedropdown=driver.findElement(By.name("accounttype"));
		  Select typedd= new Select(typedropdown);
		  typedd.selectByIndex(3);
		  
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		  Thread.sleep(4000);
		  
		  driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		  
		  driver.findElement(By.name("search_text")).sendKeys("QSPHYD3");
		  
		  WebElement searchfldDropdown=driver.findElement(By.name("search_field"));
		  
		  Select searchdd= new Select(searchfldDropdown);
		  searchdd.selectByVisibleText("Organization Name");
		  
		  driver.findElement(By.name("submit")).click();
		  
		  
		WebElement organisationname= driver.findElement(By.xpath("//a[@title='Organizations' and text()='QSPHYD4']"));
		
		if(organisationname.isDisplayed())
		{
			Assert.assertTrue(true);
		}
		  
	   }
	
	
	
	
	
	
	
	
}
