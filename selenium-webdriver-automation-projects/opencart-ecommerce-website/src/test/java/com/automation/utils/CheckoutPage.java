package com.automation.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//*[@id=\"accordion\"]/div[6]/div[1]/h4/a")
	WebElement ConfirmOrderActive;
	
	@FindBy(id="button-payment-address")
	WebElement Continue1;
	
	@FindBy(id="button-shipping-address")
	WebElement Continue2;
	
	@FindBy(id="button-shipping-method")
	WebElement Continue3;
	
	@FindBy(name="agree")
	WebElement Terms;
	
	@FindBy(id="button-payment-method")
	WebElement Continue4;
	
	@FindBy(id="button-confirm")
	WebElement ConfirmOrder;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement FinalContinue;
	
	public void ClickFContinue() 
	{
		FinalContinue.click();
	}
	
	public void ClickConfirmOrder() throws InterruptedException 
	{
		ConfirmOrder.click();
	}
	
	public void ClickContine4() throws InterruptedException 
	{
		Continue4.click();
	}
	
	public void CheckTerms() 
	{
		Terms.click();
	}
	
	public void WritePaymentComments(String Comments) throws InterruptedException 
	{
		wait=new WebDriverWait(driver,15);
		WebElement PaymentComments=wait.until(
				ExpectedConditions.visibilityOf(
						driver.findElement(
								By.name("comment"))));
		PaymentComments.clear();
		PaymentComments.sendKeys(Comments);
	}
	
	public void ClickContine3() throws InterruptedException 
	{
		Continue3.click();
	}
	
	public void WriteShippingComments(String Comments) throws InterruptedException 
	{
		wait=new WebDriverWait(driver,15);
		WebElement ShippingComments=wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.name("comment"))));
		ShippingComments.clear();
		ShippingComments.sendKeys(Comments);
	}
	
	
	public void ClickContine2() throws InterruptedException 
	{
		Continue2.click();
	}
	
	public void ClickContine1() throws InterruptedException 
	{
		Continue1.click();
	}
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,15);
	}

	public Boolean isConfirmOrderActive() {
		String value = ConfirmOrderActive.getAttribute("aria-expanded").toString();
		if(value.equals("true")) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}