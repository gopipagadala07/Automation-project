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

import io.reactivex.rxjava3.functions.Action;


public class MultiScoringSubmissionPages extends ActionType{
	static List<Map<String, String>> testdata=null;
	ExcelReader reader = new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;
	static String MultiPortfolioCourseName;
	static String Multiassignmentname;
	static int number = randomNumberGeneratorstatic();
	
	
	@FindBy(how=How.XPATH,using = "//*[text()='more_vert']/ancestor::button")private WebElement EllipseBtn;
	@FindBy(how=How.XPATH,using = "//*[text()='Multi Scoring']/ancestor::button")private WebElement MultScoringBtn;
	@FindBy(how=How.XPATH,using = "(//table/child::tbody/child::tr/child::td/child::input)[1]")private WebElement Score1Btn;
	@FindBy(how=How.XPATH,using = "(//table/child::tbody/child::tr/child::td/child::input)[2]")private WebElement Score2Btn;
	@FindBy(how=How.XPATH,using = "(//table/child::tbody/child::tr/child::td/child::input)[3]")private WebElement Score3Btn;
	@FindBy(how=How.XPATH,using = "//*[text()=' Save Score ']/parent::button")private WebElement  SavScoreBtn ;
	
	
	
	
	
//	@FindBy(how=How.XPATH,using = "//*[text()='done']/parent::div/parent::span/parent::button")private WebElement ScoreBtn;
	@FindBy(how=How.XPATH,using = "//*[@name='scoreField']")private WebElement Scorefield;
	@FindBy(how=How.XPATH,using = "//*[text()='Comments']/parent::label/parent::span/parent::div/child::textarea")private WebElement CommentsElement;
//	@FindBy(how=How.XPATH,using = "//*[text()=' Save Score ']/parent::button")private WebElement  SavScoreBtn ;
	@FindBy(how=How.XPATH,using = "//*[text()='search here']/parent::label/parent::span/preceding-sibling::input")private WebElement inputsearchhereElement;
	@FindBy(how=How.XPATH,using = "//*[@role='rowgroup']/child::tr/child::td/child::span[text()='Completed']")private WebElement statusElement;
	@FindBy(how=How.XPATH,using = "//*[text()='PERFORMANCE REPORT']/parent::div")private WebElement PerformanceReportelement;
	@FindBy(how=How.XPATH,using = "//*[local-name()='svg' and @matTooltip='Report Card']/parent::div")private WebElement ReportCardTab;
	@FindBy(how=How.XPATH,using = "//table/child::tbody/child::tr/child::td/child::div")private WebElement StandardScoreElement;
	
	@FindBy(how = How.XPATH,using = "(//*[text()='more_vert']/parent::span/parent::button)[2]")private WebElement ellipses1;
	@FindBy(how = How.XPATH,using = "(//*[text()='more_vert']/parent::span/parent::button)[3]")private WebElement ellipses2;
	@FindBy(how = How.XPATH,using = "(//*[text()='more_vert']/parent::span/parent::button)[4]")private WebElement ellipses3;
	@FindBy(how = How.XPATH,using = "//*[text()='Award Badge']/parent::button")private WebElement AwardBadge;
	
	
	
	

