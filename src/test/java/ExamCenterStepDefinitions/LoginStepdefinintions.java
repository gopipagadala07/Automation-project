package ExamCenterStepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Examcenter.pages.LoginPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepdefinintions extends ActionType{

	static ExcelReader reader=new ExcelReader();   
	static List<Map<String,String>> testdata=null;
	private LoginPage login=new LoginPage(Base.getDriver());

	@And("User able to see all Fields")
	public void user_able_to_see_all_fields() {
		StaticWait(2);
		//login.allFieldsDispayed();
	}

	@Then("User enters the credentials from the excel sheet at {int}")
	public void user_enters_the_credentials_from_the_excel_sheet_at(Integer rownumber) throws InvalidFormatException, IOException {
		waitForPageLoad();
		testdata=null;
		if(testdata == null)
		{
			testdata=reader.getData("/ExcelFiles/User_Details.xlsx", getSheetEnv());
		}
		String FtName=testdata.get(rownumber).get("FirstName");
		String LtName=testdata.get(rownumber).get("LastName");
		String Tid=testdata.get(rownumber).get("Tenant ID");
		String password=testdata.get(rownumber).get("password");
		login.User_login(FtName,LtName,Tid, password);
		
	}

	@And("User is on homepage")
	public void user_is_on_homepage() throws Exception {
		login.header();
		
	}

	@Given("User launch the application with Valid URL")
	public void user_launch_the_application() {
		getURL(getProperty("url"));
	}
}
