package com.plp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchingBetweenTabs {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("headphones"+Keys.ENTER);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/descendant::span[@class='a-size-medium a-color-base a-text-normal'][1]")).click();
		Thread.sleep(4000);
		String mainWindow = driver.getWindowHandle();
		for(String window: driver.getWindowHandles()) {
			System.out.println("Window Names: "+window);
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				System.out.println("Title on tab:"+window+ " is "+driver.getTitle());
			}
		}
		driver.close();
		driver.switchTo().window(mainWindow);
		driver.quit();
	}

}
