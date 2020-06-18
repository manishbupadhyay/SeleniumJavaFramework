package BrowserPopUpWindow;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserPopUpWindow {

	public static void main(String[] args) throws Exception {

		// set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://recruit.hirebridge.com/v3/careercenter/v2/details.aspx?jid=524050&cid=7601&locvalue=1013&source=Glassdoor");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='buttons']//a[contains(text(),'Apply')]")).click();

		Thread.sleep(2000);

		// now there are two browser window parent and child window
		Set<String> handler = driver.getWindowHandles();

		// now we need to use iterator
		Iterator<String> it = handler.iterator();

		// now find parent window id
		String parentWindowId = it.next();
		System.out.println("Parent Window Id : " + parentWindowId);

		// find child window id
		String childWindowId = it.next();
		System.out.println("Child Window Id : " + childWindowId);

		// now switch to child window
		driver.switchTo().window(childWindowId);

		Thread.sleep(2000);

		// get browser title of child window
		System.out.println("Child Browser title : " + driver.getTitle());

		// close child browser window
		driver.close(); // don't use driver.quit() other wise it will close both the windows

		// again switch to parent browser window
		driver.switchTo().window(parentWindowId);

		Thread.sleep(2000);

		// get browser title of parent window
		System.out.println("Parent Browser title : " + driver.getTitle());
		
		driver.close();
		driver.quit();
		
		System.out.println("Test executed successfully");
	}

}
