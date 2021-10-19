package com.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFile
{
	public static void main(String[] args) throws IOException, ParseException  
	{
		FileReader inputfile= new FileReader("../SDET_11/CommonData.json");
		JSONParser parser= new JSONParser();
		
		Object obj= parser.parse(inputfile);
		
		HashMap jobj =(HashMap) obj;
		String value=jobj.get("browser").toString();
		System.out.println(value);
		
		
	}
	
}
