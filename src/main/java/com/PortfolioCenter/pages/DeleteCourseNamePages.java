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


public class DeleteCourseNamePages extends ActionType{
	static List<Map<String, String>> testdata=null;
	ExcelReader reader = new ExcelReader();
	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;
	static String DeleteCourseName;
	static int number = randomNumberGeneratorstatic();
	
	
	
	@FindBy(how=How.XPATH,using = "//*[text()='more_vert']/ancestor::button")private WebElement EllipseBtn;
	@FindBy(how=How.XPATH,using = "//*[text()='Add New Course']/parent::button")private WebElement AddNewCourseBtn;
	@FindBy(how=How.XPATH,using = "//*[text()='Title ']/parent::label")private WebElement TitleElement;
	@FindBy(how=How.XPATH,using = "//*[text()='Title ']/parent::label/parent::span/preceding-sibling::input")private WebElement inputTitleElement;
	@FindBy(how=How.XPATH,using = "//*[@data-placeholder='Type here']/parent::div")private WebElement DescriptionElement;
	@FindBy(how=How.XPATH,using = "//*[text()=' Save ']/parent::button")private WebElement savebtn;
	@FindBy(how=How.XPATH,using = "//*[text()='search here']/parent::label/parent::span/preceding-sibling::input")private WebElement inputsearchhereElement;
	
	
	
	@FindBy(how = How.XPATH,using = "//*[text()='Delete']/parent::button")private WebElement Deletebtn;
	@FindBy(how=How.XPATH,using = "//*[text()='Yes, Deleted!']")private WebElement YesDeleteBth;
	
	
	public WebElement Editbutton(String DeleteName) {
		String xpath = "//*[text()='"+DeleteName+"']/parent::span/following-sibling::div/child::mat-icon";
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement PortfolioName(String PortfolioCourseName) {
		String xpath ="//*[@class='mat-card-header-text']/child::mat-card-title/child::span/child::b[text()='"+PortfolioCourseName+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	
	
	public DeleteCourseNamePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}
	
	public void the_user_creates_a_portfolio_course_by_providing_a_title_and_description() {
		 wait.elementToBeClickable(EllipseBtn);
	     EllipseBtn.click();
	     wait.elementToBeClickable(AddNewCourseBtn);
	     AddNewCourseBtn.click();
	     wait.elementToBeClickable(TitleElement);
	     JavascriptExecutor jc = (JavascriptExecutor) driver;
	     jc.executeScript("arguments[0].click();", TitleElement);
	     
	     DeleteCourseName = "PortfolioCourse"+number;
	     StaticWait(1);
	     inputTitleElement.sendKeys(DeleteCourseName);
	     wait.elementToBeClickable(DescriptionElement);
	     DescriptionElement.sendKeys(generateRandomString());
	     wait.elementToBeClickable(savebtn);
	     savebtn.click(); 
	
	}
//	public void the_user_searche_for_the_course_and_clicks_on_it() {
//		StaticWait(1);
//	     JavascriptExecutor jc = (JavascriptExecutor) driver;
//	     wait.elementToBeClickable(inputsearchhereElement);
//			jc.executeScript("arguments[0].click();", inputsearchhereElement); 
//	     cp.searchField(DeleteCourseName);     
//}
	
	
	public void the_user_searche_for_the_course_and_clicks_on_it() {
	    StaticWait(1);
	    JavascriptExecutor jc = (JavascriptExecutor) driver;
	    wait.elementToBeClickable(inputsearchhereElement);
	    jc.executeScript("arguments[0].click();", inputsearchhereElement);

	    retrySearchForCourseName(DeleteCourseName, 4);
	}

	public void retrySearchForCourseName(String DeleteCourseName, int retryCount) {
	    int attempts = 0;
	    boolean isSuccessful = false;

	    while (attempts < retryCount && !isSuccessful) {
	        try {
	            // Wait for the input element to be clickable
	            wait.elementToBeClickable(inputsearchhereElement);
	            inputsearchhereElement.click();
	            inputsearchhereElement.clear(); // Clear the input field before sending keys
	            inputsearchhereElement.sendKeys(DeleteCourseName);

	            // Introduce a short static wait to let results load
	            StaticWait(4);

	            // Wait for the visibility of the desired course name
	            wait.visibilityOf(PortfolioName(DeleteCourseName));

	            // Use JavaScript executor to click on the course name
//	            JavascriptExecutor jc = (JavascriptExecutor) driver;
//	            jc.executeScript("arguments[0].click();", PortfolioName(DeleteCourseName));

	            isSuccessful = true; // If successful, mark the operation as successful
	        } catch (Exception e) {
	            attempts++;
	            System.out.println("Attempt " + attempts + " failed: " + e.getMessage());
	            if (attempts >= retryCount) {
	                throw new RuntimeException("Failed to search and click on course name after " + retryCount + " attempts.", e);
	            }
	        }
	    }
	}

	
	public void the_user_clicks_on_the_edit_portfolio_course_button_and_deletes_the_portfolio_course() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
//		wait.visibilityOf(PortfolioName(DeleteCourseName));
		StaticWait(1);
		wait.visibilityOf(Editbutton(DeleteCourseName));
		j.executeScript("arguments[0].click();", Editbutton(DeleteCourseName));
		System.out.println(DeleteCourseName);

		wait.elementToBeClickable(Deletebtn);
		j.executeScript("arguments[0].click();", Deletebtn);
		wait.elementToBeClickable(YesDeleteBth);
		j.executeScript("arguments[0].click();", YesDeleteBth);
		StaticWait(1);
    
}
		
	

	


}
