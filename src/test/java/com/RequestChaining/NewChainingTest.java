package com.RequestChaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class NewChainingTest
{
	@Test
	  public void UsingAll4Methods()
	   {
		Random random=  new Random(); 
		  int rn=random.nextInt(2000);
		  
	  /*creating object
	   * Creating new data and storing the project id in the variable of re
	   * 	  
	   */
		JSONObject jobj = new JSONObject();
		   
		jobj.put("createdBy", "Common man" );
		jobj.put("projectName","Society"+rn);
		jobj.put("status", "started");
		jobj.put("teamSize", 1);
		   
	Response resp=	 given()
		 .contentType(ContentType.JSON)
		   .body(jobj)
		   .when()
		   .post("http://localhost:8084/addProject");
	
		 resp.then()
		   .log().all()
		   .assertThat().statusCode(201)
		   .assertThat().contentType("application/json");
		   
		   String re=resp.jsonPath().get("projectId");
		   System.out.println(re);
		
		   
		   
		   
		/*Retreiving whether object is created or not   
		   we cannot directly give string re in the URI because it is in form of String
		   So need to convert in the form of path parameter then can use it
		  */ 
		 given().contentType(ContentType.JSON).pathParam("projectid", re)
		 .when().get("http://localhost:8084/projects/{projectid}").then()
		   .log().all()
		   .assertThat().statusCode(200)
		   .assertThat().contentType("application/json");
		 
		 System.out.println("projectid");  //---> not printing the id value just printing projectid name
		 
		 
		 /*Updating the above data - Modifying the existing data
		   Every time when you have to use the id you need to give path parameter with different value
		   But the string which you assigned should be same(re) and need to run the program
		 
		 */
		 jobj.put("createdBy", "Celebrity");
			jobj.put("projectName","HardWork");
			jobj.put("status", "started");
			jobj.put("teamSize", 05);
			   
			 given()
			 .contentType(ContentType.JSON).pathParam("proid",re)
			   .body(jobj)
			   .when()
			   .put("http://localhost:8084/projects/{proid}")
			   .then()
			   .log().all()
			   .assertThat().statusCode(200)
			   .contentType("application/json");
		 
		 
		 /*
		  * Deleting the created record here also need to use the path parameter
		  */
		 
		Response response=	 given()
			 .contentType(ContentType.JSON).pathParam("pid",re).
			 when().delete("http://localhost:8084/projects/{pid}");
		
		int actualstatuscode=response.getStatusCode();
		  Assert.assertEquals(actualstatuscode, 204);
	   System.out.println(actualstatuscode);
		
		 response.then().assertThat().statusCode(actualstatuscode)
			   .and()
			   .assertThat().contentType("application/json")
			   .and().log().all();
			   
			 
		 
		 
		   
	   }
	
	
	
	
}
