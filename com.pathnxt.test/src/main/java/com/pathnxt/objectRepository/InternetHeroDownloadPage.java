package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetHeroDownloadPage 
{

	//Initialization
	public InternetHeroDownloadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Declaration

	@FindBy(xpath = "//a[.=\"chromedriver.exe\"]")
	private WebElement link;

	//Utilization
	public WebElement getLink() {
		return link;
	}


}
