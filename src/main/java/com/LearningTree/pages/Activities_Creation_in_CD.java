package com.LearningTree.pages;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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
import com.Utils.Wait;

public class Activities_Creation_in_CD extends ActionType
{
	private WebDriver driver;
	private Wait wait;
	CommonPages cp=new CommonPages(Base.getDriver());
	
	public String CourseDesigner_Name;
	
	@FindBy(how = How.XPATH,using = "//span[text()='Learning']")public WebElement LearningTab;
	@FindBy(how = How.XPATH,using = "//a[text()='Course Designer']")public WebElement CoursrDesignerTab;
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='more_vert']")public WebElement CoursrDesigner_ellipse;
	@FindBy(how = How.XPATH,using = "//span[text()='Add New Community']")public WebElement Add_New_Community;

	@FindBy(how = How.XPATH,using = "//input[@type='search']")public WebElement SearchHere;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Virtual Course')]/parent::span/parent::div/parent::div/following::div/descendant::button[@mattooltip='More Actions']")
	public WebElement Virtual_ellipse;
	@FindBy(how = How.XPATH,using = "//span[text()='Add Child Objective']")public WebElement Add_Child_Objective;
	@FindBy(how = How.XPATH,using = "//div[normalize-space(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))='tags']")public WebElement Tags_Tab;
	@FindBy(how = How.XPATH,using = "//mat-expansion-panel-header[@role='button']")public WebElement Standards_Lookups;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Unit')]/parent::span/parent::div/parent::div/following::div/child::div[6]/child::button/child::span/child::mat-icon")
	public WebElement Unit_ellipse;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Search Test')]")private WebElement Searchtestbtn;
	@FindBy(how = How.XPATH,using = "//span[text()=' Go ']")private WebElement gobtn;
	@FindBy(how = How.XPATH,using = "//span[text()='Add Activity']")public WebElement Add_Activity;
	//	Activities
	@FindBy(how = How.XPATH,using = "//span[@class='discussion']")public WebElement Discussion_Activity;	
	@FindBy(how = How.XPATH,using = "//span[@class='assignment']")public WebElement Assignment_Activity;
	@FindBy(how = How.XPATH,using = "//span[@class='resources']")public WebElement Resources_Activity;
	@FindBy(how = How.XPATH,using = "//*[@class='fa fa-search']")public WebElement  Search_Resources;
	@FindBy(how = How.XPATH,using = "//*[@class='fa fa-backward']")public WebElement  Save_and_Continue_Resources;

	
	@FindBy(how = How.XPATH,using = "//span[@class='externaltool']")public WebElement Externaltool_Activity;
	@FindBy(how = How.XPATH,using = "//span[@class='epub']")public WebElement Epub_Activity;
	@FindBy(how = How.XPATH,using = "//span[@class='content']")public WebElement Content_Activity;
	@FindBy(how = How.XPATH,using = "//span[@class='adaptiveassessment']")public WebElement Assessment_Activity;	
	@FindBy(how = How.XPATH,using = "(//div[@role='textbox'])[2]")private WebElement Instructionbox;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[1]")private WebElement ShowAnswers;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[2]")private WebElement ShowTestResult;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[3]")private WebElement ShowtestSummary;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[4]")private WebElement ShowtestAnalytics;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Is Override Instructions')]")private WebElement OverrideInstructionstoggle;
	@FindBy(how = How.XPATH,using = "//span[@class='pointfullcourse']")public WebElement  LTI_Content_Provider_Activity;
	//	CommonWebelement
	@FindBy(how = How.XPATH,using = "//input[@type='text']")public WebElement TitleName;
	@FindBy(how = How.XPATH,using = "//label[contains(text(),'Description')]/parent::div/descendant::p")public WebElement Description;
	@FindBy(how = How.XPATH,using = "//div[text()=' Rubric ']/parent::mat-card/parent::div/descendant::p")public WebElement Rubric;
	@FindBy(how = How.XPATH,using = "//div[text()='Badge']")private WebElement Badgetab;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Add/Change Badge Image')]")private WebElement AddnewBadgebtn;
	@FindBy(how = How.XPATH,using = "(//*[local-name()='svg' and @class='ng-scope']//*[name()='path'])[16]")private WebElement BadgeSelection;
	@FindBy(how = How.XPATH,using = "//button[contains(text(),'Import Badge')]")private WebElement importBadge;
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='more_vert']")private WebElement ellipses;
	@FindBy(how = How.XPATH,using = "//iframe[@name='badgeFrame']")private WebElement BadgeFrame;
	@FindBy(how = How.XPATH,using = "//input[@type='number']")private WebElement MaxScore;
	@FindBy(how = How.XPATH,using = "//h3[text()='Learning']/parent::div/parent::div/descendant::label/child::span/child::span/child::span[1]")private WebElement Publish_Toggle;


