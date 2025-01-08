package AssessmentsStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.Utils.Base;
import com.Utils.CommonPages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;

import com.Assessments.pages.BenchmarksPage;
import com.Assessments.pages.SISProvisioningPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BenchmarkStepdefinitions extends ActionType{
	 
	BenchmarksPage bpages=new BenchmarksPage(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	static List<Map<String, String>> testdata=null;
	


	@When("the user clicks on the Districts")
	public void the_user_clicks_on_the_districts() {
	   bpages.Disttab();
	   
	}
	@And("user navigates to Benchmarks tab")
	public void user_navigates_to_Benchmarks_tab() {
		bpages.benchmarkstab();
	}

	@And("the user selects the Year from the dropdown at row {int}")
	public void the_user_selects_the_year_from_the_dropdown_at_row(Integer int1) throws Exception, IOException {
	    if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
	    }  
		String Year = testdata.get(int1).get("Year");	   
	    bpages.yeardropdowns(Year) ;   
	}


	@And("the user selects the Grade from the dropdown at row {int}")
	public void the_user_selects_the_grade_from_the_dropdown_at_row(Integer int1) throws Exception, IOException {
	    
	    if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
	    }
	    String grade = testdata.get(int1).get("Grade");	   
	    bpages.gradedropdowns(grade); 
	
	}

	@And("the user selects the Subject from the dropdown at row {int}")
	public void the_user_selects_the_subject_from_the_dropdown_at_row(Integer int1) throws Exception, IOException {
		
		if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
	    }
	    String subject = testdata.get(int1).get("Subject");	   
	    bpages.subdropdowns(subject);
	}
	@Then("the user clicks on the Add New Benchmark button")
	public void the_user_clicks_on_the_add_new_benchmark_button() {
	    bpages.AddBenchmark();
	}
	
	@And("the user enters the benchmark name and description generated randomly")
	public void the_user_enters_the_benchmark_name_and_description_generated_randomly() {
	   bpages.BenchmarkName();
	}

	@And("the user selects all the checkboxes")
	public void the_user_selects_all_the_checkboxes() {
	    bpages.checkboxes();
	   
	}

	@Then("the user clicks on the Save button")
	public void the_user_clicks_on_the_save_button() {
		cp.Save();
	}

	@And("the user clicks on the Find Test button")
	public void the_user_clicks_on_the_find_test_button() {
	    bpages.findtest();
	}

	@Then("the user clicks on the Search Here field and enters the test name from row {int}")
	public void the_user_clicks_on_the_search_here_field_and_enters_the_test_name_from_row(int Testname) throws InvalidFormatException, IOException {
		if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
	    }
	    String Tname = testdata.get(Testname).get("TestName");	   
		bpages.testSearch(Tname);
	
	}

	@And("the user clicks on the Add icon button")
	public void the_user_clicks_on_the_add_icon_button() {
	    bpages.addicon();
	}

	@Then("the user clicks on the Publish button")
	public void the_user_clicks_on_the_publish_button() {
		
		bpages.publishBtn();
	}

	@And("a confirmation popup appears, and the user clicks on the Yes button")
	public void a_confirmation_popup_appears_and_the_user_clicks_on_the_yes_button() {
	    bpages.yesbutton();
	}

	@And("the user clicks on the created benchmark and navigates to the Sections tab")
	public void the_user_clicks_on_the_created_benchmark_and_navigates_to_the_sections_tab() throws InterruptedException {
	    bpages.clickOnNewBencmark();
	    bpages.clickOnSectionTab();
	}

	@Then("the user clicks on the Search Here field and enters the section name from row and clicks on the Add {int}")
	public void the_user_clicks_on_the_search_here_field_and_enters_the_section_name_from_row(int SectionName) throws Exception, IOException {
		if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
	    }
	    String secname = testdata.get(SectionName).get("Section Name");	
	    bpages.SectionSearch(secname);
	
	}
	
	/*
	 * Test Administration
	 */
	
	@When("user clicks on Testadministration tab")
	public void user_clicks_on_Testadministration_tab() {
	    bpages.testAdminTab();
	}

	@And("the user selects the course benchmark from the dropdown at row {int}")
	public void the_user_selects_the_course_benchmark_from_the_dropdown_at_row_rownumber(int SectionName1) throws Exception, IOException {
		if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
	    }
	    String CourseBmark = testdata.get(SectionName1).get("Section Name");	   	   
		    bpages.CourseBenchmarkDdown(CourseBmark);
	}

	@And("the user selects the school from the dropdown at row {int}")
	public void the_user_selects_the_school_from_the_dropdown_at_row_rownumber(int int1) throws InvalidFormatException, IOException {
//		if (testdata == null) {
//	        testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
//	    }
//	    String schoolDdown = testdata.get(int1).get("SchoolName");	   
//	    bpages.schoolDdown(schoolDdown); 
		StaticWait(1);
	}

	@And("the user selects the teacher from the dropdown at row {int}")
	public void the_user_selects_the_teacher_from_the_dropdown_at_row_rownumber(Integer int1) throws InvalidFormatException, IOException {
//		if (testdata == null) {
//	        testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
//	    }
//	    String Lastname = testdata.get(int1).get("LastName");	
//	    String firstname = testdata.get(int1).get("FirstName");	
//	    bpages.teacherDdown(Lastname,firstname); 
		StaticWait(1);
	}

	@And("the user selects the classroom from the dropdown at row {int}")
	public void the_user_selects_the_classroom_from_the_dropdown_at_row_rownumber(Integer int1) throws InvalidFormatException, IOException {
//		if (testdata == null) {
//	        testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
//	    }
//	    String classroomDdown = testdata.get(int1).get("Classroom Name");	   
//	    bpages.classroomDdown(classroomDdown); 
		StaticWait(1);
	}
	

	@When("user clicks on toggle to activate benchmark")
	public void user_clicks_on_toggle_to_activate_benchmark() {
		StaticWait(1);
		bpages.ActiveToggle();
	}
	@Then("user checks the status and Reset the Benchmark Activity")
	public void user_checks_the_status_and_reset_the_benchmark_activity() {
	   bpages.CheckingStatus();
	   
	}

	
	
}
