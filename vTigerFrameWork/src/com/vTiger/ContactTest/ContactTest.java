package com.vTiger.ContactTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vTiger.GenericLibrary.BaseClass;
import com.vTiger.GenericLibrary.CommonUtils;
import com.vTiger.GenericLibrary.FileLib;

public class ContactTest extends BaseClass {
	@Test
	public void contactTest() throws Throwable
	{
		
		
		CommonUtils.implicitelyWait();
		
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

//Navigation 4
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
WebElement wContact=driver.findElement(By.xpath("//span[text()='Creating New Contact']"));
String actText=wContact.getText();
String exptText="Creating New Contact";
//New contact page displayed validation
Assert.assertEquals(exptText, actText);

//Navigation 5
//Name prefix dropdown
WebElement dropDownName=driver.findElement(By.name("salutationtype"));
Select s1=new Select(dropDownName);
s1.selectByVisibleText("Mr.");
/* Create one contact*/
FileLib flib=new FileLib();
String firstName=flib.getExcelData("Sheet1",2,3);
String lastName=flib.getExcelData("Sheet1", 2, 4);
String title=flib.getExcelData("Sheet1", 2, 5);
String email=flib.getExcelData("Sheet1", 2, 6);
String phone=flib.getExcelData("Sheet1", 2, 7);


driver.findElement(By.name("firstname")).sendKeys(firstName);
driver.findElement(By.name("lastname")).sendKeys(lastName);
driver.findElement(By.id("title")).sendKeys(title);
driver.findElement(By.id("email")).sendKeys(email);
driver.findElement(By.id("phone")).sendKeys(phone);
//Assigned to --Radio Button
boolean radioUser=driver.findElement(By.name("assigntype")).isSelected();

Thread.sleep(2000);
driver.findElement(By.name("assigntype")).isSelected();

if(radioUser==true)
{
	WebElement dropDownUser=driver.findElement(By.name("assigned_user_id"));
	Select s2=new Select(dropDownUser);
	s2.selectByVisibleText("Administrator");
}
else
{

	WebElement dropDownGroup=driver.findElement(By.name("assigned_group_id"));
	Select s3=new Select(dropDownGroup);
	s3.selectByVisibleText("Marketing Group");
	
}
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();//Save

//Validation created contact present in contact


WebElement w4=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
boolean dis=w4.isDisplayed();
Assert.assertTrue(dis);



		
		
	}

}