public Activities_Creation_in_CD(WebDriver driver)
{
	this.driver=driver;	
	PageFactory.initElements(driver, this);
	this.wait = new Wait(driver);
}

public void click_on_CoursrDesignerTab()
{	
	if(CoursrDesignerTab.isDisplayed())
	{
		wait.elementToBeClickable(CoursrDesignerTab);
		CoursrDesignerTab.click();
	}
	else
	{
		wait.elementToBeClickable(LearningTab);
		LearningTab.click();
		wait.elementToBeClickable(CoursrDesignerTab);
		CoursrDesignerTab.click();
	}
}
public void click_on_Add_a_Community() 
{
	wait.elementToBeClickable(CoursrDesigner_ellipse);
	CoursrDesigner_ellipse.click();
	wait.elementToBeClickable(Add_New_Community);
	Add_New_Community.click();
}
public void publish_All_Activity_in_CD() 
{
	
	int attempts = 0;
	while (attempts < 3) {
		try {
			driver.findElement(By.xpath("//h3[text()='Learning']")).click();
			StaticWait(1);
			Actions Ac=new Actions(driver);
			Ac.moveToElement(Publish_Toggle).click().build().perform();
			break;
		} catch (StaleElementReferenceException e) {
			attempts++;
			StaticWait(1);	       
		}
		catch (ElementClickInterceptedException e) {
			attempts++;
			StaticWait(1);	       
		}
		catch (TimeoutException e) {
			attempts++;
			StaticWait(1);	       
		}
	}
}


public void enter_CName_Description() throws Exception
{
	wait.elementToBeClickable(TitleName);
	CourseDesigner_Name="CourseDesigner"+randomNumberGenerator();
	TitleName.sendKeys(CourseDesigner_Name);
	cp.insertData("LearningTree.xlsx", CourseDesigner_Name, 10);
	Description.sendKeys("Description"+generateRandomString());
	cp.Save();
}
public void search_Community(String CD_Name)
{
	cp.searchField(CD_Name);
}
public void click_on_Community(String CD_Name)
{
	int attempts = 0;
	while (attempts < 3) {
		try {
			WebElement communt=driver.findElement(By.xpath("//b[text()='"+CD_Name+"']"));
			communt.click();
			break;
		} catch (StaleElementReferenceException e) {
			attempts++;
			StaticWait(1);	       
		}
	}
}
public void addChildObjective()
{
	int attempts = 0;
	while (attempts < 3) {
		try {
			driver.findElement(By.xpath("//h3[text()='Learning']")).click();
			StaticWait(1);
			Actions Ac=new Actions(driver);
			Ac.moveToElement(Virtual_ellipse).click().build().perform();
			break;
		} catch (StaleElementReferenceException e) {
			attempts++;
			StaticWait(1);	       
		}
	}
	while (attempts < 3) {
		try {
			Add_Child_Objective.click();
			break;
		} catch (StaleElementReferenceException e) {
			attempts++;
			StaticWait(1);	       
		}
	}
	TitleName.sendKeys("Unit"+randomNumberGenerator());
	String Description_Txt="Description"+generateRandomString();
	driver.findElement(By.xpath("//b[contains(text(),'Description')]/parent::div/descendant::p")).sendKeys(Description_Txt);	
	select_Tags();
	cp.Save();
}
public void click_on_Add_Activity()
{
	int attempts = 0;
	while (attempts < 3) {
		try {
			driver.findElement(By.xpath("//h3[text()='Learning']")).click();
			StaticWait(1);
			Actions Ac=new Actions(driver);
			Ac.moveToElement(Unit_ellipse).click().build().perform();
			break;
		} catch (StaleElementReferenceException e) {
			attempts++;
			StaticWait(1);	       
		}
		catch (ElementClickInterceptedException e) {
			attempts++;
			StaticWait(1);	       
		}
		catch (TimeoutException e) {
			attempts++;
			StaticWait(1);	       
		}
	}
	wait.elementToBeClickable(Add_Activity);
	Add_Activity.click();
}

