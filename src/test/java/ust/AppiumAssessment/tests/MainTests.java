package ust.AppiumAssessment.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import ust.AppiumAssessment.appiumUtilities.AppiumServerManager;
import ust.AppiumAssessment.pom.BedTimePom;

import ust.AppiumAssessment.utilities.*;

public class MainTests {
	public static AndroidDriver driver;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;	
	private Map<String, String> testData;
	Properties properties ;
	BedTimePom btp;
	static int i=0;


	@BeforeTest
	public void setup() throws MalformedURLException {
		properties= FileIO.getProperties();
		String port = AppiumServerManager.startServer();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(properties.getProperty("deviceName"));
		options.setAppPackage(properties.getProperty("appPackage"));
		options.setAppActivity(properties.getProperty("appActivity"));
		options.setPlatformName("Android");
		driver = new AndroidDriver(new URL("http://127.0.0.1:"+ port), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    btp=new BedTimePom(driver);
	    
		//report object setups
		htmlReporter=new ExtentSparkReporter("Report.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		
	
		
	}




		
@Test(priority=1)
public void bedTimeOptionClickTest() {
	btp.bedTimeOptionClick();
	assertTrue(btp.getbedPic().isDisplayed(),"something went wrong");
	test=reports.createTest("bedTimeOptionClickTest");
}

@Test(priority=2)
public void getStartedOptionClickTest() {
	btp.getStartedOptionClick();
	assertTrue(btp.addTimeWebElement().isDisplayed());
	test=reports.createTest("getStartedOptionClickTest");
	
}

@Test(priority=3)
public void addNewBedTimeTest() {
btp.addTime();
	btp.changeVibration();
	btp.nextButtonClick();
	assertTrue(btp.doneButtoneWebElement().isDisplayed(),"add new time failed");
	test=reports.createTest("addNewBedTimeTest");
}

@Test(priority=4)
public void savingNewTimeTest() {
btp.doneButtonClick();
	assertTrue(btp.wakeUpTimeWebElement().isDisplayed());
	test=reports.createTest("savingNewTimeTest");
}
// json data used to validate wakeup and bedtime
@Test(priority=5)
public void checkSavedBedTime() {
//	System.out.println("bdehgwvfhgrwrwfvrwhgvfr"+btp.getWakeUpTime());
//	System.out.println("bdehgwvfhgrwrwfvrwhgvfr"+btp.getbedTime());
	
	try {
		testData = JsonManage.readJsonFromFile("C:\\Users\\268859\\Desktop\\mobileaplications\\AppiumAssessment\\testData\\testData.json");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String bedTime=testData.get("bedTime");
	String wakeupTime=testData.get("wakeupTime");
	assertEquals(btp.getbedTime(),bedTime);
	assertEquals(btp.getWakeUpTime(),wakeupTime);
}





		// to add screenshots
		@AfterMethod
		public void screenShots() {
			i++;
			//both failed and success screen shots are saved in screenShotFolder
			takeScreenShot("C:\\Users\\268859\\Desktop\\mobileaplications\\AppiumAssessment\\Screenshots\\"+i+".png");
		String ss="C:\\Users\\268859\\Desktop\\mobileaplications\\AppiumAssessment\\Screenshots\\"+i+".png";
			test.addScreenCaptureFromPath(ss);
		}

		@AfterTest
		public void reportFlush() {
			AppiumServerManager.stopServer();
			reports.flush();
		}


		public static void takeScreenShot(String filepath) {
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(filepath);
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}
