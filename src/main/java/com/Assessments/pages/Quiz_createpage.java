package com.Assessments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Utils.ActionType;

public class Quiz_createpage extends ActionType
{
	private WebDriver driver;
	private By Username = By.xpath("//input[@placeholder='Username']");
	private By Password = By.xpath("//input[@placeholder='Password']");
	private By Login = By.xpath("//button[contains(text(), 'Login')]");
	private By Learning = By.xpath("//span[contains(text(),'Learning')]");
	private By Asseement_btn = By.xpath("//a[contains(text(),'Assessment Center')]");
	private By search_AC_community = By.xpath("//input[@data-placeholder='search here']");
	private By click_on_AC_Community = By.xpath("//span[contains(text(),'wefrbg(S-Section)')]");
	private By go_To_Assessment_Tab = By.xpath("//span[@mattooltip='Assessments']");
	
	public Quiz_createpage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void Login() {
		
		waitForPageLoad();
		StaticWait(2);
		driver.findElement(Username).sendKeys("steacher.ss.5");
		driver.findElement(Password).sendKeys("@Abcd1234");
		driver.findElement(Login).click();		

	}
	public void Navigate_AC_page()
	{
		WebElement AC = driver.findElement(Asseement_btn);
		if(AC.isDisplayed())
		{
			AC.click();
		}
		else
		{
			driver.findElement(Learning).click();
			AC.click();
		}
//        // Find the tab (e.g., "Learning" tab) using XPath, ID, or CSS selector
//        WebElement learningTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'Learning')]")));
//
//        // Check if the tab is already expanded by checking for a class or visibility of a sub-option
//        String isExpanded = learningTab.getAttribute("class");  // Replace with actual class attribute
//        if (!isExpanded.contains("expanded-class-name")) {  // Replace 'expanded-class-name' with the actual class for expanded state
//            // If the tab is not expanded, click to expand
//            learningTab.click();
//        }
//
//        // After ensuring the tab is expanded, find the button inside the tab and click it
//        WebElement courseDesignerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Course Designer')]")));
//        courseDesignerButton.click();
		
	}
	public void search_The_Community()
	{
		driver.findElement(search_AC_community).sendKeys("wefrbg(S-Section)");
	}
	public void click_On_The_Community()
	{
		try {
		    WebElement element = driver.findElement(click_on_AC_Community);
		    element.click();
		} catch (StaleElementReferenceException e) {
		    // Re-find the element and retry
			WebElement element = driver.findElement(click_on_AC_Community);
		    element.click();
		}
	}
	public void go_To_Assessment_Tab()
	{
		WebElement assessmentsTab= driver.findElement(go_To_Assessment_Tab);
		Actions actions = new Actions(driver);
		actions.moveToElement(assessmentsTab).click().build().perform();
		
	}
}
