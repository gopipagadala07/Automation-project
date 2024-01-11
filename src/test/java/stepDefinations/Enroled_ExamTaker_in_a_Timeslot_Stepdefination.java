package stepDefinations;


import com.Exam_Center.pages.Enrolled_ExamTaker_in_the_Timeslot_Page;
import com.FP_Examcenter.util.ActionType;
import com.FP_Examcenter.util.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Enroled_ExamTaker_in_a_Timeslot_Stepdefination extends ActionType
{
	private Enrolled_ExamTaker_in_the_Timeslot_Page Enr = new Enrolled_ExamTaker_in_the_Timeslot_Page(Base.getDriver());

	@When("Examtaker not added in the Timeslot then add the Examtaker in the Timeslot")
	public void examtaker_not_added_in_the_timeslot_then_add_the_examtaker_in_the_timeslot() 
	{
		Enr.add_Examtaker();
		
	}

	@Then("User provide the comment to the Examtaker")
	public void user_provide_the_comment_to_the_examtaker() 
	{
		Enr.p_comment();
	}
	@Then("User click on ExamTaker Entry Details")
	public void user_click_on_exam_taker_entry_details() 
	{
		Enr.ET_Entry_details();

	}
	@When("User reset the Examinataion for the ExamTaker")
	public void user_reset_the_examinataion_for_the_exam_taker()
	{
		Enr.Reset_the_Examination();
	}
	@Then("User remove the ExamTaker from the Timeslot")
	public void user_remove_the_exam_taker_from_the_timeslot() 
	{
		Enr.remove_the_examtaker();
	}

	


}
