package com.pathnxt.commonUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass  
{ 
	/**
	 * creating object of required commonutilities and declare them as public
	 */
	public static  WebDriver driver;
	public ExcelUtility excel=new ExcelUtility();
	public WebDriverUtilitiy web = new WebDriverUtilitiy();
	public FileUtility file = new FileUtility();

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
