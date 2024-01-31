package com.HM.project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import GenericUtilities.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AddProductToCart_Test extends BaseClass {
	
	@Test
	
public void addProduct() throws Throwable
{
		cp.newproduct();
		gutil.scroll("Denim popover shirt");
		cp.viewProduct();
		gutil.zoomIn(cp.getZoomImg(), 0.75);
		cp.cart();
}

}
//WebElement image = driver.findElement(AppiumBy.id("com.hm.goe:id/carouselPhotoView"));
