package PortfolioCenterStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.PortfolioCenter.pages.MultiScoringPortfolioCoursePages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.*;

public class MultiScoringPortfolioCourseStepdef extends ActionType{
	
	ExcelReader reader = new ExcelReader();
	static List<Map<String, String>> testdata=null;
	MultiScoringPortfolioCoursePages Multi = new MultiScoringPortfolioCoursePages(Base.getDriver());
	
	
	
	@Then("the user creates a Multi Scoring Portfolio Course by entering the Title and Description")
	public void the_user_creates_a_multi_scoring_portfolio_course_by_entering_the_title_and_description() throws Exception {
		Multi.the_user_creates_a_multi_scoring_portfolio_course_by_entering_the_title_and_description();
	}
	
	@Then("the user searches for the Multi Scoring Portfolio Course and clicks on it {int}")
	public void the_user_searches_for_the_multi_scoring_portfolio_course_and_clicks_on_it(Integer MultiScoringCourseName) throws InvalidFormatException, IOException {
		Multi.the_user_searches_for_the_multi_scoring_portfolio_course_and_clicks_on_it(MultiScoringCourseName);
	}

	@Then("the user enters the Assignment Name, Description, and Add Multi Standards {int} {int} {int}")
	public void the_user_enters_the_assignment_name_description_and_add_multi_standards(Integer Standard1, Integer Standard2, Integer Standard3) throws Exception {
		Multi.the_user_enters_the_assignment_name_description_and_add_multi_standards(Standard1, Standard2, Standard3);
		
	}

}
