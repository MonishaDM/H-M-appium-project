package com.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage {

	AndroidDriver driver;
	
	@FindBy(id = "com.hm.goe:id/text_vignette")
	private WebElement newArrivalsBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Sleeveless denim dress']")
	private WebElement product;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Rs. 2,999.00']")
	private WebElement productValue;
	
	
	@FindBy(id = "com.hm.goe:id/buttonText")
	private WebElement addBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='S']")
	private WebElement sizeBtn;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"pdp_add_to_cart_button\"]")
	private WebElement addToCartBtn;
	
	@FindBy(id = "com.hm.goe:id/hm_shoppingbag_count")
	private WebElement bagBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Rs. 2,999.00']")
	private WebElement cartValue;
	
	
	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getNewArrivalsBtn() {
		return newArrivalsBtn;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getProductValue() {
		return productValue;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getSizeBtn() {
		return sizeBtn;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getBagBtn() {
		return bagBtn;
	}

	public WebElement getCartValue() {
		return cartValue;
	}

	public ProductPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	public void addProduct() throws Throwable {
		newArrivalsBtn.click();
		product.click();
        productValue.getText();
        addBtn.click();
        sizeBtn.click();
        addToCartBtn.click();
        Thread.sleep(5000);
        bagBtn.click();
		cartValue.getText();
		Assert.assertEquals(productValue, cartValue);
		System.out.println("The product has same value");
		
	}
}
