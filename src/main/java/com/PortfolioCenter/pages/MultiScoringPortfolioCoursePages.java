package com.PortfolioCenter.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
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
	@FindBy(how = How.XPATH,using = "//*[local-name()='svg' and @selection='true']")private WebElement alertBadge;

	public WebElement MultiPortfolioName(String PortfolioCourseName) {
		//		String xpath ="//*[@class='mat-card-header-text']/child::mat-card-title/child::span/child::b[text()='"+MultiPortfolioCourseName+"']";
		String xpath="//b['"+PortfolioCourseName+"']";
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
		cp.insertData("TestDataDetails.xlsx", MultiPortfolioCourseName, 14);
		System.out.println(MultiPortfolioCourseName);
		StaticWait(1);
		inputTitleElement.sendKeys(MultiPortfolioCourseName);
		wait.elementToBeClickable(DescriptionElement);
		DescriptionElement.sendKeys(generateRandomString());
		cp.Save(); 
		StaticWait(2);
	}


	public void the_user_searches_for_the_multi_scoring_portfolio_course_and_clicks_on_it(Integer MultiScoringCourseName) throws InvalidFormatException, IOException {
		StaticWait(1);
		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/TestDataDetails.xlsx", getSheetEnv());
		}
		String MultiPortfolioCourse = testdata.get(MultiScoringCourseName).get("MultiScoringCourseName");
		retrySearchForCourseName(MultiPortfolioCourse,5);
	}

	public void retrySearchForCourseName(String portfoliocoursename, int retryCount) {
		int attempts = 0;
		boolean isSuccessful = false;

		while (attempts < retryCount && !isSuccessful) {
			try {
				cp.searchField(portfoliocoursename);
				wait.visibilityOf(MultiPortfolioName(portfoliocoursename));

				WebElement courseElement = MultiPortfolioName(portfoliocoursename);
				String courseText = courseElement.getText();
				// System.out.println("Found course: " + courseText);

				if (portfoliocoursename.equals(courseText)) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", courseElement);
					//	                System.out.println("Course clicked successfully.");
					isSuccessful = true;
				} else {
					System.out.println("Course name mismatch. Retrying...");
				}
			} catch (Exception e) {
				System.out.println("Attempt " + (attempts + 1) + " failed: " + e.getMessage());
			}

			attempts++;

			if (!isSuccessful && attempts >= retryCount) {
				throw new RuntimeException(
						"Failed to search and click on course name after " + retryCount + " attempts."
						);
			}

			StaticWait(2);
		}
	}


	public void the_user_enters_the_assignment_name_description_and_add_multi_standards() throws Exception {
		StaticWait(1);
		wait.elementToBeClickable(inputAssignmentNameElement);
		inputAssignmentNameElement.click();
		Multiassignmentname ="AssignmentName"+Number;
		cp.insertData("TestDataDetails.xlsx", Multiassignmentname, 15);
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
		StaticWait(2);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> elements = getVisibleElements(wait);

		while (elements.size() < 3) {

			System.out.println("Not enough elements found. Clicking dropdown to select a random value.");
			WebElement dropdown = driver.findElement(By.xpath("//div[@role='region']/child::div/child::mat-form-field[1]/child::div"));
			JavascriptExecutor js=(JavascriptExecutor) driver;
			StaticWait(1);
			Actions a=new Actions(driver);
			a.moveToElement(dropdown).build().perform();
			StaticWait(1);
			a.click().build().perform();

			List<WebElement> dropdownValues = driver.findElements(By.xpath("//div[@role='listbox']/child::mat-option"));
			if (!dropdownValues.isEmpty()) {
				Random random = new Random();
				int randomIndex = random.nextInt(dropdownValues.size());
				dropdownValues.get(randomIndex).click();
				StaticWait(1);
			} else {
				System.out.println("No values found in the dropdown.");
				return;
			}

			elements = getVisibleElements(wait);
		}

		if (elements.size() > 3) {
			try {
				StaticWait(1);
				selectRandomFourElements(elements);
			}catch (StaleElementReferenceException e) {
				System.out.println("stale element");

			}

		} else {
			System.out.println("Not enough elements found. At least 2 are required.");
		}
	}


	private List<WebElement> getVisibleElements(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-label[text()='Search here']/ancestor::span/ancestor::mat-form-field/following::div/descendant::span[1]/child::small")));
		return driver.findElements(By.xpath("//mat-label[text()='Search here']/ancestor::span/ancestor::mat-form-field/following::div/descendant::span[1]/child::small"));
	}

	private void selectRandomFourElements(List<WebElement> elements) {
		Random random = new Random();
		Set<Integer> selectedIndices = new HashSet<>();
		Actions action = new Actions(driver);

		while (selectedIndices.size() < 4) {
			int randomIndex = random.nextInt(elements.size());
			if (!selectedIndices.contains(randomIndex)) {
				WebElement elementToClick = elements.get(randomIndex);
				action.moveToElement(elementToClick).click().build().perform();
				selectedIndices.add(randomIndex);
			}
		}
	}

	public void addBadge() {
		try {
			Actions actions = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			List<WebElement> badgeSelection = driver.findElements(By.xpath("//*[local-name()='svg' and @class='ng-scope']"));
			if (badgeSelection.isEmpty()) {
				throw new NoSuchElementException("No badges found for selection.");
			}

			Random r = new Random();
			int randomBadgeIndex = r.nextInt(Math.min(badgeSelection.size(), 75));
			WebElement selectedBadge = badgeSelection.get(randomBadgeIndex);

			List<WebElement> pathElements = selectedBadge.findElements(By.xpath(".//*[name()='path']"));
			if (!pathElements.isEmpty()) {
				int randomPathIndex = r.nextInt(pathElements.size());
				WebElement targetElement = pathElements.get(randomPathIndex);
				js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
				actions.moveToElement(targetElement).build().perform();
				boolean badgeAdded = false;
				int retryCount = 0;
				while (!badgeAdded && retryCount < 3) {
					try {
						StaticWait(1);
						actions.click(targetElement).build().perform();
						StaticWait(1);
						WebElement closetab=driver.findElement(By.xpath("//a[@class='close-tab']"));
						closetab.click();
						WebElement alertBadge = driver.findElement(By.xpath("//*[local-name()='svg' and @selection='true']"));
						if (alertBadge.isDisplayed()) {
							//System.out.println("Badge successfully added..!!!");
							badgeAdded = true;
						} 
						else {
							System.out.println("Badge not displayed as added, retrying...");
						}
					} catch (MoveTargetOutOfBoundsException e) {
						System.out.println("Target element out of bounds. Retrying...");
					}catch (TimeoutException e) {
						System.out.println("Timeout Exception. Retrying...");
					} catch (Exception e) {
						System.out.println("Unexpected error: " + e.getMessage());
					}
					retryCount++;
				}
				if (!badgeAdded) {
					throw new RuntimeException("Failed to add badge after " + retryCount + " retries.");
				}
			} else {
				throw new NoSuchElementException("No path elements found within the badge.");
			}

			boolean success = false;
			for (int badgeRetry = 0; badgeRetry < 5; badgeRetry++) {
				try {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					WebElement importBadgeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button info']")));

					js.executeScript("arguments[0].scrollIntoView(true);", importBadgeBtn);
					StaticWait(1);
					js.executeScript("arguments[0].click();", importBadgeBtn);
					StaticWait(1);

					driver.switchTo().defaultContent();
					System.out.println("Badge imported successfully.");
					success=true;
					break;
				} catch (TimeoutException e) {
					System.err.println("Retry due to TimeoutException.");
					e.printStackTrace();
				} catch (Exception e) {
					System.err.println("Retry due to an exception: " + e.getMessage());
					e.printStackTrace();
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("No badges found for selection.");
		} catch (Exception e) {
			System.err.println("Error in addBadge: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public void the_user_added_the_badge_for_multi_scoring_portfolio_course() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Badgetab.click();
		js.executeScript("arguments[0].click();", AddnewBadgebtn);
		StaticWait(1);
		driver.switchTo().frame(0);
		StaticWait(1);
		addBadge();
		StaticWait(2);
	}
}
