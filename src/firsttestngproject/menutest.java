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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class menutest {	
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
		public void checkmenu1() throws FileNotFoundException, UnsupportedEncodingException
		{	
			try(FileWriter fw = new FileWriter("result.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{	driver.manage().window().maximize();
					String[] keyword_deal = {"dndn","dmdm"};
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				    try{
				    FileUtils.copyFile(scrFile, new File("/home/ashivliving/workspace/image.jpg"),true);
				    	System.out.println("Login Successful!");
				    }  catch(Exception e){
				    	System.out.println("Can't capture screenshot!");
				    }
				    String str = "//*[@id='mytokrinav']/li[2]/ul/li[3]";
					driver.findElement(By.xpath(str)).click();
					System.out.println(driver.getTitle());
				/*
					//==========> Deals <==============
				int error = 0;
				for(int i=2;i<=3;i++)
				{	
					String str = "//*[@id='mytokrinav']/li[2]/ul/li["+ i +"]";
					driver.findElement(By.xpath(str)).click();
					String str1 = driver.getTitle();
					String str2 = keyword_deal[i-2];
					if(!(str1.toLowerCase().contains(str2.toLowerCase())))
					  {		error++;
						  	System.out.println("Error occur at Menubar Deal section : "+ str2 + " page!");  
					  }
				}
					if(error==0)
						System.out.println("No error in Menubar Deal");
					else
						System.out.println("There are "+ error + " errors in Menubar Deal!");		
				
				*/
				} catch (IOException e) {
				   
				}
				
				
		}
		
		
		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}