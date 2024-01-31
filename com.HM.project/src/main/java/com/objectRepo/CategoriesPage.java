package com.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CategoriesPage {
	
AndroidDriver driver;

public CategoriesPage(AndroidDriver driver) 
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

	@FindBy(xpath = "//android.widget.TextView[@text='Sweaters & Cardigans']")
	private WebElement ladiesBtn;
	
	@FindBy(id = "com.hm.goe:id/filterSortButton")
	private WebElement filterBtn;
	
	@FindBy(id="com.hm.goe:id/min_value")
	private WebElement minValue;
	
	@FindBy(id="com.hm.goe:id/max_value")
	private WebElement maxValue;

	@FindBy(id="com.hm.goe:id/applyFilters")
	private WebElement showBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\\\"plp_product_text\\\"])[2]")
	private WebElement productBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Rs. 1,499.00']")
	private WebElement textValue;

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getLadiesBtn() {
		return ladiesBtn;
	}

	public WebElement getFilterBtn() {
		return filterBtn;
	}

	public WebElement getMinValue() {
		return minValue;
	}

	public WebElement getMaxValue() {
		return maxValue;
	}

	public WebElement getShowBtn() {
		return showBtn;
	}

	public WebElement getProductBtn() {
		return productBtn;
	}

	public WebElement getTextValue() {
		return textValue;
	}
	

}
