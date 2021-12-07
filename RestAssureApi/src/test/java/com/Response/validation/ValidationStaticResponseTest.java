package com.Response.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class ValidationStaticResponseTest {
  
  	@Test
  	public void validationstaticResponse()
  	{
  		
  	String expproname="SDET_001";	
  	Response response=	when()
  		  .get("http://localhost:8084/projects");
  		
  		response.then()
  		.assertThat()
  		.statusCode(200)
  		.log().all();
  		
  	String actpN=response.jsonPath().get("[5].projectName");
  	System.out.println("Expected projectName:"+expproname);
  	System.out.println("Actual projectName:"+actpN);
  	Assert.assertEquals(actpN, expproname);
  	
  	/*
  	 * If we are storing more than one object in json language it acts as array and when we are trying to fetch the data and checking 
  	 * by using assertion then we should use array method for getting that value
  	 */
  	
  	}
	
	
	
	
}
