package GenericUtilities;

import java.time.Duration;
import java.util.Set;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;

public class DriverUtility {
		AndroidDriver driver;
		
		public DriverUtility(AndroidDriver driver) {
			 this.driver=driver;
		
		}
		
		public void installApp(String package_name, String path) {
			driver.installApp(path);
			driver.isAppInstalled(package_name);
			
		}
		
		public void unInstall(String package_name) {
			driver.removeApp(package_name);
			
		}
		
		public void hideKeyboard() {
			driver.hideKeyboard();
			
		}
		
		public void openNotification() {
			driver.openNotifications();
			
		}
		
		public void deviceLocked() {
			driver.isDeviceLocked();
			
		}

		public void appState(String package_name) {
			driver.queryAppState(package_name);
			
		}
		
		public void activateApp(String package_name) {
			driver.activateApp(package_name);
			
		}
		
		public void appInBackground(int time) {
			driver.runAppInBackground(Duration.ofSeconds(time));
		
		}
		
		public void context() 
		{
			Set<String> ch = driver.getContextHandles();
			int count=ch.size();
			System.out.println(count);
			for (String allch : ch) {
				System.out.println(allch);	
			}
		}
		
		public void switchContext(String WEBVIEW_packageName) {
			driver.context(WEBVIEW_packageName);
			
		}
		
		public void implicitWait() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		}
		
		 public void orientationLandscape() {
			 org.openqa.selenium.ScreenOrientation screen = driver.getOrientation();
			 driver.rotate(screen.LANDSCAPE);
			 
		}
		 
		 public void orientationPotrait() {
			org.openqa.selenium.ScreenOrientation screen = driver.getOrientation();
			driver.rotate(screen.PORTRAIT);
		
		 }
		 
		 public void turnOffData() {
			 ConnectionState dataOff = driver.setConnection(new ConnectionStateBuilder()
						.withDataDisabled().build());
		}
		 
		 public void turnOnData() {
			 ConnectionState dataOn = driver.setConnection(new ConnectionStateBuilder()
						.withDataEnabled().build());
		}
		 
		 public void turnOffWifi() {
			 ConnectionState wifiOff = driver.setConnection(new ConnectionStateBuilder()
						.withWiFiDisabled().build());
		}
		 
		 public void turnOnWifi() {
			 ConnectionState wifiOn = driver.setConnection(new ConnectionStateBuilder()
						.withDataDisabled().build());
		}
		 
		 public void turnOffAirplane() {
			 ConnectionState airplaneOff = driver.setConnection(new ConnectionStateBuilder()
						.withAirplaneModeDisabled().build());
		}
		 
		 public void turnOnAirplane() {
			 ConnectionState airplaneOn = driver.setConnection(new ConnectionStateBuilder()
						.withAirplaneModeEnabled().build());
		}
		
}	
