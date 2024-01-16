package StepDefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Com.Examcenter.Utils.ActionType;
import Com.Examcenter.Utils.Base;
import Com.Examcenter.Utils.ExcelReader;
import Com.Examcenter.pages.LoginPage;
import Com.Examcenter.pages.MyProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyProfileStepDefinitions extends ActionType{

	private LoginPage login=new LoginPage(Base.getDriver()); 
	private MyProfilePage profile=new MyProfilePage(Base.getDriver());
	static ExcelReader reader=new ExcelReader();
	static List<Map<String,String>> testdata=null;

	
	@And("User clicks on Myprofile Logo")
	public void user_clicks_on_myprofile_logo() {
		profile.logo();
	}

	@Then("User edit the Details {int}")
	public void user_edit_the_details(Integer editDetails) throws InvalidFormatException, IOException {
		testdata=null;
		waitForPageLoad();
		if(testdata==null)
		{
			testdata=reader.getData("\\Excel\\ProfileDetails.xlsx", getSheetEnv());
		}
		String email=testdata.get(editDetails).get("Email");
		String  ZoomId=testdata.get(editDetails).get("Zoom ID");
		//String desc=testdata.get(editDetails).get("Description");
		profile.edtEmail(email);
		profile.zoomid(ZoomId);
		//profile.profiledesc(desc);
	}

	@And("User Upload the profile Picture with {int}")
	public void user_upload_the_profile_picture_with(Integer filepath) throws InvalidFormatException, IOException, AWTException {
		testdata=null;
		waitForPageLoad();
		if(testdata==null)
		{
			testdata=reader.getData("\\Excel\\ProfileDetails.xlsx", getSheetEnv());
		}
		String path=testdata.get(filepath).get("Path");
		profile.uploadProfile(path);
	}

	@Then("User change the Password with Credentials {int}")
	public void user_change_the_password_with_credentials(Integer PwdDetails) throws InvalidFormatException, IOException {
		testdata=null;
		waitForPageLoad();
		if(testdata==null)
		{
			testdata=reader.getData("\\Excel\\ProfileDetails.xlsx", getSheetEnv());
		}
		String oldpwd=testdata.get(PwdDetails).get("OldPwd");
		String newpwd=testdata.get(PwdDetails).get("NewPwd");
		String conformpwd=testdata.get(PwdDetails).get("ConformPwd");
		profile.changepwd(oldpwd, newpwd, conformpwd);
	}

	@Then("Save the User Profile")
	public void save_the_user_profile() {
		profile.profileSave();
	}
}
