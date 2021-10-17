package com.plp.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class HoverMouseAction {

	@Test
	public void verifyMouseHoverAction() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/");
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		
		Actions ac = new Actions(driver);
		WebElement live= driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='Live']"));
		ac.moveToElement(live).perform(); // hover action
		//ac.moveToElement(live).build();
		Thread.sleep(10000);
		WebElement automate= driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='App Automate']"));
		ac.moveToElement(automate).perform();
		//automate.click();
		Thread.sleep(10000);
		driver.quit();
	}

}
