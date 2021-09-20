package BarCode;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarCodeTest {
	
	@Test
	public void barCodeConcept() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/SeleniumJavaFramework/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://barcode.tec-it.com/en");
		
		String barCodeURL = driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(barCodeURL);
		
		URL url = new URL(barCodeURL);
		BufferedImage bufferedImage = ImageIO.read(url);
		
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result = new MultiFormatReader().decode(binaryBitmap);
		
		System.out.println(result.getText());
		Thread.sleep(20000);
		driver.close();
		driver.quit();
	}

}
