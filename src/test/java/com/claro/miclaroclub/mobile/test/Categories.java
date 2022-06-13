package com.claro.miclaroclub.mobile.test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.claro.miclaroclub.mobile.providers.CategoriesProviders;
import com.relevantcodes.extentreports.LogStatus;

public class Categories extends BaseClass {

	@BeforeClass
	public void BeforeClass()
	{
		test = report.startTest("Categorias");
	}
	
	@Test(priority = 1, dataProvider = "ViewCategoriesProvider", dataProviderClass= CategoriesProviders.class)	
	public void ViewCategories(String XpathButtonCategories, String XpathCategories) throws InterruptedException
	{
		test.log(LogStatus.INFO, "Visualización de Categorias");
		WaitToClik(Android, XpathButtonCategories, 10);
		Android.findElement(By.xpath(XpathButtonCategories)).click();
		time.sleep(1);
		TakeScreenShot("Categories_1");
		Assert.assertEquals(Android.findElements(By.xpath(XpathCategories)).size() > 0 , true, "Se muestran las categorias correctamente");
	}
}
