package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import base.DriverSetup;
import screens.TestDPCAppScreenAndDeviceSetTimeSettingsScreen;
import base.DriverSetup;

public class VerifyTimeZoneChangeOnDeviceTest extends DriverSetup{
	
	  @Test(priority = 0) public void clickOnSetTimeZoneOption() throws
	  IOException, InterruptedException { 
	  TestDPCAppScreenAndDeviceSetTimeSettingsScreen pap = new TestDPCAppScreenAndDeviceSetTimeSettingsScreen(); 
	  DriverSetup.getDriver().activateApp("com.afwsamples.testdpc");
	  pap.ClickSetTimeZoneOnDpcAppOption();
	  }
	  
	  
	  
	  @Test(priority = 1) public void enterTimeZoneValueInSetTimeZoneInputField()
	  throws IOException, InterruptedException { 
	  TestDPCAppScreenAndDeviceSetTimeSettingsScreen pap = new TestDPCAppScreenAndDeviceSetTimeSettingsScreen();	  
	  pap.SetTimeZone("Australia/Sydney");
	  
	  }
	  
	  
	  
	  @Test(priority = 2) 
	  public void VerifyTimeZoneChangedDueToSetTimeZoneInDPCApp() throws
	  IOException, InterruptedException { 
		  
	  TestDPCAppScreenAndDeviceSetTimeSettingsScreen map = new TestDPCAppScreenAndDeviceSetTimeSettingsScreen();
	  DriverSetup.getDriver().activateApp("com.android.settings");
	  
	  map.searchAndSelectInSettingsAppForSetTimeOption("Set time");

	  String getTimeZoneValueFromSettingsApp = map.getTextOfSetTimeZoneFieldInSettingsApp();

	  assertEquals(getTimeZoneValueFromSettingsApp, "GMT+10:00 Australian Eastern Standard Time");

	  
	  }
	  
		
		  @Test(priority = 2, enabled=false) public void validateTimeZoneChangedOnDevice() throws
		  IOException, InterruptedException { 
		  TestDPCAppScreenAndDeviceSetTimeSettingsScreen map = new TestDPCAppScreenAndDeviceSetTimeSettingsScreen();
		  
		  
		  String deviceTime = DriverSetup.getDriver().getDeviceTime();
		  
		  
		  System.out.println("##$$$####$%%%%  current device time is :" +deviceTime);
		  
		  String timeZoneValueExpacted = "11:00"; String timeZoneValueChangedOnDevice =
		  TestDPCAppScreenAndDeviceSetTimeSettingsScreen.returnTimeZoneValueFromCurrentDeviceTime(deviceTime);
		  
		  assertEquals(timeZoneValueChangedOnDevice, timeZoneValueExpacted);
		  
		  }
		 
		
		
}



