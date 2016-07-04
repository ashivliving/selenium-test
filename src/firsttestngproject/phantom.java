package firsttestngproject;

import java.io.BufferedWriter;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class phantom {	
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
		public void checkTitle() throws FileNotFoundException, UnsupportedEncodingException{	
			PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
			Date date = new Date();
			writer.println(date.toString());
			writer.println(driver.getTitle());
			writer.println("Result ---->");
			writer.close();
			//System.out.println(driver.getTitle());
		}
		
		@Test(priority = 2)
		public void checkLogIn(){
			try(FileWriter fw = new FileWriter("result.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
			driver.manage().window().maximize();
			long iStart = System.currentTimeMillis(); 
			 driver.findElement(By.xpath("/html/body/header/div/div/div/div/a[6]")).click();
			 try {
				    Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			    driver.findElement(By.id("ctrl_pageLogin_login")).clear();
			    driver.findElement(By.id("ctrl_pageLogin_login")).sendKeys("ashivliving@gmail.com");
			    driver.findElement(By.id("ctrl_pageLogin_password")).clear();
			    driver.findElement(By.id("ctrl_pageLogin_password")).sendKeys("Ashiv2424$");
			    if (driver.findElement(By.id("ctrl_pageLogin_remember")).isSelected()) {
			      driver.findElement(By.id("ctrl_pageLogin_remember")).click();
			    };
			    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
			    driver.navigate().to(baseUrl);
			    //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    //try{
			    //FileUtils.copyFile(scrFile, new File("/home/ashivliving/workspace/image.jpg"),true);
			    	System.out.println("Login Successful!");
			    //}  catch(Exception e){
			    //	System.out.println("Can't capture screenshot!");
			    //}
			        out.println("Single Page Time:" + (System.currentTimeMillis() - iStart));
				
				}
				catch (IOException e) {
					   
				}
		}
		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}