package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasicDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		
		// path where output is to be printed
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test1 = extent.createTest("Google Search Test One","This is a test to validate google search");

		//set up chrome driver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting test case");
		
		driver.get("http://google.com");
		test1.pass("Navigated to google.com");
		
		// enter text in search textbox
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation Step by Step");
		test1.pass("Entered text in textbox");
		
		// click on search button
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter key");
		
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		
		test1.info("Test completed");
		
		// test 2 start
		ExtentTest test2 = extent.createTest("Google Search Test Two","This is a test to validate google search");

		//set up chrome driver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test2.log(Status.INFO, "Starting test case");
		
		driver.get("http://google.com");
		test2.pass("Navigated to google.com");
		
		// enter text in search textbox
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation Step by Step");
		test2.pass("Entered text in textbox");
		
		// click on search button
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).sendKeys(Keys.RETURN);
		test2.fail("Pressed keyboard enter key");
		
		driver.close();
		driver.quit();
		test2.pass("Closed the browser");
		
		test2.info("Test completed");
		
		extent.flush();
	}

}
