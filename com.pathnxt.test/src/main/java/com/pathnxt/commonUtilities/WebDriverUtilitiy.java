package com.pathnxt.commonUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
	 * here we can change the polling time from default 500ms to any polling time
	 * @param driver
	 * @param pollingTime
	 * @param element
	 */
	public void waitForElementToCustom(WebDriver driver,int pollingTime,WebElement element)
	{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(pollingTime));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * here we are giving custom timeout
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element)
	{
		int count=0;
		while(count<10)
		{
			try {
				element.click();
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				count++;
			}
		}
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
	 * this method is used to click on right arrow key key
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickOnRightArrowKey(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_RIGHT).perform();
	}

	/**
	 * this method is used to click on left arrow key key
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickOnLeftArrowKey(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_LEFT).perform();
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

	/**
	 * this method is used to switch to window using title
	 * @param driver
	 * @param actualTitle
	 */
	public void switchTowindow(WebDriver driver,String actualTitle)
	{
		Set<String> set = driver.getWindowHandles();
		for (String string : set)
		{
			driver.switchTo().window(string);
			String title = driver.getTitle();
			if(title.contains(actualTitle))
			{
				break;
			}
		}
	}

	/**
	 * this method is used to switch to window by using URL
	 * @param actualURL
	 * @param driver
	 */
	public void switchToWindow(String actualURL,WebDriver driver)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wId = it.next();
			driver.switchTo().window(wId);
			String url = driver.getCurrentUrl();
			if(url.contains(actualURL))
			{
				break;
			}
		}
	}

	/**
	 * This method is used to switch alert popUp and accept the popup
	 * @param driver
	 * @param expectedMsg
	 */
	public void switchToAlertPopUpAndAccept(WebDriver driver,String expectedMsg)
	{
		Alert alert = driver.switchTo().alert();
		if(alert.getText().trim().equalsIgnoreCase(expectedMsg.trim()))
		{
			System.out.println("alert msg is verified");
		}else {
			System.out.println("alert msg is not verified");
		}
		alert.accept();
	}
	/**
	 * this method is used to switch to alert popUp and dismiss
	 * @param expectedMsg
	 * @param driver
	 */
	public void switchToAlertPopUpAndDismiss(String expectedMsg,WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		if(alert.getText().trim().equalsIgnoreCase(expectedMsg))
		{
			System.out.println("alert msg is verified");
		}else {
			System.out.println("alert msg is not verified");
		}
		alert.dismiss();
	}

	/**
	 * Robot class for enter keyboard operation
	 * @throws AWTException 
	 */
	public void robotenter() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * robot class for tab keyboard operation
	 * @throws AWTException 
	 */
	public void robottab() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	/**
	 * robot class for control keyboard operation
	 * @throws AWTException 
	 */
	public void robotcontrol() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	/**
	 * robot class for tab keyboard operation
	 * @throws AWTException 
	 */
	public void robotV() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
	}

	/**
	 * robot class for contro + v keyboard operation
	 * @throws AWTException 
	 */
	public void controlv() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
	}

	/**
	 * String selection class for internally copy the file path
	 */
	public void stringselection(String filepath)
	{
		StringSelection strings = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strings, null);
	}




}
