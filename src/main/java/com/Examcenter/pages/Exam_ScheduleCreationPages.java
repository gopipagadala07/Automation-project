package com.Examcenter.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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

public class Exam_ScheduleCreationPages extends ActionType{
	private Wait wait;
	static String ScheduleName;
	static String ExamName;
	private WebDriver driver;
	CommonPages cp=new CommonPages(Base.getDriver());
	JavascriptExecutor j=(JavascriptExecutor) Base.getDriver();
	Actions a=new Actions(Base.getDriver());

	@FindBy(how=How.XPATH,using="//span[text()=' Add New Exam ']")private WebElement AddExambutton;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='add']")private WebElement Addicon;
	@FindBy(how=How.XPATH,using="//span[text()=' Add New Schedule ']")private WebElement AddnewSchedule;
	@FindBy(how=How.XPATH,using="//mat-icon[text()=' settings ']")private WebElement Adminstrationbtn;
	@FindBy(how=How.XPATH,using="//button[@aria-label='Choose month and year']")private WebElement Choosemonthandyear;
	@FindBy(how=How.XPATH,using="//mat-label[text()='Examination']/ancestor::span/preceding-sibling::mat-select/ancestor::mat-form-field/child::div")private WebElement clickonExaminationdropdown;
	@FindBy(how=How.XPATH,using="//mat-label[text()='Schedule']/ancestor::span/preceding-sibling::mat-select/ancestor::mat-form-field/child::div")private WebElement clickonScheduledropdown;
	@FindBy(how=How.XPATH,using="//button[@id='btnNewTestAdmin']")private WebElement clickonSearchTest;
	@FindBy(how=How.XPATH,using="(//button[@aria-label='Open calendar'])[2]")private WebElement datepickerforEndsonfield;
	@FindBy(how=How.XPATH,using="//input[@type='text']")private WebElement Examname;
	@FindBy(how=How.XPATH,using="//button[@title='Enroll to an Exam']")private WebElement EnrollToAnExambutton;
	@FindBy(how=How.XPATH,using="//input[@type='text']")private WebElement EnterSchedulename;
	@FindBy(how=How.XPATH,using="//span[text()='Exam Administration']")private WebElement ExamAdministrationtab;
	@FindBy(how=How.XPATH,using="//div[@role='textbox']")private WebElement ExamDescription;
	@FindBy(how=How.XPATH,using="//fp-textbox[@placeholder='Name']/../following-sibling::mat-form-field/div/div")private WebElement Generaldropdown;
	@FindBy(how=How.XPATH,using="//span[text()=' Go ']")private WebElement Goicon;
	@FindBy(how=How.XPATH,using="(//span[@class='mat-slide-toggle-bar'])[6]")private WebElement InvigilatorTokentoggle;
	@FindBy(how=How.XPATH,using="(//div[@role='textbox'])[1]")private WebElement OnlineTestingInstructions;
	@FindBy(how=How.XPATH,using="(//div[@role='textbox'])[3]")private WebElement PrintFormInstructions;
	@FindBy(how=How.XPATH,using="//a[text()='Provisioning']")private WebElement provisioning;
	@FindBy(how=How.XPATH,using="(//div[@role='textbox'])[2]")private WebElement ScheduleDescription;
	@FindBy(how=How.XPATH,using="//span[text()='Pre-Test']")private WebElement SelectPretestdropdown;
	@FindBy(how=How.XPATH,using="(//span[@class='mat-slide-toggle-bar'])[9]")private WebElement ShowAnswerstoggle;
	@FindBy(how=How.XPATH,using="(//span[@class='mat-slide-toggle-bar'])[10]")private WebElement ShowTestAnalysistoggle;
	@FindBy(how=How.XPATH,using="(//span[@class='mat-slide-toggle-bar'])[5]")private WebElement ShowTestResultToStudenttoggle;
	@FindBy(how=How.XPATH,using="(//span[@class='mat-slide-toggle-bar'])[8]")private WebElement ShuffleChoicestoggle;
	@FindBy(how=How.XPATH,using="(//span[@class='mat-slide-toggle-bar'])[7]")private WebElement ShuffleTestQuestionstoggle;
	public WebElement TestAddbtn(String TestnameAdd) {
		String xpath = "//span[text()='"+TestnameAdd+"']/parent::div/parent::div/preceding-sibling::div/child::div[2]/child::div[1]/child::button";
		return driver.findElement(By.xpath(xpath));
	}

	public Exam_ScheduleCreationPages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void Add_Exam() {
		wait.elementToBeClickable(AddExambutton);
		AddExambutton.click();
	}

	public void Add_new_Schedule() {
		wait.elementToBeClickable(AddnewSchedule);
		AddnewSchedule.click();
	}

	public void Adminstarationbtn()
	{
		wait.elementToBeClickable(Adminstrationbtn);
		Adminstrationbtn.click();
	}
	public void All_toggles() {
		ShowTestResultToStudenttoggle.click();
		//InvigilatorTokentoggle.click();
		ShuffleTestQuestionstoggle.click();
		ShuffleChoicestoggle.click();
		ShowAnswerstoggle.click();
		ShowTestAnalysistoggle.click();
		//Desktoptoggle.click();	
	}
	public void Ck_editor_texts() {

		OnlineTestingInstructions.sendKeys(generateRandomString());
		ScheduleDescription.sendKeys(generateRandomString());
		j.executeScript("arguments[0].scrollIntoView()", PrintFormInstructions);
		PrintFormInstructions.sendKeys(generateRandomString());
	}
	public void Examsearch()
	{
		System.out.println(Exam_ScheduleCreationPages.ExamName);
		cp.searchField(Exam_ScheduleCreationPages.ExamName);
	}
	public void click_on_datepicker() {
		cp.getRandomDate(datepickerforEndsonfield);
	}
	public void click_on_searched_examtaker(String Lastnametext, String Firstnametext) {
	    int retry = 0;
	    int maxretry = 5;
	    boolean success = false; 

	    while (retry < maxretry) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	            WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + Lastnametext + " " + Firstnametext + "']")));
	            wait.until(ExpectedConditions.elementToBeClickable(e));
	            j.executeScript("arguments[0].click();", e);
	            success = true;
	            break;
	        } catch (StaleElementReferenceException e) {
	            retry++;
	            System.out.println("StaleElementReferenceException caught, retrying... " + retry);
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException ie) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    }

	    if (!success) {
	        throw new RuntimeException("Failed to click on the searched examtaker after " + maxretry + " attempts.");
	    }
	}


	public void Dropdowns() {
		Generaldropdown.click();
		SelectPretestdropdown.click();
	}
	public void Enroll_To_An_Exam() {
		wait.elementToBeClickable(EnrollToAnExambutton);
		EnrollToAnExambutton.click();
	}
	public void Enter_Schedule_name() throws Exception {
		wait.elementToBeClickable(EnterSchedulename);
		ScheduleName="FPK12Schedule"+randomNumberGenerator();
		EnterSchedulename.sendKeys(ScheduleName);
		ExtentCucumberAdapter.addTestStepLog(ScheduleName);
		cp.insertData("ExamCenterDetails.xlsx", ScheduleName, 8);
	}
	public void Exam_Administration() {
		wait.elementToBeClickable(ExamAdministrationtab);
		wait.visibilityOf(ExamAdministrationtab);
		j.executeScript("arguments[0].click();", ExamAdministrationtab);

	}
	public void Exam_Description() {
		ExamDescription.sendKeys(generateRandomString());
	}
	public void Exam_name_field() throws Exception {
		ExamName="FPK12Exam"+randomNumberGenerator();
		cp.Name(ExamName);
		ExtentCucumberAdapter.addTestStepLog(ExamName);
		cp.insertData("ExamCenterDetails.xlsx", ExamName, 7);
	}
	public void Exam_Search_here() {
		cp.searchField(ExamName);
		WebElement e=driver.findElement(By.xpath("//span[text()='"+ExamName+"']"));
		e.click();
	}

	public void Examtaker_search(String Lastnametext, String Firstnametext) {
		cp.searchField(Lastnametext+" "+Firstnametext);
	}
	public void icons_Action(String TestName) {
		wait.elementToBeClickable(Goicon);
		Goicon.click();
		StaticWait(1);
		wait.elementToBeClickable(TestAddbtn(TestName));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement testAddBtn = wait.until(ExpectedConditions.elementToBeClickable(TestAddbtn(TestName)));
		js.executeScript("arguments[0].click();", testAddBtn);
	}

	public void provisioning()
	{
		wait.elementToBeClickable(provisioning);
		provisioning.click();
	}
	public void published_Examlive_toggle() {
		WebElement publishedtoggle=driver.findElement(By.xpath("//div[text()='"+ScheduleName+"']/../div/div/div[2]/mat-slide-toggle/label/span[1]/input"));
		a.moveToElement(publishedtoggle).build().perform();
		j.executeScript("arguments[0].click()",publishedtoggle);
		WebElement Examlivetoggle=driver.findElement(By.xpath("//div[text()='"+ScheduleName+"']/../div/div/div[1]/mat-slide-toggle/label/span[1]/input"));
		wait.elementToBeClickable(Examlivetoggle);
		a.moveToElement(Examlivetoggle).build().perform();
		j.executeScript("arguments[0].click()",Examlivetoggle);	
		StaticWait(1);
	}
	public void clickonsearchTest()
	{
		clickonSearchTest.click();
	}
	public void Search_Test_button(String TestName) {
		String testname = "\"" + TestName + "\"";
		cp.SearchTestname(testname);
	}
	public void select_examinations_lookup(String value) {
		StaticWait(1);	
		for(int retry=0;retry<=3;retry++)
		{
			try {
				cp.FPdropdown(clickonExaminationdropdown, value);
				System.out.println(value);
				break;
			} catch (Exception e) {
				retry++;
			}
		}
	}
	public void select_schedule_lookup() {
		StaticWait(1);	
		cp.FPdropdown(clickonScheduledropdown, ScheduleName);
	}

}
