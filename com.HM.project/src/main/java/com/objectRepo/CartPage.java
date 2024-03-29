package com.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.GestureUtility;
import io.appium.java_client.android.AndroidDriver;

public class CartPage {

	AndroidDriver driver;
	
	@FindBy(id = "com.hm.goe:id/text_vignette")
	private WebElement newArrivalsBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Denim popover shirt']")
	private WebElement product;
	
	@FindBy(id = "com.hm.goe:id/carouselImage")
	private WebElement productImage;
	
	@FindBy(id = "com.hm.goe:id/carouselPhotoView")
	private WebElement zoomImg;
	
	public WebElement getZoomImg() {
		return zoomImg;
	}

	public WebElement getCloseImg() {
		return closeImg;
	}
	@FindBy(id = "com.hm.goe:id/ivCloseCarousel")
	private WebElement closeImg;
	
	@FindBy(id = "com.hm.goe:id/buttonText")
	private WebElement addBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='S']")
	private WebElement sizeBtn;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"pdp_add_to_cart_button\"]")
	private WebElement addToCartBtn;
	
	@FindBy(id = "com.hm.goe:id/hm_shoppingbag_count")
	private WebElement bagBtn;
	
	public CartPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}
	
	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getNewArrivalsBtn() {
		return newArrivalsBtn;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getProductImage() {
		return productImage;
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

	public void newproduct() throws Throwable 
	{
		newArrivalsBtn.click();
		Thread.sleep(2000);
		
	}
	
	public void viewProduct() throws Throwable
	{
		product.click();
		productImage.click();
		Thread.sleep(2000);
	}
	public void cart() throws Throwable
	{
		closeImg.click();
		addBtn.click();
		Thread.sleep(3000);
		sizeBtn.click();
		addToCartBtn.click();
		bagBtn.click();
		System.out.println("Product added to cart successfully");
	}
}
