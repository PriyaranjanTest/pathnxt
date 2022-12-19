package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetHerologinPage 
{
//Initialization
	public InternetHerologinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath = "//input[@id=\"username\"]")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id=\"password\"]")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement signinbutton;

	//Utilization
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSigninbutton() {
		return signinbutton;
	}
	
	
}
