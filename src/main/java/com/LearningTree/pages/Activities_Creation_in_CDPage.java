package com.LearningTree.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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

public class Activities_Creation_in_CDPage extends ActionType
{
	private WebDriver driver;
	private Wait wait;
	CommonPages cp=new CommonPages(Base.getDriver());

	public String CourseDesigner_Name;

	@FindBy(how = How.XPATH,using = "//span[text()='Learning']")private WebElement LearningTab;
	@FindBy(how = How.XPATH,using = "//a[text()='Course Designer']")private WebElement CoursrDesignerTab;
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='more_vert']")private WebElement CoursrDesigner_ellipse;
	@FindBy(how = How.XPATH,using = "//span[text()='Add New Community']")private WebElement Add_New_Community;
	@FindBy(how = How.XPATH,using = "//input[@type='search']")private WebElement SearchHere;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Virtual Course')]/parent::span/parent::div/parent::div/following::div/descendant::button[@mattooltip='More Actions']")
	public WebElement Virtual_ellipse;
	//	@FindBy(how = How.XPATH,using = "//div[@class='course-unit selectedUnit']")private WebElement Allbtn;
	@FindBy(how = How.XPATH,using = "//span[text()='Add Child Objective']")private WebElement Add_Child_Objective;
	@FindBy(how = How.XPATH,using = "//div[normalize-space(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))='tags']")private WebElement Tags_Tab;
	@FindBy(how = How.XPATH,using = "//mat-expansion-panel-header[@role='button']")private WebElement Standards_Lookups;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Add Child Objective')]")private WebElement childObjectivebtn;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Search Test')]")private WebElement Searchtestbtn;
	@FindBy(how = How.XPATH,using = "//span[text()=' Go ']")private WebElement gobtn;
	@FindBy(how = How.XPATH,using = "//span[text()='Add Activity']")public WebElement Add_Activity;
	//	Activities
	@FindBy(how = How.XPATH,using = "//span[@class='discussion']")private WebElement Discussion_Activity;	
	@FindBy(how = How.XPATH,using = "//span[@class='assignment']")private WebElement Assignment_Activity;
	@FindBy(how = How.XPATH,using = "//span[@class='resources']")private WebElement Resources_Activity;
	@FindBy(how = How.XPATH,using = "//*[@class='fa fa-search']")private WebElement  Search_Resources;
	@FindBy(how = How.XPATH,using = "//*[@class='fa fa-backward']")private WebElement  Save_and_Continue_Resources;	
	@FindBy(how = How.XPATH,using = "//span[@class='externaltool']")private WebElement Externaltool_Activity;
	@FindBy(how = How.XPATH,using = "//mat-label[text()='Url ']/parent::label/parent::span/parent::div/child::input")private WebElement URL_input;
	@FindBy(how = How.XPATH,using = "//mat-label[text()='Name ']/parent::label/parent::span/parent::div/child::input")private WebElement Name_input;
	@FindBy(how = How.XPATH,using = "//span[@class='epub']")private WebElement Epub_Activity;
	@FindBy(how = How.XPATH,using = "//mat-label[text()='E-Publication URL ']/parent::label/parent::span/parent::div/child::input")private WebElement EPublication_URL;
	@FindBy(how = How.XPATH,using = "//mat-label[text()='Audio URL ']/parent::label/parent::span/parent::div/child::input")private WebElement Audio_URL;
	@FindBy(how = How.XPATH,using = "//mat-label[text()='PDF URL ']/parent::label/parent::span/parent::div/child::input")private WebElement PDF_URL;
	@FindBy(how = How.XPATH,using = "//span[@class='content']")private WebElement Content_Activity;
	@FindBy(how = How.XPATH,using = "//span[@class='adaptiveassessment']")public WebElement Assessment_Activity;	
	@FindBy(how = How.XPATH,using = "(//div[@role='textbox'])[2]")private WebElement Instructionbox;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[1]")private WebElement ShowAnswers;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[2]")private WebElement ShowTestResult;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[3]")private WebElement ShowtestSummary;
	@FindBy(how = How.XPATH,using = "(//span[contains(text(),'Show')])[4]")private WebElement ShowtestAnalytics;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Is Override Instructions')]")private WebElement OverrideInstructionstoggle;
	@FindBy(how = How.XPATH,using = "//span[@class='pointfullcourse']")public WebElement  LTI_Content_Provider_Activity;	
	@FindBy(how = How.XPATH,using = "//mat-label[text()='Tool Name ']/parent::label/parent::span/parent::div/child::input")private WebElement Tool_Name;
	@FindBy(how = How.XPATH,using = "//mat-label[text()='Lti Content Provider']")private WebElement  LTI_Content_Provider_Lookup;
	//	CommonWebelement
	@FindBy(how = How.XPATH,using = "//input[@type='text']")private WebElement TitleName;
	@FindBy(how = How.XPATH,using = "//label[contains(text(),'Description')]/parent::div/descendant::p")private WebElement Description;
	@FindBy(how = How.XPATH,using = "//div[text()=' Rubric ']/parent::mat-card/parent::div/descendant::p")private WebElement Rubric;
	@FindBy(how = How.XPATH,using = "//div[text()='Badge']")private WebElement Badgetab;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Add/Change Badge Image')]")private WebElement AddnewBadgebtn;
	@FindBy(how = How.XPATH,using = "(//*[local-name()='svg' and @class='ng-scope']//*[name()='path'])[16]")private WebElement BadgeSelection;
	@FindBy(how = How.XPATH,using = "//button[contains(text(),'Import Badge')]")private WebElement importBadge;
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='more_vert']")private WebElement ellipses;
	@FindBy(how = How.XPATH,using = "//iframe[@name='badgeFrame']")private WebElement BadgeFrame;
	@FindBy(how = How.XPATH,using = "//input[@type='number']")private WebElement MaxScore;
	@FindBy(how = How.XPATH,using = "//h3[text()='Learning']/parent::div/parent::div/descendant::label/child::span/child::span/child::span[1]")private WebElement Publish_Toggle;
	@FindBy(how = How.XPATH,using = "//input[@type='search']")private WebElement search;
	@FindBy(how = How.XPATH,using = "//div[text()=' 0 of 0 ']")private WebElement Pagination;
	//Adding Tags in Virtual Goal
	@FindBy(how = How.XPATH,using = "//div[@class='leaning__course__tree_item']/child::div/following-sibling::div/child::div/button[@mattooltip='More Actions']")private WebElement Virtual_goal_ellipse;
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='edit']")private WebElement Edit_button;
	@FindBy(how = How.XPATH,using = "//div[normalize-space(text())='ATTACHMENTS']")private WebElement ATTACHMENTS_Tab;
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='close']")private WebElement Close_button;



	public Activities_Creation_in_CDPage(WebDriver driver)
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
		cp.insertData("TestDataDetails.xlsx", CourseDesigner_Name, 16);
		Description.sendKeys("Description"+generateRandomString());
		cp.Save();
	}
	public void search_Community(String CD_Name)
	{
		search.sendKeys(CD_Name);
		search.sendKeys(Keys.BACK_SPACE);
		StaticWait(1);
		search.sendKeys(Keys.CONTROL + "z");
	}
	public void click_on_Community(String CD_Name)
	{
		int attempts = 0;
		while (attempts < 5) {
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
	public void adding_Tags_And_Attachement_in_Virtual_Goal() throws IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		StaticWait(1);	
		wait.elementToBeClickable(Virtual_goal_ellipse);
		js.executeScript("arguments[0].click();", Virtual_goal_ellipse);
		wait.elementToBeClickable(Edit_button);
		int attempts = 0;
		while (attempts < 5) {
			try {
				js.executeScript("arguments[0].click();", Edit_button);	
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);	       
			}
		}

		select_Tags();
		attachment();
		cp.Save();
	}
	public void ChildObjectivesCreation() {

		StaticWait(1);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i<4; i++) {
			try {
				List<WebElement> ellipsesList = driver.findElements(By.xpath("//mat-icon[text()='more_vert']"));
				if (ellipsesList.isEmpty()) {
					System.out.println("No ellipses found for iteration " + (i + 1));
					return;
				}
				if (ellipsesList.size() == 5) {
					System.out.println("Latest ellipses count reached 4, stopping the loop.");
					break;
				}
				WebElement latestEllipsis = ellipsesList.get(ellipsesList.size() - 1);
				wait.until(ExpectedConditions.elementToBeClickable(latestEllipsis));
				wait.until(ExpectedConditions.visibilityOf(latestEllipsis));
				StaticWait(1);
				js.executeScript("arguments[0].click();", latestEllipsis);
				StaticWait(1);
				childObjectivebtn.click();
				String childLabel = "ChildObjective" + randomNumberGenerator();
				StaticWait(1);
				cp.Name(childLabel);
				String Description_Txt="Description"+generateRandomString();
				driver.findElement(By.xpath("//b[contains(text(),'Description')]/parent::div/descendant::p")).sendKeys(Description_Txt);	
				select_Tags();
				cp.Save();
				StaticWait(1);
			} catch (StaleElementReferenceException e) {
				//				System.out.println("StaleElementReferenceException encountered, retrying iteration " + (i + 1) + ": " + e.getMessage());
				System.out.println("StaleElementReferenceException encountered");
				i--;
			} catch (Exception e) {
				System.out.println("Failed in iteration " + (i + 1) + ": " + e.getMessage());
			}
		}
	}
	public void click_on_Add_Activity(String Goal)
	{
		int attempts = 0;
		while (attempts < 5) {
			try {
				driver.findElement(By.xpath("//h3[text()='Learning']")).click();
				StaticWait(1);
				Actions Ac=new Actions(driver);
				WebElement Unit_ellipse = driver.findElement(By.xpath("//span[contains(text(),'"+Goal+"')]/parent::span/parent::div/parent::div/following::div/child::div[6]/child::button/child::span/child::mat-icon"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Unit_ellipse);
				Ac.moveToElement(Unit_ellipse).build().perform();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", Unit_ellipse);

				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException encountered");
				attempts++;
				StaticWait(1);	       
			}
			catch (ElementClickInterceptedException e) {
				System.out.println("ElementClickInterceptedException encountered");
				attempts++;
				StaticWait(1);	       
			}
			catch (TimeoutException e) {
				System.out.println("TimeoutException encountered");
				attempts++;
				StaticWait(1);	       
			}
		}
		int attempts1 = 0;
		while (attempts1 < 5) {
			try {
				wait.elementToBeClickable(Add_Activity);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", Add_Activity);
				break;
			} catch (ElementClickInterceptedException e) {
				attempts++;
				StaticWait(1);	       
			}
			catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);	 
			}
		}

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
		addBadge();
		cp.Save();
		System.out.println("Discussion_Activity Created Successfully");
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
		addBadge();
		cp.Save();
		System.out.println("Assignment_Activity Created Successfully");
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
		
		int attempts=0;
		while(attempts<3)
		{
			try {
				WebElement testAddBtn = wait1.until(ExpectedConditions.elementToBeClickable(TestAddbtn(TestName)));
				Actions a=new Actions(driver);
				a.moveToElement(testAddBtn).build().perform();
				StaticWait(1);
				js.executeScript("arguments[0].click();", testAddBtn);
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);
			}
		}

		String AName = "Assessment"+randomNumberGenerator();
		cp.Name(AName);
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
		addBadge();
		cp.Save();
		System.out.println("Assessment_Activity Created Successfully");
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
		String Description_Txt="Description"+"   "+generateRandomString();
		Description.sendKeys(Description_Txt);
		select_Tags();
		Badges();
		addBadge();
		cp.Save();
		System.out.println("Resources_Activity Created Succefully");
	}
	public void add_External_Tool_Activity()
	{
		wait.elementToBeClickable(Externaltool_Activity);
		Externaltool_Activity.click();
		wait.elementToBeClickable(URL_input);
		URL_input.sendKeys("https://pointfuleducation.coursearc.com/index.php?cID=19934&courseKey=JvLYX0ZNG5PY");
		wait.elementToBeClickable(Name_input);
		Name_input.sendKeys("ExternalTool"+randomNumberGenerator());
		MaxScore.clear();   
		MaxScore.sendKeys("80");
		String Description_Txt="Description"+"          "+generateRandomString();
		Description.sendKeys(Description_Txt);
		select_Tags();
		Badges();
		addBadge();
		cp.Save();
		System.out.println("External_Tool_Activity Created Succefully");
	}
	public void add_LTI_Activity()
	{
		wait.elementToBeClickable(LTI_Content_Provider_Activity);
		LTI_Content_Provider_Activity.click();
		wait.elementToBeClickable(Tool_Name);
		Tool_Name.sendKeys("Pointful Education");
		wait.elementToBeClickable(URL_input);
		URL_input.sendKeys("https://pointfuleducation.coursearc.com/index.php?cID=19934&courseKey=JvLYX0ZNG5PY");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.elementToBeClickable(LTI_Content_Provider_Lookup);
		js.executeScript("arguments[0].click();", LTI_Content_Provider_Lookup);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()=' Pointful Education ']")));
		wait.elementToBeClickable(Name_input);
		Name_input.sendKeys("LTI_Content_Provider_Activity"+randomNumberGenerator());
		MaxScore.clear();   
		MaxScore.sendKeys("80");
		String Description_Txt="Description"+"          "+generateRandomString();
		Description.sendKeys(Description_Txt);
		select_Tags();
		Badges();
		addBadge();
		cp.Save();
		System.out.println("External_Tool_Activity Created Succefully");
	}
	public void add_Epub_Activity()
	{
		wait.elementToBeClickable(Epub_Activity);
		Epub_Activity.click();;
		wait.elementToBeClickable(EPublication_URL);
		EPublication_URL.sendKeys("https://fpk12storage.blob.core.windows.net/edx/YCMOU%2FMarathi%20YCMOU%20Course%2FIntroduction%20to%20Roads%2FRTC003_MR_Unit_1.epub");
		wait.elementToBeClickable(Audio_URL);
		Audio_URL.sendKeys("https://fpk12storage.blob.core.windows.net/edx/YCMOU%2FMarathi%20YCMOU%20Course%2FAudio%2FMRTC003%2FRTC003Ghatak01.mp3");	
		wait.elementToBeClickable(PDF_URL);
		PDF_URL.sendKeys("https://fpk12storage.blob.core.windows.net/edx/YCMOU%2FMarathi%20YCMOU%20Course%2FPDF%2FRTC001_MR_Unit%201.pdf");
		wait.elementToBeClickable(Name_input);
		Name_input.sendKeys("Epublication"+randomNumberGenerator());
		String Description_Txt="Description"+"          "+generateRandomString();
		Description.sendKeys(Description_Txt);
		select_Tags();
		Badges();
		addBadge();
		cp.Save();
		System.out.println("Epub_Activity Created Succefully");
	}
	public void select_Tags()
	{
		Actions Ac=new Actions(driver);
		wait.elementToBeClickable(Tags_Tab);
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
				clickedIndices.add(randomIndex); 
			}
		} 
		else if(elements.size() >= 1)
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
		else if(Pagination.isDisplayed()) 
		{
			System.out.println("Not enough elements found to click.");
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
							System.out.println("Badge successfully added..!!!");
							badgeAdded = true;
						}else if (!alertBadge.isDisplayed()) {
							StaticWait(1);
							closetab.click();
							actions.click(targetElement).build().perform();
							StaticWait(1);
							closetab.click();
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

			int maxRetry = 10;
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

	public void Badges()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Badgetab);
		StaticWait(1);
		js.executeScript("arguments[0].click();", AddnewBadgebtn);
		StaticWait(1);
		driver.switchTo().frame(0);
	}
	public WebElement TestAddbtn(String TestnameAdd) {
		String xpath = "//span[text()='"+TestnameAdd+"']/parent::div/parent::div/preceding-sibling::div/child::div[2]/child::div[1]/child::button";
		return driver.findElement(By.xpath(xpath));
	}
	public void attachment() throws IOException
	{
		ATTACHMENTS_Tab.click();
		int retries = 10;
		while (retries > 0)
		{
			try {

				WebElement fileInputRootFolder = driver.findElement(By.xpath("(//mat-icon[@mattooltip='Upload File']/preceding-sibling::input)[1]"));
				fileInputRootFolder.sendKeys(new File("src/test/resources/ExcelFiles/TestDataDetails.xlsx").getCanonicalPath());		         
				break;
			}

			catch (StaleElementReferenceException e)
			{
				System.out.println("Caught StaleElementReferenceException. Retrying...");
				StaticWait(1);
				retries--;
			}  
		}


	}
}