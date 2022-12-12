package com.pathnxt.hyrtutorials;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.ExcelUtility;
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
	public void multipletabs() throws IOException, EncryptedDocumentException, InvalidFormatException
	{

		/**
		 * creating object of excel utility class
		 */
		ExcelUtility excel = new ExcelUtility();

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

		//use implicit wait
		web.waitForPageToLoad(driver);

		//navigate to application
		driver.get(file.getPropertyKeyValue(excel.readDataFromExcel("tab", 1, 0)));

		//mouse over on element
		web.mouseOverOnElement(driver, home.getPratice());

		//click on the windowhandle option
		home.getWindowhandle().click();

		//click on the multiple tab button
		home.getMultitabs().click();

		//switch to new tab
		web.switchTowindow(driver, excel.readDataFromExcel("tab", 1, 2));

		//perform operation on that tab
		tabpage.getAlert().click();

		//handle the popup
		web.switchToAlertPopUpAndAccept(driver, excel.readDataFromExcel("tab", 1, 4));

		//switch to another tab
		web.switchTowindow(driver, excel.readDataFromExcel("tab", 3, 2));

		//perform operation in the tab
		childtab.getFrstnametextfield().sendKeys(excel.readDataFromExcel("tab", 3, 4));

		//switch to parent tab
		web.switchTowindow(driver, excel.readDataFromExcel("tab", 1, 1));

		//perform action on the parent tab
		home.getTextfield().sendKeys(excel.readDataFromExcel("tab", 1, 5));

		//result message
		System.out.println(excel.readDataFromExcel("tab", 1, 3));
	}
}
