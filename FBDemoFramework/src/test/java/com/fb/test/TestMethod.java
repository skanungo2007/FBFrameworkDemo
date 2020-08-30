package com.fb.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fb.base.BaseClass;
import com.fb.dataGenerator.DataProviderClass;
import com.fb.pages.PageClass;

public class TestMethod extends BaseClass {

	
	@Test(dataProvider="fbData", dataProviderClass=DataProviderClass.class)
	public void fbLogin(String uname, String pass) throws InterruptedException, IOException {
		
		PageClass obj = new PageClass(driver);
		
		obj.enterCredentials(uname, pass);
		
		obj.logIn();
		
		Thread.sleep(1000);
		
		
	}
	
}
