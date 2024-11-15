package com.Assessments.pages;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.Utils.ActionType;
//import com.Utils.Wait;
//
//public class QuizSubmissionPages extends ActionType{
//	private Wait wait;
//
//	@FindBy(how = How.XPATH,using = "//mat-icon[@mattooltip='Launch Activity']")private WebElement launchicon;
//	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Begin Test')]")private WebElement Begintestbtn;
//	@FindBy(how = How.XPATH,using = "//div[@class='qti_item']/mat-card")private WebElement Questionelement;
//	@FindBy(how = How.XPATH,using = "(//div[@class='mdc-radio'])[2]")private WebElement Singlechoice;
//	@FindBy(how = How.XPATH,using = "//div[@role='textbox']")private WebElement ExtendedAnswer;
//	@FindBy(how = How.XPATH,using = "//input[@type='text']")private WebElement FillintheblankAnswer;
//	@FindBy(how = How.XPATH,using = "//div[@id='navigationSideMenu']/ul/li/div/button")private WebElement Questioncnt;
//	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Finish')]")private WebElement Finishbtn;
//	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Submit')]")private WebElement submitbtn;
//	@FindBy(how = How.XPATH,using = "//mat-icon[text()='close']")private WebElement close;
//
//	public QuizSubmissionPages(WebDriver driver)
//	{
//		this.driver=driver;
//		this.wait=new Wait(driver);
//	}
//
//	public void Launchicon()
//	{
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		WebElement matIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[@mattooltip='Launch Activity']")));
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", matIcon);
//	}
//	public void Begintest() {
//		StaticWait(2);
//		driver.switchTo().frame(0);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement BeginTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Begin Test')]")));
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", BeginTest);
//	}
//
//
//	public void QuestionsAnswers() {
//		List<WebElement> countQ = driver.findElements(By.xpath("//div[@id='navigationSideMenu']/ul/li/div/button"));
//		int count = countQ.size();
//		System.out.println(count);
//
//		for (int i = 0; i < count; i++) {
//			int min = 0;
//			int max = 5;
//			while (min < max) {
//				try {
//					WebElement ele = driver.findElement(By.xpath("//*[contains(@responseidentifier, 'RESPONSE')]"));
//					String tagName = ele.getTagName();
//					System.out.println(tagName);
//					StaticWait(1);
//					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//					if (tagName.equalsIgnoreCase("choiceinteraction")) {
//						WebElement ChoiceValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mdc-radio'])[2]")));
//						Actions a = new Actions(driver);
//						a.moveToElement(ChoiceValue);
//						a.click().build().perform();
//					} else if (tagName.equalsIgnoreCase("extendedtextinteraction")) {
//						WebElement ExtendedValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='ck-placeholder']")));
//						ExtendedValue.sendKeys(generateRandomString());
//					} else if (tagName.equalsIgnoreCase("textentryinteraction")) {
//						WebElement FillInTheBlankValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEditorInteraction")));
//						StaticWait(1);
//						FillInTheBlankValue.sendKeys(String.valueOf(randomNumberGenerator()));        
//					}
//					WebElement Nextbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@mattooltip='Next']")));
//					JavascriptExecutor js = (JavascriptExecutor) driver;
//					js.executeScript("arguments[0].click();", Nextbtn);
//					StaticWait(2);
//					break;
//				} catch (StaleElementReferenceException e) {
//					System.out.println("Attempt " + (min + 1) + " - StaleElementReferenceException encountered. Retrying...");
//					min++;
//				}
//			}
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			WebElement Finishbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Finish')]")));
//			Finishbtn.click();
//			WebElement Submitbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Submit')]")));
//			Submitbtn.click();
//			WebElement closeicon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[text()='close']")));
//			closeicon.click();
//		}
//	}
//
//
//
//	public void SubmitExam()
//	{
//		wait.elementToBeClickable(Finishbtn);
//		Finishbtn.click();
//		wait.elementToBeClickable(submitbtn);
//		submitbtn.click();
//		wait.elementToBeClickable(close);
//		close.click();
//	}
//
//
//	public void LaunchandSubmitQuiz()
//	{
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));		
//		WebElement Allbtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=' All ']")));
//		Allbtn.click();
//		List<WebElement> LaunchIcon = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-icon[@mattooltip='Launch Activity']")));
//		int LaunchIconcount=LaunchIcon.size();
//		System.out.println(LaunchIconcount);
//
//		for(int i=0;i<=LaunchIconcount;i++)
//		{
//			LaunchIcon.get(i).click();
//			StaticWait(2);
//			driver.switchTo().frame(0);
//			WebElement BeginTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Begin Test')]")));
//			JavascriptExecutor js=(JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", BeginTest);
//			List<WebElement> countQ = driver.findElements(By.xpath("//div[@id='navigationSideMenu']/ul/li/div/button"));
//			int count = countQ.size();
//			System.out.println(count);
//
//			for (int j = 0; j < count; j++) {
//				int min = 0;
//				int max = 5;
//				while (min < max) {
//					try {
//						WebElement ele = driver.findElement(By.xpath("//*[contains(@responseidentifier, 'RESPONSE')]"));
//						String tagName = ele.getTagName();
//						System.out.println(tagName);
//						StaticWait(1);
//
//						if (tagName.equalsIgnoreCase("choiceinteraction")) {
//							WebElement ChoiceValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mdc-radio'])[2]")));
//							Actions a = new Actions(driver);
//							a.moveToElement(ChoiceValue);
//							a.click().build().perform();
//						} else if (tagName.equalsIgnoreCase("extendedtextinteraction")) {
//							WebElement ExtendedValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='ck-placeholder']")));
//							ExtendedValue.sendKeys(generateRandomString());
//						} else if (tagName.equalsIgnoreCase("textentryinteraction")) {
//							WebElement FillInTheBlankValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEditorInteraction")));
//							StaticWait(1);
//							FillInTheBlankValue.sendKeys(String.valueOf(randomNumberGenerator()));        
//						}
//						WebElement Nextbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@mattooltip='Next']")));
//
//						js.executeScript("arguments[0].click();", Nextbtn);
//						StaticWait(2);
//						break;
//					} catch (StaleElementReferenceException e) {
//						System.out.println("Attempt " + (min + 1) + " - StaleElementReferenceException encountered. Retrying...");
//						min++;
//					}
//				}
//				WebElement Finishbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Finish')]")));
//				Finishbtn.click();
//				WebElement Submitbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Submit')]")));
//				Submitbtn.click();
//				WebElement closeicon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[text()='close']")));
//				closeicon.click();
//			}
//		}
//	}
//
//}
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
				j--;
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

