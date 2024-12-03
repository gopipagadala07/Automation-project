package AssessmentsStepdef;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.Utils.Base;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.Assessments.pages.AnnouncementsPages;
import com.Assessments.pages.BenchmarksPage;
import com.Assessments.pages.CommonPages;
import com.Assessments.pages.LaunchValidationPages;
import com.Assessments.pages.SISProvisioningPage;
import com.Assessments.pages.QuizSubmissionPages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaunchValidationStepdefinitions extends ActionType{


	LaunchValidationPages Launch=new LaunchValidationPages(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	static List<Map<String, String>> testdata=null;

	@Then("user clicks on Launch icon and validates")
	public void user_clicks_on_launch_icon_and_validates() {
		Launch.clickEachQuizAndClose();
		//Launch.clickEachExamAndClose();
		
	}
}
