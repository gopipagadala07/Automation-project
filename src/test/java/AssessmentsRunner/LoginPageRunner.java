package AssessmentsRunner;

import java.io.IOException;

import org.apache.commons.math3.analysis.function.Abs;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
   (features = "src/test/resources/AssessmentsFeatures/Login.feature",
    glue = {"AssessmentsStepdef","Hooks"},
    plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    monochrome = true,
			tags = "@AssessmentCenterGroup",
    dryRun = false)
public class LoginPageRunner extends AbstractTestNGCucumberTests{

	String TestcaseName;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeclass(/*String browser*/) {

		TestcaseName = this.getClass().getSimpleName();
		System.out.println("<---------------" + TestcaseName + "Test Start--------------->");

	}
	
	@AfterClass(alwaysRun = true)
	public void testDownClass() throws IOException {
		System.out.println("<---------------" + TestcaseName + "Test End--------------->");

	}
}
