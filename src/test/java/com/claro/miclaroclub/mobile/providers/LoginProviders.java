package com.claro.miclaroclub.mobile.providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

import com.claro.qa.core.Provider;

public class LoginProviders extends Provider {

	@DataProvider(name = "WelcomeTextProvider")
	public static Object[][] WelcomeTextProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t1XpathWelcomeText").getValue()
						
					}
				};
	}
	
	@DataProvider(name = "ButtonClickResidentialServiceProvider")
	public static Object[][] ButtonClickResidentialServiceProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t1XpathButtonClickResidentialService").getValue(),
						GetParamLocatorsByName("t1XpathButtonBack").getValue()
						
					}
				};
	}
	
	@DataProvider(name = "CountrySelectProvider")
	public static Object[][] CountrySelectProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("XpathCountry").getValue(),
						GetParamLocatorsByName("t1XpathButtonCountryContinue").getValue()
						
					}
				};
	}
	@DataProvider(name="EnterWithCompetitorsMobileNumberProvider")
	public static Object[][] EnterWithCompetitorsMobileNumberProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t1XpathButtonMobilePhone").getValue(),
						GetParamLocatorsByName("XpathCountry").getValue(),
						GetParamLocatorsByName("t1XpathButtonCountryContinue").getValue(),
						GetParamDataByName("PhoneCompetition").getValue(),
						GetParamLocatorsByName("t1XpathNumber").getValue(),
						GetParamLocatorsByName("t1XpathButtonContinue").getValue()
						
						
					}
				};
	}
	
	@DataProvider(name="ShowMessageErrorProvider")
	public static Object[][] ShowMessageErrorProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						
						GetParamLocatorsByName("t1XpathMessageError").getValue(),
						GetParamLocatorsByName("t1XpathButtonReturn").getValue()
						
					}
				};
	}
	
	@DataProvider(name = "LoginAppProvider")
	public static Object[][] LoginAppProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetListDataByParam("servicio"),
						GetParamDataByName("email").getValue(),
						GetParamDataByName("Phone").getValue(),
						GetParamLocatorsByName("t1XpathTextService").getValue(),
						GetParamLocatorsByName("t1XpthTextEmail").getValue(),
						GetParamLocatorsByName("t1XpathTextPhone").getValue(),
						GetParamLocatorsByName("t1XpathButtonGetInto").getValue(),
						GetParamLocatorsByName("t1XpathErrorMessage").getValue(),
						GetParamLocatorsByName("t1XpathMessageError").getValue(),
						GetParamLocatorsByName("t1XpathLogoClaroClub").getValue(),
						GetParamLocatorsByName("t1XpathButtonClickResidentialService").getValue(),
						GetParamLocatorsByName("t1IdPermissions").getValue(),
						GetParamLocatorsByName("XpathCountry").getValue()
						
					}
				};
	}
	
	@DataProvider(name = "RequestEmailProvider")
	public static Object[][] RequestEmailProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						
						GetParamLocatorsByName("t1XpthTextEmail").getValue(),
						
						
					}
				};
	}
	
	@DataProvider(name = "RequestPhoneProvider")
	public static Object[][] RequestPhoneProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						
						GetParamLocatorsByName("t1XpathTextPhone").getValue(),
						
						
					}
				};
	}
}
