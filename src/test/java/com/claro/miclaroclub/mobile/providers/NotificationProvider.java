package com.claro.miclaroclub.mobile.providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

import com.claro.qa.core.Provider;

public class NotificationProvider extends Provider{

	@DataProvider(name = "EnableDisableNotificationsProvider")
	public static Object[][] EnableDisableNotificationsProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t10XpathButtonNotification").getValue(),
						GetParamLocatorsByName("t10XpathTogleButtonNotification").getValue(),
						
						
						
					}
				};
	}
}
