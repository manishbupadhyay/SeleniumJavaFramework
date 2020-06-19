package HeadLessBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverConcept {

	public static void main(String[] args) {

		WebDriver driver = new HtmlUnitDriver();

		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Automation");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

		driver.close();
		driver.quit();

		System.out.println("Test completed successfull !!");

	}

}
