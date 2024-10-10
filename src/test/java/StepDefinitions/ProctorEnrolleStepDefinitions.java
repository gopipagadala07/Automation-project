package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Examcenter.Utils.ActionType;
import com.Examcenter.Utils.Base;
import com.Examcenter.Utils.ExcelReader;
import com.Examcenter.pages.ProctorEnrollePage;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProctorEnrolleStepDefinitions extends ActionType{

	ProctorEnrollePage pe=new ProctorEnrollePage(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	ActionType a=new ActionType();
	List<Map<String, String>> testdata=null;

	@And("user click on Enrolle tab")
	public void user_click_on_enrolle_tab() {
		pe.EnrolleTab();
	}

	@Then("User click on Examinations lookups")
	public void user_click_on_examinations_lookups() {
		pe.ExaminationsDropdown();
	}

	@And("user select the Examination from Examination lookup{int}")
	public void user_select_the_examination_from_examination_lookup(int rownumber) throws InvalidFormatException, IOException {
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());
		}
		String Examname=testdata.get(rownumber).get("ExamName");
		String Schedulename=testdata.get(rownumber).get("ScheduleName");
		pe.ExaminationsSelect(Examname, Schedulename);
	}

	@Then("search for Examtaker{int}")
	public void serachExamtakername(int rownumber) throws InvalidFormatException, IOException
	{
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/UsersCreationDetails.xlsx", getSheetEnv());
		}
		String LastName=testdata.get(rownumber).get("LastName");
		String FirstName=testdata.get(rownumber).get("FirstName");
		pe.examtakerSearch(FirstName, LastName);
	}
	@Then("user click on Test Analytics icon{int}")
	public void user_click_on_test_analytics_icon(int rownumber) throws InvalidFormatException, IOException {
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());
		}
		String Examname=testdata.get(rownumber).get("ExamName");
		String Schedulename=testdata.get(rownumber).get("ScheduleName");
		pe.TestAnalytics(Examname, Schedulename);
	}

	@And("finally print the Examtaker Name in that pop up")
	public void finally_print_the_examtaker_name_in_that_pop_up() throws Exception {
		pe.printExamtakerName();
		StaticWait(3);
		pe.Capturescreenshot();
	}
}
