package stepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.Exam_Center.pages.Create_TimeSlot_and_enroll_Examatker_Page;
import com.FP_Examcenter.util.ActionType;
import com.FP_Examcenter.util.Base;
import com.FP_Examcenter.util.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Create_TimeSlot_and_Enroll_the_Examtaker_Stepdefination extends ActionType
{
	private Create_TimeSlot_and_enroll_Examatker_Page createt_ts_and_enroll_examatker = new Create_TimeSlot_and_enroll_Examatker_Page(Base.getDriver());
	static ExcelReader reader = new ExcelReader();
	static List<Map<String,String>> testData = null;


	@Then("User click on Enrollment")
	public void user_click_on_enrollment() 
	{
		waitForPageLoad();
		createt_ts_and_enroll_examatker.click_On_Enrollment_Tab();
	}
//	@When("User click on the Examination Lookup")
//	public void user_click_on_the_examination()   
//	{
//		waitForPageLoad();
//		createt_ts_and_enroll_examatker.click_On_Examination_Lookup();
//	}
	@When("User Select the Examination {int}")
	public void user_select_the_examination(Integer erownumber) throws InvalidFormatException, IOException 
	{
		testData = null;
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/Examtaker_Details.xlsx", getSheetEnv());
			String Examination = testData.get(erownumber).get("Examination");
			String Schedule = testData.get(erownumber).get("Schedule");
			createt_ts_and_enroll_examatker.select_the_Examination(Examination, Schedule);
		}
		else
		{
			System.out.println("testData is null");
		}
	}
