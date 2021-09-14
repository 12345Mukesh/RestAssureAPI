package com.SwiZo.GenericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Filelib 
{

	
	public String readPropertyData(String proppath, String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream(proppath);
		Properties prop= new Properties();
		prop.load(fis);
		String propvalue= prop.getProperty(key,"Incorrect key");
		return propvalue;
		
	}
	
	public String ReadExcelData(String path, String sheetName, int row, int cell) throws Throwable
	{
		FileInputStream fis= new FileInputStream(path);
		Workbook wb= WorkbookFactory.create(fis);
		String Excelvalue= wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
		return Excelvalue;		
	}
	
	public void WriteExcelData(String path, String sheetName, int row, int cell,String data) throws Throwable
	{
		FileInputStream fs= new FileInputStream(path);
		Workbook wb= WorkbookFactory.create(fs);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(data);
		
		FileOutputStream fos= new FileOutputStream(path);
		wb.write(fos);
		
		
	}
	
	
	public int getRowCount(String path, String sheet) throws Throwable
   {
		FileInputStream fs= new FileInputStream(path);
		Workbook wb= WorkbookFactory.create(fs);
		int rowcount= wb.getSheet(sheet).getLastRowNum();
		return rowcount;
		
    }
	
	
	
	
	
	
}
