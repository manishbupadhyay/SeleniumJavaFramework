package SeleniumTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoWithTestNG {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver = null;

	@BeforeSuite
	public void setUp() {
		// path where output is to be printed
		htmlReporter = new ExtentHtmlReporter("extentReportsTestNG.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setUpTest() {
		//set up chrome driver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void testExtentReportWithTestNG() {
		ExtentTest extentTest = extent.createTest("Google Search with TestNG","This is a test to validate google search");
		driver.get("http://google.com");
		extentTest.pass("Navigated to google.com");

		// enter text in search textbox
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation Step by Step");
		extentTest.pass("Entered text in textbox");

		// click on search button
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).sendKeys(Keys.RETURN);
		extentTest.pass("Pressed keyboard enter key");
	}

	@Test
	public void test1() throws IOException {

		ExtentTest test1 = extent.createTest("Google Search Test One with TestNG","This is a test to validate google search");
		test1.log(Status.INFO, "This step shows usages of logs");
		test1.info("This step shows usage of info details");
		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test1.addScreenCaptureFromPath("screenshot.png");
	}

	@Test
	public void test2() throws IOException {

		ExtentTest test2 = extent.createTest("Google Search Test Two with TestNG","This is a test to validate google search");
		test2.log(Status.INFO, "This step shows usages of logs");
		test2.info("This step shows usage of info details");
		test2.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test2.addScreenCaptureFromPath("screenshot.png");
	}

	@AfterTest
	public void tearDownTest() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();


	}

}
