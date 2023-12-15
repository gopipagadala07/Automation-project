package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Com.Examcenter.Utils.ActionType;
import Com.Examcenter.Utils.Base;
import Com.Examcenter.Utils.ExcelReader;
import Com.Examcenter.pages.ExamtakerSubmissionPage;
import Com.Examcenter.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AssessmentSubmission extends ActionType{

	ExamtakerSubmissionPage Sub=new ExamtakerSubmissionPage(Base.getDriver());
	LoginPage login=new LoginPage(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	List<Map<String, String>> testdata=null;
	
	@Given("Launch the URL for Examtaker")
	public void launch_the_url_for_examtaker() {
	    getURL(getProperty("url"));
	}

	@And("Login with Examtaker credentials from excel sheet {int}")
	public void login_with_examtaker_credentials_from_excel_sheet(Integer int1) throws InvalidFormatException, IOException {
	    if(testdata==null)
	    {
	    	testdata=reader.getData("/Excel/ProdCredentials.xlsx", getSheetEnv());
	        String username=testdata.get(int1).get("username");
	        String password=testdata.get(int1).get("password");
	        login.User_login(username, password);	        
	    }
	}

	@Then("Search for particular exam and Click on it {int}")
	public void search_for_particular_exam_and_click_on_it(Integer rownumber) throws InvalidFormatException, IOException {
		Sub.examinationbtn();
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/Excel/ProdCredentials.xlsx", getSheetEnv());
		}
		String examname=testdata.get(rownumber).get("ExamName");
		String schedulename=testdata.get(rownumber).get("ScheduleName");
		Sub.searchheretxt(examname, schedulename);
	}

	@And("Clicks on Launch button")
	public void clicks_on_launch_button() {
	    Sub.launchbtn();
	}

	@Then("Enter the valid Invigilatory Token {int}")
	public void enter_the_valid_invigilatory_token(Integer rownumber) throws InvalidFormatException, IOException {
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/Excel/ProdCredentials.xlsx", getSheetEnv());
		}
		String token=testdata.get(rownumber).get("Token");
	    Sub.tokentxt(token);
	    Sub.validatebtn();
	}

	@And("clicks on begin test")
	public void clicks_on_begin_test() {
		Sub.begintest();
	}

	@Then("Select all Answers")
	public void select_all_answers() {
	    
		Sub.Answers();
	}

	@And("submit the Exam")
	public void submit_the_exam() {
	    
	Sub.Finish();
	Sub.close();
	}
	@Then("capture the status band")
	public void Then_capture_the_status_band()
	{
		Sub.statusband();
		StaticWait(2);
	}
	@Then("Logout from the Application")
	public void Logout_from_the_Application()
	{
		Sub.logout();
	}
}
