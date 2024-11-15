package com.Assessments.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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

public class Teacher_Activityprogress extends ActionType{

	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;
	static String ClassroomName;
	static String SectionName;
	static int DLastName;
	static int TLastName;
	static int SLastName;
	static String DFirstName;
	static String TFirstName;
	static String SFirstName;

	/*
	 * Activate & Deactivate toggles
	 */

	private By Learningtab = By.xpath("//span[contains(text(),'Learning')]");
	private By AssessmentTab = By.xpath("//a[contains(text(),'Assessment Center')]");



	//	@FindBy(how = How.XPATH, using = "//div[contains(text(),'QUIZ')]")
	//	private List<WebElement> Quizzes;

	@FindBy(how = How.XPATH, using = "//cdk-nested-tree-node[@role='treeitem']/child::div/child::div[2]/cdk-nested-tree-node/child::div/child::small")
	private List<WebElement> Quizzeslist;

	private By close = By.xpath("//button[@aria-label='close dialog']/child::span/child::mat-icon");

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'EXAM')]")
	private WebElement examtab;


	@FindBy(how = How.XPATH, using = "//mat-tab-body[@role='tabpanel']/child::div/child::mat-list/child::mat-list-item/child::span/child::small")
	private List<WebElement> Examslist;


	public Teacher_Activityprogress(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void learning()
	{

		WebElement AC = driver.findElement(AssessmentTab);
		if(AC.isDisplayed())
		{
			AC.click();
		}
		else
		{
			driver.findElement(Learningtab).click();
			AC.click();
		}
	}


	public WebElement getCommunityNameElement(String ClassroomName) {
		String xpath = "//span[(text()='"+ClassroomName+"')]/parent::div/parent::mat-card-content/preceding-sibling::mat-card-header/child::div/mat-card-title/child::span";
		return driver.findElement(By.xpath(xpath));
	}

	public void AssessmentCentre(String ClassroomName, String SectionName, String TLastName, String TFirstName)
	{
		cp.searchField(ClassroomName + "(" + SectionName + ")-"+ TLastName + " " + TFirstName);
		StaticWait(2);
		wait.visibilityOf(getCommunityNameElement(ClassroomName));
		wait.elementToBeClickable(getCommunityNameElement(ClassroomName));
		Actions a=new Actions(driver);
		a.moveToElement(getCommunityNameElement(ClassroomName)).click().build().perform();
		//      JavascriptExecutor js=(JavascriptExecutor) driver;
		//      js.executeScript("arguments[0].click();", getCommunityNameElement(ClassroomName));



		//wait.elementToBeClickable(Assessmentcourse);
		//Assessmentcourse.click();
		StaticWait(2);

	}

	public void clickEachQuizAndClose() {
		System.out.println("Total Quizzes: "+Quizzeslist.size());
		for (WebElement quiz : Quizzeslist) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", quiz);
			StaticWait(2);
			WebElement closeButton = driver.findElement(close);
			js.executeScript("arguments[0].click();", closeButton);

			// Static wait to allow the page or modal to close properly
			StaticWait(2);



		}

	}

	public void examtab() {

		examtab.click();
		StaticWait(2);

	}

	/*public void clickEachExamAndClose() {
		System.out.println("Total Exams: " + Examslist.size());
		for (WebElement exam : Examslist) {
		    try {
		        JavascriptExecutor js = (JavascriptExecutor) driver;


		        js.executeScript("arguments[0].click()", exam);
		        StaticWait(5);


		        WebElement closeButton = driver.findElement(close);
		        js.executeScript("arguments[0].click();", closeButton);
		        StaticWait(2);

		    } catch (NoSuchElementException e) {


		    }
		}*/

	/*public void clickEachExamAndClose() {
		try {
			Actions actions = new Actions(driver);


			for (WebElement exam : Examslist) {

				System.out.println("Total Exams: " + Examslist.size());


				actions.moveToElement(exam).click().perform();
				StaticWait(2);


				WebElement closeButton = driver.findElement(close);
				actions.moveToElement(closeButton).click().perform();
				StaticWait(2);
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Encountered a stale element exception. Retrying...");
		}*/

	public void clickEachExamAndClose() {
		System.out.println("Total Exams: " + Examslist.size());
		Actions actions = new Actions(driver);
		int retries = 5;

		for (int i = 0; i < Examslist.size(); i++) {
			int attempts = retries;

			while (attempts > 0) {
				try {
					WebElement exam = Examslist.get(i);
					actions.moveToElement(exam).click().perform();
					StaticWait(2);

					WebElement closeButton = driver.findElement(close);
					actions.moveToElement(closeButton).click().perform();
					StaticWait(5);
					break;
				} catch (StaleElementReferenceException e) {
					attempts--;
					if (attempts == 0) {
						System.out.println("Failed after retries due to StaleElementReferenceException for exam at index " + i);
					} else {
						System.out.println("Retrying due to StaleElementReferenceException for exam at index " + i + ". Attempts left: " + attempts);
					}
						                
				}
			}
		}


	}}



