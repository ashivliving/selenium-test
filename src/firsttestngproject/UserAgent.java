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
		    try(FileWriter fw = new FileWriter("result.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
		    
		    String[] keyword_menucategory = {"mobile phone best deals","mobile accessories coupons",
					 "cameras coupons","camera accessories coupons",
					 "tablets coupons","tablets accessories coupons",
					 "fashion offers","bags & accessories","clothing coupons",
					 "footwear coupons","watches coupons","home & kitchen",
					 "air conditioner coupons","iron coupons","microwave oven",
					 "refrigerator coupons","washing machines coupons",
					 "babycare best deals","baby clothes and kids",
					 "baby diapers deals","toys coupons","computers coupons",
					 "hard drive deals","memory cards best deals",
					 "monitors & desktops coupons","pen drive offers",
					 "printers coupons","speakers coupons","online recharge offers",
					 "mobile recharge offers","cabs booking offers",
					 "beauty and personal care coupons","perfumes & deos coupons",
					 "sexual wellness coupons","home furnishing coupons",
					 "bedsheets best deals","travel coupons","bus ticket coupons",
					 "holiday coupons","hotel coupons"
					 };
				error = 0;
				int k =0;
				for(int i=1;i<=4;i++)
				 {
					for(int j=1;j<=11;j++)
						{
							if(((i==2)&&(j>10))||((i==3)&&(j>10))||((i==4)&&(j>9)))
								break;
							else{
								driver.findElement(By.xpath("//*[@id='mytokrinav']/li[6]/a")).click();       	
								Actions action = new Actions(driver);
								action.moveToElement(driver.findElement(By.xpath("//*[@id='mytokrinav']/li[6]/a")), 97, 16).click().build().perform();
				
				
								String str = "//*[@id='mytokrinav']/li[6]/ul/li["+i+"]/ul/li["+j+"]/a";
								driver.findElement(By.xpath(str)).click();
								String str1 = driver.getTitle();
								
				
								String str2 = keyword_menucategory[k++];
								if(!(str1.toLowerCase().contains(str2.toLowerCase())))
								{		error++;
									out.println("Error occur at Menubar CATEGORIES : "+ str2 + " page!");  
								}
				
				
							}
							System.out.println("hey");
						}
				 }
					if(error==0)
						out.println("No error in Menubar CATEGORIES");
					else
						out.println("There are "+ error + " errors in Menubar CATEGORIES!");
					}
				catch (IOException e) {
				   
				}

			}
		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}