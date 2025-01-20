package LearningTreeStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.LearningTree.pages.Activities_Creation_in_CDPage;
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
	private Activities_Creation_in_CDPage AC=new Activities_Creation_in_CDPage(Base.getDriver());


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
		AC.ChildObjectivesCreation();
	}
	@Then("User Add Discussion Activity")
	public void User_Add_Discussion_Activity() 
	{
		AC.click_on_Add_Activity("Unit");
		AC.add_Discussion_Activity();
	}
	@Then("User Add Assignment Activity")
	public void User_Add_Assignment_Activity() 
	{
		AC.click_on_Add_Activity("Unit");
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
		AC.click_on_Add_Activity("Unit");
		AC.add_Assessment_Activity(Testname);
	}
	@Then("User Add Resources Activity")
	public void User_Add_Resources_Activity() 
	{
		AC.click_on_Add_Activity("Unit");
		AC.add_Resources_Activity();
	}
	@Then("User Add External Tool Activity")
	public void User_Add_External_Tool_Activity() 
	{
		AC.click_on_Add_Activity("Unit");
		AC.add_External_Tool_Activity();
	}
	@Then("User Add Epub Activity")
	public void User_Add_Epub_Activity() 
	{
		AC.click_on_Add_Activity("Unit");
		AC.add_Epub_Activity();
	}
	@Then("User Add LTI Activity")
	public void User_Add_LTI_Activity() 
	{
		AC.click_on_Add_Activity("Unit");
		AC.add_LTI_Activity();
	}

	@And("User Add Activities in Virtual Goal{int}")
	public void User_Add_Activities_in_Virtual_Goal(int row) throws InvalidFormatException, IOException 
	{
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String Testname=testdata.get(row).get("TestName");
		AC.click_on_Add_Activity("Virtual");
		AC.add_Assessment_Activity(Testname);
		AC.click_on_Add_Activity("Virtual");
		AC.add_Assignment_Activity();
		AC.click_on_Add_Activity("Virtual");
		AC.add_Discussion_Activity();    
	}
	@And("User Add Activities in Topic Goal{int}")
	public void User_Add_Activities_in_Topic_Goal(int row) throws InvalidFormatException, IOException 
	{
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String Testname=testdata.get(row).get("TestName");
		AC.click_on_Add_Activity("Topic");
		AC.add_Assessment_Activity(Testname);
		AC.click_on_Add_Activity("Topic");
		AC.add_Assignment_Activity();
		AC.click_on_Add_Activity("Topic");
		AC.add_Discussion_Activity();
	}
	@Then("User Add Activities in Sub Topic Goal{int}")
	public void User_Add_Activities_in_Sub_Topic_Goal(int row) throws InvalidFormatException, IOException 
	{
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String Testname=testdata.get(row).get("TestName");
		AC.click_on_Add_Activity("Sub-Topic");
		AC.add_Assessment_Activity(Testname);
		AC.click_on_Add_Activity("Sub-Topic");
		AC.add_Assignment_Activity();
		AC.click_on_Add_Activity("Sub-Topic");
		AC.add_Discussion_Activity();
	}

	@And("User click on Publish Toggle for All Activities in CD")
	public void User_click_on_Publish_Toggle_for_All_Activity_in_CD() 
	{
		AC.publish_All_Activity_in_CD();
	}
}
