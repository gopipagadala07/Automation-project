package com.PortfolioCenter.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
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
	Random random = new Random();
	static int randomScore;



	@FindBy(how=How.XPATH,using = "//*[text()='done']/parent::div/parent::span/parent::button")private WebElement ScoreBtn;
	@FindBy(how=How.XPATH,using = "//*[@name='scoreField']")private WebElement Scorefield;
	@FindBy(how=How.XPATH,using = "//*[text()='Comments']/parent::label/parent::span/parent::div/child::textarea")private WebElement CommentsElement;
	@FindBy(how=How.XPATH,using = "//button[@aria-label='savePortfolio']")private WebElement  SavScoreBtn ;
	@FindBy(how=How.XPATH,using = "//*[text()='search here']/parent::label/parent::span/preceding-sibling::input")private WebElement inputsearchhereElement;
	@FindBy(how=How.XPATH,using = "//*[@role='rowgroup']/child::tr/child::td/child::span[text()='Completed']")private WebElement statusElement;
	@FindBy(how=How.XPATH,using = "//*[text()='PERFORMANCE REPORT']/parent::div")private WebElement PerformanceReportelement;
	//	@FindBy(how=How.XPATH,using = "")
	//	private WebElement StandardScore;
	@FindBy(how=How.XPATH,using = "//*[local-name()='svg' and @matTooltip='Report Card']/parent::div")private WebElement ReportCardTab;
	@FindBy(how=How.XPATH,using = "//table/child::tbody/child::tr/child::td/child::div")private WebElement StandardScoreElement;

	@FindBy(how = How.XPATH,using = "(//*[text()='more_vert']/parent::span/parent::button)[2]")private WebElement ellipses;
	@FindBy(how = How.XPATH,using = "//*[text()='Award Badge']/parent::button")private WebElement AwardBadge;
	@FindBy(how = How.XPATH,using = "//table/tbody/tr/td[6]/span")private WebElement TotalScore;
	@FindBy(how = How.XPATH,using = "//table/tbody/tr/td[2]/descendant::div[3]")private WebElement StandardScore;
	@FindBy(how = How.XPATH,using = "//h4[text()='Mastery by Standard']")private WebElement Standardmastery;

	public WebElement PortfolioName(String PortfolioCourseName) {
		//		String xpath ="//*[@class='mat-card-header-text']/child::mat-card-title/child::span/child::b[text()='"+PortfolioCourseName+"']";
		String xpath="//b['"+PortfolioCourseName+"']";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement ScoreAssignmentName(String ACName) {
		String xpath = "//*[text()='"+ACName+"']/parent::div";
		return driver.findElement(By.xpath(xpath));
	}

	public ScoreSubmissionPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}

	public void the_user_searches_for_the_course_and_clicks_on_it(Integer CourseName) throws InvalidFormatException, IOException {	
		StaticWait(1);
		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/TestDataDetails.xlsx", getSheetEnv());
		}
		String PortfolioName = testdata.get(CourseName).get("CourseName");
		retrySearchForCourseName(PortfolioName, 5);
	}

	public void retrySearchForCourseName(String PortfolioCourseName, int retryCount) {
		int attempts = 0;
		boolean isSuccessful = false;
		while (attempts < retryCount && !isSuccessful) {
			try {
				cp.searchField(PortfolioCourseName);
				wait.visibilityOf(PortfolioName(PortfolioCourseName));
				if(PortfolioCourseName.equalsIgnoreCase(PortfolioName(PortfolioCourseName).getText()))
				{
					JavascriptExecutor jc = (JavascriptExecutor) driver;
					jc.executeScript("arguments[0].click();", PortfolioName(PortfolioCourseName));
					isSuccessful = true;
					break;
				}
			} catch (Exception e) {
				attempts++;
				System.out.println("Attempt " + attempts + " failed: " + e.getMessage());
				if (attempts >= retryCount) {
					throw new RuntimeException("Failed to search and click on course name after " + retryCount + " attempts.", e);
				}
			}
		}
	}

	public void the_user_clicks_on_the_assignment_then_click_on_score_student_portfolio_button_assignment_name(Integer AssignmentName) throws InvalidFormatException, IOException {
		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/TestDataDetails.xlsx", getSheetEnv());
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

	public void enter_the_score_and_comments_and_submit_the_score_score() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		StaticWait(2);
		try {
			j.executeScript("arguments[0].scrollIntoView(true);", Scorefield);
			StaticWait(1);
			wait.elementToBeClickable(Scorefield);
			j.executeScript("arguments[0].click();", Scorefield);
		} catch (Exception e) {
			try {
				WebElement alternateScoreField = driver.findElement(By.xpath("//*[text()='Score']/parent::label/parent::span"));
				j.executeScript("arguments[0].scrollIntoView(true);", alternateScoreField);
				StaticWait(2);
				wait.elementToBeClickable(alternateScoreField);
				j.executeScript("arguments[0].click();", alternateScoreField);
			} catch (Exception innerException) {
				System.out.println("Failed to interact with both primary and alternate Scorefield elements.");
				innerException.printStackTrace();
			}
		}
		randomScore = random.nextInt(61) + 40;
		if(Scorefield!=null)
		{
			Scorefield.clear();
		}
		Scorefield.sendKeys(String.valueOf(randomScore));
		wait.elementToBeClickable(CommentsElement);
		j.executeScript("arguments[0].click();", CommentsElement);
		CommentsElement.sendKeys(generateRandomString());     
		wait.elementToBeClickable(SavScoreBtn);
		j.executeScript("arguments[0].click();", SavScoreBtn);
		StaticWait(1);
		j.executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");
		String Total= TotalScore.getText();
		StaticWait(1);
		if (Total.equals(String.valueOf(randomScore))) {
			System.out.println("Score Added ");
		} else {
			System.out.println("Score Not Added ");
		}			
	}


	public void the_user_is_awarded_the_badge() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		wait.elementToBeClickable(ellipses);
		je.executeScript("arguments[0].click();", ellipses);
		wait.elementToBeClickable(AwardBadge);
		if(AwardBadge.isDisplayed())
		{
			je.executeScript("arguments[0].click();", AwardBadge);
		}
		else
		{
			System.out.println("Badge Not yet Created...!!!!");
		}		
	}

	public void the_user_clicks_on_the_assignment_and_validates_the_status_and_performance_report() {

		try {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", statusElement);
			String status = statusElement.getText();
			if (status != null && status.contains("Completed")) { 
				System.out.println("Status Added");
			} else {
				System.out.println("Status Not Added");
			}
			StaticWait(1);
		} catch (StaleElementReferenceException e) {

		}

	}
	public void the_user_clicks_on_the_report_card_tab_and_validates_the_score_in_the_report_card(){
		JavascriptExecutor j = (JavascriptExecutor) driver;
		Actions a = new Actions(driver);

		boolean isClicked = false;
		int retryCount = 3;

		for (int i = 0; i < retryCount; i++) {
		    try {
		        a.moveToElement(PerformanceReportelement).build().perform();
		        StaticWait(1);
		        a.click().build().perform();
		        if (Standardmastery.isDisplayed()) {
		            isClicked = true;
		            break;
		        }
		    } catch (Exception e) {
		        System.out.println("Attempt " + (i + 1) + " failed: " + e.getMessage());
		    }
		}

		if (!isClicked) {
		    try {
		        j.executeScript("arguments[0].click();", PerformanceReportelement);
		        System.out.println("Clicked using JavaScriptExecutor..!!");
		    } catch (Exception e) {
		        System.out.println("JavaScript click failed: " + e.getMessage());
		    }
		}

		String Total = StandardScore.getText();
		if (Total != null && String.valueOf(randomScore).toString().equals(Total)) {
			System.out.println("Score Added: " + Total);
		} else {
			System.out.println("Score Not Added: " + Total);
		}
		j.executeScript("arguments[0].click();", ReportCardTab);
		StaticWait(1);
		String TotalScore = StandardScoreElement.getText();
		if (TotalScore != null && TotalScore.contains(String.valueOf(randomScore))) {
			System.out.println("Score Added in Report Card : " + TotalScore);
		} else {
			System.out.println("Score Not Added in Report Card : " + TotalScore);
		}
	}
}
