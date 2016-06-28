package firsttestngproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
		public void checkmenubar2() throws IOException{
			try(FileWriter fw = new FileWriter("result.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
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
				  	out.println("Error occur at "+ str2 + " page!");  
			  }
			}
			if(error==0)
					out.println("Menubar 2 working correctly");
			else
					out.println("There are "+ error + " errors!");
				}
			catch (IOException e) {
				   
			}
		}
		
		@Test(priority = 2)
		public void checkfooter()
		{	try(FileWriter fw = new FileWriter("result.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			driver.manage().window().maximize();
			String[] keyword_about = {"about us","privacy policy","sitemap",
					"advertise with us","blog",
					"careers with us","contact us"};
			String[] keyword_category = {"cameras coupons","babycare","fashion offers",
										 "food & drink","books & stationery Coupons",
										 "mobile recharge offers","home & kitchen","mobile phone"
										 ,"tablets coupons","computers coupons","find all coupon"};
			String[] keyword_store = {"amazon india","flipkart offers","snapdeal coupons",
									  "myntra offers","jabong latest offers","zivame coupons",
									  "foodpanda coupons","dominos coupons","firstcry coupons",
									  "ebay india coupons","all coupon stores"};
			String[] keyword_occasion = {"valentine day offers","holi offers","christmas offers",
										 "diwali offers","festivals deals"};
			//========> About us <===================== 
			
			int error = 0;
			for(int i=2;i<=8;i++)
			{	if(i==6)
				 continue;
				String str = "//*[@id='footertop']/div/div/section[1]/ul/li[" + i +"]/a";
				driver.findElement(By.xpath(str)).click();
				String str1 = driver.getTitle();
				String str2 = keyword_about[i-2];
				if(!(str1.toLowerCase().contains(str2.toLowerCase())))
				  {		error++;
					  	out.println("Error occur at ABOUT section : "+ str2 + " page!");  
				  }
			}
				if(error==0)
					out.println("No error in Footer ABOUT");
				else
					out.println("There are "+ error + " errors in footer ABOUT!");	

			//============> Category <=============
				error = 0;
				for(int i=1;i<=11;i++)
				{	
					String str = "//*[@id='footertop']/div/div/section[2]/ul/li["+i+"]/a";
					driver.findElement(By.xpath(str)).click();
					String str1 = driver.getTitle();
					String str2 = keyword_category[i-1];
					if(!(str1.toLowerCase().contains(str2.toLowerCase())))
					  {		error++;
						  	out.println("Error occur at CATEGORY section : "+ str2 + " page!");  
					  }
				}
					if(error==0)
						out.println("No error in Footer CATEGORY");
					else
						out.println("There are "+ error + " errors in footer CATEGORY!");
					
			//==========> Stores <==========
					error = 0;
					for(int i=1;i<=11;i++)
					{	
						String str = "//*[@id='footertop']/div/div/section[3]/ul/li["+i+"]/a";
						driver.findElement(By.xpath(str)).click();
						String str1 = driver.getTitle();
						String str2 = keyword_store[i-1];
						if(!(str1.toLowerCase().contains(str2.toLowerCase())))
						  {		error++;
							  	out.println("Error occur at STORES section : "+ str2 + " page!");  
						  }
						
					}
						if(error==0)
							out.println("No error in Footer STORES");
						else
							out.println("There are "+ error + " errors in footer STORES!");
			//==========> Occasion <=============	
						/*
						error = 0;
						for(int i=1;i<=5;i++)
						{	
							String str = "//*[@id='footertop']/div/div/section[4]/ul/li["+i+"]/a";
							driver.findElement(By.xpath(str)).click();
							String str1 = driver.getTitle();
							String str2 = keyword_occasion[i-1];
							if(!(str1.toLowerCase().contains(str2.toLowerCase())))
							  {		error++;
								  	out.println("Error occur at Occasion section : "+ str2 + " page!");  
							  }
							
						}
							if(error==0)
								out.println("No error in Footer Occasion");
							else
								out.println("There are "+ error + " errors in footer Occasion!");
								*/
			}
		catch (IOException e) {
			   
		}
			}
		
		
		@AfterSuite
		 public void tearDown(){
			 driver.quit();
		 } 
		
		
}