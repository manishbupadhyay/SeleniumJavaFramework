package SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectModel.GoogleSearchPage;
import PageObjectModel.GoogleSearchPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchPageTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		GoogleSearchPageObject googleSearchPageObj = new GoogleSearchPageObject(driver);
		
		driver.get("http://google.com");
		
		googleSearchPageObj.setTextInSearchBox("Selenium Java");
		googleSearchPageObj.clickSearchButton();
		
		driver.close();
	}

}
