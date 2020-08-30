package com.fb.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class UtilityClass {
	
	
	public static String fetchProperty(String key) throws IOException {
		
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//Config//config.properties");
		
		Properties property = new Properties();
		
		property.load(fis);
		
		return property.get(key).toString();
		

		
	}
	
	
	public static void takeScreenshot(WebDriver driver) throws IOException {
		
		long timeStamp = System.currentTimeMillis();
		
		String s = String.valueOf(timeStamp);
		
		String imagePath = UtilityClass.fetchProperty("screenshotPath") + "\\" + s + ".jpeg";
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(imagePath);
		
		FileUtils.copyFile(srcFile, destFile);
		
		Reporter.log("<img src='"+imagePath+"' height='250' width='500' />");
		
		
	}
	

}
