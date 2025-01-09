package com.PortfolioCenter.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
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


public class PortfolioCenterCoursePages extends ActionType{
	static List<Map<String, String>> testdata=null;
	ExcelReader reader = new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;
	static String PortfolioCourseName;
	static String assignmentname;
	static int number = randomNumberGeneratorstatic();

	private By Learningtab = By.xpath("//span[contains(text(),'Learning')]");
	private By PortfolioCenterTab = By.xpath("//*[text()='Portfolio Center']");
	//@FindBy(how = How.XPATH,using = "//*[(text()='Learning')]")private WebElement Learningtab;
	//@FindBy(how=How.XPATH,using = "//*[text()='Portfolio Center']")private WebElement PortfolioCenterTab;
	@FindBy(how=How.XPATH,using = "//*[text()='more_vert']/ancestor::button")private WebElement EllipseBtn;
	@FindBy(how=How.XPATH,using = "//*[text()='Add New Course']/parent::button")private WebElement AddNewCourseBtn;
	@FindBy(how=How.XPATH,using = "//*[text()='Title ']/parent::label")private WebElement TitleElement;
	@FindBy(how=How.XPATH,using = "//*[text()='Title ']/parent::label/parent::span/preceding-sibling::input")private WebElement inputTitleElement;
	@FindBy(how=How.XPATH,using = "//*[@data-placeholder='Type here']/parent::div")private WebElement DescriptionElement;
	@FindBy(how=How.XPATH,using = "//*[text()=' Save ']/parent::button")private WebElement savebtn;
	//	@FindBy(how=How.XPATH,using = "//*[text()='search here']/parent::label")private WebElement searchhereElement;
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
	@FindBy(how = How.XPATH,using = "//*[text()='+subCode+']/..") private WebElement  StandardsElement;
	@FindBy(how = How.XPATH,using = "//*[text()='Save']/parent::button") private WebElement  SavebtnElement;
	@FindBy(how = How.XPATH,using = "//*[local-name()='svg' and @matTooltip='Members']/parent::div") private WebElement MembersTabElement;
	@FindBy(how = How.XPATH,using = "//*[text()=' Manage Members ']/parent::button") private WebElement ManageMembersbElement;
	@FindBy(how = How.XPATH,using = "(//*[text()='search here']/parent::label)[1]") private WebElement SearchuserinmemnberTabElement;
	@FindBy(how = How.XPATH,using = "//*[text()='+username+']/parent::span/parent::div/parent::div/following-sibling::div/child::a/child::mat-icon") 
	private WebElement AdduserElement;
	@FindBy(how = How.XPATH,using = "//mat-icon[contains(text(),'close')]") private WebElement  closebtnElement;
	@FindBy(how = How.XPATH,using = "//*[local-name()='svg']/parent::span[@mattooltip='Portfolio']") private WebElement  PortfolioElement;
	//	@FindBy(how = How.XPATH,using = "//*[text()="+AssignmentName+"]/parent::div") private WebElement  ACElement;
	@FindBy(how = How.XPATH,using = "//*/child::tr/child::td[contains(text(),'+StudentName+')]") private WebElement  StudentElement;

	@FindBy(how = How.XPATH,using = "//div[text()='Badge']")private WebElement Badgetab;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Add/Change Badge Image')]")private WebElement AddnewBadgebtn;
	@FindBy(how = How.XPATH,using = "//*[local-name()='svg' and @class='ng-scope']//*[name()='path' and @fill='#2B8383']")private WebElement BadgeSelection;
	@FindBy(how = How.XPATH,using = "//button[contains(text(),'Import Badge')]")private WebElement importBadge;
	@FindBy(how = How.XPATH,using = "//*[local-name()='svg' and @selection='true']")private WebElement alertBadge;

