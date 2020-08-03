package com.vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(com.vTiger.GenericLibrary.LisImpClass.class)
public class BaseClass   {
	/**
	 *Used to perform common operations like open browser,login,logout&close the browser 
	 * @author Subha 
	 */

	public static WebDriver driver;
	/**
	 * Used To open Browser
	 * @throws Throwable
	 */
	@BeforeClass
	public void lunchBroser() throws Throwable
	{
		/*Create object of FileLib*/
		FileLib flb=new FileLib();
	String BROWSER=flb.getPropertyValue("browser");
		
		/*Open the given browser*/
		driver=null;
		if(BROWSER.equals("firefox")) 
			driver=new FirefoxDriver();
		else if(BROWSER.equals("chrome"))
			driver=new ChromeDriver();
		else if(BROWSER.equals("ie"))
			driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		
		}
	/**
	 * used to login in to the application
	 * @throws Throwable
	 */
	@BeforeMethod
	public void login() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		/*Create object of FileLib*/
		FileInputStream ftsLogin=new FileInputStream("./Data/commonData.property");
		Properties pobj=new Properties();
		pobj.load(ftsLogin);
		
		/*Get the login data from properties file*/
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		
		/*Goto login page*/
		driver.get(URL);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("user_name")));
		/*Enter id & password*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		/*click login*/
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		
		
			}
	/**
	 * Used to logout from the application
	 * @throws InterruptedException
	 */
	@AfterMethod
	public void logoutAM() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver,20);
		 
		 /*Perform actions to goto logout*/
		Actions act=new Actions(driver);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		WebElement w=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(w).perform();
		
		/*Click on logout*/
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a [text()='Sign Out']")));
		driver.findElement(By.xpath("//a [text()='Sign Out']")).click();
	
	
	  
	 

}
	/**
	 * Used to close the browser
	 */
	@AfterClass
	public void closeBrowserAC() {
		/*Close the driver*/
		driver.close();
	}
}
