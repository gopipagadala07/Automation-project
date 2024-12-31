package com.Assessments.pages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
import com.Utils.Wait;
import java.awt.AWTException;
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

public class QuizSubmissionPages extends ActionType {

	CommonPages cp = new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;
	@FindBy(how=How.XPATH,using="//span[@mattooltip='Assessments']")private WebElement AssessmentTab;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='launch']/parent::span")private List<WebElement> LaunchIcon;
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
		StaticWait(2);
		JavascriptExecutor s = (JavascriptExecutor) driver;
		s.executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");
		s.executeScript("arguments[0].scrollIntoView(true);", Topic);
		s.executeScript("arguments[0].click();", Topic);
		StaticWait(3);
		s.executeScript("arguments[0].scrollIntoView(true);", SubTopic);
		s.executeScript("arguments[0].click();", SubTopic);
		StaticWait(1);
	}

	public void ClickOnLaunchAndCompleteQuiz() throws AWTException, InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    List<WebElement> matIcons = driver.findElements(By.xpath("//mat-icon[text()='launch']"));
	    System.out.println("Total Quizzes Found: " + matIcons.size());

	    for (int targetIndex = 0; targetIndex < matIcons.size(); targetIndex++) {
	        int retry = 0;
	        int maxRetry = 5;
	        while (retry < maxRetry) {
	            try {
	            	matIcons = driver.findElements(By.xpath("//mat-icon[text()='launch']"));
	            	WebElement currentIcon = matIcons.get(targetIndex);
	                StaticWait(1);
	                wait.until(ExpectedConditions.elementToBeClickable(currentIcon));
	                js.executeScript("arguments[0].click();", currentIcon);

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
//	                                fillInTheBlankValue.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//	                                fillInTheBlankValue.sendKeys(Keys.BACK_SPACE);
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
	                break;
	            } catch (Exception e) {
	                System.out.println("Attempt " + (retry + 1) + " failed with exception: " + e.getMessage());
	                retry++;
	            }
	        }
	        if (retry == maxRetry) {
	            System.out.println("Failed to process quiz icon at index: " + targetIndex + " after " + maxRetry + " retries.");
	        }
	    }
	}
}
