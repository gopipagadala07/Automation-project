package ExamCenterStepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.Examcenter.pages.Provide_Score_Pages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Provide_Score_Stepdefination extends ActionType

{
	static ExcelReader reader=new ExcelReader();
	static List<Map<String,String>> testdata=null;
	Provide_Score_Pages PS = new Provide_Score_Pages(Base.getDriver());
	@And("User Enter the Controller Name in Search here Textbox {int}")
	public void user_enter_the_controller_name_in_search_here_textbox(Integer rownumber) throws InvalidFormatException, IOException 
	{
		waitForPageLoad();
		testdata=null;
		if(testdata == null)
		{
			testdata=reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
		}
		String L_Name=testdata.get(rownumber).get("LastName");
		String F_Name=testdata.get(rownumber).get("FirstName");
		PS.searchtxt(L_Name, F_Name);
	}
	
	@Then("User select the Examination from the Lookups {int}")
	public void user_select_the_the_examination_from_the_from_the_lookups(Integer rownumber) throws InvalidFormatException, IOException 
	{
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
		}
		String examname=testdata.get(rownumber).get("ExamName");
		String schedulename=testdata.get(rownumber).get("ScheduleName");
		PS.Select_the_Examination(examname, schedulename);
	}
	

	@And("Enable the Location {int}")
	public void enable_the_location(Integer rownumber) throws InvalidFormatException, IOException 
	{
		waitForPageLoad();
		testdata=null;
		if(testdata == null)
		{
			testdata=reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
		}
		String Location_Name=testdata.get(rownumber).get("Location");
		PS.Location_Toggle(Location_Name);
	}

	@Then("User click on Score Exam Tab")
	public void user_click_on_score_exam_tab() 
	{
	  PS.click_on_Score_Exam_Tab();
	}

	@And("User select the Score Examination from the Lookups {int}")
	public void user_select_the_examination_from_the_from_the_lookups(Integer rownumber) throws InvalidFormatException, IOException 
	{
		testdata=null;
		if(testdata==null)
		{
			testdata=reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
		}
		String examname=testdata.get(rownumber).get("ExamName");
		String schedulename=testdata.get(rownumber).get("ScheduleName");
		PS.Select_the_Examination_for_Score(examname, schedulename);
	}

	@Then("User select the Location from the Lookups {int}")
	public void user_select_the_location_from_the_from_the_lookups(Integer rownumber) throws InvalidFormatException, IOException 
	{
		waitForPageLoad();
		testdata=null;
		if(testdata == null)
		{
			testdata=reader.getData("/ExcelFiles/ExamCenterDetails.xlsx", getSheetEnv());
		}
		String Location_Name=testdata.get(rownumber).get("Location");
		PS.select_Location(Location_Name);
	}
	

	@And("User Click on Score button and provide the score")
	public void user_click_on_score_button_and_provide_the_score() 
	{
		PS.click_on_Score_Exam_Tab();
		PS.Score_Exam();
		
	}

}
