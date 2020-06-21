package FindBrokenLinksAndImages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksAndImagesTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://freecrm.co.in/");
		
		// 1. Get the list of all the links and images
		// as we know links are in a href tag and images are in img href
		
		List<WebElement> linkedList = driver.findElements(By.tagName("a"));
		linkedList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Size of full links and images ------> " + linkedList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2. Iterate linkedlist : exclude all the links/images who doesn't have any href attribute
		for(int i=0; i<linkedList.size(); i++) {
			System.out.println(linkedList.get(i).getAttribute("href"));
			if(linkedList.get(i).getAttribute("href") !=null && (linkedList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linkedList.get(i));
			}
		}
		
		// get the size of active links list
		System.out.println("Size of active links and images -----> " + activeLinks.size());
		
		// 3. check the href, url, with httpconnection api
		// 200 -- ok
		// 404 -- not found
		// 500 -- internal error
		// 400 -- bad request
		
		for(int j=0; j<activeLinks.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "----->" + response);
		}
		
	}
}
