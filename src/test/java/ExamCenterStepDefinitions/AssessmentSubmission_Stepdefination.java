package ExamCenterStepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.Examcenter.pages.ExamtakerSubmissionPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AssessmentSubmission_Stepdefination extends ActionType{

	static ExcelReader reader=new ExcelReader();
	static List<Map<String, String>> testdata=null;
	private ExamtakerSubmissionPage Sub=new ExamtakerSubmissionPage(Base.getDriver());

	@And("Clicks on Launch button")
	public void clicks_on_launch_button() {
	    Sub.launchbtn();
	}

//	@Then("Enter the valid Invigilatory Token {int}")
//	public void enter_the_valid_invigilatory_token(Integer rownumber) throws InvalidFormatException, IOException {
//		testdata=null;
//		if(testdata==null)
//		{
//			testdata=reader.getData("/ExcelFiles/Examinations.xlsx", getSheetEnv());
//		}
//		String token=testdata.get(rownumber).get("Token");
//	    //Sub.tokentxt(token);
//	    //Sub.validatebtn();
//	}

	@Then("Logout from the Application")
	public void Logout_from_the_Application()
	{
		Sub.logout();
	}

	@Then("Search for particular exam and Click on it {int}")
	public void search_for_particular_exam_and_click_on_it(Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
		}
		String examname=testdata.get(rownumber).get("ExamName");
		String schedulename=testdata.get(rownumber).get("ScheduleName");
		Sub.searchheretxt(examname, schedulename);
	}

    @Then("Perform and Submit the Test")
	public void select_all_answers() throws InvalidFormatException, IOException {
		Sub.Answers();
	}
	@Then("capture the status band")
	public void Then_capture_the_status_band()
	{
		Sub.statusband();
	}
}
