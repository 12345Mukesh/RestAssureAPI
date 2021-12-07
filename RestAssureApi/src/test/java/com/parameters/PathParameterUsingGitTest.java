package com.parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PathParameterUsingGitTest 
{
   @Test
   
   public void pathparameterusingGit()
   {
	 given()
	 .contentType(ContentType.JSON)
	   .pathParam("username", "12345Mukesh")
	   .queryParam("sort", "created")
	   .when()
	   .get("https://api.github.com/users/{username}/repos")
	   .then().assertThat().statusCode(200)
	   .log().all();
	   
   }
}
