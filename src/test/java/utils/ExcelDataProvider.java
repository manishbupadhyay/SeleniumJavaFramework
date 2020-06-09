package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	
	// when use TestNG then no need of main method
	/*
	public static void main(String[] args) {
		String excelPath = "/SeleniumJavaFramework/excel/data.xlsx";
		String sheetName = "Sheet1";
		testData(excelPath,sheetName);
	}
	*/
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		//set up chrome driver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws Exception {
		System.out.println(username + " | " + password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(5000);
	}
	
	// use TestNG Data provide
	@DataProvider(name = "test1data")
	public Object[][] getData() {
	
		String excelPath = "/SeleniumJavaFramework/excel/data.xlsx";
		String sheetName = "Sheet1";	
		Object data[][] = testData(excelPath, sheetName);
		return data;
	}
	
	// Create function and object for ExcelUtils
	public Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
		
		// Run a loop in object array
		Object data [][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData + " | ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data;
	}

}
