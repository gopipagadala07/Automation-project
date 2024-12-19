package ExamCenterStepDefinitions;


import com.Examcenter.pages.CommonPages;
import com.Examcenter.pages.Enrolled_ExamTaker_in_the_Timeslot_Page;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Enroled_ExamTaker_in_a_Timeslot_Stepdefination extends ActionType

{
	static ExcelReader reader = new ExcelReader();
    static List<Map<String,String>> testData = null;
    CommonPages cp=new CommonPages(Base.getDriver());
	private Enrolled_ExamTaker_in_the_Timeslot_Page Enr = new Enrolled_ExamTaker_in_the_Timeslot_Page(Base.getDriver());

	@Then("User click on ExamTaker Entry Details")
	public void user_click_on_exam_taker_entry_details() 
	{
		Enr.ET_Entry_details();

	}
	@Then("User provide the comment to the Examtaker")
	public void user_provide_the_comment_to_the_examtaker()
	{
			Enr.p_comment();
			cp.Save();
	}
	@Then("User remove the ExamTaker from the Timeslot")
	public void user_remove_the_exam_taker_from_the_timeslot() 
	{
		//Enr.remove_the_examtaker();
	}
	@When("User reset the Examinataion for the ExamTaker")
	public void user_reset_the_examinataion_for_the_exam_taker()
	{
		//Enr.Reset_the_Examination();
	}

	


}
