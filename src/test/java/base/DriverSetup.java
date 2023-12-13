package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import base.DriverSetup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverSetup {

private static final ThreadLocal<AndroidDriver>  LOCAL_DRIVER = new ThreadLocal<>();
	
	public static void setDriver(AndroidDriver driver) {
		DriverSetup.LOCAL_DRIVER.set(driver);
	}
	
	
	public static AndroidDriver getDriver() throws MalformedURLException {
	    return LOCAL_DRIVER.get();
	}

	
	public static AndroidDriver setCap() throws MalformedURLException{
		
		 UiAutomator2Options options = new UiAutomator2Options();
	        options.setUdid("1bd8e64c570c7ece");
	        File file = new File("./resources/TestDPC_9001.apk");
	        options.setCapability("appium:app", file.getAbsolutePath());
	        options.setCapability("appium:appPackage", "com.afwsamples.testdpc");
	        options.setCapability("appium:appActivity", "com.afwsamples.testdpc.PolicyManagementActivity");
	        options.setCapability("platformName", "Android");
	        options.setCapability("appium:noReset", "true");
	        options.setCapability("appium:fullReset", "false");
	        options.setCapability("appium:forceAppLaunch", "true");        
	        options.setCapability("appium:platformVersion", "10.0");
	        options.setCapability("appium:automationName", "uiautomator2");
	        
			/*
			 * DesiredCapabilities cap = new DesiredCapabilities(); File file = new
			 * File("./resources/General-Store.apk"); cap.setCapability("platformName",
			 * "android"); cap.setCapability("automationName", "UiAutomator2");
			 * cap.setCapability("deviceName", "HP"); cap.setCapability("udid",
			 * "emulator-5556"); cap.setCapability("app", file.getAbsolutePath());
			 */
	        
		return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	}
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public static synchronized void setAndroiDriver() throws MalformedURLException {
		AndroidDriver driver = setCap(); 
	    LOCAL_DRIVER.set(driver);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void removeApp() throws MalformedURLException {
		getDriver().quit();
	}
}
