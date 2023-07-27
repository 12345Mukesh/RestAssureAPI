package com.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PremptiveAndDigestiveAuthTest {

@Test
public void premptiveauth()
{
	/*
	 * Pre-emptive authentication is used when the the developer knows that credentials are required before the request is made
	 */
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
	/*
	 * The main difference between Basic Authentication and Digest Authentication is how the credentials sent through the network.
	 *  Basic Authentication mechanism sends credentials in ‘clear text’. Whereas, Digest Authentication sends credentials in 
	 *  MD5 hashed form. Both Basic and Digest are not secure for ‘man in the middle’ attacks, 
	 *  So we only should apply with HTTPs protocol.
	 */
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
