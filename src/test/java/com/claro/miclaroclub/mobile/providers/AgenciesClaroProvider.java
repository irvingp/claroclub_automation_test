package com.claro.miclaroclub.mobile.providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

import com.claro.qa.core.Provider;

public class AgenciesClaroProvider extends Provider {

	@DataProvider(name = "ViewClaroAgenciesProvider")
	public static Object[][] ViewClaroAgenciesProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t8XpathButtonClaroAgencies").getValue(),
						GetParamLocatorsByName("t8XpathButtonStateSelector").getValue(),
						GetParamLocatorsByName("t8XpathButtonState").getValue(),
						GetParamLocatorsByName("t8XpathLocations").getValue()
						
					}
				};
	}
}
