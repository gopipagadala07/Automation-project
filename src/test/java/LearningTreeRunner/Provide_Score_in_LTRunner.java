package LearningTreeRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\LearningTreeFeatures\\Provide_Score_in_LT.feature",
glue = {"LearningTreeStepdef","Hooks"},
plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
tags = "@LearningTreeGroup",
monochrome = true,
dryRun = false)
public class Provide_Score_in_LTRunner extends AbstractTestNGCucumberTests{
	String TestcaseName;
	//@Parameters("browser")
	@BeforeClass
	public void beforeClass(/*String browser*/)
	{
		TestcaseName=this.getClass().getSimpleName();
		System.out.println("<---------------" + TestcaseName + " Test Start--------------->");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("<---------------" + TestcaseName + " Test End--------------->");
	}
}
