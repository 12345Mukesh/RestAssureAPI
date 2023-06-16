package com.rmgyantra.withBDD;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest 
{
   @Test
   
   public void  deleteprojects()
   {
	   
	   when().delete("http://localhost:8084/projects/TY_PROJ_1202")
		.then().assertThat().statusCode(204)
	   .and()
	   .assertThat().contentType("application/json")
	   .and().log().all();
	   
   }
	
	
}
