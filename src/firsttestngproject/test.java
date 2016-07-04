package firsttestngproject;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class test {	
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
		public void checkMenuBar() throws FileNotFoundException, UnsupportedEncodingException{	
			try(FileWriter fw = new FileWriter("result.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
			
			driver.manage().window().maximize();
		    int error;
		    
		    
			//=============> Deals <=============
			String[] keyword_deal = {"today deals","popular deals"};
			error = 0;
			for(int i=2;i<=3;i++)
			{
				driver.findElement(By.xpath("//*[@id='mytokrinav']/li[2]/a")).click();   
			    Actions action = new Actions(driver);
			    action.moveToElement(driver.findElement(By.xpath("//*[@id='mytokrinav']/li[2]/a")), 97, 16).click().build().perform();
			    
			    String str = "//*[@id='mytokrinav']/li[2]/ul/li["+i+"]/a";
			    driver.findElement(By.xpath(str)).click();
			    String str1 = driver.getTitle();
				String str2 = keyword_deal[i-2];
				if(!(str1.toLowerCase().contains(str2.toLowerCase())))
				  {		error++;
					  	out.println("Error occur at Menubar DEALS : "+ str2 + " page!");  
				  }
			}
			if(error==0)
				out.println("No error in Menubar DEALS");
			else
				out.println("There are "+ error + " errors in Menubar DEALS!");	

			
		    
			//==============> Travel <===================
			String[] keyword_travel = {"international flight coupons","domestic flight coupons",
									   "cabs booking coupons","hotel booking coupons",
									   "bus booking coupons"};
			error = 0;
			for(int i=1;i<=5;i++)
			{
				driver.findElement(By.xpath("//*[@id='mytokrinav']/li[3]/a")).click();   
			    Actions action = new Actions(driver);
			    action.moveToElement(driver.findElement(By.xpath("//*[@id='mytokrinav']/li[3]/a")), 97, 16).click().build().perform();
			    
			    String str = "//*[@id='mytokrinav']/li[3]/ul/li["+i+"]/a";
			    driver.findElement(By.xpath(str)).click();
			    String str1 = driver.getTitle();
			  
				String str2 = keyword_travel[i-1];
				if(!(str1.toLowerCase().contains(str2.toLowerCase())))
				  {		error++;
					  	out.println("Error occur at Menubar TRAVEL : "+ str2 + " page!");  
				  }
			}
			if(error==0)
				out.println("No error in Menubar TRAVEL");
			else
				out.println("There are "+ error + " errors in Menubar TRAVEL!");
			
			//=============> Community <=============
			String[] keyword_community = {"hot deals online","coupons forum",
										  "freebies forum","help me find a deal",
										  "contests forum","chit chat forum","log in",
										  "site questions"};
			error = 0;
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
						  	out.println("Error occur at Menubar COMMUNITY : "+ str2 + " page!");  
					  }
				}
			}
			if(error==0)
				out.println("No error in Menubar COMMUNITY");
			else
				out.println("There are "+ error + " errors in Menubar COMMUNITY!");
			
			//==============> STORES <======================
			
			String[] keyword_menustore = {"amazon india offers","flipkart offers","snapdeal coupons",
										  "shopclues offers","ebay india coupons","lenskart coupons",
										  "limeroad coupons","abof coupons","jabong latest offers",
										  "koovs coupons","zivame coupons","myntra offers","askme grocery",
										  "dominos coupons","grofers offers","swiggy coupons",
										  "bigbasket coupons","mcdonalds coupons","ola cabs latest",
										  "yatra coupons","makemytrip coupons","uber coupons",
										  "redbus coupons","goibibo coupons","mobikwik offers",
										  "citrus pay coupons","payumoney coupons",
										  "oxigenwallet coupons","paytm coupons","freecharge offers"};
					error = 0;
					for(int i=1;i<=5;i++)
					{
						for(int j=2;j<=7;j++)
						{
						
							driver.findElement(By.xpath("//*[@id='mytokrinav']/li[5]/a")).click();   
							Actions action = new Actions(driver);
							action.moveToElement(driver.findElement(By.xpath("//*[@id='mytokrinav']/li[5]/a")), 97, 16).click().build().perform();
							
							String str = "//*[@id='mytokrinav']/li[5]/ul/li["+i+"]/ul/li["+j+"]/a";
							driver.findElement(By.xpath(str)).click();
							String str1 = driver.getTitle();
							int k = (i-1)*6+j-2;
							String str2 = keyword_menustore[k];
							if(!(str1.toLowerCase().contains(str2.toLowerCase())))
							{		error++;
								  	out.println("Error occur at Menubar STORES : "+ str2 + " page!");  
							}
							
						}
					}
					if(error==0)
					out.println("No error in Menubar STORES");
						else
					out.println("There are "+ error + " errors in Menubar STORES!");

	/*				//=============> Category <=============
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
						    
						    try {
							    Thread.sleep(100);                 //100 milliseconds is one second.
							} catch(InterruptedException ex) {
							    Thread.currentThread().interrupt();
							}
						    
						    String str = "//*[@id='mytokrinav']/li[6]/ul/li["+i+"]/ul/li["+j+"]/a";
						    driver.findElement(By.xpath(str)).click();
						    String str1 = driver.getTitle();
						    String str2 = keyword_menucategory[k++];
						    if(!(str1.toLowerCase().contains(str2.toLowerCase())))
							  {		error++;
								  	System.out.println("Error occur at Menubar CATEGORIES : "+ str2 + " page!");  
							  }
							  
							}
						}
					}
					if(error==0)
						out.println("No error in Menubar CATEGORIES");
					else
						out.println("There are "+ error + " errors in Menubar CATEGORIES!");			
				*/
				}
			catch (IOException e) {
				   
			}
		}
		
		
		
		
		@Test(priority = 2)
		public void checkMenuBar2() throws IOException{
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
		
		@Test(priority = 3)
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
			//String[] keyword_occasion = {"valentine day offers","holi offers","christmas offers",
			//							 "diwali offers","festivals deals"};
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