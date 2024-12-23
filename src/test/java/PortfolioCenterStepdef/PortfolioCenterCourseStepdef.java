package PortfolioCenterStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.PortfolioCenter.pages.PortfolioCenterCoursePages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.*;

public class PortfolioCenterCourseStepdef extends ActionType{
	
	ExcelReader reader = new ExcelReader();
	static List<Map<String, String>> testdata=null;
	PortfolioCenterCoursePages PortfolioCenterCourse = new PortfolioCenterCoursePages(Base.getDriver());

	@Then("the user clicks on Learning and Portfolio Center")
	public void the_user_clicks_on_learning_and_portfolio_center() {
		PortfolioCenterCourse.the_user_clicks_on_learning_and_portfolio_center();
	}

	@Then("the user creates a Portfolio Course by entering the Title and Description")
	public void the_user_creates_a_portfolio_course_by_entering_the_title_and_description() {
		PortfolioCenterCourse.the_user_creates_a_portfolio_course_by_entering_the_title_and_description();
	     
	}

	@Then("the user searches for the specific course and clicks on it {int}")
	public void the_user_searches_for_the_specific_course_and_clicks_on_it(Integer CourseName) throws InvalidFormatException, IOException {
		PortfolioCenterCourse.the_user_searches_for_the_specific_course_and_clicks_on_it();
	     
	}

	@Then("the user clicks on the Add Portfolio Assignment button")
	public void the_user_clicks_on_the_add_portfolio_assignment_button() {
		PortfolioCenterCourse.the_user_clicks_on_the_add_portfolio_assignment_button();
	     
	}

	@Then("the user enters the Assignment Name, Description, and selects Standards {int}")
	public void the_user_enters_the_assignment_name_description_and_selects_standards(Integer Standards) throws InvalidFormatException, IOException {
		PortfolioCenterCourse.the_user_enters_the_assignment_name_description_and_selects_standards(Standards);
	     
	}

	@Then("the user clicks on the Save button")
	public void the_user_clicks_on_the_save_button() {
		PortfolioCenterCourse.the_user_clicks_on_the_save_button();
	     
	}

	@Then("the user navigates to the Members tab, searches for the username in the Search Here field using row {int}")
	public void the_user_navigates_to_the_members_tab_searches_for_the_username_in_the_search_here_field_using_row(Integer FirstName) throws InvalidFormatException, IOException {
		PortfolioCenterCourse.the_user_navigates_to_the_members_tab_searches_for_the_username_in_the_search_here_field_using_row(FirstName);    
	}

	@Then("assign the user to the assignment")
	public void assign_the_user_to_the_assignment() {
		PortfolioCenterCourse.assign_the_user_to_the_assignment();
	}

	@Then("the user navigates to the Portfolio tab,")
	public void the_user_navigates_to_the_portfolio_tab() {
		PortfolioCenterCourse.the_user_navigates_to_the_portfolio_tab();
	}

	@Then("clicks on the assignment, and verifies that the user is added to the assignment {int}")
	public void clicks_on_the_assignment_and_verifies_that_the_user_is_added_to_the_assignment(Integer LastName) throws Exception {
		PortfolioCenterCourse.clicks_on_the_assignment_and_verifies_that_the_user_is_added_to_the_assignment(LastName);
		PortfolioCenterCourse.PortfolioCourseNameInsertmultipledataIntoExcel();
		System.out.println("Portfolio Course Name inserted Sucessfully");
		PortfolioCenterCourse.PortfolioAssignmentnameInsertmultipledataIntoExcel();
//		PortfolioCenterCourse.intert();
		System.out.println("Portfolio Assignment Name inserted Sucessfully");
	}

}
