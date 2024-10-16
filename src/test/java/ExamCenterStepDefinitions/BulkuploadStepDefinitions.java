package ExamCenterStepDefinitions;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;

import com.Examcenter.pages.BulkUpload_Pages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class BulkuploadStepDefinitions extends ActionType{

	BulkUpload_Pages Bulk=new BulkUpload_Pages(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	List<Map<String, String>> TestData=null;


	@Then("Click on controller Bulk Upload Icon and Upload the File")
	public void click_on_controller_bulk_upload_icon() throws Exception {

		String path =(System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\ControllerTemplate.xlsx");
		System.out.println(path);
		Bulk.bulkUpload(path);
	}
	@Then("Click on Examtaker Bulk Upload Icon and Upload the File")
	public void click_on_Examtaker_bulk_upload_icon() throws Exception {
		//StaticWait(5);
		String path =(System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\Exam Takers Template.xlsx");
		Bulk.bulkUpload(path);
	}
	@Then("Click on Proctor Bulk Upload Icon and Upload the File")
	public void click_on_Proctor_bulk_upload_icon() throws Exception {
		//StaticWait(5);
		String path =(System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\Proctor Template.xlsx");
		Bulk.bulkUpload(path);
	}
	@And("Create the Bulk controller users Excel Sheet")
	public void Create_Controller_Sheet() throws Exception

	{
		for(int i=0;i<30;i++)
		{
			String randomnumber = randomNumberGenerator();
			String FirstName="Controller"+randomnumber;
			String LastName="Automation"+randomnumber;
			String Email="controllerautomation"+randomnumber+"@gmail.com";
			String ID=randomnumber;
			//System.out.println(randomnumber);
			String path="./src/test/resources/Files/ControllerTemplate.xlsx";
			Bulk.Excel_Creation(path, "Bulk Upload", 0, FirstName,i+1);
			Bulk.Excel_Creation(path, "Bulk Upload", 1, LastName,i+1);
			Bulk.Excel_Creation(path, "Bulk Upload", 2, Email,i+1);
			Bulk.Excel_Creation(path, "Bulk Upload", 3, ID,i+1);
		}
	}
	@And("Create the Bulk Examtaker users Excel Sheet")
	public void Create_Examtaker_Sheet() throws Exception

	{
		for(int i=0;i<30;i++)
		{
			String randomnumber = randomNumberGenerator();
			String FirstName="Examtaker"+randomnumber;
			String LastName="Automation"+randomnumber;
			String Email="examtakerautomation"+randomnumber+"@gmail.com";
			String ID=randomnumber;
			String path="./src/test/resources/Files/Exam Takers Template.xlsx";
			//System.out.println(randomnumber);
			Bulk.Excel_Creation(path, "Bulk Upload", 0, FirstName,i+1);
			Bulk.Excel_Creation(path, "Bulk Upload", 1, LastName,i+1);
			Bulk.Excel_Creation(path, "Bulk Upload", 2, Email,i+1);
			Bulk.Excel_Creation(path, "Bulk Upload", 3, ID,i+1);
		}
	}
	@And("Create the Bulk Proctor users Excel Sheet")
	public void Create_Proctor_Sheet() throws Exception

	{
		for(int i=0;i<30;i++)
		{
			String randomnumber = randomNumberGenerator();
			String FirstName="Proctor"+randomnumber;
			String LastName="Automation"+randomnumber;
			String Email="proctorautomation"+randomnumber+"@gmail.com";
			String ID=randomnumber;
			String path="./src/test/resources/Files/Proctor Template.xlsx";
			//System.out.println(randomnumber);
			Bulk.Excel_Creation(path, "Bulk Upload", 0, FirstName,i+1);
			Bulk.Excel_Creation(path, "Bulk Upload", 1, LastName,i+1);
			Bulk.Excel_Creation(path, "Bulk Upload", 2, Email,i+1);
			Bulk.Excel_Creation(path, "Bulk Upload", 3, ID,i+1);
		}
	}

}
