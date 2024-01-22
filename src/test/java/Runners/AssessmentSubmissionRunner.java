package Runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src\\test\\resources\\Features\\AssessmentSubmission.feature",
                 glue = {"StepDefinitions","Hooks"},
                 plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 monochrome = true,
                 dryRun = false	)

public class AssessmentSubmissionRunner extends AbstractTestNGCucumberTests{

	String TestcaseName;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser)
	{
		TestcaseName=this.getClass().getSimpleName();
		System.out.println("***************** " + TestcaseName + " Test Starting *****************");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("***************** " + TestcaseName + " Test end *****************");
	}

}
