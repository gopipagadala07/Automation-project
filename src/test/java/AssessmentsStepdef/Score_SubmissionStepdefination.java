package AssessmentsStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Assessments.pages.Score_SubmissionPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Score_SubmissionStepdefination extends ActionType   
{
	ExcelReader reader=new ExcelReader();
	static List<Map<String, String>> testdata=null;

	Score_SubmissionPage S_Submission = new Score_SubmissionPage(Base.getDriver());
	@When("User Click on Overal Speed Grader")
	public void user_click_on_overal_speed_grader() 
	{
		S_Submission.speedGrader();
	}

	@Then("Select Dropdown in Speed Grader {int}{int}")
	public void select_dropdown_in_speed_grader(Integer row,int row2) throws InvalidFormatException, IOException 
	{
		if (testdata == null) 
		{
			testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
		}
		String ClaroomName = testdata.get(row).get("Classroom Name");	
		String SectionName = testdata.get(row).get("Section Name");
		String SFirstname = testdata.get(row2).get("FirstName");
		String SLastName = testdata.get(row2).get("LastName");
		
		System.out.print(ClaroomName + SectionName + "  " + SFirstname + "  "+SLastName);

		StaticWait(1);
		S_Submission.select_CommunitiesDropDown(ClaroomName);
		StaticWait(1);
		S_Submission.all_Activity_TypesDropDown();
		StaticWait(1);
		S_Submission.all_ActivitiesDropDown();
		StaticWait(1);
		S_Submission.All_MembersDropDown();
	}

	@Then("clicks on Score button")
	public void clicks_on_score_button() 
	{
		S_Submission.click_On_Score();
	}

	@Then("Enter the Score and FeedBack")
	public void enter_the_score_and_feed_back() 
	{
		S_Submission.provide_the_Score();
	}

	@Then("submit the Score")
	public void submit_the_score() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("capture the status band")
	public void capture_the_status_band() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
