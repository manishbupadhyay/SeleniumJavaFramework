package BrowserNavigateBackAndForward;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateBackAndForward {

	public static void main(String[] args) throws Exception {
		// set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// maximize chrome browser window
		//driver.manage().window().maximize();

		// delete/cookies
		//driver.manage().deleteAllCookies();

		// open google
		driver.get("https://www.google.com/");
		
		// wait for 2 second
		Thread.sleep(2000);
		
		// navigate to amazon.in
		driver.navigate().to("https://www.amazon.in/");
		
		// click on browser back button to back on google page
		driver.navigate().back();
		
		// wait for 2 second
		Thread.sleep(2000);
		
		// click on browser forward button to go on amazon.in page
		driver.navigate().forward();
		
		// wait for 2 second
		Thread.sleep(2000);
		
		// again click on browser back button to back on google page
		driver.navigate().back();
		
		// refresh page
		driver.navigate().refresh();
		
		driver.close();
		driver.quit();
	}

}
