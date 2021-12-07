package com.rmgyantra.fourwaysToPostReq;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Usingjsonfile
{
   @Test
   public void usingjsonfile()
   {
	   
	  File file= new File("./BinaryData.json");
	   
	   given()
		 .contentType(ContentType.JSON)
		   .body(file)
		   .when()
		   .post("http://localhost:8084/addProject")
		   .then()
		   .log().all()
		   .assertThat().statusCode(201)
		   .contentType("application/json");   
	   
	   
	   
   }	
}
