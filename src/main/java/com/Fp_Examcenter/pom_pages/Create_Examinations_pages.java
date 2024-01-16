package com.Fp_Examcenter.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Fp_Examcenter.Utils.ActionType;

public class Create_Examinations_pages extends ActionType {

	private WebDriver driver;

	//Create Examination
	//private By ChangepwdClose= By.xpath("//mat-icon[text()='close']");
	private By ExamAdministrationtab= By.xpath("//span[text()='Exam Administration']");
	private By AddExambutton= By.xpath("//span[text()=' Add New Exam ']");
	private By Nametextfield= By.xpath("//input[@type='text']");
	private By ExamDescription=By.xpath("//div[@role='textbox']");
	private By Savebutton= By.xpath("//span[text()=' Save ']");
	private By ExaminationSearchhere=By.xpath("//input[@type='search']");
	private By ExamEdit=By.xpath("//mat-icon[text()='edit']");
	private By EditExamname=By.xpath("//input[@type='text']");
	private By EditSave= By.xpath("//span[text()=' Save ']");

	//Creating a new Schedule
	private By AddnewSchedule=By.xpath("//span[text()=' Add New Schedule ']");
	private By clickonSearchTest=By.xpath("(//button[@type='button'])[6]");
	private By SearchTestName=By.xpath("//input[@form='pageIndex']");
	private By Goicon=By.xpath("//span[text()=' Go ']");
	private By Addicon=By.xpath("//mat-icon[text()='add']");
	private By EnterSchedulename=By.xpath("//input[@type='text']");
	//dropdown
	private By Generaldropdown=By.xpath("//fp-textbox[@placeholder='Name']/../following-sibling::mat-form-field/div/div");
	private By SelectPretestdropdown=By.xpath("//span[text()='Pre-Test']");
	//toggles
	private By ShowTestResultToStudenttoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[5]");
	private By InvigilatorTokentoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[6]");
	private By ShuffleTestQuestionstoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[7]");
	private By ShuffleChoicestoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[8]");
	private By ShowAnswerstoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[9]");
	private By ShowTestAnalysistoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[10]");
	//Mode toggles
	private By Tablettoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[11]");
	private By Desktoptoggle=By.xpath("(//span[@class='mat-slide-toggle-bar'])[12]");
	//Datepicker
	private By datepickerforEndsonfield=By.xpath("(//button[@aria-label='Open calendar'])[2]");
	private By Choosemonthandyear=By.xpath("//button[@aria-label='Choose month and year']");
	//Ckeditors
	private By OnlineTestingInstructions=By.xpath("(//div[@class='ck-restricted-editing_mode_standard ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline'])[1]");
	private By PrintFormInstructions=By.xpath("(//div[@class='ck-restricted-editing_mode_standard ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline'])[2]");
	private By ScheduleDescription=By.xpath("//div[@class='ck-restricted-editing_mode_standard ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline']");
	private By ScheduleSave=By.xpath("//span[text()=' Save ']");

	//Enroll Exam to the Exam taker
	 private By Adminstrationbtn=By.xpath("//mat-icon[text()=' settings ']");
	 private By provisioning=By.xpath("//a[text()='Provisioning']");
	//private By Userstab=By.xpath("//div[text()='USERS']"); 
	private By SearchExamtaker= By.xpath("//input[@type='search']");
	private By EnrollToAnExambutton=By.xpath("//button[@title='Enroll to an Exam']");
	private By clickonExaminationdropdown=By.xpath("//h2[text()='Enrollment']/../following-sibling::mat-dialog-content/div/mat-form-field[1]");
	private By clickonScheduledropdown=By.xpath("//h2[text()='Enrollment']/../following-sibling::mat-dialog-content/div/mat-form-field[2]");
	private By EnrollmentSave=By.xpath("//span[text()=' Save ']");


	public Create_Examinations_pages(WebDriver driver) {
		this.driver=driver;
	}

