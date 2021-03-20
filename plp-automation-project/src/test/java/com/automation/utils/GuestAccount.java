package com.automation.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class GuestAccount {
WebDriver driver;
	
	@FindBy(id="button-account")
	WebElement continueWithGuest;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/fieldset[1]/div[2]/input")
	WebElement fname;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/fieldset[1]/div[3]/input")
	WebElement lname;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/fieldset[1]/div[4]/input")
	WebElement email;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/fieldset[1]/div[5]/input")
	WebElement phone;

	@FindBy(xpath="//*[@id='input-payment-company']")
	WebElement comp;
	
	@FindBy(xpath="//*[@id='input-payment-address-1']")
	WebElement add1;
	
	@FindBy(xpath="//*[@id='input-payment-address-2']")
	WebElement add2;
	
	@FindBy(xpath="//*[@id='input-payment-city']")
	WebElement city;
	
	@FindBy(xpath="//*[@id='input-payment-postcode']")
	WebElement postcode;
	
	@FindBy(xpath="//*[@id='input-payment-country']")
	WebElement country;
	
	@FindBy(xpath="//*[@id='input-payment-zone']")
	WebElement state;
	
	@FindBy(xpath="//*[@id='newsletter']")
	WebElement newsletter;
	
	@FindBy(xpath="//*[@id='collapse-payment-address']/div/div[3]/label/input")
	WebElement sameaddress;
	
	@FindBy(name="shipping_address")
	WebElement policy;
	
	@FindBy(xpath="//*[@id='button-guest']")
	WebElement Guestiter;


	public void ClickCountinueWithGuest() 
	{
		driver.findElement(By.xpath("//*[@id='collapse-checkout-option']/div/div/div[1]/div[2]/label/input")).click();
		continueWithGuest.click();
		
	}
	
	public void Enterfname(String fname1) 
	{
		fname.sendKeys(fname1);
		
	}
	
	public void Enterlname(String lname1) 
	{
		lname.sendKeys(lname1);
		
	}
	
	public void Enterphone(String phone1) 
	{
		phone.sendKeys(phone1);
		
	}
	
	public void EnterEmail(String email1) 
	{
		email.sendKeys(email1);
		
	}
	
	public void EnterComp(String comp1) 
	{
		comp.sendKeys(comp1);
		
	}
	
	public void EnterAdd1(String add11) 
	{
		add1.sendKeys(add11);
		
	}
	
	public void EnterAdd2(String add21) 
	{
		add2.sendKeys(add21);
		
	}
	
	public void EnterCity(String city1) 
	{
		city.sendKeys(city1);
		
	}
	
	public void EnterPostCode(String code) 
	{
		postcode.sendKeys(code);
		
	}
	
	public void SelectCountry(String country1) 
	{
		Select sc1=new Select(country);
		sc1.selectByVisibleText(country1);
		
	}
	
	public void SelectState(String state1) 
	{
		Select sc1=new Select(state);
		sc1.selectByVisibleText(state1);
	
	}
	
	public void clickNews()
	{
		newsletter.click();
	}
	
	public void clicksameadd()
	{
		sameaddress.click();
	}
	
	public void clickpolicy()
	{
		policy.click();
	}
	
	public void ClickSubmit() 
	{
		Guestiter.click();
		
	}
	
	public GuestAccount(WebDriver driver) {
		
		this.driver=driver;
	}
	
}
