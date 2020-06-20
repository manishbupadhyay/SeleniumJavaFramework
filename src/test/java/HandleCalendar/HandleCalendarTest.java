package HandleCalendar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCalendarTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://jqueryui.com/resources/demos/datepicker/dropdown-month-year.html"); // enter URL

		// click on calendar link
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		// click on 20 june
		//driver.findElement(By.xpath("//td//a[text()='20']")).click();
		//driver.switchTo().frame("mainpanel");


		String date = "30-Jun-2020"; 
		String dateArr[] = date.split("-"); // {30,June,2020} 
		String day = dateArr[0]; 
		String month = dateArr[1];
		String year = dateArr[2];

		Select select = new Select(driver.findElement(By.xpath("//select[@data-handler='selectMonth']")));
		select.selectByVisibleText(month);

		Select select1 = new Select(driver.findElement(By.xpath("//select[@data-handler='selectYear']")));
		select1.selectByVisibleText(year);

		//*[@class='ui-datepicker-calendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@class='ui-datepicker-calendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@class='ui-datepicker-calendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]

		String beforeXpath = "//*[@class='ui-datepicker-calendar']/table/tbody/tr[2]/td/table/tbody/tr["; 
		String afterXpath = "]/td[";

		final int totalWeekDays = 7;

		//2-1 2-2 2-3 2-4 2-5 2-6 2-7 //3-2 3-2 3-3 3-4 3-5 3-6 3-7 
		boolean flag = false; 
		String dayVal = null; for(int rowNum=2; rowNum<=7; rowNum++){

			for(int colNum = 1; colNum<=totalWeekDays; colNum++){ 
				try{ 
					dayVal =driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText(); 
				}catch (NoSuchElementException e)
				{
					System.out.println("Please enter a correct date value"); 
					flag = false; 
					break;
				} 
				System.out.println(dayVal); 
				if(dayVal.equals(day)){
					driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click(); 
					flag = true; 
					break; 
				} 
			} 
			if(flag)
			{ 
				break; 
			}

		}



	}
}
