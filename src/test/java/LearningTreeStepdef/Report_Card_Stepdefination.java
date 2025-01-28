package LearningTreeStepdef;

import com.LearningTree.pages.Report_CardPage;
import com.Utils.ActionType;
import com.Utils.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Report_Card_Stepdefination extends ActionType{
	private Report_CardPage RC = new Report_CardPage(Base.getDriver());
	
	
	@Then("User Click on Report Card Tab")
	public void user_click_on_report_card_tab()
	{
		RC.report_Card_Tab();
	}

	@Then("User Provide the Comments in Report Card for the Student")
	public void user_provide_the_comments_in_report_card_for_the_student()
	{
	    RC.provide_the_Comments();
	}

	@Then("User validate the preview of the Activities in the Report card")
	public void user_validate_the_preview_of_the_activities_in_the_report_card()
	{
	    RC.preview_the_Activity_in_Report_Card();
	}

	@And("Export the report card and print the Report Table")
	public void export_the_report_card_and_print_the_report_table()
	{
	    RC.export_And_Print_the_Report_Table();
	}

}
