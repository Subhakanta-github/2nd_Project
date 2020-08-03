package roughTest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

@Listeners
public class ScreenShot implements ITestListener {

	@Override
	public void onTestFailure(ITestResult arg0) {
		WebDriver driver=new ChromeDriver();
		Date date=new Date();
		driver.get("http://localhost:8888/index.php?" );
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("use_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		//Home page displayed validation
		String str=date.toString().replace(":", "_").replace(" ", "_");
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		File scrImg=eDriver.getScreenshotAs(OutputType.FILE);
		
		
		File dest=new File("./screenshot/Login"+str+".png");
		
		try {
			FileUtils.copyFile(scrImg, dest);
		} catch (IOException e) {
			
		}
		
	}

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
	
	
	
	
	




