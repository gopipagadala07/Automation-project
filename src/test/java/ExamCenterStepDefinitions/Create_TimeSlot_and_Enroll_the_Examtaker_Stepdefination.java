package ExamCenterStepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.Examcenter.pages.TimeSlotCreation_and_enrollExamataker_Page;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
import com.Utils.ExcelReader;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Create_TimeSlot_and_Enroll_the_Examtaker_Stepdefination extends ActionType
{
	static ExcelReader reader = new ExcelReader();
	static List<Map<String,String>> testData = null;
	
	CommonPages cp=new CommonPages(Base.getDriver());
	private TimeSlotCreation_and_enrollExamataker_Page createtimeslot_and_enrollexamatker = new TimeSlotCreation_and_enrollExamataker_Page(Base.getDriver());


	@Then("User click on Enrollment")
	public void user_click_on_enrollment() 
	{
		waitForPageLoad();
		createtimeslot_and_enrollexamatker.click_On_Enrollment_Tab();
	}


	@When("User Select the Examination {int}")
	public void user_select_the_examination(Integer erownumber) throws InvalidFormatException, IOException 
	{
		testData = null;
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
			String Examination = testData.get(erownumber).get("ExamName");
			String Schedule = testData.get(erownumber).get("ScheduleName");
			createtimeslot_and_enrollexamatker.select_the_Examination(Examination, Schedule);
		}
		else
		{
			System.out.println("testData is null");
		}
	}



	@Then("User Select the Location {int}")
	public void user_select_the_location(Integer lrownumber) throws InvalidFormatException, IOException 
	{
		testData = null;
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
			String Location = testData.get(lrownumber).get("Location");
			createtimeslot_and_enrollexamatker.select_the_Location(Location);
		}
		else
		{
			System.out.println("testData is null");
		}
	}

	@And("User click on TimeSlot Tab")
	public void user_click_on_time_slot_tab() 
	{
		createtimeslot_and_enrollexamatker.click_on_TimeslotTab();
	}
	@Then("User click on Add New TimeSlot")
	public void user_click_on_add_new_time_slot() 
	{
		createtimeslot_and_enrollexamatker.Add_New_TimeSlot();
	}

	@When("User click on the calender and select the Exam date from calendar")
	public void user_click_on_the_calender_and_select_the_Exam_date_from_calendar() 
	{
		createtimeslot_and_enrollexamatker.open_the_Calender();
	}

	@Then("User select the start time from time picker")
	public void user_select_the_start_time_from_timepicker() {
		createtimeslot_and_enrollexamatker.select_start_time_from_timepicker();

	}
	@Then ("User clicks on ok button")
	public void user_click_on_start_ok_button() {
		createtimeslot_and_enrollexamatker.okButton(); 
	}


	@When("User click on the end Time in Exam Time slot popup")
	public void user_click_on_the_end_time_in_exam_time_slot_popup()
	{
		createtimeslot_and_enrollexamatker.clickon_EndTime();
	}
	
	
	@Then("User provide the examtaker count")
	public void user_provide_the_examtaker_count()
	{
		createtimeslot_and_enrollexamatker.ExamTaker_Count();
	}
	
	@Then("User click on Exam Time Slot Save button")
	public void user_click_on_Exam_Time_Slot_Save_button() 
	{
		cp.Save();
		ExtentCucumberAdapter.addTestStepLog("Timeslot created..!!");
	}
	
	
	  @Then("User click on Enrollee tab")
	  public void user_click_on_Enrollee_tab() {
		  createtimeslot_and_enrollexamatker.Enrollee_tab();
	  }
	  
	 @Then("User click Timeslot lookup and select particular Timeslot")
	 public void user_click_Timeslot_lookup_and_select_particular_Timeslot() {
		 createtimeslot_and_enrollexamatker.click_on_Time_slot_Lookup_and_select_timeslot();
	 }
	 
	 @When("User search the particular ExamTaker {int}")
		public void User_search_the_particular_ExamTaker(Integer rownumber2) throws InvalidFormatException, IOException 
		{
			testData = null;
			if(testData == null)
			{
				testData = reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
				
				String ELastName = testData.get(rownumber2).get("LastName");
				String EFirstname = testData.get(rownumber2).get("FirstName");
				
				createtimeslot_and_enrollexamatker.search_Examtaker_under_enrollment(EFirstname, ELastName);
			}
			else
			{
				System.out.println("testData is null");
			}
		}

    @When("User add the Examtaker in the Timeslot")
    public void user_add_the_examtaker_in_the_timeslot() {
    	createtimeslot_and_enrollexamatker.addExamtaker();
    }
    
    
    @Then("User search the added ExamTaker in the TimeSlot {int}")
    public void User_search_the_added_ExamTaker_in_the_TimeSlot(Integer rownumber) throws InvalidFormatException, IOException 
    {
    	testData = null;
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
			
			String ELName = testData.get(rownumber).get("LastName");
			String EFName = testData.get(rownumber).get("FirstName");
			
			createtimeslot_and_enrollexamatker.search_Examtaker_in_a_Timeslot(EFName, ELName);
		}
		else
		{
			System.out.println("testData is null");
		}
    }
    
    @When("User approve and Live the Examtaker for the Examination")
    public void User_approve_and_Live_the_Examtaker_for_the_Examination() {
    	createtimeslot_and_enrollexamatker.approve_and_Live_the_Examtaker();
    }

}
