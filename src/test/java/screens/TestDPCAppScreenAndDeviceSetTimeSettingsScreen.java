package screens;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import base.DriverSetup;
import io.appium.java_client.android.AndroidDriver;
import static base.DriverSetup.getDriver;

public class TestDPCAppScreenAndDeviceSetTimeSettingsScreen{
	
//		driverSetup driver = new driverSetup();
	
		public TestDPCAppScreenAndDeviceSetTimeSettingsScreen() throws MalformedURLException {
			PageFactory.initElements(getDriver(), this);
		}
		
		@FindBy(xpath="//android.widget.TextView[@text=\"Set time(Unix timestamp in milliseconds)\"]")
		  @CacheLookup
		  WebElement setTimeOnDpcAppOption;
		  
		  
		  
		  @FindBy(xpath ="//android.widget.EditText[@resource-id=\"com.afwsamples.testdpc:id/input\"]")
		  @CacheLookup
		  WebElement setTimeOnDpcAppInputField;
		  
		  
		  
		  @FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
		  @CacheLookup
		  WebElement promptOkButton; 
		  
		  
		  @FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Set timezone\"]")
		  @CacheLookup
		  WebElement setTimeZoneOnDpcAppOption;
		  
		  
		  @FindBy(xpath ="//android.widget.EditText[@resource-id=\"com.afwsamples.testdpc:id/input\"]")
		  @CacheLookup
		  WebElement setTimeZoneOnDpcAppInputField;
		  
		  @FindBy(xpath =" //android.widget.Button[@content-desc=\"Search settings\"]")
		  @CacheLookup
		  WebElement settingsAppSearchOption;
		  
		  @FindBy(xpath ="//android.widget.EditText[@resource-id=\"com.android.settings.intelligence:id/search_src_text\"]")
		  @CacheLookup
		  WebElement settingsAppSearchInputField;
		  
		  @FindBy(xpath ="//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Set time\"]")
		  @CacheLookup
		  WebElement settingsAppSetTimeResultOptionFromSearchResultList;
		  
		  @FindBy(xpath ="//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Set time\"]/following-sibling::android.widget.TextView[@resource-id=\"android:id/summary\"]")
		  @CacheLookup
		  WebElement settingsAppSetTimeValue;
		  
		  @FindBy(xpath ="//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Select time zone\"]/following-sibling::android.widget.TextView[@resource-id=\"android:id/summary\"]")
		  @CacheLookup
		  WebElement settingsAppSetTimeZoneValue;
		  
		  public void SetTimeInMilliSeconds(String value) {
			  setTimeOnDpcAppInputField.clear();
			  setTimeOnDpcAppInputField.sendKeys(value);
			  promptOkButton.click();
		  }
		  
		  public void searchAndSelectInSettingsAppForSetTimeOption(String value) {
			  settingsAppSearchOption.click();
			  settingsAppSearchInputField.sendKeys(value);
			  settingsAppSetTimeResultOptionFromSearchResultList.click();
		  }
		  
		  public String getTextOfSetTimeFieldInSettingsApp() {
			  
			  return settingsAppSetTimeValue.getText();
		  }
		  
		  public String getTextOfSetTimeZoneFieldInSettingsApp() {
			  
			  return settingsAppSetTimeZoneValue.getText();
		  }

		  public void SetTimeZone(String value) {
			  setTimeZoneOnDpcAppInputField.clear();
			  setTimeZoneOnDpcAppInputField.sendKeys(value);
			  promptOkButton.click();
		  }
		  
		  public String getTimeInMilliSecondsSetInDpcApp()
		  {
			  String getTimeInMilliSecondsSetInDpcApp = setTimeOnDpcAppInputField.getText();
			  
			  return getTimeInMilliSecondsSetInDpcApp;
		  }
		  
		  
		  public void ClickSetTimeOnDpcAppOption() {
			  setTimeOnDpcAppOption.click();
		  }
		  
		  public void ClickSetTimeZoneOnDpcAppOption() {
			  setTimeZoneOnDpcAppOption.click();
		  }
		  
		  public void ClickPromptOkButton() {
			  promptOkButton.click();
		  }
		  
		  public void clearSetTimeFieldOnDpcApp()
		  {
			
			  setTimeOnDpcAppInputField.clear();
			  
		  }
		  
		  public void clearSetTimeZoneFieldOnDpcApp()
		  {
			
			  setTimeZoneOnDpcAppInputField.clear();
			  
		  }
		  
		  public String generateTimeValueToEnterInMilliSeconds()
		  {
			  Random random = new Random();
			  StringBuilder sb = new StringBuilder();
			    sb.append(11); // Starting digit
			    for (int i = 0; i < 11; i++) {
			      sb.append(random.nextInt(10)); // Generate remaining 11 digits
			    }
			    String randomLong = sb.toString();
			    
			    return randomLong;
		  }
		  
		  public static boolean compareFirst10Digits(String str1, String str2) {
			  
			    // Extract the first 10 digits of each string
			    String first10Str1 = str1.substring(0, 8);
			    String first10Str2 = str2.substring(0, 8);

			    // Compare the extracted strings
			    return first10Str1.equals(first10Str2);
			  }
		  
		  public static String returnTimeZoneValueFromCurrentDeviceTime(String str) {
			  
			  int index = str.indexOf("+");

			 return str.substring(index + 1);
			  
			  }

}
