package ExamCenterRunners;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/ExamCenterFeatures/Create_TimeSlot_and_Enroll_the_ExamTaker.feature"},
		glue= {"ExamCenterStepDefinitions","Hooks"},
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
		dryRun = false
		)

public class Create_Time_Slot_and_Enroll_the_ExamTakerRunner extends AbstractTestNGCucumberTests
{
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
