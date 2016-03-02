package com.selenium.WebDriver;

import static org.junit.Assert.fail;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SignIn { 	
	private WebDriver driver; 	
	private String baseUrl; 	
	private boolean acceptNextAlert = true; 	
	private StringBuffer verificationErrors = new StringBuffer(); 	
	//this is not a Fouzia's soucelabs account. Barrowing a friend's paid account.
	public static final String USERNAME = "roshim"; 	
	public static final String ACCESS_KEY ="503f3cdf-e414-4dd5-8a21-64a0cf84b757"; 	
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com/wd/hub";
	
	@Before 	
	public void setUp() throws Exception { 		 		
		DesiredCapabilities caps = DesiredCapabilities.chrome();  		
		caps.setCapability("platform", "Windows 7");  		
		caps.setCapability("version", "45.0"); 		
		caps.setCapability("name", "Test123"); 		 		
		driver = new RemoteWebDriver(new URL (URL), caps);	 		 		
		//URL 	"true url" below	 		 		
		driver.get("https://trello.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
		
		}
	@Test 	
	public void TrelloSignIn() throws Exception { 		
		int timeout = 2; 		 		
		TimeUnit.SECONDS.sleep(timeout);
		driver.findElement(By.cssSelector("a.quiet")).click();
		driver.findElement(By.id("user")).clear();
		driver.findElement(By.id("user")).sendKeys("fouziahaque.pr@gmail.com");
		driver.findElement(By.id("password")).clear();
		//manually enter password below
		driver.findElement(By.id("password")).sendKeys("***"); 
		TimeUnit.SECONDS.sleep(timeout);
		driver.findElement(By.id("login")).click();
		TimeUnit.SECONDS.sleep(timeout);
		
		}
	
	@After    	
	public void tearDown() throws Exception {    		    		
		//sauce.jobs.update_job(self.driver.session_id, passed=True)    		
		driver.quit();    		
		String verificationErrorString = verificationErrors.toString();    	
		if (!"".equals(verificationErrorString)) {    		
			fail(verificationErrorString);    		
			}    	}    	
	private boolean isElementPresent(By by) {    		
		try {    			
			driver.findElement(by);    			
			return true;  
			} 	catch (NoSuchElementException e) {    			
				return false; 
				}    	}    
	private boolean isAlertPresent() {    		
		try {    				
			driver.switchTo().alert();    				
			return true;
			} 	catch (NoAlertPresentException e) {    			
				return false;  
				}    	}    	
	private String closeAlertAndGetItsText() {   
		try {    			
			Alert alert = driver.switchTo().alert();    			
			String alertText = alert.getText();    			
			if (acceptNextAlert) {    				
				alert.accept();    			
				} else {    				
					alert.dismiss();    			
					}    			
			return alertText;    		
			}
		finally {    			
			acceptNextAlert = true;  
			}  
		} 	   
	}
