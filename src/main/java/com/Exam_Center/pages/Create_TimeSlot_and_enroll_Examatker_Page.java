package com.Exam_Center.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.FP_Examcenter.util.ActionType;

public class Create_TimeSlot_and_enroll_Examatker_Page extends ActionType
{
	private WebDriver driver;


	private By Enrollment = By.xpath("//span[text()='Enrollments']");
	private By ExaminationLookup =By.xpath("//span[text()=' Print Exam Takers ']/../../../div[1]/mat-form-field/div/div/div/mat-select/div");
	private By LocationLookup = By.xpath("//span[text()=' Print Exam Takers ']/../../../div[2]/mat-form-field");
	private By TimeSlotTab = By.xpath("//*[text()='TIME SLOTS']");
	private By AddNewButton = By.xpath("//span[contains(text(),'Add New ')]");
	private By ExamTakerCount = By.xpath("//input[@data-placeholder='Exam Taker count allowed']");
	private By OpenCalender = By.xpath("//button[@aria-label='Open calendar']");
	private By ChooseMonthandYear = By.xpath("//button[@aria-label='Choose month and year']");
	private By StartTime = By.xpath("//input[@name='start_time']");
	private By ClickOnHr = By.xpath("(//div[@class='timepicker-dial']/div/div/ngx-mat-timepicker-dial-control/input)[1]");
	private By ClickOnMin = By.xpath("(//div[@class='timepicker-dial']/div/div/ngx-mat-timepicker-dial-control/input)[2]");
	private By EndTime = By.xpath("//input[@name='end_time']");
	private By OkButton = By.xpath("//span[contains(text(),'OK')] ");
	private By SaveButton = By.xpath("//mat-icon[text()='save']");
	
	private By TimeSlot_Lookup = By.xpath("(//div[text()='TIME SLOTS']/../../.././../../following-sibling::div/mat-tab-body/div/app-ec-enrollees/div[2]/mat-card/mat-card-content/div/div/mat-form-field/div/div/div/mat-select/div)[1]");
	private By AddExamtaker = By.xpath("//mat-icon[text()='add']");
	private By Notapprove = By.xpath("//mat-icon[contains(text(),'person')]/../.././../following-sibling::div/div/mat-slide-toggle/following-sibling::small");
	private By approve = By.xpath("//mat-icon[contains(text(),'person')]/../.././../following-sibling::div/div/mat-slide-toggle");
	private By Live = By.xpath("(//mat-icon[contains(text(),'person')]/../.././../following-sibling::div/div/mat-slide-toggle)[1]");
	



