package com.HM.project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class StoreLocator_Test {
	
	@Test
	public void storeLocator() throws Throwable
	{
		File f = new File("C:\\Users\\dmoni\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceName", "Redmi 11T");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("UDID", "M7WGS48XZ9VSHMXO");
		
		dc.setCapability("appPackage", "com.hm.goe");
		dc.setCapability("appActivity", ".app.home.HomeActivity");
		
		URL u = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India/English\"))")).click();
		driver.findElement(AppiumBy.id("android:id/button2")).click();
		
		
		driver.findElement(AppiumBy.xpath("(//android.widget.ImageButton)[1]")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Store Locator\"))")).click();
		
		
		WebElement storeLoc = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Store Locator\"]"));

		storeLoc.click();

		Thread.sleep(5000);

		WebElement locBtn = driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.hm.goe:id/storeLocatorActionButton\"]"));
		locBtn.click();

		driver.findElement(AppiumBy.id("com.hm.goe:id/search_src_text")).sendKeys("bangalore");

		List<WebElement> suggLoc = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.hm.goe:id/store_list_store_name']"));
		for (int i = 0; i < suggLoc.size(); i++) {
		    WebElement element = suggLoc.get(i);
		    String text = element.getText();

		    // Print relevant information about the element
		    System.out.println(text);
		   
		}
		
	}
		
		
		
		
		
}









//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Store Locator']")).click();
//Thread.sleep(3000);
//
////driver.findElement(AppiumBy.id("com.hm.goe:id/underlinedTextview")).click();
////driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click();
////Thread.sleep(3000);
//
//
//driver.findElement(AppiumBy.id("com.hm.goe:id/storeLocatorActionButton")).click();
//driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click();
//
//List<WebElement> allAddress = driver.findElements(AppiumBy.id("com.hm.goe:id/store_results_number"));
//for(int i=0;i<allAddress.size();i++)
//{
//	String data = allAddress.get(i).getText();
//	System.out.println(data);
//}
//
//
//
////String address = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Vega City, Bannerghatta Main Road,']")).getText();
////for(int i=0;i<address.length();i++)
////{
////	System.out.println(address);
////}
//}
//
////driver.findElement(AppiumBy.accessibilityId("MAP")).click();
////driver.findElement(AppiumBy.accessibilityId("LIST")).click();
////driver.findElement(AppiumBy.id("com.hm.goe:id/search_bar")).sendKeys("Bangalore");
////driver.findElement(AppiumBy.id("com.hm.goe:id/search_src_text")).click();
////driver.findElement(AppiumBy.xpath("//android.widget.AutoCompleteTextView[@text='Find a store']")).sendKeys("Bangalore");
////driver.findElement(AppiumBy.className("android.widget.AutoCompleteTextView")).click();
//
////
////WebElement element = driver.findElement(AppiumBy.id("com.hm.goe:id/search_src_text"));
////
////driver.executeScript("mobile: clickGesture", ImmutableMap.of(
////    "elementId", ((RemoteWebElement) element).getId()
////));
//
////driver.findElement(AppiumBy.id("com.hm.goe:id/search_src_text")).sendKeys("Bangalore");
////
////
////
////
////
////
////
////Thread.sleep(3000);
////driver.findElement(AppiumBy.accessibilityId("LIST")).click();
