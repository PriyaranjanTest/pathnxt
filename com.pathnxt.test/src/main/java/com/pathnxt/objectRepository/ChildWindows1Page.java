package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChildWindows1Page 
{
	//initialization

	public ChildWindows1Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaration
	@FindBy(xpath = "//input[@maxlength=\"10\"]")
	private WebElement firstname;

	
	//utilization
	public WebElement getFirstname() {
		return firstname;
	}


	
	
	}



