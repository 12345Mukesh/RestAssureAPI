package com.rmgyantra.withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProject
{
   @Test
   
   public void createproject()
   {
	Random random=  new Random(); 
	   int rn=random.nextInt(2000);
	JSONObject jobj = new JSONObject();
	   
	jobj.put("createdBy", "Manual Batch" );
	jobj.put("projectName","JIRA"+rn);
	jobj.put("status", "started");
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
