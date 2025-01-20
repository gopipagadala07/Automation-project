package LearningTreeRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\LearningTreeFeatures\\Activities_Creation.feature",
glue = {"LearningTreeStepdef","Hooks"},
plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true,
dryRun = false)
public class Activity_CreationRunner extends AbstractTestNGCucumberTests {
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