	public WebElement PortfolioName(String PortfolioCourseName) {
		String xpath ="//*[@class='mat-card-header-text']/child::mat-card-title/child::span/child::b[text()='"+PortfolioCourseName+"']";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement AssignmentName(String ACName) {
		String xpath = "//*[text()='"+ACName+"']/parent::div";
		return driver.findElement(By.xpath(xpath));
	}


	public WebElement Standards(String Code) {
		String xpath = "//*[@class='fontchanges ng-star-inserted']/child::span[text()='"+Code+"']";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement Addicon(String name) {
		String xpath = "//*[text()='"+name+"']/parent::span/parent::div/parent::div/following-sibling::div/child::a/child::mat-icon";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement verifiesUser(String verify) {
		String xpath = "//*/child::tr/child::td[contains(text(),'"+verify+"')]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement verifiesStudent(String Student) {
		String xpath = "//*[text()=' Student Name ']/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td[contains(text(),'"+Student+"')]";
		return driver.findElement(By.xpath(xpath));
	}


	public PortfolioCenterCoursePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}

	public void the_user_clicks_on_learning_and_portfolio_center()
	{
		WebElement PC = driver.findElement(PortfolioCenterTab);
		if(PC.isDisplayed())
		{
			PC.click();
		}
		else
		{
			driver.findElement(Learningtab).click();
			PC.click();
		}
	}
	public void the_user_creates_a_portfolio_course_by_entering_the_title_and_description() throws Exception {
		wait.elementToBeClickable(EllipseBtn);
		EllipseBtn.click();
		wait.elementToBeClickable(AddNewCourseBtn);
		AddNewCourseBtn.click();
		wait.elementToBeClickable(TitleElement);
		JavascriptExecutor jc = (JavascriptExecutor) driver;
		jc.executeScript("arguments[0].click();", TitleElement);     
		PortfolioCourseName = "PortfolioCourse"+number;
		cp.insertData("PortfolioCenter.xlsx", PortfolioCourseName, 12);
		StaticWait(1);
		inputTitleElement.sendKeys(PortfolioCourseName);
		wait.elementToBeClickable(DescriptionElement);
		DescriptionElement.sendKeys(generateRandomString());
		wait.elementToBeClickable(savebtn);
		cp.Save();
	}

	public void the_user_searches_for_the_specific_course_and_clicks_on_it() throws InvalidFormatException, IOException {	
		StaticWait(1);
		retrySearchForCourseName(PortfolioCourseName, 3);
	}

	public void retrySearchForCourseName(String PortfolioCourseName, int retryCount) {
		int attempts = 0;
		boolean isSuccessful = false;
		while (attempts < retryCount && !isSuccessful) {
			try {
				cp.searchField(PortfolioCourseName);
				wait.visibilityOf(PortfolioName(PortfolioCourseName));
				JavascriptExecutor jc = (JavascriptExecutor) driver;
				jc.executeScript("arguments[0].click();", PortfolioName(PortfolioCourseName));
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


	public void the_user_clicks_on_the_add_portfolio_assignment_button() {
		StaticWait(1);
		wait.elementToBeClickable(AddAssignmentElement);
		AddAssignmentElement.click();  
	}

	public void the_user_enters_the_assignment_name_description_and_selects_standards(Integer Standards) throws Exception {
		StaticWait(1);
		wait.elementToBeClickable(inputAssignmentNameElement);
		inputAssignmentNameElement.click();
		assignmentname ="AssignmentName"+number;
		cp.insertData("PortfolioCenter.xlsx", assignmentname, 13);
		inputAssignmentNameElement.sendKeys(assignmentname);
		wait.elementToBeClickable(DecInstElement);
		DecInstElement.click();
		DecInstElement.sendKeys(generateRandomString());
		wait.elementToBeClickable(RubricElement);
		RubricElement.click();
		RubricElement.sendKeys(generateRandomString());
		wait.elementToBeClickable(TagsElement);
		TagsElement.click();
		wait.elementToBeClickable(StandardsTabElement);
		StaticWait(1);
		StandardsTabElement.click();
		StaticWait(1);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-label[text()='Search here']/ancestor::span/ancestor::mat-form-field/following::div/descendant::span[1]/child::small")));
		List<WebElement> elements = driver.findElements(By.xpath("//mat-label[text()='Search here']/ancestor::span/ancestor::mat-form-field/following::div/descendant::span[1]/child::small"));
		if (!elements.isEmpty()) {
			Random random = new Random();
			int randomIndex = random.nextInt(elements.size());
			WebElement elementToClick = elements.get(randomIndex);
			Actions a = new Actions(driver);
			a.moveToElement(elementToClick).perform();
			StaticWait(1);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", elementToClick);
			//System.out.println("Clicked on element at index: " + randomIndex);
		} else {
			System.out.println("No elements found to click.");
		}
	}

	public void the_user_added_the_badge() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Badgetab.click();
		js.executeScript("arguments[0].click();", AddnewBadgebtn);
		StaticWait(1);
		driver.switchTo().frame(0);
		StaticWait(1);
		try {
            List<WebElement> badgeSelection = driver.findElements(By.xpath("//*[local-name()='svg' and @class='ng-scope']"));
            Random r = new Random();
            int randomBadge = r.nextInt(Math.min(badgeSelection.size(), 75));
            List<WebElement> pathElements = badgeSelection.get(randomBadge).findElements(By.xpath(".//*[name()='path']"));
            if (!pathElements.isEmpty()) {
                int randomPathIndex = r.nextInt(pathElements.size());
                WebElement targetElement = pathElements.get(randomPathIndex);
                js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
                actions.moveToElement(targetElement).build().perform();
                boolean badgeAdded = false;
                int retryCount = 0;
                while (!badgeAdded && retryCount < 3) { 
                    try {
                        actions.click(targetElement).build().perform();
                        StaticWait(1);

                        WebElement alertBadge = driver.findElement(By.xpath("//*[local-name()='svg' and @selection='true']"));
                        if (alertBadge.isDisplayed()) {
                            System.out.println("Badge added!");
                            badgeAdded = true;
                        } else {
                            System.out.println("Alert badge not displayed, retrying...");
                        }
                    } catch (MoveTargetOutOfBoundsException e) {
                        System.out.println("Target element out of bounds. Retrying...");
                        actions.moveToElement(targetElement).build().perform();
                    } catch (Exception e) {
                        System.out.println("Unexpected error: " + e.getMessage());
                    }
                    retryCount++;
                }

                if (!badgeAdded) {
                    System.out.println("Failed to add badge after retries.");
                }
            } else {
                System.out.println("No <path> elements found for the selected <svg>.");
            }
        } catch (Exception e) {
            e.printStackTrace();
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


	public void the_user_clicks_on_the_save_button() {
		cp.Save();
	}

	public void the_user_navigates_to_the_members_tab_searches_for_the_username_in_the_search_here_field_using_row(Integer LastName) throws InvalidFormatException, IOException{
		StaticWait(1);
		wait.elementToBeClickable(MembersTabElement);
		MembersTabElement.click();
		StaticWait(1);
		wait.elementToBeClickable(ManageMembersbElement);
		ManageMembersbElement.click();

		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/PortfolioCenter.xlsx", getSheetEnv());
		}
		String Fname = testdata.get(LastName).get("FirstName");
		String Lname = testdata.get(LastName).get("LastName");
		//System.out.println(User);
		StaticWait(1);
		retrySearchUserName(Lname, 5, Fname);

	}

	public void retrySearchUserName(String Lname, int retryCount, String Fname) {
		int attempts = 0;
		boolean isSuccessful = false;
		while (attempts < retryCount && !isSuccessful) {
			try {
				cp.searchField1(Lname);
				wait.visibilityOf(Addicon(Lname+" "+Fname));
				JavascriptExecutor jc = (JavascriptExecutor) driver;
				jc.executeScript("arguments[0].click();", Addicon(Lname+" "+Fname));
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

	public void assign_the_user_to_the_assignment() {
		wait.elementToBeClickable(closebtnElement);
		for (int retry = 0; retry < 3; retry++) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(closebtnElement));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", closebtnElement);
				StaticWait(1);
				break;
			} catch (StaleElementReferenceException e) {
				retry++;
				if (retry == 3) {
					System.err.println("Element became stale after multiple attempts: " + e.getMessage());
				}
			} catch (TimeoutException e) {
				System.err.println("Element not clickable within the wait time: " + e.getMessage());
				break;
			} catch (Exception e) {
				System.err.println("An error occurred: " + e.getMessage());
				break;
			}
		}
	}

	public void the_user_navigates_to_the_portfolio_tab() {
		StaticWait(1);
		wait.elementToBeClickable(PortfolioElement);
		PortfolioElement.click();
	}

	public void clicks_on_the_assignment_and_verifies_that_the_user_is_added_to_the_assignment(Integer verifyName) throws InvalidFormatException, IOException, AWTException {
		StaticWait(1);
		//System.out.println(assignmentname);
		wait.visibilityOf(AssignmentName(assignmentname));
		AssignmentName(assignmentname).click();
		StaticWait(1);
		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/PortfolioCenter.xlsx", getSheetEnv());
		}
		String Name = testdata.get(verifyName).get("LastName");
		String verify = testdata.get(verifyName).get("LastName");
		Actions a=new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");
		a.moveToElement(verifiesStudent(verify)).build().perform();
		StaticWait(1);
		String StudentVerify = verifiesStudent(verify).getText();

		if (Name != null && StudentVerify != null && StudentVerify.contains(Name)) {
			System.out.println("User Added");
		} else {
			System.out.println("User Not Added");
			System.out.println("Expected Name: " + Name);
			System.out.println("Fetched Name: " + StudentVerify);
		}
	}
}
