package firsttestngproject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Dummy {
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
		 baseUrl = "http://www.mytokri.com/";
         driver.get(baseUrl);
         driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void testing(){
				String str = "";
				String str404 = "MyTokri - 404 Error Page";
		List<WebElement> list=driver.findElements(By.xpath("//*[@href]"));
		System.out.println(list.size());
		/*
		List<String> all = new ArrayList<String>();
		for(WebElement e : list){
			if((e.getTagName().toLowerCase().contains("a"))&&(e.getAttribute("href").toLowerCase().contains(baseUrl)))
			 all.add(e.getAttribute("href"));
		}
		System.out.println(all.size());
		for(String x : all ){
			driver.navigate().to(x);
     	   str = driver.getTitle();
     	   if(str.toLowerCase().contains(str404.toLowerCase()))
     		   System.out.println("404 Error in link - "+x);
     	   else
     		   System.out.println("correct");
		}
		
		/*
		System.out.println("Total Link on - "+baseUrl+" are "+list.size());
		for(WebElement e : list){
	           String link = e.getAttribute("href");
	           if((e.getTagName().toLowerCase().contains("a"))&&(link.toLowerCase().contains(baseUrl)))
	            {
	        	   System.out.println(e.getTagName() + "=" + link);
	        	   /*driver.navigate().to(link);
	        	   str = driver.getTitle();
	        	   if(str.toLowerCase().contains(str404.toLowerCase()))
	        		   System.out.println("404 Error in link - "+link);
	        	   else
	        		   System.out.println("correct");
	        		  
	            }
	       }*/
	       
	}
	
	
	@AfterSuite
	 public void tearDown(){
		 driver.quit();
	 } 
  
}
