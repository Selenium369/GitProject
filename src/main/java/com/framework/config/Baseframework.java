package com.framework.config;

import static com.framework.utility.Keyword.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.framework.utility.Keyword;

public class Baseframework {
	
	@BeforeMethod
	public void setup() {
		openBrowser("Chrome");
		launchURL("https://www.javatpoint.com");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
