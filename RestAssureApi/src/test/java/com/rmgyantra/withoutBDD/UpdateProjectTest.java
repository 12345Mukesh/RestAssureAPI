package com.rmgyantra.withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest
{

	@Test
	public void updateproject()
	{
	
		JSONObject jobj=new JSONObject();
		//creating body
		jobj.put("projectName ","Deeraj");
		

		 RequestSpecification reqspec=RestAssured.given();
		  
		 reqspec.contentType(ContentType.JSON);
		 reqspec.body(jobj);
		 
		 Response response = reqspec.put("http://localhost:8084/projects/TY_PROJ_1209");
		 
		 ValidatableResponse vresp = response.then();
		 vresp.assertThat().statusCode(200);
		 vresp.assertThat().contentType("application/json");
		 vresp.log().all(); 
		 
	}		
	
	
	
}
