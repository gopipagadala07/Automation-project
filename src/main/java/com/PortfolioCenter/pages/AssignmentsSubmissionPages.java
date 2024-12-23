package com.PortfolioCenter.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.ExcelReader;
import com.Utils.Wait;


public class AssignmentsSubmissionPages extends ActionType{
	static List<Map<String, String>> testdata=null;
	ExcelReader reader = new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;

	static int number = randomNumberGeneratorstatic();
	
	@FindBy(how = How.XPATH,using = "//*[(text()='Learning')]")private WebElement Learningtab;
	@FindBy(how=How.XPATH,using = "//*[text()='Portfolio Courses']")private WebElement PortfolioCourseTab;
	@FindBy(how = How.XPATH,using = "//*[text()='Launch']/parent::button")private WebElement  LaunchBtn ;
	@FindBy(how=How.XPATH,using = "//*[@data-placeholder='Type here']/parent::div")private WebElement TextEntryElement;
	@FindBy(how=How.XPATH,using = "//*[text()=' Submit Assignment ']/parent::button")private WebElement SubmitAssignmentbtn;
	@FindBy(how = How.XPATH,using = "//*[text()='close']/parent::span/parent::button") private WebElement  closebtnElement;
	
	public WebElement ContinueLearningBtn(String  LearningBth) {
		String xpath = "//*[contains(text(),'"+ LearningBth+"')]/parent::div/following-sibling::button";
		return driver.findElement(By.xpath(xpath));
	}
	
	
	public WebElement  AssignmentNamebtn(String  Assignment) {
		String xpath = "//*[contains(text(),'"+ Assignment +"')]//parent::span";
		return driver.findElement(By.xpath(xpath));
	}
	
	
	public AssignmentsSubmissionPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}
	
	public void the_user_clicks_on_learning_and_portfolio_courses() {
		   wait.elementToBeClickable(Learningtab); 
		   Learningtab.click();
		   wait.elementToBeClickable(PortfolioCourseTab);
		   PortfolioCourseTab.click(); 
	}
	
	
	public void the_user_selects_the_course_and_clicks_on_the_continue_learning(Integer CourseName) throws AWTException, InvalidFormatException, IOException {
		 if (testdata == null) {
				testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
			}
			String name = testdata.get(CourseName).get("CourseName");
			System.out.println(name);
		StaticWait(1);
		wait.visibilityOf(ContinueLearningBtn(name));
		Actions act = new Actions(driver);
		act.moveToElement(ContinueLearningBtn(name)).perform();
		act.click().perform();
		cp.scrollWithRobot();
			
			
		}
		public void the_user_launches_the_assignment_and_submit_the_assignment(Integer AssignmentName) throws AWTException, InvalidFormatException, IOException {
			if (testdata == null) {
				testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
			}
			String AssignmentNametab = testdata.get(AssignmentName).get("AssignmentName");
			System.out.println(AssignmentNametab);
			 JavascriptExecutor jc = (JavascriptExecutor) driver;
		     jc.executeScript("arguments[0].click();", AssignmentNamebtn(AssignmentNametab));
		     StaticWait(2);
			wait.elementToBeClickable(LaunchBtn);
			JavascriptExecutor j = (JavascriptExecutor) driver;
		     j.executeScript("arguments[0].click();", LaunchBtn);
			StaticWait(4);
			wait.elementToBeClickable(TextEntryElement);
			TextEntryElement.click();
			TextEntryElement.sendKeys(generateRandomString());
			cp.scrollWithRobot();
			wait.elementToBeClickable(SubmitAssignmentbtn);
			SubmitAssignmentbtn.click();
			StaticWait(4);
			wait.elementToBeClickable(closebtnElement);
			JavascriptExecutor je = (JavascriptExecutor) driver;
		     je.executeScript("arguments[0].click();", closebtnElement);
			
			
		}
		
	

}
