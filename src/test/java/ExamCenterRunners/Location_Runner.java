package ExamCenterRunners;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/test/resources/ExamCenterFeatures/Location.feature"},
		glue =  {"ExamCenterStepDefinitions", "Hooks"},
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
		dryRun = false
		)

public class Location_Runner extends AbstractTestNGCucumberTests {
	String testcasename;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeclass(/*String browser*/) {

		testcasename = this.getClass().getSimpleName();
		System.out.println("***************** " + testcasename + " Test Starting *****************");

	}
	
	@AfterClass(alwaysRun = true)
	public void testDownClass() throws IOException {
		System.out.println("***************** " + testcasename + " Test end *****************");
	}

}