	public void Exam_Administration() {
		driver.findElement(ExamAdministrationtab).click();
	}
	public void Add_Exam() {
		driver.findElement(AddExambutton).click();
	}
	public void Exam_name_field(String examnametxtfield) {
		driver.findElement(Nametextfield).sendKeys(examnametxtfield);
	}
	public void Exam_Description(String examdescription) {
		driver.findElement(ExamDescription).sendKeys(examdescription);
	}
	public void Save_button() {
		driver.findElement(Savebutton).click();
	}
	public void Exam_Search_here(String searchexamnamefield ) {
		StaticWait(2);
		driver.findElement(ExaminationSearchhere).sendKeys(searchexamnamefield);

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

	//Creating a new Schedule
	public void Add_new_Schedule() {
		driver.findElement(AddnewSchedule).click();

	}
	public void Search_Test_button() {
		driver.findElement(clickonSearchTest).click();
	}
	public void Search_test_name(String TestName) {
		driver.findElement(SearchTestName).sendKeys(TestName);
	}
	public void icons_Action() {
		driver.findElement(Goicon).click();
		driver.findElement(Addicon).click();
	}
	public void Enter_Schedule_name(String ScheduleName) {
		driver.findElement(EnterSchedulename).sendKeys(ScheduleName);
	}
	public void Dropdowns() {
		driver.findElement(Generaldropdown).click();
		driver.findElement(SelectPretestdropdown).click();
	}
	public void All_toggles() {
		driver.findElement(ShowTestResultToStudenttoggle).click();
		driver.findElement(InvigilatorTokentoggle).click();
		driver.findElement(ShuffleTestQuestionstoggle).click();
		driver.findElement(ShuffleChoicestoggle).click();
		driver.findElement(ShowAnswerstoggle).click();
		driver.findElement(ShowTestAnalysistoggle).click();
		//driver.findElement(Tablettoggle).click();
		//driver.findElement(Desktoptoggle).click();	
	}
	public void click_on_datepicker() {
		driver.findElement(datepickerforEndsonfield).click();
		driver.findElement(Choosemonthandyear).click();
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
	public void Ck_editor_texts(String onlineInstructions, String printforminstruction, String scheduledescription) {
		driver.findElement(OnlineTestingInstructions).sendKeys(onlineInstructions);
		driver.findElement(PrintFormInstructions).sendKeys(printforminstruction);
		driver.findElement(ScheduleDescription).sendKeys(scheduledescription);
	}
	public void schedulesave() {
		StaticWait(2);
		driver.findElement(ScheduleSave).click();
	}

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
	}

	//Enroll Exam to the Examtaker
	public void Adminstarationbtn()
    {
    	driver.findElement(Adminstrationbtn).click();
    	StaticWait(2);
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
	
	public void Examtaker_search(String Examtakername) {
		WebElement ES= driver.findElement(SearchExamtaker);
		ES.click();
		ES.sendKeys(Examtakername);
	}
	public void click_on_searched_examtaker(String Examtakername) {
		StaticWait(2);
		WebElement EN=driver.findElement(By.xpath("//span[text()='"+Examtakername+"']"));
		Actions a=new Actions(driver);
		a.moveToElement(EN).click().build().perform();
	}
	
	public void Enroll_To_An_Exam() {
		driver.findElement(EnrollToAnExambutton).click();
	}
	
	public void click_on_exam_dropdown() {
		StaticWait(2);
		driver.findElement(clickonExaminationdropdown).click();
	}
	public void select_examinations_lookup(String examname) {
		WebElement Elookup=driver.findElement(By.xpath("//span[text()=' "+examname+" ']"));
//		JavascriptExecutor j=(JavascriptExecutor) driver;
//		j.executeScript("arguments[0].click()",Elookup);	
		Elookup.click();
	}
	public void click_on_Schedule_dropdown() {
		StaticWait(2);
		driver.findElement(clickonScheduledropdown).click();
	}
	public void select_schedule_lookup(String schedulename) {
		WebElement Slookup=driver.findElement(By.xpath("//span[text()=' "+schedulename+" ']"));
		Slookup.click();
	}
	public void enrollment_save() {
		driver.findElement(EnrollmentSave).click();
		//driver.quit();
	}

}
