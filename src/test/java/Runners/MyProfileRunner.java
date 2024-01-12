package Runners;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\Features\\Myprofile.feature",
glue = {"StepDefinitions","Hooks"},
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true,
dryRun = false)
public class MyProfileRunner extends AbstractTestNGCucumberTests{
	String testcaseName;
	
	//@Parameters("browser")
	@BeforeClass
	public void beforeclass(/*String browser*/)
	{
		testcaseName=this.getClass().getSimpleName();
		System.out.println("**********"+testcaseName+" - Test Starting *********");
	}
	@AfterClass(alwaysRun = true)
	public void afterClass()
	{
		testcaseName=this.getClass().getSimpleName();
		System.out.println("**********"+testcaseName+" - Test Ending *********");
	}
}
