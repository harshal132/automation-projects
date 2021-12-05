package com.plp.tests;

import org.testng.annotations.Test;
import com.automation.utils.FlipkartLocators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class FlipkartTest {
	WebDriver driver;
	FlipkartLocators locator;
  @Test
  public void closePopupTest() {
	  locator = new FlipkartLocators(driver);
	  locator.closeLoginPopup();
	  System.out.println(driver.getTitle());
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.firefoxdriver().setup();
	  //driver=new ChromeDriver();
	  driver = new FirefoxDriver();
	  driver.get("https://www.flipkart.com/");
	  //driver.navigate().to("https://demo.opencart.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

}
