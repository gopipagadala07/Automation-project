package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Fp_Examcenter.Utils.ActionType;
import com.Fp_Examcenter.Utils.Base;
import com.Fp_Examcenter.Utils.ExcelReader;

import com.Fp_Examcenter.pom_pages.EC_Loginpage;
import com.Fp_Examcenter.pom_pages.Location_pom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Location_Stepdefinition extends ActionType {
	
	private EC_Loginpage EClogin=new EC_Loginpage(Base.getDriver());
	private Location_pom Location=new Location_pom(Base.getDriver());

	static ExcelReader reader=new ExcelReader();
	static List<Map<String,String>> testData=null;
	
	@Given("User launches application with URL")
	public void user_launches_application_with_url() {
		getURL(getProperty("url"));
	}

	@When("User enters the valid credential from the given excelsheet {int}")
	public void user_enters_the_valid_credential_from_the_given_excelsheet(Integer int1) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/Excelfiles/ProdData.xlsx", getSheetEnv());
		}
		String username = testData.get(int1).get("username");
		String password = testData.get(int1).get("password");
		EClogin.login(username, password);
	}
	@Then("User click on Change Password Close Icon")
	public void user_click_on_change_password_close_icon() {
	    Location.Change_password_closeIcon();
	}

	@And("User click on Exam Administration tab in homepage")
	public void user_click_on_exam_administration_tab_in_homepage() {
	   
		Location.Exam_Administration();
	}

	@Then("User click on Location tab")
	public void user_click_on_location_tab() {
	
	   Location.Location_tab();
	}

	@And("User click on AddNew button under location tab")
	public void user_click_on_add_new_button_under_location_tab() {
	   Location.Addnew_location(); 
	}

	@Then("User enters the LocationName from the given excelsheet at {int}")
	public void user_enters_the_location_name_from_the_given_excelsheet_at(Integer int2) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/Excelfiles/Examinations.xlsx", getSheetEnv());	
		}
		String locationnametxtfield = testData.get(int2).get("LocationName");
		
		Location.Location_Name_field(locationnametxtfield);
		
	}
	
	

	@Then("User enters the Address from the given excelsheet at {int}")
	public void user_enters_the_address_from_the_given_excelsheet_at(Integer int0) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/Excelfiles/Examinations.xlsx", getSheetEnv());	
		}
	
		String Addresstext = testData.get(int0).get("AddressField");
	
		Location.Address_field(Addresstext);
	}

	@Then("User click on Locationsave button")
	public void user_click_on_locationsave_button() {
		 Location.Location_Save();
		   System.out.println("Location Saved Successfully");
	}

	@And("User click on Location Edit button with reference Location name {int}")
	public void user_click_on_location_edit_button_with_reference_location_name(Integer int3) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/Excelfiles/Examinations.xlsx", getSheetEnv());	
		}
		String Locationname = testData.get(int3).get("LocationName");
		Location.Location_Edit_Icon(Locationname);
	}

	@Then("User edited the Location name {int}")
	public void user_edited_the_location_name(Integer int4) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testData=null;
		if(testData == null) {
			testData = 
					reader.getData("/Excelfiles/Examinations.xlsx", getSheetEnv());	
		}
		String editlocation = testData.get(int4).get("EditLocationName");
		Location.Edit_Location_name(editlocation);   
	}

	@Then("User click on editlocation Save button")
	public void user_click_on_editlocation_save_button() {
		  Location.Edit_Save_Location();
	}
}
