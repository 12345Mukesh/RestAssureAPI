package com.rmgyantra.withBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UPDATEProjectTest 
{
   @Test
   public void updateproject()
   {
	   
	   JSONObject jobj = new JSONObject();
	   
		jobj.put("createdBy", "Mukesh");
		jobj.put("projectName","RestAssure");
		jobj.put("status", "started");
		jobj.put("teamSize", 05);
		   
		 given()
		 .contentType(ContentType.JSON)
		   .body(jobj)
		   .when()
		   .put("http://localhost:8084/projects/TY_PROJ_036")
		   .then()
		   .log().all()
		   .assertThat().statusCode(200)
		   .contentType("application/json");
		   
   }
	
	
	
	
}
