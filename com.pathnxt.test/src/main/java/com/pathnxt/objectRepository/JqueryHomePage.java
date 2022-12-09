package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JqueryHomePage 
{


	//initialization
	public JqueryHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaration

	@FindBy(xpath = "//div[@id=\"draggable\"]")
	private WebElement drag;

	@FindBy(xpath = "//div[@id=\"droppable\"]")
	private WebElement drop;


	@FindBy(xpath = "//iframe[@class=\"demo-frame\"]")
	private WebElement parentframe;


	//utilization

	public WebElement getDrag() {
		return drag;
	}


	public WebElement getDrop() {
		return drop;
	}


	public WebElement getParentframe() {
		return parentframe;
	}


}
