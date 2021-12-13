package com.rmgyantra.genericLib;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {
	
	public DataBaseUtility dutil = new DataBaseUtility();
	
	@BeforeSuite
	public void createConnetion() throws SQLException
	{
		dutil.connecttoDataBase();
	}
	
	@AfterSuite
	public void closeConnection() throws SQLException
	{
		dutil.closeConnection();
	}

}
