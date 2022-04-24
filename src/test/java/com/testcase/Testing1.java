package com.testcase;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.framework.config.Baseframework;
import com.framework.utility.Keyword;
import com.framework.utility.constant.Locator;
import com.framework.utility.constant.LocatorType;

import io.github.bonigarcia.wdm.WebDriverManager;
import static com.framework.utility.Keyword.*; //If we import the Keyword classas static then you can directly access its functions

//This is Fourth framework discussed on 8th Jan 2022
//Here we created a class Locator.java under utility.constant package and we maintained the repository in it.
//That is we mentioned the xpath of all the required elements in it.
//Its good than OR.properties mentioned in FrameworkProject4.
//However in advance all these will be covered in POM that is page object model, later
//Here we have used logger Log4j by Apache. In Log4j we used configuration file Log4j.properties  

//Also we have added surefire plugin to run the testNG.xml using maven.
//We can also use the command prompt to run the TCs using maven


public class Testing1 extends Baseframework {
	
	private static final Logger LOG = Logger.getLogger(Testing1.class);
	
		@Test 
		public void verifySeleniumFeatureLinkDisplaysOnThePage() {
		waitFor(2000);
		click(Locator.Sel_Tut);
		LOG.info("Clicked on Selenium Tutorial");
		waitFor(2000);
		click(Locator.Sel_Feat);
		LOG.info("Clicked on Selenium Featured");
		waitFor(2000);
		enterText(Locator.Search_box,"Selenium interview");
		LOG.info("Entered search text");
		//enterText(LocatorType.xpath,"//td[@id=\"gs_tti50\"]/child::input[@name=\"search\" and @class=\"gsc-input\"]","selenium interview");
		waitFor(2000);
		click(Locator.Search_Btn);
		LOG.info("Clicked on Search Button");
		waitFor(1000);
		click(Locator.Sort_btn);
		LOG.info("Clicked on Sort Button");
		waitFor(2000);
		click(Locator.Sort_By_Date_Btn);
		LOG.info("Clicked on Sort Date Button");
		
	}
		@Test
		public  void testCaseNoTWO() {
			LOG.info("TC #2 works fine");
		}
		
		@Test
		public  void testCaseNoTHREE() {
			LOG.info("TC #3 works fine");
		}
		
		
	
	

}
