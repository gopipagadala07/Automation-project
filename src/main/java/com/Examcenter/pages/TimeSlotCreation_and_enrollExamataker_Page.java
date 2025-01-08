package com.Examcenter.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
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

public class TimeSlotCreation_and_enrollExamataker_Page extends ActionType
{

	CommonPages cp=new CommonPages(Base.getDriver());
	JavascriptExecutor js=(JavascriptExecutor) Base.getDriver();
	Actions a=new Actions(Base.getDriver());
	public WebDriver driver;
	private Wait wait;

	@FindBy(how=How.XPATH,using = "//span[text()='Enrollments']") private WebElement Enrollment;
	@FindBy(how=How.XPATH,using = "//span[text()=' Print Exam Takers ']/../../../div[1]/mat-form-field/div/div/div/mat-select/div") private WebElement ExaminationLookup;
	@FindBy(how=How.XPATH,using = "//span[text()=' Print Exam Takers ']/../../../div[1]/mat-form-field/div/div/div/mat-select/div/div/span/span") private WebElement ExaminationLookupText;
	@FindBy(how=How.XPATH,using = "//span[text()=' Print Exam Takers ']/../../../div[2]") private WebElement LocationLookup;
	@FindBy(how=How.XPATH,using = "//span[text()=' Print Exam Takers ']/../../../div[2]/mat-form-field/div/div/div/mat-select/div/div/span/span") private WebElement LocationLookupText;

	@FindBy(how=How.XPATH,using = "//*[text()='TIME SLOTS']") private WebElement TimeSlotTab;

