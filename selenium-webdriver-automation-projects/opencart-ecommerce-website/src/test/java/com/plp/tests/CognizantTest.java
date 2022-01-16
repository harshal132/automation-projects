package com.plp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CognizantTest {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.edgedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.capgemini.com/");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.id("macs_cookies_accept_all")).click();
		wait = new WebDriverWait(driver,15);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void menuAndSubMenuTest() {
		SoftAssert aAssert = new SoftAssert(); // --- soft assert
		//aAssert.assertAll(); -- Assert all failures at end of execution
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Industries"))).perform();
		
		action.keyDown(Keys.CONTROL).sendKeys("N").build().perform();
		driver.findElement(By.linkText("Insurance")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Services")));
		if(driver.getTitle().contains("Insurance")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Invalid Title displayed");
		}
	}

	@Test
	public void selectCountryDropdownTest() throws InterruptedException {
		driver.findElement(By.linkText("Job search")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Partners"))));
		System.out.println(driver.getCurrentUrl());
		scroll(driver,0,300);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@data-name='filter_country']"))));
		Select select = new Select( driver.findElement(By.xpath("//select[@data-name='filter_country']")));
		select.selectByValue("india");
		Thread.sleep(3000);
		scroll(driver,0,200);
		String result = driver.findElement(By.cssSelector("h2.section__regular-title")).getText();
		result = result.replaceAll("[^0-9]", "");
		System.out.println("Total Jobs found for Selected Country = "+result);
	}
	
	public void scroll(WebDriver driver, int x, int y) {
		((JavascriptExecutor) driver).executeScript("scroll("+x+",+"+y+")");
	}
}
