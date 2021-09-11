package com.automation.utils;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage {
	
	WebDriver driver;
	
	@FindBy(id="button-cart")
	WebElement AddProduct;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[5]/a")
	WebElement CheckOut;
	
	public void ClickCheckout() 
	{
		CheckOut.click();
		
	}
	
	
	
	public Boolean MessageDisplayed() 
	{
		List<WebElement> elements=driver.findElements(By.xpath("//*[@id=\"product-product\"]/div[1]"));
		if(elements.size()>0) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public void FinalAddToCart() 
	{
		
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddProduct.click();
	}
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
	}
}