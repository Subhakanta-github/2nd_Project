package com.vTiger.GenericLibrary;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Subha
 *
 */

public class CommonUtils {
	/*Implicitly wait*/
	public static void implicitelyWait()
	{
		BaseClass.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	/*Explicitly wait*/
	
	public static void explicitlyWait()
	{
		WebDriverWait wait=new WebDriverWait(BaseClass.driver, 20);
	}
	
	
	/*Select Class*/
	
	public static void selectClass(WebElement element,int index)
	{
		Select sel=new Select(element);
		
	}

}
