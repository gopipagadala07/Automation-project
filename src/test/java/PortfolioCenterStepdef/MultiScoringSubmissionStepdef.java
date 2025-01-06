package PortfolioCenterStepdef;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.PortfolioCenter.pages.MultiScoringSubmissionPages;
import com.PortfolioCenter.pages.ScoreSubmissionPages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.*;

public class MultiScoringSubmissionStepdef extends ActionType{
	
	ExcelReader reader = new ExcelReader();
	static List<Map<String, String>> testdata=null;
	MultiScoringSubmissionPages MultiScoring = new MultiScoringSubmissionPages(Base.getDriver());
	
	
	@Then("the user searches for the Multi Scoring Portfolio Course {int}")
	public void the_user_searches_for_the_multi_scoring_portfolio_course(Integer MultiPortfolioCourseName) throws InvalidFormatException, IOException {
		MultiScoring.the_user_searches_for_the_multi_scoring_portfolio_course(MultiPortfolioCourseName);
	}
	
	@Then("the user clicks on the Multi Scoring assignment then click on Multi Scoring button {int}")
	public void the_user_clicks_on_the_multi_scoring_assignment_then_click_on_multi_scoring_button(Integer MultiAssignmentName) throws InvalidFormatException, IOException {
		MultiScoring.the_user_clicks_on_the_multi_scoring_assignment_then_click_on_multi_scoring_button(MultiAssignmentName);
	}

	@Then("Enter the Score and submit the Score {int} {int} {int}")
	public void enter_the_score_and_submit_the_score(Integer Score1, Integer Score2, Integer Score3) throws InvalidFormatException, IOException {
		MultiScoring.enter_the_score_and_submit_the_score(Score1, Score2, Score3);
	}
	@Then("the user is awarded the Badge for the Multi Scoring Portfolio Course")
	public void the_user_is_awarded_the_badge_for_the_multi_scoring_portfolio_course() {
		MultiScoring.the_user_is_awarded_the_badge_for_the_multi_scoring_portfolio_course();
	}

	@Then("the user clicks on the Multi Scoring Assignment and validates the Status and Performance Report.")
	public void the_user_clicks_on_the_multi_scoring_assignment_and_validates_the_status_and_performance_report() {
		MultiScoring.the_user_clicks_on_the_multi_scoring_assignment_and_validates_the_status_and_performance_report();
	}
	
	
}
