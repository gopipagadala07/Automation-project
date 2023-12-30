package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Fp_Examcenter.Utils.ActionType;
import com.Fp_Examcenter.Utils.Base;
import com.Fp_Examcenter.Utils.ExcelReader;
import com.Fp_Examcenter.pom_pages.EC_Loginpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginpage_Stepdefinition extends ActionType {
	
	private EC_Loginpage EClogin=new EC_Loginpage(Base.getDriver());
	
	static ExcelReader reader=new ExcelReader();
	static List<Map<String,String>> testData=null;
	
	@Given("^User launch the application$")
	public void user_launch_the_application() {
		getURL(getProperty("url"));
	}
	
	@And("^User able to see pleaselogintoapp text$")
	public void user_able_to_see_pleaselogtoapp_text() {
		EClogin.pleaselogintoapp();
	}

	@When("User enters the valid credential from the given excel sheet at {int}")
	public void user_enters_the_valid_credential(Integer rowNumber) throws InvalidFormatException, IOException {
		waitForPageLoad();
		if(testData == null) {
			
			testData = 
					reader.getData("/Excelfiles/ProdData.xlsx", getSheetEnv());
			
			System.out.println(testData);
		}
		
		String username = testData.get(rowNumber).get("username");
		String password = testData.get(rowNumber).get("password");
		System.out.println(username+"---"+password);
		//String user = testData.get(rowNumber).get("user");
		EClogin.login(username, password);		
	}

	@Then("^User able to see the Home page$")
	public void user_able_to_see_the_home_page() {
		waitForPageLoad();
	
}
}
