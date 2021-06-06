package com.tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.utils.AppiumSetup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppiumTest {
	static AndroidDriver<AndroidElement> driver;
	public static void main(String[] args) {
		try {
			driver = AppiumSetup.LaunchApplication("app.apk");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		//setup implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TestFlow1();	//automate flow 1
	}
	private static void TestFlow1() {
		AndroidElement preference = driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
		preference.click(); // Click on Preference Item.
		
		AndroidElement preference_dependencies = driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']"));
		preference_dependencies.click(); // Click on Preference Dependencies Item.
		
		AndroidElement wifi_checkbox = driver.findElement(By.id("android:id/checkbox"));
		wifi_checkbox.getAttribute("checked");
		if(wifi_checkbox.getAttribute("checked").toString().equals("false")) {
			System.out.println("Wifi checkbox not checked");
			wifi_checkbox.click(); // Click on wifi checkbox if not checked
		}
		else {
			System.out.println("Wifi Checkbox already checked");
		}
		
		AndroidElement wifi_settings = driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']"));
		if(wifi_settings.isDisplayed()) {
			System.out.println("Wifi Settings Displayed");
			wifi_settings.click();
		}
		else {
			System.out.println("Wifi Settings not displayed!");
		}
		
		AndroidElement wifi_settings_popup = driver.findElement(By.id("android:id/edit"));
		wifi_settings_popup.sendKeys("Harshal Chavan"); //Enter details in text box
		
		AndroidElement wifi_settings_popup_ok = driver.findElement(By.id("android:id/button1"));
		wifi_settings_popup_ok.click();
		
	}

}
