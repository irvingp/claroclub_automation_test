package com.claro.miclaroclub.mobile.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.claro.miclaroclub.mobile.providers.CouponsProvider;
import com.relevantcodes.extentreports.LogStatus;

public class Coupons extends BaseClass{

	@BeforeClass
	public void BeforeClass()
	{
		test = report.startTest("Cupones");
	}
	@Test(priority = 1, dataProvider = "ShowFeaturedCouponsProvider", dataProviderClass= CouponsProvider.class)
	public void ShowFeaturedCoupons(String XpathCoupons, String XpathButtonFeaturedCoupons) throws InterruptedException
	{
		test.log(LogStatus.INFO, "Visualizar Cupones Destacados");
		WaitToClik(Android, XpathButtonFeaturedCoupons, 5);
		Android.findElement(By.xpath(XpathButtonFeaturedCoupons)).click();
		time.sleep(1);
		TakeScreenShot("Coupons_1");
		Assert.assertEquals(Android.findElements(By.xpath(XpathCoupons)).size() > 0 , true,"Se muestran los cupones correctamente");	
		
	}
	@Test(priority = 2, dataProvider = "ShowCouponsPromotionProvider", dataProviderClass= CouponsProvider.class)
	public void ShowCouponsPromotion(String XpathCoupons, String XpathButtonPromotionsCoupons) throws InterruptedException
	{
		test.log(LogStatus.INFO, "Visualizar Cupones Destacados");
		WaitToClik(Android, XpathButtonPromotionsCoupons, 5);
		Android.findElement(By.xpath(XpathButtonPromotionsCoupons)).click();
		time.sleep(2);
		TakeScreenShot("Coupons_2");
		Assert.assertEquals(Android.findElements(By.xpath(XpathCoupons)).size() > 0 , true,"Se muestran los cupones correctamente");
	}
}
