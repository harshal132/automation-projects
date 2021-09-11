package com.automation.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProduct {
	WebDriver driver;
	
	@FindBy(name="search")
	WebElement Search;
	
	@FindBy(xpath="//*[@id='content']/div/div[1]/ul[2]/li[2]")
	WebElement SpecsVerify;
	
	@FindBy(xpath="//*[@id='content']/div[3]/div/div/div[2]/div[1]/h4/a")
	WebElement ProductLink;
	
	@FindBy(xpath="//*[@id='content']/div/div[1]/ul[2]/li[1]")
	WebElement Description;
	
	@FindBy(xpath="//*[@id='content']/div/div[1]/ul[2]/li[2]/a")
	WebElement Specification;
	
	@FindBy(partialLinkText = "Reviews (0)")
	WebElement Reviews;
	
	@FindBy(xpath="//*[@id='review']/p")
	WebElement Comments;
	
	@FindBy(id="input-name")
	WebElement fNameReview;
	
	
	@FindBy(xpath="//*[@id='form-review']/div[4]/div/input[4]")
	WebElement proRatings;
	
	@FindBy(id="button-review")
	WebElement SendReview;
	
	@FindBy(xpath="//*[@id='form-review']/div[2]")
	WebElement SuccessAlert;
	
	@FindBy(id="button-cart")
	WebElement AddToCart;
	
	@FindBy(xpath="//*[@id='product-product']/div[1]/a[1]")
	WebElement AddCartSuccess;
	
	
	@FindBy(xpath="//*[@id='form-review']/div[2]")
	WebElement ReviewMissing;
	
	
	@FindBy(id="input-option225")
	WebElement DeliveryDate;
	
	@FindBy(id="input-quantity")
	WebElement prodQuantity;
	
	public void EnterProdQuantity(String qty)
	{
		prodQuantity.clear();
		prodQuantity.sendKeys(qty);
	}
	
	public void EnterDeliveryDate(String date)
	{
		DeliveryDate.clear();
		DeliveryDate.sendKeys(date);
	}
	
	
	public Boolean CheckReviewMissing()
	{
		return ReviewMissing.isDisplayed();
	}
	
	
	public Boolean CheckAddCartSuccess()
	{
		try {
		return AddCartSuccess.isDisplayed();
		}catch(Exception e) 
		{
			return false;
		}	
	}
	
	public void AddProdCart()
	{
		AddToCart.click();
	}
	
	public Boolean CheckSuccessAlert() throws InterruptedException
	{
		Thread.sleep(1000);
		
		return SuccessAlert.isDisplayed();
	}
	
	public void SendReview()
	{
		SendReview.click();
	}
	
	public void SendRatings()
	{
		proRatings.click();
	}
	
	public void EnterReviewerName(String name)
	{
		fNameReview.sendKeys(name);
	}
	
	@FindBy(id="input-review")
	WebElement rReview;
	
	public void Enter_Review(String review)
	{
		rReview.sendKeys(review);
	}
	
	public String ShowReviews()
	{
		return Comments.getText();
	}
	
	public void CheckReviews()
	{
		Reviews.click();
	}
	
	public String ClickSpecs()
	{
		Specification.click();
		return Specification.getText();
	}
	
	public String CheckSpecs()
	{
		return SpecsVerify.getAttribute("class");
	}
	
	public String CheckDesc()
	{
		return Description.getAttribute("class");
	}
	
	public void OpenProductDetails()
	{
		ProductLink.click();
	}
	
	public void SearchProductFunc(String product) 
	{
		Search.clear();
		Search.sendKeys(product);
		Search.sendKeys(Keys.ENTER);
	}
	
	public SearchProduct(WebDriver driver) {
		this.driver=driver;
	}
}