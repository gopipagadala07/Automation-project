package ExamCenterStepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Examcenter.pages.CommonPages;
import com.Examcenter.pages.Exam_ScheduleCreationPages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Exam_ScheduleCreationStepdefinations extends ActionType{
	
	ExcelReader reader=new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	static List<Map<String, String>> testdata=null;
	Exam_ScheduleCreationPages ESpages=new Exam_ScheduleCreationPages(Base.getDriver());

	@Then("User click on ExamAdministration tab")
	public void user_click_on_exam_administration_tab() {
	     ESpages.Exam_Administration();
	}

	@And("^User click on AddExam button under Examination tab$")
	public void user_click_on_add_exam_button_under_examination_tab() {
		ESpages.Add_Exam();
	}
	
	@Then("User enters the Examname and Description for the Respective Fields")
	public void user_enters_the_examname_and_description_for_the_Respective_Fields() throws Exception{	
		ESpages.Exam_name_field();
		ESpages.Exam_Description();
	}

	@Then("^User click on save button$")
	public void user_click_on_save_button() {
		cp.Save();
		System.out.println("Exam Saved Successfully");
	}

	@And("User Search the Examination in Search here field")
	public void user_search_the_examination_in_search_here_field(){
		ESpages.Examsearch();
	}

	@Then("^User click on Add New schedule button$")
	public void user_click_on_add_new_schedule_button() {
		ESpages.Add_new_Schedule();
	}

	@And("^Click on Search Test button in Add-Edit schedule popup$")
	public void click_on_search_test_button_in_add_edit_schedule_popup(){
		ESpages.clickonsearchTest();
		
	}

	@Then("User Search the Testname {int}")
	public void user_search_the_testname_and_click_on_go_icon(Integer rowno) throws InvalidFormatException, IOException {
		testdata=null;
		if(testdata == null) {
			testdata = reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());	
		}
		String testName=testdata.get(rowno).get("TestName");
		ESpages.Search_Test_button(testName);
	}

	@Then("User click on Go icon and click on Add icon for that searched test {int}")
	public void user_click_on_go_icon_and_click_on_add_icon_for_that_searched_test(Integer rowno) throws InvalidFormatException, IOException {
		testdata=null;
		if(testdata == null) {
			testdata = reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());	
		}
		String testName=testdata.get(rowno).get("TestName");
		ESpages.icons_Action(testName);
	}

	@And("User enter the Schedule name")
	public void user_enter_the_schedule_name_with() throws Exception {
		ESpages.Enter_Schedule_name();
	}

	@Then("^User select the Testtype dropdown$")
	public void user_select_the_testtype_dropdown() {
		ESpages.Dropdowns();

	}

	@And("^User enable the all toggles$")
	public void user_enable_the_all_toggles() {
		ESpages.All_toggles();
	}

	@And("User choose the date month year from datepicker icon")
	public void user_choose_the_date_month_year_from_datepicker_icon() {
		ESpages.click_on_datepicker();
	}

	@Then("User enters the text in the Ckeditor fields")
	public void user_enters_the_text_in_the_ckeditor_fields(){	
		ESpages.Ck_editor_texts();	 
	}

	@Then("^User click on Schedule Save button$")
	public void user_click_on_schedule_save_button() {
		cp.Save();
		System.out.println("Schedule Saved Successfully");

	}

	@Then("Enabled the published and Exam live toggles with schedulename")
	public void enabled_the_published_and_exam_live_toggles_with_schedulename() {
		
		ESpages.published_Examlive_toggle();
	}
	@Then("User click on Administration tab")
	public void user_click_on_administration_tab() {
	   ESpages.Adminstarationbtn();
	}

	@Then("Click on Provisioning tab")
	public void click_on_provisioning_tab() {
	  ESpages.provisioning();
	}

	@And("User Search the Examtaker in Search here field {int}")
	public void user_search_the_examtaker_in_search_here_field(Integer rowno) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testdata=null;
		if(testdata == null) {
			testdata = 
					reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());	

		}
		String Firstnametxt=testdata.get(rowno).get("FirstName");
		String Lastnametxt=testdata.get(rowno).get("LastName");
		ESpages.Examtaker_search(Lastnametxt,Firstnametxt);   
	}

	@Then("User click on the searched Examtaker {int}")
	public void user_click_on_the_searched_examtaker(Integer rowno) throws InvalidFormatException, IOException {
		testdata=null;
		if(testdata == null) {
			testdata = 
					reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());	

		}
		String Firstnametxt=testdata.get(rowno).get("FirstName");
		String Lastnametxt=testdata.get(rowno).get("LastName");	  
		ESpages.click_on_searched_examtaker(Lastnametxt,Firstnametxt);
	}

	@Then("^User click on Enroll to an Exam button$")
	public void user_click_on_enroll_to_an_exam_button() {
		ESpages.Enroll_To_An_Exam();
	}

	@And("Select one Examinations name from Examinations lookups")
	public void select_one_examinations_name_from_Examinations_lookups(){
		ESpages.select_examinations_lookup();
	}

	@Then("Select one Schedule name from an selected Examinations")
	public void choose_one_schedule_name_from_an_selected_examinations(){
	  
		ESpages.select_schedule_lookup();
	}

	@And("^User click on Enrollment Save button$")
	public void user_click_on_enrollment_save_button() {
		cp.Save();
		ExtentCucumberAdapter.addTestStepLog("Exam Enrolled Successfully");
	}
}
