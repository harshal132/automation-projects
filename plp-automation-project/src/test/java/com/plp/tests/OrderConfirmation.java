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

public class OrderConfirmation {
	WebDriver driver;
	HomePage homePage;
	AccountLogin accLogin;
	MyAccount searchProd;
	AddToCartPage add;
	CheckoutPage checkOut;
	ExplicitWaitMethods waiter;
	@Test
	public void TC_ConfirmOrder_001() throws InterruptedException {

		  placeOrder(); // Place Complete Order
		  waiter.waitForOrderPlacement(driver);
		  String Msg=driver.getTitle();
		  checkOut.ClickFContinue();
		  Assert.assertEquals(Msg,"Your order has been placed!");		  
	  }

	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		  
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.navigate().to("http://demo.opencart.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		  CompleteLogin(); /// Complete Login
		  
		  searchProd=new MyAccount(driver);
		  PageFactory.initElements(driver,searchProd);
		  addToCartProcess("HP LP3065"); // Add To Cart
		  add.ClickCheckout();
		  checkOut=new CheckoutPage(driver);
		  PageFactory.initElements(driver,checkOut);
		  waiter=new ExplicitWaitMethods();
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
	  
	  private void CompleteLogin() {
		  homePage=new HomePage(driver);
		  PageFactory.initElements(driver, homePage);
		  homePage.ClickMyAccount();
		  homePage.ClickLogin();
		  accLogin=new AccountLogin(driver);
		  PageFactory.initElements(driver, accLogin);
		  accLogin.EnterEmail("radhakumari@gmail.com");
		  accLogin.EnterPassword("radha");
		  accLogin.ClickSubmit();
	  }
	  
	  private void addToCartProcess(String productName) {
		    searchProd.SearchProduct(productName);
		    searchProd.AddToCartClick();
		    add=new AddToCartPage(driver);
		    PageFactory.initElements(driver,add);
		    add.FinalAddToCart();
	  }
	  
	  private void placeOrder() throws InterruptedException 
	  {
		  checkOut.ClickContine1();
		  checkOut.ClickContine2();
		  checkOut.WriteShippingComments("Shipping Method Comments");  
		  checkOut.ClickContine3();
		  checkOut.WritePaymentComments("Payment Method Comments");
		  checkOut.CheckTerms();
		  checkOut.ClickContine4();
		  checkOut.ClickConfirmOrder();
	  }

}
