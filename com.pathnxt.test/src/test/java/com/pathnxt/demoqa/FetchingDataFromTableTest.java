package com.pathnxt.demoqa;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.ExcelUtility;
import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.DemoQaTablePage;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class FetchingDataFromTableTest extends baseClass
{
	@Test(invocationCount = 2, retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void table() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		/**
		 * creating object of excel utility class
		 */
		ExcelUtility excel = new ExcelUtility();

		/**
		 * creating object of pom class
		 */

		DemoQaTablePage qa = new DemoQaTablePage(driver);

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
		driver.get(file.getPropertyKeyValue(excel.readDataFromExcel("table", 1, 0)));

		//fetch all the first name from the table
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][1]"));
		for(WebElement lists:ele)
		{
			if(lists.getText().contains(" "))
			{
				break;
			}
			else 
			{
				System.out.println(lists.getText());
			}	

		}

		//fetch all the lastname from the table
		List<WebElement> lastnames = driver.findElements(By.xpath("//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][2]"));
		for(WebElement lists:lastnames)
		{
			System.out.println(lists.getText().trim());
		}

		//fetch all the age

		List<WebElement> agelist = driver.findElements(By.xpath("//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][3]"));
		for(WebElement lists:agelist)
		{
			System.out.println(lists.getText().trim());
		}

		//fetch all the emails

		List<WebElement> emails = driver.findElements(By.xpath("//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][4]"));
		for(WebElement lists:emails)
		{
			System.out.println(lists.getText().trim());
		}

		//fetch all the salary

		List<WebElement> salary = driver.findElements(By.xpath("//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][5]"));
		for(WebElement lists:salary)
		{
			System.out.println(lists.getText().trim());
		}

		//fetch all the departments

		List<WebElement> departments = driver.findElements(By.xpath("//div[@class=\"rt-table\"]//div[@class=\"rt-td\"][6]"));
		for(WebElement lists:departments)
		{
			System.out.println(lists.getText().trim());
		}
	}
	
}
