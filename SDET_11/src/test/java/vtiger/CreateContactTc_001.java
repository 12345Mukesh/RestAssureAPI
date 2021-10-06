package vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateContactTc_001 
{

	 @Test
		public void CreatecontactTest() throws InterruptedException
		{
			
	    	WebDriver driver= new ChromeDriver();
	  	  driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	  	  
	  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	  driver.manage().window().maximize();
	  	  
	  	  
	  	   driver.findElement(By.name("user_name")).sendKeys("admin");
	  	   driver.findElement(By.name("user_password")).sendKeys("12345");
	  	   driver.findElement(By.id("submitButton")).click();
	  	   
	  	   
	  	   driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	  	   
	  	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	  	 
	  	WebElement First= driver.findElement(By.name("salutationtype"));
	  	   Select Firstdd= new Select(First);
	  	   Firstdd.selectByValue("Mr.");
	  	   
	  	   driver.findElement(By.name("lastname")).sendKeys("Mukesh");
	  	   driver.findElement(By.id("mobile")).sendKeys("6281963899");
	  	  
	  	 WebElement Leadsource= driver.findElement(By.name("leadsource"));
		   Select Lead= new Select(Leadsource);
		   Lead.selectByValue("Existing Customer");
		   
		   driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		   
		   Thread.sleep(4000);
	  	   
			 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			 
			 driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("Mukesh");
			 
			 WebElement Indropdown= driver.findElement(By.id("bas_searchfield"));
			 Select Indd= new Select(Indropdown);
			 Indd.selectByVisibleText("Last Name");
	  	   
			 driver.findElement(By.xpath("//input[@name='submit']")).click();
			 
			 
			 WebElement contactname= driver.findElement(By.xpath("//a[@title='Contacts' and text()='Mukesh']"));
				
				if(contactname.isDisplayed())
				{
					Assert.assertTrue(true);
				}
			
		}
		
		
		
		
	
	
	
	
	
}
