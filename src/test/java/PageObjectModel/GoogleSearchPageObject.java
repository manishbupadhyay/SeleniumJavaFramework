package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObject {
	
	WebDriver driver = null;
	
	By textbox_search = By.name("q");
	By button_search = By.name("btnK");
	
	// constructor
	public GoogleSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);
	}

}
