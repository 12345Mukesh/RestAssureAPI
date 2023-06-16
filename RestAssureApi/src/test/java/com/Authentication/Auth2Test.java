package com.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class Auth2Test {

@Test
public void oauth2()
{
    Response response = given()
    	//creating the token by generating the data
    	//confidential data passing through form parameter	
   .formParam("client_id", "SwiZo")
   .formParam("client_secret", "06dd1dc63f59834b89547045b11a609a")
   .formParam("grant_type", "client_credentials")   
  .formParam("redirect_uri", "https://example.com")
 
  //Generating token
  .when()   //Base URI
  .post("http://coop.apps.symfonycasts.com/token");
    
    /*
     *  Modifier and Type   	 Method and Description
     *  
          T	prettyPeek()   -     Peeks into the response body by printing it to the console in a prettified manner.
          String           -     prettyPrint() Pretty-print the response body if possible and return it as string.
          String           -     print() Print the response body and return it as string.
     */
  
    System.out.println(response.prettyPrint());
  
    //storing the token in token variable
  String token = response.jsonPath().get("access_token");
  
//using the token
    given()
    .auth().oauth2(token)
    .pathParam("USER_ID", "2518")
    .when()
    .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
     .then()
     .log().all();
    
    
    
    

}
	
	
	
}
