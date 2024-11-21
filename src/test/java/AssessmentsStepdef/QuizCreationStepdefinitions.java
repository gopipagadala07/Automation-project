package AssessmentsStepdef;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Assessments.pages.CommonPages;
import com.Assessments.pages.QuizCreationPages;
import com.Assessments.pages.SISProvisioningPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QuizCreationStepdefinitions extends ActionType{
	
	QuizCreationPages QP=new QuizCreationPages(Base.getDriver());
	CommonPages cp=new CommonPages(Base.getDriver());
	SISProvisioningPage provisioning=new SISProvisioningPage(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	static List<Map<String, String>> testdata=null;
	
	@When("user click on Assessment Center tab in Left menu")
	public void user_click_on_assessment_center_tab_in_left_menu() {
	       QP.Assessmentcentertab();
	}

	@And("Search for the Particular Course and click on it {int}{int}")
	public void search_for_the_particular_course_and_click_on_it(int row,int row1) throws Exception, IOException {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LoginDetails.xlsx",getSheetEnv());
		}
		String ClassroomName=testdata.get(row).get("Classroom Name");
		String SectionName=testdata.get(row).get("Section Name");
		String TFirstName=testdata.get(row1).get("FirstName");
		String TLastName=testdata.get(row1).get("LastName");
		QP.Communityname(ClassroomName, SectionName , TLastName, TFirstName);
	}

	@And("Go to Assessments tab")
	public void go_to_assessments_tab() {
	       QP.Assessmentstab();
	}

	@Then("Create Child Objective by Click on Root Goal Level Ellipses")
	public void create_child_objective_by_click_on_root_goal_level_ellipses() throws Exception, Exception {


	
		QP.EllipsesClick(); 
	}

	@And("Click on Add new Quiz by click on Goal Level Ellipses{int}")
	public void click_on_add_new_quiz_by_click_on_goal_level_ellipses(int row) throws InvalidFormatException, IOException {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LoginDetails.xlsx",getSheetEnv());
		}
		String Testname=testdata.get(row).get("Testname");
	       QP.AddnewQuiz(Testname);
	      
	}

	@Then("Add any test to the Quiz {int}")
	public void add_any_test_to_the_quiz(int row) throws Exception, IOException {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LoginDetails.xlsx",getSheetEnv());
		}
		String TestName=testdata.get(row).get("TestName");
	//	QP.EllipsesClick(TestName);
		QP.Searchtestbutton(TestName);
	}

	@And("Enter the Name,Description,Instruction")
	public void enter_the_name_description_instruction() {
	       QP.QuizDetails();
	      
	}

	@Then("Select the Start Date and Due Date by using Date Picker icon")
	public void select_the_start_date_and_due_date_by_using_date_picker_icon() {
	       QP.Dateselect();
	}

	@And("Handling the Show Answers,Is Override Instructions,Show Test Summary,Show Test Analytics toggles")
	public void handling_the_show_answers_is_override_instructions_show_test_summary_show_test_analytics_toggles() {
	       
	      QP.toggles();
	}
	@Then("User navigates to Badge tab")
	public void user_navigates_to_badge_tab() {
	   QP.Badgetab();   
	}

	@Then("user added a Badge")
	public void user_added_a_badge() {
	    QP.BadgeAdding();
	}

	@Then("User Click on Save button for saving the Quiz")
	public void user_click_on_save_button_for_saving_the_quiz() {
	       cp.Save();
	}

	@When("User enable the publish toggle at Quiz Level")
	public void user_enable_the_publish_toggle_at_quiz_level() {
	       
	}

	@Then("User Navigate to Activity Progress Screen by click on ellipses")
	public void user_navigate_to_activity_progress_screen_by_click_on_ellipses() {
	       
	      
	}

	@And("Compare the Start Date and due Dates in Activity Progress Screen with Tree dates")
	public void compare_the_start_date_and_due_dates_in_activity_progress_screen_with_tree_dates() {
	       
	      
	}

	@Then("Validate the Test tokens with Students data")
	public void validate_the_test_tokens_with_students_data() {
	       
	      
	}

}
