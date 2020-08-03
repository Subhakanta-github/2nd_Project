package com.vTiger.GenericLibrary;

import java.io.FileInputStream;

import java.util.Properties;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory; 

public class FileLib {
	
	/**
	 * Read the Data from Common Dta Property File
	 * @throws Throwable 
	 */
	
	public String getPropertyValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./Data/commonData.property");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}
	
	/**
	 * 
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\user\\Desktop\\ExcelData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row rw=sh.getRow(rowNum);
		String data=rw.getCell(cellNum).getStringCellValue();
		
		return data;
	}

}
