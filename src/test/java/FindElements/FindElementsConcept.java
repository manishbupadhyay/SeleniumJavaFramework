package FindElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept {

	public static void main(String[] args) throws Exception {

		// set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// maximize chrome browser window
		driver.manage().window().maximize();

		// delete/cookies
		driver.manage().deleteAllCookies();
		
		// open eBay site
		driver.get("https://www.ebay.com/");
		
		// 1. Get total no. of links on the page
		// 2. Get the text of each link on the page
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		
		// size of list / total no of links
		System.out.println(linkList.size());
		
		for(int i=0; i<linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);
		}
		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
	}

}
