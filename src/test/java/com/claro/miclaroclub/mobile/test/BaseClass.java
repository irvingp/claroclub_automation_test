package com.claro.miclaroclub.mobile.test;

import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.claro.qa.core.AppiumMain;
import com.claro.qa.core.ExtentManager;
import com.claro.qa.core.Provider;
import com.relevantcodes.extentreports.LogStatus;


public class BaseClass extends AppiumMain {


	
	@BeforeSuite
	@Parameters("Country")
	public void BeforeSuit(String Country, ITestContext context) throws MalformedURLException
	{
		SuiteName = context.getSuite().getName();
		Android =  GetAndroidInstance("Redmi Note 9","059297700405","Android","11 RP1A.200720.011",60,"club.claro","club.claro.MainActivity");
		report = ExtentManager.getReporter(SuiteName+"ExtendsReport-ClaroClub.html");
		Provider.setDirectory(Country);
		
	}
	
	@AfterMethod
    protected void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
	        test.log(LogStatus.FAIL, result.getThrowable().getMessage());
	    } else if (result.getStatus() == ITestResult.SKIP) {
	        test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable().getMessage());
	    } else {
	    	test.log(LogStatus.PASS, "Test passed");
	    		}
    
		report.endTest(test);        
		report.flush();
    }
	
	@AfterSuite
	public void TearDown()
	{
		System.out.println("After Suit");
		report.close();
		Android.quit();
		
		
	}

	
}
