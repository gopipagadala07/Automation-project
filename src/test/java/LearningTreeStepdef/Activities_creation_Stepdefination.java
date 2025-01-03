package LearningTreeStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.LearningTree.pages.Activities_Creation_in_CD;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activities_creation_Stepdefination extends ActionType
{
	ExcelReader reader=new ExcelReader();
	static List<Map<String, String>> testdata=null;
	private Activities_Creation_in_CD AC=new Activities_Creation_in_CD(Base.getDriver());
	
	
	@And("User Click Course Designer in Left menu")
	public void user_click_course_designer_in_left_menu() {
		AC.click_on_CoursrDesignerTab();
	}
	@Then("User Click on the Add New Community button")
	public void user_click_on_the_add_new_community_button()  {
	   AC.click_on_Add_a_Community();
	}
	@When("User Enter the Community Name and Description")
	public void user_enter_the_community_name_and_description() throws Exception {
	    AC.enter_CName_Description();
	}
	@Then("User Saved the Community and Search for the Created Community in Search here Field{int}")
	public void user_saved_the_community_and_search_for_the_created_community_in_search_here_field(int row) throws InvalidFormatException, IOException {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String CD_Name=testdata.get(row).get("CourseDesignerName");
		AC.search_Community(CD_Name);
	}
	@And("User Click on that Community{int}")
	public void user_click_on_that_community(int row) throws InvalidFormatException, IOException {
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String CD_Name=testdata.get(row).get("CourseDesignerName");
		AC.click_on_Community(CD_Name);
	}

	@Then("User Add Child Objective")
	public void user_add_child_objective() 
	{
	    AC.addChildObjective();
	}
	@Then("User Add Discussion Activity")
	public void User_Add_Discussion_Activity() 
	{
	    AC.click_on_Add_Activity();
	    AC.add_Discussion_Activity();
	}
	@Then("User Add Assignment Activity")
	public void User_Add_Assignment_Activity() 
	{
	    AC.click_on_Add_Activity();
	    AC.add_Assignment_Activity();
	}
	@Then("User Add Assessment Activity{int}")
	public void User_Add_Assessment_Activity(int row) throws InvalidFormatException, IOException 
	{
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String Testname=testdata.get(row).get("TestName");
	    AC.click_on_Add_Activity();
	    AC.add_Assessment_Activity(Testname);
	}
	@Then("User Add Resources Activity")
	public void User_Add_Resources_Activity() 
	{
	    AC.click_on_Add_Activity();
	    AC.add_Resources_Activity();
	}
	@And("User click on Publish Toggle for All Activity in CD")
	public void User_click_on_Publish_Toggle_for_All_Activity_in_CD() 
	{
	    AC.publish_All_Activity_in_CD();
	}
}
