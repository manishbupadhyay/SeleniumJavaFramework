package SingletonPatternDesign;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMTest {

	@BeforeMethod
	public void setUp() {
		TestBase.initialize();
	}
	
	@Test(priority=1)
	public void verifyFreeCRMTitleText() {
	 String title = TestBase.driver.getTitle();
	 System.out.println("Title of Free CRM page is : " + title);
	 Assert.assertEquals(title, Constants.pageTitleText);
	}
	
	@Test(priority=2)
	public void logoTest() {
		Assert.assertEquals(TestBase.driver.findElement(By.className("img-responsive")).isDisplayed(), true);
	}

	
	@AfterMethod
	public void tearDown() {
		TestBase.quit();
	}
}
