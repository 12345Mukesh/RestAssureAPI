package com.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PremptiveAndDigestiveAuthTest {

@Test
public void premptiveauth()
{
   given()
   .auth()
   .preemptive().basic("rmgyantra", "rmgy@9999")
   .when()
   .get("http://localhost:8084/projects")
  .then()
  .assertThat().statusCode(200)
  .contentType("application/json")
  .log().all();


}

@Test
public void digestive()
{
  given()
  .auth()
  .digest("rmgyantra", "rmgy@9999")
  .when()
  .get("http://localhost:8084/projects")
 .then()
 .assertThat().statusCode(200)
 .contentType("application/json")
 .log().all();
	
	
}
	
}
