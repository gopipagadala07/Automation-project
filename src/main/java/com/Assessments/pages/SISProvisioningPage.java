package com.Assessments.pages;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
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
import com.Utils.CommonPages;
import com.Utils.Wait;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class SISProvisioningPage extends ActionType{

	CommonPages cp=new CommonPages(Base.getDriver());
	JavascriptExecutor js=(JavascriptExecutor) Base.getDriver();
	private WebDriver driver;
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
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@placeholder='TimeZone']/descendant::mat-form-field/child::div")private WebElement TimeZoneDropdown;

	/*
	 * Classroom Creation
	 */
	@FindBy(how=How.XPATH,using = "(//div[@role='tab']/child::div)[5]")private WebElement Classroomtab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New Classroom')]")private WebElement AddnewClassroombtn;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@controlname='school']/descendant::mat-form-field/child::div")private WebElement SchoolDropDown;
	/*
	 * Section Creation
	 */
	//private WebElement listofTabs=By.xpath("//div[@role='tablist']/div/div");
	@FindBy(how=How.XPATH,using = "(//div[@role='tab']/child::div)[4]")private WebElement Sectiontab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New Section')]")private WebElement AddnewSectionbtn;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@controlname='year']/descendant::mat-form-field/child::div")private WebElement YearDropDown;
	@FindBy(how = How.XPATH,using = "//div[@role='alert']")private WebElement Alertsection;

	/*
	 * Districtuser Creation
	 */
	@FindBy(how=How.XPATH,using = "(//div[@role='tab']/child::div)[3]")private WebElement Districtusertab;
	@FindBy(how=How.XPATH,using = "//span[text()= ' Add New User ']")private WebElement AddnewDistrictUserbtn;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[1]")private WebElement Emailfield;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[2]")private WebElement FirstnameField;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[3]")private WebElement LastnameField;
	@FindBy(how=How.XPATH,using = "//mat-icon[text()='more_vert']") private WebElement Ellipses;
	@FindBy(how=How.XPATH,using = "//span[text()='Edit']")private WebElement Editoption;
	@FindBy(how=How.XPATH,using = "//span[text()=' Create New Login ']")private WebElement CreateNewLoginbtn;
	@FindBy(how=How.XPATH,using = "//span[text()=' Reset Password ']")private WebElement resetpwdbtn;
	@FindBy(how=How.XPATH,using = "//span[(text()=' Reset ')]")private WebElement Confirmationresetbtn;
	@FindBy(how = How.XPATH,using = "//button[text()='Cancel']/parent::div/button[1]")private WebElement resetpopup;

	/*
	 * Teacher Creation
	 */
	@FindBy(how=How.XPATH,using = "(//div[@role='tab']/child::div)[2]")private WebElement Teachertab;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New Teacher')]")private WebElement AddnewTeacherbtn;
	@FindBy(how=How.XPATH,using = "//span[text()='Settings']")private WebElement Settingsoptions;
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Is District Admin ')]/mat-checkbox")private WebElement IsDistrcitAdminchkbox;
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Is Scorer ')]/mat-checkbox")private WebElement Speedgraderchkbox;
	@FindBy(how=How.XPATH,using = "//mat-icon[contains(text(),'close')]")private WebElement Closeicon;
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Manage User')]/parent::div/following::div[1]/div")private WebElement SettingsClassroomtab;
	@FindBy(how=How.XPATH,using = "//span[(text()=' Add ')]")private WebElement Settingsadd;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@controlname='classroom']/descendant::mat-form-field/child::div")private WebElement ClassroomDown;
	@FindBy(how = How.XPATH,using = "//fp-dropdown[@controlname='section']/descendant::mat-form-field/child::div")private WebElement SectionDown;

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
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Sectiontab));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Sectiontab);
	}
	public void SchoolDropDownSearch()
	{
		wait.elementToBeClickable(SchoolDropDown);
		cp.FPdropdown(SchoolDropDown,SISProvisioningPage.SchoolName);
	}
	public void YearDropDownSearch(String Year)
	{
		for(int retry=0;retry<3;retry++)
		{
			try {
				cp.FPdropdown(YearDropDown, Year);
				break;
			} catch (StaleElementReferenceException e) {
				retry++;
			}
		}
	}
	public void ClassroomDropDownSearch() {
	    boolean success = false;
	    for (int retry = 0; retry < 3; retry++) {
	        try {
	        	StaticWait(1);
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement ClassroomDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//fp-dropdown[@controlname='classroom']/descendant::mat-form-field/child::div")));
	            StaticWait(1);
	            cp.FPdropdown(ClassroomDown, ClassroomName);
	            success = true;
	            break;
	        } catch (StaleElementReferenceException e) {
	            System.out.println("StaleElementReferenceException caught. Retrying... Attempt " + (retry + 1));
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException ie) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    }
	    if (!success) {
	        System.out.println("Operation failed after 3 retries.");
	    }
	}

	public void SectionDropDownSearch()
	{
		for(int retry=0;retry<3;retry++)
		{
			try {
				StaticWait(1);
				cp.FPdropdown(SectionDown, SectionName);
				break;
			} catch (StaleElementReferenceException e) {
				retry++;
			}
		}
	}
	public void SchoolDetails() throws Exception
	{
		SchoolName="FPK12School"+randomNumberGenerator();
		System.out.println(SchoolName);
		ExtentCucumberAdapter.addTestStepLog(SchoolName);
		cp.insertData("AssessmentCenterDetails.xlsx", SchoolName, 0);
		cp.Name(SchoolName);				
		Description.sendKeys(generateRandomString());
	}
	public void ClassroomDetails() throws Exception
	{
		ClassroomName="FPK12Classroom"+randomNumberGenerator();
		cp.Name(ClassroomName);
		ExtentCucumberAdapter.addTestStepLog(ClassroomName);
		cp.insertData("AssessmentCenterDetails.xlsx", ClassroomName, 1);
		Description.sendKeys(generateRandomString());
	}
	public void SectionDetails() throws Exception
	{
		try {
			SectionName="FPK12Section"+randomNumberGenerator();
			cp.Name(SectionName);
			ExtentCucumberAdapter.addTestStepLog(SectionName);
			cp.insertData("AssessmentCenterDetails.xlsx", SectionName, 2);
			Description.sendKeys(generateRandomString());
			StaticWait(2);
			cp.Save();
			StaticWait(1);
		} catch (Exception e) {
			
		}
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
	public void SectionSearch() throws Exception {
	    boolean sectionFound = false;
	    int maxAttempts = 5;
	    int attempts = 0;

	    while (!sectionFound && attempts < maxAttempts) { 
	    	cp.searchField(SectionName);
	        StaticWait(1);
	        WebElement e = driver.findElement(By.tagName("table"));
	        WebElement body = e.findElement(By.tagName("tbody"));
	        List<WebElement> rows = body.findElements(By.tagName("tr"));

	        for (WebElement row : rows) {
	            try {
	                List<WebElement> columns = row.findElements(By.tagName("td"));
	                String s = columns.get(0).getText();
	                //System.out.println(s);
	                if (s.equalsIgnoreCase(SectionName)) {
	                    System.out.println("Section Saved Successfully..!!");
	                    ExtentCucumberAdapter.addTestStepLog(s);
	                    sectionFound = true; 
	                    break; 
	                }
	            } catch (StaleElementReferenceException e2) {
	                
	            }
	        }

	        if (!sectionFound) { 
	            try {
	                AddNewSection();
	                SectionDetails();
	            } catch (StaleElementReferenceException e1) {
	          
	            }
	        }

	        attempts++;
	    }

	    if (!sectionFound) {
	        System.out.println("Section not found after " + maxAttempts + " attempts.");
	    }
	}
	
	public void DUserSearch()
	{
		cp.searchField(String.valueOf(DLastName));
		ExtentCucumberAdapter.addTestStepLog(String.valueOf(DLastName));
	}
	public void TUserSearch()
	{
		StaticWait(1);
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
		js.executeScript("arguments[0].click();", AddnewSchoolbtn);
	}
	public void AddNewClassroom()
	{
		js.executeScript("arguments[0].click();", AddnewClassroombtn);
	}

	public void AddNewSection()
	{
		js.executeScript("arguments[0].click();", AddnewSectionbtn);
	}
	public void DistrictUserTab()
	{
		wait.elementToBeClickable(Districtusertab);
		js.executeScript("arguments[0].click();", Districtusertab);
	}
	public void TeacherTab()
	{
		wait.elementToBeClickable(Teachertab);
		js.executeScript("arguments[0].click();", Teachertab);
	}
	public void StudentTab()
	{
		wait.elementToBeClickable(Studenttab);
		js.executeScript("arguments[0].click();", Studenttab);
	}
	public void SettingsAdd()
	{
		js.executeScript("arguments[0].click();", Settingsadd);
	}
	public void AddNewDistrictUser()
	{
		js.executeScript("arguments[0].click();", AddnewDistrictUserbtn);
	}
	public void AddNewTeacher()
	{
		js.executeScript("arguments[0].click();", AddnewTeacherbtn);
	}
	public void AddNewStudent()
	{
		js.executeScript("arguments[0].click();", AddnewStudentbtn);
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
	public void EditScreen() {
		for(int retry=0;retry<=5;retry++) {
			try {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-icon[text()='more_vert']")));
				wait.until(ExpectedConditions.visibilityOf(e));
				js.executeScript("arguments[0].click();", e);
				WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Edit']")));
				wait.until(ExpectedConditions.visibilityOf(e1));
				js.executeScript("arguments[0].click();", e1);
				break;
			} catch (RuntimeException e) {
				retry++;
			}
		}
	}


	public void CreateNewLogin()
	{
		wait.elementToBeClickable(CreateNewLoginbtn);
		js.executeScript("arguments[0].click();", CreateNewLoginbtn);
	}
	public void ResetPwd()
	{
		try {
			wait.elementToBeClickable(resetpwdbtn);
			resetpwdbtn.click();
			wait.elementToBeClickable(Confirmationresetbtn);
			Confirmationresetbtn.click();
			wait.elementToBeClickable(resetpopup);
			resetpopup.click();
			cp.Save();
		} catch (StaleElementReferenceException e) {
			
		}
	}

	public void Settings()
	{
		for(int retry=0;retry<=3;retry++)
		{
			try {
				wait.elementToBeClickable(Ellipses);
				StaticWait(2);
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-icon[text()='more_vert']")));
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", Ellipses);
				wait.until(ExpectedConditions.elementToBeClickable(Settingsoptions));
				js.executeScript("arguments[0].click();", Settingsoptions);
				StaticWait(1);
				break;
			}catch (StaleElementReferenceException e) {
				retry++;
			}
		}
	}
	public void Checkbox()
	{
		IsDistrcitAdminchkbox.click();
		wait.elementToBeClickable(Speedgraderchkbox);
		Speedgraderchkbox.click();
	}
	public void close() {
		wait.elementToBeClickable(Closeicon);
		for (int retry = 0; retry < 3; retry++) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(Closeicon));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", Closeicon);
				break;
			} catch (StaleElementReferenceException e) {
				retry++;
				if (retry == 3) {
					System.err.println("Element became stale after multiple attempts: " + e.getMessage());
				}
			} catch (TimeoutException e) {
				System.err.println("Element not clickable within the wait time: " + e.getMessage());
				break;
			} catch (Exception e) {
				System.err.println("An error occurred: " + e.getMessage());
				break;
			}
		}
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
				try {
					StaticWait(1);
					System.out.println("StaleElementReferenceException: " + e.getMessage());
					WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SettingsClassroomtab));
					Actions a=new Actions(driver);
					a.moveToElement(element).click().build().perform();
				} catch (StaleElementReferenceException e2) {
					System.out.println("Exception: " + e.getMessage());
				}
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
	public void insertUsersData() throws Exception
	{
		String filePath = Paths.get(System.getProperty("user.dir") + "/src/test/resources/ExcelFiles/AssessmentCenterDetails.xlsx").toString();
		cp.InsertmultipledataIntoExcel(filePath, getSheetEnv(),DFirstName,DLastName,TFirstName,TLastName,SFirstName,SLastName);
	}
}
