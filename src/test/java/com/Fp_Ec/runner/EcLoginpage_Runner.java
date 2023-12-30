package com.Fp_Ec.runner;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/test/resources/Ec_features/Loginpage.feature"},
		glue =  {"StepDefinitions", "AppHooks"},
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
		dryRun = false
		)


public class EcLoginpage_Runner extends AbstractTestNGCucumberTests{
String testcasename;
	
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