public void add_Discussion_Activity()
{
	wait.elementToBeClickable(Discussion_Activity);
	Discussion_Activity.click();;
	wait.elementToBeClickable(TitleName);
	MaxScore.clear();   
	MaxScore.sendKeys("80");
	TitleName.sendKeys("Discussion"+randomNumberGenerator());
	String Description_Txt="Description"+"          "+generateRandomString();
	Description.sendKeys(Description_Txt);
	String Rubric_txt="Rubric"+"     "+generateRandomString();
	Rubric.sendKeys(Rubric_txt);
	select_Tags();
	Badges();
	cp.Save();
	System.out.println("Discussion_Activity Created Succefully");
}
public void add_Assignment_Activity()
{
	wait.elementToBeClickable(Assignment_Activity);
	Assignment_Activity.click();;
	wait.elementToBeClickable(TitleName);
	TitleName.sendKeys("Assignment"+randomNumberGenerator());
	MaxScore.clear();   
	MaxScore.sendKeys("80");
	String Description_Txt="Description"+"          "+generateRandomString();
	Description.sendKeys(Description_Txt);
	String Rubric_txt="Rubric"+"     "+generateRandomString();
	Rubric.sendKeys(Rubric_txt);
	select_Tags();
	Badges();
	cp.Save();
	System.out.println("Assignment_Activity Created Succefully");
}
public void add_Assessment_Activity(String TestName)
{
	wait.elementToBeClickable(Assessment_Activity);
	Assessment_Activity.click();
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.elementToBeClickable(TitleName);
	wait1.until(ExpectedConditions.elementToBeClickable(Searchtestbtn));
	Searchtestbtn.click();
	String testname = "\"" + TestName + "\"";
	cp.SearchTestname(testname);
	wait1.until(ExpectedConditions.elementToBeClickable(gobtn));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", gobtn);
	WebElement testAddBtn = wait1.until(ExpectedConditions.elementToBeClickable(TestAddbtn(TestName)));
	js.executeScript("arguments[0].click();", testAddBtn);
	//		TitleName.clear();
	//		TitleName.sendKeys(Keys.CONTROL + "a");
	//		TitleName.sendKeys(Keys.BACK_SPACE);
	TitleName.sendKeys("Assessment"+randomNumberGenerator());
	String Description_Txt="Description"+"       "+generateRandomString();
	Description.sendKeys(Description_Txt);
	Instructionbox.sendKeys(generateRandomString());
	ShowAnswers.click();
	if (ShowTestResult.isEnabled()) {
		ShowTestResult.click();
	}
	wait1.until(ExpectedConditions.elementToBeClickable(ShowtestSummary));
	OverrideInstructionstoggle.click();
	StaticWait(1);
	select_Tags();
	Badges();
	cp.Save();
	System.out.println("Assessment_Activity Created Succefully");
}
public void add_Resources_Activity()
{
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.elementToBeClickable(Resources_Activity);
	Resources_Activity.click();;
	wait.elementToBeClickable(TitleName);
	TitleName.sendKeys("Resources"+randomNumberGenerator());
	Search_Resources.click();
	String Resourcesname = "\"" + "Resources" + "\"";
	cp.SearchTestname(Resourcesname);
	wait1.until(ExpectedConditions.elementToBeClickable(gobtn));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", gobtn);
	WebElement Add_btn=driver.findElement(By.xpath("//mat-icon[@arial-label='Add']"));
	WebElement ResourceAddBtn = wait1.until(ExpectedConditions.elementToBeClickable(Add_btn));
	js.executeScript("arguments[0].click();", ResourceAddBtn);
	Save_and_Continue_Resources.click();
	String Description_Txt="Description"+"          "+generateRandomString();
	Description.sendKeys(Description_Txt);
	select_Tags();
	Badges();
	cp.Save();
	System.out.println("Assignment_Activity Created Succefully");
}
public void select_Tags()
{
	Actions Ac=new Actions(driver);
	Ac.moveToElement(Tags_Tab).click().build().perform();
	Standards_Lookups.click();
	StaticWait(1);
	List<WebElement> elements = driver.findElements(By.xpath("//mat-label[text()='Search here']/ancestor::span/ancestor::mat-form-field/following::div/descendant::span[1]/child::small"));
	if (elements.size() >= 3) {
		Random random = new Random();
		int numberOfElementsToClick = random.nextInt(3) + 3;  // Random number between 3 and 5
		numberOfElementsToClick = Math.min(numberOfElementsToClick, elements.size());
		Set<Integer> clickedIndices = new HashSet<>();
		for (int i = 0; i < numberOfElementsToClick; i++) {
			int randomIndex = random.nextInt(elements.size());		        
			while (clickedIndices.contains(randomIndex)) {
				randomIndex = random.nextInt(elements.size());
			}		        
			WebElement elementToClick = elements.get(randomIndex);		        
			Ac.moveToElement(elementToClick).click().build().perform();
			//				System.out.println("Clicked element: " + elementToClick);
			clickedIndices.add(randomIndex); 
		}

	} 
	else if(elements.size() >= 2)
	{
		Random random = new Random();
		int numberOfElementsToClick = random.nextInt(3) + 2; 
		numberOfElementsToClick = Math.min(numberOfElementsToClick, elements.size());
		Set<Integer> clickedIndices = new HashSet<>();
		for (int i = 0; i < numberOfElementsToClick; i++) {
			int randomIndex = random.nextInt(elements.size());		        
			while (clickedIndices.contains(randomIndex)) {
				randomIndex = random.nextInt(elements.size());
			}		        
			WebElement elementToClick = elements.get(randomIndex);		        
			Ac.moveToElement(elementToClick).click().build().perform();
			clickedIndices.add(randomIndex);
		}
	}
	else 
	{
		System.out.println("Not enough elements found to click.");
	}
}
public void Badges()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", Badgetab);
	StaticWait(1);
	js.executeScript("arguments[0].click();", AddnewBadgebtn);
	StaticWait(1);
	driver.switchTo().frame(0);
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement badgeSelectionElement = wait1.until(ExpectedConditions.visibilityOf(BadgeSelection));
	js.executeScript("arguments[0].scrollIntoView(true);", badgeSelectionElement);
	Actions Ac=new Actions(driver);
	Ac.moveToElement(badgeSelectionElement).click().perform();
	StaticWait(1);
	for (int badgeRetry = 0; badgeRetry < 1; badgeRetry++) {
		try {
			WebElement importBadgeBtn = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Import Badge']")));
			js.executeScript("arguments[0].scrollIntoView(true);", importBadgeBtn);
			js.executeScript("arguments[0].click();", importBadgeBtn);
			break;
		} catch (TimeoutException e) {
			StaticWait(1);
		}
	}

	driver.switchTo().defaultContent();
	StaticWait(1);
}
public WebElement TestAddbtn(String TestnameAdd) {
	String xpath = "//span[text()='"+TestnameAdd+"']/parent::div/parent::div/preceding-sibling::div/child::div[2]/child::div[1]/child::button";
	return driver.findElement(By.xpath(xpath));
}
}