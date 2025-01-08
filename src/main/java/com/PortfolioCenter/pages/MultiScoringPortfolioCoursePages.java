package com.PortfolioCenter.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
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
		cp.insertData("PortfolioCenter.xlsx", MultiPortfolioCourseName, 14);
		System.out.println(MultiPortfolioCourseName);
		StaticWait(1);
		inputTitleElement.sendKeys(MultiPortfolioCourseName);
		wait.elementToBeClickable(DescriptionElement);
		DescriptionElement.sendKeys(generateRandomString());
		wait.elementToBeClickable(savebtn);
		cp.Save(); 
		StaticWait(2);
	}


	public void the_user_searches_for_the_multi_scoring_portfolio_course_and_clicks_on_it(Integer MultiScoringCourseName) throws InvalidFormatException, IOException {
		StaticWait(1);
		JavascriptExecutor jc = (JavascriptExecutor) driver;
		wait.elementToBeClickable(inputsearchhereElement);
		jc.executeScript("arguments[0].click();", inputsearchhereElement);
		retrySearchForMultiPortfolioCourseName(5);
	}

	public void retrySearchForMultiPortfolioCourseName(int retryCount) {
		int attempts = 0;
		boolean isSuccessful = false;
		while (attempts < retryCount && !isSuccessful) {
			try {
				cp.searchField(MultiPortfolioCourseName);
				wait.visibilityOf(MultiPortfolioName(MultiPortfolioCourseName));
				JavascriptExecutor jc = (JavascriptExecutor) driver;
				jc.executeScript("arguments[0].click();",MultiPortfolioName(MultiPortfolioCourseName));
				isSuccessful = true;
				break;
			} catch (Exception e) {
				attempts++;
				System.out.println("Attempt " + attempts + " failed: " + e.getMessage());
				if (attempts >= retryCount) {
					throw new RuntimeException("Failed to search and click on course name after " + retryCount + " attempts.", e);
				}
			}
		}
	}


	public void the_user_enters_the_assignment_name_description_and_add_multi_standards(Integer Standard1, Integer Standard2, Integer Standard3) throws Exception {
		StaticWait(1);
		wait.elementToBeClickable(inputAssignmentNameElement);
		inputAssignmentNameElement.click();
		Multiassignmentname ="AssignmentName"+Number;
		cp.insertData("PortfolioCenter.xlsx", Multiassignmentname, 15);
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
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-label[text()='Search here']/ancestor::span/ancestor::mat-form-field/following::div/descendant::span[1]/child::small")));
		List<WebElement> elements = driver.findElements(By.xpath("//mat-label[text()='Search here']/ancestor::span/ancestor::mat-form-field/following::div/descendant::span[1]/child::small"));
		if (elements.size() >= 3) {
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
		} else {
		    System.out.println("Not enough elements found. At least 3 are required.");
		}
	}

	public void the_user_added_the_badge_for_multi_scoring_portfolio_course() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Badgetab.click();
		js.executeScript("arguments[0].click();", AddnewBadgebtn);
		StaticWait(1);
		driver.switchTo().frame(0);
		StaticWait(1);
		List<WebElement> badgeSelection = driver.findElements(By.xpath("//*[local-name()='svg' and @class='ng-scope']"));
		Random r = new Random();
		int randomBadge = r.nextInt(Math.min(badgeSelection.size(), 100));
		List<WebElement> pathElements = badgeSelection.get(randomBadge).findElements(By.xpath(".//*[name()='path']"));
		if (!pathElements.isEmpty()) {
		    int randomPathIndex = r.nextInt(pathElements.size());
		    actions.moveToElement(pathElements.get(randomPathIndex)).click().build().perform();
		} else {
		    System.out.println("No <path> elements found for the selected <svg>.");
		}
		for (int badgeRetry = 0; badgeRetry < 1; badgeRetry++) {
			try {
				WebElement importBadgeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Import Badge']")));
				js.executeScript("arguments[0].scrollIntoView(true);", importBadgeBtn);
				js.executeScript("arguments[0].click();", importBadgeBtn);
				break;
			} catch (TimeoutException e) {
				StaticWait(1);
			}
		}
		driver.switchTo().defaultContent();
	}
}
