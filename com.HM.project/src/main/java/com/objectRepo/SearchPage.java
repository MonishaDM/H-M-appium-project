package com.objectRepo;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SearchPage {

	AndroidDriver driver;
	
	public SearchPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	public void search() {
		
	}
}
