package com.claro.qa.core;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.claro.miclaroclub.configxml.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;



public class AppiumMain {
	public static ExtentReports report;
	public static ExtentTest test;
	public static AndroidDriver<MobileElement> Android;
	public static TimeUnit time;
	public static String SuiteName;
	

	
	
	public AndroidDriver<MobileElement> GetAndroidInstance(String DEVICE_NAME, String UDID, String PLATAFORM_NAME, String PLATAFORM_VERSION,int NEW_COMMAND_TIMEOUT, String APP_PACKAGE, String APP_ACTIVITY) throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities(); 
		
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, 		DEVICE_NAME);
		caps.setCapability(MobileCapabilityType.UDID, 		 		UDID);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,		PLATAFORM_NAME);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, 	PLATAFORM_VERSION);		
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, NEW_COMMAND_TIMEOUT);
		caps.setCapability("appPackage", APP_PACKAGE);
		caps.setCapability("appActivity", APP_ACTIVITY);
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		time = TimeUnit.SECONDS;
		return Android = new AndroidDriver<MobileElement>(url, caps);
	}
	
	
	
	public void WaitToClik(AndroidDriver<MobileElement> Android, String targetResourceXpath , long timeLimitInSeconds)
	{
		try {
			
			WebDriverWait wait = new WebDriverWait(Android, timeLimitInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(targetResourceXpath)));
			
		} catch (Exception ex) {	
			  System.out.println("Message is: " + ex.getMessage());
			  System.out.println("Cause is: " + ex.getCause());
			  System.out.println(ex.getStackTrace());			
		}
	}
	public void WaitToClikById(AndroidDriver<MobileElement> Android, String Id , long timeLimitInSeconds)
	{
		try {
			
			WebDriverWait wait = new WebDriverWait(Android, timeLimitInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Id)));
			
		} catch (Exception ex) {	
			  System.out.println("Message is: " + ex.getMessage());
			  System.out.println("Cause is: " + ex.getCause());
			  System.out.println(ex.getStackTrace());			
		}
	}
	
	public void TakeScreenShot(String FileName)
	{
		
		File scrFile = ((TakesScreenshot)Android).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("ScreenShot/"+SuiteName+"_"+FileName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Captura de Pantalla: " + test.addScreenCapture("ScreenShot/"+SuiteName+"_"+FileName+".png"));
	}
	
	public void scrollToUp() {

	      int  x = Android.manage().window().getSize().width / 2;
	      int start_y = (int) (Android.manage().window().getSize().height * 0.8);
	      int end_y = (int) (Android.manage().window().getSize().height * 0.2);
	        TouchAction dragNDrop = new TouchAction(Android)
	                        .press(PointOption.point(x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	                        .moveTo(PointOption.point(x, end_y))
	                        .release();
	        dragNDrop.perform();
	    }
	
	public void scrollToDown() {

	      int  x = Android.manage().window().getSize().width / 2;
	      int start_y = (int) (Android.manage().window().getSize().height * 0.2);
	      int end_y = (int) (Android.manage().window().getSize().height * 0.8);
	        TouchAction dragNDrop = new TouchAction(Android)
	                        .press(PointOption.point(x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	                        .moveTo(PointOption.point(x, end_y))
	                        .release();
	        dragNDrop.perform();
	    }
	
	public Parameter FilterParam(List<Parameter> Param, String nameParam)
	{
		return Param.stream().filter(parameter-> nameParam.equals(parameter.getName()))
				.findAny()
				.orElse(null);
	}
	
    public synchronized static ExtentReports getReporter(String filePath) {
        if (report == null) {
        	report = new ExtentReports(filePath, true);
        	report.loadConfig(new File("extendsreport.xml"));
        }
        
        return report;
    }

}
