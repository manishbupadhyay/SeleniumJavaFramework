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
		getCellDataString(0,0);
		getCellDataNumber(1,1);
	}

	public static void getRowCount() {
		try {
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows: " + rowCount);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}
	
	public static void columnCount() {
		try {
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of Columns : " + colCount);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void getCellDataString(int rowNum, int colNum) {
		
		try {
			String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println("Cell data : " + cellData);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
public static void getCellDataNumber(int rowNum,int colNum) {
		
		try {
			double cellDataNumber = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println("Cell data Number : " + cellDataNumber);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

}
