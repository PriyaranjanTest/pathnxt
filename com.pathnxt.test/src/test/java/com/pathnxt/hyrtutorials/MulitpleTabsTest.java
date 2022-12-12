package com.pathnxt.hyrtutorials;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.ChildTabPage;
import com.pathnxt.objectRepository.HyrHomePage;
import com.pathnxt.objectRepository.NewTabPage;


@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class MulitpleTabsTest extends baseClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void multipletabs() throws IOException
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
		 * creating object of new  child tab 
		 */
		ChildTabPage childtab = new ChildTabPage(driver);

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

		//click on the multiple tab button
		home.getMultitabs().click();

		//fetch the parent tab title
		String parent=driver.getTitle();

		//fetch child tabs title
		String newtab="AlertsDemo - H Y R Tutorials";
		String childtab1="Basic Controls - H Y R Tutorials";

		//switch to new tab
		web.switchTowindow(driver, newtab);

		//perform operation on that tab
		tabpage.getAlert().click();

		//handle the popup
		String alertmsg="I am an alert box!";
		web.switchToAlertPopUpAndAccept(driver, alertmsg);

		//switch to another tab
		web.switchTowindow(driver, childtab1);

		//perform operation in the tab
		childtab.getFrstnametextfield().sendKeys("Hello!");

		//switch to parent tab
		web.switchTowindow(driver, parent);

		//perform action on the parent tab
		home.getTextfield().sendKeys("This is parent tab");

		//result message
		System.out.println("test case passed");
	}
}
