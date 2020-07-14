package TakeScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshotConcept {

	public static void main(String[] args) throws Exception {

		// set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// maximize chrome browser window
		driver.manage().window().maximize();

		// delete/cookies
		driver.manage().deleteAllCookies();

		// open google
		driver.get("https://www.google.com/");

		//Take screenshot
		File screenshotFile  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(screenshotFile , new File("/SeleniumJavaFramework/src/test/java/TakeScreenshot/google.png"));
		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
		

	}

}
