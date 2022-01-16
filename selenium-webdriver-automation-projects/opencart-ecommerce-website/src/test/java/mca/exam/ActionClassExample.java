package mca.exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassExample {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/");
		
		Actions ac = new Actions(driver);
		WebElement live= driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='Live']"));
		ac.moveToElement(live).perform();
		Thread.sleep(5000);
		WebElement automate= driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='App Automate']"));
		ac.moveToElement(automate).perform();
		
		ac.contextClick(automate).perform();
		Thread.sleep(5000);
		//driver.quit();
	}

}
