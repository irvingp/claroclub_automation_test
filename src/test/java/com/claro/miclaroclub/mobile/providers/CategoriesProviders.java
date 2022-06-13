package com.claro.miclaroclub.mobile.providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

import com.claro.qa.core.Provider;

public class CategoriesProviders extends Provider{

	@DataProvider(name = "ViewCategoriesProvider")
	public static Object[][] ViewCategoriesProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t4XpathButtonCategories").getValue(),
						GetParamLocatorsByName("t4XpathCategories").getValue()
						
					}
				};
	}
}
