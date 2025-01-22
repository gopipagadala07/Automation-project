package AssessmentsStepdef;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.Utils.Base;
import com.Utils.CommonPages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.Assessments.pages.AnnouncementsPages;
import com.Assessments.pages.BenchmarksPage;
import com.Assessments.pages.PerformingexamPages;
import com.Assessments.pages.SISProvisioningAssessmentCenterPage;
import com.Assessments.pages.QuizSubmissionPages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExamSubmissionStepdefinitions extends ActionType{
	 

	PerformingexamPages e=new PerformingexamPages(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	static List<Map<String, String>> testdata=null;

	@Then("user clicks on benchmarks tab")
	public void user_clicks_on_benchmarks_tab() {

		e.ClickONbenchmarksTab(); 
	}
	
	@And("User will launch and submit all Exams")
	public void User_will_launch_and_submit_all_Exams() throws AWTException, InterruptedException {
	   e.ClickOnLaunchAndCompleteExam(); 
	}
}
