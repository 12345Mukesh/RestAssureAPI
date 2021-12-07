package com.parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class QueryParameterTest {
   @Test
   public void queryparameter()
   {
	   given()
	   .contentType(ContentType.JSON)
	   .queryParams("page", "2")
	   .when()
	   .get("http://reqres.in/api/users")
	   .then()
	   .log().all();
	   
	   
   }
	
	
	
	
}
