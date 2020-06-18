package FileUploadPopup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFileUploadPopup {

	public static void main(String[] args) {
		// set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// maximize chrome browser window
		driver.manage().window().maximize();

		driver.get("https://html.com/input-type-file/");

		// below - don't use .click() because as we know selenium can not handle windows popup so sendKey and put your file location and name
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:/Users/Ayan/Downloads/Manish_Passport_size_photo.jpg");
	}

}
