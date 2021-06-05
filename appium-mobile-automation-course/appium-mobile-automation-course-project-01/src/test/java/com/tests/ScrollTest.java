package com.tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.utils.AppiumSetup;
import com.utils.MobileActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollTest {
	static AndroidDriver<AndroidElement> driver;
	static MobileActions actions;
	public static void main(String[] args) {
		
		try {
			driver = AppiumSetup.LaunchApplication();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		//setup implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions = new MobileActions(driver);
		
		testFlow("Rotating button");
	}
	private static void testFlow(String element) {
		AndroidElement views = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
		actions.tap(views);
		AppiumSetup.log("Navigated to Views page");
		actions.scrollIntoView(element);
		
	}

}
