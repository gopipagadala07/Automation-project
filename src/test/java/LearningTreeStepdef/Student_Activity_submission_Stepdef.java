package LearningTreeStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

import com.LearningTree.pages.Student_Activity_Submit_pages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Student_Activity_submission_Stepdef extends ActionType {
	

	ExcelReader reader=new ExcelReader();
	static List<Map<String, String>> testdata=null;
	private Student_Activity_Submit_pages SAS=new Student_Activity_Submit_pages(Base.getDriver());
	
	@When("User Click Learning Tree from Left menu")
	public void user_click_learning_tree_from_left_menu() {
		SAS.click_on_LearningtreeTab();
	   
	}

	@Then("User Search for the Course in Search here Field{int}")
	public void user_search_for_the_course_in_search_here_field(int rownumber1) throws InvalidFormatException, IOException  
	{
		
	testdata = null;
	if(testdata == null)
	{
		testdata = reader.getData("/ExcelFiles/LearningTree.xlsx", getSheetEnv());
		
		String LearningTree_Name = testdata.get(rownumber1).get("LearningCourseName");
		SAS.search_Course(LearningTree_Name);
	}
	else
	{
		System.out.println("testData is null");
	}
}
	
	@And("User Click on that CourseName{int}")
	public void user_click_on_that_course_name(int rownumber1) throws InvalidFormatException, IOException  
	{
		
	testdata = null;
	if(testdata == null)
	{
		testdata = reader.getData("/ExcelFiles/LearningTree.xlsx", getSheetEnv());
		
		String LearningTree_Name = testdata.get(rownumber1).get("LearningCourseName");
		SAS.click_on_Course(LearningTree_Name);
	}
	else
	{
		System.out.println("testData is null");
	}
}
	
	@Then("User go to Learning Tab in community landing page")
	public void user_go_to_learning_tab_in_community_landing_page() {
	  SAS.learningTab();
	}

	@Then("User Click on Launch button for the All Activities")
	public void user_click_on_launch_button_for_the_all_activities() {
	
		SAS.performActivities();
	
	    
	}

}
