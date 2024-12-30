package AssessmentsStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Assessments.pages.CommonPages;
import com.Assessments.pages.SISProvisioningPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SISProvisioningStepdefinitions extends ActionType{
	 
	SISProvisioningPage provisioning=new SISProvisioningPage(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	static List<Map<String, String>> testdata=null;

	@And("User Click on SIS provisining tab under Administration in Left menu")
	public void user_click_on_sis_provisining_tab_under_administration_in_left_menu() {
		provisioning.Administrationtab();
	}

	@Then("User Navigate to School tab")
	public void user_navigate_to_school_tab() {
		provisioning.Schooltab();
	}

	@And("User Click on the Add New School button")
	public void user_click_on_the_add_new_school_button() {
		provisioning.AddnewSchool();
	}

	@When("User Enter the Name and Description")
	public void user_enter_the_name_and_description() throws Exception {
		provisioning.SchoolDetails();
	}

	@And("User Select the Timezone from Dropdown {int}")
	public void user_select_the_timezone_from_dropdown(int TimeZone) throws Exception {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
		}
		String value=testdata.get(TimeZone).get("TimeZone");
		provisioning.TimezoneValue(value);
	}

	@Then("User Saved the School and Search for the Created School in Search here Field")
	public void user_saved_the_school_and_search_for_the_created_school_in_search_here_field() throws Exception {
	   cp.Save();
	   provisioning.SchoolSearch();
	}

	@And("User Navigate to Classroom tab")
	public void user_navigate_to_classroom_tab() {
	    provisioning.Classroomtab();
	}

	@Then("User Select the Created School in School dropdown")
	public void user_select_the_created_school_in_school_dropdown() {
	    provisioning.SchoolDropDownSearch();
	}

	@And("User Click on the Add New Classroom button")
	public void user_click_on_the_add_new_classroom_button() {
	    provisioning.AddNewClassroom();
	}

	@Then("User Enter the Classroom Name and Description")
	public void user_enter_the_classroom_name_and_description() throws Exception {
	    provisioning.ClassroomDetails();
	}

	@And("User Saved the Classroom and Search for the Created Classroom in Search here Field")
	public void user_saved_the_classroom_and_search_for_the_created_classroom_in_search_here_field() throws Exception {
		cp.Save();
		provisioning.ClassroomSearch();
	}

	@Then("User Navigate to Sections tab")
	public void user_navigate_to_sections_tab() {
	   provisioning.Sectiontab();
	}

	@And("User Select the Active Year from year Dropdown {int}")
	public void user_select_the_active_year_from_year_dropdown(int Year) throws Exception, IOException {
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
		}
		String value=testdata.get(Year).get("Year");
		provisioning.YearDropDownSearch(value);
	}

	@Then("User Click on the Add New Sections button")
	public void user_click_on_the_add_new_sections_button() {
	    provisioning.AddNewSection();
	}

	@And("User Enter the Section Name and Description")
	public void user_enter_the_section_name_and_description() throws Exception {
	    provisioning.SectionDetails();
	}

	@Then("User Saved the Section and Search for the Created Section in Search here Field")
	public void user_saved_the_section_and_search_for_the_created_section_in_search_here_field() throws Exception {
		StaticWait(1);
		cp.Save();
		StaticWait(1);
		provisioning.SectionSearch();
	}

	@When("User Navigate to District User tab")
	public void user_navigate_to_district_user_tab() {
	    provisioning.DistrictUserTab();
	}

	@And("User Click on Add New User button")
	public void user_click_on_add_new_user_button() {
	    provisioning.AddNewDistrictUser();
	}
	@Then("User Enters the District user Email, District user First name, District user Last name into the Respective Fields")
	public void user_enters_the_district_user_email_district_user_first_name_district_user_last_name_into_the_respective_fields() { 
		provisioning.DistrictUserDetails("DistrictUser");
	}
	@When("User Saved the District User and Search for the User in search here Field")
	public void user_saved_the_district_user_and_search_for_the_user_in_search_here_field() {
		cp.Save();
		provisioning.DUserSearch();
	}
	@And("user Click on Edit option for Logins Creations")
	public void user_click_on_edit_option_for_logins_creations() {
	    provisioning.EditScreen();
	}

	@Then("Click on Create New login button")
	public void click_on_create_new_login_button() {
	    provisioning.CreateNewLogin();
	}

	@And("User Reset the Password and save the user")
	public void user_reset_the_password_and_save_the_user() {
	    provisioning.ResetPwd();
	}

	@And("User Click on Settings option at User level Ellipses")
	public void user_click_on_settings_option_at_user_level_ellipses() {
	    provisioning.Settings();
	}

	@Then("User Check the Is District Admin Checkbox")
	public void user_check_the_is_district_admin_checkbox() {
	    provisioning.Checkbox();
	}

	@And("User Close the Settings Pop up")
	public void user_close_the_settings_pop_up() {
	    provisioning.close();
	}

	@When("User Navigate to Teachers tab")
	public void user_navigate_to_teachers_tab() {
		provisioning.TeacherTab();
	}

	@And("User Click on Add New Teacher button")
	public void user_click_on_add_new_teacher_button() {
		provisioning.SchoolDropDownSearch();
		provisioning.AddNewTeacher();
	}
	
	@Then("User Enters the Teacher Email, Teacher First name, Teacher Last name into the Respective Fields")
	public void user_enters_the_teacher_email_teacher_first_name_teacher_last_name_into_the_respective_fields() {
		provisioning.TeacherUserDetails("Teacher");;
	}
	
	@When("User Saved the Teacher and Search for the User in search here Field")
	public void user_saved_the_teacher_and_search_for_the_user_in_search_here_field() {
	    cp.Save();
	    provisioning.TUserSearch();
	}

	@Then("User Navigate to Classrooms tab in settings Pop up")
	public void user_navigate_to_classrooms_tab_in_settings_pop_up() {
		provisioning.SettingClassroom();
	}

	@And("User Select the Values in the Year {int}, Section, Classroom dropdown and Click on Add button")
	public void user_select_the_values_in_the_year_section_classroom_dropdown_and_click_on_add_button(int Year) throws InvalidFormatException, IOException {
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
		}
		String Yearvalue=testdata.get(Year).get("Year");
	    provisioning.YearDropDownSearch(Yearvalue);
	    provisioning.SectionDropDownSearch();
	    provisioning.ClassroomDropDownSearch();
	    provisioning.SettingsAdd();	    
	}

	@Then("User Navigate to Students tab")
	public void user_navigate_to_students_tab() {
	   provisioning.StudentTab();
	}

	@And("User Click on Add New Student button")
	public void user_click_on_add_new_student_button() {
		provisioning.SchoolDropDownSearch();
		provisioning.AddNewStudent();
	}

	@When("User Enters the Student Email, Student First name, Student Last name into the Respective Fields")
	public void user_enters_the_student_email_student_first_name_student_last_name_into_the_respective_fields() {
		provisioning.StudentUserDetails("Student");
	}

	@Then("User Saved the Student and Search for the User in search here Field")
	public void user_saved_the_student_and_search_for_the_user_in_search_here_field() {
	    cp.Save();
	    provisioning.SUserSearch();
	}

	@Then("User Select the Value from Classroom dropdown and Click on Add button")
	public void user_select_the_value_from_classroom_dropdown_and_click_on_add_button() {
	    provisioning.ClassroomDropDownSearch();
	    provisioning.SettingsAdd();
	}
	
	@Then("Store the data in Excel")
	public void store_the_data_in_excel() throws Exception {
		//provisioning.insertData();
//		System.out.println("Data inserted Sucessfully");
	}
	@Then("Store the users data in Excel")
	public void store_the_users_data_in_excel() throws Exception {
		provisioning.insertUsersData();
		System.out.println("Users Data inserted Sucessfully");
	}
}
