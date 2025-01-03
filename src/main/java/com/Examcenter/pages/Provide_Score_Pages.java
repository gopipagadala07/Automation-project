package com.Examcenter.pages;

import java.time.Duration;

import org.openqa.selenium.By;
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

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
import com.Utils.Wait;

public class Provide_Score_Pages extends ActionType
{
	private WebDriver driver;
	private Wait wait;
	CommonPages cp=new CommonPages(Base.getDriver());

	@FindBy(how=How.XPATH,using = "//mat-icon[text()=' settings ']") private WebElement Adminstrationbtn;
	@FindBy(how=How.XPATH,using = "//span[text()=' Create New Login ']") private WebElement createloginbtn;
	@FindBy(how=How.XPATH,using = "//input[@data-placeholder='search here']") private WebElement searchtxt;
	@FindBy(how=How.XPATH,using = "//span[text()='Score Exams']") private WebElement Score_ExamTab;
	@FindBy(how=How.XPATH,using = "//mat-icon[text()='assignment_turned_in']") private WebElement Score_button;
	@FindBy(how=How.XPATH,using = "//iframe[@id='scoreExam']") private WebElement iframe_ScoreExam;
	@FindBy(how = How.XPATH,using = "//*[contains(text(), 'Candidate Response')]/following::div[3]/div/following::span/span/descendant::input")private WebElement Provide_Score;
	@FindBy(how = How.XPATH,using = "//div[@role='textbox']")private WebElement Provide_Feedback;
	@FindBy(how = How.XPATH,using = "//span[text()='Submit Scoring']")private WebElement Submit_score;
	@FindBy(how = How.XPATH,using = "//mat-label[text()='Examination']/ancestor::span/preceding-sibling::mat-select/ancestor::mat-form-field/child::div")private WebElement ScoreExamination;
	@FindBy(how = How.XPATH,using = "//mat-label[text()='Examination ']/ancestor::span/preceding-sibling::mat-select/ancestor::mat-form-field/child::div")private WebElement LocExamination;
	@FindBy(how = How.XPATH,using = "//mat-label[text()='Locations']/ancestor::span/preceding-sibling::mat-select/ancestor::mat-form-field/child::div")private WebElement Location_lookup;


	public Provide_Score_Pages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}		
	public void searchtxt(String L_Name, String F_Name) 
	{   
		wait.elementToBeClickable(searchtxt);
		cp.searchField(L_Name+" ");
		cp.searchField(L_Name+" "+F_Name);

		int attempts = 0;

		while (attempts < 3) {
			try {
				WebElement EN=driver.findElement(By.xpath("//span[text()='"+L_Name+" "+F_Name+"']"));
				EN.click();
				return;
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException caught. Retrying... Attempt: " + (attempts + 1));
			}
			attempts++;
		}
		throw new RuntimeException("Failed to click on the element after multiple attempts.");
	}

	public void click_on_Score_Exam_Tab() 
	{   
		wait.elementToBeClickable(Score_ExamTab);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Score_ExamTab);
	}
	public void select_Location(String Location) 
	{   
		cp.FPdropdown(Location_lookup, Location);
	}

	public void Select_the_Examination(String examname, String ScheduleName) 
	{   
		cp.FPdropdown(LocExamination, examname+" - "+ScheduleName);
	}

	public void Select_the_Examination_for_Score(String examname, String ScheduleName) 
	{   
		StaticWait(2);
	    wait.elementToBeClickable(ScoreExamination);
	    Actions actions = new Actions(driver);
	    actions.moveToElement(ScoreExamination).click().build().perform();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement Examination = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//span[text()='"+examname+" - "+ScheduleName+"']")));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", Examination);
	    js.executeScript("arguments[0].click();", Examination);
	}

	public void Location_Toggle(String Location) 
	{   
		StaticWait(1);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ELocation = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//small[text()='"+Location+"']/parent::div/following-sibling::div/child::mat-slide-toggle/child::label/child::span[1]/child::span")));	    
	    wait.until(ExpectedConditions.elementToBeClickable(ELocation));
	    System.out.println(Location);
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", ELocation);
	}

	public void Score_Exam() 
	{   
	    wait.elementToBeClickable(Score_button);
	    Score_button.click();

	    switchToFrame(iframe_ScoreExam);
	    Provide_Score.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    Provide_Score.sendKeys(Keys.chord(Keys.CONTROL, "x"));
	    Provide_Score.sendKeys("5");

	    String randomString = generateRandomString();
	    Provide_Feedback.sendKeys(randomString);

	    Submit_score.click();

	    driver.switchTo().defaultContent();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("(//mat-icon[text()='close'])[1]")));

	    Actions actions = new Actions(driver);
	    actions.moveToElement(e).click().perform();
	}

}
