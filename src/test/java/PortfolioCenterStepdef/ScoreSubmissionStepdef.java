package PortfolioCenterStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.PortfolioCenter.pages.PortfolioCenterCoursePages;
import com.PortfolioCenter.pages.ScoreSubmissionPages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.*;

public class ScoreSubmissionStepdef extends ActionType{
	
	ExcelReader reader = new ExcelReader();
	static List<Map<String, String>> testdata=null;
//	PortfolioCenterCoursePages PortfolioCenterCourse = new PortfolioCenterCoursePages(Base.getDriver());
	ScoreSubmissionPages score = new ScoreSubmissionPages(Base.getDriver());
	
	@Then("the user searches for the course and clicks on it {int}")
	public void the_user_searches_for_the_course_and_clicks_on_it(Integer PortfolioCourseName) throws InvalidFormatException, IOException {
		score.the_user_searches_for_the_course_and_clicks_on_it(PortfolioCourseName);
	}

	@Then("the user clicks on the assignment then click on Score Student Portfolio button {int}")
	public void the_user_clicks_on_the_assignment_then_click_on_score_student_portfolio_button_assignment_name(Integer AssignmentName) throws InvalidFormatException, IOException {
//		PortfolioCenterCourse.the_user_clicks_on_learning_and_portfolio_center();
//		PortfolioCenterCourse.the_user_searches_for_the_specific_course_and_clicks_on_it();
		score.the_user_clicks_on_the_assignment_then_click_on_score_student_portfolio_button_assignment_name(AssignmentName);
	}

	@Then("Enter the Score and Comments and submit the Score {int}")
	public void enter_the_score_and_comments_and_submit_the_score_score(Integer Score) throws InvalidFormatException, IOException {
		score.enter_the_score_and_comments_and_submit_the_score_score(Score);
	}
	
	@Then("the user is awarded the Badge")
	public void the_user_is_awarded_the_badge() {
		score.the_user_is_awarded_the_badge(); 
	}
	
	@Then("the user clicks on the Assignment and validates the Status and Performance Report.")
	public void the_user_clicks_on_the_assignment_and_validates_the_status_and_performance_report() {
		score.the_user_clicks_on_the_assignment_and_validates_the_status_and_performance_report();
	}

	@Then("the user clicks on the Report Card tab and validates the Score in the Report Card {int}")
	public void the_user_clicks_on_the_report_card_tab_and_validates_the_score_in_the_report_card(Integer Score) throws InvalidFormatException, IOException {
		score.the_user_clicks_on_the_report_card_tab_and_validates_the_score_in_the_report_card(Score);
	}
	
	
	
	
}
