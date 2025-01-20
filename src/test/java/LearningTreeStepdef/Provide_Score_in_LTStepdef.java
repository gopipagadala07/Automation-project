package LearningTreeStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.LearningTree.pages.Provide_Score_For_LT_ActivitiesPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Provide_Score_in_LTStepdef extends ActionType
{
	ExcelReader reader=new ExcelReader();
	static List<Map<String, String>> testdata=null;
	private Provide_Score_For_LT_ActivitiesPage SL = new Provide_Score_For_LT_ActivitiesPage(Base.getDriver());
	
	@Then("User Click on Overal Speed Grader")
	public void user_click_on_overal_speed_grader() {
		SL.click_on_Overal_Speed_Grader();
	}

	@When("User select All lookups in Activities To Grade screen{int}{int}")
	public void user_select_all_lookups_in_activities_to_grade_screen(int row,int row1) throws InvalidFormatException, IOException 
	{
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String LearningCourseName=testdata.get(row).get("LearningCourseName");
		
		System.out.println("Course Name: "+LearningCourseName);
		String LastName=testdata.get(row1).get("LastName");
		String FirstName=testdata.get(row1).get("FirstName");
		System.out.println("Student Name: "+LastName+"    "+FirstName);
		StaticWait(1);
		SL.select_Community(LearningCourseName);
		StaticWait(1);		
		SL.all_ActivitiesDropDown();
		StaticWait(1);
		SL.All_MembersDropDown(LastName, FirstName);
	}
	@Then("provide the score for all Activities")
	public void provide_the_score_for_all_activities() {
		SL.Provide_Score_Overal_Speed_Grader_Level();    
	}
	@When("User Close Activity to Grade Screen")
	public void User_Close_Activity_to_Grade_Screen() {
		SL.close_the_Overal_Speed_Grader_Screen();
	    
	}
	@Then("User Provide the Score in Activity To Grade")
	public void User_Provide_the_Score_in_Activity_To_Grade() {
		SL.activities_to_Garde();
	    
	}
	@Then("User Provide the Score in Activity Progress screen{int}")
	public void User_Provide_the_Score_in_Activity_Progress_screen(int row) throws InvalidFormatException, IOException {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/LearningTree.xlsx",getSheetEnv());
		}
		String LastName=testdata.get(row).get("LastName");
		SL.Provide_the_Score_in_Activity_Progress_screen(LastName);
	    
	}

}
