package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTabPage 
{

	//initialization
	public NewTabPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// declatration
	@FindBy(xpath = "//button[@id=\"alertBox\"]")
	private WebElement alert;

	//utilization
	public WebElement getAlert() {
		return alert;
	}


}
