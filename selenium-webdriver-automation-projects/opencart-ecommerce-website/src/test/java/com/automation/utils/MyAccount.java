package com.automation.utils;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount {
	WebDriver driver;
	
	@FindBy(name="search")
	WebElement Search;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]")
	WebElement AddtoCart1;
	
	public void SearchProduct(String product) 
	{
		Search.sendKeys(product);
		Search.sendKeys(Keys.ENTER);
	}
	public void AddToCartClick() 
	{
		AddtoCart1.click();
	}
	public MyAccount(WebDriver driver) {
		this.driver=driver;
	}
}