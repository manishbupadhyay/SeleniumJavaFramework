package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo_PropertiesFile {

	WebDriver driver = null;
	public static String browserName = null;

	@BeforeTest
	public void setUpTest() {
		PropertiesFile.getProperties();
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

	}

	@Test
	public void googleSearch() {

		// goto google.com
		driver.get("http://google.com");

		// enter text in search textbox
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation Step by Step");

		// click on search button
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).sendKeys(Keys.RETURN);

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
		//driver.quit();
		System.out.println("Test Completed Successfully");
	}

}
