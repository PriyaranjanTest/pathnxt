package com.pathnxt.commonUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass  
{ 

	public WebDriver driver;

	@BeforeMethod
	public void openthebrowser()
	{


		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	//@BeforeTest
	public void navigatetoapp()
	{

		driver.get("https://irctc.co.in");
	}
	@AfterMethod
	public void Quitbrowser()
	{
		driver.quit();
	}
}
