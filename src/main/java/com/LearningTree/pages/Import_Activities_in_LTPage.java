package com.LearningTree.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Import_Activities_in_LTPage extends ActionType {
	private WebDriver driver;
	private Wait wait;
	static List<Map<String, String>> testdata=null;
	ExcelReader reader = new ExcelReader();
	public String LearningTree_Name;

	CommonPages cp=new CommonPages(Base.getDriver());
	@FindBy(how = How.XPATH,using = "//span[text()='Learning']")public WebElement LearningTab;
	@FindBy(how = How.XPATH,using = "//a[text()='Courses']")public WebElement Courses_Tab;	
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='more_vert']")public WebElement LT_ellipse;
	@FindBy(how = How.XPATH,using = "//span[text()='Create New Course']")public WebElement Create_New_Course_btn;
	@FindBy(how = How.XPATH,using = "//input[@type='search']")public WebElement SearchHere;
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='more_vert']")public WebElement  Course_ellipse;
	@FindBy(how = How.XPATH,using = "//span[text()='Search Learning Objective']")public WebElement  Search_Learning_Objective_btn;
	@FindBy(how = How.XPATH,using = "//input[@type='text']")public WebElement TitleName;
	@FindBy(how = How.XPATH,using = "//label[contains(text(),'Description')]/parent::div/descendant::p")public WebElement Description;
	@FindBy(how = How.XPATH,using = "//div[text()=' All ']/parent::div/parent::div/parent::div/parent::div/parent::div/preceding-sibling::div/descendant::label[3]/child::span/child::span[1]")
	public WebElement Public_Toggle;
	@FindBy(how = How.XPATH,using = "//div[text()=' All ']/parent::div/parent::div/parent::div/parent::div/parent::div/preceding-sibling::div/descendant::label[2]/child::span/child::span[1]")
	public WebElement Activate_Toggle;	
	@FindBy(how = How.XPATH,using = "//span[@mattooltip='Learning']")public WebElement Learning;
	@FindBy(how = How.XPATH,using = "//*[local-name()='svg' and @matTooltip='Members']")public WebElement Members_Tab;
	@FindBy(how = How.XPATH,using = "//span[text()=' Manage Members ']")public WebElement Manage_Members_btn;
	@FindBy(how = How.XPATH,using = "(//input[@data-placeholder='search here'])[1]")public WebElement Search_Users;
	@FindBy(how = How.XPATH,using = "//input[@type='search']")private WebElement search;	
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='close']")public WebElement Close;
	
	public WebElement Addicon(String name) {
		String xpath = "//*[text()='"+name+"']/parent::span/parent::div/parent::div/following-sibling::div/child::a/child::mat-icon";
		return driver.findElement(By.xpath(xpath));
	}
	public Import_Activities_in_LTPage(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}
	public void click_on_CoursesTab()
	{	
		if(Courses_Tab.isDisplayed())
		{
			wait.elementToBeClickable(Courses_Tab);
			Courses_Tab.click();
		}
		else
		{
			wait.elementToBeClickable(LearningTab);
			LearningTab.click();
			wait.elementToBeClickable(Courses_Tab);
			Courses_Tab.click();
		}
	}
	public void click_on_Add_LT_Community() 
	{
		wait.elementToBeClickable(Course_ellipse);
		Course_ellipse.click();
		wait.elementToBeClickable(Create_New_Course_btn);
		Create_New_Course_btn.click();
	}
	public void enter_LtName_Description() throws Exception
	{
		wait.elementToBeClickable(TitleName);
		LearningTree_Name="LearningCourse"+randomNumberGenerator();
		TitleName.sendKeys(LearningTree_Name);
		cp.insertData("TestDataDetails.xlsx", LearningTree_Name, 17);
		Description.sendKeys("Description"+generateRandomString());
		cp.Save();
	}
	public void search_Course(String LT_Name)
	{
		cp.searchField(LT_Name);
	}
	public void click_on_Course(String LT_Name)
	{
		int attempts = 0;
		while (attempts < 3) {
			try {
				WebElement community=driver.findElement(By.xpath("//*[text()='"+LT_Name+"']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", community);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", community);

				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);	       
			}
		}
	}
	public void assign_The_Learning_objective(String CD_Name)
	{
		wait.elementToBeClickable(Course_ellipse);
		Course_ellipse.click();
		wait.elementToBeClickable(Search_Learning_Objective_btn);
		Search_Learning_Objective_btn.click();
		search.sendKeys(CD_Name);
		search.sendKeys(Keys.BACK_SPACE);
		StaticWait(1);
		search.sendKeys(Keys.CONTROL + "z");
		int attempts = 0;
		while (attempts < 3) {
			try {
				
				WebElement Assign_to_Community_btn = driver.findElement(By.xpath("//b[text()='"+CD_Name+"']/ancestor::mat-card-header/following-sibling::mat-card-content/following::mat-card-actions/child::div/child::div"));
				Assign_to_Community_btn.click();
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);	       
			}
		}
		driver.navigate().refresh();
		StaticWait(1);
	}
	public void learningTab()
	{
		wait.elementToBeClickable(Learning);
		Learning.click();
	}
	public void publish_And_Activate()
	{
		wait.elementToBeClickable(Public_Toggle);
		Public_Toggle.click();
		wait.elementToBeClickable(Activate_Toggle);
		Activate_Toggle.click();
	}
	public void click_on_Members_Tab()
	{
		wait.elementToBeClickable(Members_Tab);
		Members_Tab.click();
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
	public void add_Student_in_Member(int Name) throws InvalidFormatException, IOException
	{
		wait.elementToBeClickable(Manage_Members_btn);
		Manage_Members_btn.click();
		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/TestDataDetails.xlsx", getSheetEnv());
		}
		String Fname = testdata.get(Name).get("FirstName");
		String Lname = testdata.get(Name).get("LastName");
		//System.out.println(User);
		StaticWait(1);
		retrySearchUserName(Lname, 5, Fname);
	        try {
	            WebElement Close = driver.findElement(By.xpath("//mat-icon[text()='close']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Close);
	            System.out.println("Close button clicked.");
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Element is blocked by a toast notification or other element.");
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Close);
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Close);
	        }	
	}
}
