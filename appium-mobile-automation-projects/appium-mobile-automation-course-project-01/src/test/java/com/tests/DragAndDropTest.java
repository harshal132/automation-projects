package com.tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import com.utils.AppiumSetup;
import com.utils.MobileActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragAndDropTest {
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
		testFlow();
	}
	private static void testFlow() {
		AppiumSetup.navigate(driver, actions, "Views");
		AppiumSetup.navigate(driver, actions, "Drag and Drop");	
		AndroidElement firstCircle = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		AndroidElement secondCircle = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));	
		actions.dragAndDrop(firstCircle, secondCircle);
	}

}
