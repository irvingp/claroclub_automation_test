package com.claro.miclaroclub.mobile.providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

import com.claro.qa.core.Provider;

public class ThemeProvider extends Provider{

	@DataProvider(name = "SelectThemeProvider")
	public static Object[][] SelectThemeProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t9XpathButtonConfig").getValue(),
						GetParamLocatorsByName("t9XpathButtonTheme").getValue(),
						GetParamLocatorsByName("t9XpathTogleButtonTheme").getValue(),
						
						
					}
				};
	}
}
