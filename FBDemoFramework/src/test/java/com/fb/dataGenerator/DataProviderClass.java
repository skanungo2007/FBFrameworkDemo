package com.fb.dataGenerator;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	
	@DataProvider(name="fbData")
	public static Object[][] getData() {
		
		return new Object[][] {
			
			{"user1", "pass1"},
			{"user2", "pass2"},
			{"user3", "pass3"}
			
		};
		
	}

}
