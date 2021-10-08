package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{

	public static void main(String[] args) throws IOException
	{
		FileInputStream fis= new FileInputStream("../SDET_11/src/test/resources/data/Input Data.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
			String Excelvalue= wb.getSheet("Account").getRow(0).getCell(1).toString();
			System.out.println(Excelvalue);	
	
	}
	

}
