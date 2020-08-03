package com.vTiger.GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * 
 * @author Subha
 *
 */

public class LisImpClass implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		String failedTestName=result.getMethod().getMethodName();
		System.out.println("Failed Method Name------->"+failedTestName);
		
		String cuurentDate=new Date().toString().replace(":", "_").replace(" ", "_");
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.driver);
		File scrFile=eDriver.getScreenshotAs(OutputType.FILE);
		
		File destFile=new File("./screenShot/"+failedTestName+"_"+cuurentDate+".png");
		try {
			FileUtils.copyFile(scrFile, destFile);
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
