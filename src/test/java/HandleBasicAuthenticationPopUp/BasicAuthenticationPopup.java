package HandleBasicAuthenticationPopUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthenticationPopup {

	public static void main(String[] args) {

		// set up driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        
		// https://username:password@URL
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		String pageMessage = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(pageMessage);
		
		driver.close();
		driver.quit();
	}
}
