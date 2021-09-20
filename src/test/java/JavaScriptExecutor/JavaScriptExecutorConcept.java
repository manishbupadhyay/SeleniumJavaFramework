package JavaScriptExecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws IOException, Exception {
		
		// set up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// maximize chrome browser window
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com/index.html");

		//driver.findElement(By.xpath("//a//span[text()='Log In']//preceding-sibling::span[@class='icon icon-xs mdi-chart-bar']")).click();
		//WebElement loginButton = driver.findElement(By.xpath("//a//span[text()='Log In']//preceding-sibling::span[@class='icon icon-xs mdi-chart-bar']"));
		WebElement loginButton = driver.findElement(By.xpath("//a[normalize-space()='Sign Up']"));

		// call JavascriptExecutor Method
		flash(loginButton, driver);

		// call draw method to draw a red border around Sign Up button
		drawBorder(loginButton, driver);

		// take screenshot
		//Take screenshot
		File screenshotFile  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(screenshotFile , new File("/SeleniumJavaFramework/src/test/java/JavaScriptExecutor/SignUp.png"));

		generateAlert(driver,"There is an issue in Sign Up button");

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

		alert.accept(); // click on ok

		Thread.sleep(5000);

		clickElementByJS(loginButton, driver);

		// page refresh using selenium
		driver.navigate().refresh();

		// page refresh using JavascriptExecutor
		refreshBrowserByJS(driver);

		// get page title by JavascriptExecutor
		System.out.println(getTitleByJS(driver));


		// get the page text
		System.out.println(getPageInnerText(driver));

		// scroll page down
		scrollPageDown(driver);

		// find term & condition element
		WebElement termOfUse = driver.findElement(By.xpath("//a[normalize-space()='Terms & Conditions']"));

		// call scroll into view method to keep scrolling until find term of use link
		scrollIntoView(termOfUse, driver);

		driver.close();
		driver.quit();
	}

	// JavascriptExecutor Method
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgColor = element.getCssValue("backgroundColor");
		for(int i = 0; i < 100; i++) {
			changeColor("rgb(0, 200, 0)", element, driver); // rgb(0, 0, 255) for Blue color
			changeColor(bgColor, element, driver);

		}
	}

	public static void changeColor(String color,WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "' ", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// draw border around Sign Up button
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border= '5px solid red'", element);
	}

	// Generate alert on runtime
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+ message +"')");
	}

	// click on button
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	// refresh page by JavascriptExecutor
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	// get browser title by JavascriptExecutor
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	// get the page text
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	// page scroll
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	// scroll and view an element
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

}
