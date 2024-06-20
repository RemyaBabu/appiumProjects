package ust.AppiumAssessment.runner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue="ust.AppiumAssessment.stepDefenitions",
		features="C:\\Users\\268859\\Desktop\\mobileaplications\\AppiumAssessment\\src\\test\\resources\\features\\addAlarmFeature.feature",
				plugin = { "pretty", "html:target/cucumber-reports.html" },// plugin for report
				tags="@add",
				monochrome = true
		)
public class TestRunner extends AbstractTestNGCucumberTests{
}
