package com.HM.project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AssertProductValue_Test{
	
	@Test
	public void productValue() throws Throwable
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
		
		
		driver.findElement(AppiumBy.id("com.hm.goe:id/text_vignette")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sleeveless denim dress']")).click();
		
		Thread.sleep(3000);
		String productValue = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Rs. 2,999.00']")).getText();
		
		driver.findElement(AppiumBy.id("com.hm.goe:id/buttonText")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='S']")).click();
		driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"pdp_add_to_cart_button\"]")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.id("com.hm.goe:id/hm_shoppingbag_count")).click();
		String cartValue = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Rs. 2,999.00']")).getText();
		
		Assert.assertEquals(productValue, cartValue);
		System.out.println("The product has same value");
	}

}
