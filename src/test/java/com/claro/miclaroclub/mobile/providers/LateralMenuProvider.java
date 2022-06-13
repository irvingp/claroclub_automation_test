package com.claro.miclaroclub.mobile.providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

import com.claro.qa.core.Provider;

public class LateralMenuProvider extends Provider {

	@DataProvider(name = "EnterMenuProvider")
	public static Object[][] EnterMenuProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t2XpathButtonMenu").getValue()
						
					}
				};
	}
	
	@DataProvider(name = "CheckMenuItemOneProvider")
	public static Object[][] CheckMenuItemOneProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t2XpathMenuOne").getValue(),
						GetParamDataByName("MenuOne").getValue()
					}
				};
	}
	
	@DataProvider(name = "CheckMenuItemTwoProvider")
	public static Object[][] CheckMenuItemTwoProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t2XpathMenuTwo").getValue(),
						GetParamDataByName("MenuTwo").getValue()
						
					}
				};
	}
	@DataProvider(name = "CheckMenuItemThreeProvider")
	public static Object[][] CheckMenuItemThreeProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t2XpathMenuThree").getValue(),
						GetParamDataByName("MenuThree").getValue()
					}
				};
	}
}
