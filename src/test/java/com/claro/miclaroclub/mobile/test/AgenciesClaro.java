package com.claro.miclaroclub.mobile.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.claro.miclaroclub.mobile.providers.AgenciesClaroProvider;
import com.relevantcodes.extentreports.LogStatus;

public class AgenciesClaro extends BaseClass{

	@BeforeClass
	public void BeforeClass()
	{
		test = report.startTest("Agencias Claro");
	}
	
	@Test(priority=1, dataProvider="ViewClaroAgenciesProvider", dataProviderClass=AgenciesClaroProvider.class)
	public void ViewClaroAgencies(String XpathButtonClaroAgencies, String XpathButtonStateSelector, String XpathButtonState, String XpathLocations) throws InterruptedException
	{
		Android.navigate().back();
		test.log(LogStatus.INFO, "Visualizar Agencias Claro");
		WaitToClik(Android, XpathButtonClaroAgencies, 5);		
		Android.findElement(By.xpath(XpathButtonClaroAgencies)).click();
		time.sleep(1);
		TakeScreenShot("AgenciesClaro_1");
		
		test.log(LogStatus.INFO, "Click en Seleccionar un Departamento");		
		WaitToClik(Android, XpathButtonStateSelector, 5);
		Android.findElement(By.xpath(XpathButtonStateSelector)).click();
		time.sleep(1);
		TakeScreenShot("AgenciesClaro_2");
		
		test.log(LogStatus.INFO, "Seleccionar una Comunidad/Zona.");
		WaitToClik(Android, XpathButtonState, 5);
		Android.findElement(By.xpath(XpathButtonState)).click();
		time.sleep(1);
		TakeScreenShot("AgenciesClaro_3");
		
		test.log(LogStatus.INFO, "Se visualizan las Agencias correctamente");
		
		TakeScreenShot("AgenciesClaro_4");
		Assert.assertEquals(Android.findElements(By.xpath(XpathLocations)).size() > 0, true, "Se muestran las Agencias correctamente.");
		
	}
}
