package com.Examcenter.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
import com.Utils.Wait;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class Location_pom extends ActionType {


	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;

	static String LocationName;


	//Location Creation
	@FindBy(how=How.XPATH,using = "//span[text()='Administration']")private WebElement Administrationbtn;
	@FindBy(how=How.XPATH,using = "//a[text()='Locations']")private WebElement Locationtab;
	@FindBy(how=How.XPATH,using = "//span[text()=' Add New ']") private WebElement AddNewbutton;
	@FindBy(how=How.XPATH,using = "//mat-label[text()='Name ']")private WebElement LocationNamefield;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[2]")private WebElement AddressNamefield;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[3]")private WebElement Cityfield;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[4]")private WebElement Zipfield;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[5]")private WebElement Statefield;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[6]")private WebElement Mobilenumberfield;
	@FindBy(how = How.XPATH,using = "//span[text()=' Save ']")private WebElement LocationSave;


	public Location_pom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=new Wait(driver);
	}


	public void Adminstrationbtn()
	{
		Administrationbtn.click();

	}
	public void Location_tab() {
		Locationtab.click();
	}

	public void Addnew_location() {
		AddNewbutton.click();
	}
	public void Location_Name() throws Exception 
	{
		LocationName="ECLocation"+randomNumberGenerator();
		System.out.println(LocationName);
		ExtentCucumberAdapter.addTestStepLog(LocationName);
		cp.Name(LocationName);
		cp.insertData("ExamCenterDetails.xlsx", LocationName, 0);

	}

	public void Other_fields() {
		AddressNamefield.sendKeys(String.valueOf(randomNumberGenerator()));
		Cityfield.sendKeys(generateRandomString());
		Zipfield.sendKeys(String.valueOf(randomNumberGenerator()));
		Statefield.sendKeys(generateRandomString());
		Mobilenumberfield.sendKeys(String.valueOf(randomNumberGenerator()));	
	}
	public void savebutton() {
		cp.Savebtn.click();

	}

}
