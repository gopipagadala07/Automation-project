//package stepDefinations;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//
//import com.Exam_Center.pages.Create_TimeSlot_Page;
//import com.Exam_Center.pages.Examtaker_enrollment_at_Procter_side_Page;
//import com.Exam_Center.pages.Login_page;
//import com.FP_Examcenter.util.ActionType;
//import com.FP_Examcenter.util.Base;
//import com.FP_Examcenter.util.ExcelReader;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Enroll_ExamTaker_to_a_TimeSlot_Stepdefination extends ActionType
//{
//	private Login_page loginpage = new Login_page(Base.getDriver());
//	private Create_TimeSlot_Page createtimeslot = new Create_TimeSlot_Page(Base.getDriver());
//	private Examtaker_enrollment_at_Procter_side_Page ET_Enrollment= new Examtaker_enrollment_at_Procter_side_Page(Base.getDriver());
//	
//	static ExcelReader reader = new ExcelReader();
//	static List<Map<String,String>> testData = null;
//	
//	@Given("User launch the application with a valid URL for ExamTaker Enrollment")
//	public void user_launch_the_application_with_a_valid_url_for_exam_taker_enrollment() 
//	{
//		getURL(getProperty("url"));
//	}
//
//	@And("User enters the login credentials for ExamTaker Enrollment {int}")
//	public void user_enters_the_login_credentials_for_exam_taker_enrollment(Integer RowNumber) throws InvalidFormatException, IOException
//	{
//		waitForPageLoad();
//		if(testData == null)
//		{
//			testData = reader.getData("/ExcelFiles/LoginCredentials.xlsx", getSheetEnv());
//			String username = testData.get(RowNumber).get("username");
//			String password = testData.get(RowNumber).get("password");
//			loginpage.user_login(username, password);
//		}
//	}
//	@When("User select the particular Examination for Enrollment {int}")
//	public void user_select_the_particular_examination_for_enrollment_exam_taker_details_rownumber(Integer erownumber) throws InvalidFormatException, IOException
//	{
//		waitForPageLoad();
//		createtimeslot.click_On_Enrollment_Tab();
//		waitForPageLoad();
//		createtimeslot.click_On_Examination_Lookup();
//		testData = null;
//		if(testData == null)
//		{
//			testData = reader.getData("/ExcelFiles/Examtaker_Details.xlsx", getSheetEnv());
//			String Examination = testData.get(erownumber).get("Examination");
//			String Schedule = testData.get(erownumber).get("Schedule");
//			createtimeslot.select_the_Examination(Examination, Schedule);
//		}
//		else
//		{
//			System.out.println("testData is null");
//		}
//	}
//
//	@Then("User select the particular Location for Enrollment {int}")
//	public void user_select_the_particular_location_for_enrollment_exam_taker_details_rownumber(Integer lrownumber) throws InvalidFormatException, IOException 
//	{
//		createtimeslot.click_On_Location_Lookup();
//		testData = null;
//		if(testData == null)
//		{
//			testData = reader.getData("/ExcelFiles/Examtaker_Details.xlsx", getSheetEnv());
//			String Location = testData.get(lrownumber).get("Location");
//			createtimeslot.select_the_Location(Location);
//		}
//		else
//		{
//			System.out.println("testData is null");
//		}
//	}
//
//	@When("User select the particular Timeslot {int}")
//	public void user_select_the_particular_timeslot(int time) throws InvalidFormatException, IOException 
//	{
//		ET_Enrollment.click_on_Time_slot_Lookup();
//		testData = null;
//		if(testData == null)
//		{
//			testData = reader.getData("/ExcelFiles/Time_Slot_Details.xlsx", getSheetEnv());
//			String Sthr = testData.get(time).get("StartTimeHr");
//			String Stmin = testData.get(time).get("StartTimeMin");
//			String EtHr = testData.get(time).get("EndTimeHr");
//			String Etmin = testData.get(time).get("EndTimeMin");
//			ET_Enrollment.select_the_TimeSlot(Sthr, Stmin, EtHr, Etmin);
//		}
//		else
//		{
//			System.out.println("testData is null");
//		}
//	}
//
//	@Then("User search the particular ExamTaker {int}")
//	public void user_search_the_particular_exam_taker(Integer rownumber) throws InvalidFormatException, IOException
//	{
//		testData = null;
//		if(testData == null)
//		{
//			testData = reader.getData("/ExcelFiles/Examtaker_Details.xlsx", getSheetEnv());
//			String FName = testData.get(rownumber).get("Examtaker_Firstname");
//			String LName = testData.get(rownumber).get("Examtaker_Lastname");
//			ET_Enrollment.search_Examtaker_under_enrollment(LName, FName);
//		}
//		else
//		{
//			System.out.println("testData is null");
//		}
//	}
//
//	@When("User add the Examtaker in the Timeslot")
//	public void user_add_add_the_examtaker_in_the_timeslot() 
//	{
//	    StaticWait(3);
//	    ET_Enrollment.addExamtaker();
//	}
//
//	@Then("User search the ExamTaker for the approve and Live the Examination {int}")
//	public void user_search_the_exam_taker_for_the_approve_and_live_the_examination(Integer rownumber) throws InvalidFormatException, IOException
//	{
//		testData = null;
//		if(testData == null)
//		{
//			testData = reader.getData("/ExcelFiles/Examtaker_Details.xlsx", getSheetEnv());
//			String FName = testData.get(rownumber).get("Examtaker_Firstname");
//			String LName = testData.get(rownumber).get("Examtaker_Lastname");
//			ET_Enrollment.search_Examtaker_in_a_Timeslot(LName, FName);
//		}
//		else
//		{
//			System.out.println("testData is null");
//		}
//	}
//
//	@When("User approve and Live the Examtaker for the Examination")
//	public void user_approve_and_live_the_examtaker_for_the_examination() 
//	{
//	    ET_Enrollment.approve_and_Live_the_Examtaker();
//	}
//
//}
