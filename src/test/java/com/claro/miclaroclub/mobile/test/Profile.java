package com.claro.miclaroclub.mobile.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.claro.miclaroclub.mobile.providers.ProfileProvider;
import com.relevantcodes.extentreports.LogStatus;

public class Profile extends BaseClass {

	@BeforeClass
	public void BeforeClass()
	{
		test = report.startTest("Pefil");
	}
	
	@Test(priority=1, dataProvider="SavedProvider", dataProviderClass= ProfileProvider.class)
	public void Saved(String XpathButtonProvider, String XpathTextSaved) throws InterruptedException
	{
		test.log(LogStatus.INFO, "Visualizar ahorrado con Claro Club");
		WaitToClik(Android, XpathButtonProvider, 10);
		Android.findElement(By.xpath(XpathButtonProvider)).click();
		time.sleep(1);
		TakeScreenShot("Profile_1");
		Assert.assertEquals(Android.findElements(By.xpath(XpathTextSaved)).size() > 0 , true, "Se muestra correctamente lo ahorrado con Claro Club");
		
	}
}
