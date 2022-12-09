package com.pathnxt.irctcTest;

import java.io.IOException;
import java.time.Duration;

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
public class verifySuccessfulLaunchTest  extends baseClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void verifyirctclaunch() throws IOException
	{

		/**
		 * fetching the data from .properties file
		 */
		FileUtility file = new FileUtility();
		String URL=file.getPropertyKeyValue("url");

		/**
		 * creating object of webdriver utility
		 */
		WebDriverUtilitiy web = new WebDriverUtilitiy();

		//use the implicit wait method
		web.waitForPageToLoad(driver);

		//navigate to the irctc web site
		driver.get(URL);

		//fetching the title
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		String exptitle="IRCTC";

		//verify if the launch is successful or not
		if(actualtitle.contains(exptitle))
		{
			System.out.println("Application launch is succsessful");
		}
		else
		{
			System.out.println("Application launch is not successful");
		}

		
	}

}
