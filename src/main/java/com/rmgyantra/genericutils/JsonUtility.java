package com.rmgyantra.genericutils;

import static io.restassured.response.Response.*;

import io.restassured.response.Response;

public class JsonUtility {
   /*
    * method will give
    * @param jsonpath
    * 2param response
    * @return
    */
	
	public String getJsonPathData(String jsonpath,Response response)
	{
       String result= response.jsonPath().get(jsonpath);
	   return result;              
		
	}
	
	
}
