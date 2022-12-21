package com.pathnxt.commonUtilities;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApiClass 
{
	/**
	 * creating object of required commonutilities and declare them as public
	 */
	public static  WebDriver driver;
	public ExcelUtility excel=new ExcelUtility();
	public WebDriverUtilitiy web = new WebDriverUtilitiy();
	public FileUtility file = new FileUtility();
	public DataBaseUtility database=new DataBaseUtility();
	/**
	 * connect to db
	 * @throws SQLException
	 */
	//@BeforeSuite
	public void connecttodb() throws SQLException
	{
		database.connecttoDB();
	}
	
	/**
	 * close the db connection
	 * @throws SQLException
	 */
	//@AfterSuite
	public void closedb() throws SQLException
	{
		database.closeDB();
	}

}
