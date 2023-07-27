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
