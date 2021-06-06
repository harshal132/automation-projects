package com.tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import com.utils.AppiumSetup;
import com.utils.MobileActions;
import com.utils.WaitTime;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SwipeMinuteHandOfClock {
	static AndroidDriver<AndroidElement> driver;
	static MobileActions actions;
	public static void main(String[] args) {
		try {
			driver = AppiumSetup.LaunchApplication("app.apk");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}	
		//setup implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions = new MobileActions(driver);
		
		//Navigate to Inline page.
		navigateToDesiredPage();
		selectHour("9");
		dragMinuteHandToMinute("45");
	}
	private static void dragMinuteHandToMinute(String minute) {
		AndroidElement selectedMinuteHand = driver.findElement(By.xpath("//*[contains(@selected, 'true')]"));
		AndroidElement selectHour = driver.findElement(By.xpath("//*[@content-desc='"+minute+"']"));
		actions.swipeByElementsWithoutPoints(selectedMinuteHand,selectHour, WaitTime.LOW);
		AppiumSetup.log("Swipe from one element to another is completed");
		
	}
	private static void selectHour(String hour) {
		AndroidElement selectHour = driver.findElement(By.xpath("//*[@content-desc='"+hour+"']"));
		actions.tap(selectHour);
		AppiumSetup.log("Clicked on provided hour");
	}
	private static void navigateToDesiredPage() {
		AndroidElement views = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
		actions.tap(views);
		AppiumSetup.log("Navigated to Views page");
		
		AndroidElement dateWidgets = driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']"));
		actions.tap(dateWidgets);
		AppiumSetup.log("Navigated to Date Widgets page");
		
		AndroidElement inlinePage = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Inline')]"));
		actions.tap(inlinePage);
		AppiumSetup.log("Navigated to Inline page");
	}

}
