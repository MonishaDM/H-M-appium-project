package GenericUtilities;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.objectRepo.CartPage;
import com.objectRepo.CategoriesPage;
import com.objectRepo.FilterPage;
import com.objectRepo.LoginPage;
import com.objectRepo.ProductPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AndroidDriver driver;
	static public AndroidDriver sdriver;
	public DriverUtility dutil;
	public GestureUtility gutil;
	public FileUtility futil = new FileUtility();
	public AppiumDriverLocalService service;
	public CartPage cp;
	public FilterPage filp;
	public LoginPage lp;
	public ProductPage prp;
	public CategoriesPage ctpg;
	
	@BeforeSuite
	public void startServer() {
		
		File f = new File("C:\\Users\\dmoni\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		service = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(200)).build();
		
		service.start();
		System.out.println("Starting__Connecting to the server");
	}
	
	@BeforeClass
	public void startApp() throws Throwable {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", futil.dataFromPropertyFile("platformName"));
		dc.setCapability("deviceName", futil.dataFromPropertyFile("deviceName"));
		dc.setCapability("automationName", futil.dataFromPropertyFile("automationName"));
		dc.setCapability("UDID", futil.dataFromPropertyFile("UDID"));
		
		dc.setCapability("appPackage", futil.dataFromPropertyFile("appPackage"));
		dc.setCapability("appActivity", futil.dataFromPropertyFile("appActivity"));
		
		URL u = new URL("http://localhost:4723");
		
		driver = new AndroidDriver(u,dc);
		sdriver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		sdriver=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		gutil = new GestureUtility(driver);
		dutil = new DriverUtility(driver);
		cp = new CartPage(driver);
		filp = new FilterPage(driver);
		lp = new LoginPage(driver);
		prp = new ProductPage(driver);
		ctpg = new CategoriesPage(driver);
		
	}
	
	@BeforeMethod
	public void login() {
		lp.login(gutil, "India/English");
	}
	
	@AfterClass
	public void closeApp() {
		driver.quit();
	}
	
	@AfterSuite
	public void stopServer() {
		service.stop();
		System.out.println("Server stopped");
	}
	
}
