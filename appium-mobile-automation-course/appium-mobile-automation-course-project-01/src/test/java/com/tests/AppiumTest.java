package com.tests;

import java.net.MalformedURLException;

import com.utils.AppiumSetup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppiumTest {
	static AndroidDriver<AndroidElement> driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			driver = AppiumSetup.LaunchApplication();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
