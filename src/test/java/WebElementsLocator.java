import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementsLocator {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		
		//find element by class name
		//driver.findElement(By.className("gLFyf")).sendKeys("Selenium");
		
		//find element by xpath
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
		
		//WebElement searchTextbox = driver.findElement(By.className("gLFyf")); // we can also use this 
		//searchTextbox.sendKeys("Automation Step By Step");
		
		List<WebElement> listOfInput = driver.findElements(By.xpath("//input"));
		int count = listOfInput.size();
		System.out.println("Count of input elements:" + count);
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

}
