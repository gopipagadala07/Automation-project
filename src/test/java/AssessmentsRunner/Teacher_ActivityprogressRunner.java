package AssessmentsRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\AssessmentsFeatures\\Teacher_Activityprogress.feature",
glue = {"AssessmentsStepdef","Hooks"},
plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true,
dryRun = false)
public class Teacher_ActivityprogressRunner extends AbstractTestNGCucumberTests {
	
	String TestcaseName;
	//@Parameters("browser")
	@BeforeClass
	public void beforeClass(/*String browser*/)
	{
		TestcaseName=this.getClass().getSimpleName();
		System.out.println("****************" + TestcaseName + "Test Start****************");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("****************"+TestcaseName+"****************");
	}

}


