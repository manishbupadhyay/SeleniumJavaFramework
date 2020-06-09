package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

// once we add listeners in testng.xml file then we can remove @Listeners from here
//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {

	@Test
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside Test 2");
		//Assert.assertTrue(false);
		
		// use TestNGListeners with Selenium example
		// we don't need to set driver path. directly we can write WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(); 
		// goto google.com
		driver.get("http://google.com");
		
		// enter text in search textbox
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("TestNG Listeners");
		
		driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("TestNG Listeners");
		
		driver.close();
		driver.quit();
	}
	
	@Test
	public void test3() {
		System.out.println("I am inside Test 3");
		throw new SkipException("This test is skipped");
	}
}
