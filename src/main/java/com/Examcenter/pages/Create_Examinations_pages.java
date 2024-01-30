package com.Examcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Examcenter.Utils.ActionType;
public class Create_Examinations_pages extends ActionType {

	private By AddExambutton= By.xpath("//span[text()=' Add New Exam ']");

	private By Addicon=By.xpath("//mat-icon[text()='add']");
	//Creating a new Schedule
	private By AddnewSchedule=By.xpath("//span[text()=' Add New Schedule ']");
	//Enroll Exam to the Exam taker
	 private By Adminstrationbtn=By.xpath("//mat-icon[text()=' settings ']");
	private By Choosemonthandyear=By.xpath("//button[@aria-label='Choose month and year']");
	private By clickonExaminationdropdown=By.xpath("//h2[text()='Enrollment']/../following-sibling::mat-dialog-content/div/mat-form-field[1]");
	private By clickonScheduledropdown=By.xpath("//h2[text()='Enrollment']/../following-sibling::mat-dialog-content/div/mat-form-field[2]");
	private By clickonSearchTest=By.xpath("(//button[@type='button'])[6]");
	//Datepicker
	private By datepickerforEndsonfield=By.xpath("(//button[@aria-label='Open calendar'])[2]");
	private By Desktoptoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[12]");

	private WebDriver driver;
	private By EditExamname=By.xpath("//input[@type='text']");
	private By EditSave= By.xpath("//span[text()=' Save ']");
	private By EnrollmentSave=By.xpath("//span[text()=' Save ']");
	private By EnrollToAnExambutton=By.xpath("//button[@title='Enroll to an Exam']");
	private By EnterSchedulename=By.xpath("//input[@type='text']");
	//Create Examination
	//private By ChangepwdClose= By.xpath("//mat-icon[text()='close']");
	private By ExamAdministrationtab= By.xpath("//span[text()='Exam Administration']");
	private By ExamDescription=By.xpath("//div[@role='textbox']");
	private By ExamEdit=By.xpath("//mat-icon[text()='edit']");
	private By ExaminationSearchhere=By.xpath("//input[@type='search']");
	//dropdown
	private By Generaldropdown=By.xpath("//fp-textbox[@placeholder='Name']/../following-sibling::mat-form-field/div/div");
	private By Goicon=By.xpath("//span[text()=' Go ']");
	private By InvigilatorTokentoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[6]");
	private By Nametextfield= By.xpath("//input[@type='text']");
	//Ckeditors
	private By OnlineTestingInstructions=By.xpath("(//div[@class='ck-restricted-editing_mode_standard ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline'])[1]");
	private By PrintFormInstructions=By.xpath("(//div[@class='ck-restricted-editing_mode_standard ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline'])[2]");
	private By provisioning=By.xpath("//a[text()='Provisioning']");
	private By Savebutton= By.xpath("//span[text()=' Save ']");
	private By ScheduleDescription=By.xpath("//div[@class='ck-restricted-editing_mode_standard ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline']");
	private By ScheduleSave=By.xpath("//span[text()=' Save ']");
	//private By Userstab=By.xpath("//div[text()='USERS']"); 
	private By SearchExamtaker= By.xpath("//input[@type='search']");
	private By SearchTestName=By.xpath("//input[@form='pageIndex']");

	private By SelectPretestdropdown=By.xpath("//span[text()='Pre-Test']");
	 private By ShowAnswerstoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[9]");
	private By ShowTestAnalysistoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[10]");
	//toggles
	private By ShowTestResultToStudenttoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[5]");
	private By ShuffleChoicestoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[8]");
	private By ShuffleTestQuestionstoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[7]");
	//Mode toggles
	private By Tablettoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[11]");


	public Create_Examinations_pages(WebDriver driver) {
		this.driver=driver;
	}

	public void Add_Exam() {
		StaticWait(1);
		driver.findElement(AddExambutton).click();
	}
	//Creating a new Schedule
	public void Add_new_Schedule() {
		StaticWait(1);
		driver.findElement(AddnewSchedule).click();

	}
	//Enroll Exam to the Examtaker
	public void Adminstarationbtn()
    {
		StaticWait(2);
		waitForElement(Adminstrationbtn);
    	driver.findElement(Adminstrationbtn).click();
    	StaticWait(1);
    }
	public void All_toggles() {
		driver.findElement(ShowTestResultToStudenttoggle).click();
		//driver.findElement(InvigilatorTokentoggle).click();
		driver.findElement(ShuffleTestQuestionstoggle).click();
		driver.findElement(ShuffleChoicestoggle).click();
		driver.findElement(ShowAnswerstoggle).click();
		driver.findElement(ShowTestAnalysistoggle).click();
		//driver.findElement(Tablettoggle).click();
		//driver.findElement(Desktoptoggle).click();	
	}
	public void Ck_editor_texts(String onlineInstructions, String printforminstruction, String scheduledescription) {
		driver.findElement(OnlineTestingInstructions).sendKeys(onlineInstructions);
		driver.findElement(PrintFormInstructions).sendKeys(printforminstruction);
		driver.findElement(ScheduleDescription).sendKeys(scheduledescription);
	}
	public void click_on_datepicker() {
		driver.findElement(datepickerforEndsonfield).click();
		driver.findElement(Choosemonthandyear).click();
	}
	public void click_on_exam_dropdown() {
		StaticWait(1);
		driver.findElement(clickonExaminationdropdown).click();
	}
	public void click_on_Schedule_dropdown() {
		waitForPageLoad();
		StaticWait(1);
		driver.findElement(clickonScheduledropdown).click();
	}
	public void click_on_searched_examtaker(String Lastnametext, String Firstnametext) {
		StaticWait(2);
		WebElement EN=driver.findElement(By.xpath("//span[text()='"+Lastnametext+" "+Firstnametext+"']"));
		Actions a=new Actions(driver);
		a.moveToElement(EN).click().build().perform();
	}

