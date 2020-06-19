package ElementVisibilityTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsDisplayedIsEnabledAndIsSelected {

	public static void main(String[] args) {

		// set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// maximize chrome browser window
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// used this URL for isEnable test
		driver.get("https://www.glassdoor.co.in/index.htm");
		
		// used this URL for isDisplayed and isSelected
		driver.get("https://register.freecrm.com/register/");
		
		// 1. isDisplayed() method : Applicable for all the elements
		boolean b1 = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
		System.out.println(b1); // true
		
		// 2. isEnabled() method
		boolean b2 = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
		System.out.println(b2); // false
		
		// fill username and password
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("test1234");
		
		// now check Continue with Email is enable or not
		boolean b3 = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
		System.out.println(b3); // true
		
		// 3. isSelected() method: only applicable for checkbox, dropdown, radiobutton
		boolean b4 = driver.findElement(By.xpath("//input[@id='terms']")).isSelected();
		System.out.println(b4); // false
		
		// now click on checkbox then check isSelected
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		boolean b5 = driver.findElement(By.xpath("//input[@id='terms']")).isSelected();
		System.out.println(b5); // true
		
		// now de-select checkbox and check isSelected()
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		boolean b6 = driver.findElement(By.xpath("//input[@id='terms']")).isSelected();
		System.out.println(b6); // false
	}

}
