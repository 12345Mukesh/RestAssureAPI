package com.Response.validation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class validateDynamicResponse {

	@Test
	public void dynamicResponse()
	{
	
		String expecteddata="Mukesh";
		String actualdata=null;
     Response response = when()
		
		.get("http://localhost:8084/projects");
		
     response.then().statusCode(200).log().all();
     
     List<String> list = response.jsonPath().get("createdBy");
     System.out.println(list);
     for(String data:list)
     {
    
    	if(data.equals(expecteddata)) 
    	{
    		 actualdata=data;
    		System.out.println("value is present" +actualdata);
    	    break;
    	}
    	 
     }
		Assert.assertEquals(actualdata, expecteddata);
      		
	}
		
}
