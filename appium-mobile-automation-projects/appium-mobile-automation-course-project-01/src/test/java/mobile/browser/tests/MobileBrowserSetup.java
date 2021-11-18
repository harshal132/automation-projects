package mobile.browser.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBrowserSetup {
	public static AndroidDriver<AndroidElement> android;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static AndroidDriver<AndroidElement> LaunchMobileBrowser(String browserName) throws MalformedURLException {
		//Method For Setting up Capabilities
		//File file = new File(appName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ASUS_X00T_3");
		android = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		System.out.println("Browser Launched Successfully!");
		return android;
	}

}
