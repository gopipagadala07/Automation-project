package AssessmentsStepdef;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Assessments.pages.QuizCreationPages;
import com.Assessments.pages.SISProvisioningAssessmentCenterPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QuizCreationStepdefinitions extends ActionType{

	QuizCreationPages QP=new QuizCreationPages(Base.getDriver());
	CommonPages cp=new CommonPages(Base.getDriver());
	SISProvisioningAssessmentCenterPage provisioning=new SISProvisioningAssessmentCenterPage(Base.getDriver());
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
			testdata=reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx",getSheetEnv());
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

	@Then("Create Child Objectives by Click on Root Goal Level Ellipses")
	public void create_child_objective_by_click_on_root_goal_level_ellipses() throws Exception, Exception {
		QP.ChildObjectivesCreation(); 
	}

	@Then("Create the Quizzes by using Add new Quiz button{int}")
	public void add_any_test_to_the_quiz(int row) throws Exception, IOException {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx",getSheetEnv());
		}
		String Testname=testdata.get(row).get("TestName");
		QP.QuizzesCreation(Testname);
	}
	@And("Compare the Start Date and due Dates in Activity Progress Screen with Tree dates")
	public void compare_the_start_date_and_due_dates_in_activity_progress_screen_with_tree_dates() {


	}

	@Then("Validate the Test tokens with Students data")
	public void validate_the_test_tokens_with_students_data() {


	}

}