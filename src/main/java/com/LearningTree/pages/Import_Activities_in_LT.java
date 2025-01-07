package com.LearningTree.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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

public class Import_Activities_in_LT extends ActionType {
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
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='close']")public WebElement Close;
	public Import_Activities_in_LT(WebDriver driver)
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
		cp.searchField(CD_Name);
		StaticWait(1);
		WebElement Assign_to_Community_btn = driver.findElement(By.xpath("//b[text()='"+CD_Name+"']/ancestor::mat-card-header/following-sibling::mat-card-content/following::mat-card-actions/child::div/child::div"));
		Assign_to_Community_btn.click();
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
		try {
			Add_Student.click();

        } catch (StaleElementReferenceException e) {
        	Add_Student.click();
        }	
		 WebDriverWait wait = new WebDriverWait(driver, 10);

	        try {
	            // Wait for the toast notification to disappear (using the toast's unique class or id)
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-toastr.toast-success")));

	            // Locate the close button (mat-icon) and click
	            WebElement Close = driver.findElement(By.xpath("//mat-icon[text()='close']"));
	            wait.until(ExpectedConditions.elementToBeClickable(Close));  // Wait until it's clickable
	            Close.click();  // Click the close button
	            System.out.println("Close button clicked.");

	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Element is blocked by a toast notification or other element.");
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }

        
		
	}

	
}
