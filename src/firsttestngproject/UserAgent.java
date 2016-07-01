package firsttestngproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UserAgent {	
	public WebDriver driver;
	 private String baseUrl;
	 public String phantomloc = "/usr/local/share/phantomjs-2.1.1-linux-x86_64/bin/phantomjs";
	 
		@BeforeSuite
		public void setUp(){
			DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setJavascriptEnabled(true);
			 caps.setCapability("takesScreenshot", true);
			 caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,phantomloc);
			 driver = new PhantomJSDriver(caps);
			 baseUrl = "http://www.mytokri.com";
             driver.get(baseUrl);
		}
		
		@Test(priority = 1)
		public void checkMenuBar() throws FileNotFoundException, UnsupportedEncodingException{	
			
			driver.manage().window().maximize();
		    int error;
		    
		    
			//=============> Deals <=============
			String[] keyword_deal = {"today deals","popular deals"};
			error = 0;
			
				driver.findElement(By.xpath("//*[@id='mytokrinav']/li[6]/a")).click();   
			    Actions action = new Actions(driver);
			    action.moveToElement(driver.findElement(By.xpath("//*[@id='mytokrinav']/li[6]/a")), 97, 16).click().build().perform();
			    
			    try {
				    Thread.sleep(100);                 //100 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			    
			  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    try{
			    FileUtils.copyFile(scrFile, new File("/home/ashivliving/workspace/image.jpg"),true);
			    	System.out.println("Login Successful!");
			    }  catch(Exception e){
			    	System.out.println("Can't capture screenshot!");
			    }
			    	
			    /*
			    String str = "//*[@id='mytokrinav']/li[2]/ul/li["+i+"]/a";
			    driver.findElement(By.xpath(str)).click();
			    String str1 = driver.getTitle();
				String str2 = keyword_deal[i-2];
				if(!(str1.toLowerCase().contains(str2.toLowerCase())))
				  {		error++;
					  	System.out.println("Error occur at Menubar DEALS : "+ str2 + " page!");  
				  }
				  */
			

				}
		
		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}