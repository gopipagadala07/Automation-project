package com.Examcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Examcenter.Utils.ActionType;

public class Create_TimeSlot_and_enroll_Examatker_Page extends ActionType
{
	private By AddExamtaker = By.xpath("//mat-icon[text()='add']");


	private By AddNewButton = By.xpath("//span[contains(text(),'Add New ')]");
	private By approve = By.xpath("//mat-icon[contains(text(),'person')]/../.././../following-sibling::div/div/mat-slide-toggle");
	private By ChooseMonthandYear = By.xpath("//button[@aria-label='Choose month and year']");
	private By ClickOnHr = By.xpath("(//div[@class='timepicker-dial']/div/div/ngx-mat-timepicker-dial-control/input)[1]");
	private By ClickOnMin = By.xpath("(//div[@class='timepicker-dial']/div/div/ngx-mat-timepicker-dial-control/input)[2]");
	private WebDriver driver;
	private By EndTime = By.xpath("//input[@name='end_time']");
	private By Enrollment = By.xpath("//span[text()='Enrollments']");
	private By ExaminationLookup =By.xpath("//span[text()=' Print Exam Takers ']/../../../div[1]/mat-form-field/div/div/div/mat-select/div");
	private By ExaminationLookupText= By.xpath("//span[text()=' Print Exam Takers ']/../../../div[1]/mat-form-field/div/div/div/mat-select/div/div/span/span");
	private By ExamTakerCount = By.xpath("//input[@data-placeholder='Exam Taker count allowed']");
	private By Header = By.xpath("//h2[@class='page-title section-header m-0']");
	private By Live = By.xpath("(//mat-icon[contains(text(),'person')]/../.././../following-sibling::div/div/mat-slide-toggle)[1]");
	private By LocationLookup = By.xpath("//span[text()=' Print Exam Takers ']/../../../div[2]");
	private By LocationLookupText=By.xpath("//span[text()=' Print Exam Takers ']/../../../div[2]/mat-form-field/div/div/div/mat-select/div/div/span/span");
	private By Notapprove = By.xpath("//mat-icon[contains(text(),'person')]/../.././../following-sibling::div/div/mat-slide-toggle/following-sibling::small");	
	private By OkButton = By.xpath("//span[contains(text(),'OK')] ");
	private By OpenCalender = By.xpath("//button[@aria-label='Open calendar']");
	private By SaveButton = By.xpath("//mat-icon[text()='save']");
	private By StartTime = By.xpath("//input[@name='start_time']");
	private By TimeSlot_Lookup = By.xpath("(//div[text()='TIME SLOTS']/../../.././../../following-sibling::div/mat-tab-body/div/app-ec-enrollees/div[2]/mat-card/mat-card-content/div/div/mat-form-field/div/div/div/mat-select/div)[1]");
	private By TimeSlotTab = By.xpath("//*[text()='TIME SLOTS']");
	//private By H_enrollment = By.xpath("//h2[text()='Enrollments']");
	private By Unassigned_Toggle1 = By.xpath("(//input[@type='search'])[1]/../../../../../../following-sibling::div/mat-slide-toggle/label/span/span/span[@class='mat-slide-toggle-thumb']");




