	package com.claro.miclaroclub.mobile.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.claro.miclaroclub.mobile.providers.RedeemedCouponsProvider;
import com.relevantcodes.extentreports.LogStatus;

public class RedeemedCoupons extends BaseClass{

	@BeforeClass
	public void BeforeClass()
	{
		test = report.startTest("Cupones Canjeados");
	}
	
	@Test(priority=1, dataProvider="SeeRedeemedcouponsProvider", dataProviderClass=RedeemedCouponsProvider.class)	
	public void SeeRedeemedcoupons(String XpathButtonRedeemedCoupons, String XpathCoupons) throws InterruptedException
	{
		Android.navigate().back();
		test.log(LogStatus.INFO, "Ver cupones canjeados");
		WaitToClik(Android, XpathButtonRedeemedCoupons, 0);
		Android.findElement(By.xpath(XpathButtonRedeemedCoupons)).click();
		time.sleep(1);
		TakeScreenShot("RedeemedCoupons_1");
		Assert.assertEquals(Android.findElements(By.xpath(XpathCoupons)).size() > 0 , true, "Se visualizan los cupones canjeados");
		
	}
	
}
