package firsttestngproject;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;	

public class phantom {	
	public WebDriver driver;
		@BeforeSuite
		public void setUp(){
			File file = new File("/usr/local/share/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");				
            System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
            driver = new PhantomJSDriver();	
            driver.get("http://www.google.com"); 
		}
		
		@Test
		public void checkTitle(){
			 WebElement element = driver.findElement(By.name("q"));	
             element.sendKeys("Mytokri");					
             element.submit();         			
             System.out.println("Page title is: " + driver.getTitle());		
		}
		
		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}