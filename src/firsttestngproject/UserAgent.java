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
	 public String phantomloc = "/usr/local/bin/phantomjs";
	 
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
		public void checkMenuBarCat() throws FileNotFoundException, UnsupportedEncodingException{	
			
			driver.manage().window().maximize();
		    int error;
		    String[] keyword_community = {"hot deals online","coupons forum",
					  "freebies forum","help me find a deal",
					  "contests forum","chit chat forum","log in",
					  "site questions"};
				error = 0;
				Actions actions = new Actions(driver);
				WebElement mainMenu = driver.findElement(By.xpath("//*[@id='mytokrinav']/li[3]/a"));
				actions.moveToElement(mainMenu);   
				//Actions action = new Actions(driver);
			
				 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    try{
			    FileUtils.copyFile(scrFile, new File("/var/lib/jenkins/workspace/image.jpg"),true);
			    	System.out.println("Login Successful!");
			    }  catch(Exception e){
			    	System.out.println("Can't capture screenshot!");
			    }
				/*
				for(int i=1;i<=2;i++)
				{
				for(int j=1;j<=4;j++)
				{
				
				driver.findElement(By.xpath("//*[@id='mytokrinav']/li[4]/a")).click();   
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//*[@id='mytokrinav']/li[4]/a")), 97, 16).click().build().perform();
				
				String str = "//*[@id='mytokrinav']/li[4]/ul/li["+i+"]/ul/li["+j+"]/a";
				driver.findElement(By.xpath(str)).click();
				String str1 = driver.getTitle();
				int k = (i-1)*4+j-1;
				String str2 = keyword_community[k];
				if(!(str1.toLowerCase().contains(str2.toLowerCase())))
				{		error++;
				System.out.println("Error occur at Menubar COMMUNITY : "+ str2 + " page!");  
				}
				}
				}
				if(error==0)
				System.out.println("No error in Menubar COMMUNITY");
				else
				System.out.println("There are "+ error + " errors in Menubar COMMUNITY!");
				*/

			}
		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}