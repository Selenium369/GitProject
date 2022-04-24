package com.framework.utility;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.utility.constant.Locator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {

	public static RemoteWebDriver driver;
	private static WebDriverWait wait;
	private static final Logger LOG = Logger.getLogger(Keyword.class);
	
	
	/**
	 * This method will launch specified browser in maximized mode
	 * 
	 * @param browsername must be of the following
	 *                    <ul>
	 *                    <li>Chrome</li>
	 *                    <li>Firefox</li>
	 *                    <li>Edge</li>
	 *                    </ul>
	 *
	 */
	public static void openBrowser(String browsername) { // Creating this static method, so that we can directly call it
															// without creating any object
		if (browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			LOG.error("Invalid browser name");
		}
		LOG.info(browsername + "successfully launched");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	/**
	 * This method will launch the specified URL in currently opened browser window
	 * 
	 * @param URL
	 */
	public static void launchURL(String URL) {
		driver.get(URL);

	}

	/**
	 * This method will click on element described by {@code locatortype} &
	 * {@code locatorvalue}
	 * 
	 * @param locatortype  must be one of the following
	 *                     <ul>
	 *                     <li>xpath</li>
	 *                     <li>css</li>
	 *                     </ul>
	 * @param locatorvalue
	 */
	@Deprecated
	public static void click(String locatortype, String locatorvalue) { 
		getWebElement(locatortype, locatorvalue).click();
	}
	
	public static void click(String locator) {
		String[] parts =locator.split("##");
		getWebElement(parts[0],parts[1]).click();
		
	}

	/**
	 * If end user the By class instance 'by' then use below method. Above and this
	 * method both are same. This is the concept of method overloading
	 * 
	 * @param by
	 */
	public static void click(By by) {   
		driver.findElement(by).click();
	}
	


	/**
	 * This method is used to enter a text in a search text box
	 * @param locatortype
	 * @param locatorvalue
	 * @param textToEnter
	 */
	@Deprecated
	public static void enterText(String locatortype, String locatorvalue, String textToEnter) {
		getWebElement(locatortype, locatorvalue).sendKeys(textToEnter);
	}
	
	
	/**
	 * Instead of above method we can use this method to enter a text in the text box.
	 * In above method we required 3 parameters however, here we require 2 parameters.
	 * We split the locator here, one for xpath and another for its locator value and then sent the text
	 * @param locator
	 * @param textToEnter
	 */
	public static void enterText(String locator, String textToEnter) {
		String[] parts=locator.split("##");
		getWebElement(parts[0],parts[1]).sendKeys(textToEnter);
	}
	
	private static WebElement  getWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("xpath")) {
		return driver.findElement(By.xpath(locatorValue));
		} else if(locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locatorValue));
		}else {
			LOG.error("Invalid locator type: " + locatorType);
			return null;
		}
		
		}
	

	/**
	 * THis is used for applying the wait
	 * @param duration
	 */
	
	public static void waitFor(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