	public Create_TimeSlot_and_enroll_Examatker_Page(WebDriver driver)
	{
		this.driver = driver;
	}
	public void click_On_Enrollment_Tab()
	{
		waitForElement(Enrollment);
		driver.findElement(Enrollment).click();
	}
	public void click_On_Examination_Lookup() 
	{
		waitForElement(ExaminationLookup);
		StaticWait(2);
		WebElement e1=driver.findElement(ExaminationLookup);
		e1.click();
	}
	public void select_the_Examination(String examination, String schedule) 
	{
		WebElement ele1=driver.findElement(By.xpath("//span[text()=' "+examination+" - "+schedule+" ']"));
		ele1.click();
		
	}
	public void click_On_Location_Lookup() 
	{
		waitForElement(LocationLookup);
		driver.findElement(LocationLookup).click();;

	}
	public void select_the_Location(String Location) 
	{
		WebElement ele2=driver.findElement(By.xpath("//span[contains(text(),'"+Location+"')]"));
		ele2.click();
	}
	public void click_on_TimeslotTab() 
	{
		driver.findElement(TimeSlotTab).click();
	}
	public void Add_New_TimeSlot() 
	{
		driver.findElement(AddNewButton).click();
	}
	public void ExamTaker_Count(String examtakercount)
	{
		driver.findElement(ExamTakerCount).sendKeys(examtakercount);
	}
	public void open_the_Calender() 
	{
		waitForElement(OpenCalender);
		driver.findElement(OpenCalender).click();
	}
	public void click_on_ChooseMonthandYear() 
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(ChooseMonthandYear)).click().perform();
	}
	public void select_year(String year) 
	{
		driver.findElement(By.xpath("//button[@aria-label='"+year+"']")).click();
	}
	public void select_Month(String month) 
	{
		driver.findElement(By.xpath("//div[text()=' "+month+" ']")).click();
	}
	public void select_date(String date) 
	{
		driver.findElement(By.xpath("//div[text()=' "+date+" ']")).click();
	}
	public void clickon_StartTime() 
	{
		driver.findElement(StartTime).click();
	}
	public void clickOnHr() 
	{
		driver.findElement(ClickOnHr).click();
	}
	public void select_StartTimeinHr(String StartTimeinHr) 
	{
		driver.findElement(By.xpath("//span[text()="+StartTimeinHr+"]")).click();
	}
	public void clickOnMin() 
	{
		driver.findElement(ClickOnMin).click();
	}
	public void select_StartTimeinMin(String StartTimeinMin) 
	
	{
		Actions act =  new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@style='transform: rotateZ("+StartTimeinMin+"deg);']"))).click().perform();
	}
	public void okButton() 
	{
		driver.findElement(OkButton).click();
	}
	public void clickon_EndTime() 
	{
		driver.findElement(EndTime).click();
	}
	public void select_End_TimeinHr(String EndTimeinHr) 
	{
		driver.findElement(By.xpath("//span[text()="+EndTimeinHr+"]")).click();
	}
	public void select_EndTimeinMin(String EndTimeinMin) 
	{
		Actions act =  new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//button[@style='transform: rotateZ(-"+EndTimeinMin+"deg);']"))).click().perform();
	}
	public void clickon_SaveButton() 
	{
		driver.findElement(SaveButton).click();
	}
	public void click_on_Time_slot_Lookup()
	{
		waitForElement(TimeSlot_Lookup);
		StaticWait(2);
		driver.findElement(TimeSlot_Lookup).click();
	}
	public void select_the_TimeSlot(String Sh,String Smin, String Eh, String Emin)
	{
//		WebElement amam = driver.findElement(By.xpath("//span[text()='"+Sh+":"+Smin+"AM']/following-sibling::span[text()='"+Eh+":"+Emin+"AM']"));
//		WebElement pmam = driver.findElement(By.xpath("//span[text()='"+Sh+":"+Smin+"PM']/following-sibling::span[text()='"+Eh+":"+Emin+"AM']"));
//		WebElement ampm = driver.findElement(By.xpath("//span[text()='"+Sh+":"+Smin+"AM']/following-sibling::span[text()='"+Eh+":"+Emin+"PM']"));
//		WebElement pmpm = driver.findElement(By.xpath("//span[text()='"+Sh+":"+Smin+"PM']/following-sibling::span[text()='"+Eh+":"+Emin+"PM']"));
		
		int ish = Integer.parseInt(Sh);
		int ieh = Integer.parseInt(Eh);
		if(ish<=12 & ieh<=12)
		{
			String Sh1=String.valueOf(ish);
			String Eh1=String.valueOf(ieh);
			WebElement t= driver.findElement(By.xpath("//span[text()='"+Sh1+":"+Smin+"AM']/following-sibling::span[text()='"+Eh1+":"+Emin+"AM']"));
		//	StaticWait(1);
			t.click();
		}
		if(ish>=12 & ieh<=12)
		{
			String Sh1=String.valueOf(ish-12);
			String Eh1=String.valueOf(ieh);
			WebElement t= driver.findElement(By.xpath("//span[text()='"+Sh1+":"+Smin+"PM']/following-sibling::span[text()='"+Eh1+":"+Emin+"AM']"));			
			//StaticWait(1);
			t.click();
		}
		
		if(ish<12 & ieh>=12)
		{
			String Sh1=String.valueOf(ish);
			String Eh1=String.valueOf(ieh-12);
			WebElement t= driver.findElement(By.xpath("//span[text()='"+Sh1+":"+Smin+"AM']/following-sibling::span[text()='"+Eh1+":"+Emin+"PM']"));	
			//StaticWait(1);
			t.click();
		}
		
		if(ish>=12 & ieh>=12)
		{
			String Sh1=String.valueOf(ish-12);
			String Eh1=String.valueOf(ieh-12);
			WebElement t= driver.findElement(By.xpath("//span[text()='"+Sh1+":"+Smin+"PM']/following-sibling::span[text()='"+Eh1+":"+Emin+"PM']"));
			//StaticWait(1);
			t.click();
		}	
	}
	public void search_Examtaker_under_enrollment(String ExamTaker_Ln,String ExamTaker_Fn)
	{
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(ExamTaker_Ln+" "+ExamTaker_Fn);
	}
	public void addExamtaker()
	{
		driver.findElement(AddExamtaker).click();
	}
	public void search_Examtaker_in_a_Timeslot(String ExamTaker_Ln,String ExamTaker_Fn)
	{
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(ExamTaker_Ln+" "+ExamTaker_Fn);
	}
	public void approve_and_Live_the_Examtaker()
	{
		waitForElement(Notapprove);
		String s = driver.findElement(Notapprove).getText();
		if(s.equalsIgnoreCase("Not Approved"))
		{
			driver.findElement(approve).click();
			waitForElement(Live);
			driver.findElement(Live).click();
		}		
	}

}
