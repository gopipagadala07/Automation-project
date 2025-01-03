package com.Assessments.pages;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
import com.Utils.Wait;
import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
	private WebElement Examlist;

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

	public void ClickOnLaunchAndCompleteExam() throws AWTException, InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    int retry = 0;
	    int maxRetry = 5;
	    try {
	        wait.until(ExpectedConditions.visibilityOf(Examlist));
	    } catch (Exception e) {
	        System.out.println("Examlist element not found, exiting...");
	        return;
	    }

	    while (retry < maxRetry) {
	        try {
	        	StaticWait(1);
	            js.executeScript("arguments[0].click();", Examlist);
	            StaticWait(2);
	            driver.switchTo().frame(0);
	            WebElement beginTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Begin Test')]")));
	            js.executeScript("arguments[0].click();", beginTest);

	            List<WebElement> questions = driver.findElements(By.xpath("//div[@id='navigationSideMenu']/ul/li/div/button"));
	            int numberOfQuestions = questions.size();
	            //System.out.println("Total number of questions: " + numberOfQuestions);
	            for (int i = 0; i < numberOfQuestions; i++) {
	                int questionAttempts = 0;
	                int questionMaxAttempts = 5;
	                while (questionAttempts < questionMaxAttempts) {
	                    try {
	                        WebElement question = driver.findElement(By.xpath("//*[contains(@responseidentifier, 'RESPONSE')]"));
	                        String tagName = question.getTagName();
	                        StaticWait(1);

	                        if (tagName.equalsIgnoreCase("choiceinteraction")) {
	                            WebElement choiceValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mdc-radio'])[2]")));
	                            new Actions(driver).moveToElement(choiceValue).click().perform();
	                            StaticWait(1);
	                        } else if (tagName.equalsIgnoreCase("extendedtextinteraction")) {
	                            WebElement extendedValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='ck-placeholder']")));
	                            StaticWait(1);
	                            extendedValue.sendKeys(generateRandomString());
	                            StaticWait(1);
	                        } else if (tagName.equalsIgnoreCase("textentryinteraction")) {
	                            WebElement fillInTheBlankValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEditorInteraction")));
	                            fillInTheBlankValue.click();
	                            //                            fillInTheBlankValue.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	                            //                            fillInTheBlankValue.sendKeys(Keys.BACK_SPACE);
	                            fillInTheBlankValue.sendKeys(generateRandomString());
	                        }
	                        WebElement nextBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@mattooltip='Next']")));
	                        js.executeScript("arguments[0].click();", nextBtn);
	                        StaticWait(2);
	                        break;
	                    } catch (StaleElementReferenceException e) {
	                        System.out.println("Attempt " + (questionAttempts + 1) + " - StaleElementReferenceException encountered. Retrying...");
	                        questionAttempts++;
	                    }
	                }
	            }

	            WebElement finish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Finish']")));
	            wait.until(ExpectedConditions.elementToBeClickable(finish));
	            js.executeScript("arguments[0].click();", finish);
	            StaticWait(1);

	            WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Submit']")));
	            wait.until(ExpectedConditions.elementToBeClickable(submit));
	            js.executeScript("arguments[0].click();", submit);
	            StaticWait(2);

	            driver.switchTo().defaultContent();
	            WebElement closeAfterSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[@mattooltip='Close']")));
	            wait.until(ExpectedConditions.elementToBeClickable(closeAfterSubmit));
	            js.executeScript("arguments[0].click();", closeAfterSubmit);
	            StaticWait(1);
	            System.out.println("Exam Submitted Successfully...!!!");
	            break;

	        } catch (Exception e) {
	            System.out.println("Attempt " + (retry + 1) + " failed with exception: " + e.getMessage());
	        }
	        retry++;
	        if (retry == maxRetry) {
	            System.out.println("Failed to process quiz icon at index: " + retry + " after " + maxRetry + " retries.");
	            break;
	        }
	    }
	}

}













