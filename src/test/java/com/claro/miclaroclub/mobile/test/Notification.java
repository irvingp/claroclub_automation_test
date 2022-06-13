package com.claro.miclaroclub.mobile.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.claro.miclaroclub.mobile.providers.NotificationProvider;
import com.relevantcodes.extentreports.LogStatus;

public class Notification extends BaseClass{

	@BeforeClass
	public void BeforeClass()
	{
		test = report.startTest("Notificaciones","Seleccionar habilitar /deshabilitar notificaciones");
	}
	@Test(priority=1, dataProvider="EnableDisableNotificationsProvider", dataProviderClass=NotificationProvider.class)
	public void EnableDisableNotifications(String XpathButtonNotification, String XpathTogleButtonNotification) throws InterruptedException
	{
		test.log(LogStatus.INFO, "Ingresar a la pantalla de Habilitar/Deshabilitar Notificaciones");
		WaitToClik(Android, XpathButtonNotification, 5);		
		Android.findElement(By.xpath(XpathButtonNotification)).click();
		time.sleep(1);
		TakeScreenShot("Notification_1");
		
		test.log(LogStatus.INFO, "Deshabilitar notificaciones");
		WaitToClik(Android, XpathTogleButtonNotification, 5);
		Android.findElement(By.xpath(XpathTogleButtonNotification)).click();
		time.sleep(1);
		TakeScreenShot("Notification_2");
		
		test.log(LogStatus.INFO, "Habilitar notificaciones");
		WaitToClik(Android, XpathTogleButtonNotification, 5);
		Android.findElement(By.xpath(XpathTogleButtonNotification)).click();
		time.sleep(1);
		TakeScreenShot("Notification_3");
		
	}
}
