package com.pathnxt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author -Priyaranjan Mohanty-
 *
 */
public class IrctchomePage
{
	//initialization
	public IrctchomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaration of webelements
	@FindBy(linkText = "Products")
	private WebElement productsLnk;

	@FindBy(xpath = "//img[@id=\"disha-banner-close\"]")
	private WebElement dishaBot;

	@FindBy(xpath = "//span[@class=\"ng-tns-c57-8 ui-autocomplete ui-widget\"]")
	private WebElement from;

	@FindBy(xpath = "//li[@role=\"option\"]/span[@class=\"ng-star-inserted\"]")
	private WebElement fromlist;

	@FindBy(xpath = "//span[@class=\"ng-tns-c57-9 ui-autocomplete ui-widget\"]")
	private WebElement to;

	@FindBy(xpath = "//span[@class=\"ng-tns-c57-9 ng-star-inserted\"]")
	private WebElement toList;

	@FindBy(xpath = "//span[@class=\"ng-tns-c58-10 ui-calendar\"]")
	private WebElement date;

	@FindBy(xpath = "((//div[@class=\"ui-datepicker-title ng-tns-c58-10\"]/../..//tr[@class=\"ng-tns-c58-10 ng-star-inserted\"])[3]//td[@class=\"ng-tns-c58-10 ng-star-inserted\"])[5]")
	private WebElement selectDate;

	@FindBy(xpath = "//div[@class=\"ui-dropdown-label-container ng-tns-c65-11\"]")
	private WebElement classes;

	@FindBy(xpath = "//li[@class=\"ui-dropdown-item ui-corner-all\"]")
	private WebElement classselect;

	@FindBy(xpath = "//div[@class=\"ui-dropdown-label-container ng-tns-c65-12\"]")
	private WebElement category;

	@FindBy(xpath = "//div[@class=\"ui-dropdown-items-wrapper ng-tns-c65-12\"]/ul[@class=\"ui-dropdown-items ui-dropdown-list ui-widget-content ui-widget ui-corner-all ui-helper-reset ng-tns-c65-12\"]/p-dropdownitem[@class=\"ng-tns-c65-12 ng-star-inserted\"]")
	private WebElement allcategory;

	@FindBy(xpath = "//span[.=\"OK\"]")
	private WebElement ok;

	@FindBy(xpath = "//button[.=\"Search\"]")
	private WebElement search;

	@FindBy(xpath = "//div[@class=\"form-group no-pad col-xs-12 bull-back border-all\"]")
	private WebElement trainList;
	
	@FindBy(xpath = "(//strong[.=\"TRAINS\"])[1]")
	private WebElement trains;
	
	@FindBy(xpath = "//span[.=\"Train Schedule\"]")
	private WebElement trainshedule;

	//utilization

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getDishaBot() {
		return dishaBot;
	}

	public WebElement getFrom() {
		return from;
	}

	public WebElement getFromlist() {
		return fromlist;
	}

	public WebElement getTo() {
		return to;
	}

	public WebElement getToList() {
		return toList;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getSelectDate() {
		return selectDate;
	}

	public WebElement getClasses() {
		return classes;
	}

	public WebElement getClassselect() {
		return classselect;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getAllcategory() {
		return allcategory;
	}

	public WebElement getOk() {
		return ok;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getTrainList() {
		return trainList;
	}

	public WebElement getTrains() {
		return trains;
	}

	public WebElement getTrainshedule() {
		return trainshedule;
	}



}
