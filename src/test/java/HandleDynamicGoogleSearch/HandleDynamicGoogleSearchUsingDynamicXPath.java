package HandleDynamicGoogleSearch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDynamicGoogleSearchUsingDynamicXPath {

	public static void main(String[] args) {
		// Handle Dynamic Google Search Using Dynamic XPath

		// set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// maximize chrome browser window
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// goto google.com
		driver.get("https://www.google.com");
		
		// type testing in search  box
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("testing");
		
		// find all the text
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbtc']"));
		System.out.println("Total number of suggestion in search box =====> " + list.size());
		
		for(int i=0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("testing tools")) {
				list.get(i).click();
				break;
			}
		}
	}

}
