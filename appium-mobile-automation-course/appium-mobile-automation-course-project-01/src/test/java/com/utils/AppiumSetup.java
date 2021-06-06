package com.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumSetup {
	public static void CloseApplication(AndroidDriver<?> android) {
		android.closeApp();
	}

	public static AndroidDriver<AndroidElement> LaunchApplication(String appName) throws MalformedURLException {
		AndroidDriver<AndroidElement> android;
		//Method For Setting up Capabilities
		File file = new File(appName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ASUS_X00T_3");
		android = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		System.out.println("Application Launched Successfully!");
		return android;
	}
	
	public static void log(String log) {
		System.out.println(log);
	}
	
	public static void navigate(AndroidDriver<AndroidElement> driver, MobileActions actions, String pageName) {
		AndroidElement views = driver.findElement(By.xpath("//android.widget.TextView[@text='"+pageName+"']"));
		actions.tap(views);
		AppiumSetup.log("Navigated to "+pageName+" page");
	}
}
