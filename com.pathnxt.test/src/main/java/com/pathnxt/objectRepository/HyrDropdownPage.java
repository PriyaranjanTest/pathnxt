package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HyrDropdownPage 
{
	//Initialization
	public HyrDropdownPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath = "//select[@id=\"course\"]")
	private WebElement singleSelectDropdown;
	
	@FindBy(xpath = "//select[@id=\"ide\"]")
	private WebElement multiSelectDropdown;
	
	//Utilization
	public WebElement getSingleSelectDropdown() {
		return singleSelectDropdown;
	}

	public WebElement getMultiSelectDropdown() {
		return multiSelectDropdown;
	}
	
	

}
