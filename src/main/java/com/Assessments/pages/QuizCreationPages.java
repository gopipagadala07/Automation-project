package com.Assessments.pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.Utils.Wait;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

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
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Search Test')]")private WebElement Searchtestbtn;
	@FindBy(how = How.XPATH,using = "//span[text()=' Go ']")private WebElement gobtn;
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
	@FindBy(how = How.XPATH,using = "//div[@class='course-unit selectedUnit']")private WebElement Allbtn;
	@FindBy(how = How.XPATH,using = "//div[@class='leaning__course__tree_item']/div[2]/div[3]/button/span")private List<WebElement> Ellipsescount;
	@FindBy(how = How.XPATH,using = "//span[text()='Progress']")private WebElement progressbtn;
	@FindBy(how = How.XPATH,using = "//b[contains(text(),'Due Date')]/parent::div/following-sibling::div/child::mat-slide-toggle/child::label")private WebElement Activatetoggle;
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='close']")private WebElement closeicon;
	@FindBy(how = How.XPATH,using = "//*[local-name()='svg' and @selection='true']")private WebElement alertBadge;

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
	public WebElement publishToggle(String Value) {
		String xpath = "//small[contains(text(),'"+Value+"')]/parent::span/parent::div/parent::div/following-sibling::div/child::div[4]/child::mat-slide-toggle/label";
		return driver.findElement(By.xpath(xpath));
	}
	public WebElement QuizEllipses(String Value) {
		String xpath = "//small[contains(text(),'"+Value+"')]/parent::span/parent::div/parent::div/following-sibling::div/child::div[5]/child::button/child::span[1]";
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
		for(int retry=0;retry<=3;retry++)
		{
			try {
				cp.searchField(ClassroomName + "(" + SectionName + ")-"+ TLastName + " " + TFirstName);
				//System.out.println(ClassroomName);
				StaticWait(1);
				wait.visibilityOf(getCommunityNameElement(ClassroomName));
				wait.elementToBeClickable(getCommunityNameElement(ClassroomName));
				Actions a=new Actions(driver);
				a.moveToElement(getCommunityNameElement(ClassroomName)).click().build().perform();
				break;
			}catch (StaleElementReferenceException e) {
				retry++;
			}
		}
	}
	public void Assessmentstab()
	{
		wait.elementToBeClickable(AssessmentsTab);
		Actions a=new Actions(driver);
		StaticWait(1);
		a.moveToElement(AssessmentsTab).click().build().perform();
	}


	public void ChildObjectivesCreation() {
		StaticWait(2);
		Allbtn.click();
		StaticWait(2);
		WebElement ele = driver.findElement(By.xpath("//h3[@class='assessment__title__all_tabs']"));
		ele.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < 3; i++) {
			try {
				List<WebElement> ellipsesList = driver.findElements(By.xpath("//mat-icon[text()='more_vert']"));
				if (ellipsesList.isEmpty()) {
					System.out.println("No ellipses found for iteration " + (i + 1));
					return;
				}
				if (ellipsesList.size() == 4) {
					System.out.println("Latest ellipses count reached 4, stopping the loop.");
					break;
				}
				WebElement latestEllipsis = ellipsesList.get(ellipsesList.size() - 1);

				wait.until(ExpectedConditions.elementToBeClickable(latestEllipsis));
				wait.until(ExpectedConditions.visibilityOf(latestEllipsis));
				StaticWait(2);
				js.executeScript("arguments[0].click();", latestEllipsis);

				StaticWait(1);
				childObjectivebtn.click();
				String childLabel = "ChildObjective" + randomNumberGenerator();
				StaticWait(1);
				cp.Name(childLabel);
				cp.Save();
				StaticWait(1);

			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException encountered, retrying iteration " + (i + 1) + ": " + e.getMessage());
				i--;
			} catch (Exception e) {
				System.out.println("Failed in iteration " + (i + 1) + ": " + e.getMessage());
			}
		}
	}


	public void QuizzesCreation(String TestName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		int targetIndex = 0;

		for (int i = 0; i < 8; i++) {
			for (int retry = 0; retry < 3; retry++) {
				try {
					List<WebElement> ellipsesList = driver.findElements(By.xpath("//mat-icon[text()='more_vert']"));
					int count = ellipsesList.size();
					System.out.println("Ellipses count: " + count);

					if (count >= 8) {
						//System.out.println("Ellipses count has reached 8. Stopping the loop.");
						return;
					}

					if (count <= targetIndex) {
						System.out.println("Not enough ellipses available. Retrying...");
						StaticWait(1);
						continue;
					}

					WebElement ellipsis = ellipsesList.get(targetIndex);
					StaticWait(3);
					wait.until(ExpectedConditions.elementToBeClickable(ellipsis));
					js.executeScript("arguments[0].click();", ellipsis);
					StaticWait(2);
					WebElement addQuizBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Add Quiz')]")));
					js.executeScript("arguments[0].click();", addQuizBtn);
					wait.until(ExpectedConditions.elementToBeClickable(Searchtestbtn));
					Searchtestbtn.click();
					String testname = "\"" + TestName + "\"";
					cp.SearchTestname(testname);
					wait.until(ExpectedConditions.elementToBeClickable(gobtn));
					js.executeScript("arguments[0].click();", gobtn);
					WebElement testAddBtn = wait.until(ExpectedConditions.elementToBeClickable(TestAddbtn(TestName)));
					js.executeScript("arguments[0].click();", testAddBtn);
					String QuizName = " Quiz " + randomNumberGenerator();
					ExtentCucumberAdapter.addTestStepLog(QuizName);
					cp.Name(QuizName);
					Descriptionbox.sendKeys(generateRandomString());
					Instructionbox.sendKeys(generateRandomString());
					StaticWait(1);
					cp.getRandomDate(Datepickericon);
					ShowAnswers.click();
					if (ShowTestResult.isEnabled()) {
						ShowTestResult.click();
					}
					wait.until(ExpectedConditions.elementToBeClickable(ShowtestSummary));
					OverrideInstructionstoggle.click();
					StaticWait(1);
					js.executeScript("arguments[0].click();", Badgetab);
					StaticWait(1);
					js.executeScript("arguments[0].click();", AddnewBadgebtn);
					StaticWait(1);
					driver.switchTo().frame(0);
					StaticWait(1);
//					try {
//						List<WebElement> badgeSelection = driver.findElements(By.xpath("//*[local-name()='svg' and @class='ng-scope']"));
//						Random r = new Random();
//						int randomBadge = r.nextInt(Math.min(badgeSelection.size(), 75));
//						List<WebElement> pathElements = badgeSelection.get(randomBadge).findElements(By.xpath(".//*[name()='path']"));
//						if (!pathElements.isEmpty()) {
//							int randomPathIndex = r.nextInt(pathElements.size());
//							WebElement targetElement = pathElements.get(randomPathIndex);
//							js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
//							actions.moveToElement(targetElement).build().perform();
//							boolean badgeAdded = false;
//							int retryCount = 0;
//
//							while (!badgeAdded && retryCount < 3) { 
//								try {
//									actions.click(targetElement).build().perform();
//									StaticWait(1);
//									WebElement alertBadge = driver.findElement(By.xpath("//*[local-name()='svg' and @selection='true']"));
//									if (alertBadge.isDisplayed()) {
//										System.out.println("Badge added!");
//										badgeAdded = true;
//									} else {
//										System.out.println("Alert badge not displayed, retrying...");
//									}
//								} catch (MoveTargetOutOfBoundsException e) {
//									System.out.println("Target element out of bounds. Retrying...");
//									actions.moveToElement(targetElement).build().perform();
//								} catch (Exception e) {
//									System.out.println("Unexpected error: " + e.getMessage());
//								}
//								retryCount++;
//							}
//
//							if (!badgeAdded) {
//								System.out.println("Failed to add badge after retries.");
//							}
//						} else {
//							System.out.println("No <path> elements found for the selected <svg>.");
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					} 
					WebElement badgeSelectionElement = wait.until(ExpectedConditions.visibilityOf(BadgeSelection));
					js.executeScript("arguments[0].scrollIntoView(true);", badgeSelectionElement);
					actions.moveToElement(badgeSelectionElement).click().perform();
					StaticWait(1);
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
					StaticWait(1);
					cp.Save();
					ExtentCucumberAdapter.addTestStepLog("Quiz created successfully!");
					System.out.println("Quiz created successfully!");

					StaticWait(1);
					js.executeScript("arguments[0].click();", publishToggle(QuizName));
					wait.until(ExpectedConditions.elementToBeClickable(QuizEllipses(QuizName)));
					js.executeScript("arguments[0].click();", QuizEllipses(QuizName));
					StaticWait(1);
					progressbtn.click();
					StaticWait(1);
					wait.until(ExpectedConditions.elementToBeClickable(Activatetoggle));
					js.executeScript("arguments[0].click();", Activatetoggle);
					StaticWait(1);
					js.executeScript("arguments[0].click();", closeicon);
					StaticWait(1);
					targetIndex += 2;
					StaticWait(1);
					break;
				} catch (StaleElementReferenceException e) {
					System.out.println("StaleElementReferenceException encountered, retrying... Attempt " + (retry + 1));
					StaticWait(2);
				} catch (TimeoutException e) {
					System.out.println("TimeoutException encountered, retrying... Attempt " + (retry + 1));
					StaticWait(1);
				} catch (Exception e) {
					System.out.println("An exception occurred: " + e.getMessage());
					break;
				}
			}
		}
	}

}