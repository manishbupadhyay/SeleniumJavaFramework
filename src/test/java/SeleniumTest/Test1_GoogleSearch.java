package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch() {
		//set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// goto google.com
		driver.get("http://google.com");
		
		// enter text in search textbox
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation Step by Step");
		
		// click on search button
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).sendKeys(Keys.RETURN);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close browser
		driver.close();
		//driver.quit();
		System.out.println("Test Completed Successfully");
	}

}
