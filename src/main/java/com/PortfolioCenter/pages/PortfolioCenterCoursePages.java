package com.PortfolioCenter.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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


public class PortfolioCenterCoursePages extends ActionType{
	static List<Map<String, String>> testdata=null;
	ExcelReader reader = new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;
	static String PortfolioCourseName;
	static String assignmentname;
	static int number = randomNumberGeneratorstatic();
	
	
	@FindBy(how = How.XPATH,using = "//*[(text()='Learning')]")private WebElement Learningtab;
	@FindBy(how=How.XPATH,using = "//*[text()='Portfolio Center']")private WebElement PortfolioCenterTab;
	@FindBy(how=How.XPATH,using = "//*[text()='more_vert']/ancestor::button")private WebElement EllipseBtn;
	@FindBy(how=How.XPATH,using = "//*[text()='Add New Course']/parent::button")private WebElement AddNewCourseBtn;
	@FindBy(how=How.XPATH,using = "//*[text()='Title ']/parent::label")private WebElement TitleElement;
	@FindBy(how=How.XPATH,using = "//*[text()='Title ']/parent::label/parent::span/preceding-sibling::input")private WebElement inputTitleElement;
	@FindBy(how=How.XPATH,using = "//*[@data-placeholder='Type here']/parent::div")private WebElement DescriptionElement;
	@FindBy(how=How.XPATH,using = "//*[text()=' Save ']/parent::button")private WebElement savebtn;
//	@FindBy(how=How.XPATH,using = "//*[text()='search here']/parent::label")private WebElement searchhereElement;
	@FindBy(how=How.XPATH,using = "//*[text()='search here']/parent::label/parent::span/preceding-sibling::input")private WebElement inputsearchhereElement;
//	@FindBy(how=How.XPATH,using = "//*[text()='+CourseName+']/ancestor::mat-card-title")private WebElement CourseNameElement;
	@FindBy(how=How.XPATH,using = "//*[text()=' Portfolio Assignment ']/parent::button")private WebElement  AddAssignmentElement;
//	@FindBy(how=How.XPATH,using = "//*[text()='Name ']/parent::label")private WebElement AssignmentNameElement;
	@FindBy(how=How.XPATH,using = "//*[text()='Name ']/parent::label/parent::span/preceding-sibling::input")private WebElement inputAssignmentNameElement;
//	@FindBy(how=How.XPATH,using = "//*[@data-placeholder='Type here']/parent::div/parent::div/parent::div/parent::div/parent::fp-ckeditor/parent::div//parent::div/child::label[text()='Description/Instructions']")
//	private WebElement DecInstElement;
//	@FindBy(how=How.XPATH,using = "//*[@data-placeholder='Type here']/parent::div/parent::div/parent::div/parent::div/parent::fp-ckeditor/parent::div/parent::div/parent::mat-card-content/parent::mat-card//child::div[text()=' Rubric ']")
//	private WebElement  RubricElement;
	@FindBy(how=How.XPATH,using = "(//*[@data-placeholder='Type here'])[1]")private WebElement DecInstElement;
	@FindBy(how=How.XPATH,using = "(//*[@data-placeholder='Type here'])[2]")private WebElement  RubricElement;
	@FindBy(how=How.XPATH,using = "//*[text()='Tags']/parent::div")private WebElement TagsElement;
	@FindBy(how=How.XPATH,using = "//*[text()=' Standards ']/parent::span")private WebElement  StandardsTabElement;
	@FindBy(how = How.XPATH,using = "//*[text()='+subCode+']/..") private WebElement  StandardsElement;
	@FindBy(how = How.XPATH,using = "//*[text()='Save']/parent::button") private WebElement  SavebtnElement;
	@FindBy(how = How.XPATH,using = "//*[local-name()='svg' and @matTooltip='Members']/parent::div") private WebElement MembersTabElement;
	@FindBy(how = How.XPATH,using = "//*[text()=' Manage Members ']/parent::button") private WebElement ManageMembersbElement;
	@FindBy(how = How.XPATH,using = "(//*[text()='search here']/parent::label)[1]") private WebElement SearchuserinmemnberTabElement;
	@FindBy(how = How.XPATH,using = "//*[text()='+username+']/parent::span/parent::div/parent::div/following-sibling::div/child::a/child::mat-icon") 
	private WebElement AdduserElement;
	@FindBy(how = How.XPATH,using = "//*[text()='close']/parent::span/parent::button") private WebElement  closebtnElement;
	@FindBy(how = How.XPATH,using = "//*[local-name()='svg']/parent::span[@mattooltip='Portfolio']") private WebElement  PortfolioElement;
//	@FindBy(how = How.XPATH,using = "//*[text()="+AssignmentName+"]/parent::div") private WebElement  ACElement;
	@FindBy(how = How.XPATH,using = "//*/child::tr/child::td[contains(text(),'+StudentName+')]") private WebElement  StudentElement;
	
	
	public WebElement PortfolioName(String PortfolioCourseName) {
		String xpath ="//*[@class='mat-card-header-text']/child::mat-card-title/child::span/child::b[text()='"+PortfolioCourseName+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement AssignmentName(String ACName) {
		String xpath = "//*[text()='"+ACName+"']/parent::div";
		return driver.findElement(By.xpath(xpath));
	}
	
	
	public WebElement Standards(String Code) {
		String xpath = "//*[@class='fontchanges ng-star-inserted']/child::span[text()='"+Code+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement LastName(String name) {
		String xpath = "//*[contains(text(),'"+name+"')]/parent::span/parent::div/parent::div/following-sibling::div/child::a/child::mat-icon";
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement verifiesUser(String verify) {
		String xpath = "//*/child::tr/child::td[contains(text(),'"+verify+"')]";
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement verifiesStudent(String Student) {
		String xpath = "//*[text()=' Student Name ']/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td[contains(text(),'"+Student+"')]";
		return driver.findElement(By.xpath(xpath));
	}
	
	
	public PortfolioCenterCoursePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}
	
	public void the_user_clicks_on_learning_and_portfolio_center() {
	   wait.elementToBeClickable(Learningtab); 
	   Learningtab.click();
	   wait.elementToBeClickable(PortfolioCenterTab);
	   PortfolioCenterTab.click();
	}

	public void the_user_creates_a_portfolio_course_by_entering_the_title_and_description() {
	     wait.elementToBeClickable(EllipseBtn);
	     EllipseBtn.click();
	     wait.elementToBeClickable(AddNewCourseBtn);
	     AddNewCourseBtn.click();
	     wait.elementToBeClickable(TitleElement);
	     JavascriptExecutor jc = (JavascriptExecutor) driver;
	     jc.executeScript("arguments[0].click();", TitleElement);     
	     PortfolioCourseName = "PortfolioCourse"+number;
	     StaticWait(1);
	     inputTitleElement.sendKeys(PortfolioCourseName);
	     wait.elementToBeClickable(DescriptionElement);
	     DescriptionElement.sendKeys(generateRandomString());
	     wait.elementToBeClickable(savebtn);
	     savebtn.click(); 
	     StaticWait(2);
	}

	public void the_user_searches_for_the_specific_course_and_clicks_on_it() throws InvalidFormatException, IOException {	
	     StaticWait(1);
	     JavascriptExecutor jc = (JavascriptExecutor) driver;
	     wait.elementToBeClickable(inputsearchhereElement);
			jc.executeScript("arguments[0].click();", inputsearchhereElement); 
	     cp.searchField(PortfolioCourseName);
	     inputsearchhereElement.sendKeys(Keys.BACK_SPACE);
	     wait.visibilityOf(PortfolioName(PortfolioCourseName));
//	     PortfolioName(PortfolioCourseName).click();	 
	     jc.executeScript("arguments[0].click();", PortfolioName(PortfolioCourseName));
			    
	}

	public void the_user_clicks_on_the_add_portfolio_assignment_button() {
		StaticWait(1);
	     wait.elementToBeClickable(AddAssignmentElement);
	     AddAssignmentElement.click();  
	}

	public void the_user_enters_the_assignment_name_description_and_selects_standards(Integer Standards) throws InvalidFormatException, IOException {
		StaticWait(1);
		 wait.elementToBeClickable(inputAssignmentNameElement);
		 inputAssignmentNameElement.click();
		 assignmentname ="AssignmentName"+number;
		 inputAssignmentNameElement.sendKeys(assignmentname);
	     wait.elementToBeClickable(DecInstElement);
	     DecInstElement.click();
	     DecInstElement.sendKeys(generateRandomString());
	     wait.elementToBeClickable(RubricElement);
	     RubricElement.click();
	     RubricElement.sendKeys(generateRandomString());
	     wait.elementToBeClickable(TagsElement);
	     TagsElement.click();
	     wait.elementToBeClickable(StandardsTabElement);
	     StandardsTabElement.click();
	     StaticWait(1);
  
	     if (testdata == null) {
				testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
			}
			String StandardsCode = testdata.get(Standards).get("Standards");
			Actions act = new Actions(driver);
			act.moveToElement(Standards(StandardsCode)).perform();
			act.click().perform();
		     StaticWait(1);
	     
	}

	public void the_user_clicks_on_the_save_button() {
	     wait.elementToBeClickable(SavebtnElement);
	     System.out.println("save");
	     SavebtnElement.click();
	     
	}

	public void the_user_navigates_to_the_members_tab_searches_for_the_username_in_the_search_here_field_using_row(Integer LastName) throws InvalidFormatException, IOException{
		StaticWait(1);
		wait.elementToBeClickable(MembersTabElement);
		MembersTabElement.click();
		StaticWait(1);
		wait.elementToBeClickable(ManageMembersbElement);
		ManageMembersbElement.click();
		
		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
		}
		String User = testdata.get(LastName).get("LastName");
		System.out.println(User);
		StaticWait(1);
		cp.searchField2(User);
		Actions act = new Actions(driver);
		act.moveToElement(LastName(User)).perform();
		StaticWait(2);
		act.click().perform();

	}

	public void assign_the_user_to_the_assignment() {
		StaticWait(4);
		wait.visibilityOf(closebtnElement);
	  wait.elementToBeClickable(closebtnElement);
	  JavascriptExecutor jc = (JavascriptExecutor) driver;
	     jc.executeScript("arguments[0].click();", closebtnElement);
//	  closebtnElement.click();
	}

	public void the_user_navigates_to_the_portfolio_tab() {
		StaticWait(1);
	    wait.elementToBeClickable(PortfolioElement);
	    PortfolioElement.click();
	}

	public void clicks_on_the_assignment_and_verifies_that_the_user_is_added_to_the_assignment(Integer verifyName) throws InvalidFormatException, IOException, AWTException {
		StaticWait(2);
		System.out.println(assignmentname);
		wait.visibilityOf(AssignmentName(assignmentname));
		AssignmentName(assignmentname).click();
	    StaticWait(1);
	    cp.scrollWithRobot();
		if (testdata == null) {
			testdata = reader.getData("/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
		}
		String Name = testdata.get(verifyName).get("LastName");
		String verify = testdata.get(verifyName).get("LastName");
		String StudentVerify = verifiesStudent(verify).getText();
		
		if (Name != null && StudentVerify != null && StudentVerify.contains(Name)) {
		    System.out.println("User Added");
		} else {
		    System.out.println("User Not Added");
		    System.out.println("Expected Name: " + Name);
		    System.out.println("Fetched Name: " + StudentVerify);
		}
	
		
	}
	public void PortfolioCourseNameInsertmultipledataIntoExcel() throws Exception
	{
		cp.PortfolioCourseNameInsertmultipledataIntoExcel("./src/test/resources/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	}
	
	public void PortfolioAssignmentnameInsertmultipledataIntoExcel() throws Exception
	{
		cp.PortfolioAssignmentnameInsertmultipledataIntoExcel("./src/test/resources/ExcelFiles/LoginDetails.xlsx", getSheetEnv());
	}
//	public void intert() throws Exception
//	{
//		cp.InsertdataIntoExcelOne("./src/test/resources/ExcelFiles/LoginDetails.xlsx", getSheetEnv(), PortfolioCenterCoursePages.assignmentname, 20);
//	}

}
