package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Examcenter.Utils.ActionType;
import com.Examcenter.Utils.Base;
import com.Examcenter.Utils.ExcelReader;
import com.Examcenter.pages.Location_pom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class Location_Stepdefinition extends ActionType {
	
	static ExcelReader reader=new ExcelReader();

	static List<Map<String,String>> testData=null;
	private Location_pom Location=new Location_pom(Base.getDriver());
	
//	@Then("User click on Change Password Close Icon")
//	public void user_click_on_change_password_close_icon() {
//	    Location.Change_password_closeIcon();
//	}
	
	@And("User click on AddNew button under location tab")
	public void user_click_on_add_new_button_under_location_tab() {
	   Location.Addnew_location(); 
	}

	@Then("User click on Administration tab in homepage")
	public void user_click_on_administration_tab_in_homepage() {
	   Location.Adminstarationbtn();
	   StaticWait(1);
	}

	@Then("User click on editlocation Save button")
	public void user_click_on_editlocation_save_button() {
		  Location.Edit_Save_Location();
	}

	@And("User click on Location Edit button with reference Location name {int}")
	public void user_click_on_location_edit_button_with_reference_location_name(Integer int2) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/UsersCreationDetails.xlsx", getSheetEnv());	
		}
		String Locationname = testData.get(int2).get("Location");
		Location.Location_Edit_Icon(Locationname);
	}
	
	@Then("User click on Location tab")
	public void user_click_on_location_tab() {
		Location.Location_tab();
	}

	@Then("User click on Locationsave button")
	public void user_click_on_locationsave_button() {
		 Location.Location_Save();
	}

	@Then("User edited the Location name {int}")
	public void user_edited_the_location_name(Integer int3) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/UsersCreationDetails.xlsx", getSheetEnv());	
		}
		String editlocation = testData.get(int3).get("EditLocationName");
		Location.Edit_Location_name(editlocation);   
	}

	@Then("User enters the Address from the given excelsheet at {int}")
	public void user_enters_the_address_from_the_given_excelsheet_at(Integer int1) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/UsersCreationDetails.xlsx", getSheetEnv());	
		}
	
		String Addresstext = testData.get(int1).get("AddressField");
	
		Location.Address_field(Addresstext);
	}

	@Then("User enters the LocationName from the given excelsheet at {int}")
	public void user_enters_the_location_name_from_the_given_excelsheet_at(Integer int0) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/ExcelFiles/UsersCreationDetails.xlsx", getSheetEnv());	
		}
		String locationnametxtfield = testData.get(int0).get("Location");
		
		Location.Location_Name_field(locationnametxtfield);
		
	}
}
