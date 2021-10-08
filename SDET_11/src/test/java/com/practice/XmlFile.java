package com.practice;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XmlFile 
{

	public static void main(String[] args) throws DocumentException  
	{
		File inputfile= new File("../SDET_11/Data.xml");
		SAXReader reader= new SAXReader();
		Document doc= reader.read(inputfile);
	String value= doc.selectSingleNode("//EmployeeDetails/org").getText();
		System.out.println(value);

	}
	
	
	
	
	
}
