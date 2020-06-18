package MouseMovement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovementConcept {

	public static void main(String[] args) throws Exception {
		// set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// maximize chrome browser window
		driver.manage().window().maximize();
		
		// delete/cookies
		driver.manage().deleteAllCookies();
		
		// open OrangeHRM login page
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		// Find username textbox and Enter username
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		
		// Find password textbox and Enter password
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		
		// Find login button and click
		driver.findElement(By.xpath("//input[@id='btnLogin']")).sendKeys(Keys.RETURN);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("menu_admin_UserManagement"))).build().perform();
		
		Thread.sleep(5000);
		driver.findElement(By.linkText("Users")).click();
		
		driver.close();
		driver.quit();

	}

}
