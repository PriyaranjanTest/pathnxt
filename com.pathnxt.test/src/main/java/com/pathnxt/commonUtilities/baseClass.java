package com.pathnxt.commonUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

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
//@AfterMethod
public void Quitbrowser()
{
	driver.quit();
}
}
