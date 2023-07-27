package com.RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ChainingTest 
{
@Test
public void chaining()
{
  //Getting data from server	
	Response response = when()
  .get("http://localhost:8084/projects"); 
   String firstproid=response.jsonPath().get("[14].projectId");	
	System.out.println(firstproid);
	//taking that project id and storing in path variable
	
	given()
	.pathParam("proid", firstproid)
	
	//Then deleting the particular id
	.when()
	.delete("http://localhost:8084/projects/{proid}")
	.then()
	.assertThat().statusCode(204)
	.log().all();
}
	

}
