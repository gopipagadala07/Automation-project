package AssessmentsStepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;

import com.Assessments.pages.BenchmarksPage;
import com.Assessments.pages.CommonPages;
import com.Assessments.pages.SISProvisioningPage;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BenchmarkStepdefinitions extends ActionType{
	 
	BenchmarksPage bpages=new BenchmarksPage(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	static List<Map<String, String>> testdata=null;

	
	
	@When("the user clicks on the Districts tab and navigates to Benchmarks")
	public void the_user_clicks_on_the_districts_tab_and_navigates_to_benchmarks() {
	   bpages.DistAndBenchmarkTab();
	   
	}

	@When("the user selects the Year from the dropdown at row {int}")
	public void the_user_selects_the_year_from_the_dropdown_at_row(Integer int1) throws Exception, IOException {
	    if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	    }  
		String Year = testdata.get(int1).get("Year");	   
	    bpages.yeardropdowns(Year) ;   
	}


	@When("the user selects the Grade from the dropdown at row {int}")
	public void the_user_selects_the_grade_from_the_dropdown_at_row(Integer int1) throws Exception, IOException {
	    
	    if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	    }
	    String grade = testdata.get(int1).get("Grade");	   
	    bpages.gradedropdowns(grade); 
	
	}

	@When("the user selects the Subject from the dropdown at row {int}")
	public void the_user_selects_the_subject_from_the_dropdown_at_row(Integer int1) throws Exception, IOException {
		
		if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	    }
	    String subject = testdata.get(int1).get("Subject");	   
	    bpages.subdropdowns(subject);
	}
	@Then("the user clicks on the Add New Benchmark button")
	public void the_user_clicks_on_the_add_new_benchmark_button() {
	    bpages.AddBenchmark();
	}
	
	@Then("the user enters the benchmark name and description generated randomly")
	public void the_user_enters_the_benchmark_name_and_description_generated_randomly() {
	   bpages.BenchmarkName();
	}

	@Then("the user selects all the checkboxes")
	public void the_user_selects_all_the_checkboxes() {
	    bpages.checkboxes();
	   
	}

	@Then("the user clicks on the Save button")
	public void the_user_clicks_on_the_save_button() {
		cp.Save();
	}

	@Then("the user clicks on the Find Test button")
	public void the_user_clicks_on_the_find_test_button() {
	    bpages.findtest();
	}

	@Then("the user clicks on the Search Here field and enters the test name from row {int}")
	public void the_user_clicks_on_the_search_here_field_and_enters_the_test_name_from_row(int Testname) throws InvalidFormatException, IOException {
		if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	    }
	    String Tname = testdata.get(Testname).get("Testname");	   
		cp.SearchTestname(Tname);
	
	}

	@Then("the user clicks on the Add icon button")
	public void the_user_clicks_on_the_add_icon_button() {
	    bpages.addicon();
	}

	@Then("the user clicks on the Publish button")
	public void the_user_clicks_on_the_publish_button() {
		
		bpages.publishBtn();
	}

	@Then("a confirmation popup appears, and the user clicks on the Yes button")
	public void a_confirmation_popup_appears_and_the_user_clicks_on_the_yes_button() {
	    bpages.yesbutton();
	}

	@Then("the user clicks on the created benchmark and navigates to the Sections tab")
	public void the_user_clicks_on_the_created_benchmark_and_navigates_to_the_sections_tab() {
	    bpages.clickOnNewBencmark();
	    bpages.clickOnSectionTab();
	}

	@Then("the user clicks on the Search Here field and enters the section name from row {int}")
	public void the_user_clicks_on_the_search_here_field_and_enters_the_section_name_from_row(Integer SectionName) throws Exception, IOException {
		if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	    }
	    String secname = testdata.get(SectionName).get("Section Name");	   
	    cp.searchField(secname);
	    cp.searchField(Keys.chord(Keys.CONTROL,"a"));
	    cp.searchField(Keys.chord(Keys.CONTROL,"x"));
	    StaticWait(1);
	    cp.searchField(Keys.chord(Keys.CONTROL,"v"));
	
	}

	@Then("the user clicks on the Add button {int}")
	public void the_user_clicks_on_the_add_button(int SectionName) throws Exception, IOException {
		
		if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	    }
	    String secname = testdata.get(SectionName).get("Section Name");	   
	    bpages.clickOnAdd(secname);
	}
	
}
