package com.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

public class InboxPage {

	AndroidDriver driver;
	
	@FindBy(xpath = "(//android.widget.ImageButton)[1]")
	private WebElement hamburgerBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Inbox']")
	private WebElement inboxBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='No messages']")
	private WebElement nomsgText;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Please come back again later to view the latest H&M news and special location-based offers.']")
	private WebElement text;
	
//	"(//android.widget.LinearLayout)[3]"
	
	public InboxPage(AndroidDriver driver) {
		this.driver=driver;
	}
	
	
	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getHamburgerBtn() {
		return hamburgerBtn;
	}

	public WebElement getInboxBtn() {
		return inboxBtn;
	}

	public WebElement getNomsgText() {
		return nomsgText;
	}

	public WebElement getText() {
		return text;
	}
	
	public void inbox() {
		hamburgerBtn.click();
		inboxBtn.click();
		String msgtext = nomsgText.getText();
		String overAllText = text.getText();
		
		System.out.println(msgtext);
		System.out.println(overAllText);
		
		
	}

	
}
