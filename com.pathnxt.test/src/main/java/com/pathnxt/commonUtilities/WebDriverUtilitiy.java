package com.pathnxt.commonUtilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author -Priyaranjan Mohanty-
 *
 */
public class WebDriverUtilitiy implements Iconstants
{
	/**
	 * used to maximize the browser
	 * @param driver
	 */
	public void maximizethebrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * to refresh the page
	 * @param driver
	 */
	public void refershThePage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	/**
	 * to get back to previous page
	 * @param driver
	 */
	public void backToPreviousPage(WebDriver driver)
	{
		driver.navigate().back();

	}
	/**
	 * to get forward to next page
	 * @param driver
	 */
	public void forwardToNextPage(WebDriver driver)
	{
		driver.navigate().forward();
	}
	/**
	 *it will wait for 10 seconds till the page gets load.
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Iconstants.implicitlyWaitDuration));
	}
	/**
	 * it will wait for js elements
	 * @param driver
	 */
	public void waitforPageToLoadForJSElement(WebDriver driver)
	{
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Iconstants.scriptTimeOutDuration));
	}
	/**
	 * it will check for the element in the GUI for polling time of 500ms
	 * @param driver
	 * @param element
	 */
	public void waitForElemenetToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Iconstants.explicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * it is used switch to select dropdown by using index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * it is used switch to select dropdown by using value
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * it is used switch to select dropdown by using visible_text
	 * @param element
	 * @param visible_text
	 */
	public void selectDropDownByVtext(WebElement element,String visible_text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visible_text);
	}

	public List<WebElement> getalloptions(WebElement element)
	{
		Select sel = new Select(element);
		List<WebElement> list = sel.getOptions();
		return list;

	}

	/**
	 * this method is used to mouseover on an element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * this method is used to right click on element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * this method is used to doubleclick on an element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void dragandrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dst).perform();;
	}

	/**
	 * this method is used to click on enter key
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickOnEnterKey(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * switching to frame using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * switching to frame using id
	 * 
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	/**
	 * switching to frame using element
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * switching to main frame
	 * 
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * Window Scroll using java Scripts Executor
	 */
	public void windowscrollbypixel(WebDriver driver)
	{
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,7000)");
	}

	/**
	 * Window Scroll using java Scripts Executor
	 */
	public void windowscrolltopageheight(WebDriver driver)
	{
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// it will go down till the object specified.
	public void scrolltillobjectfound(WebDriver driver,String element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(element)));
	}





}
