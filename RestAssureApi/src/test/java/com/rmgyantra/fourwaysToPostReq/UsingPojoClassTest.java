package com.rmgyantra.fourwaysToPostReq;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import project.pojolibrary.ProjectLib;

public class UsingPojoClassTest
{
   @Test
   public void createpojo()
   {
	   Random random= new Random();
	   int rn=random.nextInt(1000);
	  ProjectLib plib = new ProjectLib("testyantra","usingpojoclass"+rn,"started",250);
	   
	  given()
		 .contentType(ContentType.JSON)
		   .body(plib)
		   .when()
		   .post("http://localhost:8084/addProject")
		   .then()
		   .log().all()
		   .assertThat().statusCode(201)
		   .contentType("application/json");
		   
   }
	
	
	
}
