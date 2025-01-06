package com.PortfolioCenter.pages;

import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;
import com.Utils.Wait;


public class MultiScoringPortfolioCoursePages extends ActionType{
	static List<Map<String, String>> testdata=null;
	ExcelReader reader = new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;
	static String MultiPortfolioCourseName;
	static String Multiassignmentname;
	static int Number = randomNumberGeneratorstatic();
	
	@FindBy(how=How.XPATH,using = "//*[text()='more_vert']/ancestor::button")private WebElement EllipseBtn;
	@FindBy(how=How.XPATH,using = "//*[text()='Add New Course']/parent::button")private WebElement AddNewCourseBtn;
	@FindBy(how=How.XPATH,using = "//*[text()='Title ']/parent::label")private WebElement TitleElement;
	@FindBy(how=How.XPATH,using = "//*[text()='Title ']/parent::label/parent::span/preceding-sibling::input")private WebElement inputTitleElement;
	@FindBy(how=How.XPATH,using = "//*[@data-placeholder='Type here']/parent::div")private WebElement DescriptionElement;
	@FindBy(how=How.XPATH,using = "//*[text()=' Save ']/parent::button")private WebElement savebtn;
	@FindBy(how=How.XPATH,using = "//*[text()='search here']/parent::label/parent::span/preceding-sibling::input")private WebElement inputsearchhereElement;
//	@FindBy(how=How.XPATH,using = "//*[text()='+CourseName+']/ancestor::mat-card-title")private WebElement CourseNameElement;
	@FindBy(how=How.XPATH,using = "//*[text()=' Portfolio Assignment ']/parent::button")private WebElement  AddAssignmentElement;
//	@FindBy(how=How.XPATH,using = "//*[text()='Name ']/parent::label")private WebElement AssignmentNameElement;
	@FindBy(how=How.XPATH,using = "//*[text()='Name ']/parent::label/parent::span/preceding-sibling::input")private WebElement inputAssignmentNameElement;
//	@FindBy(how=How.XPATH,using = "//*[@data-placeholder='Type here']/parent::div/parent::div/parent::div/parent::div/parent::fp-ckeditor/parent::div//parent::div/child::label[text()='Description/Instructions']")
//	private WebElement DecInstElement;
//	@FindBy(how=How.XPATH,using = "//*[@data-placeholder='Type here']/parent::div/parent::div/parent::div/parent::div/parent::fp-ckeditor/parent::div/parent::div/parent::mat-card-content/parent::mat-card//child::div[text()=' Rubric ']")
//	private WebElement  RubricElement;
	@FindBy(how=How.XPATH,using = "(//*[@data-placeholder='Type here'])[1]")private WebElement DecInstElement;
	@FindBy(how=How.XPATH,using = "(//*[@data-placeholder='Type here'])[2]")private WebElement  RubricElement;
	@FindBy(how=How.XPATH,using = "//*[text()='Tags']/parent::div")private WebElement TagsElement;
	@FindBy(how=How.XPATH,using = "//*[text()=' Standards ']/parent::span")private WebElement  StandardsTabElement;
	
	@FindBy(how = How.XPATH,using = "//div[text()='Badge']")private WebElement Badgetab;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Add/Change Badge Image')]")private WebElement AddnewBadgebtn;
	@FindBy(how = How.XPATH,using = "//*[local-name()='svg' and @class='ng-scope']//*[name()='path' and @fill='#2B8383']")private WebElement BadgeSelection;
	@FindBy(how = How.XPATH,using = "//button[contains(text(),'Import Badge')]")private WebElement importBadge;
	
	
	
	
	
