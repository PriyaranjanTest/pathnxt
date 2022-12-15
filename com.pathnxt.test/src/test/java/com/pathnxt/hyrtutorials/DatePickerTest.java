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
import com.pathnxt.objectRepository.HyrCalenderPage;
import com.pathnxt.objectRepository.HyrHomePage;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class DatePickerTest extends baseClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void calender() throws EncryptedDocumentException, InvalidFormatException, IOException
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
		HyrCalenderPage calender = new HyrCalenderPage(driver);

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
		driver.get(file.getPropertyKeyValue(excel.readDataFromExcel("calender", 1, 0)));

		//mouse over on the selenium pratice link
		web.mouseOverOnElement(driver, home.getPratice());

		//click on the calender pratice link
		home.getCalenderPratice().click();

		//click on the first date textfield
		calender.getFirstDate().click();

		//select the date from the calender
		calender.getfirstDateSelect().click();

		//click on the second date textfield
		calender.getSecondDate().click();

		//select the date from the calender
		calender.getSecondDateSelect().click();

		//click on the third date textfield
		calender.getThirdDate().click();

		//select the dtae from the calender
		calender.getThirdDateSelect().click();

		//click on the fourth date textfield
		calender.getFourthDate().click();

		//select the date from the calender
		calender.getFourthDateSelect().click();

		//click on the fifth date textfield
		calender.getFifthdate().click();

		//select the date from the calender
		calender.getFifthDateSelect().click();

		//click on the sixth date calender icon
		calender.getSixtDateCalenderIcon().click();

		//select the date from the calender
		calender.getSixthDateSelect().click();
	}
}
