package com.automation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertVisibility {
	WebDriver driver;
	public AlertVisibility(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isAlertVisible() {
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver,10);
		if(wait.until(ExpectedConditions.alertIsPresent())==null) {
			System.out.println("alert was not present");
			return true;
		}   
		else {
			System.out.println("alert was present");
			return false;
		}
		   
	}
	
	public void fluentWaitSyntax() {
		Wait wait = new FluentWait(driver)
				.withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(4, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
	}
}
