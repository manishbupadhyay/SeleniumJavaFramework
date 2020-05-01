import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
		 
		
		// set IE driver to run test on IE browser
		System.setProperty("webdriver.ie.driver", projectPath + "/drivers/iedriver/IEDriverServer.exe");
		WebDriver IEDriver = new InternetExplorerDriver();
		IEDriver.get("http://selenium.dev");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IEDriver.close();
		
		// Note: Also we can set driver path in Control Panel\All Control Panel Items\System\Advanced system setting\ 
		//environment variables and add it in system variables
		//so we don't need to set here for firefix,chrome and IE driver
	}

}
