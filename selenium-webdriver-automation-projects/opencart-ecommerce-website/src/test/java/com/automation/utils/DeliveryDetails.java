package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryDetails {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id='collapse-shipping-address']/div/form/div[3]/label/input")
	WebElement addnewadd;

	@FindBy(xpath="//*[@id='input-shipping-firstname']")
	WebElement fname;

	@FindBy(xpath="//*[@id='input-shipping-lastname']")
	WebElement lname;

	@FindBy(id="input-shipping-address-1")
	WebElement add1;

	@FindBy(id="input-shipping-address-2")
	WebElement add2;

	@FindBy(id="input-shipping-city")
	WebElement city;

	@FindBy(id="input-shipping-postcode")
	WebElement postcode;

	@FindBy(id="input-shipping-country")
	WebElement country;

	@FindBy(id="input-shipping-zone")
	WebElement state;

	public void clickradio() throws InterruptedException
	{
		Thread.sleep(2000);
		addnewadd.click();
	}
	public void addnewAddress(String fname1,String lname1,String add11,String add21,String city1,String code,String count,String zone) throws Exception
	{
		
		Thread.sleep(1000);
		fname.sendKeys(fname1);
		Thread.sleep(1000);
		lname.sendKeys(lname1);
		Thread.sleep(1000);
		add1.sendKeys(add11);
		Thread.sleep(1000);
		add2.sendKeys(add21);
		Thread.sleep(1000);
		city.sendKeys(city1);
		Thread.sleep(1000);
		postcode.sendKeys(code);
		Thread.sleep(1000);
		country.sendKeys(count);
		Thread.sleep(1000);
		state.sendKeys(zone);
		
	}
	
	public DeliveryDetails(WebDriver driver) {
		this.driver=driver;
	}
}
