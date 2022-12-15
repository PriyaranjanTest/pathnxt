package com.pathnxt.hyrtutorials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.ExcelUtility;
import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.HyrDropdownPage;
import com.pathnxt.objectRepository.HyrHomePage;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class DropDownTest extends baseClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void dropsown() throws EncryptedDocumentException, InvalidFormatException, IOException
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
		HyrDropdownPage dropdown = new HyrDropdownPage(driver);

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
		driver.get(file.getPropertyKeyValue(excel.readDataFromExcel("dropdown", 1, 2)));

		//mouse over on the selenium pratice link
		web.mouseOverOnElement(driver, home.getPratice());

		//click the dropdown link
		home.getDropdowns().click();

		//click on the course select dropdown
		dropdown.getSingleSelectDropdown().click();

		//get all the option from the select dropdown
		List<WebElement> list = web.getalloptions(dropdown.getSingleSelectDropdown());
		System.out.println(list.size());

		//print all the option on the console and store them in an array
		ArrayList<String> ascending = new ArrayList<String>();
		for(WebElement ele:list)
		{
			System.out.println(ele.getText());
			String str=ele.getText();
			ascending.add(str);
		}

		//print all the values in the ascending order
		Collections.sort(ascending);
		System.out.println(ascending);

		//print all the values in the descending order
		Collections.reverse(ascending);
		System.out.println(ascending);

	}
}