//	@When("User click on the Location Lookup")
//	public void user_click_on_the_location_lookup() 
//	{
//		createt_ts_and_enroll_examatker.click_On_Location_Lookup();
//	}

	@Then("User Select the Location {int}")
	public void user_select_the_location(Integer lrownumber) throws InvalidFormatException, IOException 
	{
		testData = null;
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/Examtaker_Details.xlsx", getSheetEnv());
			String Location = testData.get(lrownumber).get("Location");
			createt_ts_and_enroll_examatker.select_the_Location(Location);
		}
		else
		{
			System.out.println("testData is null");
		}
	}
	@And("User click on TimeSlot Tab")
	public void user_click_on_time_slot_tab() 
	{
		createt_ts_and_enroll_examatker.click_on_TimeslotTab();
	}

	@Then("User click on Add New TimeSlot")
	public void user_click_on_add_new_time_slot() 
	{
		createt_ts_and_enroll_examatker.Add_New_TimeSlot();
	}

	@When("User click on the calender in Exam Time slot popup")
	public void user_click_on_the_calender_in_exam_time_slot_popup() 
	{
		createt_ts_and_enroll_examatker.open_the_Calender();
	}

	@Then("User select the Exam date {int}")
	public void user_select_the_exam_date(Integer calender) throws InvalidFormatException, IOException 
	{
		createt_ts_and_enroll_examatker.click_on_ChooseMonthandYear();
		testData = null;
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/Time_Slot_Details.xlsx", getSheetEnv());
			//System.out.println(testData+"1");
			String year = testData.get(calender).get("Year");
			String month = testData.get(calender).get("Month");
			String date = testData.get(calender).get("Date");
			createt_ts_and_enroll_examatker.select_year(year);
			createt_ts_and_enroll_examatker.select_Month(month);
			createt_ts_and_enroll_examatker.select_date(date);
		}
		else
		{
			System.out.println("testData is null");
		}
	}

	@When("User click on the start Time in Exam Time slot popup")
	public void user_click_on_the_start_time_in_exam_time_slot_popup()
	{
		createt_ts_and_enroll_examatker.clickon_StartTime();
	}

	@Then("User select the start Time in Hr {int}")
	public void user_select_the_start_time_in_hr(Integer starttimeinhr) throws InvalidFormatException, IOException
	{
		testData = null;
		createt_ts_and_enroll_examatker.clickOnHr();
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/Time_Slot_Details.xlsx", getSheetEnv());
			//System.out.println(testData+"1");
			String starTtimeinHr = testData.get(starttimeinhr).get("StartTimeHr");
			createt_ts_and_enroll_examatker.select_StartTimeinHr(starTtimeinHr);
		}
		else
		{
			System.out.println("testData is null");
		}
	}

	@Then("User select the start Time in Min {int}")
	public void user_select_the_start_time_in_min(Integer starttimeinmin) throws InvalidFormatException, IOException 
	{
		testData = null;
		createt_ts_and_enroll_examatker.clickOnMin();
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/Time_Slot_Details.xlsx", getSheetEnv());
			//System.out.println(testData+"1");
			String starTtimeinMin1 = testData.get(starttimeinmin).get("StartTimeMin");
			int m1=Integer.parseInt(starTtimeinMin1)*6;
			String starTtimeinMin2=String.valueOf(m1);
			createt_ts_and_enroll_examatker.select_StartTimeinMin(starTtimeinMin2);
		}
		else
		{
			System.out.println("testData is null");
		}
		createt_ts_and_enroll_examatker.okButton();
	}

	@When("User click on the end Time in Exam Time slot popup")
	public void user_click_on_the_end_time_in_exam_time_slot_popup() 
	{
		createt_ts_and_enroll_examatker.clickon_EndTime();
	    StaticWait(1);
	}

	@Then("User select the end Time in Hr {int}")
	public void user_select_the_end_time_in_hr(Integer endtimeinhr) throws InvalidFormatException, IOException 
	{
		testData = null;
		createt_ts_and_enroll_examatker.clickOnHr();
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/Time_Slot_Details.xlsx", getSheetEnv());
			//System.out.println(testData+"1");
			String endTtimeinHr = testData.get(endtimeinhr).get("EndTimeHr");
			createt_ts_and_enroll_examatker.select_StartTimeinHr(endTtimeinHr);
		}
		else
		{
			System.out.println("testData is null");
		}
	}

	@Then("User select the end Time in Min {int}")
	public void user_select_the_end_time_in_min(Integer endtimeinmin) throws InvalidFormatException, IOException
	{
		testData = null;
		createt_ts_and_enroll_examatker.clickOnMin();
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/Time_Slot_Details.xlsx", getSheetEnv());
			//System.out.println(testData+"1");
			String endTtimeinMin1 = testData.get(endtimeinmin).get("EndTimeMin");
			int m1=Integer.parseInt(endTtimeinMin1)*6;
			String endTtimeinMin2=String.valueOf(m1);
			createt_ts_and_enroll_examatker.select_EndTimeinMin(endTtimeinMin2);
		}
		else
		{
			System.out.println("testData is null");
		}
		createt_ts_and_enroll_examatker.okButton();
	}	

	@Then("User provide the examtaker count {int}")
	public void user_provide_the_examtaker_count(Integer examatkercount) throws InvalidFormatException, IOException 
	{
		testData = null;
		//createt_ts_and_enroll_examatker.clickOnHr();
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/Time_Slot_Details.xlsx", getSheetEnv());
			//System.out.println(testData+"1");
			String examTakerCount = testData.get(examatkercount).get("ExamTakerCount");
			createt_ts_and_enroll_examatker.ExamTaker_Count(examTakerCount);
		}
		else
		{
			System.out.println("testData is null");
		}	    
	}
	@Then("User click on Exam Time Slot Save button")
	public void user_click_on_exam_time_slot_save_button() 
	{
		createt_ts_and_enroll_examatker.clickon_SaveButton();
		System.out.println("Sucessfully Time Slot Created !!!!!!!");

	}
	@When("User select the particular Timeslot {int}")
	public void user_select_the_particular_timeslot(int time) throws InvalidFormatException, IOException 
	{
		createt_ts_and_enroll_examatker.click_on_Time_slot_Lookup();
		testData = null;
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/Time_Slot_Details.xlsx", getSheetEnv());
			String Sthr = testData.get(time).get("StartTimeHr");
			String Stmin = testData.get(time).get("StartTimeMin");
			String EtHr = testData.get(time).get("EndTimeHr");
			String Etmin = testData.get(time).get("EndTimeMin");
			createt_ts_and_enroll_examatker.select_the_TimeSlot(Sthr, Stmin, EtHr, Etmin);
		}
		else
		{
			System.out.println("testData is null");
		}
	}

	@Then("User search the particular ExamTaker {int}")
	public void user_search_the_particular_exam_taker(Integer rownumber) throws InvalidFormatException, IOException
	{
		testData = null;
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/Examtaker_Details.xlsx", getSheetEnv());
			String FName = testData.get(rownumber).get("Examtaker_Firstname");
			String LName = testData.get(rownumber).get("Examtaker_Lastname");
			createt_ts_and_enroll_examatker.search_Examtaker_under_enrollment(LName, FName);
		}
		else
		{
			System.out.println("testData is null");
		}
	}

	@When("User add the Examtaker in the Timeslot")
	public void user_add_add_the_examtaker_in_the_timeslot() 
	{
	    StaticWait(3);
	    createt_ts_and_enroll_examatker.addExamtaker();
	}

	@Then("User search the added ExamTaker in the TimeSlot {int}")
	public void user_search_the_exam_taker_for_the_approve_and_live_the_examination(Integer rownumber) throws InvalidFormatException, IOException
	{
		testData = null;
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/Examtaker_Details.xlsx", getSheetEnv());
			String FName = testData.get(rownumber).get("Examtaker_Firstname");
			String LName = testData.get(rownumber).get("Examtaker_Lastname");
			createt_ts_and_enroll_examatker.search_Examtaker_in_a_Timeslot(LName, FName);
		}
		else
		{
			System.out.println("testData is null");
		}
	}

	@When("User approve and Live the Examtaker for the Examination")
	public void user_approve_and_live_the_examtaker_for_the_examination() 
	{
		createt_ts_and_enroll_examatker.approve_and_Live_the_Examtaker();
	}
	
}




