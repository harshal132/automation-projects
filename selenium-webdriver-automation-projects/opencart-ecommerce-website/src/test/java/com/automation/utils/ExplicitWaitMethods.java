package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitMethods {
	WebDriverWait wait;
	
	public void waitForCheckoutPage(WebDriver driver) {
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.urlContains("checkout"));
	}
	
	public void waitForOrderPlacement(WebDriver driver) {
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.urlContains("checkout/success"));
	}

}
