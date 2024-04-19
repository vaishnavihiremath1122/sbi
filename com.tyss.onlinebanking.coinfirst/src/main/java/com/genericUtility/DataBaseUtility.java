package com.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.nimbus.State;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
			
	Connection con=null;
	
		public void connectToDB() throws SQLException 
		{
			//step 1: Register database
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//step 2: Get connection for database[databasename]
			con= DriverManager.getConnection(IpathConstant.DBURL,IpathConstant.DBUsername,IpathConstant.DBPassword);
			
		}
		    public void executeandgetData(String query, int colIndex, String expData) throws SQLException
			{
			 //step 3: create statement[tablename]
			
			 Statement state = con.createStatement();
			
			 //step 4: execute query/update query
		    ResultSet result = state.executeQuery(query);
			boolean flag= false;
			while(result.next()) 
			{
		
				String actual = result.getString(colIndex);
	
				if(actual.contains(expData))
				{
					flag=true;
					break;
					
				}
			}
			if(flag==true)
			{
				System.out.println("--data is verified--");
			}
			else
			{
				System.out.println("--data is not verified--");
			}	
		}
			public void closeDB() throws SQLException 
			{
				
			//step 5: close database connection
			con.close();	
	  }
}
