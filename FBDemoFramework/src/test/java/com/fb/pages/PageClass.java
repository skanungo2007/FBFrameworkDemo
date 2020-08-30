package com.fb.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.fb.utility.UtilityClass;

public class PageClass {
	
	
	WebDriver driver;
	
	
	
	@FindBy(id="email")
	@CacheLookup
	WebElement username;
	
	
	@FindBy(name="pass")
	@CacheLookup
	WebElement password;
	
	
	@FindBy(xpath="//*[@name='login']")
	WebElement login;
	
	
	
	public PageClass(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterCredentials(String uname, String pass) throws IOException {
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		
		Reporter.log("Filled in credentials", true);
		UtilityClass.takeScreenshot(driver);
	
	}
	
	public void logIn() throws InterruptedException, IOException {
		
		username.click();
		Thread.sleep(500);
		login.click();
		Reporter.log("Clicked on Login", true);
		Thread.sleep(4000);
		UtilityClass.takeScreenshot(driver);
	}

}
