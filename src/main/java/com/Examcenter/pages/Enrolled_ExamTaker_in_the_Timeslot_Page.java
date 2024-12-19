package com.Examcenter.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class Enrolled_ExamTaker_in_the_Timeslot_Page extends ActionType
{
	private Wait wait;
	static String ScheduleName;
	static String ExamName;
	private WebDriver driver;
	CommonPages cp=new CommonPages(Base.getDriver());
	JavascriptExecutor j=(JavascriptExecutor) Base.getDriver();
	Actions a=new Actions(Base.getDriver());
	
	@FindBy(how=How.XPATH,using="//mat-icon[text()='comment']")private WebElement Commenticon;
	@FindBy(how=How.XPATH,using="//p[@data-placeholder='Type here']/parent::div")private WebElement Comment_Textbox;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='computer']")private WebElement Entry_reentryIcon;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='close']")private WebElement Closeicon;
	
	public Enrolled_ExamTaker_in_the_Timeslot_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void ET_Entry_details()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Entry_reentryIcon);
		StaticWait(1);
		WebElement table = driver.findElement(By.id("tblEntryDetails"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() >= 2) {
                System.out.println(columns.get(0).getText() + " || " + columns.get(1).getText());
                ExtentCucumberAdapter.addTestStepLog(columns.get(0).getText() + " || " + columns.get(1).getText());
            }
        }		
		StaticWait(1);
		Actions act = new Actions(driver);
		act.moveToElement(Closeicon).click().build().perform();		
	}
	public void p_comment() {
	    int retries = 3;
	    boolean success = false;
	    
	    for (int attempt = 0; attempt < retries; attempt++) {
	        try {
	            Actions act = new Actions(Base.getDriver());
	            act.moveToElement(Commenticon).click().build().perform();
	            StaticWait(2);
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	            WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='descriptionField']/parent::div/child::div/child::div[2]/child::div[2]")));
	            if (e.isDisplayed() && e.isEnabled()) {
	                act.moveToElement(e).click().build().perform();
	                StaticWait(2);
	                e.sendKeys(generateRandomString());
	                System.out.println("Value sent to the comment box");
	                success = true;
	                break;
	            } else {
	                System.out.println("Element is not interactable");
	            }
	        } catch (TimeoutException te) {
	            System.out.println("Timeout: Element not found or not interactable. Attempt: " + (attempt + 1));
	        } catch (NoSuchElementException nse) {
	            System.out.println("No Such Element: The element was not found. Attempt: " + (attempt + 1));
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	        StaticWait(2);
	    }
	    if (!success) {
	        System.out.println("Failed to interact with the element after " + retries + " attempts");
	    }
	}

}
