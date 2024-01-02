package stepDefinations;


import com.Exam_Center.pages.Enrolled_ExamTaker_in_the_Timeslot_Page;
import com.FP_Examcenter.util.ActionType;
import com.FP_Examcenter.util.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Procter_Comment_Stepdefination extends ActionType
{
	private Enrolled_ExamTaker_in_the_Timeslot_Page proctercomment = new Enrolled_ExamTaker_in_the_Timeslot_Page(Base.getDriver());

	@When("Examtaker not added in the Timeslot then add the Examtaker in the Timeslot")
	public void examtaker_not_added_in_the_timeslot_then_add_the_examtaker_in_the_timeslot() 
	{
	    proctercomment.add_Examtaker();
	}

	@Then("User provide the comment to the Examtaker")
	public void user_provide_the_comment_to_the_examtaker() 
	{
		proctercomment.p_comment();
	}

}
