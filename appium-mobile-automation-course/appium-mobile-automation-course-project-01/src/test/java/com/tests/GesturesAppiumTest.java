package com.tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import com.utils.AppiumSetup;
import com.utils.MobileActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GesturesAppiumTest {
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
		longPressFlow();	//automate flow 1
	}
	private static void longPressFlow() {
		AndroidElement views = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
		actions.tap(views);
		
		AndroidElement expandable_list = driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
		actions.tap(expandable_list);
		
		AndroidElement custom_adapter = driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']"));
		actions.tap(custom_adapter);
				
		AndroidElement peopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		actions.tap(peopleNames);
		
		AndroidElement chuck = driver.findElement(By.xpath("//android.widget.TextView[@text='Chuck']"));
		actions.longPress(chuck);
		
		AndroidElement sampleMenu = driver.findElement(By.xpath("//android.widget.TextView[@text='Sample action']"));
		if(sampleMenu.isDisplayed()) {
			System.out.println("Sample Menu is visible");
		}
		else {
			System.out.println("Sample menu is not displayed!");
		}
	}

}
