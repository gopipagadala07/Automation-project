package PortfolioCenterStepdef;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.PortfolioCenter.pages.AssignmentsSubmissionPages;
import com.PortfolioCenter.pages.PortfolioCenterCoursePages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.*;

public class AssignmentsSubmissionStepdef extends ActionType{
	
	ExcelReader reader = new ExcelReader();
	static List<Map<String, String>> testdata=null;
	AssignmentsSubmissionPages Submission = new AssignmentsSubmissionPages(Base.getDriver());

	@Then("the user clicks on Learning and Portfolio Courses")
	public void the_user_clicks_on_learning_and_portfolio_courses() {
		Submission.the_user_clicks_on_learning_and_portfolio_courses();
	}

	@Then("the user selects the Course and clicks on the Continue Learning {int}")
	public void the_user_selects_the_course_and_clicks_on_the_continue_learning(Integer CourseNam) throws AWTException, InvalidFormatException, IOException {
		Submission.the_user_selects_the_course_and_clicks_on_the_continue_learning(CourseNam);
		
	}

	@Then("The user launches the Assignment and  Submit the Assignment {int}")
	public void the_user_launches_the_assignment_and_submit_the_assignment(Integer AssignmentName) throws AWTException, InvalidFormatException, IOException {
		Submission.the_user_launches_the_assignment_and_submit_the_assignment(AssignmentName);
	}

}
