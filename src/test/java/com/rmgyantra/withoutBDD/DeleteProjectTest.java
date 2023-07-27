package com.rmgyantra.withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest 
{
	@Test
	   public void deleteproject()
	   {
		 Response response= RestAssured.delete("http://localhost:8084/projects/TY_PROJ_474");
		   
		 ValidatableResponse vresp = response.then();
		 vresp.assertThat().contentType("application/json");
		  vresp.assertThat().statusCode(204); 
		  vresp.log().all();
		   
	   }	

	
	
}
