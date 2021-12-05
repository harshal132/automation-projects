package com.plp.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automation.utils.SearchProduct;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ProductPageValidation {
	WebDriver driver;
	SearchProduct search;
	
	
  //TC_ProductPage_001
  @Test(dataProvider="productnavigation")
  public void ProductNavigation(String productName) throws InterruptedException
  {
	  search.SearchProductFunc(productName);
	  search.OpenProductDetails();
	  Assert.assertEquals(productName,driver.getTitle());
  }
  
	//TC_ProductPage_002
  @Test(dataProvider="productnavigation")
  public void verifyDescription(String productName) throws InterruptedException
  {
	  search.SearchProductFunc(productName);
	  search.OpenProductDetails();
	  String result=search.CheckDesc();
	  if(!result.equals("active"))
	  {
		  Assert.fail("Description Field is Not Active");
	  }
	  
  }
  
	
	//TC_ProductPage_003
  @Test(dataProvider="productnavigation")
  public void verifySpecification(String productName) throws InterruptedException
  {
	  search.SearchProductFunc(productName);
	  search.OpenProductDetails();
	  String linkText= search.ClickSpecs();
	  String result=search.CheckSpecs();
	  if(!(result.equals("active") && linkText.equals("Specification")))
	  {
		  Assert.fail("Specification field Not Active");
	  }
  }
	
	//TC_ProductPage_007
	@Test(dataProvider="productnavigation")
	public void VerifyReviews(String productName) throws InterruptedException
	{
		search.SearchProductFunc(productName);
		search.OpenProductDetails();
		search.CheckReviews();
		String result=search.ShowReviews();
		if(result.contains("There are no reviews for this product."))
		{
			Assert.fail("Reviews are not available");
		}	
	}
	
	//TC_ProductPage_008
	@Test(dataProvider="productnavigation")
	public void ReviewFunc(String productName) throws InterruptedException
	{
		search.SearchProductFunc(productName);
		search.OpenProductDetails();
		search.CheckReviews();
		search.EnterReviewerName("Harshal Chavan");
		search.Enter_Review("Product is good. Fast Delivery Etc etc");
		search.SendRatings();
		search.SendReview();
		if(!search.CheckSuccessAlert())
		{
			Assert.fail("Success Message is not displayed");
		}
	}
	
	
	//TC_ProductPage_009
	@Test
	public void VerifyFields() throws InterruptedException
	{
		search.SearchProductFunc("HP LP3065");
		search.OpenProductDetails();
		search.CheckReviews();
		search.EnterReviewerName("Harsh3938");
		search.Enter_Review("Product is good. Fast Delivery Etc etc Maza aa gaya bhai full maje le raha hai me");
		search.SendRatings();
		search.SendReview();
		if(search.CheckSuccessAlert())
		{
			Assert.fail("First Name Field is Accepting Numeric Data");
		}
	}
	
	
	//TC_ProductPage_010
	@Test(dataProvider="productnavigation")
	public void VerifyAddToCart(String productName) throws InterruptedException
	{
		search.SearchProductFunc(productName);
		search.OpenProductDetails();
		search.AddProdCart();
		if(!search.CheckAddCartSuccess())
		{
			Assert.fail("Product is not added to the cart");
		}
	}
	
	//TC_ProductPage_013
	@Test 
	public void verifyMandatoryFields() throws InterruptedException
	{
		search.SearchProductFunc("HP LP3065");
		search.OpenProductDetails();
		search.CheckReviews();
		search.EnterReviewerName("Harsh3938");
		search.SendRatings();
		search.SendReview();
		if(!search.CheckReviewMissing())
		{
			Assert.fail("Review Missing is not Displayed");
		}
	}
	
	
	//TC_ProductPage_011
	@Test
	public void CartAddDate() throws InterruptedException
	{
		search.SearchProductFunc("HP LP3065");
		search.OpenProductDetails();
		search.EnterDeliveryDate("2012-01-01");
		search.AddProdCart();
		if(search.CheckAddCartSuccess())
		{
			Assert.fail("Website is accepting previous delivery date");
		}
		else 
		{
			Assert.assertTrue(true);
		}
	}
	
	//Test Case - 012
	@Test
	public void verifyQuantity() throws InterruptedException
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		now.plusWeeks(2);
		String futureDate= dtf.format(now);
		search.SearchProductFunc("HP LP3065");
		search.OpenProductDetails();
		search.EnterDeliveryDate(futureDate); // 2030-11-11
		search.EnterProdQuantity("0");
		search.AddProdCart();
		if(search.CheckAddCartSuccess())
		{
			Assert.fail("Success Message is displayed Even without valid quantity");
		}
	}

  @BeforeClass
  public void beforeClass(){
	  
	  //System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://demo.opencart.com");
	  //driver.navigate().to("https://demo.opencart.com");
	  driver.manage().window().maximize();
	  
	  //implicit wait syntax
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	  search=new SearchProduct(driver);
	  PageFactory.initElements(driver,search);
  }
  
  @DataProvider(name="productnavigation")
  public Object[][] dataSource() throws IOException
  {
	  FileInputStream file = new FileInputStream(new File("ProductNavigation.xlsx")); 
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		Object[][] values=new Object[rowcount+1][1];
		//getWindowHandle() - String id
		//List<WebElement> abcd = driver.findElements(By.xpath(""));
		//int rows = abcd.size();
		//getWindowHandles() - Set
		for(int i=0;i<=rowcount;i++)
		{
			Row  row=sheet.getRow(i);
			values[i][0]=row.getCell(0).toString();
		}
		wb.close();
	  return values;
	  
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  driver.quit();
  }

}

