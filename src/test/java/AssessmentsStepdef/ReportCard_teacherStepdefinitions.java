package AssessmentsStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Assessments.pages.ReportCard_teacherPage;
import com.Assessments.pages.CommonPages;
import com.Assessments.pages.SISProvisioningPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportCard_teacherStepdefinitions extends ActionType{

	ReportCard_teacherPage benchmarkTeacher=new ReportCard_teacherPage(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	static List<Map<String, String>> testdata=null;

	@Then("User Click on Assessment Centre tab under Learning in Left menu")
	public void user_click_on_assessment_centre_tab_under_learning_in_left_menu() {

		benchmarkTeacher.learning();

	}

	@Then("User click on the Assessment Centre Course {int}{int}")
	public void user_click_on_the_assessment_centre_course(Integer row,int row1) throws InvalidFormatException, IOException {

		if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	    }
	    String ClaroomName = testdata.get(row).get("Classroom Name");	
	    String SectionName = testdata.get(row).get("Section Name");
	    String TFirstname = testdata.get(row1).get("FirstName");
	    String TLastName = testdata.get(row1).get("LastName");
	    benchmarkTeacher.AssessmentCentre(ClaroomName, SectionName, TLastName, TFirstname);
    }





	@When("User navigate to Benchmark tab")
	public void user_navigate_to_benchmark_tab() {
		//benchmarkTeacher.benchmarktab();

	}

	@When("activate the toggle and compare the Student status")
	public void activate_the_toggle_and_compare_the_student_status() {
//		benchmarkTeacher.Activatetoggle();
//		benchmarkTeacher.CheckStdToggle();
		
	}

	@Then("capture the Benchmark band")
	public void capture_the_benchmark_band() {
		//benchmarkTeacher.bandstatus();


	}

	@Then("User navigates to Grade tab")
	public void user_navigates_to_grade_tab() {
		benchmarkTeacher.Grade();
		benchmarkTeacher.moveDownloadedFile("Grades.xlsx");

	}

	@Then("User select the Grades by activity and print")
	public void user_select_the_grades_by_activity_and_print() {
		//benchmarkTeacher.standard();

	}

	/*@When("User select the Grades by Standards and print")
	public void user_select_the_grades_by_standards_and_print() {
	    // Write code here that turns the phrase above into concrete actions

	}

	@Then("User stores the student score")
	public void user_stores_the_student_score() {
	    // Write code here that turns the phrase above into concrete actions

	}*/

	@Then("User compares the Benchmark Count from Home tab")
	public void user_compares_the_benchmark_count_from_home_tab() {
		//benchmarkTeacher.printCounts();

	}

	@When("User navigates back to Assessment landing page")
	public void user_navigates_back_to_assessment_landing_page() {
		benchmarkTeacher.landpage();

	}
}