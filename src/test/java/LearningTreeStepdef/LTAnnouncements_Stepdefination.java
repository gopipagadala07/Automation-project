package LearningTreeStepdef;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import com.LearningTree.pages.LTAnnouncements_pages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LTAnnouncements_Stepdefination extends ActionType {
	
	ExcelReader reader=new ExcelReader();
	static List<Map<String, String>> testdata=null;

	private LTAnnouncements_pages LTAnnouncements =new LTAnnouncements_pages(Base.getDriver());
	
	@And("User clicks on Announcements Tab in LT")
	public void user_clicks_on_announcements_tab_in_lt() {
	   LTAnnouncements.LTAnnouncementTab();
	}

	@And("User clicks on Add New Announcement button")
	public void user_clicks_on_add_new_announcement_button() {
	LTAnnouncements.AddNewAnnouncement_LT();
	}

	@Then("User checks Announcements search Functionality")
	public void user_checks_announcements_search_functionality() {
	   LTAnnouncements.Announcement_Search();
	}

	@Then("User checks the pagination")
	public void user_checks_the_pagination() throws AWTException {
	  LTAnnouncements.PagiNation();
	}

//	@Then("User clicks on the Hometab")
//	public void user_clicks_on_the_hometab() {
//	LTAnnouncements.ClickOnHomeTab();
//	}
//
//	@Then("User clicks on Addnew button and save button")
//	public void user_clicks_on_addnew_button_and_save_button() {
//	   LTAnnouncements.ClickOnAddAndSave();
//	}

	@And("User Click on Learningtree in Left menu")
	public void user_click_on_learningtree_in_left_menu() {
	  LTAnnouncements.click_on_LearningtreeTab();
	}

	@Then("User clicks on the Student Announcements from home tab")
	public void user_clicks_on_the_student_announcements_from_home_tab() throws AWTException {
	 LTAnnouncements.StudentAnnouncementFromHomeTab();
	}





}