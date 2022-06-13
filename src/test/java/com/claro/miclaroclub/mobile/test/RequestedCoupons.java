package com.claro.miclaroclub.mobile.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.claro.miclaroclub.mobile.providers.RequestedCouponsProvider;
import com.relevantcodes.extentreports.LogStatus;

public class RequestedCoupons extends BaseClass{

	@BeforeClass
	public void BeforeClass()
	{
		test = report.startTest("Cupones Solicitados");
	}
	
	@Test(priority=1, dataProvider="RequestCouponProvider", dataProviderClass=RequestedCouponsProvider.class)
	public void RequestCoupon(String XpathButtonFeaturedCopupons, String XpathButtonOutstanding, String XpathCoupons,String XpathButtonGetCoupons, String XpathButtonOk) throws InterruptedException
	{
		test.log(LogStatus.INFO, "Solicitar cupon");
		WaitToClik(Android, XpathButtonFeaturedCopupons, 2);
		Android.findElement(By.xpath(XpathButtonFeaturedCopupons)).click();
		WaitToClik(Android, XpathButtonOutstanding, 3);
		Android.findElement(By.xpath(XpathButtonOutstanding)).click();
		time.sleep(1);
		TakeScreenShot("RequestedCoupons_1");
		
		
		if(Android.findElements(By.xpath(XpathCoupons)).size() == 0)
		{
			Assert.assertTrue(false, "No se encuentran cupones a solicitar");
			
		}
		
			Android.findElements(By.xpath(XpathCoupons)).get(0).click();
			WaitToClik(Android, XpathButtonGetCoupons, 10);
			test.log(LogStatus.INFO, "Seleccionar el primer cupon presentado en pantalla");
			TakeScreenShot("RequestedCoupons_2");
			Android.findElement(By.xpath(XpathButtonGetCoupons)).click();
			test.log(LogStatus.INFO, "Click en Obtener cupon");
			WaitToClik(Android, XpathButtonOk, 10);
			TakeScreenShot("RequestedCoupons_3");
			Android.findElement(By.xpath(XpathButtonOk)).click();
			
			
		
		
	}
	
	@Test(priority=2, dataProvider="ViewRequestedCouponsProvider", dataProviderClass=RequestedCouponsProvider.class, alwaysRun = true)
	public void ViewRequestedCoupons(String XpathButtonPerfil, String XpathButtonRequestedCoupons, String XpathCoupons,String XpathButtonBack, String XpathButtonGetCoupons) throws InterruptedException
	{
		
		if(Android.findElements(By.xpath(XpathButtonBack)).size()>0 )
		{
			WaitToClik(Android, XpathButtonBack, 5);
			Android.findElement(By.xpath(XpathButtonBack)).click();
		}
		time.sleep(2);
		if(Android.findElements(By.xpath(XpathButtonGetCoupons)).size()>0)
		{
			Android.navigate().back();
		}
		
		test.log(LogStatus.INFO, "Visualizar cupones solicitados");
		WaitToClik(Android, XpathButtonPerfil, 10);
		Android.findElement(By.xpath(XpathButtonPerfil)).click();
		WaitToClik(Android, XpathButtonRequestedCoupons, 10);
		time.sleep(1);
		TakeScreenShot("RequestedCoupons_4");
		Android.findElement(By.xpath(XpathButtonRequestedCoupons)).click();
		
		test.log(LogStatus.INFO, "Verificar si se muestran los cupones solicitados");
		time.sleep(1);
		TakeScreenShot("RequestedCoupons_5");
		Assert.assertEquals(Android.findElements(By.xpath(XpathCoupons)).size() > 0, true, "Cupones visualizados correctamente");
		
		
	}
}
