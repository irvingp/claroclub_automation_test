package com.claro.miclaroclub.mobile.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.claro.miclaroclub.mobile.providers.ThemeProvider;
import com.relevantcodes.extentreports.LogStatus;

public class Theme extends BaseClass {

	@BeforeClass
	public void BeforeClass()
	{
		test = report.startTest("Temas");
	}
	
	@Test(priority=1, dataProvider="SelectThemeProvider", dataProviderClass=ThemeProvider.class)
	public void SelectTheme(String XpathButtonConfig, String XpathButtonTheme, String XpathTogleButtonTheme) throws InterruptedException
	{
		Android.navigate().back();
		test.log(LogStatus.INFO, "Selecciona Configuraciones");
		WaitToClik(Android, XpathButtonConfig, 5);		
		Android.findElement(By.xpath(XpathButtonConfig)).click();
		time.sleep(1);
		TakeScreenShot("Theme_1");
		
		test.log(LogStatus.INFO, "Selecciona la Opcion Temas");
		WaitToClik(Android, XpathButtonTheme, 5);
		Android.findElement(By.xpath(XpathButtonTheme)).click();
		time.sleep(1);
		test.log(LogStatus.INFO, "Tema Claro");
		TakeScreenShot("Theme_2");		
		
		WaitToClik(Android, XpathTogleButtonTheme, 5);
		Android.findElement(By.xpath(XpathTogleButtonTheme)).click();
		time.sleep(1);
		test.log(LogStatus.INFO, "Tema Oscuro");
		TakeScreenShot("Theme_3");
		
		
		Android.findElement(By.xpath(XpathTogleButtonTheme)).click();
		Android.navigate().back();
	}
}
