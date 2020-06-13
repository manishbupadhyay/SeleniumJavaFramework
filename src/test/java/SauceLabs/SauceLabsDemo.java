package SauceLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceLabsDemo {

	public static final String USERNAME = "manishuupadhyay";
	public static final String ACCESS_KEY = "55fa3f8c-6862-43e4-b9fc-33ac461aa5ce";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");
		caps.setCapability("name", "GoogleTest");
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		

		driver.findElement(By.name("q")).sendKeys("Sauce Lab");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		driver.close();
		System.out.println("Test Completed");
		
	}
}