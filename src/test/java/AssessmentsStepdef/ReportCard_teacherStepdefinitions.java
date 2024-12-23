package AssessmentsStepdef;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Assessments.pages.ReportCard_teacherPage;
import com.Assessments.pages.CommonPages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportCard_teacherStepdefinitions extends ActionType {

    ReportCard_teacherPage benchmarkTeacher = new ReportCard_teacherPage(Base.getDriver());
    ExcelReader reader = new ExcelReader();
    CommonPages cp = new CommonPages(Base.getDriver());
    static List<Map<String, String>> testdata = null;
    private ExtentTest extentTest;
    @Then("User Click on Assessment Centre tab under Learning in Left menu")
    public void user_click_on_assessment_centre_tab_under_learning_in_left_menu() {
        benchmarkTeacher.learning();
    }

    @Then("User click on the Assessment Centre Course {int}{int}")
    public void user_click_on_the_assessment_centre_course(Integer row, int row1) throws InvalidFormatException, IOException {
        if (testdata == null) {
            testdata = reader.getData("/ExcelFiles/AssessmentCenterDetails.xlsx", getSheetEnv());
        }
        String ClaroomName = testdata.get(row).get("Classroom Name");
        String SectionName = testdata.get(row).get("Section Name");
        String TFirstname = testdata.get(row1).get("FirstName");
        String TLastName = testdata.get(row1).get("LastName");
        benchmarkTeacher.AssessmentCentre(ClaroomName, SectionName, TLastName, TFirstname);
    }

    @When("User navigates to Grade tab")
    public void user_navigates_to_grade_tab() {
        benchmarkTeacher.Grade();
        benchmarkTeacher.attachDownloadedFileToReport();
    }

    @Then("User compares the Benchmark Count from Home tab")
    public void user_compares_the_benchmark_count_from_home_tab() {
        // benchmarkTeacher.printCounts();
    }

    @When("User navigates back to Assessment landing page")
    public void user_navigates_back_to_assessment_landing_page() {
        benchmarkTeacher.landpage();
    }
}
