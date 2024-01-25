package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Examcenter.Utils.ActionType;
import com.Examcenter.Utils.Base;
import com.Examcenter.Utils.ExcelReader;
import com.Examcenter.pages.BulkUpload_Pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class BulkuploadStepDefinitions extends ActionType{

	BulkUpload_Pages Bulk=new BulkUpload_Pages(Base.getDriver());
	ExcelReader reader=new ExcelReader();
	List<Map<String, String>> TestData=null;
	
	
	@And("Create the Bulk controller users Excel Sheet")
	public void Create_Controller_Sheet() throws Exception

	{
		for(int i=0;i<35;i++)
		{
			String randomnumber = randomNumberGenerator();
			String FirstName="Controller"+randomnumber;
			String LastName="Automation"+randomnumber;
			String Email="controllerautomation"+randomnumber+"@gmail.com";
			String ID=randomnumber;
            //System.out.println(randomnumber);
			Bulk.Excel_Creation("E:\\Files\\ControllerTemplate.xlsx", "Bulk Upload", 0, FirstName,i+1);
			Bulk.Excel_Creation("E:\\Files\\ControllerTemplate.xlsx", "Bulk Upload", 1, LastName,i+1);
			Bulk.Excel_Creation("E:\\Files\\ControllerTemplate.xlsx", "Bulk Upload", 2, Email,i+1);
			Bulk.Excel_Creation("E:\\Files\\ControllerTemplate.xlsx", "Bulk Upload", 3, ID,i+1);
		}
	}
	@Then("Click on controller Bulk Upload Icon and Upload the File")
	public void click_on_controller_bulk_upload_icon() throws Exception {
		//StaticWait(5);
       Bulk.bulkUpload("E:\\Files\\ControllerTemplate.xlsx");
	}
	@And("Create the Bulk Proctor users Excel Sheet")
	public void Create_Proctor_Sheet() throws Exception

	{
		for(int i=0;i<35;i++)
		{
			String randomnumber = randomNumberGenerator();
			String FirstName="Proctor"+randomnumber;
			String LastName="Automation"+randomnumber;
			String Email="proctorautomation"+randomnumber+"@gmail.com";
			String ID=randomnumber;
            //System.out.println(randomnumber);
			Bulk.Excel_Creation("E:\\Files\\Proctor Template.xlsx", "Bulk Upload", 0, FirstName,i+1);
			Bulk.Excel_Creation("E:\\Files\\Proctor Template.xlsx", "Bulk Upload", 1, LastName,i+1);
			Bulk.Excel_Creation("E:\\Files\\Proctor Template.xlsx", "Bulk Upload", 2, Email,i+1);
			Bulk.Excel_Creation("E:\\Files\\Proctor Template.xlsx", "Bulk Upload", 3, ID,i+1);
		}
	}
	@Then("Click on Proctor Bulk Upload Icon and Upload the File")
	public void click_on_Proctor_bulk_upload_icon() throws Exception {
		//StaticWait(5);
       Bulk.bulkUpload("E:\\Files\\Proctor Template.xlsx");
	}
	@And("Create the Bulk Examtaker users Excel Sheet")
	public void Create_Examtaker_Sheet() throws Exception

	{
		for(int i=0;i<35;i++)
		{
			String randomnumber = randomNumberGenerator();
			String FirstName="Examtaker"+randomnumber;
			String LastName="Automation"+randomnumber;
			String Email="examtakerautomation"+randomnumber+"@gmail.com";
			String ID=randomnumber;
            //System.out.println(randomnumber);
			Bulk.Excel_Creation("E:\\Files\\Exam Takers Template.xlsx", "Bulk Upload", 0, FirstName,i+1);
			Bulk.Excel_Creation("E:\\Files\\Exam Takers Template.xlsx", "Bulk Upload", 1, LastName,i+1);
			Bulk.Excel_Creation("E:\\Files\\Exam Takers Template.xlsx", "Bulk Upload", 2, Email,i+1);
			Bulk.Excel_Creation("E:\\Files\\Exam Takers Template.xlsx", "Bulk Upload", 3, ID,i+1);
		}
	}
	@Then("Click on Examtaker Bulk Upload Icon and Upload the File")
	public void click_on_Examtaker_bulk_upload_icon() throws Exception {
		//StaticWait(5);
       Bulk.bulkUpload("E:\\Files\\Exam Takers Template.xlsx");
	}

}
