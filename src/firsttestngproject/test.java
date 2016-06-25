package firsttestngproject;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;	

public class test {
	public WebDriver driver;
	 private String baseUrl;
	 
	 @BeforeSuite
		public void setUp(){
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setJavascriptEnabled(true);
		 caps.setCapability("takesScreenshot", true);
		 caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"/usr/local/share/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
		 driver = new PhantomJSDriver(caps);
		 baseUrl = "http://www.mytokri.com";
		}
	
	  @Test
	  public void f() {
		  driver.get(baseUrl);
		  System.out.println(driver.getTitle());
	  }
	  
	  @AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
}
