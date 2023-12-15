package Runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/Create_Controller_User.feature",
                 glue = {"StepDefinitions","Hooks"},
                 plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 monochrome = true,
                 dryRun = false)
                 
public class Users_Creation_Runner extends AbstractTestNGCucumberTests{

	String testcaseName;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeclass(String browser)
	{
		testcaseName = this.getClass().getSimpleName();
		System.out.println("*******************"+testcaseName+"testcase started ");
	}
    @AfterClass(alwaysRun = true)
	public void Afterclass()
	{
		System.out.println("*******************"+testcaseName+"testcase Ended");
	}
}
