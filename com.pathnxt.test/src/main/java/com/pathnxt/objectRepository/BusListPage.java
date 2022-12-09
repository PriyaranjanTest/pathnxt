package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusListPage 
{
	//initialization

	public BusListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaration

	@FindBy(xpath = "//section[@class=\"D159_main\"]")
	private WebElement Buses;

	//Utilization
	public WebElement getBuses() {
		return Buses;
	}
	
	



}
