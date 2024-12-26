package com.PortfolioCenter.pages;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.Wait;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

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
	@FindBy(how=How.XPATH,using = "(//div[@role='tab']/child::div)[6]")private WebElement Schooltab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'Add New School')]")private WebElement AddnewSchoolbtn;
	@FindBy(how=How.XPATH,using = "//div[@role='textbox']")private WebElement Description;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@placeholder='TimeZone']")private WebElement TimeZoneDropdown;
	
	/*
	 * Classroom Creation
	 */
	@FindBy(how=How.XPATH,using = "(//div[@role='tab']/child::div)[5]")private WebElement Classroomtab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New Classroom')]")private WebElement AddnewClassroombtn;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@controlname='school']")private WebElement SchoolDropDown;
	/*
	 * Section Creation
	 */
	//private WebElement listofTabs=By.xpath("//div[@role='tablist']/div/div");
	@FindBy(how=How.XPATH,using = "(//div[@role='tab']/child::div)[4]")private WebElement Sectiontab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New Section')]")private WebElement AddnewSectionbtn;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@controlname='year']")private WebElement YearDropDown;
	
	/*
	 * Districtuser Creation
	 */
	@FindBy(how=How.XPATH,using = "(//div[@role='tab']/child::div)[3]")private WebElement Districtusertab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New User')]")private WebElement AddnewDistrictUserbtn;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[1]")private WebElement Emailfield;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[2]")private WebElement FirstnameField;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[3]")private WebElement LastnameField;
	@FindBy(how=How.XPATH,using = "//*[text()='more_vert']") private WebElement Ellipses;
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'Edit')]")private WebElement Editoption;
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'Create New Login')]")private WebElement CreateNewLoginbtn;
	@FindBy(how=How.XPATH,using = "//span[contains(text(),' Reset Password')]")private WebElement resetpwdbtn;
	@FindBy(how=How.XPATH,using = "//span[(text()=' Reset ')]")private WebElement Confirmationresetbtn;
	@FindBy(how = How.XPATH,using = "//button[text()='Cancel']/parent::div/button[1]")private WebElement resetpopup;

	/*
	 * Teacher Creation
	 */
	@FindBy(how=How.XPATH,using = "(//div[@role='tab']/child::div)[2]")private WebElement Teachertab;
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
	@FindBy(how=How.XPATH,using = "(//div[@role='tab']/child::div)[1]")private WebElement Studenttab;
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

	public void Schooltab() {
	    int maxRetries = 3;
	    int attempt = 0;
	    boolean success = false;

	    while (attempt < maxRetries && !success) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	            wait.until(ExpectedConditions.elementToBeClickable(Schooltab));
	            StaticWait(2);
	            Actions a = new Actions(driver);
	            a.moveToElement(Schooltab).click().perform();
	            success = true;
	        } catch (TimeoutException e) {
	            System.out.println("TimeoutException: " + e.getMessage());
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", Schooltab);
	            success = true;
	        } catch (Exception e) {
	            System.out.println("Exception: " + e.getMessage());
	        }

	        if (!success) {
	            attempt++;
	            if (attempt < maxRetries) {
	                System.out.println("Retrying... Attempt " + (attempt + 1));
	            } else {
	                throw new RuntimeException("Failed to click on Schooltab after " + maxRetries + " attempts.");
	            }
	        }
	    }
	}

	public void Classroomtab()
	{
		wait.elementToBeClickable(Classroomtab);
		wait.visibilityOf(Classroomtab);
		Classroomtab.click();
	}
	public void Sectiontab()
	{
		wait.elementToBeClickable(Sectiontab);
		wait.visibilityOf(Sectiontab);
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
	    ExtentCucumberAdapter.addTestStepLog(SchoolName);
		cp.Name(SchoolName);				
		Description.sendKeys(generateRandomString());
	}
	public void ClassroomDetails()
	{
		ClassroomName="FPK12Classroom"+randomNumberGenerator();
		cp.Name(ClassroomName);
		StaticWait(2);
		ExtentCucumberAdapter.addTestStepLog(ClassroomName);
		Description.sendKeys(generateRandomString());
	}
	public void SectionDetails()
	{
		SectionName="FPK12Section"+randomNumberGenerator();
		
		cp.Name(SectionName);
		
		ExtentCucumberAdapter.addTestStepLog(SectionName);
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
		ExtentCucumberAdapter.addTestStepLog(String.valueOf(DLastName));
	}
	public void TUserSearch()
	{
		cp.searchField(String.valueOf(TLastName));
		ExtentCucumberAdapter.addTestStepLog(String.valueOf(TLastName));
	}
	public void SUserSearch()
	{
		cp.searchField(String.valueOf(SLastName));
		//System.out.println(SLastName);
		ExtentCucumberAdapter.addTestStepLog(String.valueOf(SLastName));
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
		StaticWait(2);
		Districtusertab.click();
	}
	public void TeacherTab()
	{
		wait.elementToBeClickable(Teachertab);
		StaticWait(2);
		Teachertab.click();
	}
	public void StudentTab()
	{
		wait.elementToBeClickable(Studenttab);
		StaticWait(2);
		Studenttab.click();
	}
	public void SettingsAdd()
	{
		StaticWait(1);
		Settingsadd.click();
		StaticWait(1);
	}
	public void AddNewDistrictUser()
	{
		StaticWait(1);
		AddnewDistrictUserbtn.click();
	}
	public void AddNewTeacher()
	{
		AddnewTeacherbtn.click();
		StaticWait(2);
	}
	public void AddNewStudent()
	{
		AddnewStudentbtn.click();
		StaticWait(2);
	}
	public void DistrictUserDetails(String UserRole)
	{
		wait.elementToBeClickable(Emailfield);
		wait.visibilityOf(Emailfield);
		StaticWait(1);
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
		StaticWait(1);
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
		StaticWait(1);
		Emailfield.sendKeys(randomEmailIdGenerator(UserRole).toLowerCase());
		SFirstName="FPK12Student".toLowerCase();
		FirstnameField.sendKeys(SFirstName);
		SLastName=randomNumberGenerator();
		LastnameField.sendKeys(String.valueOf(SLastName));
	}
	public void EditScreen() {
	    int attempts = 0;
	    while (attempts++ < 5) {
	        try {
	        	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.elementToBeClickable(Ellipses)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(Editoption)).click();
	            return; 
	        } catch (Exception e) {
	            if (attempts < 5) try { Thread.sleep(500); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
	        }
	    }
	    throw new RuntimeException("Failed to perform EditScreen action after 5 attempts.");
	}


	public void CreateNewLogin()
	{
		wait.elementToBeClickable(CreateNewLoginbtn);
		CreateNewLoginbtn.click();
	}
	public void ResetPwd()
	{
		StaticWait(2);
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
		try {
		    StaticWait(2);
		    wait.elementToBeClickable(Ellipses);
		    StaticWait(2);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click()", Ellipses);
		} catch (Exception e) {
		    try {
		        // Alternative XPath if the first one fails
		        WebElement alternateElement = driver.findElement(By.xpath("//*[text()='more_vert']/parent::span/parent::button"));
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].click()", alternateElement);
		    } catch (Exception innerException) {
		        System.out.println("Both attempts to click the element failed: " + innerException.getMessage());
		        // Optionally log the full stack trace or take further action
		    }
		}

		StaticWait(2);
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
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", Closeicon);

	}

	public void SettingClassroom() {
	    int maxRetries = 3;
	    int attempt = 0;
	    boolean success = false;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    while (attempt < maxRetries && !success) {
	        try {
	            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SettingsClassroomtab));
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", element);
	            success = true;
	        } catch (StaleElementReferenceException e) {
	            System.out.println("StaleElementReferenceException: " + e.getMessage());
	            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SettingsClassroomtab));
	            Actions a=new Actions(driver);
	            a.moveToElement(element).click().build().perform();
	        } catch (Exception e) {
	            System.out.println("Exception: " + e.getMessage());
	        }
	        if (!success) {
	            attempt++;
	            if (attempt < maxRetries) {
	                System.out.println("Retrying... Attempt " + (attempt + 1));
	            } else {
	                throw new RuntimeException("Failed to click on SettingsClassroomtab after " + maxRetries + " attempts.");
	            }
	        }
	    }
	}

	public void insertData() throws Exception
	{
		String filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "ExcelFiles", "LoginDetails.xlsx").toString();
		cp.InsertdataIntoExcel(filePath, getSheetEnv(), SchoolName, ClassroomName, SectionName);
	}
	public void insertUsersData() throws Exception
	{
		String filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "ExcelFiles", "LoginDetails.xlsx").toString();
		cp.InsertmultipledataIntoExcel(filePath, getSheetEnv());
	}
}
