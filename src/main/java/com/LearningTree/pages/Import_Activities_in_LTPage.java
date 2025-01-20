package com.LearningTree.pages;

import java.time.Duration;
import java.util.List;

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
import com.Utils.Wait;

public class Import_Activities_in_LTPage extends ActionType {
	private WebDriver driver;
	private Wait wait;
	
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
		cp.insertData("LearningTree.xlsx", LearningTree_Name, 11);
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
				WebElement communt=driver.findElement(By.xpath("//b[text()='"+LT_Name+"']"));
				communt.click();
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
	public void add_Student_in_Member(String Student_Lastname)
	{
		wait.elementToBeClickable(Manage_Members_btn);
		Manage_Members_btn.click();
		Search_Users.sendKeys(Student_Lastname);
		WebElement Add_Student =  driver.findElement(By.xpath("//small[contains(text(),'"+Student_Lastname+"')]/parent::span/parent::div/parent::div/following::div/descendant::mat-icon[@mattooltip='Add User']"));
		int retries = 10;
		while (retries > 0) {
			try {
				wait.elementToBeClickable(Add_Student);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", Add_Student);
				break;
			} catch (StaleElementReferenceException e) {
				
				System.out.println("StaleElementReferenceException. Retrying...");
				StaticWait(1);
				retries--;
			}	
		}
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
