package ExamCenterStepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.Examcenter.pages.Users_CreationPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;
import com.Examcenter.pages.All_User_CreationPage;
import com.Examcenter.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUsersStepdefinitions extends ActionType{

	static ExcelReader reader=new ExcelReader();
	static List<Map<String,String>> testdata=null;
	private All_User_CreationPage Users=new All_User_CreationPage(Base.getDriver());

	@And("^User clicks on Create new Login button on Add/edit pop up$")
	public void user_clicks_create_new_login_button() {
		Users.createloginbtn();
	}

	@And("User clicks on Add new button")
	public void user_clicks_on_add_new_button() {
		Users.Addnewbtn();
	}

	@And("User clicks on Administration tab")
	public void user_clicks_on_administration_tab() {

		Users.Adminstarationbtn();
	}

	@Then("User clicks on Controller tab")
	public void user_clicks_on_controller_tab() {
		Users.Controllerbtn();
	}


	@Then("User clicks on Edit button")
	public void user_clicks_on_edit_button() {
		waitForPageLoad();
		Users.Editbtn();
	}

	@And("^User clicks on Reset password button on Add/edit pop up$")
	public void user_clicks_on_reset_password_button() {
		Users.resetbtn();
		Users.reset();
		Users.Yes();
	}

	@Then("User clicks on Save button")
	public void user_clicks_on_save_button() {
		Users.savebtn();
	}

	@And("User Enter the Controller Name in search Textbox")
	public void user_enter_the_details_in_search_textbox() throws InvalidFormatException, IOException {
		waitForPageLoad();
		Users.searchtxt(All_User_CreationPage.ControllerL_Name, All_User_CreationPage.ControllerF_Name);
	}

	@And("User Enter the Proctor Name in search Textbox")
	public void user_enter_the_proctor_details_in_search_textbox() {
		waitForPageLoad();
		Users.searchtxt(All_User_CreationPage.ProctorL_Name, All_User_CreationPage.ProctorF_Name);
	}
	@And("User Enter the ExamTaker Name in search Textbox")
	public void user_enter_the_ExamTaker_Name_in_search_textbox() 
	{
		waitForPageLoad();
		Users.searchtxt(All_User_CreationPage.ExamTakerL_Name, All_User_CreationPage.ExamTakerF_Name);
	}


		@When("User Enter the valid Examtaker details {int} {int}")
		public void User_enter_the_valid_Examtaker_details(int rownumber, int rownumber3) throws InvalidFormatException, IOException {
			waitForPageLoad();
			testdata=null;
			if(testdata == null)
			{
				testdata=reader.getData("/ExcelFiles/User_Details.xlsx", getSheetEnv());
			}
			String User_Role=testdata.get(rownumber3).get("User Role");
			String location=testdata.get(rownumber).get("Location");
			Users.Create_Examtaker_User(User_Role,location);
		}

	@When("User Enter the valid Proctor details {int} {int}")
	public void user_Enter_the_valid_Proctor_details(int rownumber, int rownumber2 ) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testdata=null;
		if(testdata == null)
		{
			testdata=reader.getData("/ExcelFiles/User_Details.xlsx", getSheetEnv());
		}
		String User_Role=testdata.get(rownumber2).get("User Role");
		String location=testdata.get(rownumber).get("Location");
		Users.Create_proctor_User(User_Role,location);

	}


	@When("User Enter the valid Controller details")
	public void user_enter_the_valid_user_details() throws Exception {
		Users.Create_Controller_User("Controller");
		Users.isAdminChkBox();
	}

	@And("User on Examtaker tab")
	public void user_is_on_Examtaker_tab() {
		Users.Examtakersbtn();
	}

	@Given("User is on Proctor tab")
	public void user_is_on_proctor_tab() {
		Users.provisioning();
		Users.Proctorbtn();
	}
	@Then("Store the users data in Excel")
	public void store_the_users_data_in_excel() throws Exception {
		Users.insertUsersData();
		System.out.println("Users Data inserted Sucessfully");
	}

}
