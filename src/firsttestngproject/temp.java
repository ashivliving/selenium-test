package firsttestngproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class temp {	
	public WebDriver driver;
	 private String baseUrl;
	 public String phantomloc = "/usr/local/bin/phantomjs";
		@BeforeSuite
		public void setUp(){
			DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setJavascriptEnabled(true);
			 caps.setCapability("takesScreenshot", true);
			 caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,phantomloc);
			 driver = new PhantomJSDriver(caps);
			 baseUrl = "http://www.bechkitab.com/";
			 //driver.get(baseUrl);
			 driver.manage().window().maximize();
		}
		
		@Test(priority = 1)
		public void testing(){
			for(int i=0;i<100;i++){
				System.out.println(i);
				driver.navigate().to("http://www.google.com");
				
				driver.navigate().to(baseUrl);
				try {
				    Thread.sleep(5000);                
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			}
		}
		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}
