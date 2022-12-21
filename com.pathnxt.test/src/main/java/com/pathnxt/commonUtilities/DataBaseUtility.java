package com.pathnxt.commonUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	static Connection connection;
	/**
	 * This method is used to connect to the database
	 * @throws SQLException
	 */
	public void connecttoDB() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(Iconstants.dburl+Iconstants.portnum,Iconstants.dbusername,Iconstants.dbpassword);
	}
	
	/**
	 * this method is used to disconnect from the database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException 
	{
		//close the connection to DB
		connection.close();
	}
}
