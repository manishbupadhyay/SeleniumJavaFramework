package AutoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://tinyupload.com/");
		driver.findElement(By.name("uploaded_file")).click();
		
		// call autoIT script
		Runtime.getRuntime().exec("C:\\AutoITSelenium\\FileUploadScript.exe");
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
