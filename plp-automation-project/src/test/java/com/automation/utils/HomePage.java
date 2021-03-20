package com.automation.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement MyAccount;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement Login;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[5]/a")
	WebElement checkOutLink;
	
	public void ClickMyAccount() 
	{
		MyAccount.click();
	}
	
	public void ClickLogin() 
	{
		Login.click();
	}
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void ClickCheckOutLinkHP() {
		checkOutLink.click();
	}
}