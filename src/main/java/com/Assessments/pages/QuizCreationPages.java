package com.Assessments.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.Wait;

public class QuizCreationPages extends ActionType{

	private WebDriver driver;
	private Wait wait;
	CommonPages cp=new CommonPages(Base.getDriver());


	private By Learningtab = By.xpath("//span[contains(text(),'Learning')]");
	private By AsseementTab = By.xpath("//a[contains(text(),'Assessment Center')]");
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'Assessment Center')]")private WebElement AssessmentCenterTab;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Learning')]")private WebElement LearningTab;
	@FindBy(how = How.XPATH,using = "//div[@role='tablist']/child::div/child::div[2]")private WebElement AssessmentsTab;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Add Child Objective')]")private WebElement childObjectivebtn;
	@FindBy(how = How.XPATH,using = "//label[contains(text(),'Objective')]/parent::div/child::b")private WebElement objectiveLabel;
	@FindBy(how = How.XPATH,using = "//input[@type='text']")private WebElement objectiveName;
	//	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Add Quiz')]")private WebElement AddQuizbtn;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Search Test')]")private WebElement Searchtestbtn;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Go')]")private WebElement gobtn;
	@FindBy(how = How.XPATH,using = "(//button[@aria-label='Open calendar'])[2]")private WebElement Datepickericon;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[1]")private WebElement ShowAnswers;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[2]")private WebElement ShowTestResult;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[3]")private WebElement ShowtestSummary;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[4]")private WebElement ShowtestAnalytics;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Is Override Instructions')]")private WebElement OverrideInstructionstoggle;
	@FindBy(how = How.XPATH,using = "(//div[@role='textbox'])[1]")private WebElement Descriptionbox;
	@FindBy(how = How.XPATH,using = "(//div[@role='textbox'])[2]")private WebElement Instructionbox;
	@FindBy(how = How.XPATH,using = "//div[text()='Badge']")private WebElement Badgetab;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Add/Change Badge Image')]")private WebElement AddnewBadgebtn;
	@FindBy(how = How.XPATH,using = "(//*[local-name()='svg' and @class='ng-scope']//*[name()='path'])[16]")private WebElement BadgeSelection;
	@FindBy(how = How.XPATH,using = "//button[contains(text(),'Import Badge')]")private WebElement importBadge;
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='more_vert']")private WebElement ellipses;
	@FindBy(how = How.XPATH,using = "//iframe[@name='badgeFrame']")private WebElement BadgeFrame;
	@FindBy(how = How.XPATH,using = "//i[@class='text']")private WebElement Itext;
	//	@FindBy(how = How.XPATH,using = "(//button[@mattooltip='More Actions'])[2]/span/mat-icon")private WebElement childellipses;
	@FindBy(how = How.XPATH,using = "//div[@class='course-unit selectedUnit']")private WebElement Allbtn;
	@FindBy(how = How.XPATH,using = "//div[@class='leaning__course__tree_item']/div[2]/div[3]/button/span")private List<WebElement> Ellipsescount;

	public WebElement getCommunityNameElement(String ClassroomName) {
		String xpath = "//span[(text()='"+ClassroomName+"')]/parent::div/parent::mat-card-content/preceding-sibling::mat-card-header/child::div/mat-card-title/child::span";
		return driver.findElement(By.xpath(xpath));
	}
	public WebElement TestAddbtn(String TestnameAdd) {
		String xpath = "//span[text()='"+TestnameAdd+"']/parent::div/parent::div/preceding-sibling::div/child::div[2]/child::div[1]/child::button";
		return driver.findElement(By.xpath(xpath));
	}
	public WebElement childObjectiveEllipses(String Value) {
		String xpath = "//span[contains(text(),'"+Value+"')]/parent::span/parent::div/parent::div/following-sibling::div/child::div[3]/child::button";
		return driver.findElement(By.xpath(xpath));
	}

	public QuizCreationPages(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void Assessmentcentertab()
	{
		WebElement AC = driver.findElement(AsseementTab);
		if(AC.isDisplayed())
		{
			AC.click();
		}
		else
		{
			driver.findElement(Learningtab).click();
			AC.click();
		}
	}
	public void Communityname(String ClassroomName, String SectionName ,String TLastName, String TFirstName)
	{
		cp.searchField(ClassroomName + "(" + SectionName + ")-"+ TLastName + " " + TFirstName);
		StaticWait(1);
		wait.visibilityOf(getCommunityNameElement(ClassroomName));
		wait.elementToBeClickable(getCommunityNameElement(ClassroomName));
		Actions a=new Actions(driver);
		a.moveToElement(getCommunityNameElement(ClassroomName)).click().build().perform();
	}
	public void Assessmentstab()
	{
		wait.elementToBeClickable(AssessmentsTab);
		Actions a=new Actions(driver);
		StaticWait(1);
		a.moveToElement(AssessmentsTab).click().build().perform();
	}


	public void EllipsesClick() {
		StaticWait(2);
		Allbtn.click();
		StaticWait(2);
		WebElement ele = driver.findElement(By.xpath("//h3[@class='assessment__title__all_tabs']"));
		ele.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < 3; i++) {
			List<WebElement> ellipsesList = driver.findElements(By.xpath("//mat-icon[text()='more_vert']"));
			if (ellipsesList.isEmpty()) {
				System.out.println("No ellipses found for iteration " + (i + 1));
				return;
			}

			WebElement latestEllipsis = ellipsesList.get(ellipsesList.size() - 1);
			try {
				wait.until(ExpectedConditions.elementToBeClickable(latestEllipsis));
				StaticWait(2);
				js.executeScript("arguments[0].click();", latestEllipsis);
				System.out.println("Clicked latest ellipsis for iteration: " + (i + 1));
			} catch (Exception e) {
				System.out.println("Failed to click the latest ellipsis in iteration " + (i + 1) + ": " + e.getMessage());
				continue; 
			}

			StaticWait(1);
			childObjectivebtn.click();
			String childLabel = "ChildObjective" + randomNumberGenerator();
			System.out.println("Generated label for iteration " + (i + 1) + ": " + childLabel);
			StaticWait(1);
			cp.Name(childLabel);
			StaticWait(1);
			cp.Save();
			StaticWait(2);

		}
	}



	public void AddnewQuiz(String TestName) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    Actions actions = new Actions(driver);
	    
	    // Click on the 'all' button initially
	    WebElement allBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='course-unit selectedUnit']")));
	    allBtn.click();
	    StaticWait(1);

	    int targetIndex = 0; // The target index for clicking ellipses (0 for 1st, 2 for 3rd, 4 for 5th, etc.)

	    // Use a for loop to iterate over a maximum of 10 retries
	    for (int retries = 0; retries < 10; retries++) {
	        // Fetch the current list of ellipses on the page
	        List<WebElement> ellipsesList = driver.findElements(By.xpath("//mat-icon[text()='more_vert']"));
	        int count = ellipsesList.size();
	        System.out.println("Ellipses count: " + count);

	        // Stop the loop if the ellipses count has reached 8
	        if (count >= 8) {
	            System.out.println("Ellipses count has reached 8. Stopping the loop.");
	            break; // Exit the loop when there are 8 or more ellipses
	        }

	        // Ensure there are enough ellipses to continue the process
	        if (count <= targetIndex) {
	            System.out.println("Not enough ellipses available. Retrying...");
	            StaticWait(1);
	            continue; // Retry if the required ellipsis is not available
	        }

	        // Click the ellipsis based on the target index (0 -> 1st, 2 -> 3rd, 4 -> 5th, etc.)
	        WebElement ellipsis = ellipsesList.get(targetIndex);
	     
	        js.executeScript("arguments[0].click();", ellipsis); // Fallback to JavaScript click
	        StaticWait(1);

	        // Proceed to the quiz creation process
	        WebElement addQuizBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Add Quiz')]")));
	        addQuizBtn.click();

	        wait.until(ExpectedConditions.elementToBeClickable(Searchtestbtn));
	        Searchtestbtn.click();
	        String testname = "\"" + TestName + "\"";
	        cp.SearchTestname(testname);

	        wait.until(ExpectedConditions.elementToBeClickable(gobtn));
	        gobtn.click();

	        WebElement testAddBtn = wait.until(ExpectedConditions.elementToBeClickable(TestAddbtn(TestName)));
	        testAddBtn.click();

	        // Generate random quiz details and complete the creation process
	        String QuizName = " Quiz" + randomNumberGenerator();
	        cp.Name(QuizName);
	        Descriptionbox.sendKeys(generateRandomString());
	        Instructionbox.sendKeys(generateRandomString());
	        cp.getRandomDate(Datepickericon);
	        ShowAnswers.click();
	        if (ShowTestResult.isEnabled()) {
	            ShowTestResult.click();
	        }

	        wait.until(ExpectedConditions.elementToBeClickable(ShowtestSummary));
	        OverrideInstructionstoggle.click();
	        cp.Save();

	        System.out.println("Quiz created successfully!");

	        // Increase the target index by 2 to click the next ellipsis (1st -> 3rd -> 5th -> 7th -> etc.)
	        targetIndex += 2;
	        StaticWait(2); // Wait briefly before continuing to the next iteration
	    }
	}
	

	public void Searchtestbutton(String TestName)
	{
		wait.elementToBeClickable(Searchtestbtn);
		Searchtestbtn.click();
		String testname="\"" + TestName + "\"";
		cp.SearchTestname(testname);
		wait.elementToBeClickable(gobtn);
		gobtn.click();
		wait.elementToBeClickable(TestAddbtn(TestName));
		TestAddbtn(TestName).click();
	}
	public void QuizDetails()
	{
		String QuizName=" Quiz"+randomNumberGenerator();
		cp.Name(QuizName);
		Descriptionbox.sendKeys(generateRandomString());
		Instructionbox.sendKeys(generateRandomString());
	}
	public void Dateselect()
	{
		cp.getRandomDate(Datepickericon);
	}
	public void toggles()
	{
		ShowAnswers.click();
		if(ShowTestResult.isEnabled())
		{
			ShowTestResult.click();
		}
		wait.elementToBeClickable(ShowtestSummary);
		//		ShowtestSummary.click();
		//		wait.elementToBeClickable(ShowtestAnalytics);
		//		ShowtestAnalytics.click();
		OverrideInstructionstoggle.click();

	}
	public void Badgetab()
	{
		Badgetab.click();
	}
	public void BadgeAdding()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
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