# TestDPCAppMobileAutomation
This repo covers mobile automation scenarios for TestDPC app on android device

# softwares used
1. Eclipse IDE
2. Appium Inspector
3. TestNG
4. appium 2.0.1
5. java
6. android studio
7. windows system

# important folders 
1. src/test/java/base - contains driver setup class to initilize driver and invoke the device connected with capabilities
2. src/test/java/screens - contains page class to initilize elements and actions
3. src/test/java/tests - contains testNG test classes to execute test cases
4. resources - contains the apk file
5.  


# How to run the code
1. connect physical device to your computer
2. copy device id by writing - adb devices command in command prompt and add in the capabilities code
1. start the appium server from command prompt by writing - appium command
2. right click on project name and run as - maven test OR
3. right click on testng.xml file and run as - TestNG Suite

# Execution reports
1. target - surefire-reports folder OR
2. test-output folder

