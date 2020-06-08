import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilitiesDemo {

	
	public static void main(String[] args) {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("SOftware Development Engineer Test");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.close();
		driver.quit();
	}

}
