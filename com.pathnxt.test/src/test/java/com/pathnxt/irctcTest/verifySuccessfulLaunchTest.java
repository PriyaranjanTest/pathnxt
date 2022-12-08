package com.pathnxt.irctcTest;

import java.time.Duration;

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
public class verifySuccessfulLaunchTest 
{
	@Test
public void tc_01_launchtest()
{
	//create an instance of the browser
	WebDriverManager.chromedriver().setup();
	
	//launching the browser
	WebDriver driver=new ChromeDriver();
	
	//maximize the browser
	driver.manage().window().maximize();
	
	//use the implicit wait method
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	
	//navigate to the irctc web site
	driver.get("https://www.irctc.co.in");
	
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
	
	//close the browser
	driver.quit();
}

}
