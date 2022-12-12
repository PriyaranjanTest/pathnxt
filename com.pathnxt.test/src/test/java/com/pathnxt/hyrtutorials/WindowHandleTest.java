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
	public void windowhandle() throws IOException, EncryptedDocumentException, InvalidFormatException
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
		HyrNewWindow window = new HyrNewWindow(driver);

		/**
		 * creating object of webdriver utility
		 */
		WebDriverUtilitiy web = new WebDriverUtilitiy();

		/**
		 * creating object of properties file for fetching the data
		 */
		FileUtility file = new FileUtility();
		String URL=file.getPropertyKeyValue(excel.readDataFromExcel("window", 1, 5));


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

		//switch to child window;
		web.switchTowindow(driver, excel.readDataFromExcel("window", 1, 0));

		//perform operation on the child windows
		window.getFirstname().sendKeys(excel.readDataFromExcel("window", 1, 2));

		//switch to parent window
		web.switchTowindow(driver, excel.readDataFromExcel("window", 1, 1));

		//perform operation on the parent window
		home.getTextfield().sendKeys(excel.readDataFromExcel("window", 1, 3));

		//confirmation message
		System.out.println(excel.readDataFromExcel("window", 1, 4));
		

	}
}
