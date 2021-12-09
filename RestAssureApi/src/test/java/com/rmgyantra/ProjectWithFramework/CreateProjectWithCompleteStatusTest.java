package com.rmgyantra.ProjectWithFramework;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.rmgyantra.genericutils.BaseAPI;
import com.rmgyantra.genericutils.DatabaseUtilities;
import com.rmgyantra.genericutils.Endpoints;
import com.rmgyantra.genericutils.JavaUtility;
import com.rmgyantra.genericutils.JsonUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import project.pojolibrary.ProjectLib;

public class CreateProjectWithCompleteStatusTest extends BaseAPI{

@Test
public void createprojectwithcompletedstatus() throws Throwable
{
  
	JavaUtility ju = new JavaUtility();
    JsonUtility js = new JsonUtility();     
    DatabaseUtilities dbutility = new DatabaseUtilities();
    
	String expprojname="India"+ju.randomNumber();
	String expstatus="on-going";
	
  //1.creating a resource inside server using pojo class	
  ProjectLib projectlib = new ProjectLib("Raja Ravinder", expprojname, expstatus, 15);
	
 //2.Give precondition and capture the response after doing post operation 
	Response response = given()
	.contentType(ContentType.JSON)
	.body(projectlib)
	.when()
	.post(Endpoints.addProject_EP );
	
	//3.capture projectName and status code from the response
	String responseProjectName=js.getJsonPathData("projectName", response);
	String responsestatus=js.getJsonPathData("status", response);
	
	
	
	//4.provide the restassure verification
   response.then()
     .assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)		
	.log().all();		
   
    
  
	//5.perform datbase operation, executing and storing in one variable
   String query="select * from project";
  String actualdata = dbutility.executeQueryAndGetData(query, 4, expprojname);
	String actualstatus=dbutility.executeQueryAndGetData(query, 5, expstatus);
  
	//6.checking expected data with database
	Assert.assertEquals(actualdata, expprojname);
	Assert.assertEquals(actualstatus, expstatus);
	
	//7.checking actual data with database
	Assert.assertEquals(responseProjectName, expprojname);
	Assert.assertEquals(responsestatus, expstatus);
	
	
	
}
	
	
}
