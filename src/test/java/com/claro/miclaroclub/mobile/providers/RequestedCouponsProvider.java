package com.claro.miclaroclub.mobile.providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

import com.claro.qa.core.Provider;

public class RequestedCouponsProvider extends Provider{
	
	
	@DataProvider(name = "RequestCouponProvider")
	public static Object[][] RequestCouponProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t3XpathButtonFeaturedCopupons").getValue(),
						GetParamLocatorsByName("t6XpathButtonOutstanding").getValue(),
						GetParamLocatorsByName("t3XpathCoupons").getValue(),
						GetParamLocatorsByName("t6XpathButtonGetCoupons").getValue(),
						GetParamLocatorsByName("t6XpathButtonOk").getValue(),
						
						
					}
				};
	}
	
	@DataProvider(name = "ViewRequestedCouponsProvider")
	public static Object[][] ViewRequestedCouponsProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t5XpathButtonPerfil").getValue(),
						GetParamLocatorsByName("t6XpathButtonRequestedCoupons").getValue(),
						GetParamLocatorsByName("t6XpathCoupons").getValue(),
						GetParamLocatorsByName("t1XpathButtonBack").getValue(),
						GetParamLocatorsByName("t6XpathButtonGetCoupons").getValue()
						
					}
				};
	}
	
}
