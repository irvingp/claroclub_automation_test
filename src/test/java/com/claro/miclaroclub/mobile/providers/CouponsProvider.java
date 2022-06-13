package com.claro.miclaroclub.mobile.providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

import com.claro.qa.core.Provider;

public class CouponsProvider extends Provider {

	@DataProvider(name = "ShowFeaturedCouponsProvider")
	public static Object[][] ShowFeaturedCouponsProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t3XpathCoupons").getValue(),
						GetParamLocatorsByName("t3XpathButtonFeaturedCopupons").getValue()
						
					}
				};
	}
	
	@DataProvider(name = "ShowCouponsPromotionProvider")
	public static Object[][] ShowCouponsPromotionProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t3XpathCoupons").getValue(),
						GetParamLocatorsByName("t3XpathButtonPromotionsCoupons").getValue()
						
					}
				};
	}
}
