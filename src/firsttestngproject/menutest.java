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

public class menutest {	
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
		
		@Test(priority = 1)
		public void search() throws FileNotFoundException, UnsupportedEncodingException
		{	
			
			try(FileWriter fw = new FileWriter("result.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
				String str1,str2,data;
				boolean available=true;
				int correct=0,i=0,j=0;
				double avg=0,sum=0;
				String keyword;
				String[] keydata = {"Amazon","book","selfie","myntra","paytm","laptop",
									"mobile","pendrive","free","shoe","bag","recharge",
									"food","buffet","pizza","ticket","room"};
				
			while(j<keydata.length)
	    	{ keyword = keydata[j++];
		    while(available)
		    {	driver.findElement(By.id("livesearch")).clear();
			    driver.findElement(By.id("livesearch")).sendKeys(keyword);
			    driver.findElement(By.id("livesearchsubmit")).click();
		    	int k = (i/4)+1;
		    	int l = (i%4)+1;
		    	
		    	str2 = "//*[@id='mytokridata']/div/div[1]/div[1]/div["+k+"]/div["+l+"]/div";
		    	try{
		    		str1 = driver.findElement(By.xpath(str2)).getText();
		    	}
		    	catch(NoSuchElementException e){
		    		available = false;
		    		continue;
		    	}
		    	
		    	
		    	String search_xpath1 = "//*[@id='mytokridata']/div/div[1]/div[1]/div["+k+"]/div["+l+"]/div/div[2]/a";
		    	String search_xpath2 = "//*[@id='mytokridata']/div/div[1]/div[1]/div["+k+"]/div["+l+"]/div/div[3]/a";
		    
		    	if(!(str1.toLowerCase().contains(keyword.toLowerCase())))
				{
		    		try{
		    			driver.findElement(By.xpath(search_xpath1)).click();
		    		}
		    		catch(NoSuchElementException e){
		    			driver.findElement(By.xpath(search_xpath2)).click();
		    		}
		    			try{
		    				 data = driver.findElement(By.xpath("//*[@id='messageList']")).getText();
		    			}
		    			catch(NoSuchElementException e){
		    	             data = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]")).getText();
		    	             data = data + driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[3]")).getText();
		    	        }
		    			if(data.toLowerCase().contains(keyword.toLowerCase()))
		    		     correct++;
		    			
		    			driver.navigate().back();
		    			
				}
		    	else{
		    		correct++;
		    	}
		    	i++;
		    		
		    }
		    //System.out.println("Correct "+keyword+" - "+correct+"/"+i+"");
		    sum = sum+ (double)(correct*100/i);
		    avg = sum/keydata.length;
		    
		}
	    	out.println("Search Efficiency is - "+avg+"%.");
			}catch(IOException e){
				
			}
		}
		
		/*
		@Test(priority = 1)
		public void sidebar_popular() throws FileNotFoundException, UnsupportedEncodingException
		{	
			
			int error = 0; 
			for(int i=1;i<=5;i++)
			{	
				String sidexpath = "//*[@id='sidebar']/div[5]/table/tbody/tr["+i+"]/td[1]/a";
				String str1 = driver.findElement(By.xpath(sidexpath)).getText();
				driver.findElement(By.xpath(sidexpath)).click();
				String str2 = driver.getTitle();
				
				if(!(str2.toLowerCase().contains(str1.toLowerCase())))
				{
					error++;
					System.out.println("Error in Sidebar Popular Deals at "+ str1 +" Link.");
				}
				
				driver.navigate().to(baseUrl);
			}
			if(error==0)
				System.out.println("No error in Sidebar Popular Deals");
			else
				System.out.println("There are "+ error + " errors in Sidebar Popular Deals!");	
		}
		
		@Test(priority = 2)
		public void coupan_page() throws FileNotFoundException, UnsupportedEncodingException
		{
			String xpath1 = "//*[@id='mytokridata']/div/div[1]/div[1]/div[2]/div[1]/div/div[2]/a";
			String xpath2 = "//*[@id='mytokridata']/div/div[1]/div[1]/div[2]/div[1]/div/div[3]/a";
			
			boolean isPresent = driver.findElements(By.xpath(xpath1)).size() > 0;
			if(!isPresent)
			{
				driver.findElement(By.xpath(xpath2)).click();
			}
			else{
				driver.findElement(By.xpath(xpath1)).click();
			}
			System.out.println(driver.getTitle());
		}
		*/
		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}