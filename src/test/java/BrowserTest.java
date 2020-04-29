import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {
	
	public static void main(String[] args) {
		// set projectpath
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath :" + projectPath);	
		
		// set gecko driver path for firefox browser
		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
		WebDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.get("http://selenium.dev");
		
		// set chrome drive to run test on chrome browser
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("http://selenium.dev");
		chromeDriver.close();
	}

}
