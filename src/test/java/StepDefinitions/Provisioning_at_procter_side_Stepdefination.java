package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Examcenter.pages.Provisioning_at_Procter_side_page;
import com.Examcenter.Utils.ActionType;
import com.Examcenter.Utils.Base;
import com.Examcenter.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Provisioning_at_procter_side_Stepdefination extends ActionType{

	private Provisioning_at_Procter_side_page Users=new Provisioning_at_Procter_side_page(Base.getDriver());
	static ExcelReader reader=new ExcelReader();
	static List<Map<String,String>> testdata=null;
	
	@And("Proctor clicks on Administration tab")
	public void user_clicks_on_administration_tab() {

		Users.Adminstarationbtn();
	}

//	@Then("User clicks on Controller tab")
//	public void user_clicks_on_controller_tab() {
//		Users.Controllerbtn();
//	}

//	@And("User clicks on Add new button on Controller tab")
//	public void user_clicks_on_add_new_button() {
//		Users.Addnewbtn();
//	}

//	@When("User Enter the valid Controller details from the given Excel sheet at {int}")
//	public void user_enter_the_valid_user_details_from_the_given_excel_sheet_at(Integer rownumber1) throws InvalidFormatException, IOException {
//		waitForPageLoad();
//		testdata=null;
//		if(testdata == null)
//		{
//			testdata=reader.getData("/Excel/UsersCreationDetails.xlsx", getSheetEnv());
//		}
//		String Emailtxt=testdata.get(rownumber1).get("Email");
//		String Firstnametxt=testdata.get(rownumber1).get("FirstName");
//		String Lastnametxt=testdata.get(rownumber1).get("LastName");
//		String Idtxt=testdata.get(rownumber1).get("ID");
//		Users.Create_Controller_User(Emailtxt, Firstnametxt, Lastnametxt, Idtxt);
//
//	}

//	@Then("User clicks on Save button for controller")
//	public void user_clicks_on_save_button() {
//		Users.savebtn();
//	}

//	@And("User Enter the Controller Details from the given Excel sheet at {int} in search Textbox")
//	public void user_enter_the_details_from_the_given_excel_sheet_at_in_search_textbox(Integer rownumber2) throws InvalidFormatException, IOException {
//		waitForPageLoad();
//		testdata=null;
//		if(testdata == null)
//		{
//			testdata=reader.getData("/Excel/UsersCreationDetails.xlsx", getSheetEnv());
//		}
//		String Firstnametxt=testdata.get(rownumber2).get("FirstName");
//		String Lastnametxt=testdata.get(rownumber2).get("LastName");
//		//System.out.println(Firstnametxt);
//		Users.searchtxt(Firstnametxt, Lastnametxt);
//	}
//
//	@Then("User clicks on Edit button on Controller tab")
//	public void user_clicks_on_edit_button() {
//		waitForPageLoad();
//		Users.Editbtn();
//	}
//
//	@And("^user clicks on Create new Login button on Add/edit controller pop up$")
//	public void user_clicks_create_new_login_button() {
//		Users.createloginbtn();
//	}
//
//	@And("^user clicks on Reset password button on Add/edit controller pop up$")
//	public void user_clicks_on_reset_password_button() {
//		StaticWait(3);
//		Users.resetbtn();
//		Users.reset();
//		Users.Yes();
//	}
//
//	@Then("^User clicks on Editsave button on Add/edit controller pop up$")
//	public void user_clicks_on_editsave_button() {
//		Users.editsavebtn();
//	}
//	
//	@Given("User is on Proctor tab")
//	public void user_is_on_proctor_tab() {
//		StaticWait(1);
//		Users.provisioning();
//		StaticWait(1);
//		Users.Proctorbtn();
//	}
//
//	@Given("User clicks on Add new button on Proctor tab")
//	public void user_clicks_on_add_new_button_on_proctor_tab() {
//		Users.Addnewbtn();
//	}
//
//	@When("User Enter the valid Proctor details from the given Excel sheet at {int} and save it")
//	public void user_enter_the_valid_proctor_details_from_the_given_excel_sheet_at_row_number2_and_save_it(int rownumber2) throws InvalidFormatException, IOException {
//		waitForPageLoad();
//		testdata=null;
//		if(testdata == null)
//		{
//			testdata=reader.getData("/Excel/UsersCreationDetails.xlsx", getSheetEnv());
//		}
//		String Emailtxt=testdata.get(rownumber2).get("Email");
//		String Firstnametxt=testdata.get(rownumber2).get("FirstName");
//		String Lastnametxt=testdata.get(rownumber2).get("LastName");
//		String Idtxt=testdata.get(rownumber2).get("ID");
//		String location=testdata.get(rownumber2).get("Location");
//		Users.Create_proctor_User(Emailtxt, Firstnametxt, Lastnametxt, Idtxt,location);
//		Users.proctor();
//		StaticWait(1);
//		Users.savebtn();
//	}
//
//	@Then("User Enter the Proctor Details from the given Excel sheet at {int} in search Textbox")
//	public void user_enter_the_proctor_details_from_the_given_excel_sheet_at_row_number2_in_search_textbox(int rownumber3) throws InvalidFormatException, IOException {
//		waitForPageLoad();
//		testdata=null;
//		if(testdata == null)
//		{
//			testdata=reader.getData("/Excel/UsersCreationDetails.xlsx", getSheetEnv());
//		}
//		String Firstnametxt=testdata.get(rownumber3).get("FirstName");
//		String Lastnametxt=testdata.get(rownumber3).get("LastName");
//		Users.searchtxt(Firstnametxt, Lastnametxt);
//	}
//
//	@And("User clicks on Edit button on Proctor tab")
//	public void user_clicks_on_edit_button_on_proctor_tab() {
//	    Users.Editbtn();
//	}
//
//	@And("^user clicks on Create new Login button on Add/edit proctor pop up$")
//	public void user_clicks_on_create_new_login_button_on_add_edit_proctor_pop_up() {
//		Users.createloginbtn();
//	}
//
//	@And("^user clicks on Reset password button on Add/edit proctor pop up$")
//	public void user_clicks_on_reset_password_button_on_add_edit_proctor_pop_up() {
//		StaticWait(3);
//		Users.resetbtn();
//		Users.reset();
//		Users.Yes();
//	}
//
//	@Then("^User clicks on Editsave button on Add/edit proctor pop up$")
//	public void user_clicks_on_editsave_button_on_add_edit_proctor_pop_up() {
//	    Users.editsavebtn();
//	}
	
	@Then("Proctor is clicks on Examtaker tab")
	public void user_is_on_Examtaker_tab() {
		StaticWait(3);
		Users.provisioning();
		StaticWait(1);
		Users.Examtakersbtn();
	}

	@And("Proctor clicks on Add new button on Examtaker tab")
	public void user_clicks_on_add_new_button_on_Examtaker_tab() {
		Users.Addnewbtn();
	}

	@When("Proctor Enter the valid Examtaker details from the given Excel sheet at {int} and save it")
	public void user_enter_the_valid_Examtaker_details_from_the_given_excel_sheet_at_row_number2_and_save_it(int rownumber4) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testdata=null;
		if(testdata == null)
		{
			testdata=reader.getData("/ExcelFiles/ExamTaker_Creation_at_procter_side_Details.xlsx", getSheetEnv());
		}
		String Emailtxt=testdata.get(rownumber4).get("Email");
		String Firstnametxt=testdata.get(rownumber4).get("FirstName");
		String Lastnametxt=testdata.get(rownumber4).get("LastName");
		String Idtxt=testdata.get(rownumber4).get("ID");
		String location=testdata.get(rownumber4).get("Location");
		String year=testdata.get(rownumber4).get("Year");
		String month=testdata.get(rownumber4).get("Month");
		String date=testdata.get(rownumber4).get("Date");
		Users.Create_Exataker_User(Emailtxt, Firstnametxt, Lastnametxt, Idtxt, location,year,month,date);
		StaticWait(1);
		Users.savebtn();
	}

	@Then("Proctor Enter the Examtaker Details from the given Excel sheet at {int} in search Textbox")
	public void user_enter_the_Examtaker_details_from_the_given_excel_sheet_at_row_number2_in_search_textbox(int rownumber3) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testdata=null;
		if(testdata == null)
		{
			testdata=reader.getData("/ExcelFiles/ExamTaker_Creation_at_procter_side_Details.xlsx", getSheetEnv());
		}
		String Firstnametxt=testdata.get(rownumber3).get("FirstName");
		String Lastnametxt=testdata.get(rownumber3).get("LastName");
		//System.out.println(Firstnametxt);
		Users.searchtxt(Firstnametxt, Lastnametxt);
	}

	@And("Proctor clicks on Edit button on Examtaker tab")
	public void user_clicks_on_edit_button_on_Examtaker_tab() {
		StaticWait(2);
	    Users.Editbtn();
	}

	@And("^Proctor clicks on Create new Login button on Add/edit Examtaker pop up$")
	public void user_clicks_on_create_new_login_button_on_add_edit_Examtaker_pop_up() {
		Users.createloginbtn();
	}

	@And("^Proctor clicks on Reset password button on Add/edit Examtaker pop up$")
	public void user_clicks_on_reset_password_button_on_add_edit_Examtaker_pop_up() {
		StaticWait(3);
		Users.resetbtn();
		Users.reset();
		Users.Yes();
	}

	@Then("^Proctor clicks on Editsave button on Add/edit Examtaker pop up$")
	public void user_clicks_on_editsave_button_on_add_edit_Examtaker_pop_up() {
	    Users.editsavebtn();
	   
	}
	
}