package com.vtech.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	// "C:\Users\USER\eclipse-workspace\com.vtechhybridframwork\TestData\inetBankingTestData.xlsx"
	FileInputStream fins;
	XSSFWorkbook workbook;
//	XSSFSheet sheet;

//	public ExcelDataProvider(String fileNale ,String sheetname) {
//		try {
//			File fs = new File("./TestData/"+  fileNale + ".xlsx");
//			fins = new FileInputStream(fs);
//			workbook = new XSSFWorkbook(fins);
//			sheet =workbook.getSheet(sheetname);
//
//		} catch (Exception e) {
//         e.printStackTrace();	
//		}
//	}
//	
//	public ExcelDataProvider(int index ,String fileName) {
//		try {
//			File fs = new File("./TestData/" + fileName + ".xlsx");
//			fins = new FileInputStream(fs);
//			workbook = new XSSFWorkbook(fins);
//			sheet =workbook.getSheetAt(index);
//
//		} catch (Exception e) {
//         e.printStackTrace();
//		}
//	}

	public ExcelDataProvider(String fileNale) {
		try {
			File fs = new File("./TestData/" + fileNale + ".xlsx");
			fins = new FileInputStream(fs);
			workbook = new XSSFWorkbook(fins);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int rowCount(String sheetname) {
		return workbook.getSheet(sheetname).getLastRowNum();
	}
	public int rowCount(int index) {

		return workbook.getSheetAt(index).getLastRowNum();
	}
	public int colCount(String sheetname, int row) {
		return workbook.getSheet(sheetname).getRow(row).getLastCellNum();
	}
	public int colCount(int index, int row) {
		return workbook.getSheetAt(index).getRow(row).getLastCellNum();
	}
	
	
	
	public String fetchStringCellValue(String sheetname, int row,int col)
	{
		return workbook.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();		
	}
	
	public String fetchStringCellValue(int index, int row,int col)
	{
		return workbook.getSheetAt(index).getRow(row).getCell(col).getStringCellValue();		
	}
	
	public int fetchNumericCellValue(String sheetname,int row,int col)
	{
		return (int)workbook.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();	
	}

	public int fetchNumericCellValue(int index, int row,int col)
	{
		return (int)workbook.getSheetAt(index).getRow(row).getCell(col).getNumericCellValue();	
	}
	

//	public static void main(String[] args) {
//		
//		ExcelDataProvider excelDataProvider =new ExcelDataProvider("inetBankingTestData");
//		
//		System.out.println("Row Count"+excelDataProvider.rowCount("Login"));
//		System.out.println("Row Count"+excelDataProvider.rowCount(0));
//		
//		System.out.println("Row Count"+excelDataProvider.colCount("Login",0));
//		System.out.println("Row Count"+excelDataProvider.colCount(0,0));
//		
//	
//		System.out.println("User name: "+excelDataProvider.fetchStringCellValue("Login", 0, 0));
//		System.out.println("User name: "+excelDataProvider.fetchStringCellValue("Login", 0, 1));
//		System.out.println("User name: "+excelDataProvider.fetchStringCellValue("Login", 0, 2));
//		
//		System.out.println("User name: "+excelDataProvider.fetchStringCellValue("Login", 1, 0));
//		System.out.println("User name: "+excelDataProvider.fetchStringCellValue("Login", 1, 1));
//		System.out.println("User name: "+excelDataProvider.fetchStringCellValue("Login", 1, 2));
//	}

	public String[][] getExcelTestDate(String sheetname) 
	{
		int rows = rowCount(sheetname);
		int col = colCount(sheetname,0);
		
		String[][] data = new String [rows][col];
		for(int i=0; i<rows; i++) 
		{
			for(int j=0; j<col;i++)
			{
				data[i][j]= workbook.getSheet(sheetname).getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
