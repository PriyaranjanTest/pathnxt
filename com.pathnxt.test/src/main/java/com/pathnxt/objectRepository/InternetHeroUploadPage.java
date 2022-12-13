package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetHeroUploadPage 
{
	//Initialization
	public InternetHeroUploadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(xpath = "//input[@id=\"file-upload\"]")
	private WebElement browse;

	@FindBy(xpath = "//input[@id=\"file-submit\"]")
	private WebElement submit;
	
	@FindBy(xpath = "//input[@name=\"file\"]")
	private WebElement browse2;
	
	@FindBy(xpath = "//div[@class=\"panel text-center\"]")
	private WebElement validate;


	//Utilization
	

	public WebElement getSubmit() {
		return submit;
	}


	public WebElement getValidate() {
		return validate;
	}


	public WebElement getBrowse2() {
		return browse2;
	}


	public WebElement getBrowse() {
		return browse;
	}


}
