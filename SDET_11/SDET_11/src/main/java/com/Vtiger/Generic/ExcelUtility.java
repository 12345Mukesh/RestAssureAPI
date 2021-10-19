package com.Vtiger.Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{

	public String readDatafromExcel (int row,int cell,String sheetname) throws Throwable
	{
		FileInputStream fis = new FileInputStream("../SDET_11/src/test/resources/data/Input Data.xlsx");

		Workbook wb=WorkbookFactory.create(fis);

		String data = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return  data;
	}
}
	
	
