package com.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest 
{

	@Test
	public void bearertoken()
	{
		//Giving personal access token of github
		given()
		.auth().oauth2("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")
		//Giving the github api
		.when()
		.get("http://api.github.com/user/repos")
		//validation
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
