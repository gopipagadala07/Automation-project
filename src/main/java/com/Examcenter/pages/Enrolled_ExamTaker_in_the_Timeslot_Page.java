package com.Examcenter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(how=How.XPATH,using="//mat-icon[@name='myMatIcon' and text()='comment']")private WebElement Commenticon;
	@FindBy(how=How.XPATH,using="//p[@data-placeholder='Type here']/parent::div")private WebElement Comment_Textbox;
	@FindBy(how=How.XPATH,using="//mat-icon[@name='myMatIcon' and text()='computer']")private WebElement Entry_reentryIcon;
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
	public void p_comment()
	{
		Actions act = new Actions(Base.getDriver());
		act.moveToElement(Commenticon).click().build().perform();
       Comment_Textbox.sendKeys(generateRandomString());
	}
}
