package ExamCenterStepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Examcenter.pages.Create_Examinations_pages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateExaminations_Stepdefinations extends ActionType {
	
	static ExcelReader reader=new ExcelReader();

	static List<Map<String,String>> testData=null;
	//private EC_Loginpage EClogin=new EC_Loginpage(Base.getDriver());
	private Create_Examinations_pages CreateExams=new Create_Examinations_pages(Base.getDriver());

	@And("^Again click on the Schedule dropdown$")
	public void again_click_on_the_schedule_dropdown() {
		CreateExams.click_on_Schedule_dropdown();
	 
	}

	@Then("Choose one Schedule name from an selected Examinations {int}")
	public void choose_one_schedule_name_from_an_selected_examinations(Integer col12) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());	
		}
		String schedulename = testData.get(col12).get("ScheduleName");	  
		CreateExams.select_schedule_lookup(schedulename);
	}

	@Then("^Click on datepicker icon$")
	public void click_on_datepicker_icon() {
	   CreateExams.click_on_datepicker();
	}

	@Then("Click on Provisioning tab")
	public void click_on_provisioning_tab() {
	  CreateExams.provisioning();
	}

	@And("^Click on Search Test button in Add-Edit schedule popup$")
	public void click_on_search_test_button_in_add_edit_schedule_popup() {
		CreateExams.Search_Test_button();
	}

	@Then("Enabled the published and Exam live toggles with schedulename {int}")
	public void enabled_the_published_and_exam_live_toggles_with_schedulename(Integer rownumber8) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());	

		}

		String schedulename = testData.get(rownumber8).get("ScheduleName");
		CreateExams.published_Examlive_toggle(schedulename);
	}

	@Then("Select one Examinations name from excel {int}")
	public void select_one_examinations_name_from_excel(Integer col11) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());	
		}
		String Examname = testData.get(col11).get("ExamName");	  
		CreateExams.select_examinations_lookup(Examname);
	}

	@And("User choose the date month year from excel datepicker {int}")
	public void user_choose_the_date_month_year_from_excel_datepicker(Integer rownumber6) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());	

		}
		String Yeartext = testData.get(rownumber6).get("Year");
		String Monthtext = testData.get(rownumber6).get("Month");
		String Datetext = testData.get(rownumber6).get("Date");
		CreateExams.Date_picker(Yeartext, Monthtext, Datetext);

	}

	@And("^User click on AddExam button under Examination tab$")
	public void user_click_on_add_exam_button_under_examination_tab() {
		CreateExams.Add_Exam();
	}

	//Creating a new Schedule
	@Then("^User click on Add New schedule button$")
	public void user_click_on_add_new_schedule_button() {
		CreateExams.Add_new_Schedule();
	}

	//Enroll to an Exam
	@Then("User click on Administration tab")
	public void user_click_on_administration_tab() {
	   CreateExams.Adminstarationbtn();
	}

	@Then("^User click on edit Save button$")
	public void user_click_on_edit_save_button() {
		CreateExams.Edit_Save_button();   
	}

	@Then("^User click on Enroll to an Exam button$")
	public void user_click_on_enroll_to_an_exam_button() {
		
		CreateExams.Enroll_To_An_Exam();
	 
	}

	@And("^User click on Enrollment Save button$")
	public void user_click_on_enrollment_save_button() {
		CreateExams.enrollment_save();
		System.out.println("Exam Enrolled Successfully");
		
	}

	@Then("^User click on ExamAdministration tab$")
	public void user_click_on_exam_administration_tab() 
	{
		waitForPageLoad();
		StaticWait(1);
		CreateExams.Exam_Administration();
	}
	@Then("^User click on Go icon and click on Add icon for that searched test$")
	public void user_click_on_go_icon_and_click_on_add_icon_for_that_searched_test() {
		CreateExams.icons_Action();

	}

	@Then("^User click on save button$")
	public void user_click_on_save_button() {
		CreateExams.Save_button();
		StaticWait(1);
		System.out.println("Exam Saved Successfully");
	}
	

	@Then("^User click on Schedule Save button$")
	public void user_click_on_schedule_save_button() {
		CreateExams.schedulesave();
		System.out.println("Schedule Saved Successfully");

	}

	@Then("^User click on Searched Examination Edit button$")
	public void user_click_on_searched_examination_edit_button() {
		CreateExams.Edit_Examinations();

	}

	@And("^User click on the Examinations dropdown$")
	public void user_click_on_the_examinations_dropdown() {
		CreateExams.click_on_exam_dropdown();  
	}
	
	@Then("User click on the searched Examtaker {int}")
	public void user_click_on_the_searched_examtaker(Integer col10) throws InvalidFormatException, IOException {
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/UsersCreationDetails.xlsx", getSheetEnv());	

		}
		String Firstnametxt=testData.get(col10).get("FirstName");
		String Lastnametxt=testData.get(col10).get("LastName");	  
		CreateExams.click_on_searched_examtaker(Lastnametxt,Firstnametxt);
	}

	@Then("User edited the examination name {int}")
	public void user_edited_the_examination_name(Integer rownumber3) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());	
			//	System.out.println(testData);

		}

		String editexamnamefield = testData.get(rownumber3).get("EditExamname");
		CreateExams.Edit_Examname(editexamnamefield);
	}


	@And("^User enable the all toggles$")
	public void user_enable_the_all_toggles() {
		CreateExams.All_toggles();

	}
	@And("User enter the Schedule name with {int}")
	public void user_enter_the_schedule_name_with(Integer rownumber5) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());	

		}

		String Schedulename = testData.get(rownumber5).get("ScheduleName");
		CreateExams.Enter_Schedule_name(Schedulename);

	}

	@Then("User enters the Examname and Description from the given excelsheet at {int}")
	public void user_enters_the_examname_and_description_from_the_given_excelsheet_at(Integer rownumber1) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());	
			//System.out.println(testData);
		}
		String examnametxtfield = testData.get(rownumber1).get("ExamName");
		String examdescription = testData.get(rownumber1).get("ExamDescription");
		//CreateExams.Examinationstab(examnametxtfield, examdescription);	
		CreateExams.Exam_name_field(examnametxtfield);
		CreateExams.Exam_Description(examdescription);
	}

	@Then("User enters the text in the Ckeditor fields from excel {int}")
	public void user_enters_the_text_in_the_ckeditor_fields_from_excel(Integer rownumber7) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());	

		}

		String OnlineTestingInstructions = testData.get(rownumber7).get("OnlineTestingInstructions");
		String PrintFormInstructions = testData.get(rownumber7).get("PrintFormInstructions");
		String ScheduleDescription = testData.get(rownumber7).get("ScheduleDescription");
		CreateExams.Ck_editor_texts(OnlineTestingInstructions, PrintFormInstructions, ScheduleDescription);
	 
	}

	@And("User Search the Examination in Search here field {int}")
	public void user_search_the_examination_in_search_here_field(Integer rownumber2) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());	
			//System.out.println(testData);

		}

		String searchexamnamefield = testData.get(rownumber2).get("ExamName");
		CreateExams.Exam_Search_here(searchexamnamefield,searchexamnamefield);
	}
	

	@And("User Search the Examtaker in Search here field {int}")
	public void user_search_the_examtaker_in_search_here_field(Integer col9) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/UsersCreationDetails.xlsx", getSheetEnv());	

		}
		String Firstnametxt=testData.get(col9).get("FirstName");
		String Lastnametxt=testData.get(col9).get("LastName");
		CreateExams.Examtaker_search(Lastnametxt,Firstnametxt);   
		
	}

	@Then("User Search the Testname {int}")
	public void user_search_the_testname_and_click_on_go_icon(Integer rownumber4) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());	

		}

		String searchtestname = testData.get(rownumber4).get("TestName");
		CreateExams.Search_test_name(searchtestname);
	}

	@Then("^User select the Testtype dropdown$")
	public void user_select_the_testtype_dropdown() {
		CreateExams.Dropdowns();

	}

}

