package LearningTreeStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.LearningTree.pages.Import_Activities_in_LT;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Import_Activities_in_LTStefdef extends ActionType
{
	
	ExcelReader reader=new ExcelReader();
	static List<Map<String, String>> testdata=null;
	private Import_Activities_in_LT ILT=new Import_Activities_in_LT(Base.getDriver());
	
	@And("User Click Courses in Left menu")
	public void user_click_courses_in_left_menu() {
	    ILT.click_on_CoursesTab();
	}

	@Then("User Click on the Create New Course button")
	public void user_click_on_the_create_new_course_button() {
	    ILT.click_on_Add_LT_Community();
	}

	@When("User Enter the Course Name and Description")
	public void user_enter_the_course_name_and_description() throws Exception {
	    ILT.enter_LtName_Description();
	}

	@Then("User Saved the Course and Search for the Created Course in Search here Field{int}")
	public void user_saved_the_course_and_search_for_the_created_course_in_search_here_field(int row) throws InvalidFormatException, IOException {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String LearningCourseName=testdata.get(row).get("LearningCourseName");
		ILT.search_Course(LearningCourseName);
	}
	

	@And("User Click on that Course{int}")
	public void user_click_on_that_course(int row) throws InvalidFormatException, IOException {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String LearningCourseName=testdata.get(row).get("LearningCourseName");
		ILT.click_on_Course(LearningCourseName);
	}

	@When("User Search the Learning Objective and Assign it to the Course{int}")
	public void user_search_the_learning_objective_and_assign_it_to_the_course(int row) throws InvalidFormatException, IOException {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String CD_Name=testdata.get(row).get("CourseDesignerName");
		ILT.assign_The_Learning_objective(CD_Name);
		
	}
	@Then("User go to Learning Tab")
	public void User_go_to_Learning_Tab() {
		ILT.learningTab();
	}

	@Then("User Publish and Activate all the Activities")
	public void user_publish_and_activate_all_activity() {
		ILT.publish_And_Activate();
		
	}
	@And("User go to Member Tab")
	public void user_go_to_member_tab() {
		ILT.click_on_Members_Tab();

	}
	@Then("User Search and added the Student in the Course{int}")
	public void User_Search_and_added_the_Student_in_the_Course(int row) throws InvalidFormatException, IOException {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String LastName=testdata.get(row).get("LastName");
		ILT.add_Student_in_Member(LastName);

	}
}
