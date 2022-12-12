package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HyrNewWindow 
{

	//initialization
	public HyrNewWindow(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "//input[@id=\"firstName\"]")
	private WebElement firstname;

	public WebElement getFirstname() {
		return firstname;
	}
}
