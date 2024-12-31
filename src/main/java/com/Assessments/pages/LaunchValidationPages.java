package com.Assessments.pages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
import com.Utils.Wait;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import java.time.Duration;
import java.util.List;

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
public class LaunchValidationPages extends ActionType {

	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;

	@FindBy(how=How.XPATH,using="//span[@mattooltip='Assessments']")private WebElement AssessmentTab;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='launch']/parent::span")private WebElement LaunchIcon;
	@FindBy(how=How.XPATH,using="//span[text()=' Begin Test ']")private WebElement BeginTest;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='close']/parent::span")private WebElement CloseIcon;
	@FindBy(how=How.XPATH,using="//iframe[@class='iframe-styling ng-star-inserted']")private WebElement iFrame;

	@FindBy(how=How.XPATH,using="//h3[text()='Assessments']/parent::mat-card-content/descendant::mat-tab-header/descendant::div[@role='tab'][2]")private WebElement ExamTab;
	@FindBy(how=How.XPATH,using="//b[text()='Achievement']/parent::div/child::label")private WebElement StatusBand;



	@FindBy(how = How.XPATH, using = "//cdk-nested-tree-node[@role='treeitem']/child::div/child::div/cdk-nested-tree-node/child::div/child::div[2]/child::span[2]/child::mat-icon")
	private List<WebElement> Quizzeslist;

	@FindBy(how = How.XPATH, using = "//small[@class='announce__list--icon']/child::span[2]/child::mat-icon")
	private WebElement examsList;


	public LaunchValidationPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}
	public void clickEachQuizAndClose() {
		System.out.println("Total Quizzes: " + Quizzeslist.size());

		for (int i = 0; i < Quizzeslist.size(); i++) {
			WebElement quiz = Quizzeslist.get(i);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", quiz);
			StaticWait(1);
			String s=StatusBand.getText();
			ExtentCucumberAdapter.addTestStepLog("Quizzes Status band : "+s);
			System.out.println("Quizzes Status band : "+s);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click()", CloseIcon);
			StaticWait(1); 
		}
	}
	public void clickEachExamAndClose() {
		StaticWait(2);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='Assessments']/parent::mat-card-content/descendant::mat-tab-header/descendant::div[@role='tab'][2]")));
		Actions actions = new Actions(driver);
		actions.moveToElement(e1).perform();
		actions.click().build().perform();
		try {
			WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[@class='announce__list--icon']/child::span[2]/child::mat-icon")));
			actions.moveToElement(e2).click().perform();
			StaticWait(2);
			String s=StatusBand.getText();
			ExtentCucumberAdapter.addTestStepLog("Exam Status band : "+s);
			System.out.println("Exam Status band : "+s);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click()", CloseIcon);
			StaticWait(1); 
		} catch (StaleElementReferenceException e) {
			
		}
	}

}