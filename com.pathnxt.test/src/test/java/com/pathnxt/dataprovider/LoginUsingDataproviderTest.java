package com.pathnxt.dataprovider;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.ExcelUtility;
import com.pathnxt.commonUtilities.baseClass;
import com.pathnxt.objectRepository.InternetHerologinPage;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class LoginUsingDataproviderTest extends baseClass
{
	/**
	 * 
	 * @param username
	 * @param password
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	@Test(dataProvider = "logindata",retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void Logindataprovider(String username,String password) throws IOException, EncryptedDocumentException, InvalidFormatException
	{
		/**
		 * creating object of home page
		 */
		InternetHerologinPage hero = new InternetHerologinPage(driver);

		//using implicitly wait
		web.waitForPageToLoad(driver);

		//navigate to the application
		driver.get(file.getPropertyKeyValue("url8"));

		//enter the username
		hero.getUsername().sendKeys(username);

		//enter the password
		hero.getPassword().sendKeys(password);

		//click on the signin button
		hero.getSigninbutton().click();

		//fetch the title
		String url=driver.getCurrentUrl();

		//perform the validation
		if(url.contains(excel.readDataFromExcel("dataprovider", 1, 3)))
		{
			System.out.println("Login successful");
		}
		else
		{
			System.out.println("invalid username or password");
		}


	}
	/**
	 * creating object array for fetching the required data one by one
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@DataProvider(name = "logindata")
	public Object[][] passdata() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		//creating an object array for storing the data
		Object[][] data = new Object[8][2];
		data[0][0]=excel.readDataFromExcel("dataprovider", 1, 0);
		data[0][1]=excel.readDataFromExcel("dataprovider", 1, 1);
		data[1][0]=excel.readDataFromExcel("dataprovider", 2, 0);
		data[1][1]=excel.readDataFromExcel("dataprovider", 2, 1);
		data[2][0]=excel.readDataFromExcel("dataprovider", 3, 0);
		data[2][1]=excel.readDataFromExcel("dataprovider", 3, 1);
		data[3][0]=excel.readDataFromExcel("dataprovider", 4, 0);
		data[3][1]=excel.readDataFromExcel("dataprovider", 4, 1);
		data[4][0]=excel.readDataFromExcel("dataprovider", 5, 0);
		data[4][1]=excel.readDataFromExcel("dataprovider", 5, 1);
		data[5][0]=excel.readDataFromExcel("dataprovider", 6, 0);
		data[5][1]=excel.readDataFromExcel("dataprovider", 6, 1);
		data[6][0]=excel.readDataFromExcel("dataprovider", 7, 0);
		data[6][1]=excel.readDataFromExcel("dataprovider", 7, 1);
		data[7][0]=excel.readDataFromExcel("dataprovider", 8, 0);
		data[7][1]=excel.readDataFromExcel("dataprovider", 8, 1);

		return data;
	}
}
