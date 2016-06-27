package firsttestngproject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
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
			 driver.get(baseUrl);
		}
		
		@Test(priority = 1)
		public void checkmenubar2() throws IOException{
			driver.manage().window().maximize();	
			
			String[] keywords = {"buy 1 get 1","mobile phone","snapdeal coupons",
					             "computers coupons","Amazon india offers","fashion offer",
					             "flipkart offers","freecharge offers","mobile recharge offers",
					             "free samples online","shopclues offers"};
			int error = 0;
			for(int i=1;i<=11;i++)
			{ String str="//*[@id='menubar']/div/div[3]/div[2]/div/a["+ i + "]";
			  driver.findElement(By.xpath(str)).click();
			  String str1 = driver.getTitle();
			  String str2 = keywords[i-1];
			  if(!(str1.toLowerCase().contains(str2.toLowerCase())))
			  {		error++;
				  	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				    try{
				    FileUtils.copyFile(scrFile, new File("/home/ashivliving/workspace/FirstTestNGProject/src/firsttestngproject/image/image" + error +".jpg"),true);
				    System.out.println("Error occur at "+ str2 + " page!");
				    }  catch(Exception e){
				    	System.out.println("Can't capture screenshot!");
				    }
			  }
			}
			if(error==0)
				System.out.println("Menubar 2 working correctly");
			else
				System.out.println("There are "+ error + " errors!");
			
		}
		
		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}