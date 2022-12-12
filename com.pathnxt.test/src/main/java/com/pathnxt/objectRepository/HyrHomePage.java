package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HyrHomePage 
{
	//initialization
	public HyrHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaration

	@FindBy(xpath = "//a[.=\"Selenium Practice\"]")
	private WebElement pratice;

	@FindBy(xpath = "//a[.=\"Window Handles\"]")
	private WebElement windowhandle;

	@FindBy(xpath = "//button[@id=\"newWindowBtn\"]")
	private WebElement windowbutton;

	@FindBy(xpath = "//input[@id=\"name\"]")
	private WebElement textfield;

	@FindBy(xpath = "//button[@id=\"newTabBtn\"]")
	private WebElement newtab;
	
	@FindBy(xpath = "//button[@id=\"newWindowsBtn\"]")
	private WebElement windows;

	//utilization

	public WebElement getPratice() {
		return pratice;
	}

	public WebElement getWindowhandle() {
		return windowhandle;
	}

	public WebElement getWindowbutton() {
		return windowbutton;
	}

	public WebElement getTextfield() {
		return textfield;
	}

	public WebElement getNewtab() {
		return newtab;
	}

	public WebElement getWindows() {
		return windows;
	}


}
