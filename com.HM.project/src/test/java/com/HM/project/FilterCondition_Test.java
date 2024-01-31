package com.HM.project;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import javax.swing.Scrollable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.internal.Parser;

import com.google.common.collect.ImmutableMap;

import GenericUtilities.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class FilterCondition_Test{
	
	@Test
	public void filter() throws Throwable
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
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Popular categories\"))")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sweaters & Cardigans']")).click();
		driver.findElement(AppiumBy.accessibilityId("plp_filters_button")).click();
		WebElement element = driver.findElement(AppiumBy.accessibilityId("Range end,13499"));
		
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//				"elementId", ((RemoteWebElement) element).getId(),
//			    "left", 344, "top", 344, "width", 748, "height", 748,
//			    "direction", "right",
//			    "percent", 0.75
//			));
		
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", 344,
			    "endY", 748
			));
		
		
		Thread.sleep(5000);
		
		String minValue = driver.findElement(AppiumBy.id("com.hm.goe:id/min_value")).getText();
		String maxValue = driver.findElement(AppiumBy.id("com.hm.goe:id/max_value")).getText();
		
		int value1=0;
		int value2=0;
		
		for(int i=0;i<minValue.length();i++)
		{
			
			char num1 = minValue.charAt(i);
			if (num1 >= '0' && num1 <= '9') {
				value1 = value1 + num1;
				
				System.out.print(value1);
		}
		}
		System.out.println();
		
		for(int i=0;i<maxValue.length();i++)
		{
			
			char num2 = maxValue.charAt(i);
			if (num2 >= '0' && num2 <= '9') {
				value2 = value2 + num2;
				
				System.out.print(value2);
		}
		}
		System.out.println();
		
		driver.findElement(AppiumBy.accessibilityId("plp_filters_show_button")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"plp_product_text\"])[2]")).click();
		
		
		
		
		String text = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Rs. 1,499.00']")).getText();
		int value=0;
		for(int i=0;i<text.length();i++)
		{
			char num = text.charAt(i);

			if (num >= '0' && num <= '9') 
			{
				value = value + num;
				
				System.out.print(value);
			}
		}
		System.out.println();
		
		if(value>=value1 || value<=value2)
		{
			System.out.println("This value is present between the range");
		}
		
		
		service.stop();
		}
}
