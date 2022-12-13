package com.pathnxt.internethero;

import java.awt.AWTException;
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
import com.pathnxt.objectRepository.InternetHeroDownloadPage;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class FileDownloadTest extends baseClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void filedownload() throws EncryptedDocumentException, InvalidFormatException, IOException, AWTException, InterruptedException

	{
		/**
		 * creating object of excel utility class
		 */
		ExcelUtility excel = new ExcelUtility();

		/**
		 * creating object of pom class
		 */

		InternetHeroDownloadPage download = new InternetHeroDownloadPage(driver);

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
		driver.get(file.getPropertyKeyValue(excel.readDataFromExcel("download", 1, 0)));

		//click on the file download link
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class=\"example\"]/a"));
		int count=0;
		for(WebElement list:ele)
		{
			if(list.getText().contains("sample.pdf"))
			{
				if(list.getText().contains("chromedriver"))
				{
					count++;
					list.click();
					for(int i=0;i<=ele.size();i++)
					{
						Thread.sleep(50);
						web.robottab();
					}
					Thread.sleep(100);
					web.robotenter();
					break;
				}
				count++;
				list.click();
				break;
			}
			else
			{
				System.out.println("element is not present");
				break;
			}
		}

	}
}
