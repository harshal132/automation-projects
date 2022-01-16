package com.utils;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
//import io.appium.java_client.ios.IOSTouchAction;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

//contains all methods like tap, swipe, long press etc.
public class MobileActions {
    private AppiumDriver<?> driver;
 
    public MobileActions (AndroidDriver<?> driver) {
        this.driver = driver;
    }
 
    public void tap(MobileElement androidElement) {
    	new TouchAction(driver)
        .tap(TapOptions.tapOptions().withElement(ElementOption.element(androidElement))).perform();
    }
    //Tap to an element for 250 milliseconds
    public void tapByElement (MobileElement androidElement) {
        new TouchAction(driver)
            .tap(tapOptions().withElement(ElementOption.element(androidElement)))
            .waitAction(waitOptions(ofMillis(250))).perform();
    }
    
    public void longPress (MobileElement androidElement) {
        new TouchAction(driver)
        	.longPress(LongPressOptions.longPressOptions()
        			.withElement(ElementOption.element(androidElement))
        			.withDuration(Duration.ofSeconds(WaitTime.LOW.getValue())))
        			.release()
        	.perform();
    }
 
    //Tap by coordinates
    public void tapByCoordinates (int x,  int y) {
        new TouchAction(driver)
            .tap(point(x,y))
            .waitAction(waitOptions(ofMillis(250))).perform();
    }
 
    //Press by element
    public void pressByElement (MobileElement element, long seconds) {
        new TouchAction(driver)
            .press(ElementOption.element(element))
            .waitAction(waitOptions(ofSeconds(seconds)))
            .release()
            .perform();
    }
 
    //Press by coordinates
    public void pressByCoordinates (int x, int y, long seconds) {
        new TouchAction(driver)
            .press(PointOption.point(x,y))
            .waitAction(waitOptions(Duration.ofSeconds(seconds)))
            .release()
            .perform();
    }
 
    //Horizontal Swipe by percentages
    public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
 
        new TouchAction(driver)
            .press(point(startPoint, anchor))
            .waitAction(waitOptions(ofMillis(1000)))
            .moveTo(point(endPoint, anchor))
            .release().perform();
    }
 
    //Vertical Swipe by percentages
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
 
        new TouchAction(driver)
            .press(point(anchor, startPoint))
            .waitAction(waitOptions(Duration.ofSeconds(WaitTime.LOW.getValue())))
            .moveTo(point(anchor, endPoint))
            .release().perform();
    }
 
    //Swipe by elements
    public void swipeByElements (AndroidElement startElement, AndroidElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
 
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
 
        new TouchAction(driver)
            .press(point(startX,startY))
            .waitAction(waitOptions(ofMillis(1000)))
            .moveTo(point(endX, endY))
            .release().perform();
    }
 
    //Multitouch action by using an android element
    public void multiTouchByElement (AndroidElement androidElement) {
        TouchAction press = new TouchAction(driver)
            .press(ElementOption.element(androidElement))
            .waitAction(waitOptions(ofSeconds(1)))
            .release();
 
        new MultiTouchAction(driver)
            .add(press)
            .perform();
    }
    
    public void swipeByElementsWithoutPoints (AndroidElement androidElement,AndroidElement androidElement2, WaitTime time) {

        new TouchAction(driver)
        	.longPress(
        			longPressOptions()
        			.withElement(ElementOption.element(androidElement))
        			.withDuration(Duration.ofSeconds(time.getValue())))
        			.moveTo(ElementOption.element(androidElement2))
        			.release()
        	.perform();
    }
    
    public void scrollIntoView(String searchElementText, AndroidDriver<?> driver) {
    	String query = "new UiScrollable(new UiSelector()).scrollIntoView(text(\""+searchElementText+"\"));";
    	AndroidElement element = (AndroidElement) driver.findElementByAndroidUIAutomator(query);
    	this.tap(element);
    }
    
    public void dragAndDrop (AndroidElement androidElement,AndroidElement androidElement2) {
        new TouchAction(driver)
        	.longPress(ElementOption.element(androidElement))
        			.moveTo(ElementOption.element(androidElement2))
        			.release()
        	.perform();
    }
    
    public void tapBackButton(AndroidDriver<?> driver) {
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
    
    public void scrollIos(String direction, String textDisplayed) {
    	HashMap<String,String> swipeActions = new HashMap<String,String>();
    	swipeActions.put("direction", direction);
    	swipeActions.put("predicateString", "label CONTAINS "+textDisplayed);
    	swipeActions.put("toVisible", "true");
    	driver.executeScript("mobile:scroll",swipeActions);
    }
    
    public void takeScreenshot() {
    	File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
			FileUtils.copyFile(file, new File("Screenshot.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
