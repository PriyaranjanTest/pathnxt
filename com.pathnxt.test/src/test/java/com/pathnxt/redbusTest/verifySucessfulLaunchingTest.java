package com.pathnxt.redbusTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author -Priyaranjan Mohanty-
 *
 */
@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class verifySucessfulLaunchingTest extends baseClass
{
	
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void verifyredbuslaunch() throws IOException
	{

		/**
		 * fetching the data from .properties file
		 */
		FileUtility file = new FileUtility();
		String URL=file.getPropertyKeyValue("url1");

		/**
		 * creating object of webdriver utility
		 */
		WebDriverUtilitiy web = new WebDriverUtilitiy();

		//using the implicitly wait
		web.waitForPageToLoad(driver);

		//navigate to redbus web site
		driver.get(URL);

		//fetching the  title from the current web page
		String actualtitle=driver.getTitle();
		String expectedtitle="redBus India";

		//verify if the web page displayed successfully
		if(actualtitle.contains(expectedtitle))
		{
			System.out.println("Application launched successfully");
		}
		else
		{
			System.out.println("Application launch failed");
		}

	}
}