	public WebElement MultiPortfolioCourseName(String MultiPortfolioCourseName) {
		String xpath ="//*[@class='mat-card-header-text']/child::mat-card-title/child::span/child::b[text()='"+MultiPortfolioCourseName+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement Multiassignmentname(String Multiassignmentname) {
		String xpath = "//*[text()='"+Multiassignmentname+"']/parent::div/parent::mat-card";
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
	
	
	public WebElement MultiPortfolioName(String PortfolioCourseName) {
		String xpath ="//*[@class='mat-card-header-text']/child::mat-card-title/child::span/child::b[text()='"+PortfolioCourseName+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	public MultiScoringSubmissionPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}
	
	
	
	
	public void the_user_searches_for_the_multi_scoring_portfolio_course(Integer MultiScoringCourseName)throws InvalidFormatException, IOException {
		StaticWait(1);
	     JavascriptExecutor jc = (JavascriptExecutor) driver;
	     wait.elementToBeClickable(inputsearchhereElement);
			jc.executeScript("arguments[0].click();", inputsearchhereElement); 
			if (testdata == null) {
				testdata = reader.getData("/ExcelFiles/PortfolioCenter.xlsx", getSheetEnv());
			}
			String MultiPortfolioCourse = testdata.get(MultiScoringCourseName).get("MultiScoringCourseName");
//	     cp.searchField(MultiPortfolioCourse);
			System.out.println(MultiPortfolioCourse);
			wait.elementToBeClickable(inputsearchhereElement);
			inputsearchhereElement.click();
			inputsearchhereElement.sendKeys(MultiPortfolioCourse);
	     StaticWait(4);
	     wait.visibilityOf(MultiPortfolioName(MultiPortfolioCourse));
//	     PortfolioName(PortfolioCourseName).click();	 
	     jc.executeScript("arguments[0].click();", MultiPortfolioName(MultiPortfolioCourse));
	}
	
	
	public void the_user_clicks_on_the_multi_scoring_assignment_then_click_on_multi_scoring_button(Integer MultiAssignmentName) throws InvalidFormatException, IOException {
		StaticWait(2);
		JavascriptExecutor jc = (JavascriptExecutor) driver;
		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/PortfolioCenter.xlsx", getSheetEnv());
		}
		String MultiPortfolioName = testdata.get(MultiAssignmentName).get("MultiAssignmentName");
	     wait.elementToBeClickable(Multiassignmentname(MultiPortfolioName));
	     Multiassignmentname(MultiPortfolioName).click();
	     StaticWait(2);
	     wait.elementToBeClickable(EllipseBtn);
	     EllipseBtn.click();
	     wait.elementToBeClickable(MultScoringBtn);
	     MultScoringBtn.click();
	     
	}

	
	public void enter_the_score_and_submit_the_score(Integer Score1, Integer Score2, Integer Score3) throws InvalidFormatException, IOException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
//		wait.elementToBeClickable(Score1Btn);
//		Score1Btn.click();
//		
//	     j.executeScript("arguments[0].scrollIntoView(true);", Scorefield);
//	     wait.elementToBeClickable(Scorefield);
//	     j.executeScript("arguments[0].click();", Scorefield);
	     if (testdata == null) {
				testdata = reader.getData("/ExcelFiles/PortfolioCenter.xlsx", getSheetEnv());
			}
	     	wait.elementToBeClickable(Score1Btn);
			Score1Btn.click();
			String Number1 = testdata.get(Score1).get("Score1");
			Score1Btn.sendKeys(Number1);
			wait.elementToBeClickable(Score2Btn);
			Score2Btn.click();
			String Number2 = testdata.get(Score2).get("Score2");
			Score2Btn.sendKeys(Number2);
			wait.elementToBeClickable(Score3Btn);
			Score3Btn.click();
			String Number3 = testdata.get(Score3).get("Score3");
			Score3Btn.sendKeys(Number3);
		     wait.elementToBeClickable(SavScoreBtn);
		     j.executeScript("arguments[0].click();", SavScoreBtn);
		    
		     
	}

	public void the_user_is_awarded_the_badge_for_the_multi_scoring_portfolio_course() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		StaticWait(1);
	    wait.elementToBeClickable(ellipses1);
	    je.executeScript("arguments[0].click();", ellipses1);
//	    wait.visibilityOf(AwardBadge);
	    StaticWait(2);
	    wait.elementToBeClickable(AwardBadge);
	    je.executeScript("arguments[0].click();", AwardBadge);
	    StaticWait(5);
	    
	}
	
	
	public void the_user_clicks_on_the_multi_scoring_assignment_and_validates_the_status_and_performance_report() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", statusElement);
		String status = statusElement.getText();
		if (status != null && status.contains("Completed")) { 
		    System.out.println("Status Added");
		} else {
		    System.out.println("Status Not Added");
		}
	}
	
	
}
