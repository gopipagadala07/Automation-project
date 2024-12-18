package ExamCenterStepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Examcenter.pages.CommonPages;
import com.Examcenter.pages.Location_pom;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Location_Stepdefinition extends ActionType {
	
	static ExcelReader reader=new ExcelReader();
	static List<Map<String,String>> testData=null;
	
	Location_pom Location=new Location_pom(Base.getDriver());
	CommonPages cp=new CommonPages(Base.getDriver());
	

	@Then("User click on Administration tab in homepage")
	public void user_click_on_administration_tab_in_homepage() {
	   Location.Adminstrationbtn();
	}

	@Then("User click on Location tab")
	public void user_click_on_location_tab() {
		Location.Location_tab();
	}

	@And("User click on AddNew button under location tab")
	public void user_click_on_add_new_button_under_location_tab() {
	   Location.Addnew_location(); 
	}
	
	@Then("User enters the LocationName and Addressfield generated randomly")
	public void user_enters_the_location_name_and_addressfield_generated_randomly() throws Exception {
		Location.Location_Name();
		Location.Address_field();
	}
	
	@Then("User click on Locationsave button")
	public void user_click_on_locationsave_button() {
		 cp.Save();
	}
}
