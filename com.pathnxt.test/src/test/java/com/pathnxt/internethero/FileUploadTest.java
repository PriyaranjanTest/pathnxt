package com.pathnxt.internethero;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.ExcelUtility;
import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.InternetHeroUploadPage;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class FileUploadTest extends baseClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void download() throws EncryptedDocumentException, InvalidFormatException, IOException, AWTException, InterruptedException
	{
		/**
		 * creating object of excel utility class
		 */
		ExcelUtility excel = new ExcelUtility();

		/**
		 * creating object of pom class
		 */

		InternetHeroUploadPage home = new InternetHeroUploadPage(driver);

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
		driver.get(file.getPropertyKeyValue(excel.readDataFromExcel("upload", 1, 0)));

		//click on upload button by using robot class	
		web.robottab();
		web.robottab();
		web.robotenter();

		//Use string selection class for copy the path of the file 
		web.stringselection(excel.readDataFromExcel("upload", 1, 1));	

		Thread.sleep(2000);

		//paste the file path using robot class
		web.controlv();

		Thread.sleep(2000);

		//click on the open button using robot class method
		web.robottab();
		web.robottab();
		web.robotenter();               

		Thread.sleep(2000);				

		//click on the upload button
		web.waitAndClick(home.getSubmit());

		//validation for file upload
		//Assert.assertEquals(home.getValidate().getText(), "index.png");



	}
}
