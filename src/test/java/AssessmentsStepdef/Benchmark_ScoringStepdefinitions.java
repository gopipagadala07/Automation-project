package AssessmentsStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Assessments.pages.Benchmark_Scoring;
import com.Assessments.pages.Teacher_Activityprogress;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Benchmark_ScoringStepdefinitions extends ActionType{

	Benchmark_Scoring scoring=new Benchmark_Scoring(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	static List<Map<String, String>> testdata=null;

	@Then("Users Click on Assessment Centre tab in Left menu")
	public void user_click_on_assessment_centre_tab_under_learning_in_left_menu() {

		scoring.learning();

	}

	@Then("Users clicks on Assessment Centre Course {int}{int}")
	public void user_click_on_the_assessment_centre_course(Integer row,int row1) throws InvalidFormatException, IOException {

		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
		}
		String ClaroomName = testdata.get(row).get("Classroom Name");	
		String SectionName = testdata.get(row).get("Section Name");
		String TFirstname = testdata.get(row1).get("FirstName");
		String TLastName = testdata.get(row1).get("LastName");
		scoring.AssessmentCentre(ClaroomName, SectionName, TLastName, TFirstname);
	}




	@When("User clicks on Benchmarks Tab")
	public void user_clicks_on_benchmarks_tab() {
		scoring.benchmarktab();
	}

	@Then("User navigates to Student Activity Progress")
	public void user_navigates_to_student_activity_progress() {
		scoring.Activityprogress();
	}

	@Then("User navigate and give score to the Benchmark")
	public void user_navigate_and_give_score_to_the_benchmark() {
		scoring.Scoringscreen();
	}

	@When("User sumbit the Benchmark scoring and navigate back")
	public void user_sumbit_the_benchmark_scoring_and_navigate_back() {
		scoring.Submitscore();
	}

	@Then("User capture the Band Status of the Student")
	public void user_capture_the_band_status_of_the_student() {
		scoring.bandstatus();
	}}