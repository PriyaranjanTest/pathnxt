package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQaSliderPage 
{
	//Initialization
	public DemoQaSliderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(xpath = "//input[@class=\"range-slider range-slider--primary\"]")
	private WebElement slider;

	//Utilization
	public WebElement getSlider() {
		return slider;
	}


}
