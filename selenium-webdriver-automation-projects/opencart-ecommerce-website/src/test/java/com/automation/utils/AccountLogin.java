package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogin {
	
	WebDriver driver;
	
	@FindBy(id="input-email")
	WebElement Email;
	
	@FindBy(id="input-password")
	WebElement Password;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement Submit;
	
	public void EnterEmail(String email) 
	{
		Email.sendKeys(email);
		
		
	}
	
	public void EnterPassword(String password) 
	{
		Password.sendKeys(password);
		
	}
	
	public void ClickSubmit() 
	{
		Submit.submit();
		
	}
	
	
	
	public AccountLogin(WebDriver driver) {
		this.driver=driver;
	}
}