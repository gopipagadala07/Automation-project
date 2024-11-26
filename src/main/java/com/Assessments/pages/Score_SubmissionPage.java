package com.Assessments.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.Wait;

public class Score_SubmissionPage extends ActionType
{
	CommonPages cp=new CommonPages(Base.getDriver());
	static String ClassroomName;
	public WebDriver driver;
	private Wait wait;
	static int SLastName;
	static String SFirstName;
	
	/*
	 * Score at Speed Grader Level
	 */
	@FindBy(how = How.XPATH,using = "//span[contains(text(), 'Speed Grader')]")private WebElement Speed_Grader ;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Communities')]")private WebElement All_CommunitiesDropDown;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Activity Types')]")private WebElement All_Activity_TypesDropDown;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Activities')]")private WebElement All_ActivitiesDropDown;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Members')]")private WebElement All_MembersDropDown;
	@FindBy(how = How.XPATH,using = "//mat-icon[contains(text(), ' score')]")private WebElement Score;
	/*
	 *Provide the Score in iframe
	 */
	@FindBy(how = How.XPATH,using = "//iframe[@id='adminAssessment']")private WebElement Switch_To_iframe;
	@FindBy(how = How.XPATH,using = "//*[contains(text(), 'Candidate Response')]/following::div[3]/div/following::span/span/descendant::input")private WebElement Provide_Score;
	@FindBy(how = How.XPATH,using = "//div[@role='textbox']")private WebElement Provide_Feedback;
	@FindBy(how = How.XPATH,using = "//span[text()='Submit Scoring']")private WebElement Submit_score;
	/*
	 *Provide the Score Quiz Level
	 */
	@FindBy(how = How.XPATH,using = "//span[@class='assessment_icon_wrapper']/../../following-sibling::div/descendant::mat-icon")private List<WebElement> Quiz_List;
	@FindBy(how = How.XPATH,using = "//span[@class='assessment_icon_wrapper']")private List<WebElement> Assessment_List;
	@FindBy(how = How.XPATH,using = "//span[@mattooltip='Assessments']")private WebElement Quiz_Tab;
	@FindBy(how = How.XPATH,using = "//span[contains(text(), 'Progress')]")private WebElement Progress;
	@FindBy(how = How.XPATH,using = "//div[@class='course-unit']")private WebElement All;
	@FindBy(how = How.XPATH,using = "//div[contains(text(), 'Status / Performance')]/../../following-sibling::div/descendant::small")private WebElement Status;
	@FindBy(how = How.XPATH,using = "//div[text() = 'Assessment']/ancestor::mat-dialog-container/descendant::span/mat-icon[text()='close']")private WebElement Close_Scoring_Screen;
	@FindBy(how = How.XPATH,using = "//*[text()='Activity Progress']/../button")private WebElement Close_Activity_Progress_screen;
	/*
	 *Provide the Score Quiz Level
	 */
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Learning')]")private WebElement LearningTab;
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'Speed Grader')]")private WebElement Speed_Grader_Tab;
	@FindBy(how = How.XPATH,using = "//div[contains(text(),'Exams')]/../../../../../following-sibling::div/descendant::mat-list[1]/span[1]")private WebElement Exam;


	public Score_SubmissionPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}
	public void speedGrader()
	{
		Speed_Grader.click();
		
	}
//	public void select_CommunitiesDropDown()
//	{
//		cp.FPdropdown(All_CommunitiesDropDown, "FPK12Classroom8989");
//	}
	public void select_CommunitiesDropDown(String ClassroomName)
	{
		cp.FPdropdown(All_CommunitiesDropDown, ClassroomName);
	}
	public void all_Activity_TypesDropDown()
	{
		cp.FPdropdown(All_Activity_TypesDropDown, "Quiz");
	}
	public void all_ActivitiesDropDown()
	{
		cp.FPdropdown(All_ActivitiesDropDown, "Automation Test");
	}
	public void All_MembersDropDown(String LastName,String FirstName)
	{
		//cp.FPdropdown(All_MembersDropDown, "1848 fpk12student");
		String StudentName = LastName + " " + FirstName;
	    cp.FPdropdown(All_MembersDropDown, StudentName);
	}
	
	public void click_On_Score()
	{
		Score.click();
	}
	public void provide_the_Score()
	{

		// Switch to the iframe using the WebElement
		
//		driver.switchTo().frame(Switch_To_iframe);
		
		StaticWait(1);
		driver.switchTo().frame(0);
		// Interact with elements inside the iframe
		Provide_Score.sendKeys("1");
        String randomString = generateRandomString();
		Provide_Feedback.sendKeys(randomString);
		StaticWait(1);
		Submit_score.click();
		// Switch back to the main page
		driver.switchTo().defaultContent();
	}
	
	public void click_On_Quiz_Tab_and_All()
	{
		wait.elementToBeClickable(Quiz_Tab);
        wait.visibilityOf(Quiz_Tab);
		Quiz_Tab.click();
		wait.elementToBeClickable(All);
        wait.visibilityOf(All);
        All.click();
		
	}
	public void Provide_the_for_each_Quiz_in_Activity_Progress_Screen()
	{
		Score_SubmissionPage Score_S =new Score_SubmissionPage(Base.getDriver());
		 for (int i = 0; i < Quiz_List.size(); i++) 
		 {
	            JavascriptExecutor js = (JavascriptExecutor) driver;

	            try 
	            {
	            	 WebElement ellipse = Quiz_List.get(i);
//	 	            WebElement AL = Assessment_List.get(i);
	            	wait.visibilityOf(ellipse);
		            wait.elementToBeClickable(ellipse);
		            StaticWait(1);
		           ellipse.click();
	    		} 
	            catch (StaleElementReferenceException e)
	            {
	            	WebElement ellipse = Quiz_List.get(i);
	 	            WebElement AL = Assessment_List.get(i);
//	    		    // Re-find the element and retry
	    			StaticWait(1);
	                js.executeScript("arguments[0].scrollIntoView(true);", ellipse);
	    			System.out.println("Element click intercepted");
		            wait.elementToBeClickable(ellipse);
		            Actions actions = new Actions(driver);
		            actions.moveToElement(AL).build().perform();
//		            ellipse.click();
		            actions.moveToElement(ellipse).click().build().perform();
//	    			System.out.println("Element click intercepted");
	    		}
	            
		          wait.elementToBeClickable(Progress);
		          wait.visibilityOf(Progress);
		          Progress.click();
		          String Actual_Student_Status = Status.getText();
		          System.out.println(Actual_Student_Status);
		          String Student_Status = "SCORE";
		          if(Actual_Student_Status.equals(Student_Status))
		          {
		        	  Status.click();
		        	  Score_S.provide_the_Score();
		        	  Close_Scoring_Screen.click();
		        	  StaticWait(1);
		        	  Close_Activity_Progress_screen.click();
		          }
		          else
		          {
		        	  StaticWait(1);
		        	  Close_Activity_Progress_screen.click();
		          }
	        }
	}
	public void Navigate_Assessment_SpeedGrader_page()
	{
		WebElement SGT = Speed_Grader_Tab;
		if(SGT.isDisplayed())
		{
			SGT.click();
		}
		else
		{
			LearningTab.click();
			SGT.click();
		}
	}
	public void click_On_Exam()
	{
		wait.elementToBeClickable(Exam);
        wait.visibilityOf(Exam);
        Actions Ac = new Actions(Base.getDriver());
        Ac.moveToElement(Exam).perform();
        StaticWait(2);
        Ac.click(Exam).build().perform();
//        Exam.click();
	
	}
}
