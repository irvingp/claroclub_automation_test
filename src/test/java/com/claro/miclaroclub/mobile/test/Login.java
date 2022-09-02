package com.claro.miclaroclub.mobile.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.claro.miclaroclub.configxml.Parameter;
import com.claro.miclaroclub.mobile.providers.LoginProviders;
import com.relevantcodes.extentreports.LogStatus;

  class Login extends BaseClass {

	@BeforeClass
	public void BeforeClass()
	{
		test = report.startTest("WelcomeText");	
	}
	
	@Test(priority = 0,  dataProvider="WelcomeTextProvider", dataProviderClass = LoginProviders.class)
	public void WelcomeText(String XpathWelcomeText) throws IOException
	{
		
		test.log(LogStatus.INFO, "Verifica texto de bienvenida.");
		WaitToClik(Android, XpathWelcomeText, 5);
		TakeScreenShot("Login_1");
		Assert.assertEquals(Android.findElement(By.xpath(XpathWelcomeText)).isDisplayed(), true);	
		
	}
	@Test(priority=1, dataProvider="EnterWithCompetitorsMobileNumberProvider", dataProviderClass=LoginProviders.class)
	public void EnterWithCompetitorsMobileNumber(String ButtonMobileNumber, String XpathCountry, String XpathContinue, String CompetitionPhone, String XpathCompetitionPhone, String XpathBtnContinue)
	{
		test.log(LogStatus.INFO, "Intentar ingresar con un número de la competencia");
		Android.findElement(By.xpath(ButtonMobileNumber)).click();
		WaitToClik(Android, XpathCountry, 10);
		Android.findElement(By.xpath(XpathCountry)).click();
		WaitToClik(Android, XpathContinue, 10);
		Android.findElement(By.xpath(XpathContinue)).click();
		
		test.log(LogStatus.INFO, "Ingresar Número");
		WaitToClik(Android, XpathCompetitionPhone,5);
		Android.findElement(By.xpath(XpathCompetitionPhone)).sendKeys(CompetitionPhone);
		TakeScreenShot("Login_2");
		Android.findElement(By.xpath(XpathBtnContinue)).click();
		
		
	}
	
	@Test(priority = 2, dataProvider="ShowMessageErrorProvider", dataProviderClass=LoginProviders.class)
	public void ShowMessageError(String XpathMessageError, String XpathBtnReturn)
	{
		test.log(LogStatus.INFO, "Muestra mensaje de error?");
		WaitToClik(Android, XpathMessageError, 10);
		TakeScreenShot("Login_3");
		Assert.assertEquals(Android.findElements(By.xpath(XpathMessageError)).size() > 0, true);
		WaitToClik(Android, XpathBtnReturn, 10);
		Android.findElement(By.xpath(XpathBtnReturn)).click();
		
	}
	@Test(priority= 3, dataProvider="ButtonClickResidentialServiceProvider", dataProviderClass=LoginProviders.class)
	public void ButtonClickResidentialService(String xpathButtonClickResidentialService, String XpathBtnBack)
	{
		WaitToClik(Android, XpathBtnBack, 10);
		Android.findElement(By.xpath(XpathBtnBack)).click();
		WaitToClik(Android, XpathBtnBack, 10);
		Android.findElement(By.xpath(XpathBtnBack)).click();
		test.log(LogStatus.INFO, "Hacer click en el boton \"Ingresa con mi servicio residencial\"");
		WaitToClik(Android, xpathButtonClickResidentialService, 10);
		Assert.assertEquals(Android.findElement(By.xpath(xpathButtonClickResidentialService)).isDisplayed(), true);
		Android.findElement(By.xpath(xpathButtonClickResidentialService)).click();
	}
	
	@Test(priority = 4, dataProvider="CountrySelectProvider", dataProviderClass = LoginProviders.class)
	public void CountrySelect(String XpathCountryButton, String XpathButtonContinue) throws IOException
	{
		test.log(LogStatus.INFO, "Selecciona el país");
		WaitToClik(Android, XpathCountryButton, 10);
		TakeScreenShot("Login_4");
		Android.findElement(By.xpath(XpathCountryButton)).click();
		WaitToClik(Android, XpathButtonContinue, 10);
		Android.findElement(By.xpath(XpathButtonContinue)).click();
		
	}
	@Test(priority=5, dataProvider="RequestEmailProvider", dataProviderClass=LoginProviders.class)
	public void RequestEmail(String XpathEmail)
	{
		test.log(LogStatus.INFO, "Solicita Email?");
		WaitToClik(Android, XpathEmail, 10);
		TakeScreenShot("Login_5");
		Assert.assertEquals(Android.findElements(By.xpath(XpathEmail)).size() > 0 , true);
		
	}
	@Test(priority=6, dataProvider="RequestPhoneProvider", dataProviderClass=LoginProviders.class)
	public void RequestPhone(String XpathPhone)
	{
		test.log(LogStatus.INFO, "Solicita Número Celular?");
		WaitToClik(Android, XpathPhone, 10);
		TakeScreenShot("Login_6");
		Assert.assertEquals(Android.findElements(By.xpath(XpathPhone)).size() > 0 , true);	
	}
	
	@Test(priority = 7, dataProvider="LoginAppProvider", dataProviderClass=LoginProviders.class )
	public void LoginAppFixedService(List<Parameter> Servicios, String Email, String Phone, String XpathService, String XpathEmail, String XpathPhone, String XpathGetInto, String XpathErrorMessage, String XpathErrorMessage2, String XpathLogoClaroClub, String XpathButtonClickResidentialService, String IdPermissions, String XpathCountry)throws IOException
	{
		test.log(LogStatus.INFO, "Ingresar en Mi Claro Club");
	
		
	
		for(Parameter param : Servicios)
		{
			test.log(LogStatus.INFO, "Inicio de sesión con número de servicio " + param.getValue());
			WaitToClik(Android, XpathService, 4);
			Android.findElement(By.xpath(XpathService)).sendKeys(param.getValue());
			Android.findElement(By.xpath(XpathEmail)).sendKeys(Email);
			Android.findElement(By.xpath(XpathPhone)).sendKeys(Phone);
			Android.findElement(By.xpath(XpathGetInto)).click();
			
			WaitToClikById(Android, IdPermissions, 3);
			if(Android.findElements(By.id(IdPermissions)).size()> 0 )
			{
				Android.findElement(By.id(IdPermissions)).click();	
			}
			WaitToClik(Android, XpathLogoClaroClub, 3);
			if(Android.findElements(By.xpath(XpathLogoClaroClub)).size() > 0)
			{ 
				
					TakeScreenShot("Login_Service_"+ param.getValue());
					Assert.assertTrue(true);
					break;		
			
			}		
			else if(Android.findElements(By.xpath(XpathErrorMessage)).size() > 0 )
			{
				TakeScreenShot("Login_Service_"+ param.getValue());
				test.log(LogStatus.FAIL, "Falló inicio de sesión");
				Android.navigate().back();
				Assert.assertTrue(false);
				return;
			}
			
			 else if(Android.findElements(By.xpath(XpathErrorMessage)).size() > 0 )
			{
				TakeScreenShot("Login_Service_"+ param.getValue());
				test.log(LogStatus.FAIL, "Falló inicio de sesión");
				Assert.assertTrue(false);				
				return;
			}			
		}
		
		
		
		
		
	}
	
}
