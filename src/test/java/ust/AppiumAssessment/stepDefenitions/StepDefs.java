package ust.AppiumAssessment.stepDefenitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.ITestListener;
import org.testng.annotations.Listeners;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ust.AppiumAssessment.pom.NewAlarmPom;


public class StepDefs {

	private final AndroidDriver driver = Hooks.driver;
	public NewAlarmPom nap;
	@Given("User opens clocks app")
	public void user_opens_clocks_app() {
	    nap=new NewAlarmPom(driver);
	}

	@Given("User clicks alarm")
	public void user_clicks_alarm() {
	    nap.alarmClick();
	}

	@Given("User clicks plus icon")
	public void user_clicks_plus_icon() {
	  nap.plusIconClick();
	}

	@Given("User set up new time")
	public void user_set_up_new_time() {
		nap.addNewAlarmTimeSetUp();
	   
	}

	@When("User clicks ok")
	public void user_clicks_ok() {
		nap.okButtonClick();
		 System.out.println("scdbsvdhabvhavdhgvhddd"+nap.getTime());
		

	}


	@Then("New alarm {int}:{int} added successfully")
	public void new_alarm_added_successfully(Integer int1, Integer int2) {
		 String hr=Integer.toString(int1);
		 String min=Integer.toString(int2);
		 assertEquals(hr,"3");
		 assertEquals(min,"20");
	}


}
