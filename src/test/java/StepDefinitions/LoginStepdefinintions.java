package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

import Com.Examcenter.Utils.ActionType;
import Com.Examcenter.Utils.Base;
import Com.Examcenter.Utils.ExcelReader;
import Com.Examcenter.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepdefinintions extends ActionType{

	private LoginPage login=new LoginPage(Base.getDriver());   
    static ExcelReader reader=new ExcelReader();
    static List<Map<String,String>> testdata=null;
    
	@Given("User launch the application")
	public void user_launch_the_application() {
	    getURL(getProperty("url"));
	}

	@And("User able to see all Fields")
	public void user_able_to_see_all_fields() {
	    login.allFieldsDispayed();
	}

	@Then("User enters the credentials from the given excel sheet at {int}")
	public void user_enters_the_credentials_from_the_given_excel_sheet_at(Integer rownumber) throws InvalidFormatException, IOException {
		waitForPageLoad();
		if(testdata == null)
	    {
	    	testdata=reader.getData("/Excel/StageCredentials.xlsx", getSheetEnv());
	    }
	    String username=testdata.get(rownumber).get("username");
	    String password=testdata.get(rownumber).get("password");
	    login.User_login(username, password);
	    StaticWait(4);
	}

	@And("User is on homepage")
	public void user_is_on_homepage() throws Exception {
		StaticWait(2);
		login.Logo();
	   System.out.println("Sucessfully user is Login into the Application..");
	   StaticWait(3);
	   //getDriver().close();
	}
}
