package com.rmgyantra.fourwaysToPostReq;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingHashMap 
{

	@Test
	public void usinghashmap()
	{
		HashMap jobj = new HashMap();
		jobj.put("createdBy", "Automation Batch");
		jobj.put("projectName","SELENIUM");
		jobj.put("status", "on-going");
		jobj.put("teamSize", 50);
		   
		 given()
		 .contentType(ContentType.JSON)
		   .body(jobj)
		   .when()
		   .post("http://localhost:8084/addProject")
		   .then()
		   .log().all()
		   .assertThat().statusCode(201)
		   .contentType("application/json");
		   
		
		
		
		
		
	}
	
	
}
