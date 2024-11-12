package AssessmentsRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "\\src\\test\\resources\\AssessmentsFeatures\\Provide_Score.feature",
glue = {"AssessmentsStepdef","Hooks"},
plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true,
dryRun = false)
public class Provide_ScoreRunner {
	
	
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
