package com.Assessments.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.Wait;

public class SISProvisioningPage extends ActionType{

	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;
	static String SchoolName;
	static String ClassroomName;
	static String SectionName;
	static int DLastName;
	static int TLastName;
	static int SLastName;
	static String DFirstName;
	static String TFirstName;
	static String SFirstName;
	
	/*
	 * School Creation
	 */
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'Administration')]") private WebElement Administrationbtn;
	@FindBy(how=How.XPATH,using = "//a[contains(text(),'SIS Provisioning')]")private WebElement Provisioningtab;
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Schools')]")private WebElement Schooltab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'Add New School')]")private WebElement AddnewSchoolbtn;
	@FindBy(how=How.XPATH,using = "//div[@role='textbox']")private WebElement Description;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@placeholder='TimeZone']")private WebElement TimeZoneDropdown;
	
	/*
	 * Classroom Creation
	 */
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Classrooms')]")private WebElement Classroomtab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New Classroom')]")private WebElement AddnewClassroombtn;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@controlname='school']")private WebElement SchoolDropDown;
	/*
	 * Section Creation
	 */
	//private WebElement listofTabs=By.xpath("//div[@role='tablist']/div/div");
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Sections')]")private WebElement Sectiontab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New Section')]")private WebElement AddnewSectionbtn;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@controlname='year']")private WebElement YearDropDown;
	
	/*
	 * Districtuser Creation
	 */
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'District Users')]")private WebElement Districtusertab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New User')]")private WebElement AddnewDistrictUserbtn;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[1]")private WebElement Emailfield;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[2]")private WebElement FirstnameField;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[3]")private WebElement LastnameField;
	@FindBy(how=How.XPATH,using = "//mat-icon[contains(text(),'more_vert')]") private WebElement Ellipses;
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'Edit')]")private WebElement Editoption;
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'Create New Login')]")private WebElement CreateNewLoginbtn;
	@FindBy(how=How.XPATH,using = "//span[contains(text(),' Reset Password')]")private WebElement resetpwdbtn;
	@FindBy(how=How.XPATH,using = "//span[(text()=' Reset ')]")private WebElement Confirmationresetbtn;
	@FindBy(how = How.XPATH,using = "//button[text()='Cancel']/parent::div/button[1]")private WebElement resetpopup;

	/*
	 * Teacher Creation
	 */
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Teachers')]")private WebElement Teachertab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New Teacher')]")private WebElement AddnewTeacherbtn;
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'Settings')]")private WebElement Settingsoptions;
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Is District Admin ')]/mat-checkbox")private WebElement IsDistrcitAdminchkbox;
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Is Scorer ')]/mat-checkbox")private WebElement Speedgraderchkbox;
	@FindBy(how=How.XPATH,using = "//mat-icon[contains(text(),'close')]")private WebElement Closeicon;
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Manage User')]/parent::div/following::div[1]/div")private WebElement SettingsClassroomtab;
	@FindBy(how=How.XPATH,using = "//span[(text()=' Add ')]")private WebElement Settingsadd;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@controlname='classroom']")private WebElement ClassroomDown;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@controlname='section']")private WebElement SectionDown;

	/*
	 * Student Creation
	 */
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Students')]")private WebElement Studenttab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New Student')]")private WebElement AddnewStudentbtn;
	
	public SISProvisioningPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}
	
	public void Administrationtab()
	{
		//Wait.visibilityOf(Administrationbtn)
		Administrationbtn.click();
		Provisioningtab.click();
	}
	public void Schooltab()
	{
		wait.elementToBeClickable(Schooltab);
		Schooltab.click();
	}
	public void Classroomtab()
	{
		Classroomtab.click();
	}
	public void Sectiontab()
	{
		Sectiontab.click();
	}
	public void SchoolDropDownSearch()
	{
		wait.elementToBeClickable(SchoolDropDown);
		cp.FPdropdown(SchoolDropDown,SISProvisioningPage.SchoolName);
	}
	public void YearDropDownSearch(String Year)
	{
		cp.FPdropdown(YearDropDown, Year);
	}
	public void ClassroomDropDownSearch()
	{
		cp.FPdropdown(ClassroomDown, ClassroomName);
	}
	public void SectionDropDownSearch()
	{
		cp.FPdropdown(SectionDown, SectionName);
	}
	public void SchoolDetails()
	{
	    SchoolName="FPK12School"+randomNumberGenerator();
	    System.out.println(SchoolName);
		cp.Name(SchoolName);				
		Description.sendKeys(generateRandomString());
	}
	public void ClassroomDetails()
	{
//		ClassroomName="FPK12Classroom"+randomNumberGenerator();
		ClassroomName = "FPK12Classroom8989";
		cp.Name(ClassroomName);
		System.out.println(ClassroomName);
		Description.sendKeys(generateRandomString());
	}
	public void SectionDetails()
	{
		SectionName="FPK12Section"+randomNumberGenerator();
		cp.Name(SectionName);
		System.out.println(SectionName);
		Description.sendKeys(generateRandomString());
	}
	public void TimezoneValue(String TimeZoneValue)
	{
		cp.FPdropdown(TimeZoneDropdown,TimeZoneValue);
	}	
	
	public void SchoolSearch()
	{
		cp.searchField(SchoolName);
	}
	public void ClassroomSearch()
	{
		cp.searchField(ClassroomName);
	}
	public void SectionSearch()
	{
		cp.searchField(SectionName);
	}
	public void DUserSearch()
	{
		cp.searchField(String.valueOf(DLastName));
		System.out.println(DLastName);
	}
	public void TUserSearch()
	{
		cp.searchField(String.valueOf(TLastName));
		System.out.println(TLastName);
	}
	public void SUserSearch()
	{
		cp.searchField(String.valueOf(SLastName));
		System.out.println(SLastName);
	}
	public void AddnewSchool()
	{
		AddnewSchoolbtn.click();
	}
	public void AddNewClassroom()
	{
		AddnewClassroombtn.click();
	}

	public void AddNewSection()
	{
		AddnewSectionbtn.click();
	}
	public void DistrictUserTab()
	{
		wait.elementToBeClickable(Districtusertab);
		Districtusertab.click();
	}
	public void TeacherTab()
	{
		wait.elementToBeClickable(Teachertab);
		Teachertab.click();
	}
	public void StudentTab()
	{
		wait.elementToBeClickable(Studenttab);
		Studenttab.click();
	}
	public void SettingsAdd()
	{
		Settingsadd.click();
	}
	public void AddNewDistrictUser()
	{
		AddnewDistrictUserbtn.click();
	}
	public void AddNewTeacher()
	{
		AddnewTeacherbtn.click();
	}
	public void AddNewStudent()
	{
		AddnewStudentbtn.click();
	}
	public void DistrictUserDetails(String UserRole)
	{
		wait.elementToBeClickable(Emailfield);
		wait.visibilityOf(Emailfield);
		Emailfield.sendKeys(randomEmailIdGenerator(UserRole).toLowerCase());
		DFirstName="FPK12Admin".toLowerCase();
		FirstnameField.sendKeys(DFirstName);
		DLastName=randomNumberGenerator();
		LastnameField.sendKeys(String.valueOf(DLastName));
	}
	public void TeacherUserDetails(String UserRole)
	{
		wait.elementToBeClickable(Emailfield);
		wait.visibilityOf(Emailfield);
		Emailfield.sendKeys(randomEmailIdGenerator(UserRole).toLowerCase());
		TFirstName="FPK12Teacher".toLowerCase();
		FirstnameField.sendKeys(TFirstName);
		TLastName=randomNumberGenerator();
		LastnameField.sendKeys(String.valueOf(TLastName));
	}
	public void StudentUserDetails(String UserRole)
	{
		wait.elementToBeClickable(Emailfield);
		wait.visibilityOf(Emailfield);
		Emailfield.sendKeys(randomEmailIdGenerator(UserRole).toLowerCase());
		SFirstName="FPK12Student".toLowerCase();
		FirstnameField.sendKeys(SFirstName);
		SLastName=randomNumberGenerator();
		LastnameField.sendKeys(String.valueOf(SLastName));
	}
	public void EditScreen()
	{
		wait.elementToBeClickable(Ellipses);
		wait.visibilityOf(Ellipses);
		Ellipses.click();
		wait.elementToBeClickable(Editoption);
		Editoption.click();
	}
	public void CreateNewLogin()
	{
		wait.elementToBeClickable(CreateNewLoginbtn);
		CreateNewLoginbtn.click();
	}
	public void ResetPwd()
	{
		wait.elementToBeClickable(resetpwdbtn);
		resetpwdbtn.click();
		wait.elementToBeClickable(Confirmationresetbtn);
		Confirmationresetbtn.click();
		wait.elementToBeClickable(resetpopup);
		resetpopup.click();
		cp.Save();
	}
	
	public void Settings()
	{
		wait.elementToBeClickable(Ellipses);
		StaticWait(2);
		Ellipses.click();
		wait.elementToBeClickable(Settingsoptions);
		Settingsoptions.click();
		StaticWait(1);
	}
	public void Checkbox()
	{
		IsDistrcitAdminchkbox.click();
		wait.elementToBeClickable(Speedgraderchkbox);
		Speedgraderchkbox.click();
	}
	public void close()
	{
		wait.elementToBeClickable(Closeicon);		
	//	StaticWait(4);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", Closeicon);
//		Actions a=new Actions(driver);
//		a.moveToElement(Closeicon);
//		Closeicon.click();
	}
	public void SettingClassroom()
	{
		SettingsClassroomtab.click();
	}
	public void insertData() throws Exception
	{
		cp.InsertdataIntoExcel("./src/test/resources/ExcelFiles/LoginDetails.xlsx", getSheetEnv(), SchoolName, ClassroomName, SectionName);
	}
	public void insertUsersData() throws Exception
	{
		cp.InsertmultipledataIntoExcel("./src/test/resources/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	}
}
