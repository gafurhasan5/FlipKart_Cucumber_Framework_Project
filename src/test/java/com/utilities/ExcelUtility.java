package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	FileInputStream fs;
	XSSFWorkbook wb;
    XSSFSheet sh;
	XSSFRow row;
	XSSFCell c;

	public String excelread(String sheet, int RowNumber, int CellNumber) throws IOException {

		// create the file path of where the data stored
		File Path = new File("src/test/resources/TestData/FlipkartTestData.xlsx");

		fs = new FileInputStream(Path);
		wb = new XSSFWorkbook(fs);
		sh = wb.getSheet(sheet);
		row = sh.getRow(RowNumber);
		c = row.getCell(CellNumber);
		return c.getStringCellValue();

	}

	public int getRowCount(String sheetName) throws IOException {

	    File Path = new File(
	            "src/test/resources/TestData/FlipkartTestData.xlsx");

	    fs = new FileInputStream(Path);

	    wb = new XSSFWorkbook(fs);

	    sh = wb.getSheet(sheetName);

	    int lastRowNum = sh.getLastRowNum();

	    return lastRowNum;
	}
}

/*
 * import java.io.FileInputStream; import java.io.IOException;
 * 
 * import org.apache.poi.ss.usermodel.DataFormatter; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class ExcelUtility {
 * 
 * private Workbook workbook; private Sheet sheet;
 * 
 * public ExcelUtility(String filePath, String sheetName) throws IOException {
 * 
 * FileInputStream fis = new FileInputStream(filePath);
 * 
 * workbook = new XSSFWorkbook(fis); sheet = workbook.getSheet(sheetName); }
 * 
 * public int getRowCount() { return sheet.getLastRowNum(); }
 * 
 * public String getCellData(int rowNumber, int columnNumber) {
 * 
 * Row row = sheet.getRow(rowNumber);
 * 
 * if (row == null) { return ""; }
 * 
 * DataFormatter formatter = new DataFormatter();
 * 
 * return formatter.formatCellValue( row.getCell(columnNumber) ); }
 * 
 * public void closeWorkbook() throws IOException { workbook.close(); } }
 */