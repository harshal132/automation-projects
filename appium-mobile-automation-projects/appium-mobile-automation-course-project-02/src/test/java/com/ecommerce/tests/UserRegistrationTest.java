package com.ecommerce.tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import com.utils.AppiumSetup;
import com.utils.MobileActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UserRegistrationTest {
	static AndroidDriver<AndroidElement> driver;
	static MobileActions actions;
	public static void main(String[] args) {
		try {
			driver = AppiumSetup.LaunchApplication("general-store-hybrid-application.apk");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}		
		//setup implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions = new MobileActions(driver);	
		testFlow();
	}
	private static void testFlow() {
		
	}
}
