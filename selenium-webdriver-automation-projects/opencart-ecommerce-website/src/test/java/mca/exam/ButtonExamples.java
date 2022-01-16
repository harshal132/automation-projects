package mca.exam;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonExamples {
	static WebDriver driver;
	WebDriverWait wait;
  @Test
  public void exampleTest() {
	  WebElement yesRadioButton;
	  WebElement noRadioButton;
	  
	  driver.findElement(By.name("firstname")).sendKeys("Harshal");
	  driver.findElement(By.name("lastname")).sendKeys("Chavan");
	  driver.findElement(By.name("email")).sendKeys("testmail@yopmail.com");
	  driver.findElement(By.name("telephone")).sendKeys("8454070574");
	  
	 driver.findElement(By.name("password")).sendKeys("Test@123");
	 driver.findElement(By.name("confirm")).sendKeys("Test@123");
	 yesRadioButton = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
	 yesRadioButton.click();
	 System.out.println("Yes Radio Button Text = "+driver.findElement(By.cssSelector("label.radio-inline")).getText());
	 noRadioButton = driver.findElement(By.xpath("//input[@name='newsletter' and @value='0']"));
	 noRadioButton.click();
	 yesRadioButton.click();
	 
	 driver.findElement(By.name("agree")).click();
	 driver.findElement(By.cssSelector("input.btn.btn-primary")).submit();
  }
  
  @BeforeTest
  public void setup() throws InterruptedException {
  	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://demo.opencart.com/index.php?route=account/register");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver,10);
	Thread.sleep(3000);
  }
  
  @AfterTest()
  public void tearDown() throws InterruptedException{
	  Thread.sleep(3000);
	  driver.quit();
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("After Class Invoked");
  }
  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite Invoked");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class Invoked");
  }
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite Invoked");
  }
  
}
