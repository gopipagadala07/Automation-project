package PortfolioCenterStepdef;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.PortfolioCenter.pages.AssignmentsSubmissionPages;
import com.PortfolioCenter.pages.MultiScoringAssignmentSubmissionPages;
import com.PortfolioCenter.pages.PortfolioCenterCoursePages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.*;

public class MultiScoringAssignmentSubmissionSetpdef extends ActionType{
	
	ExcelReader reader = new ExcelReader();
	static List<Map<String, String>> testdata=null;
	MultiScoringAssignmentSubmissionPages MultiSubmission = new MultiScoringAssignmentSubmissionPages(Base.getDriver());

	@Then("the user selects the Multi Scoring Course and clicks on the Continue Learning {int}")
	public void the_user_selects_the_multi_scoring_course_and_clicks_on_the_continue_learning(Integer MultiPortfolioCourseName) throws InvalidFormatException, AWTException, IOException {
		MultiSubmission.the_user_selects_the_multi_scoring_course_and_clicks_on_the_continue_learning(MultiPortfolioCourseName);
	}

	@Then("The user launches the Multi Scoring Course Assignment and  Submit the Assignment {int}")
	public void the_user_launches_the_multi_scoring_course_assignment_and_submit_the_assignment(Integer Multiassignmentname) throws InvalidFormatException, AWTException, IOException {
		MultiSubmission.the_user_launches_the_multi_scoring_course_assignment_and_submit_the_assignment(Multiassignmentname);
	}

}
