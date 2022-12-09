package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedbubHomePage 
{
	//initialization

	public RedbubHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaration

	@FindBy(xpath = "//input[@id=\"src\"]")
	private WebElement from;

	@FindBy(xpath = "//input[@id=\"dest\"]")
	private WebElement to;

	@FindBy(xpath = "//input[@id=\"onward_cal\"]")
	private WebElement onwardDate;
	
	@FindBy(xpath = "//td[@class=\"monthTitle\"]/../../tr[5]/td[.='15']")
	private WebElement selectDate;

	@FindBy(xpath = "//button[.='Search Buses']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//div[@class=\"close-primo\"]")
	private WebElement closePrimo;


	//utilization

	public WebElement getFrom() {
		return from;
	}

	public WebElement getSelectDate() {
		return selectDate;
	}

	public WebElement getClosePrimo() {
		return closePrimo;
	}

	public WebElement getTo() {
		return to;
	}

	public WebElement getOnwardDate() {
		return onwardDate;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

}
