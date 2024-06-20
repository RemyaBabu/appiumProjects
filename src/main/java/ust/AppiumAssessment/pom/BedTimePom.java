package ust.AppiumAssessment.pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ust.AppiumAssessment.appiumUtilities.AndroidActions;

public class BedTimePom {
	public AndroidDriver driver;
	AndroidActions ac;
	WebDriverWait wait;

	public BedTimePom(AndroidDriver driver) {
		this.driver = driver;
		ac=new AndroidActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}
	@AndroidFindBy(xpath="(//android.widget.ImageView[@index='1'])[5]")
	WebElement  bedTimeOption;

	@AndroidFindBy(id="com.google.android.deskclock:id/bedtime_onboarding_graphic")
	WebElement  bedPic;

	@AndroidFindBy(xpath="(//android.widget.ImageView[@index='1'])[1]")
	WebElement  getStartedOption;

	@AndroidFindBy(id="com.google.android.deskclock:id/plus_button")
	WebElement  addTimeButton;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.CheckBox")
	WebElement  vibrateRadio;

	@AndroidFindBy(xpath="//android.widget.Button[@index='12']")
	WebElement  nextButton;

	@AndroidFindBy(id="com.google.android.deskclock:id/bedtime_onboarding_done")
	WebElement  doneButton;

	@AndroidFindBy(id="com.google.android.deskclock:id/wake_clock")
	WebElement  wakeUpTime;

	@AndroidFindBy(id="com.google.android.deskclock:id/bedtime_clock")
	WebElement  bedTime;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@index='1'])[1]")
	WebElement  scheduleElement;

	
	//method to click bedTimeOption
	public void bedTimeOptionClick() {
		bedTimeOption.click();
	}



	//method to return webelement
	public WebElement getbedPic() {
		return  bedPic;
	}

	//method to click getStarted option
	public void getStartedOptionClick() {
		ac.tap(driver, 542, 1868);
	}

	//method to return add time webelement
	public WebElement addTimeWebElement() {
		return  addTimeButton;

	}

	//method to add time
	public void addTime() {
		addTimeButton.click();
	}

	//method to change vibration
	public void changeVibration() {
		vibrateRadio.click();
	}


	//method to click nextButton
	public void nextButtonClick() {
		nextButton.click();
	}

	//method to return done webelement
	public WebElement doneButtoneWebElement() {
		return  doneButton;

	}

	//method to click doneButton
	public void doneButtonClick() {
		doneButton.click();
	}

	//method to return wakeup webelement 
	public WebElement wakeUpTimeWebElement() {
		return  wakeUpTime;

	}

	//method to return wakeup time as string
	public String getWakeUpTime() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  wakeUpTime.getText();

	}
	//method to return bed time as string
	public String getbedTime() {
		return  bedTime.getText();
		
	}

//	public String scheduleElementText() {
//		return  scheduleElement.getText();
//		
//	}

}
