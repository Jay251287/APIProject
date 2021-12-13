package com.rmgyantra.genericLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	public Connection connect = null;
	public ResultSet result;

	/**
	 * @author SWATHI
	 * Descrition : This method conncets to the database
	 * @throws SQLException
	 */
	public void connecttoDataBase() throws SQLException
	{
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Projects", "root", "root");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * @author SWATHI
	 * Description : This method disconnects from the database
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException
	{
		connect.close();
	}

	/**
	 * @author SWATHI
	 * Description: This method is used to read the data from database
	 * @param query
	 * @return
	 * @throws SQLException 
	 * @throws Throwable
	 */
	public ResultSet executeQuery(String query) throws SQLException
	{
		result = connect.createStatement().executeQuery(query);
		return result;
	}
}
