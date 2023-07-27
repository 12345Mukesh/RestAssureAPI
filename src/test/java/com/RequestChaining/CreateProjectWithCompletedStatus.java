package com.RequestChaining;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import project.pojolibrary.ProjectLib;

public class CreateProjectWithCompletedStatus {

@Test
public void createprojectwithcompletedstatus() throws SQLException
{
	Random random = new Random();
	int rn=random.nextInt(1000);
	String expprojname="India"+rn;
	String expstatus="on-going";
  //1.creating a resource inside server using pojo class	
  ProjectLib projectlib = new ProjectLib("Rahul", expprojname, expstatus, 15);
	
 //Give precondition and capture the response after doing post operation 
	Response response = given()
	.contentType(ContentType.JSON)
	.body(projectlib)
	.when()
	.post("http://localhost:8084/addProject");
	
	//capture projectName and status code from the response
	String projectName = response.jsonPath().get("projectName");
	String status=response.jsonPath().get("status");
	
	//provide the restassure verification
   response.then()
     .assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)		
	.log().all();		
	
  //connect to the database
    Driver driver = new Driver();
    DriverManager.registerDriver(driver);
    
    //connect to mysql database
   Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");    
   
   //create the statement
   Statement st = con.createStatement();
   
   //execute the statement
      ResultSet result = st.executeQuery("select * from project");	
   
      String actualprojectname=null;
      String actualstatus=null;
      boolean flag=false;
	//For Project name
      while(result.next())  
      {
    	  
    	  if(result.getString(4).equals(expprojname))
	    	{
	    		actualprojectname=result.getString(4);
	    	 actualstatus=result.getString(5);
	    	 flag=true;	
	    	 break;
	    	}
      }
      
    
  con.close();
  Assert.assertEquals(flag, true);
  //verification between expected and actual projectname from database 
  Assert.assertEquals(expprojname, actualprojectname);
   //verification between expected and actual projectname from response
   Assert.assertEquals(projectName, actualprojectname);
  //verification between expected and actual status from database
   Assert.assertEquals(expstatus, actualstatus);
   //verification between expected and actual status from response
   Assert.assertEquals(status, actualstatus);

}	
	
}
