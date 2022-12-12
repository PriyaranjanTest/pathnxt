package com.pathnxt.hyrtutorials;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.HyrHomePage;
import com.pathnxt.objectRepository.NewTabPage;

public class HandleNewTabTest extends baseClass
{
	@Test
	public void handletab() throws IOException
	{
		/**
		 * creating object of pom class
		 */
		HyrHomePage home = new HyrHomePage(driver);

		/**
		 * creating object of newtabpage
		 */
		NewTabPage tabpage = new NewTabPage(driver);

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
		
		//click on new tab button
		home.getNewtab().click();
		
		//fetch the title of parent window/tab
		String parent = driver.getTitle();
		
		//fetch the title of the tab
		String tab="AlertsDemo - H Y R Tutorials";
		
		//switch to new tab
		web.switchTowindow(driver, tab);
		
		//perform the operation on the tab
		tabpage.getAlert().click();
		
		//handle the alert poppup
		String alert="I am an alert box!";
		web.switchToAlertPopUpAndAccept(driver, alert);
		
		//switch to the parent tab
		web.switchTowindow(driver, parent);
		
		//perform operation on the parent tab
		home.getTextfield().sendKeys("hii");
		

	}
}
