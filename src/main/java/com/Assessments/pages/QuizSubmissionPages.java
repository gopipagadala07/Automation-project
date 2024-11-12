package com.Assessments.pages;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.Wait;

import io.cucumber.java.lu.an;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuizSubmissionPages extends ActionType {

	CommonPages cp = new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;
	@FindBy(how=How.XPATH,using="//span[@mattooltip='Assessments']")private WebElement AssessmentTab;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='launch']/parent::span")private WebElement LaunchIcon;
	@FindBy(how=How.XPATH,using="//span[text()=' Begin Test ']")private WebElement BeginTest;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='close']/parent::span")private WebElement CloseIcon;
	@FindBy(how=How.XPATH,using="//iframe[@class='iframe-styling ng-star-inserted']")private WebElement iFrame;

	/*
	 * QTI Player questions
	 */
	@FindBy(how=How.XPATH,using="(//div[@class=\"mdc-radio\"])[1]")private WebElement McqAnswer;
	@FindBy(how=How.XPATH,using="//input[@type='text']")private WebElement FillAndExtended;

	@FindBy(how=How.XPATH,using="//mat-icon[text()='chevron_right']")private WebElement NextQ;
	@FindBy(how=How.XPATH,using="//span[text()='Finish']")private WebElement Finish;
	@FindBy(how=How.XPATH,using="//span[text()='Submit']")private WebElement Submit;
	@FindBy(how=How.XPATH,using="//mat-icon[@mattooltip='Close']")private WebElement CloseAfterSubmit;

	@FindBy(how=How.XPATH,using="//mat-icon[@mattooltip='Close']")private WebElement JustMoveElement;

	@FindBy(how=How.XPATH,using="//div[text()=' All ']/parent::div")private WebElement All;
	@FindBy(how=How.XPATH,using="(//mat-icon[text()=' chevron_right '])[1]")private WebElement Topic;
	@FindBy(how=How.XPATH,using="//mat-icon[text()=' chevron_right ']")private WebElement SubTopic;
	@FindBy(how=How.XPATH,using="//a[text()='Courses']")private WebElement ScrollTop;

	//	@FindBy(how = How.XPATH, using = "//mat-icon[@mattooltip='Launch Activity']")
	//	private List<WebElement> Quizzeslist;
	//@FindBy(how=How.XPATH,using="//div/cdk-nested-tree-node/div/div/div/div/div/child::button/child::span/child::mat-icon")
	//	private WebElement LaunchfromAssessmentTab;

	public QuizSubmissionPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}
	public void ClickOnAssessmentTab() throws AWTException, InterruptedException {
		wait.elementToBeClickable(AssessmentTab);
		wait.visibilityOf(AssessmentTab);
		AssessmentTab.click();
		StaticWait(2);

		All.click();
		JavascriptExecutor s = (JavascriptExecutor) driver;
		cp.scrollToBottomAndClick(Topic);
		cp.scrollToBottomAndClick(SubTopic);
		s.executeScript("arguments[0].scrollIntoView(true);", ScrollTop);
		StaticWait(2);
	}

	public void ClickOnLaunchAndCompleteTest() throws AWTException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));  
		List<WebElement> matIcon;
		matIcon = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//cdk-nested-tree-node/div/div/div/div/div/button/span/mat-icon")));
		System.out.println("Total Quizzes: " + matIcon.size());

		for (int j = 0; j < matIcon.size(); j++) {
			WebElement quiz = null;

			try {
				matIcon = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//cdk-nested-tree-node/div/div/div/div/div/button/span/mat-icon")));
				quiz = matIcon.get(j);
				WebDriverWait clickableWait = new WebDriverWait(driver, Duration.ofSeconds(5));
				clickableWait.until(ExpectedConditions.elementToBeClickable(quiz));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", quiz);
				Thread.sleep(2000); 
			} catch (StaleElementReferenceException e) {

				System.out.println("stale Element reference Exception, retrying...");
				j--; // retry the same iteration
				continue;
			} catch (Exception e) {
				System.out.println("Error occurred while clicking quiz: " + e.getMessage());
			}
			cp.scrollWithRobot();
			driver.switchTo().frame(iFrame);
			wait.until(ExpectedConditions.elementToBeClickable(BeginTest));
			wait.until(ExpectedConditions.visibilityOf(BeginTest));
			cp.scrollWithRobot();

			Actions s = new Actions(driver);
			s.moveToElement(BeginTest).click().perform();
			List<WebElement> questions = driver.findElements(By.xpath("//div[@class='question_area']/child::button/child::span[2]"));
			int numberOfQuestions = questions.size();
			System.out.println("Total number of questions: " + numberOfQuestions);

			for (int i = 0; i < numberOfQuestions; i++) {
				try {

					WebElement questionElement = driver.findElement(By.xpath("(//div[@class='mdc-radio'])[1] | //p[@class='ck-placeholder'] | //input[@class='ng-untouched ng-pristine ng-valid ng-star-inserted']")); 
					WebElement NextQ = driver.findElement(By.xpath("//mat-icon[text()='chevron_right']"));

					String elementType = questionElement.getAttribute("class"); 
					if (elementType.contains("mdc-radio")) {
						wait.until(ExpectedConditions.elementToBeClickable(questionElement));
						questionElement.click();

					}
					else if (elementType.contains("ck-placeholder")) {

						wait.until(ExpectedConditions.elementToBeClickable(questionElement));
						questionElement.click();
						questionElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
						questionElement.sendKeys(Keys.chord(Keys.CONTROL, "x"));
						StaticWait(1);
						questionElement.click();
						questionElement.sendKeys(generateRandomString());
						//questionElement.sendKeys("Extended Text Answer");
						StaticWait(1);

					} 

					else if (elementType.contains("ng-untouched ng-pristine ng-valid ng-star-inserted")) {

						wait.until(ExpectedConditions.elementToBeClickable(questionElement));
						questionElement.click();
						questionElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
						questionElement.sendKeys(Keys.chord(Keys.CONTROL, "x"));
						StaticWait(1);
						questionElement.click();
						questionElement.sendKeys(generateRandomString());
						//questionElement.sendKeys("fill in");
					} 

					wait.until(ExpectedConditions.elementToBeClickable(NextQ));
					JavascriptExecutor jsnv = (JavascriptExecutor) driver;
					jsnv.executeScript("arguments[0].click();", NextQ);
					WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(2));
					wait1.until(ExpectedConditions.stalenessOf(NextQ));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			wait.until(ExpectedConditions.elementToBeClickable(Finish));
			wait.until(ExpectedConditions.visibilityOf(Finish));
			Finish.click();
			wait.until(ExpectedConditions.elementToBeClickable(Submit));
			wait.until(ExpectedConditions.visibilityOf(Submit));
			Submit.click();
			StaticWait(2);
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.elementToBeClickable(CloseAfterSubmit));
			wait.until(ExpectedConditions.visibilityOf(CloseAfterSubmit));
			CloseAfterSubmit.click();
		}
	}
}






