package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	// constructor
	public ExcelUtils(String excelPath, String sheetName) {
		try {
		    workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		getRowCount();
		getColumnCount();
		getCellDataString(0,0);
		getCellDataNumber(1,1);
	}

	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows: " + rowCount);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;

	}
	
	public static int getColumnCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of Columns : " + colCount);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}
	
	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println("Cell data : " + cellData);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}
	
public static void getCellDataNumber(int rowNum,int colNum) {
		
		try {
			String cellDataNumber = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println("Cell data Number : " + cellDataNumber);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

}
