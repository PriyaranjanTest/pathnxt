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
import com.pathnxt.objectRepository.ChildWindows1Page;
import com.pathnxt.objectRepository.HyrHomePage;
import com.pathnxt.objectRepository.HyrNewWindow;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class MultipleWindowsTest extends baseClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void multiplewindowhandle() throws IOException, EncryptedDocumentException, InvalidFormatException
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

		//use implicit wait
		web.waitForPageToLoad(driver);

		//navigate to application
		driver.get(file.getPropertyKeyValue(excel.readDataFromExcel("window", 1, 5)));

		//mouse over on element
		web.mouseOverOnElement(driver, home.getPratice());

		//click on the windowhandle option
		home.getWindowhandle().click();

		//clck on the multiple window button
		home.getWindows().click();

		//switch to windows by title
		web.switchTowindow(driver, excel.readDataFromExcel("window", 2, 0));

		//perform operation on child windows
		childwindow.getFirstname().sendKeys(excel.readDataFromExcel("window", 1, 2));

		//switch back to the parent window
		web.switchTowindow(driver, excel.readDataFromExcel("window", 1, 1));

		//perform operation on the parent window
		home.getTextfield().sendKeys(excel.readDataFromExcel("window", 1, 3));

		//switch to child1 windows
		web.switchTowindow(driver, excel.readDataFromExcel("window", 1, 0));

		//perform operation on the child1 windows
		child1window.getFirstname().sendKeys(excel.readDataFromExcel("window", 2, 2));

		//switch to the parent frame
		web.switchTowindow(driver, excel.readDataFromExcel("window", 1, 1));

		//perform some operation again on the parent window
		home.getTextfield().clear();
		home.getTextfield().sendKeys(excel.readDataFromExcel("window", 1, 3));

		//Result message
		System.out.println(excel.readDataFromExcel("window", 1, 4));

	}
}
