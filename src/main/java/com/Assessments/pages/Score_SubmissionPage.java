package com.Assessments.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	/*
	 * Score at Speed Grader Level
	 */
	@FindBy(how = How.XPATH,using = "//span[contains(text(), 'Speed Grader')]")private WebElement Speed_Grader ;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Communities')]")private WebElement All_CommunitiesDropDown;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Activity Types')]")private WebElement All_Activity_TypesDropDown;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Activities')]")private WebElement All_ActivitiesDropDown;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Members')]")private WebElement All_MembersDropDown;
	@FindBy(how = How.XPATH,using = "//mat-icon[contains(text(), ' score')]")private WebElement Score;
	@FindBy(how = How.XPATH,using = "//iframe[@id='adminAssessment']")private WebElement Switch_To_iframe;
	@FindBy(how = How.XPATH,using = "//*[contains(text(), 'Candidate Response')]/following::div[3]/div/following::span/span/descendant::input")private WebElement Provide_Score;
	@FindBy(how = How.XPATH,using = "//div[@role='textbox']")private WebElement Provide_Feedback;
	@FindBy(how = How.XPATH,using = "//span[text()='Submit Scoring']")private WebElement Submit_score;
	
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
	public void All_MembersDropDown()
	{
		cp.FPdropdown(All_MembersDropDown, "1848 fpk12student");
	}
	public void click_On_Score()
	{
		Score.click();
	}
	public void provide_the_Score()
	{

		// Switch to the iframe using the WebElement
		driver.switchTo().frame(Switch_To_iframe);
		StaticWait(1);
		// Interact with elements inside the iframe
		Provide_Score.sendKeys("1");
        String randomString = generateRandomString();
		Provide_Feedback.sendKeys(randomString);
		StaticWait(1);
		Submit_score.click();
		// Switch back to the main page
		driver.switchTo().defaultContent();
	}
	
}
