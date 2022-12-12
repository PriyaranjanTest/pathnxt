package com.pathnxt.hyrtutorials;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.ChildWindows1Page;
import com.pathnxt.objectRepository.HyrHomePage;
import com.pathnxt.objectRepository.HyrNewWindow;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class MultipleWindowsTest extends baseClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void multiplewindowhandle() throws IOException
	{
		/**
		 * creating object of pom class
		 */
		HyrHomePage home = new HyrHomePage(driver);

		/**
		 * creating object of newwindow page
		 */
		HyrNewWindow child1window = new HyrNewWindow(driver);

		/**
		 * creating object of new child1 window
		 */
		ChildWindows1Page childwindow = new ChildWindows1Page(driver);

		/**
		 * creating object of webdriver utility
		 */
		WebDriverUtilitiy web = new WebDriverUtilitiy();

		/**
		 * creating object of properties file for fetching the data
		 */
		FileUtility file = new FileUtility();
		String URL=file.getPropertyKeyValue("url3");


		//use implicit wait
		web.waitForPageToLoad(driver);

		//navigate to application
		driver.get(URL);

		//mouse over on element
		web.mouseOverOnElement(driver, home.getPratice());

		//click on the windowhandle option
		home.getWindowhandle().click();

		//clck on the multiple window button
		home.getWindows().click();

		//fetch the parent window title
		String parent = driver.getTitle();

		//fetch the title of child windows
		String child="XPath Practice - H Y R Tutorials";
		String child1="Basic Controls - H Y R Tutorials";

		//switch to windows by title
		web.switchTowindow(driver, child);

		//perform operation on child windows
		childwindow.getFirstname().sendKeys("priyaranjan");

		//switch back to the parent window
		web.switchTowindow(driver, parent);

		//perform operation on the parent window
		home.getTextfield().sendKeys("hii");

		//switch to child1 windows
		web.switchTowindow(driver, child1);

		//perform operation on the child1 windows
		child1window.getFirstname().sendKeys("priyaranjan");

		//switch to the parent frame
		web.switchTowindow(driver, parent);

		//perform some operation again on the parent window
		home.getTextfield().clear();
		home.getTextfield().sendKeys("bye");

		//Result message
		System.out.println("test case passed");

	}
}
