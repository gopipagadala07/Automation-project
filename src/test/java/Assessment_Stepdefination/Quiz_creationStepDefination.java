package Assessment_Stepdefination;


import com.Assessments.pages.Quiz_createpage;
import com.Utils.ActionType;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Quiz_creationStepDefination extends ActionType
{
	private Quiz_createpage Quiz_Create = new Quiz_createpage(com.Utils.Base.getDriver());

	@Given("User is On Login Page1")
	public void user_is_on_login_page1() {
		getURL(getProperty("url"));
		
	}

	@When("User Enters Valid Login Credentials")
	public void user_enters_valid_login_credentials() 
	{
		waitForPageLoad();
		StaticWait(2);
		Quiz_Create.Login();
	}


	@When("user click on Assessment Center tab")
	public void user_click_on_assessment_center_tab() 
	{
		Quiz_Create.Navigate_AC_page();
	    
	}
	@Then("Search for the Particular Course and click on it")
	public void search_for_the_particular_course_and_click_on_it() 
	{
	    Quiz_Create.search_The_Community();
	    Quiz_Create.click_On_The_Community();
	}

	@Then("Go to Assessments tab")
	public void go_to_assessments_tab() 
	{
	    Quiz_Create.go_To_Assessment_Tab();
	}

	@Then("Create Child Objective by Click on Root Goal Level Ellipses")
	public void create_child_objective_by_click_on_root_goal_level_ellipses() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Click on Add new Quiz by click on Goal Level Ellipses")
	public void click_on_add_new_quiz_by_click_on_goal_level_ellipses() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Add any test to the Quiz")
	public void add_any_test_to_the_quiz() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Enter the Name,Description,Instruction")
	public void enter_the_name_description_instruction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Select the Start Date and Due Date by using Date Picker icon")
	public void select_the_start_date_and_due_date_by_using_date_picker_icon() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Handling the Show Answers,Is Override Instructions,Show Test Summary,Show Test Analytics toggles")
	public void handling_the_show_answers_is_override_instructions_show_test_summary_show_test_analytics_toggles() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
