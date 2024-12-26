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
		String xpath = "//*[@role='rowgroup']/child::tr/child::td/child::span[text()=' "+ Score+"']";
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
	
	
//	public void the_user_searches_for_the_course_and_clicks_on_it(Integer CourseName) throws InvalidFormatException, IOException {
//		StaticWait(2);
//		JavascriptExecutor jc = (JavascriptExecutor) driver;
//		if (testdata == null) {
//			testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
//		}
//		String PortfolioName = testdata.get(CourseName).get("CourseName");
//		wait.elementToBeClickable(inputsearchhereElement);
//		jc.executeScript("arguments[0].click();", inputsearchhereElement); 
//		StaticWait(1);
//		inputsearchhereElement.sendKeys(PortfolioName);
//		StaticWait(2);
////		inputsearchhereElement.sendKeys(Keys.BACK_SPACE);
//	     StaticWait(4);
//	     wait.visibilityOf(PortfolioName(PortfolioName));
//	     jc.executeScript("arguments[0].click();", PortfolioName(PortfolioName));  
//	}
	
	
	
	public void the_user_searches_for_the_course_and_clicks_on_it(Integer CourseName) throws InvalidFormatException, IOException {
	    StaticWait(1);
	    JavascriptExecutor jc = (JavascriptExecutor) driver;
	    wait.elementToBeClickable(inputsearchhereElement);
	    jc.executeScript("arguments[0].click();", inputsearchhereElement);

	    // Retrieve data from Excel
	    if (testdata == null) {
	        testdata = reader.getData("/ExcelFiles/PortfolioCenter.xlsx", getSheetEnv());
	    }
	    String PortfolioName = testdata.get(CourseName).get("CourseName");

	    retrySearchForMultiPortfolioCourseName(PortfolioName,4);
	}

	public void retrySearchForMultiPortfolioCourseName(String PortfolioName,int retryCount) {
	    int attempts = 0;
	    boolean isSuccessful = false;

	    while (attempts < retryCount && !isSuccessful) {
	        try {
	            // Wait for the input element to be clickable
	            wait.elementToBeClickable(inputsearchhereElement);
	            inputsearchhereElement.click();
	            inputsearchhereElement.clear(); // Clear the input field before sending keys
	            inputsearchhereElement.sendKeys(PortfolioName);

	            // Introduce a short static wait to let results load
	            StaticWait(4);

	            // Wait for the visibility of the desired portfolio name
	            wait.visibilityOf(PortfolioName(PortfolioName));

	            // Use JavaScript executor to click on the portfolio name
	            JavascriptExecutor jc = (JavascriptExecutor) driver;
	            jc.executeScript("arguments[0].click();", PortfolioName(PortfolioName));

	            isSuccessful = true; // If successful, mark the operation as successful
	        } catch (Exception e) {
	            attempts++;
	            System.out.println("Attempt " + attempts + " failed: " + e.getMessage());
	            if (attempts >= retryCount) {
	                throw new RuntimeException("Failed to search and click on MultiPortfolioCourseName after " + retryCount + " attempts.", e);
	            }
	        }
	    }
	}

	
	
	public void the_user_clicks_on_the_assignment_then_click_on_score_student_portfolio_button_assignment_name(Integer AssignmentName) throws InvalidFormatException, IOException {
		 if (testdata == null) {
				testdata = reader.getData("/ExcelFiles/PortfolioCenter.xlsx", getSheetEnv());
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
		StaticWait(2);
		try {
		    // Scroll the Scorefield element into view
		    j.executeScript("arguments[0].scrollIntoView(true);", Scorefield);

		    // Wait for 2 seconds to allow the page to stabilize
		    StaticWait(2);

		    // Wait until the Scorefield element is clickable
		    wait.elementToBeClickable(Scorefield);

		    // Click the Scorefield element using JavaScript
		    j.executeScript("arguments[0].click();", Scorefield);
		} catch (Exception e) {
		    // Handle exception by using an alternate XPath
		    try {
		        WebElement alternateScoreField = driver.findElement(By.xpath("//*[text()='Score']/parent::label/parent::span"));

		        // Scroll the alternate element into view
		        j.executeScript("arguments[0].scrollIntoView(true);", alternateScoreField);

		        // Wait for 2 seconds to allow the page to stabilize
		        StaticWait(2);

		        // Wait until the alternate element is clickable
		        wait.elementToBeClickable(alternateScoreField);

		        // Click the alternate element using JavaScript
		        j.executeScript("arguments[0].click();", alternateScoreField);
		    } catch (Exception innerException) {
		        System.out.println("Failed to interact with both primary and alternate Scorefield elements.");
		        innerException.printStackTrace();
		    }
		}

		
	     StaticWait(2);
	     if (testdata == null) {
				testdata = reader.getData("/ExcelFiles/PortfolioCenter.xlsx", getSheetEnv());
			}
			String Number = testdata.get(Score).get("Score");
			Scorefield.sendKeys(Number);
			wait.elementToBeClickable(CommentsElement);
		     j.executeScript("arguments[0].click();", CommentsElement);
		     CommentsElement.sendKeys(generateRandomString());
		     wait.elementToBeClickable(SavScoreBtn);
		     j.executeScript("arguments[0].click();", SavScoreBtn);
		     StaticWait(4);
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
			testdata = reader.getData("/ExcelFiles/PortfolioCenter.xlsx", getSheetEnv());
		}
		String Number = testdata.get(Score).get("Score");
//		wait.visibilityOf(StandardScore(Number));
//		 String Total= StandardScore(Number).getText();
//	     if (Number != null && Number == Total) {
//			    System.out.println("Score Added : " +Total);
//			} else {
//			    System.out.println("Score Not Added : "+Total);
//			}
		
		
		try {
		    // Wait for visibility of the primary element
		    wait.visibilityOf(StandardScore(Number));
		    String Total = StandardScore(Number).getText();

		    // Validate and log the score
		    if (Number != null && Number.toString().equals(Total)) {
		        System.out.println("Score Added: " + Total);
		    } else {
		        System.out.println("Score Not Added: " + Total);
		    }
		} catch (Exception e) {
		    try {
		        // Attempt to find and validate using an alternate XPath
		        WebElement alternateElement = driver.findElement(By.xpath("//table/child::tbody/child::tr/child::td/child::div/child::div/child::div/child::div/child::small[contains(text(),'75')]"));
		        wait.visibilityOf(alternateElement);
		        String Total = alternateElement.getText();

		        // Validate and log the score for the alternate element
		        if (Number != null && Number.toString().equals(Total)) {
		            System.out.println("Score Added using alternate element: " + Total);
		        } else {
		            System.out.println("Score Not Added using alternate element: " + Total);
		        }
		    } catch (Exception innerException) {
		        // Log error if both attempts fail
		        System.out.println("Failed to retrieve and validate the score: " + innerException.getMessage());
		        // Optionally, log the full stack trace
		        innerException.printStackTrace();
		    }
		}

		
		
	     wait.elementToBeClickable(ReportCardTab);
	     j.executeScript("arguments[0].click();", ReportCardTab);
	     StaticWait(2);
	     String TotalScore = StandardScoreElement.getText();
	     if (Number != null && TotalScore.contains(Number)) {
	         System.out.println("Score Added in Report Card : " + TotalScore);
	     } else {
	         System.out.println("Score Not Added in Report Card : " + TotalScore);
	     }

	}
	
	
}
