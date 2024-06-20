package ust.AppiumAssessment.pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ust.AppiumAssessment.appiumUtilities.AndroidActions;

public class NewAlarmPom {
	public AndroidDriver driver;
	AndroidActions ac;
	WebDriverWait wait;

	public NewAlarmPom(AndroidDriver driver) {
		this.driver = driver;
		ac=new AndroidActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@AndroidFindBy(xpath="(//android.widget.ImageView[@index='1'])[1]")
	WebElement  alarm;

	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"3 o'clock\"]")
	WebElement  hour;

	@AndroidFindBy(accessibility="20 minutes")
	WebElement  minutes;
	@AndroidFindBy(id="com.google.android.deskclock:id/material_clock_period_am_button")
	WebElement  amOrpm;

	@AndroidFindBy(id="com.google.android.deskclock:id/material_timepicker_ok_button")
	WebElement okButton;

	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"3:20 AM\"]")
	WebElement time;



	// method to click alarm
	public void alarmClick() {
		alarm.click();
	}

	//method to click plus icon using android actions taps
	public void plusIconClick() {
		ac.tap(driver, 550, 1864);
	}

	// method to set up new alarm 
	public void addNewAlarmTimeSetUp() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hour.click();
		minutes.click();
		amOrpm.click();
	}

	//method to click confirm alarm
	public void okButtonClick() {
		okButton.click();
	}

	//method to get time
	public String getTime() {
		return time.getText();
	}



}
