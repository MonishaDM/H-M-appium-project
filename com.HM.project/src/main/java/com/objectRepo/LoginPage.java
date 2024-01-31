package com.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.GestureUtility;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

	AndroidDriver driver;
	public LoginPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='India/English']")
	private WebElement country;
	
	@FindBy(id = "android:id/button2")
	private WebElement notify;
	
	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getNotify() {
		return notify;
	}

	public void login(GestureUtility gutil, String value) {
		gutil.scroll(value);
		country.click();
		notify.click();
		
	}
	
}
