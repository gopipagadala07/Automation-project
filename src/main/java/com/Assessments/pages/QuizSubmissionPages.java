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



	@FindBy(how = How.XPATH, using = "//cdk-nested-tree-node[@role='treeitem']/child::div/child::div[2]/cdk-nested-tree-node/child::div/child::small/following::div/child::span/child::mat-icon")
	private List<WebElement> Quizzeslist;

	public QuizSubmissionPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void ClickOnLaunchAndCompleteTest() throws AWTException, InterruptedException {
		System.out.println("Total Quizzes: " + Quizzeslist.size());
		//
		Robot robot = new Robot();

		for (int j = 0; j < Quizzeslist.size(); j++) {
			WebElement quiz = Quizzeslist.get(j);


			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", quiz);
			StaticWait(2);


			cp.scrollWithRobot();
			driver.switchTo().frame(iFrame);
			wait.elementToBeClickable(BeginTest);
			wait.visibilityOf(BeginTest);
			cp.scrollWithRobot();

			Actions actions = new Actions(driver);
			actions.moveToElement(BeginTest).click().perform();


			List<WebElement> questions = driver.findElements(By.xpath("//div[@class='question_area']/child::button/child::span[2]"));
			int numberOfQuestions = questions.size();
			System.out.println("Total number of questions: " + numberOfQuestions);


			for (int i = 0; i < numberOfQuestions; i++) {
				try {

					WebElement questionElement = driver.findElement(By.xpath("(//div[@class='mdc-radio'])[1] | //p[@class='ck-placeholder'] | //input[@class='ng-untouched ng-pristine ng-valid ng-star-inserted']")); 
					WebElement NextQ = driver.findElement(By.xpath("//mat-icon[text()='chevron_right']"));
					
					String elementType = questionElement.getAttribute("class"); 
					if (elementType.contains("mdc-radio")) {

						wait.elementToBeClickable(questionElement);
						questionElement.click();
						//System.out.println("Selected MCQ option for question ");
					}
					else if (elementType.contains("ck-placeholder")) {

						wait.elementToBeClickable(questionElement);
						questionElement.click();
						questionElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
						questionElement.sendKeys(Keys.chord(Keys.CONTROL, "x"));
						StaticWait(1);
						questionElement.click();
						questionElement.sendKeys("Extended Text Answer");
						StaticWait(1);
						//System.out.println("extended answer");
					} 
					
					else if (elementType.contains("ng-untouched ng-pristine ng-valid ng-star-inserted")) {

						wait.elementToBeClickable(questionElement);
						questionElement.click();
						questionElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
						questionElement.sendKeys(Keys.chord(Keys.CONTROL, "x"));
						StaticWait(1);
						questionElement.click();
						questionElement.sendKeys("fill in");
						//System.out.println("Filled in the blank for question ");
					} 
					
					wait.elementToBeClickable(NextQ);
					JavascriptExecutor jsnv = (JavascriptExecutor) driver;
					jsnv.executeScript("arguments[0].click();", NextQ);
					WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
					wait.until(ExpectedConditions.stalenessOf(NextQ));
				} catch (Exception e) {
					System.out.println("Done");
				}
			}

			wait.elementToBeClickable(Finish);
			wait.visibilityOf(Finish);
			Finish.click();
			wait.elementToBeClickable(Submit);
			wait.visibilityOf(Submit);
			Submit.click();
			driver.switchTo().defaultContent();
			wait.elementToBeClickable(CloseAfterSubmit);
			wait.visibilityOf(CloseAfterSubmit);
			CloseAfterSubmit.click();
		}
	}
}






