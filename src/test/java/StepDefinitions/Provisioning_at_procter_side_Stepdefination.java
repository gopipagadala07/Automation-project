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