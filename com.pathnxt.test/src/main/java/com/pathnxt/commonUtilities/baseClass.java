package com.pathnxt.commonUtilities;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

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
	public DataBaseUtility database=new DataBaseUtility();

	
	/**
	 * launch the browser
	 */
	@BeforeMethod
	public void openthebrowser()
	{

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	/*
	 * navigate to application
	 */
	//@BeforeTest
	public void navigatetoapp()
	{

		driver.get("https://irctc.co.in");
	}

	/**
	 * close the browser
	 */
	@AfterMethod
	public void Quitbrowser()
	{
		driver.quit();
	}
	
	
}
