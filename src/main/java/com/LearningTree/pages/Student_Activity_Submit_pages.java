package com.LearningTree.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

public class Student_Activity_Submit_pages extends ActionType {

	private WebDriver driver;
	private Wait wait;

	public String LearningTree_Name;

	CommonPages cp=new CommonPages(Base.getDriver());

	@FindBy(how = How.XPATH,using = "//span[text()='Learning']")private WebElement LearningTab;
	@FindBy(how = How.XPATH,using = "//a[text()='Learning Tree']")private WebElement LearningTree_Tab;
	@FindBy(how = How.XPATH,using = "//input[@type='search']")private WebElement SearchHere;
	@FindBy(how = How.XPATH,using = "//span[@mattooltip='Learning']")private WebElement Learning;

	@FindBy(how=How.XPATH,using="//div[text()=' All ']/parent::div")private WebElement All;
	//	@FindBy(how=How.XPATH,using="//mat-icon[text()='launch']/parent::span")private List<WebElement> LaunchIcon;

	//Launching Discussion
	@FindBy(how=How.XPATH,using="//span[text()=' New Post ']")private WebElement NewPost;
	@FindBy(how=How.XPATH,using="//p[@data-placeholder='Type here']")private WebElement TypehereText;

	@FindBy(how=How.XPATH,using="//span[text()=' Post ']")private WebElement Postbutton;
	@FindBy(how=How.XPATH,using="//span[text()=' Reply ']")private WebElement Replybutton;

	@FindBy(how=How.XPATH,using="//span[text()='Submit Discussion']")private WebElement SubmitDiscussion;

	@FindBy(how=How.XPATH,using="//mat-icon[text()='close']/parent::span")private WebElement CloseIcon;

	//Launching Assignment

	//@FindBy(how=How.XPATH,using="//mat-icon[text()=' add ']")private WebElement AddIcon;--->upload document
	@FindBy(how=How.XPATH,using="//span[text()='Submit Assignment']")private WebElement SubmitAssignment;

	//Launching Assessment
	@FindBy(how=How.XPATH,using="//span[text()=' Begin Test ']")private WebElement BeginTest;
	@FindBy(how=How.XPATH,using="//iframe[@class='iframe-styling ng-star-inserted']")private WebElement iFrame;
	@FindBy(how=How.XPATH,using="(//div[@class=\"mdc-radio\"])[1]")private WebElement McqAnswer;
	@FindBy(how=How.XPATH,using="//input[@type='text']")private WebElement FillAndExtended;

	@FindBy(how=How.XPATH,using="//mat-icon[text()='chevron_right']")private WebElement NextQ;
	@FindBy(how=How.XPATH,using="//span[text()='Finish']")private WebElement Finish;
	@FindBy(how=How.XPATH,using="//span[text()='Submit']")private WebElement Submit;



	public Student_Activity_Submit_pages(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void click_on_LearningtreeTab()
	{	
		if(LearningTree_Tab.isDisplayed())
		{
			wait.elementToBeClickable(LearningTree_Tab);
			LearningTree_Tab.click();
		}
		else
		{
			wait.elementToBeClickable(LearningTab);
			LearningTab.click();
			wait.elementToBeClickable(LearningTree_Tab);
			LearningTree_Tab.click();
		}
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
	public void learningTab()
	{
		wait.elementToBeClickable(Learning);
		Learning.click();
		StaticWait(2);
		All.click();
		StaticWait(2);
	}


	public void performActivities()
	{
		List<WebElement> LaunchIcon = driver.findElements(By.xpath("//mat-icon[text()='launch']"));
		for (int i = 0; i < LaunchIcon.size(); i++) {
			try {
				  WebElement nextLaunchIcon = LaunchIcon.get(i); 
				Actions Ac=new Actions(driver);
				Ac.moveToElement(nextLaunchIcon).click().build().perform();

				performDiscussionActivity(); 
	     
	      
//	            LaunchIcon = driver.findElements(By.xpath("//mat-icon[text()='launch']"));
//	            int i = 0;
//				if (i + 1 < LaunchIcon.size()) {
//	                WebElement nextLaunchIcon = LaunchIcon.get(i + 1); 
//	                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//	                wait1.until(ExpectedConditions.elementToBeClickable(nextLaunchIcon));
//	                Ac.moveToElement(nextLaunchIcon).click().build().perform();
//	            }

				performAssignmentActivity();
	            
			} catch (Exception ex) {
				System.out.println("Error clicking element: " + ex.getMessage());
			}
		}
	}


	
	private void performDiscussionActivity() {
		System.out.println("Performing Discussion activity...");
		// Add logic to handle discussion activity
		NewPost.click();
		TypehereText.sendKeys(generateRandomString());
		Postbutton.click();
		Replybutton.click();
		TypehereText.sendKeys(generateRandomString());
		Postbutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", SubmitDiscussion);
	     js.executeScript("arguments[0].click();", SubmitDiscussion);
		 js.executeScript("arguments[0].scrollIntoView(true);", CloseIcon);
	     js.executeScript("arguments[0].click();", CloseIcon); 
	//	SubmitDiscussion.click();
	}

	public void performAssignmentActivity() {
		System.out.println("Performing Assignment activity...");
		// Add logic to handle assignment activity
		TypehereText.sendKeys(generateRandomString());
		//SubmitAssignment.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", SubmitAssignment);
	     js.executeScript("arguments[0].click();", SubmitAssignment);
		 js.executeScript("arguments[0].scrollIntoView(true);", CloseIcon);
	     js.executeScript("arguments[0].click();", CloseIcon); 

	}

	public void performAssessmentActivity() {
		System.out.println("Performing Assessment activity...");
		// Add logic to handle assessment activity
	}

}

