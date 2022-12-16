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

public class FetchTheLowestFairedTrainTest extends baseClass
{
	@Test
	public void lowestfairtrain() throws EncryptedDocumentException, InvalidFormatException, IOException
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
		 * creating object of hompage
		 */
		IrctchomePage home = new IrctchomePage(driver);

		/**
		 * creating object of file utility
		 */
		FileUtility file = new FileUtility();
		String url=file.getPropertyKeyValue("url");
		/**
		 * getting required data from excel sheet
		 */
		String FROM=excel.readDataFromExcel("irctc", 1, 0);
		String TO=excel.readDataFromExcel("irctc", 1, 1);
		String CLASSES=excel.readDataFromExcel("irctc", 1, 3);
		String QUOTA=excel.readDataFromExcel("irctc", 1, 4);

		//navigate to the web application
		driver.get(url);

		//using implicit wait
		utility.waitForPageToLoad(driver);

		// Closing the DISHA Bot
		driver.findElement(By.xpath("//img[@id=\"disha-banner-close\"]")).click();

		//enter in the FROM dynamic textfield
		WebElement dropdown = driver.findElement(By.xpath("//span[@class=\"ng-tns-c57-8 ui-autocomplete ui-widget\"]"));
		dropdown.click();
		List<WebElement> list = driver.findElements(By.xpath("//li[@role=\"option\"]/span[@class=\"ng-star-inserted\"]"));
		for(int i=0;i<list.size();i++)
		{
			//System.out.println(list.get(i).getText()); 
			if(list.get(i).getText().contains(FROM))
			{
				//System.out.println(list.get(i).getText());
				list.get(i).click();
				break;
			}
		}

		//enter in the TO textfield
		driver.findElement(By.xpath("//span[@class=\"ng-tns-c57-9 ui-autocomplete ui-widget\"]")).click();
		List<WebElement> tolist = driver.findElements(By.xpath("//span[@class=\"ng-tns-c57-9 ng-star-inserted\"]"));

		for(WebElement ele:tolist)
		{
			//System.out.println(ele.getText());
			if(ele.getText().contains(TO))
			{
				ele.click();
				break;
			}
		}

		//enetr the DATE of journey
		driver.findElement(By.xpath("//span[@class=\"ng-tns-c58-10 ui-calendar\"]")).click();
		driver.findElement(By.xpath("//span[.=\"December\"]/../../..//tr[5]/td[6]")).click();

		//select ALL CLASSES dropdown
		WebElement allclasses = driver.findElement(By.xpath("//div[@class=\"ui-dropdown-label-container ng-tns-c65-11\"]"));
		allclasses.click();
		List<WebElement> dd = driver.findElements(By.xpath("//li[@class=\"ui-dropdown-item ui-corner-all\"]"));
		for(WebElement acc:dd)
		{
			//System.out.println(acc.getText());
			if(acc.getText().contains(CLASSES))
			{
				acc.click();
				break;
			}
		}

		//selecting category
		driver.findElement(By.xpath("//div[@class=\"ui-dropdown-label-container ng-tns-c65-12\"]")).click();
		List<WebElement> quota = driver.findElements(By.xpath("//div[@class=\"ui-dropdown-items-wrapper ng-tns-c65-12\"]/ul[@class=\"ui-dropdown-items ui-dropdown-list ui-widget-content ui-widget ui-corner-all ui-helper-reset ng-tns-c65-12\"]/p-dropdownitem[@class=\"ng-tns-c65-12 ng-star-inserted\"]"));

		for(WebElement cat:quota)
		{
			//System.out.println(cat.getText());
			if(cat.getText().contains(QUOTA))
			{
				cat.click();
				break;
			}
		}
		driver.findElement(By.xpath("//span[.=\"OK\"]")).click();

		//click on the search button
		driver.findElement(By.xpath("//button[.=\"Search\"]")).click();
		
		//click on the all the train's 3AC link
		List<WebElement> trains = driver.findElements(By.xpath("//div[@class=\"form-group no-pad col-xs-12 bull-back border-all\"]//tr/td//strong[.=\"AC 3 Tier (3A)\"]"));
		for(WebElement ele:trains)
		{
			ele.click();
		}
		
		//not completed
	}
}
