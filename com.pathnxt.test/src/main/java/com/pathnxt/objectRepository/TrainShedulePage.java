package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainShedulePage 
{
	//Initialization
	public TrainShedulePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(xpath = "//input[@placeholder=\"Enter Train Number\"]")
	private WebElement trainNoTextfield;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement submit;
	
	@FindBy(xpath = "//table[@class=\"table\"]/tbody/tr/td[3]")
	private WebElement stations;
	
	//utilization
	public WebElement getTrainNoTextfield() {
		return trainNoTextfield;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getStations() {
		return stations;
	}

	
	
}
