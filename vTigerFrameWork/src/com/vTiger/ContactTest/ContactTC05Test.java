package com.vTiger.ContactTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vTiger.GenericLibrary.BaseClass;
import com.vTiger.GenericLibrary.FileLib;

public class ContactTC05Test extends BaseClass {

	@Test
	public void searchByLastNmae() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		//Login validation
String exptPage=("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
	String actPage=driver.getTitle();
	
	Assert.assertEquals(exptPage, actPage);
	
	
	//Home page displayed validation
	String expt=("Home");
	WebElement wHome=driver.findElement(By.xpath("//a[@class='hdrLink']"));
	String act=wHome.getText();
	Assert.assertEquals(expt, act);
	
	Thread.sleep(2000);
	
driver.findElement(By.xpath("//a[text()='Contacts']")).click();//Click on contact
//Navigation-3

boolean b1=driver.findElement(By.xpath("//a[text()='Contact Id']")).isDisplayed();
boolean b2=driver.findElement(By.xpath("//a[text()='First Name']")).isDisplayed();
boolean b3=driver.findElement(By.xpath("//a[text()='Last Name']")).isDisplayed();
boolean b4=driver.findElement(By.xpath("//a[text()='Title']")).isDisplayed();
boolean b5=driver.findElement(By.xpath("//td[text()='Organization Name']")).isDisplayed();
boolean b6=driver.findElement(By.xpath("//a[text()='Email']")).isDisplayed();
boolean b7=driver.findElement(By.xpath("//a[text()='Office Phone']")).isDisplayed();
boolean b8=driver.findElement(By.xpath("//a[text()='Assigned To']")).isDisplayed();
boolean b9=driver.findElement(By.xpath("//td[text()='Action']")).isDisplayed();
if(b1==true&&b2==true&&b3==true&&b4==true&&b6==true&&b7==true&&b8==true&&b5==true&&b9==true)
{
	System.out.println("All datas of conatct are present");
}
else
	System.out.println("All datas of contact are not present");

/* Search By LastName */

FileLib flib=new FileLib();
String lastNmaetest=flib.getExcelData("Sheet1", 8, 3);

WebElement c2=driver.findElement(By.name("search_text"));//Search Box
c2.sendKeys(lastNmaetest);
WebElement w2=driver.findElement(By.id("bas_searchfield"));//Dropdown
Select selt2=new Select(w2);

selt2.selectByVisibleText("Last Name");

driver.findElement(By.name("submit")).click();

boolean disNmae=driver.findElement(By.xpath("//a[text()='M']")).isDisplayed();
Assert.assertTrue(disNmae);

c2.clear();
	}
}
