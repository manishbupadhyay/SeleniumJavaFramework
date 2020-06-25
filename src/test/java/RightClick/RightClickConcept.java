package RightClick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {
	public static void main(String[] args) {
		
		// set browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		WebElement rightClickButton = driver.findElement(By.xpath("//p//span[text()='right click me']"));
		action.contextClick(rightClickButton).build().perform();
		
		WebElement copy = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		
		String copyText = copy.getText();
		
		System.out.println(copyText);
		
		copy.click();
	}

}
