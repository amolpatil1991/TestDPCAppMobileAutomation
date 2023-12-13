package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.time.Instant;

import org.testng.annotations.Test;


import base.DriverSetup;
import screens.TestDPCAppScreenAndDeviceSetTimeSettingsScreen;

public class VerifyTimeChangeOnDeviceTest extends DriverSetup{

	
	 String enteredTimeInDPCApp;
	 String timeShownOnSettingsAppBeforeChanges;
	 String timeShownOnSettingsAppAfterChanges;
	 
	@Test(priority = 1)
	public void clickOnSetTimeOptionOfDCPApp() throws IOException, InterruptedException {
		TestDPCAppScreenAndDeviceSetTimeSettingsScreen map = new TestDPCAppScreenAndDeviceSetTimeSettingsScreen();

		DriverSetup.getDriver().activateApp("com.afwsamples.testdpc");
		map.ClickSetTimeOnDpcAppOption();
	}
	
	
	
	@Test(priority = 2)
	public void enterMilliSecsValueInSetTimeInputField() throws IOException, InterruptedException {
		TestDPCAppScreenAndDeviceSetTimeSettingsScreen map = new TestDPCAppScreenAndDeviceSetTimeSettingsScreen();

		enteredTimeInDPCApp= map.generateTimeValueToEnterInMilliSeconds();
		map.SetTimeInMilliSeconds(enteredTimeInDPCApp);
		
	}
	
	
	@Test(priority = 0)
	public void getSetTimeValueOnSettingsAppBeforeChangeByTestDPCApp() throws IOException, InterruptedException {
		TestDPCAppScreenAndDeviceSetTimeSettingsScreen map = new TestDPCAppScreenAndDeviceSetTimeSettingsScreen();
		
		DriverSetup.getDriver().activateApp("com.android.settings");
		
		map.searchAndSelectInSettingsAppForSetTimeOption("Set time");
		timeShownOnSettingsAppBeforeChanges = map.getTextOfSetTimeFieldInSettingsApp();
		
		System.out.println("############### time shown on settings is :" +timeShownOnSettingsAppBeforeChanges);
		
	}
	
	@Test(priority = 3)
	public void getSetTimeValueOnSettingsAppAfterChangeByTestDPCApp() throws IOException, InterruptedException {
		TestDPCAppScreenAndDeviceSetTimeSettingsScreen map = new TestDPCAppScreenAndDeviceSetTimeSettingsScreen();
		
		DriverSetup.getDriver().activateApp("com.android.settings");
		
		map.searchAndSelectInSettingsAppForSetTimeOption("Set time");
		timeShownOnSettingsAppAfterChanges = map.getTextOfSetTimeFieldInSettingsApp();
		
		System.out.println("############### time shown on settings is :" +timeShownOnSettingsAppAfterChanges);
		
	}
	
	
	@Test(priority = 4)
	public void VerifyTimeChangedDueToSetTimeInDPCApp() throws IOException, InterruptedException {
		TestDPCAppScreenAndDeviceSetTimeSettingsScreen map = new TestDPCAppScreenAndDeviceSetTimeSettingsScreen();
		
		assertNotEquals(timeShownOnSettingsAppBeforeChanges, timeShownOnSettingsAppAfterChanges);
		
	}
	
	
	
	
	  @Test(priority = 2, enabled=false) public void validateTimeChangedOnDevice() throws
	  IOException, InterruptedException { 
		  TestDPCAppScreenAndDeviceSetTimeSettingsScreen map = new TestDPCAppScreenAndDeviceSetTimeSettingsScreen();
	  
	  
	  
	  String deviceTime = DriverSetup.getDriver().getDeviceTime();
	  
	  System.out.println("##$$$####$%%%%  current device time is :" +deviceTime);
	  
	  
	  
	  Instant instant = Instant.parse(DriverSetup.getDriver().getDeviceTime());
	  
	  long value = instant.toEpochMilli();
	  
	  String s=String.valueOf(value);
	  
	  System.err.println("############TestDPC app time is :" +enteredTimeInDPCApp);
	  
	  System.err.println("************device time is :" +s);
	  
	  assertEquals(TestDPCAppScreenAndDeviceSetTimeSettingsScreen.compareFirst10Digits(enteredTimeInDPCApp, s), true);
	  
	  
	  }
	 
	
}
