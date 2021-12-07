package com.rmgyantra.genericutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

public class DatabaseUtilities
{
 static Connection con=null;
  static ResultSet result;
	public void startingdatabaseconnection() 
	{
	  /*
	   * @author:Mukesh
	   * This method will perform mysql database connection	
	   */
      try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
	con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
			
	}

	/*
	 * @author:Mukesh
	 * This method will perform database close action
	 */
	public void closingdatabaseconnection() throws SQLException
	{
		con.close();
	}
	
/*
 * This method will execute query nd gives result	
 */
	


	public ResultSet executeQuery(String query)
	{
		try {
			result=con.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	 
	/*
	 * @param query
	 * @param columnNumber
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 * This method will verify whether data is there or not	
	 */
	
  public String executeQueryAndGetData(String query, int columnNumber, String expectedData) throws Throwable 
  {
	  boolean flag=false;
	  result = con.createStatement().executeQuery(query);
		 while(result.next())
		 { 
	  try {
		  if(result.getString(columnNumber).equals(expectedData))
			 {
			     flag=true;
			     break;
			 }
		  
	  }
	  catch(Exception e){
		  
	  }
  }
   	if(flag==true) 
   	{
   		System.out.println(expectedData+"==> Data is verified in the database");
   	    return expectedData;
   	}
   	else
   	{
   		System.out.println(expectedData+"==> Data is not verified");
   	    return expectedData;
   	}
	 
  }


}
