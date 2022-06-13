package com.claro.miclaroclub.mobile.providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

import com.claro.qa.core.Provider;

public class ProfileProvider extends Provider {

	@DataProvider(name = "SavedProvider")
	public static Object[][] SavedProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t5XpathButtonPerfil").getValue(),
						GetParamLocatorsByName("t5XpathTextAhorradoClaroClub").getValue()
						
					}
				};
	}
}
