package com.rmgyantra.withoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GETProjectTest
{

	@Test
	  public void getallProject()
	  {
		 Response response = RestAssured.get("http://localhost:8084/projects");
//		System.out.println(response.asString());   
//		 response.prettyPrint();
	
		  //validation
		  int actualstatuscode=response.getStatusCode();
		  Assert.assertEquals(actualstatuscode, 200);
		 
	  ValidatableResponse vr = response.then();
	  vr.assertThat().statusCode(actualstatuscode);
	  vr.assertThat().contentType("application/json");
	  vr.log().all();
	  
		//Response 
		 System.out.println(response.getContentType());
		 System.out.println(response.getStatusCode());
	     System.out.println(response.getTime());
	  System.out.println(actualstatuscode);
	  
	
	  
	  
	  }
	
	
	
	
}
