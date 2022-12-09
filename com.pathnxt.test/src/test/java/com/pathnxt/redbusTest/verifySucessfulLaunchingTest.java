package com.pathnxt.redbusTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author -Priyaranjan Mohanty-
 *
 */
@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class verifySucessfulLaunchingTest 
{
	
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void verifyredbuslaunch()
	{

		//Create an instance/Object of the browser
		WebDriverManager.chromedriver().setup();

		//launching the web browser
		WebDriver driver=new ChromeDriver();

		//maximize the browser
		driver.manage().window().maximize();

		//using the implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		//navigate to redbus web site
		driver.get("https://www.redbus.in");

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

		//close the browser
		driver.quit();

	}
}
