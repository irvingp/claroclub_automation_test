package com.claro.miclaroclub.mobile.providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

import com.claro.qa.core.Provider;

public class RedeemedCouponsProvider extends Provider{
	
	@DataProvider(name = "SeeRedeemedcouponsProvider")
	public static Object[][] SeeRedeemedcouponsProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t7XpathButtonRedeemedCoupons").getValue(),
						GetParamLocatorsByName("t7XpathCoupons").getValue()
						
					}
				};
	}
}