	public WebElement Standard1(String Code1) {
		String xpath = "//*[@class='fontchanges ng-star-inserted']/child::span[text()='"+Code1+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement Standard2(String Code2) {
		String xpath = "//*[@class='fontchanges ng-star-inserted']/child::span[text()='"+Code2+"']";
		return driver.findElement(By.xpath(xpath));
	}
	public WebElement Standard3(String Code3) {
		String xpath = "//*[@class='fontchanges ng-star-inserted']/child::span[text()='"+Code3+"']";
		return driver.findElement(By.xpath(xpath));
	}
	public WebElement MultiPortfolioName(String PortfolioCourseName) {
		String xpath ="//*[@class='mat-card-header-text']/child::mat-card-title/child::span/child::b[text()='"+PortfolioCourseName+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	
	public MultiScoringPortfolioCoursePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}
	

	public void the_user_creates_a_multi_scoring_portfolio_course_by_entering_the_title_and_description() throws Exception {
		 wait.elementToBeClickable(EllipseBtn);
	     EllipseBtn.click();
	     wait.elementToBeClickable(AddNewCourseBtn);
	     AddNewCourseBtn.click();
	     wait.elementToBeClickable(TitleElement);
	     JavascriptExecutor jc = (JavascriptExecutor) driver;
	     jc.executeScript("arguments[0].click();", TitleElement);     
	     MultiPortfolioCourseName = "PortfolioCourse"+Number;
	     cp.insertData("PortfolioCenter.xlsx", MultiPortfolioCourseName, 16);
	     System.out.println(MultiPortfolioCourseName);
	     StaticWait(1);
	     inputTitleElement.sendKeys(MultiPortfolioCourseName);
	     wait.elementToBeClickable(DescriptionElement);
	     DescriptionElement.sendKeys(generateRandomString());
	     wait.elementToBeClickable(savebtn);
	     savebtn.click(); 
	     StaticWait(2);
	}
	
//	public void the_user_searches_for_the_multi_scoring_portfolio_course_and_clicks_on_it(Integer MultiScoringCourseName) throws InvalidFormatException, IOException {
//		StaticWait(1);
//	     JavascriptExecutor jc = (JavascriptExecutor) driver;
//	     wait.elementToBeClickable(inputsearchhereElement);
//			jc.executeScript("arguments[0].click();", inputsearchhereElement); 
////			if (testdata == null) {
////				testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
////			}
////			String MultiPortfolioCourse = testdata.get(MultiScoringCourseName).get("MultiScoringCourseName");
////	     cp.searchField(MultiPortfolioCourse);
//			wait.elementToBeClickable(inputsearchhereElement);
//			inputsearchhereElement.click();
//			inputsearchhereElement.sendKeys(MultiPortfolioCourseName);
//	     StaticWait(4);
//	     wait.visibilityOf(MultiPortfolioName(MultiPortfolioCourseName));
////	     PortfolioName(PortfolioCourseName).click();	 
//	     jc.executeScript("arguments[0].click();", MultiPortfolioName(MultiPortfolioCourseName));
//	}
	
	public void the_user_searches_for_the_multi_scoring_portfolio_course_and_clicks_on_it(Integer MultiScoringCourseName) throws InvalidFormatException, IOException {
	    StaticWait(1);
	    JavascriptExecutor jc = (JavascriptExecutor) driver;
	    wait.elementToBeClickable(inputsearchhereElement);
	    jc.executeScript("arguments[0].click();", inputsearchhereElement);

	    // Uncomment and configure test data retrieval if needed
	    // if (testdata == null) {
	    //     testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	    
	    // }
	    // String MultiPortfolioCourse = testdata.get(MultiScoringCourseName).get("MultiScoringCourseName");
	    // cp.searchField(MultiPortfolioCourse);

	    retrySearchForMultiPortfolioCourseName(5);
	}

	public void retrySearchForMultiPortfolioCourseName( int retryCount) {
	    int attempts = 0;
	    boolean isSuccessful = false;

	    while (attempts < retryCount && !isSuccessful) {
	        try {
	            // Wait for the input element to be clickable
	            wait.elementToBeClickable(inputsearchhereElement);
	            inputsearchhereElement.click();
	            inputsearchhereElement.clear(); // Clear the input field before sending keys
	            inputsearchhereElement.sendKeys(MultiPortfolioCourseName);

	            // Introduce a short static wait to let results load
	            StaticWait(4);

	            // Wait for the visibility of the desired portfolio name
	            wait.visibilityOf(MultiPortfolioName(MultiPortfolioCourseName));

	            // Use JavaScript executor to click on the portfolio name
	            JavascriptExecutor jc = (JavascriptExecutor) driver;
	            jc.executeScript("arguments[0].click();", MultiPortfolioName(MultiPortfolioCourseName));

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

	
	public void the_user_enters_the_assignment_name_description_and_add_multi_standards(Integer Standard1, Integer Standard2, Integer Standard3) throws Exception {
		StaticWait(1);
		 wait.elementToBeClickable(inputAssignmentNameElement);
		 inputAssignmentNameElement.click();
		 Multiassignmentname ="AssignmentName"+Number;
		 cp.insertData("PortfolioCenter.xlsx", Multiassignmentname, 20);
		 System.out.println(Multiassignmentname);
		 inputAssignmentNameElement.sendKeys(Multiassignmentname);
	     wait.elementToBeClickable(DecInstElement);
	     DecInstElement.click();
	     DecInstElement.sendKeys(generateRandomString());
	     wait.elementToBeClickable(RubricElement);
	     RubricElement.click();
	     RubricElement.sendKeys(generateRandomString());
	     wait.elementToBeClickable(TagsElement);
	     TagsElement.click();
	     wait.elementToBeClickable(StandardsTabElement);
	     StandardsTabElement.click();
	     StaticWait(1);

	     if (testdata == null) {
				testdata = reader.getData("/ExcelFiles/PortfolioCenter.xlsx", getSheetEnv());
			}
			String StandardsCod1 = testdata.get(Standard1).get("Standard1");
			String StandardsCod2 = testdata.get(Standard2).get("Standard2");
			String StandardsCod3 = testdata.get(Standard3).get("Standard3");
			
			Actions act = new Actions(Base.getDriver());
			act.moveToElement(Standard1(StandardsCod1)).perform();
			act.click().perform();
			act.moveToElement(Standard2(StandardsCod2)).perform();
			act.click().perform();
			act.moveToElement(Standard3(StandardsCod3)).perform();
			act.click().perform();
		     StaticWait(1);
	 
	
	}
	
	public void the_user_added_the_badge_for_multi_scoring_portfolio_course() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Badgetab.click();
		js.executeScript("arguments[0].click();", AddnewBadgebtn);
		StaticWait(1);
		driver.switchTo().frame(0);
		WebElement badgeSelectionElement = wait.until(ExpectedConditions.visibilityOf(BadgeSelection));
		js.executeScript("arguments[0].scrollIntoView(true);", badgeSelectionElement);
		actions.moveToElement(badgeSelectionElement).click().perform();
		WebElement importBadgeBtn = wait.until(ExpectedConditions.elementToBeClickable(importBadge));
		importBadgeBtn.click();
		driver.switchTo().defaultContent();
	}
	
	

}
