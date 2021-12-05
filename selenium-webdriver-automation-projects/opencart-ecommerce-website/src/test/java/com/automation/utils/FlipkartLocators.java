package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartLocators {
	WebDriver driver;
	By loginPopup = By.cssSelector("button._2KpZ6l._2doB4z");
	public FlipkartLocators(WebDriver driver) {
		this.driver = driver;
	}
	public void closeLoginPopup() {
		driver.findElement(loginPopup).click();
	}
}
