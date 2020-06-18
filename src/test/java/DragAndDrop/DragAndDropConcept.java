package DragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	public static void main(String[] args) throws Exception {
		// set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// maximize chrome browser window
		driver.manage().window().maximize();

		// delete/cookies
		//driver.manage().deleteAllCookies();

		// open OrangeHRM login page
		driver.get("https://jqueryui.com/droppable/");
		
		// switch to frame
		driver.switchTo().frame(0);
		
		// Actions classs
		Actions actions = new Actions(driver);
		
		// click on dragable element, hold, move to dropable element then release
		actions.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']")))
		.moveToElement(driver.findElement(By.xpath("//div[@id='droppable']")))
		.release()
		.build()
		.perform();
		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
	}

}
