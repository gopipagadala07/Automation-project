package com.Assessments.pages;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;

public class BenchmarksPage extends ActionType {

	CommonPages cp=new CommonPages(Base.getDriver());
	static String BenchMarkname;
	static String Testname;
	public WebDriver driver;
	private Wait wait;

	/*
	 * Benchmarks Creation
	 * 
	 */

	@FindBy(how=How.XPATH,using = "//span[contains(text(),'District')]") private WebElement DistrictBtn;

	@FindBy(how=How.XPATH,using = "//a[text()='Benchmarks']") private WebElement BenchmarksBtn;
	@FindBy(how=How.XPATH,using="//fp-dropdown[@controlname='year']")private WebElement yeardropdown;
	@FindBy(how=How.XPATH,using="//fp-dropdown[@controlname='grade']")private WebElement gradedropdown;
	@FindBy(how=How.XPATH,using="//fp-dropdown[@controlname='subject']")private WebElement subjectdropdown;
	@FindBy(how=How.XPATH,using = "//span[contains(text(), 'Add New Benchmark')]") private WebElement AddNewBenchmarkBtn;
	@FindBy(how=How.XPATH,using="//fp-textbox[@placeholder='Name']/div/mat-form-field/div/div/div/input") private WebElement BenchmarkNameField; 
	@FindBy(how=How.XPATH,using="(//div[text()='DETAIL']/following::p[@data-placeholder='Type here'])[1]")private WebElement DescriptionFld;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='find_in_page']")private WebElement FindTestBtn;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='add']")private WebElement Addicon; // Find test>>Add icon
	@FindBy(how=How.XPATH,using="//span/following::span[text()='Show Answers']")private WebElement ShowAnsCheckBoxes;//Show Answers
	@FindBy(how=How.XPATH,using="//span/following::span[text()='Override General Instructions']")private WebElement GeneralIns;//Override general instructions
	@FindBy(how=How.XPATH,using="//span/following::span[text()=' Show Test Summary ']")private WebElement TestSummary;//Show Test Summary
	@FindBy(how=How.XPATH,using="//span/following::span[text()=' Show Test Analytics ']")private WebElement TestAnalytics;//Show Test Analytics
	@FindBy(how=How.XPATH,using="//mat-icon[text()='publish']")private WebElement publishbutton;
	@FindBy(how=How.XPATH,using="//span[text()=' Go ']")private WebElement gobutton;
	@FindBy(how=How.XPATH,using="//div/following::button[text()='Yes']")private WebElement PopUp;//Click on yes (popup
	@FindBy(how=How.XPATH,using="//mat-icon[text()='save']")private WebElement savebutton;
	@FindBy(how=How.XPATH,using="//div[contains(text(),'SECTIONS')]")private WebElement sectionstab;
	@FindBy(how=How.XPATH,using="//a[text()=' Add ']")private WebElement clickonAddSectionbutton;
	@FindBy(how=How.XPATH,using="//div[text()='DETAIL']")private WebElement ClickonDetailtab;

