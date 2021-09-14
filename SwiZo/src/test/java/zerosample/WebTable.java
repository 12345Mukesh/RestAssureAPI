package zerosample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\L e n o v o\\git\\repository\\SwiZo\\src\\main\\resources\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("file:///E:/QSpiders/Selenium/Website%20projects/webtable.html");
		
		
   WebElement frame1=driver.findElement(By.tagName("tr"));
		driver.switchTo().frame(frame1);
		
		
		
		
	}

}
