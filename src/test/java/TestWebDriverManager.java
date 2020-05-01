import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebDriverManager {

	public static void main(String[] args) {
		
		// we don't need to set driver path. directly we can write WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().setup();
		/*
		 * WebDriverManager.firefoxdriver().setup();
		 * WebDriverManager.operadriver().setup(); WebDriverManager.phantomjs().setup();
		 * WebDriverManager.edgedriver().setup(); WebDriverManager.iedriver().setup();
		 * WebDriverManager.chromiumdriver().setup();
		 */
		
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://google.com");
		driver.close();
		driver.quit();

	}

}
