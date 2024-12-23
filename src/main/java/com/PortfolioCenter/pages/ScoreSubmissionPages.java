package com.PortfolioCenter.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;
import com.Utils.Wait;


public class ScoreSubmissionPages extends ActionType{
	static List<Map<String, String>> testdata=null;
	ExcelReader reader = new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;
	static String PortfolioCourseName;
	static String assignmentname;
	static int number = randomNumberGeneratorstatic();
	
	
	
	@FindBy(how=How.XPATH,using = "//*[text()='done']/parent::div/parent::span/parent::button")private WebElement ScoreBtn;
	@FindBy(how=How.XPATH,using = "//*[@name='scoreField']")private WebElement Scorefield;
	@FindBy(how=How.XPATH,using = "//*[text()='Comments']/parent::label/parent::span/parent::div/child::textarea")private WebElement CommentsElement;
	@FindBy(how=How.XPATH,using = "//*[text()=' Save Score ']/parent::button")private WebElement  SavScoreBtn ;
	@FindBy(how=How.XPATH,using = "//*[text()='search here']/parent::label/parent::span/preceding-sibling::input")private WebElement inputsearchhereElement;
	@FindBy(how=How.XPATH,using = "//*[@role='rowgroup']/child::tr/child::td/child::span[text()='Completed']")private WebElement statusElement;
	@FindBy(how=How.XPATH,using = "//*[text()='PERFORMANCE REPORT']/parent::div")private WebElement PerformanceReportelement;
//	@FindBy(how=How.XPATH,using = "")
//	private WebElement StandardScore;
	@FindBy(how=How.XPATH,using = "//*[local-name()='svg' and @matTooltip='Report Card']/parent::div")private WebElement ReportCardTab;
	@FindBy(how=How.XPATH,using = "//table/child::tbody/child::tr/child::td/child::div")private WebElement StandardScoreElement;
	
	
	
	
	
	

	public WebElement PortfolioName(String PortfolioCourseName) {
		String xpath ="//*[@class='mat-card-header-text']/child::mat-card-title/child::span/child::b[text()='"+PortfolioCourseName+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement ScoreAssignmentName(String ACName) {
		String xpath = "//*[text()='"+ACName+"']/parent::div";
		return driver.findElement(By.xpath(xpath));
	}
	
	
	public WebElement TotalScore(String Score) {
		String xpath = "//*[@role='rowgroup']/child::tr/child::td/child::span[text()=' "+Score+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement StandardScore(String Score) {
		String xpath = "//table/child::tbody/child::tr/child::td/child::div/child::div/child::div/child::div/child::small[text()='"+Score+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	public ScoreSubmissionPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}
	
	
	public void the_user_searches_for_the_course_and_clicks_on_it(Integer CourseName) throws InvalidFormatException, IOException {
		StaticWait(2);
		JavascriptExecutor jc = (JavascriptExecutor) driver;
		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
		}
		String PortfolioName = testdata.get(CourseName).get("CourseName");
		wait.elementToBeClickable(inputsearchhereElement);
		jc.executeScript("arguments[0].click();", inputsearchhereElement); 
		StaticWait(1);
		inputsearchhereElement.sendKeys(PortfolioName);
		StaticWait(2);
//		inputsearchhereElement.sendKeys(Keys.BACK_SPACE);
	     StaticWait(4);
	     wait.visibilityOf(PortfolioName(PortfolioName));
	     jc.executeScript("arguments[0].click();", PortfolioName(PortfolioName));  
	}
	
	
	public void the_user_clicks_on_the_assignment_then_click_on_score_student_portfolio_button_assignment_name(Integer AssignmentName) throws InvalidFormatException, IOException {
		 if (testdata == null) {
				testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
			}
			String ScoreAssignment = testdata.get(AssignmentName).get("AssignmentName");
			Actions act = new Actions(driver);
			act.moveToElement(ScoreAssignmentName(ScoreAssignment)).perform();
			act.click().perform();
		     StaticWait(1);
		     JavascriptExecutor js = (JavascriptExecutor) driver;
		     js.executeScript("arguments[0].scrollIntoView(true);", ScoreBtn);
		     wait.elementToBeClickable(ScoreBtn);
		     js.executeScript("arguments[0].click();", ScoreBtn);
		     
	}


	public void enter_the_score_and_comments_and_submit_the_score_score(Integer Score) throws InvalidFormatException, IOException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
	     j.executeScript("arguments[0].scrollIntoView(true);", Scorefield);
	     wait.elementToBeClickable(Scorefield);
	     j.executeScript("arguments[0].click();", Scorefield);
	     if (testdata == null) {
				testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
			}
			String Number = testdata.get(Score).get("Score");
			Scorefield.sendKeys(Number);
			wait.elementToBeClickable(CommentsElement);
		     j.executeScript("arguments[0].click();", CommentsElement);
		     CommentsElement.sendKeys(generateRandomString());
		     wait.elementToBeClickable(SavScoreBtn);
		     j.executeScript("arguments[0].click();", SavScoreBtn);
		     StaticWait(2);
		     j.executeScript("arguments[0].scrollIntoView(true);", TotalScore(Number));
		     String Total= TotalScore(Number).getText();
		     if (Number != null && Number == Total) {
		    	 System.out.println("Score Added ");
				} else {
				    System.out.println("Score Not Added ");
				}
		     
		     
		     
		     
			
}

	
	public void the_user_clicks_on_the_assignment_and_validates_the_status_and_performance_report() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", statusElement);
		String status = statusElement.getText();
		if (status != null && status.contains("Completed")) { 
		    System.out.println("Status Added");
		} else {
		    System.out.println("Status Not Added");
		}
		
	}
	public void the_user_clicks_on_the_report_card_tab_and_validates_the_score_in_the_report_card(Integer Score) throws InvalidFormatException, IOException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		wait.elementToBeClickable(PerformanceReportelement);
		j.executeScript("arguments[0].click();", PerformanceReportelement);
		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
		}
		String Number = testdata.get(Score).get("Score");
		wait.visibilityOf(StandardScore(Number));
		 String Total= StandardScore(Number).getText();
	     if (Number != null && Number == Total) {
			    System.out.println("Score Added : " +Total);
			} else {
			    System.out.println("Score Not Added : "+Total);
			}
	     wait.elementToBeClickable(ReportCardTab);
	     j.executeScript("arguments[0].click();", ReportCardTab);
	     String TotalScore= StandardScoreElement.getText();
	     if (Number != null && Number == TotalScore) {
			    System.out.println("Score Added in Report Card : " +TotalScore);
			} else {
			    System.out.println("Score Not Added in Report Card : "+TotalScore);
			}
	}
	
	
}
