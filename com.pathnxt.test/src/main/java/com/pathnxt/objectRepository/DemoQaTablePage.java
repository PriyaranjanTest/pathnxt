package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQaTablePage 
{
	//Initialization
	public DemoQaTablePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(xpath = "//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][1]")
	private WebElement firstnames;

	@FindBy(xpath = "//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][2]")
	private WebElement lastnames;

	@FindBy(xpath = "//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][3]")
	private WebElement age;

	@FindBy(xpath = "//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][4]")
	private WebElement emails;

	@FindBy(xpath = "//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][5]")
	private WebElement salary;

	@FindBy(xpath = "//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][6]")
	private WebElement department;

	//Utilization

	public WebElement getFirstnames() {
		return firstnames;
	}

	public WebElement getLastnames() {
		return lastnames;
	}

	public WebElement getAge() {
		return age;
	}

	public WebElement getEmails() {
		return emails;
	}

	public WebElement getSalary() {
		return salary;
	}

	public WebElement getDepartment() {
		return department;
	}



}
