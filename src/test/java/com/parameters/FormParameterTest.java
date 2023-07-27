package com.parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameterTest 
{

  @Test
  
  public void formparameter()
  {
	  /*
	   * Not working this parameter
	   */
	  
	given()
	.contentType(ContentType.JSON)
	  .formParam("createdBy", "Viratkohli")
	  .formParam("projectName", "RCB")
	  .formParam("status", "completed")
	  .formParam("teamSize", 20)
	.when()
	.post("http://localhost:8084/addProject")
	  .then()
	  .assertThat()
	  .log().all();
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  
  
	
}
