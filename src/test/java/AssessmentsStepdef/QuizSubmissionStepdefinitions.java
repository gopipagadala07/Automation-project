package AssessmentsStepdef;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import com.Utils.Base;
import com.Assessments.pages.CommonPages;
import com.Assessments.pages.QuizSubmissionPages;
import com.Utils.ActionType;
import com.Utils.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


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