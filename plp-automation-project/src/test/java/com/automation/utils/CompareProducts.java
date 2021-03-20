package com.automation.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CompareProducts {
	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[3]")
	WebElement AddtoCompare;
	
	@FindBy(xpath="//*[@id='product-search']/div[1]")
	WebElement AddtoCompareSucc;
	
	@FindBy(xpath="//*[@id='compare-total']")
	WebElement CompareTotal;
	
	@FindBy(xpath="//*[@id='content']/table/tbody[4]/tr/td[2]/input")
	WebElement AddFromCompare;
	
	//@FindBy(xpath="//*[@id='content']/table/tbody[4]/tr/td[2]/a")
	
	@FindBy(linkText="Remove")
	WebElement RemoveProduct;
	
	@FindBy(xpath="//*[@id='product-compare']/div[1]")
	WebElement RemoveResult;
	
	public Boolean SendRemoveResult()
	{
		return RemoveResult.isDisplayed();
	}
	
	public void ClickToRemove()
	{
		RemoveProduct.click();
	}
	
	public void AddFromCompareProd()
	{
		AddFromCompare.click();
	}
	
	public void ShowCompare()
	{
		CompareTotal.click();
	}
	
	public String TotalCompare()
	{
		return CompareTotal.getText();
	}
	public Boolean CheckCompareSucc()
	{
		return AddtoCompareSucc.isDisplayed();
	}
	
	public void AddProdToCompare()
	{
		AddtoCompare.click();
	}
	
	
	public CompareProducts(WebDriver driver) {
		this.driver=driver;
	}
}