	public Create_TimeSlot_and_enroll_Examatker_Page(WebDriver driver)
	{
		this.driver = driver;
	}
	public void Add_New_TimeSlot() 
	{
		driver.findElement(AddNewButton).click();
	}
	public void addExamtaker()
	{
		driver.findElement(AddExamtaker).click();
	}
	public void approve_and_Live_the_Examtaker()
	{
		waitForElement(Notapprove);
		String s = driver.findElement(Notapprove).getText();
		if(s.equalsIgnoreCase("Not Approved"))
		{
			WebElement e=driver.findElement(approve);			
			Actions a=new Actions(driver);
			a.moveToElement(e).click().build().perform();
			waitForElement(Live);
			StaticWait(2);
			WebElement e1=driver.findElement(Live);
			a.moveToElement(e1).click().build().perform();
		}		
	}
	public void click_on_ChooseMonthandYear() 
	{
		StaticWait(1);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(ChooseMonthandYear)).click().perform();
	}
	public void click_On_Enrollment_Tab()
	{

		waitForElement(Enrollment);
		//		WebElement he1 = driver.findElement(H_enrollment);
		//		if(he1.isDisplayed())
		//		{			
		//		}
		//		else
		//		{
		Actions act = new Actions(driver);
		WebElement e=driver.findElement(Enrollment);
		act.moveToElement(e).click().build().perform();
		StaticWait(2);
		//		}
	}
	public void click_on_Time_slot_Lookup()
	{
		waitForElement(TimeSlot_Lookup);
		StaticWait(2);
		driver.findElement(TimeSlot_Lookup).click();
	}
	public void click_on_TimeslotTab() 
	{
		StaticWait(1);
		driver.findElement(Header).click();
		StaticWait(1);
		driver.findElement(TimeSlotTab).click();;

	}
	public void clickon_EndTime() 
	{
		driver.findElement(EndTime).click();
	}
	public void clickon_SaveButton() 
	{
		StaticWait(1);
		driver.findElement(SaveButton).click();
		StaticWait(1);
	}
	public void clickon_StartTime() 
	{
		driver.findElement(StartTime).click();
	}
	public void clickOnHr() 
	{
		driver.findElement(ClickOnHr).click();
	}
	public void clickOnMin() 
	{
		driver.findElement(ClickOnMin).click();
	}
	public void ExamTaker_Count(String examtakercount)
	{
		StaticWait(1);
		driver.findElement(ExamTakerCount).sendKeys(examtakercount);
	}
	public void okButton() 
	{
		driver.findElement(OkButton).click();
	}
	public void open_the_Calender() 
	{
		waitForElement(OpenCalender);
		driver.findElement(OpenCalender).click();
	}
	public void search_Examtaker_in_a_Timeslot(String ExamTaker_Ln,String ExamTaker_Fn)
	{
		StaticWait(2);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(ExamTaker_Ln+" ");
		StaticWait(1);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(ExamTaker_Fn);
		StaticWait(2);
	}
	public void search_Examtaker_under_enrollment(String ExamTaker_Ln,String ExamTaker_Fn)
	{
		StaticWait(2);
		driver.findElement(Unassigned_Toggle1).click();
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(ExamTaker_Ln+" ");
		StaticWait(1);
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(ExamTaker_Fn);
		StaticWait(1);
	}
	public void select_date(String date) 
	{
		driver.findElement(By.xpath("//div[text()=' "+date+" ']")).click();
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
	public void select_Month(String month) 
	{
		driver.findElement(By.xpath("//div[text()=' "+month+" ']")).click();
	}
	public void select_StartTimeinHr(String StartTimeinHr) 
	{
		driver.findElement(By.xpath("//span[text()="+StartTimeinHr+"]")).click();
	}
	public void select_StartTimeinMin(String StartTimeinMin) 

	{
		Actions act =  new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@style='transform: rotateZ("+StartTimeinMin+"deg);']"))).click().perform();
	}
	//	public void click_On_Examination_Lookup() 
	//	{
	//		waitForElement(ExaminationLookup);
	//		StaticWait(2);
	//		WebElement e1=driver.findElement(ExaminationLookup);
	//		Actions a=new Actions(driver);
	//		a.moveToElement(e1).perform();
	//		StaticWait(2);
	//		e1.click();
	//	}
	public void select_the_Examination(String examination, String schedule) 
	{
		String ExamiantionName1=driver.findElement(ExaminationLookupText).getText();
		String ExamiantionName2=(examination+" - "+schedule);
		if (ExamiantionName1.equalsIgnoreCase(ExamiantionName2))
		{			
		}
		else
		{
			WebElement e2 =driver.findElement(ExaminationLookup);
			StaticWait(2);
			e2.click();
			WebElement ele1=driver.findElement(By.xpath("//span[text()=' "+examination+" - "+schedule+" ']"));
			JavascriptExecutor j=(JavascriptExecutor) driver;	
			j.executeScript("arguments[0].scrollIntoView();",ele1);
			StaticWait(2);
			ele1.click();
		}

	}
	//	public void click_On_Location_Lookup() 
	//	{
	////		waitForElement(LocationLookup);
	////		WebElement e2 =driver.findElement(LocationLookup);
	////		Actions a=new Actions(driver);
	////		a.moveToElement(e2).perform();
	////		StaticWait(2);
	////		e2.click();
	////		
	//	}
	public void select_the_Location(String Location) 
	{
		String Locationname = driver.findElement(LocationLookupText).getText();
		if (Locationname.equalsIgnoreCase(Location))
		{
			//driver.findElement(TimeSlotTab).click();
		}
		else
		{
			WebElement e2 =driver.findElement(LocationLookup);
			e2.click();
			StaticWait(2);
			WebElement ele2=driver.findElement(By.xpath("//span[contains(text(),'"+Location+"')]"));
			Actions a = new Actions(driver);
			a.moveToElement(ele2).click().build().perform();
			StaticWait(2);

		}
		//		StaticWait(2);
		//		WebElement ele2=driver.findElement(By.xpath("//span[contains(text(),'"+Location+"')]"));
		//		JavascriptExecutor j=(JavascriptExecutor) driver;	
		//		j.executeScript("arguments[0].scrollIntoView();",ele2);
		//		StaticWait(2);
		//		ele2.click();
	}
	public void select_the_TimeSlot(String Sh,String Smin, String Eh, String Emin)
	{

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
	public void select_year(String year) 
	{
		StaticWait(1);
		driver.findElement(By.xpath("//button[@aria-label='"+year+"']")).click();
	}

}
