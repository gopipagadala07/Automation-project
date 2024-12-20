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
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

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
	@FindBy(how = How.XPATH, using = "//cdk-nested-tree-node[@role='treeitem']/child::div/child::div[2]/cdk-nested-tree-node/child::div/child::small")
	private List<WebElement> Quizzeslist;
	@FindBy(how=How.XPATH,using = "//div[@class='table_body_item']/child::label")private WebElement bandstatus;
	private By close = By.xpath("//button[@aria-label='close dialog']/child::span/child::mat-icon");

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'EXAM')]")
	private WebElement examtab;


	@FindBy(how = How.XPATH, using = "//mat-tab-body[@role='tabpanel']/child::div/child::mat-list/child::mat-list-item/child::span/child::small")
	private WebElement Examslist;


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
		StaticWait(2);

	}

	public void clickEachQuizAndClose() {
		System.out.println("Total Quizzes: "+Quizzeslist.size());
		for (WebElement quiz : Quizzeslist) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", quiz);
			StaticWait(2);
			String Band=bandstatus.getText();
			ExtentCucumberAdapter.addTestStepLog(Band);
			System.out.println(Band);
			WebElement closeButton = driver.findElement(close);
			js.executeScript("arguments[0].click();", closeButton);
			StaticWait(2);
		}
	}
	public void examtab() {
		StaticWait(2);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'EXAM')]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);
		StaticWait(1);
	}

	public void clickEachExamAndClose() {
		Actions actions = new Actions(driver);
				try {
					actions.moveToElement(Examslist).click().perform();
					StaticWait(2);
					//String Band=bandstatus.getText();
					//System.out.println(Band);
					WebElement closeButton = driver.findElement(close);
					actions.moveToElement(closeButton).click().perform();
				} catch (StaleElementReferenceException e) {
					
	
				}

		}
}
