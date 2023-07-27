package com.rmgyantra.genericutils;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BaseAPI 
{  /*
     Use Rest Assure version 3.2.0 then only Rest Assure will add Response in "Json Utility"  base URI and port in BaseAPI 
   */
	 DatabaseUtilities db = new DatabaseUtilities();
	
	
   @BeforeSuite
   public void configBeforeSuite()
   {
	  
	   System.out.println("======start========");
	   db.startingdatabaseconnection();
	   System.out.println("=====connect to Databse==="); 
	   baseURI="http://localhost";
	   port=8084;
   }
	
	@AfterSuite
	public void configAfterSuite() throws Throwable 
	{
		db.closingdatabaseconnection();
		System.out.println("====database is closed=====");
		
	}
	
	
}
