package PortfolioCenterRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\PortfolioCenterFeatures\\SIS Provisioning.feature",
glue = {"PortfolioCenterStepdef","Hooks"},
plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true,
tags = "@AssessmentCenterGroup",
dryRun = false)

public class SISprovisioningRunner extends AbstractTestNGCucumberTests {
	
	String TestcaseName;
	//@Parameters("browser")
	@BeforeClass
	public void beforeClass(/*String browser*/)
	{
		TestcaseName=this.getClass().getSimpleName();
		System.out.println("<---------------" + TestcaseName + " Test Start--------------->");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("<---------------" + TestcaseName + " Test End--------------->");
	}

}