/*
 * Test Administration
 */
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Test Administration')] ")private WebElement TestAdministrationTab;
	@FindBy(how=How.XPATH,using="//mat-select[@formcontrolname='benchmark']/parent::div/parent::div/..")private WebElement CourseBenchmarkDropDown;
	@FindBy(how=How.XPATH,using="//fp-dropdown[@controlname='school']")private WebElement SchoolDropdown;
	@FindBy(how=How.XPATH,using="//fp-dropdown[@controlname='teacher']")private WebElement TeacherDropdown;
	@FindBy(how=How.XPATH,using="//fp-dropdown[@controlname='classroomID']")private WebElement ClassroomdropDown;
	@FindBy(how=How.XPATH,using="//span[contains(text(),' Activate all test status. ')] ")private WebElement ToggleActive;

	@FindBy(how=How.XPATH,using="//mat-label[contains(text(),'Status')]/following::span[contains(text(),'Not Started')]")private WebElement NotStartedStatus;
	@FindBy(how=How.XPATH,using="//mat-label[contains(text(),'Status')]/following::span[contains(text(),'In Progress')]")private WebElement InProgressStatus;
    @FindBy(how=How.XPATH,using="//mat-label[contains(text(),'Status')]/following::span[contains(text(),'In Review')]")private WebElement InReviewStatus;
	@FindBy(how=How.XPATH,using="//mat-label[contains(text(),'Status')]/following::span[contains(text(),'Completed')]")private WebElement CompletedStatus;
	@FindBy(how=How.XPATH,using="//mat-icon[contains(text(),'settings_backup_restore')]/parent::span")private WebElement ResetButton;
	
	@FindBy(how=How.XPATH,using="//li[text()='Benchmark Test Administration']")private WebElement BEnchmarkTD;// click on benchmark test administration

	public WebElement NewBenchmarkName(String BenchMarkname) {
		String xpath = "//a[contains(text(), '"+BenchMarkname+"')]";
		return driver.findElement(By.xpath(xpath));
	}
	public WebElement clickonAddSectionbutton(String SectionName) {
		String xpath = "//span[text()='"+SectionName+"']/parent::div/parent::div/following-sibling::div/a";
		return driver.findElement(By.xpath(xpath));
	}
	public void clickOnNewBencmark() {
		NewBenchmarkName(BenchMarkname).click();
	}
	public BenchmarksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}

	public void Disttab() {
		wait.elementToBeClickable(DistrictBtn);
		DistrictBtn.click();
		
	}
	public void benchmarkstab() {
		wait.elementToBeClickable(BenchmarksBtn);
		BenchmarksBtn.click();
	}

	public void gradedropdowns(String gradeddown) {
		wait.elementToBeClickable(gradedropdown);		
		cp.FPdropdown(gradedropdown, gradeddown);
		
	}

	public void subdropdowns(String subddown) {
		
		wait.elementToBeClickable(subjectdropdown);
		StaticWait(1);
		cp.FPdropdown(subjectdropdown, subddown);
//		Actions a2=new Actions(driver);
//		a2.moveToElement(BEnchmarkTD);
//		a2.click();
//		a2.perform();
	}
	public void yeardropdowns(String yearddown) {
		wait.elementToBeClickable(yeardropdown);
		cp.FPdropdown(yeardropdown, yearddown);
		//StaticWait(2);

	}
	public void AddBenchmark() {
		try {
			wait.visibilityOf(AddNewBenchmarkBtn);
			wait.elementToBeClickable(AddNewBenchmarkBtn);
			StaticWait(1);

			Actions a=new Actions(driver);
			a.moveToElement(AddNewBenchmarkBtn);
			a.click();
			a.perform();
		} catch (Exception e) {
			System.out.println("e");
		}

	}

	public void checkboxes() {
		wait.visibilityOf(ShowAnsCheckBoxes);
		ShowAnsCheckBoxes.click();
		GeneralIns.click();
		TestSummary.click();
		TestAnalytics.click();
	}
	public void BenchmarkName() {
		wait.visibilityOf(BenchmarkNameField);
		BenchMarkname="AutoBenchmark"+randomNumberGenerator();
		BenchmarkNameField.sendKeys(BenchMarkname);
		System.out.println(BenchMarkname);
		DescriptionFld.sendKeys(generateRandomString());

	}
	public void savebutton() {
		cp.Savebtn.click();
	}
	public void findtest() {
		wait.elementToBeClickable(FindTestBtn);
		FindTestBtn.click();
	}

	public void testSearch(String Testname) {
		String testname="\"" + Testname + "\"";
		System.out.println(testname);
		cp.searchField(testname);
		wait.elementToBeClickable(gobutton);
		gobutton.click();
	}
	public void addicon() {

		Addicon.click();
	}

	public void publishBtn() {
		StaticWait(1);
		publishbutton.click();
	}
	public void yesbutton() {
		StaticWait(1);
		PopUp.click();
		StaticWait(1);
	}
	public void savebuttonn() {
		savebutton.click();
		StaticWait(1);
	}
	public void clickOnSectionTab() {
		wait.visibilityOf(sectionstab);
		wait.elementToBeClickable(sectionstab);
		StaticWait(2);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", sectionstab);

	}

	public void clickOnAdd(String SectionName) {

		wait.elementToBeClickable(clickonAddSectionbutton(SectionName));
		Actions a=new Actions(driver);
		a.moveToElement(clickonAddSectionbutton(SectionName));
		a.click();
		a.perform();
	}

	/*
	 * Test Administration
	 */

public void testAdminTab() {
	wait.elementToBeClickable(TestAdministrationTab);
	TestAdministrationTab.click();
}
	public void CourseBenchmarkDdown(String SectionName) {
		wait.elementToBeClickable(CourseBenchmarkDropDown);	
			 
		cp.FPdropdown(CourseBenchmarkDropDown, SectionName+""+" - "+BenchmarksPage.BenchMarkname);
		System.out.println(SectionName+""+" - "+BenchmarksPage.BenchMarkname);
//		
//		if(CourseBenchmarkDropDown.)
//		
		
	}


	public void schoolDdown(String schooldrop) {
		wait.elementToBeClickable(SchoolDropdown);
		cp.FPdropdown(SchoolDropdown, schooldrop);
	}

	public void teacherDdown(String teacherdrop) {
		wait.elementToBeClickable(TeacherDropdown);
		cp.FPdropdown(TeacherDropdown, teacherdrop);
	}

	public void classroomDdown(String classroomdown) {
		wait.elementToBeClickable(ClassroomdropDown);
		cp.FPdropdown(ClassroomdropDown, classroomdown);
	}


	public void ActiveToggle() {
		wait.elementToBeClickable(ToggleActive);
		ToggleActive.click();
	}
	public void CheckingStatus() {
		wait.visibilityOf(NotStartedStatus);
		wait.visibilityOf(InProgressStatus);
		wait.visibilityOf(InReviewStatus);
		wait.visibilityOf(CompletedStatus);
		if (CompletedStatus.isDisplayed()) {
		    StaticWait(1);
		    wait.elementToBeClickable(ResetButton);
		    ResetButton.click();
		} else {
		    System.out.println(NotStartedStatus.isDisplayed() ? "Not Started" :
		                       InProgressStatus.isDisplayed() ? "In Progress" :
		                       InReviewStatus.isDisplayed() ? "In Review" : "No active status");
		}
	}


}
