package com.Response.validation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import project.pojolibrary.ProjectLib;

public class PojoClassWithDataProvider {

	@Test(dataProvider="Projectdetails")
	public void createMultipleProject(String createdBy, String projectName, String status, int teamSize )
	{
	
		 ProjectLib plib = new ProjectLib(createdBy, projectName, status, teamSize);
		   
		  given()
			 .contentType(ContentType.JSON)
			   .body(plib)
			   .when()
			   .post("http://localhost:8084/addProject")
			   .then()
			   .log().all()
			   .assertThat().statusCode(201)
			   .contentType("application/json");
		
	}	


  @DataProvider
  public Object[][] Projectdetails()
  {

	  Object[][] obj = new Object[4][4];
	  obj[0][0]="Kiran Abbavaram";
	  obj[0][1]="Meter Metro";
	  obj[0][2]="Started";
	  obj[0][3]=20;
	  
	  
	  obj[1][0]="Suresh Singh";
	  obj[1][1]="Captain";
	  obj[1][2]="on going";
	  obj[1][3]=30;
	  
	  
	  
	  obj[2][0]="Praveen Kumar";
	  obj[2][1]="Database";
	  obj[2][2]="Completed";
	  obj[2][3]=200;  
	  
	  obj[3][0]="Ramaraju";
	  obj[3][1]="RRR";
	  obj[3][2]="Completed";
	  obj[3][3]=212;

	  
	  
	  
	  return obj;
	  
	  
	  
   	  
	  
	  
  }

}
