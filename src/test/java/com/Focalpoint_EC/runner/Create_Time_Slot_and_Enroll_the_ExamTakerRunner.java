package com.Focalpoint_EC.runner;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Feature/Create_TimeSlot_and_Enroll_the_ExamTaker.feature"},
		glue= {"stepDefinations","appHooks"},
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
		dryRun = false
		,tags = "@SmokeTest"
		)

public class Create_Time_Slot_and_Enroll_the_ExamTakerRunner extends AbstractTestNGCucumberTests
{
String testcasename;  // 
	
	//@Parameters("browser")
	@BeforeClass
	public void beforeclass(/*String browser*/) {

		testcasename = this.getClass().getSimpleName();
		System.out.println("***************** " + testcasename + " Test Starting *****************");

	}
	
	@AfterClass(alwaysRun = true)
	public void testDownClass() throws IOException {
		System.out.println("***************** " + testcasename + " Test end *****************");

	}
	
	@DataProvider
	public Object[][] getexcel()  {
		return this.scenarios();
	}
}
