package com.rmgyantra.withoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostProjectTest
{

	@Test
	public void createproject()
	{
		Random random = new Random();
		int rn=random.nextInt(1000);
		//First we should create json object because of creating body
		JSONObject jobj = new JSONObject();
	//creating body
	jobj.put("createdBy","online batch"+rn);
	jobj.put("projectName","Suresh");
	jobj.put("status","on-going");
	jobj.put("teamSize",27);

	 RequestSpecification reqspec=RestAssured.given();
	  
	 reqspec.contentType(ContentType.JSON);
	 reqspec.body(jobj);
	 
	 Response response = reqspec.post("http://localhost:8084/addProject");
	 
	 ValidatableResponse vresp = response.then();
	 vresp.assertThat().statusCode(201);
	 vresp.assertThat().contentType("application/json");
	 vresp.log().all(); 
	 
	 
	 
	}
	
	
	
}
