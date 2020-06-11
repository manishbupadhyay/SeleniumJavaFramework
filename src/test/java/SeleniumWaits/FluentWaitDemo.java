package SeleniumWaits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.*;
import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium Fluent Wait");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//driver.findElement(By.linkText("Difference Between Implicit, Explicit & Fluent Wait in Selenium ...")).click();;
		
		// Fluent wait
		// Waiting 30 seconds for an element to be present on the page, checking
	   // for its presence once every 5 seconds.
		
		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) .withTimeout(30,
		 * TimeUnit.SECONDS) .pollingEvery(5, TimeUnit.SECONDS)
		 * .ignoring(NoSuchElementException.class);
		 */
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(3000))
		        .pollingEvery(Duration.ofMillis(600))
		        .ignoring(NoSuchElementException.class);
		
	   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	     public WebElement apply(WebDriver driver) {
	       WebElement linkElement = driver.findElement(By.linkText("Difference Between Implicit, Explicit & Fluent Wait in Selenium ..."));
	     
	       if(linkElement.isEnabled()) {
	    	   System.out.println("Element found");
	       }
	       return linkElement;
	     }
	   });
		
		   element.click();
		   
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
		
		
	}
}
