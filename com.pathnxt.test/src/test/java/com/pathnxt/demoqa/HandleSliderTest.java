package com.pathnxt.demoqa;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.ExcelUtility;
import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.DemoQaSliderPage;
@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class HandleSliderTest extends baseClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void slider() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		/**
		 * creating object of excel utility class
		 */
		ExcelUtility excel = new ExcelUtility();

		/**
		 * creating object of webdriver utility
		 */
		WebDriverUtilitiy web = new WebDriverUtilitiy();

		/**
		 * creating object of sliderpage
		 */
		DemoQaSliderPage slider = new DemoQaSliderPage(driver);

		/**
		 * creating object of properties file for fetching the data
		 */
		FileUtility file = new FileUtility();

		//use implicit wait
		web.waitForPageToLoad(driver);

		//navigate to application
		driver.get(file.getPropertyKeyValue(excel.readDataFromExcel("table", 1, 1)));

		//click on the slider
		slider.getSlider().click();

		//moving the slider right side
		web.clickOnRightArrowKey(driver, slider.getSlider());
		web.clickOnRightArrowKey(driver, slider.getSlider());
		web.clickOnRightArrowKey(driver, slider.getSlider());

		//message
		System.out.println("slider control success");

	}
}
