package HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeCRMLoginTest {

	public static void main(String[] args) throws Exception {
		
		// set up driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/");
		driver.manage().window().maximize();
		
		String customerCrediantials = Data.getUserLoginInfo().get("customer");
		String [] customerInfo = customerCrediantials.split("_");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(customerInfo[0]);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(customerInfo[1]);
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(Data.monthMap().get(10));
		
		Thread.sleep(5000);
		driver.close();

	}

}
