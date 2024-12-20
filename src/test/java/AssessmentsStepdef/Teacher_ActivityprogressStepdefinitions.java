package AssessmentsStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Assessments.pages.CommonPages;
import com.Assessments.pages.Teacher_Activityprogress;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Teacher_ActivityprogressStepdefinitions extends ActionType{

	Teacher_Activityprogress activityprogress=new Teacher_Activityprogress(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	static List<Map<String, String>> testdata=null;

	@Then("Users Click on Assessment Centre tab under Learning in Left menu")
	public void user_click_on_assessment_centre_tab_under_learning_in_left_menu() {
		activityprogress.learning();
	}

	@Then("Users clicks on the Assessment Centre Course {int}{int}")
	public void user_click_on_the_assessment_centre_course(Integer row,int row1) throws InvalidFormatException, IOException {

		if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
	    }
	    String ClaroomName = testdata.get(row).get("Classroom Name");	
	    String SectionName = testdata.get(row).get("Section Name");
	    String TFirstname = testdata.get(row1).get("FirstName");
	    String TLastName = testdata.get(row1).get("LastName");
	    activityprogress.AssessmentCentre(ClaroomName, SectionName, TLastName, TFirstname);
    }

	@When("User click on all Quizzes and navigate back")
	public void user_click_on_all_quizzes_and_navigate_back() {
	   activityprogress.clickEachQuizAndClose();
	   //activityprogress.examtab();
	}

	@Then("User click on all benchmarks and navigate back")
	public void user_click_on_all_benchmarks_and_navigate_back() {
	    activityprogress.clickEachExamAndClose();
	}

}