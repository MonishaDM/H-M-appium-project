package GenericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GestureUtility {

AndroidDriver driver;
	
	public GestureUtility(AndroidDriver driver) {
		this.driver=driver;
		
	}
	
	public void click(WebElement element) {
		((JavascriptExecutor)driver).executeScript("mobile:clickGesture",ImmutableMap.of 
		("elementId",((RemoteWebElement)element).getId()
		));
		
	}
	
	public void longClick(WebElement element) {
		((JavascriptExecutor)driver).executeScript("mobile:longClickGesture", ImmutableMap.of
		("elementId",((RemoteWebElement)element).getId(),"duration", 2000));
		
	}
	
	public void doubleClick(WebElement element) {
		((JavascriptExecutor)driver).executeScript("mobile:doubleClickGesture", ImmutableMap.of
		("elementId",((RemoteWebElement)element).getId()
		));
		
	}
	
	public void zoomIn(WebElement element, double percentage) {
		((JavascriptExecutor)driver).executeScript("mobile:pinchOpenGesture", ImmutableMap.of
		("elementId",((RemoteWebElement)element).getId(),"percent",percentage
		));
	}
	
	public void zoomOut(WebElement element, double percentage) {
		((JavascriptExecutor)driver).executeScript("mobile:pinchCloseGesture", ImmutableMap.of
		("elementId",((RemoteWebElement)element).getId(),"percent",percentage
		));
		
	}
	
	public void swipe(WebElement element, double percentage, int left, int top, int height, int width, String direction, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of
			("left", left, "top", top, "width", width, "height", height,
			    "direction", direction,"percent", percent
			));
		
	}
	
	public void dragAndDrop(WebElement element,int x, int y) {
		((JavascriptExecutor)driver).executeScript("mobile:dragGesture", ImmutableMap.of
		("elementId",((RemoteWebElement)element).getId(),"endX",x,"endY",y));
		
	}
	
	public void scroll(String value) {
		driver.findElement(AppiumBy.androidUIAutomator
		("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));"));
		
	}
	
	public void searchAction() {
		driver.executeScript("mobile: performEditorAction",
				ImmutableMap.of("action", "search"));
		
	}

}
