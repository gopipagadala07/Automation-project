package com.Assessments.pages;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.Wait;

import io.cucumber.java.lu.an;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.time.Duration;


import javax.xml.xpath.XPath;

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

public class PerformingexamPages extends ActionType {

	CommonPages cp = new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;

	@FindBy(how=How.XPATH,using="//div[contains(text(),'EXAM')]")private WebElement ExamTab;

	@FindBy(how=How.XPATH,using="(//div[@class=\"mdc-radio\"])[1]")private WebElement McqAnswer;
	@FindBy(how=How.XPATH,using="//input[@type='text']")private WebElement FillAndExtended;

	@FindBy(how=How.XPATH,using="//mat-icon[text()='chevron_right']")private WebElement NextQ;
	@FindBy(how=How.XPATH,using="//span[text()='Finish']")private WebElement Finish;
	@FindBy(how=How.XPATH,using="//span[text()='Submit']")private WebElement Submit;
	@FindBy(how=How.XPATH,using="//mat-icon[@mattooltip='Close']")private WebElement CloseAfterSubmit;

	@FindBy(how=How.XPATH,using="//span[@mattooltip='Assessments']")private WebElement AssessmentTab;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='launch']/parent::span")private WebElement LaunchIcon;
	@FindBy(how=How.XPATH,using="//span[text()=' Begin Test ']")private WebElement BeginTest;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='close']/parent::span")private WebElement CloseIcon;
	@FindBy(how=How.XPATH,using="//iframe[@class='iframe-styling ng-star-inserted']")private WebElement iFrame;

	
//	@FindBy(how=How.XPATH,using = "(//mat-tab-body/div/following::mat-tab-body)[2]/div/app-benchmark-delivery/div/div[2]/div/div/span/following::div[2]/child::button/span/child::mat-icon")
//	private WebElement LaunchFromBenchmarktab;
//	@FindBy(how=How.XPATH,using="//div/cdk-nested-tree-node/div/div/div/div/div/child::button/child::span/child::mat-icon")
//	private WebElement LaunchfromAssessmentTab;
	
	@FindBy(how=How.XPATH,using="(//div[@role='tab'])[3]")private WebElement BenchmarksTab;
	



	//	@FindBy(how=How.XPATH,using="//p[@class='ck-placeholder']")private WebElement extended;
	//	@FindBy(how=How.XPATH,using="(//div[@class='mdc-radio'])[1]")private WebElement choice;
	//	@FindBy(how=How.XPATH,using="//mat-card/div")private WebElement choicetag;
	//	@FindBy(how=How.XPATH,using="//extendedtextinteraction[@responseidentifier='RESPONSE']")private WebElement ExtendedTag;
	//	

	@FindBy(how = How.XPATH, using = "(//mat-tab-body/div/following::mat-tab-body)[2]/div/app-benchmark-delivery/div/div[2]/div/div/span/following::div[2]/child::button/span/child::mat-icon")
	private List<WebElement> Examlist;

	public PerformingexamPages(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void ClickONbenchmarksTab() {
		wait.elementToBeClickable(BenchmarksTab);
		wait.visibilityOf(BenchmarksTab);
		BenchmarksTab.click();
	}

	@SuppressWarnings("unused")
	public void ClickOnLaunchAndCompleteExam() throws AWTException, InterruptedException {
		System.out.println("Total Exams: " + Examlist.size());
		//
		Robot robot = new Robot();

		for (int j = 0; j < Examlist.size(); j++) {
			WebElement quiz = Examlist.get(j);


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
					//System.out.println("Done");
				}
			}

			wait.elementToBeClickable(Finish);
			wait.visibilityOf(Finish);
			Finish.click();
			StaticWait(2);
			wait.elementToBeClickable(Submit);
			wait.visibilityOf(Submit);
			Submit.click();
			StaticWait(2);
			driver.switchTo().defaultContent();
			wait.elementToBeClickable(CloseAfterSubmit);
			wait.visibilityOf(CloseAfterSubmit);
			CloseAfterSubmit.click();
		}
	}
}













