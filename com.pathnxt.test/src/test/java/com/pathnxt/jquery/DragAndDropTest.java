package com.pathnxt.jquery;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.FileUtility;
import com.pathnxt.commonUtilities.WebDriverUtilitiy;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.JqueryHomePage;
@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class DragAndDropTest extends baseClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void draganddrop() throws IOException
	{
		/**
		 * fetching the data from .properties file
		 */
		FileUtility file = new FileUtility();
		String str=file.getPropertyKeyValue("url2");

		/**
		 * creating object of jqueryclass
		 */
		JqueryHomePage jq = new JqueryHomePage(driver);

		/**
		 * creating object of webdriver utility
		 */
		WebDriverUtilitiy web = new WebDriverUtilitiy();
		
		//use implicit wait
		web.waitForPageToLoad(driver);

		//navigate to the application
		driver.get(str);


		//get the webelements required
		WebElement src = jq.getDrag();
		WebElement dst = jq.getDrop();
		WebElement def = jq.getParentframe();

		//switch to frame
		web.switchToFrame(driver, def);

		//perform drag and drop
		web.dragandrop(driver, src, dst);

	}
}
