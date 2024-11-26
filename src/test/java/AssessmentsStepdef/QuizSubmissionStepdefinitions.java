package AssessmentsStepdef;

//import java.util.List;
//import java.util.Map;
//
//import com.Assessments.pages.CommonPages;
//import com.Assessments.pages.QuizSubmissionPages;
//import com.Utils.Base;
//import com.Utils.ExcelReader;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//
//public class QuizSubmissionStepdefinitions {
//	ExcelReader reader=new ExcelReader();
//	CommonPages cp=new CommonPages(Base.getDriver());
//	QuizSubmissionPages QS=new QuizSubmissionPages(Base.getDriver());
//	static List<Map<String, String>> testdata=null;
//
//	@Then("Launch the Quiz and Submit the Quiz")
//	public void launch_the_quiz_by_using_launch_icon() {
//		QS.LaunchandSubmitQuiz();
//	}
//
//	@And("User navigate to inside of the Exam by using begin test button")
//	public void user_navigate_to_inside_of_the_exam_by_using_begin_test_button() {
//		QS.Begintest();
//
//	}
//
//	@Then("Select the Answers for All type of Questions")
//	public void select_the_answers_for_all_type_of_questions() {
//		QS.QuestionsAnswers();
//
//	}
//
//	@And("Submit the Exam")
//	public void submit_the_exam() {
//        QS.SubmitExam();
//
//	}
//
//	@Then("user click on Close icon")
//	public void user_click_on_close_icon() {
//
//	}
import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.Utils.Base;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.Assessments.pages.AnnouncementsPages;
import com.Assessments.pages.BenchmarksPage;
import com.Assessments.pages.CommonPages;
import com.Assessments.pages.SISProvisioningPage;
import com.Assessments.pages.QuizSubmissionPages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QuizSubmissionStepdefinitions extends ActionType{
	 

	QuizSubmissionPages spages=new QuizSubmissionPages(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	static List<Map<String, String>> testdata=null;
	

	@Given("user clicks on the Assessment tab")
	public void user_clicks_on_the_assessment_tab() throws AWTException, InterruptedException {
	   spages.ClickOnAssessmentTab();
	}
	
	@Then("user clicks on Launch icon and complete test")
	public void user_clicks_on_launch_icon_and_complete_test() throws AWTException, InterruptedException, TimeoutException {
	   spages.ClickOnLaunchAndCompleteQuiz(); 
	}
}
