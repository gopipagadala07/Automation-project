package LearningTreeStepdef;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.LearningTree.pages.Documents_tab_page;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Documents_tab_Stepdefination extends ActionType {

	ExcelReader reader=new ExcelReader();
	static List<Map<String, String>> testdata=null;

	private Documents_tab_page DT=new Documents_tab_page(Base.getDriver());


	@Then("User Click on Courses in Left menu")
	public void user_click_on_courses_in_left_menu() {
		DT.click_on_CoursesTab();
	}

	@Then("User clicks on Documents Tab")
	public void user_clicks_on_documents_tab() {
		DT.DocumentsTab();
	}

	@When("User created folder by Entering the Folder Name and Description")
	public void User_create_folder_by_Entering_the_Folder_Name_and_Description() {
		DT.create_Folders();
	}

	@Then("User click Upload file button")
	public void User_click_Upload_file_button() throws IOException   {
		DT.fileupload();

	}

	@Then("User successfully uploaded the document file")
	public void user_successfully_uploaded_the_document_file() {
		   System.out.println("File uploaded successfully.");
	}

	@Then("User clicks on Learning tree")
	public void user_clicks_on_learning_tree() {
		DT.click_on_LearningtreeTab();
	}
	


	@Then("User downloaded the file")
	public void user_downloaded_the_file() {
		DT.downloadfile();
		DT.attachDownloadedFileToReport();

	}
}
