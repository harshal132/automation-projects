package com.plp.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
import com.automation.utils.CompareProducts;
import com.automation.utils.SearchProduct;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompareProductsTest {
	WebDriver driver;
	SearchProduct search;
	int numTest=0;
	CompareProducts compare;
	Object[][] values;
	
	//TC_ProductComparison_001
  @Test
  public void AddtoCompareTest() throws InterruptedException {
	  search.SearchProductFunc("HP LP3065");
	  compare.AddProdToCompare();
	  if(!compare.CheckCompareSucc())
	  {
		  Assert.fail("Product is not added to Compare");
	  }
 }
	
	//TC_ProductComparison_003
	@Test(dataProvider="productnavigation")
	public void CompareNumtest(String productName) throws InterruptedException
	{
		  search.SearchProductFunc(productName);
		  compare.AddProdToCompare();
		  Thread.sleep(1500);
		  numTest = numTest+1;
		  if(!compare.TotalCompare().contains("Compare ("+numTest+")"))
		  {
			  Assert.fail(numTest+" products are not getting added to the compare list");
		  }	   
	}
	
	//TC_ProductComparison_004
	@Test
	public void CartFunc() throws InterruptedException
	{
		  search.SearchProductFunc("HP LP3065");
		  compare.AddProdToCompare();
		  compare.ShowCompare();
		  compare.AddFromCompareProd();
		  search.AddProdCart();
		  if(!search.CheckAddCartSuccess())
		  {
			  Assert.fail("Product is not added to the cart");
		  }
	}
	 
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.navigate().to("https://demo.opencart.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  search=new SearchProduct(driver);
	  PageFactory.initElements(driver,search);
	  compare=new CompareProducts(driver);
	  PageFactory.initElements(driver,compare);
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  driver.quit();
  }
  
  @DataProvider(name="productnavigation")
  public Object[][] dataSource() throws IOException
  {
	  FileInputStream file = new FileInputStream(new File("ProductNavigation.xlsx")); 
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		values=new Object[rowcount+1][1];
		for(int i=0;i<=rowcount;i++)
		{
			Row  row=sheet.getRow(i);
			values[i][0]=row.getCell(0).toString();
		}
		wb.close();
	  return values;
	  
  }
}
