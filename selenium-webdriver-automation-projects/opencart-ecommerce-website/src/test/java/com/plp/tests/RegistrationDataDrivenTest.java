package com.plp.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationDataDrivenTest {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void registrationWithExcel() throws IOException {
	  	FileInputStream file = new FileInputStream(new File("registration-details.xlsx")); 
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount=sheet.getPhysicalNumberOfRows();
		int columncount = sheet.getRow(0).getLastCellNum();
		System.out.println("Rows = "+rowcount+ "Column = "+columncount);
		System.out.println(sheet.getRow(0).getCell(2).toString());  // -- access elements one by one
		
		//# Multiple Registrations
		//String detailsArray[][] = new String[rowcount-1][columncount];
		String firstName[] = new String[rowcount-1];
		String lastName[] = new String[rowcount-1];
		String emailId[] = new String[rowcount-1];
		String telephone[] = new String[rowcount-1];
		String password[] = new String[rowcount-1];
		for(int i = 0; i<rowcount-1; i++) {
		  firstName[i] = sheet.getRow(i).getCell(0).toString();
		  lastName[i] = sheet.getRow(i).getCell(1).toString();
		  emailId[i] = sheet.getRow(i).getCell(2).toString();
		  telephone[i] = sheet.getRow(i).getCell(3).toString();
		  password[i] = sheet.getRow(i).getCell(4).toString();
		}
		
		for(int counter = 0; counter<rowcount-1; counter++) {
		  System.out.println("Execution for User "+counter);
		  driver.findElement(By.name("firstname")).sendKeys(firstName[counter]); //firstname
		  driver.findElement(By.name("lastname")).sendKeys(lastName[counter]); //lastname
		  driver.findElement(By.name("email")).sendKeys(emailId[counter]); //email
		  driver.findElement(By.name("telephone")).sendKeys(telephone[counter]); //telephone
		  
		  driver.findElement(By.name("password")).sendKeys(password[counter]); //password
		  driver.findElement(By.name("confirm")).sendKeys(password[counter]); //confirm password
		  
		  driver.findElement(By.name("agree")).click(); //checkbox
		  driver.findElement(By.cssSelector("input.btn.btn-primary")).submit();
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content > p:nth-child(2)")));
		  System.out.println(driver.findElement(By.cssSelector("#content > p:nth-child(2)")).getText());
		  
		  driver.findElement(By.cssSelector("li.dropdown > a[title='My Account']")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
		  
		  driver.findElement(By.linkText("Logout")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#content > h1")));
		  System.out.println("Title = "+driver.getTitle());
		  
		  driver.findElement(By.cssSelector("li.dropdown > a[title='My Account']")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
		  
		  driver.findElement(By.linkText("Register")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#content > h1")));
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
	  wait = new WebDriverWait(driver,15);
	  
	  driver.findElement(By.cssSelector("li.dropdown > a[title='My Account']")).click();
	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
	  
	  driver.findElement(By.linkText("Register")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#content > h1")));
	  System.out.println("Title = "+driver.getTitle());
	  
  }
  @AfterClass
  public void afterClass() throws InterruptedException {
	  driver.quit();
  }
}
