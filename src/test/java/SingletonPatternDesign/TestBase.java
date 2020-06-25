package SingletonPatternDesign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver =  null;
	
	public static void initialize() {
		// Singleton pattern
		if(driver == null) {
			if(Constants.browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "/SeleniumJavaFramework/drivers/chromedriver/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(Constants.browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "/SeleniumJavaFramework/drivers/geckodriver/geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(Constants.url);
	}
	
	public static void quit() {
		System.out.println("Quiting the browser");
		driver.quit();
		driver=null;
	}
	
	public static void close() {
		System.out.println("Closing the browser");
		driver.close();
		driver=null;
	}
}
