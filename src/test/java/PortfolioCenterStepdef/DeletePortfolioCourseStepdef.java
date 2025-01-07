package PortfolioCenterStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.PortfolioCenter.pages.DeleteCourseNamePages;
import com.PortfolioCenter.pages.PortfolioCenterCoursePages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.*;

public class DeletePortfolioCourseStepdef extends ActionType{
	
	ExcelReader reader = new ExcelReader();
	static List<Map<String, String>> testdata=null;
	DeleteCourseNamePages delete =new DeleteCourseNamePages(Base.getDriver());
	
	@Then("the user creates a Portfolio Course by providing a Title and Description.")
	public void the_user_creates_a_portfolio_course_by_providing_a_title_and_description() {
		delete.the_user_creates_a_portfolio_course_by_providing_a_title_and_description();
	}

	@Then("the user searche for the course and clicks on it {int}")
	public void the_user_searche_for_the_course_and_clicks_on_it(Integer DeleteCourseName) throws Exception {
		delete.the_user_searche_for_the_course_and_clicks_on_it();
		
	}

	@Then("The user clicks on the Edit Portfolio Course button and deletes the Portfolio Course.")
	public void the_user_clicks_on_the_edit_portfolio_course_button_and_deletes_the_portfolio_course() {
		delete.the_user_clicks_on_the_edit_portfolio_course_button_and_deletes_the_portfolio_course();
	}
	
	
	
	
	
	

//	@Then("clicks on the assignment, and verifies that the user is added to the assignment {int}")
//	public void clicks_on_the_assignment_and_verifies_that_the_user_is_added_to_the_assignment(Integer LastName) throws Exception {
//		PortfolioCenterCourse.clicks_on_the_assignment_and_verifies_that_the_user_is_added_to_the_assignment(LastName);
//		PortfolioCenterCourse.PortfolioCourseNameInsertmultipledataIntoExcel();
//		System.out.println("Portfolio Course Name inserted Sucessfully");
//		PortfolioCenterCourse.PortfolioAssignmentnameInsertmultipledataIntoExcel();
////		PortfolioCenterCourse.intert();
//		System.out.println("Portfolio Assignment Name inserted Sucessfully");
//	}

}
