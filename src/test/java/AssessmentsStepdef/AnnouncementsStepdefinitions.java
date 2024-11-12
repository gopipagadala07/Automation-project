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
import com.Assessments.pages.SISProvisioningPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AnnouncementsStepdefinitions extends ActionType{
	 
	private static final String String = null;
	AnnouncementsPages announce=new AnnouncementsPages(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	static List<Map<String, String>> testdata=null;
	

	@Then("user clicks on Learning and assessment center")
	public void user_clicks_on_learning_and_assessment_center() {
	    announce.ClickOnLearningaAndAssessmentCenter();
	}

	
	@Then("user clicks on the classroom name {int} {int}")
	public void user_clicks_on_the_classroom_name(int row,int row1) throws InvalidFormatException, IOException {
	//	announce.classroomClick();
//		if (testdata == null) {
//	        testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
//	    }
//	    String Classroom = testdata.get(row).get("Classroom Name");
//	    String section = testdata.get(row).get("Section Name");
//	    String lastname = testdata.get(row1).get("LastName");
//	    String Fname = testdata.get(row1).get("FirstName");
//		
//		announce.clickonCommunity(Classroom, section, lastname, Fname);
//	}
		if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	    }
	    String ClaroomName = testdata.get(row).get("Classroom Name");	
	    String SectionName = testdata.get(row).get("Section Name");
	    String TFirstname = testdata.get(row1).get("FirstName");
	    String TLastName = testdata.get(row1).get("LastName");
	    announce.communityClick(ClaroomName, SectionName, TLastName, TFirstname);
    }

	@And("user clicks on Announcements Tab")
	public void user_clicks_on_announcements_tab() {
	 announce.ClickOnAnnouncementTab();  
	}

	@And("user clicks on Add New Announcement button")
	public void user_clicks_on_add_new_announcement_button() {
		announce.ClickOnAddNewAnnouncement();
	}
	@Then("user checks Announcements search Functionality")
	public void user_checks_announcements_search_functionality() {
	    announce.AnnouncementsSearch();
	}

	
	@Then("user  checks the pagenation")
	public void user_checks_the_pagenation() throws AWTException {
	    announce.PageNation();
	}

	@Then("user clicks on the Hometab")
	public void user_clicks_on_the_hometab() {
	  announce.ClickOnHomeTab();
	}
	
	@Then("user clicks on Addnew button and save button")
	public void user_clicks_on_Addnew_button_and_save_button() {
	  announce.ClickOnAddAndSave();
	}

	
	/*
	 * Student Side Verification
	 */
	@Then("user clicks on the Announcement from home tab")
	public void user_clicks_on_the_announcement_from_home_tab() throws AWTException {
	   announce.ClickOnAnnouncementFromHomeTab();
	}

	
	
}
