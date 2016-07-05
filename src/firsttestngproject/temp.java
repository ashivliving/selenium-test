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
			 baseUrl = "http://www.mytokri.com";
			 driver.get(baseUrl);
			 driver.manage().window().maximize();
		}
		
		@Test(priority = 2)
        public void sidebar_popular() throws FileNotFoundException, UnsupportedEncodingException
        {
                try(FileWriter fw = new FileWriter("result.txt", true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter out = new PrintWriter(bw))
                        {

                int error = 0;
                String sidexpath,str1,str2;
                for(int i=1;i<=1;i++)
                {
                        try{
                                sidexpath = "//*[@id='sidebar']/div[8]/table/tbody/tr["+i+"]/td[1]/a";
                                str1 = driver.findElement(By.xpath(sidexpath)).getText();
                        }
                        catch(NoSuchElementException e){
                                sidexpath = "//*[@id='sidebar']/div[9]/table/tbody/tr["+i+"]/td[1]/a";
                                str1 = driver.findElement(By.xpath(sidexpath)).getText();
                        }
                        if(str1.length()<=0)
                        {
                                error++;
                                out.println("Error in Sidebar Popular Deals at "+ str1 +" Link.");
                        }


                        driver.navigate().to(baseUrl);
                }
                if(error==0)
                        out.println("No error in Sidebar Popular Deals");
                else
                        out.println("There are "+ error + " errors in Sidebar Popular Deals!");
                        }catch(IOException e){

                        }
        }

		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}