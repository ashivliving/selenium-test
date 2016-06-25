package firsttestngproject;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class phantom {	
	public WebDriver driver;
	 private String baseUrl;
	 
		@BeforeSuite
		public void setUp(){
			File file = new File("/usr/local/share/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");				
            System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
            driver = new PhantomJSDriver();	
            //driver.get("http://www.google.com"); 
            baseUrl = "http://www.mytokri.com";
            driver.get("http://www.mytokri.com");
		}
		
		@Test(priority = 1)
		public void checkTitle(){
			
			System.out.println(driver.getTitle());
		}
		
		@Test(priority = 2)
		public void checkLogIn(){
			long iStart = System.currentTimeMillis(); 
			if(driver.findElements(By.id("popcl")).size() != 0){
				driver.findElement(By.id("popcl")).click();
			}
			driver.manage().window().maximize();
			 driver.findElement(By.linkText("Login")).click();
			    driver.findElement(By.id("ctrl_pageLogin_login")).clear();
			    driver.findElement(By.id("ctrl_pageLogin_login")).sendKeys("ashivliving@gmail.com");
			    driver.findElement(By.id("ctrl_pageLogin_password")).clear();
			    driver.findElement(By.id("ctrl_pageLogin_password")).sendKeys("Ashiv2424$");
			    if (driver.findElement(By.id("ctrl_pageLogin_remember")).isSelected()) {
			      driver.findElement(By.id("ctrl_pageLogin_remember")).click();
			    };
			    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
			    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    try{
			    FileUtils.copyFile(scrFile, new File("/home/ashivliving/workspace/image.jpg"),true);
			    System.out.println("Screenshot Captured");
			    }  catch(Exception e){
			    	System.out.println("Can't capture screenshot!");
			    }
			    System.out.println("Single Page Time:" + (System.currentTimeMillis() - iStart));
			    
		}
		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}