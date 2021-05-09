package com.tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import com.utils.AppiumSetup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomatorTest {
	static AndroidDriver<AndroidElement> driver;
	public static void main(String[] args) {
		try {
			driver = AppiumSetup.LaunchApplication();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		//setup implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TestFlow1();	//automate flow 1

	}
	private static void TestFlow1() {
		//Finding Elements using AndroidUIAutomator
		// Advantages - No need to write whole xpath, you can provide only attributes to find elements
		//Attribute value should be in double quotes, single quotes does not work ("text('Views')") <- fail
		AndroidElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		views.click();
		
		//if you want to find element based on property
		AndroidElement element = driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
		System.out.println("Element Displayed on Top "+element.getText());
		
		
	}

}
