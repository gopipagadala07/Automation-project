package com.Assessments.pages;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
import com.Utils.Wait;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;

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
	@FindBy(how=How.XPATH,using="//mat-select[@formcontrolname='benchmark']/parent::div/parent::div/parent::div")private WebElement CourseBenchmarkDropDown;
	@FindBy(how=How.XPATH,using="//fp-dropdown[@controlname='school']")private WebElement SchoolDropdown;
	@FindBy(how=How.XPATH,using="//fp-dropdown[@controlname='teacher']")private WebElement TeacherDropdown;
	@FindBy(how=How.XPATH,using="//fp-dropdown[@controlname='classroomID']")private WebElement ClassroomdropDown;
	@FindBy(how=How.XPATH,using="//span[text()=' Activate all test status. ']")private WebElement ToggleActive;
	@FindBy(how=How.XPATH,using="//span[text()=' Deactivate all test status. ']")private WebElement ToggleInActive;
	@FindBy(how=How.XPATH,using="//button[text()='Yes']")private WebElement ClickOnYEs;//click on yes to activate benchmark
	@FindBy(how=How.XPATH,using="//mat-label[text()='Status']/following::span[text()='Not Started']")private WebElement NotStartedStatus;
	@FindBy(how=How.XPATH,using="//mat-label[contains(text(),'Status')]/following::span[contains(text(),'In Progress')]")private WebElement InProgressStatus;
	@FindBy(how=How.XPATH,using="//mat-label[contains(text(),'Status')]/following::span[contains(text(),'In Review')]")private WebElement InReviewStatus;
	@FindBy(how=How.XPATH,using="//mat-label[contains(text(),'Status')]/following::span[contains(text(),'Completed')]")private WebElement CompletedStatus;
	@FindBy(how=How.XPATH,using="//mat-icon[contains(text(),'settings_backup_restore')]/parent::span")private WebElement ResetButton;
	@FindBy(how=How.XPATH,using="//button[text()='Yes, Please reset!']")private WebElement YesPleaseReset;

	@FindBy(how=How.XPATH,using="//li[text()='Benchmark Test Administration']")private WebElement BEnchmarkTD;

	public WebElement NewBenchmarkName(String BenchMarkname) {
		String xpath = "//a[contains(text(), '"+BenchMarkname+"')]";
		return driver.findElement(By.xpath(xpath));
	}
	public WebElement clickonAddSectionbutton(String SectionName) {
		String xpath = "//span[text()='"+SectionName+"']/parent::div/parent::div/following-sibling::div/a";
		return driver.findElement(By.xpath(xpath));
	}
	public WebElement TeacherName(String teachername) {
		String xpath = "//div[@role='listbox']/child::mat-option[text()='"+teachername+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	public void clickOnNewBencmark() {
		for(int retry=0;retry<=3;retry++)
		{
			try {
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", NewBenchmarkName(BenchMarkname));
				break;
			}catch (StaleElementReferenceException e) {
				retry++;
				System.out.println("Stale Element reference Exception occuring..!!");
			}
		}
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
		ExtentCucumberAdapter.addTestStepLog(BenchMarkname);
		DescriptionFld.sendKeys(generateRandomString());

	}
	public void savebutton() {
		cp.Save();
	}
	public void findtest() {
		wait.elementToBeClickable(FindTestBtn);
		FindTestBtn.click();
	}

	public void testSearch(String Testname) {
		String testname="\"" + Testname + "\"";
		ExtentCucumberAdapter.addTestStepLog(testname);
		cp.SearchTestname(testname);
		wait.elementToBeClickable(gobutton);
		gobutton.click();
		StaticWait(2);
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
		cp.Save();
		StaticWait(1);
	}
	public void clickOnSectionTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int retries = 0;
		int maxRetries = 15;
		boolean success = false;

		while (retries < maxRetries && !success) {
			try {
				WebElement sectionTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'SECTIONS')]")));
				js.executeScript("arguments[0].click()", sectionTab);
				success = true;
			} catch (StaleElementReferenceException e) {
				retries++;
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}

		if (!success) {
			System.out.println("Failed to click the section tab after " + maxRetries + " attempts.");
		}
	}


	public void SectionSearch(String SectionName)
	{
		StaticWait(1);
		retrySearchForSectionName(SectionName,5);
	}

	public void retrySearchForSectionName(String SectionName, int retryCount) {
		int attempts = 0;
		boolean isSuccessful = false;
		while (attempts < retryCount && !isSuccessful) {
			try {
				cp.searchField(SectionName);
				wait.visibilityOf(clickonAddSectionbutton(SectionName));
				JavascriptExecutor jc = (JavascriptExecutor) driver;
				jc.executeScript("arguments[0].click();", clickonAddSectionbutton(SectionName));
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

	/*
	 * Test Administration
	 */

	public void testAdminTab() {
		wait.elementToBeClickable(TestAdministrationTab);
		TestAdministrationTab.click();
	}
	public void CourseBenchmarkDdown(String SectionName) {
		wait.elementToBeClickable(CourseBenchmarkDropDown);  
		for(int retry = 0; retry <= 3; retry++) {
			try {
				WebElement CourseBenchmarkDropDown = driver.findElement(By.xpath("//mat-label[text()='Course - Benchmark ']/ancestor::span/preceding-sibling::mat-select/parent::div/parent::div/parent::div"));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				CourseBenchmarkDropDown = wait.until(ExpectedConditions.elementToBeClickable(CourseBenchmarkDropDown));
				StaticWait(2);
				cp.FPdropdown(CourseBenchmarkDropDown, SectionName);
				break;
			} catch (NoSuchElementException e) {
				retry++;
				if(retry == 3) {
					StaticWait(1);
					cp.FPdropdown(CourseBenchmarkDropDown, SectionName);
					break;
				}
			}
		}
	}

	public void schoolDdown(String schooldrop) {
		wait.elementToBeClickable(SchoolDropdown);
		wait.visibilityOf(SchoolDropdown);	
		cp.FPdropdown(SchoolDropdown, schooldrop);

	}

	public void teacherDdown(String FirstName, String LastName) {
		wait.elementToBeClickable(TeacherDropdown);
		Actions a=new Actions(driver);
		a.moveToElement(TeacherDropdown).click().build().perform();
		StaticWait(1);
		a.moveToElement(TeacherName(LastName+" "+FirstName)).click().build().perform();
	}

	public void classroomDdown(String classroomdown) {
		wait.elementToBeClickable(ClassroomdropDown);
		wait.visibilityOf(ClassroomdropDown);
		cp.FPdropdown(ClassroomdropDown, classroomdown);
	}


	public void ActiveToggle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		int maxRetries = 3;
		int retries = 0;

		while (retries < maxRetries) {
			try {

				if (ToggleActive.isDisplayed()) {
					wait.until(ExpectedConditions.elementToBeClickable(ToggleActive)); 
					Actions actions = new Actions(driver);
					actions.moveToElement(ToggleActive).click().perform(); 

					wait.until(ExpectedConditions.elementToBeClickable(ClickOnYEs));
					ClickOnYEs.click();
					return; 
				} else {
					StaticWait(1); 
					Actions actions = new Actions(driver);
					actions.moveToElement(ToggleInActive).click().perform(); 

					wait.until(ExpectedConditions.elementToBeClickable(ClickOnYEs));
					wait.until(ExpectedConditions.visibilityOf(ClickOnYEs));
					ClickOnYEs.click();
					return;
				}
			} catch (NoSuchElementException | StaleElementReferenceException e) {

				System.out.println("Element not found or stale. Retrying... Attempt " + (retries + 1));
				retries++;


				if (retries >= maxRetries) {
					System.out.println("Max retries reached. Unable to find the element.");
					throw new RuntimeException("Failed to toggle the element after " + maxRetries + " retries.");
				}


				StaticWait(1);
			} catch (Exception e) {

				System.out.println("Unexpected error: " + e.getMessage());
				break; 
			}
		}
	}

	public void CheckingStatus() {
		for(int retry=0;retry<3;retry++)
		{
			try {
				if (NotStartedStatus.equals("Not Started"))  {
					StaticWait(1);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
					wait.elementToBeClickable(ResetButton);
					ResetButton.click();
					wait.elementToBeClickable(YesPleaseReset);
					YesPleaseReset.click();
					break;
				} else {
					System.out.println(NotStartedStatus.isDisplayed() ? "<--------Not Started-------->" :
						InProgressStatus.isDisplayed() ? "In Progress" :
							InReviewStatus.isDisplayed() ? "In Review" : "No active status");
					break;
				}
			} catch (Exception e) {
				retry++;
			}

		}
	}
}
