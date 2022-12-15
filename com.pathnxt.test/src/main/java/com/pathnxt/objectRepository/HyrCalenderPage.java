package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HyrCalenderPage 
{
	//Intialization
	public HyrCalenderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(xpath = "//input[@id=\"first_date_picker\"]")
	private WebElement firstDate;

	@FindBy(xpath = "//input[@id=\"second_date_picker\"]")
	private WebElement secondDate;

	@FindBy(xpath = "//input[@id=\"third_date_picker\"]")
	private WebElement thirdDate;

	@FindBy(xpath = "//input[@id=\"fourth_date_picker\"]")
	private WebElement fourthDate;

	@FindBy(xpath = "//input[@id=\"fifth_date_picker\"]")
	private WebElement fifthdate;

	@FindBy(xpath = "//img[@class=\"ui-datepicker-trigger\"]")
	private WebElement sixtDateCalenderIcon;

	@FindBy(xpath = "//div[@class=\"ui-datepicker-title\"]/../..//tbody/tr[4]/td[5]")
	private WebElement firstDateSelect;

	@FindBy(xpath = "//div[@class=\"ui-datepicker-title\"]/../..//tbody/tr[4]/td[4]")
	private WebElement secondDateSelect;

	@FindBy(xpath = "//div[@class=\"ui-datepicker-title\"]/../..//tbody/tr[4]/td[3]")
	private WebElement thirdDateSelect;

	@FindBy(xpath = "//div[@class=\"ui-datepicker-title\"]/../..//tbody/tr[4]/td[2]")
	private WebElement fourthDateSelect;

	@FindBy(xpath = "//div[@class=\"ui-datepicker-title\"]/../..//tbody/tr[4]/td[1]")
	private WebElement fifthDateSelect;

	@FindBy(xpath = "//div[@class=\"ui-datepicker-title\"]/../..//tbody/tr[4]/td[7]")
	private WebElement sixthDateSelect;


	//Utilization
	public WebElement getFirstDate() {
		return firstDate;
	}

	public WebElement getSecondDate() {
		return secondDate;
	}

	public WebElement getThirdDate() {
		return thirdDate;
	}

	public WebElement getFourthDate() {
		return fourthDate;
	}

	public WebElement getFifthdate() {
		return fifthdate;
	}

	public WebElement getSixtDateCalenderIcon() {
		return sixtDateCalenderIcon;
	}

	public WebElement getfirstDateSelect() {
		return firstDateSelect;
	}

	public WebElement getFirstDateSelect() {
		return firstDateSelect;
	}

	public WebElement getSecondDateSelect() {
		return secondDateSelect;
	}

	public WebElement getThirdDateSelect() {
		return thirdDateSelect;
	}

	public WebElement getFourthDateSelect() {
		return fourthDateSelect;
	}

	public WebElement getFifthDateSelect() {
		return fifthDateSelect;
	}

	public WebElement getSixthDateSelect() {
		return sixthDateSelect;
	}


}
