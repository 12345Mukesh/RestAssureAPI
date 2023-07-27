package com.parameters;


import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class HamcrestVerificationTest
{
   @Test
   public void ham()
   {
	   
	   when()
	   .get("http://localhost:8084/projects")
	   .then()
	   .assertThat().time(Matchers.lessThan(50L),TimeUnit.SECONDS)
       .assertThat().body("[0].projectName", Matchers.equalTo("SDET_001"))
        .log().all();
   
   
   
   
   
   
   
   }
	
	
	
}
