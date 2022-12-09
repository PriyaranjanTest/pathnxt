package com.pathnxt.redbusTest;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.ExcelUtility;
import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.BusListPage;
import com.pathnxt.objectRepository.RedbubHomePage;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class calculateTotaBusesTest extends baseClass
{
	@Test()
	public void calculatebuses() throws IOException, EncryptedDocumentException, InvalidFormatException
	{
		/**
		 * fetching the data from .properties file
		 */
		FileUtility file = new FileUtility();
		String URL=file.getPropertyKeyValue("url1");

		/**
		 * Creating object for excel utilty class
		 */
		ExcelUtility excel = new ExcelUtility();


		/**
		 * getting required data from excel sheet
		 */
		String FROM=excel.readDataFromExcel("redbus", 1, 0);
		String TO=excel.readDataFromExcel("redbus", 1, 1);


		/**
		 * creating object of redbus class
		 */
		RedbubHomePage home = new RedbubHomePage(driver);

		/**
		 * creating object of bus list class
		 */
		BusListPage buslist = new BusListPage(driver);

		/**
		 * creating object of webdriver utility
		 */
		WebDriverUtilitiy web = new WebDriverUtilitiy();

		//use implicitly wait
		web.waitForPageToLoad(driver);

		//navigate to the web page
		driver.get(URL);

		//enter data into the from field
		home.getFrom().click();
		home.getFrom().sendKeys(FROM);
		List<WebElement> fromlist = driver.findElements(By.xpath("//ul[@class=\"autoFill homeSearch\"]/li"));
		for(WebElement srclist:fromlist)
		{
			System.out.println(srclist.getText());
			if(srclist.getText().equalsIgnoreCase(FROM))
			{
				srclist.click();
				break;
			}

		}

		//enter the data in the to field
		home.getTo().click();
		home.getTo().sendKeys(TO);
		List<WebElement> tolist = driver.findElements(By.xpath("//ul[@class=\"autoFill homeSearch\"]/li"));
		for(WebElement destlist:tolist)
		{
			if(destlist.getText().equalsIgnoreCase(TO))
			{
				destlist.click();
				break;
			}
		}


		//select the date from calender
		home.getOnwardDate().click();
		home.getSelectDate().click();

		//click on the search button
		home.getSearchBtn().click();


		//scroll down for loading the number of busses
		web.windowscrollbypixel(driver);
		web.windowscrollbypixel(driver);

		web.waitForElemenetToBeClickable(driver, home.getClosePrimo());


		//scroll down for loading the number of busses
		web.windowscrollbypixel(driver);
		
		
		//count the number of busses
		List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"clearfix bus-item-details\"]"));
		System.out.println(list.size());




	}
}
