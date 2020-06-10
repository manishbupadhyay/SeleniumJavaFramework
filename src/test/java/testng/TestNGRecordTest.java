package testng;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestNGRecordTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	WebDriverManager.chromedriver().setup();  
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase1() throws Exception {
    driver.get("https://opensource-demo.orangehrmlive.com/");
    driver.findElement(By.id("txtUsername")).clear();
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("txtUsername")).click();
    driver.findElement(By.id("divLoginImageContainer")).click();
    driver.findElement(By.id("frmLogin")).click();
    driver.findElement(By.id("txtPassword")).click();
    driver.findElement(By.id("divLoginImageContainer")).click();
    driver.findElement(By.id("btnLogin")).click();
    driver.findElement(By.xpath("//div[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td/div/a/img")).click();
    driver.findElement(By.id("assignleave_txtEmployee_empName")).click();
    driver.findElement(By.id("assignleave_txtEmployee_empName")).clear();
    driver.findElement(By.id("assignleave_txtEmployee_empName")).sendKeys("Ma");
    driver.findElement(By.xpath("//div[6]/ul/li")).click();
    driver.findElement(By.id("assignleave_txtLeaveType")).click();
    new Select(driver.findElement(By.id("assignleave_txtLeaveType"))).selectByVisibleText("Vacation US");
    driver.findElement(By.id("assignleave_txtLeaveType")).click();
    driver.findElement(By.xpath("//form[@id='frmLeaveApply']/fieldset/ol/li[4]/img")).click();
    driver.findElement(By.linkText("15")).click();
    driver.findElement(By.xpath("//form[@id='frmLeaveApply']/fieldset/ol/li[5]/img")).click();
    driver.findElement(By.linkText("26")).click();
    driver.findElement(By.id("assignleave_partialDays")).click();
    new Select(driver.findElement(By.id("assignleave_partialDays"))).selectByVisibleText("All Days");
    driver.findElement(By.id("assignleave_partialDays")).click();
    driver.findElement(By.id("assignleave_txtComment")).click();
    driver.findElement(By.id("assignleave_firstDuration_duration")).click();
    new Select(driver.findElement(By.id("assignleave_firstDuration_duration"))).selectByVisibleText("Specify Time");
    driver.findElement(By.id("assignleave_firstDuration_duration")).click();
    driver.findElement(By.id("assignleave_firstDuration_duration")).click();
    new Select(driver.findElement(By.id("assignleave_firstDuration_duration"))).selectByVisibleText("Half Day");
    driver.findElement(By.id("assignleave_firstDuration_duration")).click();
    driver.findElement(By.id("assignleave_firstDuration_ampm")).click();
    driver.findElement(By.id("assignleave_firstDuration_ampm")).click();
    driver.findElement(By.id("assignleave_txtComment")).click();
    driver.findElement(By.id("assignleave_txtComment")).clear();
    driver.findElement(By.id("assignleave_txtComment")).sendKeys("Annual leave");
    driver.findElement(By.id("assignBtn")).click();
    driver.findElement(By.id("confirmOkButton")).click();
    driver.findElement(By.id("welcome")).click();
    driver.findElement(By.linkText("Logout")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
