package com.fb.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fb.utility.UtilityClass;

public class BaseClass {
	
	
	public WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() throws IOException {
		
		if(UtilityClass.fetchProperty("browserName").equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			driver = new ChromeDriver();
			
					
		} else if(UtilityClass.fetchProperty("browserName").equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			
			driver = new FirefoxDriver();
			
			
		} else {
			
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get(UtilityClass.fetchProperty("url"));
		
	}
	
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
	
		
		
	

}
