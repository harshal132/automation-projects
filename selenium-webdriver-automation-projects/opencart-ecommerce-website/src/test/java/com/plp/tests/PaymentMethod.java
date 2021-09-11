package com.plp.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.automation.utils.AccountLogin;
import com.automation.utils.AddToCartPage;
import com.automation.utils.CheckoutPage;
import com.automation.utils.HomePage;
import com.automation.utils.MyAccount;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PaymentMethod {
		WebDriver driver;
		HomePage homePage;
		AccountLogin accLogin;
		MyAccount searchProd;
		AddToCartPage add;
		CheckoutPage checkOut;
		
		@Test
		public void TC_PaymentMethod_001() throws InterruptedException {
			
			  navigateToPaymentMethod();
			  checkOut.ClickContine4();
			  WebElement checkTerms;
			  checkTerms=driver.findElement(By.xpath("//*[@id='collapse-payment-method']/div/div[1]"));
			  if(!checkTerms.isDisplayed())
			  {
				  Assert.fail("Website Allowing User To Continue without Agreeing to Terms & Conditions");
			  }
		}
		
		@Test
		public void TC_PaymentMethod_002() throws InterruptedException 
		{
			  driver.navigate().refresh();
			  navigateToPaymentMethod();
			  checkOut.CheckTerms();
			  checkOut.ClickContine4();
			  if (!checkOut.isConfirmOrderActive()) 
			  {
				  Assert.fail("User is Not navigated to Confirm Order Section After Clicking on Continue Button on Payment Method Section");
			  }
		}

		  @BeforeClass
		  public void beforeClass() throws InterruptedException {
			  
			  WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
			  driver.navigate().to("http://demo.opencart.com");
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			  
			  CompleteLogin(); // Complete Procedure for Login
			  
			  searchProd=new MyAccount(driver);
			  PageFactory.initElements(driver,searchProd);
			  addToCartProcess("HP LP3065");
			  add.ClickCheckout();
			  checkOut=new CheckoutPage(driver);
			  PageFactory.initElements(driver,checkOut);  
		  }

		  public void CompleteLogin() {
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
		  
		  public void addToCartProcess(String productName) {
			    searchProd.SearchProduct(productName);
			    searchProd.AddToCartClick();
			    add=new AddToCartPage(driver);
			    PageFactory.initElements(driver,add);
			    add.FinalAddToCart();
		  }
		  
		  public void navigateToPaymentMethod() throws InterruptedException 
		  {
			  checkOut.ClickContine1();
			  checkOut.ClickContine2();
			  checkOut.WriteShippingComments("Shipping Method Comments");  
			  checkOut.ClickContine3();
			  checkOut.WritePaymentComments("Payment Method Comments");
		  }

		@AfterClass
		  public void afterClass() {
			  driver.quit();
		  }		
}
