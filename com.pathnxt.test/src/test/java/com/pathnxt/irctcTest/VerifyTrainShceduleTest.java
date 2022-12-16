package com.pathnxt.irctcTest;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.ExcelUtility;
import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.IrctchomePage;
import com.pathnxt.objectRepository.TrainShedulePage;

public class VerifyTrainShceduleTest extends baseClass
{
	@Test
	public void verifytrainshedule() throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException
	{
		/**
		 * creating object for webdriverutility class
		 */
		WebDriverUtilitiy utility = new WebDriverUtilitiy();

		/**
		 * Creating object for excel utilty class
		 */
		ExcelUtility excel = new ExcelUtility();

		/**
		 * creating object of train shedule page
		 */
		TrainShedulePage ts = new TrainShedulePage(driver);

		/**
		 * creating object of hompage
		 */
		IrctchomePage home = new IrctchomePage(driver);

		/**
		 * creating object of file utility
		 */
		FileUtility file = new FileUtility();

		//navigate to the web application
		driver.get(file.getPropertyKeyValue("url"));

		//using implicit wait
		utility.waitForPageToLoad(driver);

		// Closing the DISHA Bot
		driver.findElement(By.xpath("//img[@id=\"disha-banner-close\"]")).click();

		//mouse over on the trains link
		utility.mouseOverOnElement(driver, home.getTrains());

		//click on the trainshedule link
		home.getTrainshedule().click();

		//enter the train number in the train textfield
		ts.getTrainNoTextfield().sendKeys(excel.readDataFromExcel("irctc", 1, 5));

		//click on the submit button
		ts.getSubmit().click();

		//fetch all the train station from the table
		List<WebElement> list = driver.findElements(By.xpath("//table[@class=\"table\"]/tbody/tr/td[3]"));

		//print all the train stations name one by one in the console
		for(WebElement ele:list)
		{
			System.out.println(ele.getText());
		}


	}
}
