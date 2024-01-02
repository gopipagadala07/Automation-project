package stepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Exam_Center.pages.Login_page;
import com.FP_Examcenter.util.ActionType;
import com.FP_Examcenter.util.Base;
import com.FP_Examcenter.util.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login_Stepdefination extends ActionType
{
	private Login_page loginpage = new Login_page(Base.getDriver());

	static ExcelReader reader = new ExcelReader();
	static List<Map<String,String>> testData = null;
	
	@Given("User launch the application with valid URL")
	public void user_launch_the_application_with_valid_url() 
	{
		getURL(getProperty("url"));
	}

	@And("User enters the credentials from the given admin excel sheet at {int}")
	public void user_enters_the_credentials_from_the_given_admin_excel_sheet_at_row_number_i_complete_action(Integer RowNumber) throws InvalidFormatException, IOException 
	{
		testData = null;
		waitForPageLoad();
		if(testData == null)
		{
			testData = reader.getData("/ExcelFiles/LoginCredentials.xlsx", getSheetEnv());
			//				System.out.println(testData);
			String username = testData.get(RowNumber).get("username");
			String password = testData.get(RowNumber).get("password");
			loginpage.user_login(username, password);
		}
	}

	@Then("User able to see the Home page")
	public void user_able_to_see_the_home_page()
	{


	}

}
