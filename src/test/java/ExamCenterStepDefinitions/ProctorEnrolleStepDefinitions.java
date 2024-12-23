package ExamCenterStepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Examcenter.pages.CommonPages;
import com.Examcenter.pages.ProctorEnrollePage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProctorEnrolleStepDefinitions extends ActionType{

	ProctorEnrollePage pe=new ProctorEnrollePage(Base.getDriver());
	CommonPages cp=new CommonPages(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	ActionType a=new ActionType();
	List<Map<String, String>> testdata=null;

	@And("user click on Enrolle tab")
	public void user_click_on_enrolle_tab() {
		pe.EnrolleTab();
	}
	@When("User Select the ExamSchedule {int}")
	public void User_Select_the_ExamSchdeule(int rownumber) throws InvalidFormatException, IOException
	{
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
		}
		String Examname=testdata.get(rownumber).get("ExamName");
		String Schedulename=testdata.get(rownumber).get("ScheduleName");
        pe.select_the_Examination(Examname, Schedulename);
	}
	
	@Then("search for Examtaker{int}")
	public void serachExamtakername(int rownumber) throws InvalidFormatException, IOException
	{
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
		}
		String LastName=testdata.get(rownumber).get("LastName");
		String FirstName=testdata.get(rownumber).get("FirstName");
		cp.searchField(LastName+" "+FirstName);

	}
	@Then("user click on Test Analytics icon{int}")
	public void user_click_on_test_analytics_icon(int rownumber) throws InvalidFormatException, IOException {
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
		}
		String Examname=testdata.get(rownumber).get("ExamName");
		String Schedulename=testdata.get(rownumber).get("ScheduleName");
		pe.TestAnalytics(Examname, Schedulename);
	}

	@And("finally print the Examtaker Name in that pop up {int}")
	public void finally_print_the_examtaker_name_in_that_pop_up(int rownumber) throws Exception {
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
		}
		String LastName=testdata.get(rownumber).get("LastName");
		String FirstName=testdata.get(rownumber).get("FirstName");
		pe.printExamtakerName(LastName+" "+FirstName);
        pe.attachDownloadedFileToReport();
	}
}
