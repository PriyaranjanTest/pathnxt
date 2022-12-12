package com.pathnxt.hyrtutorials;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.ExcelUtility;
import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.HyrHomePage;
import com.pathnxt.objectRepository.NewTabPage;

public class HandleNewTabTest extends baseClass
{
	@Test
	public void handletab() throws IOException, EncryptedDocumentException, InvalidFormatException
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
		 * creating object of webdriver utility
		 */
		WebDriverUtilitiy web = new WebDriverUtilitiy();

		/**
		 * creating object of properties file for fetching the data
		 */
		FileUtility file = new FileUtility();
		String URL=file.getPropertyKeyValue(excel.readDataFromExcel("tab", 1, 0));

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
		
		//switch to new tab
		web.switchTowindow(driver, excel.readDataFromExcel("tab", 1, 2));
		
		//perform the operation on the tab
		tabpage.getAlert().click();
		
		//handle the alert poppup;
		web.switchToAlertPopUpAndAccept(driver, excel.readDataFromExcel("tab", 1, 4));
		
		//switch to the parent tab
		web.switchTowindow(driver, excel.readDataFromExcel("tab", 1, 1));
		
		//perform operation on the parent tab
		home.getTextfield().sendKeys("hii");
		
		//result message
		System.out.println(excel.readDataFromExcel("tab", 1, 3));
		

	}
}