	public void Date_picker(String Yeartext,String Monthtext,String Datetext) {
		StaticWait(2);
		WebElement y=driver.findElement(By.xpath("//div[text()=' "+Yeartext+" ']"));
		y.click();
		WebElement m=driver.findElement(By.xpath("//div[text()=' "+Monthtext+" ']"));
		m.click();
		WebElement d=driver.findElement(By.xpath("//div[text()=' "+Datetext+" ']"));
		d.click();

	}
	public void Dropdowns() {
		driver.findElement(Generaldropdown).click();
		driver.findElement(SelectPretestdropdown).click();
	}
	public void Edit_Examinations() {
		driver.findElement(ExamEdit).click();
	}
	public void Edit_Examname(String editexamnametxtfield ) {

		WebElement E1= driver.findElement(EditExamname);
		E1.click();
		E1.clear();
		E1.sendKeys(editexamnametxtfield);
	}
	public void Edit_Save_button() {
		driver.findElement(EditSave).click();
	}
	public void Enroll_To_An_Exam() {
		StaticWait(1);
		driver.findElement(EnrollToAnExambutton).click();
	}
	public void enrollment_save() {
		//waitForPageLoaded(1);
		StaticWait(1);
		driver.findElement(EnrollmentSave).click();
		StaticWait(1);
		//driver.quit();
	}
	public void Enter_Schedule_name(String ScheduleName) {
		StaticWait(1);
		driver.findElement(EnterSchedulename).sendKeys(ScheduleName);
	}
	public void Exam_Administration() {
		waitForElement(ExamAdministrationtab);
		waitForPageLoad();
		StaticWait(1);
		driver.findElement(ExamAdministrationtab).click();
	}
	public void Exam_Description(String examdescription) {
		driver.findElement(ExamDescription).sendKeys(examdescription);
	}
	public void Exam_name_field(String examnametxtfield) {
		StaticWait(1);
		driver.findElement(Nametextfield).sendKeys(examnametxtfield);
	}

	public void Exam_Search_here(String searchexamnamefield,String ExamName ) {
		StaticWait(2);			
		driver.findElement(ExaminationSearchhere).sendKeys(searchexamnamefield);
		StaticWait(1);
		WebElement e=driver.findElement(By.xpath("//span[text()='"+ExamName+"']"));
		e.click();

	}

	public void Examtaker_search(String Lastnametext, String Firstnametext) {
		waitForElement(SearchExamtaker);
		WebElement e = driver.findElement(SearchExamtaker);
		JavascriptExecutor j=(JavascriptExecutor)getDriver();
		j.executeScript("arguments[0].click()", e);
		StaticWait(2);
		e.sendKeys(Lastnametext+" ");
		StaticWait(1);
		e.sendKeys(Firstnametext);
	}
    public void icons_Action() {
		StaticWait(1);
		driver.findElement(Goicon).click();
		StaticWait(2);
		driver.findElement(Addicon).click();
	}
	
	public void provisioning()
    {
    	waitForElement(provisioning);
    	driver.findElement(provisioning).click();
    }
//	public void click_on_Users_tab() {
//		waitForElement(Userstab);
//    	driver.findElement(Userstab).click();
//	}
	//published and examlive toggles
	public void published_Examlive_toggle(String ScheduleName) {
		WebElement publishedtoggle=driver.findElement(By.xpath("//div[text()='"+ScheduleName+"']/../div/div/div[2]/mat-slide-toggle/label/span[1]/input"));
		Actions a=new Actions(driver);
		a.moveToElement(publishedtoggle).build().perform();
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()",publishedtoggle);
		StaticWait(3);
		WebElement Examlivetoggle=driver.findElement(By.xpath("//div[text()='"+ScheduleName+"']/../div/div/div[1]/mat-slide-toggle/label/span[1]/input"));
		a.moveToElement(Examlivetoggle).build().perform();
		j.executeScript("arguments[0].click()",Examlivetoggle);	
		StaticWait(1);
	}
	
	public void Save_button() {
		driver.findElement(Savebutton).click();
	}
	
	public void schedulesave() {
		StaticWait(1);
		driver.findElement(ScheduleSave).click();
		waitForPageLoad();
		StaticWait(3);
	}
	public void Search_Test_button() {
		StaticWait(2);
		driver.findElement(clickonSearchTest).click();
	}
	public void Search_test_name(String TestName) {
		driver.findElement(SearchTestName).sendKeys(TestName);
	}
	public void select_examinations_lookup(String examname) {
		WebElement Elookup=driver.findElement(By.xpath("//span[text()=' "+examname+" ']"));
//		JavascriptExecutor j=(JavascriptExecutor) driver;
//		j.executeScript("arguments[0].click()",Elookup);	
		Elookup.click();
	}
	public void select_schedule_lookup(String schedulename) {
		WebElement Slookup=driver.findElement(By.xpath("//span[text()=' "+schedulename+" ']"));
		Slookup.click();
	}

}
