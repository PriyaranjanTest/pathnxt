package com.pathnxt.hyrtutorials;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.HyrHomePage;
import com.pathnxt.objectRepository.HyrNewWindow;

/**
 * 
 * @author -Priyaranjan Mohanty -
 *
 */

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class WindowHandleTest extends baseClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void windowhandle() throws IOException
	{

		/**
		 * creating object of pom class
		 */
		HyrHomePage home = new HyrHomePage(driver);

		/**
		 * creating object of newwindow page
		 */
		HyrNewWindow window = new HyrNewWindow(driver);

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

		//perform window handle operation
		home.getWindowbutton().click();
		
		//fetch the title
		String parent = driver.getTitle();

		//switch to child window
		String tilte="Basic Controls";
		web.switchTowindow(driver, tilte);

		//perform operation on the child windows
		window.getFirstname().sendKeys("hello");
		
		//fetch the child window title
		String child = driver.getTitle();

		//switch to parent window
		web.switchTowindow(driver, parent);

		//perform operation on the parent window
		home.getTextfield().sendKeys("hii");

		//confirmation message
		System.out.println("test case passed");
		System.out.println(parent);
		System.err.println(child);

	}
}
