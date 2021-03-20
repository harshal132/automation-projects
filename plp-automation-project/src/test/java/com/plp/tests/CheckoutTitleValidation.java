package com.plp.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.automation.utils.AccountLogin;
import com.automation.utils.AddToCartPage;
import com.automation.utils.CheckoutPage;
import com.automation.utils.ExplicitWaitMethods;
import com.automation.utils.HomePage;
import com.automation.utils.MyAccount;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutTitleValidation {
	WebDriver driver;
	HomePage homePage;
	AddToCartPage add;
	AccountLogin accLogin;
	CheckoutPage checkOut;
	MyAccount searchProd;
	ExplicitWaitMethods waiter;
  @Test(priority=1)
  public void TC_Checkout_001() throws InterruptedException {
	  homePage.ClickCheckOutLinkHP();
	  waiter.waitForCheckoutPage(driver);
	  Assert.assertEquals(driver.getTitle(), "Shopping Cart");
  }
  
  @Test(priority=2)
  public void TC_Checkout_002() throws InterruptedException {
	  addProductToCart("HP LP3065");
	  homePage.ClickCheckOutLinkHP();
	  waiter.waitForCheckoutPage(driver);
	  Assert.assertEquals(driver.getTitle(), "Checkout");
  }
  
@BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  waiter=new ExplicitWaitMethods();
	  driver=new ChromeDriver();
	  driver.navigate().to("https://demo.opencart.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  homePage=new HomePage(driver);
	  PageFactory.initElements(driver, homePage);
	  
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  driver.quit();
  }
  
  private void addProductToCart(String productName) {
	  searchProd=new MyAccount(driver);
	  PageFactory.initElements(driver,searchProd);
	  searchProd.SearchProduct(productName);
	  searchProd.AddToCartClick();
	  add=new AddToCartPage(driver);
	  PageFactory.initElements(driver,add);
	  add.FinalAddToCart();
  }
  
}
