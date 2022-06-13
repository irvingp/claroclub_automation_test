package com.claro.miclaroclub.mobile.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.claro.miclaroclub.mobile.providers.LateralMenuProvider;
import com.relevantcodes.extentreports.LogStatus;

public class LateralMenu extends BaseClass{

	@BeforeClass
	public void BeforeClass()
	{
		test = report.startTest("Menu Lateral");
	}
	
	@Test(priority = 1, dataProvider = "EnterMenuProvider", dataProviderClass= LateralMenuProvider.class)
	public void EnterMenu(String XpathButtonMenu)
	{
		test.log(LogStatus.INFO, "Abrir Menú");
		WaitToClik(Android, XpathButtonMenu, 10);
		Android.findElement(By.xpath(XpathButtonMenu)).click();
	
	}

	@Test(priority = 2, dataProvider = "CheckMenuItemOneProvider", dataProviderClass= LateralMenuProvider.class)
	public void CheckMenuItemOne(String XpathMenuOne, String MenuOne)
	{
		test.log(LogStatus.INFO, "Verifica item 1 del menú: " + MenuOne);
		WaitToClik(Android, XpathMenuOne, 1);
		TakeScreenShot("LateralMenu_1");
		Assert.assertEquals(Android.findElements(By.xpath(XpathMenuOne)).size()>0, true);
		
	}
	
	@Test(priority = 3, dataProvider = "CheckMenuItemTwoProvider", dataProviderClass= LateralMenuProvider.class)
	public void CheckMenuItemTwo(String XpathMenuTwo, String MenuTwo)
	{
		test.log(LogStatus.INFO, "Verifica item 2 del menú: "+ MenuTwo);
		WaitToClik(Android, XpathMenuTwo, 1);
		TakeScreenShot("LateralMenu_1");
		Assert.assertEquals(Android.findElements(By.xpath(XpathMenuTwo)).size()>0, true);
		
	}
	@Test(priority = 4, dataProvider = "CheckMenuItemThreeProvider", dataProviderClass= LateralMenuProvider.class)
	public void CheckMenuItemThree(String XpathMenuThree, String MenuThree)
	{
		test.log(LogStatus.INFO, "Verifica item 3 del menú: " + MenuThree);
		WaitToClik(Android, XpathMenuThree, 1);
		TakeScreenShot("LateralMenu_1");
		Assert.assertEquals(Android.findElements(By.xpath(XpathMenuThree)).size()>0, true);
		Android.navigate().back();
	}
	
	
}
