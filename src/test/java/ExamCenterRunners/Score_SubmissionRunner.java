package ExamCenterRunners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/ExamCenterFeatures/Provide_Score.feature",
glue = {"ExamCenterStepDefinitions","Hooks"},
plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true,
tags = "@ExamCenterGroup",
dryRun = false)
public class Score_SubmissionRunner extends AbstractTestNGCucumberTests{
	String TestcaseName;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeclass(/*String browser*/)
	{
		TestcaseName = this.getClass().getSimpleName();
		System.out.println("<---------------" + TestcaseName + "Test Start--------------->");
	}
	@AfterClass(alwaysRun = true)
	public void Afterclass()
	{
		System.out.println("<---------------" + TestcaseName + "Test End--------------->");
	}

}
