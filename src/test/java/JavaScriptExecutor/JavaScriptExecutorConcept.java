package JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
		// set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// maximize chrome browser window
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://freecrm.co.in/");

		//driver.findElement(By.xpath("//a//span[text()='Log In']//preceding-sibling::span[@class='icon icon-xs mdi-chart-bar']")).click();
		WebElement loginButton = driver.findElement(By.xpath("//a//span[text()='Log In']//preceding-sibling::span[@class='icon icon-xs mdi-chart-bar']"));
		
		// call JavascriptExecutor Method
		flash(loginButton, driver);
		
	}
	
	// JavascriptExecutor Method
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgColor = element.getCssValue("backgroundColor");
		for(int i = 0; i < 100; i++) {
			changeColor("rgb(0, 0, 255)", element, driver); // rgb(0, 0, 255) for Blue color
			changeColor(bgColor, element, driver);
			
		}
	}
	
	public static void changeColor(String color,WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "' ", element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