	@FindBy(how=How.XPATH,using = "//span[contains(text(),'Add New ')]") private WebElement AddNewButton;
	@FindBy(how=How.XPATH,using = "//button[@aria-label='Open calendar']") private WebElement OpenCalender;
	@FindBy(how=How.XPATH,using = "//button[@aria-label='Choose month and year']") private WebElement ChooseMonthandYear;
	@FindBy(how=How.XPATH,using = "//input[@name='start_time']") private WebElement StartTime;
	@FindBy(how=How.XPATH,using = "(//div[@class='timepicker-dial']/div/div/ngx-mat-timepicker-dial-control/input)[1]") private WebElement ClickOnHr;
	@FindBy(how=How.XPATH,using = "(//div[@class='timepicker-dial']/div/div/ngx-mat-timepicker-dial-control/input)[2]") private WebElement ClickOnMin;
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'OK')] ") private WebElement OkButton;
	@FindBy(how=How.XPATH,using = "//input[@name='end_time']") private WebElement EndTime;
	@FindBy(how=How.XPATH,using = "//input[@data-placeholder='Exam Taker count allowed']") private WebElement ExamTakerCount;
	@FindBy(how=How.XPATH,using = "//mat-icon[text()='save']") private WebElement SaveButton;

	@FindBy(how=How.XPATH,using = "//div[text()='ENROLLEES']") private WebElement Enrolleetab;
	@FindBy(how=How.XPATH,using = "(//div[@class='time_slot_performance']/div/mat-form-field/child::div)[1]") private WebElement TimeSlot_Lookup;

	@FindBy(how=How.XPATH,using = "//mat-icon[text()='add']") private WebElement AddExamtaker;
	@FindBy(how=How.XPATH,using = "(//mat-icon[@name='myMatIcon' and text()='comment']/parent::span/parent::button/parent::div/preceding-sibling::div[1]/child::div/child::mat-slide-toggle/child::label/child::span)[1]") private WebElement approve;
	@FindBy(how=How.XPATH,using = "(//mat-icon[@name='myMatIcon' and text()='comment']/parent::span/parent::button/parent::div/preceding-sibling::div[1]/child::div/child::mat-slide-toggle/child::label/child::span/child::span)[1]") private WebElement Live;

	@FindBy(how=How.XPATH,using = "//mat-icon[contains(text(),'person')]/../.././../following-sibling::div/div/mat-slide-toggle/following-sibling::small") private WebElement Notapprove;
	@FindBy(how=How.XPATH,using = "(//input[@type='search'])[1]/../../../../../../following-sibling::div/mat-slide-toggle/label/span/span/span[@class='mat-slide-toggle-thumb']") private WebElement Unassigned_Toggle1;
	@FindBy(how=How.XPATH,using = "//h2[@class='page-title section-header m-0']") private WebElement Header;
	@FindBy(how=How.XPATH,using = "//h2[text()='Enrollments']") private WebElement H_enrollment;
	@FindBy(how=How.XPATH,using = "(//input[contains(@type, 'search')])[2]") private WebElement Search;

	public TimeSlotCreation_and_enrollExamataker_Page(WebDriver driver)	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public String timeslotselection(String Value)
	{
		String Xpath="//span[text()='"+Value+"']/parent::div/parent::span";
		driver.findElement(By.xpath(Xpath));
		return Xpath;
	}
	public void click_On_Enrollment_Tab(){
		a.moveToElement(Enrollment).perform();
		a.doubleClick().build().perform();
		//Enrollment.click();
		StaticWait(2);
	}

	public void select_the_Examination(String ExamName, String ScheduleName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String fullExamScheduleName = ExamName + " - " + ScheduleName;
		int maxRetries = 5;
		int retry = 0;

		while (retry <= maxRetries) {
			try {
				WebElement ExaminationLookup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-label[text()='Examination']/ancestor::span/preceding-sibling::mat-select/ancestor::mat-form-field/child::div")));
				wait.until(ExpectedConditions.visibilityOf(ExaminationLookup));
				if (ExaminationLookup.isEnabled()) {
					StaticWait(2);
					cp.FPdropdown(ExaminationLookup, fullExamScheduleName);
					break;
				} else {
					throw new ElementNotInteractableException("Examination Lookup element is not enabled.");
				}
			} catch (TimeoutException e) {
				retry++;
				System.err.println("Timeout waiting for the Examination Lookup element to be clickable/visible. Attempt " + retry);
				e.printStackTrace();
				if (retry > maxRetries) {
					throw e;
				}
			} catch (ElementNotInteractableException e) {
				System.err.println("The Examination Lookup element is not interactable.");
				e.printStackTrace();
				break;
			} catch (Exception e) {
				System.err.println("An unexpected error occurred while selecting the examination.");
				e.printStackTrace();
				break;
			}
		}
	}

	public void select_the_Location(String Location) 
	{
		for(int retry=0;retry<3;retry++)
		{
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement Locationlookup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-label[text()='Location']/ancestor::span/preceding-sibling::mat-select/ancestor::mat-form-field/child::div")));
				StaticWait(2);
				cp.FPdropdown(Locationlookup, Location);
				//System.out.println(Location);
				break;
			}catch (TimeoutException e) {
				retry++;
			}
		}

	}

	public void click_on_TimeslotTab() 
	{
		wait.elementToBeClickable(TimeSlotTab);
		wait.visibilityOf(TimeSlotTab);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", TimeSlotTab);
		StaticWait(1);
	}
	public void Add_New_TimeSlot() 
	{
		int retries = 10;
		while (retries > 0) {
			try {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Add New ')]")));
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", e);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
	}
	public void open_the_Calender() 
	{
		wait.elementToBeClickable(OpenCalender);
		cp.selectCurrentDate(OpenCalender);
	}

	public void select_start_time_from_timepicker() {

		cp.selectCurrentTime(StartTime,true);
	}

	public void okButton() 
	{
		wait.elementToBeClickable(OkButton);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", OkButton);
	}

	public void clickon_EndTime() 
	{
		StaticWait(1);
		cp.selectFutureRandomTime(EndTime,true);
	}

	public void ExamTaker_Count()
	{
		ExamTakerCount.sendKeys(String.valueOf(randomNumberGenerator()));
	}

	public void Enrollee_tab() {
		wait.elementToBeClickable(Enrolleetab);
		wait.visibilityOf(Enrolleetab);
		StaticWait(1);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Enrolleetab);
		StaticWait(2);
	}
	
	public void retryclickTimeslotLookup(int retryCount, WebElement TimeSlotLookup) {
		int attempts = 0;
		boolean isSuccessful = false;
		while (attempts < retryCount && !isSuccessful) {
			try {
				
				Actions a=new Actions(driver);
				a.moveToElement(TimeSlotLookup).perform();
				a.click().build().perform();
				isSuccessful = true;
				break;
			} catch (Exception e) {
				attempts++;
				System.out.println("Attempt " + attempts + " failed: " + e.getMessage());
				if (attempts >= retryCount) {
					throw new RuntimeException("Failed to search and click on course name after " + retryCount + " attempts.", e);
				}
			}
		}
	}

	public void click_on_Time_slot_Lookup_and_select_timeslot() {
		if (CommonPages.currentHour < 12) {
			String timeslotvalue = CommonPages.currentHour + ":" + CommonPages.formattedMin + "AM";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement TimeSlotLookup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='time_slot_performance']/child::div[1]/child::mat-form-field")));
			//System.out.println(timeslotvalue);
			retryclickTimeslotLookup(5,TimeSlotLookup);
			WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(timeslotselection(timeslotvalue))));
			e.click();
		} else if (CommonPages.currentHour > 12) {
			int currentHour = CommonPages.currentHour - 12;
			//System.out.println(currentHour);
			String timeslotvalue = currentHour + ":" + CommonPages.formattedMin + "PM";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement TimeSlotLookup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='time_slot_performance']/child::div[1]/child::mat-form-field")));
			//System.out.println(timeslotvalue);
			retryclickTimeslotLookup(5,TimeSlotLookup);
			WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(timeslotselection(timeslotvalue))));
			e.click();
		}
		else if (CommonPages.currentHour == 12) {
			int currentHour = CommonPages.currentHour;
			//System.out.println(currentHour);
			String timeslotvalue = currentHour + ":" + CommonPages.formattedMin + "PM";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement TimeSlotLookup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='time_slot_performance']/child::div[1]/child::mat-form-field")));
			//System.out.println(timeslotvalue);
			retryclickTimeslotLookup(5,TimeSlotLookup);
			WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(timeslotselection(timeslotvalue))));
			e.click();
		}
	}

	public void search_Examtaker_under_enrollment(String EFirstName, String ELastName)
	{
		cp.searchField(ELastName + " " + EFirstName);
	}
	public void addExamtaker()
	{	
		AddExamtaker.click();
	}

	public void search_Examtaker_in_a_Timeslot(String EFName, String ELName)
	{
		Search.sendKeys(ELName + " " + EFName);
	}


	public void approve_and_Live_the_Examtaker() {
		try {
			StaticWait(1);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Actions a = new Actions(driver);
			WebElement approveButton = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//small[text()='Not Approved']/parent::div/child::mat-slide-toggle/child::label/child::span[1]")));
			wait.until(ExpectedConditions.visibilityOf(approveButton));
			js.executeScript("arguments[0].click();", approveButton);
			System.out.println("Approve button clicked successfully.");
			StaticWait(1);
			int maxRetries = 3;
			int attempt = 0;
			boolean success = false;

			while (attempt < maxRetries && !success) {
				try {
					js.executeScript("arguments[0].scrollIntoView(true);", Live);
					WebElement liveButton = wait.until(ExpectedConditions.presenceOfElementLocated(
							By.xpath("//small[text()='Not Live']/parent::div/child::mat-slide-toggle/child::label/child::span[1]")));
					wait.until(ExpectedConditions.elementToBeClickable(liveButton));
					wait.until(ExpectedConditions.visibilityOf(liveButton));
					StaticWait(1);
					a.moveToElement(liveButton).perform();
					StaticWait(2);
					a.click().build().perform();
					System.out.println("Live button clicked successfully.");
					success = true;
				} catch (StaleElementReferenceException ex) {
					System.out.println("StaleElementReferenceException: Retrying... Attempt " + (attempt + 1));
				} catch (Exception ex) {
					System.out.println("Exception: " + ex.getMessage());
					throw ex;
				}
				attempt++;
				if (attempt >= maxRetries && !success) {
					throw new RuntimeException("Failed to click the Live button after " + maxRetries + " attempts.");
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception in approve_and_Live_the_Examtaker: " + ex.getMessage());
			throw ex;
		}
	}
}