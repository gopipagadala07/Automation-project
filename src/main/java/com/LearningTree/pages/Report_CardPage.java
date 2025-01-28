package com.LearningTree.pages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
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
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class Report_CardPage extends ActionType{

	private WebDriver driver;
	private Wait wait;
	CommonPages cp=new CommonPages(Base.getDriver());

	@FindBy(how=How.XPATH,using = "//*[name()='svg' and  @matTooltip='Report Card']")private WebElement Report_Card_Tab;
	@FindBy(how=How.XPATH,using = "//a[contains(text(), 'Comments')]")private WebElement Comments_btn;
	@FindBy(how=How.XPATH,using = "//textarea[@name='commentsField']")private WebElement CommentsField;
	@FindBy(how=How.XPATH,using = "//mat-icon[text()='close']")private WebElement close_btn;
	@FindBy(how=How.XPATH,using = "(//b[contains(text(),'CourseDesigner')])[1]")private WebElement FirstActivity_in_ReportCard;
	@FindBy(how=How.XPATH,using = "//div[text()='Activity Preview']")private WebElement Activity_Preview;
	@FindBy(how=How.XPATH,using = "//fp-search/parent::div/following-sibling::div/child::button")private WebElement Report_card_ellipse;
	@FindBy(how=How.XPATH,using = "//span[text()='Export Report Card']")private WebElement Export_Report_Card;

	
	
	public Report_CardPage(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void report_Card_Tab()
	{
		wait.elementToBeClickable(Report_Card_Tab);
		Report_Card_Tab.click();
	}
	public void provide_the_Comments()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		int count = 5;
		while(count>1)
		{
			try
			{
				js.executeScript("arguments[0].scrollIntoView(true);", Comments_btn);
				js.executeScript("arguments[0].click();", Comments_btn);
				wait.elementToBeClickable(CommentsField);
				Actions actions = new Actions(driver);
				actions.moveToElement(CommentsField).click().sendKeys("Well done! Let's aim for an even higher score next time.").perform();
				break;
			}
			catch(StaleElementReferenceException e)
			{
				System.out.println("StaleElementReferenceException!!!!!");
				count--;
			}
		}

		cp.Save();
		js.executeScript("arguments[0].click();", close_btn);

	}
	public void preview_the_Activity_in_Report_Card()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", FirstActivity_in_ReportCard);
		js.executeScript("arguments[0].click();", FirstActivity_in_ReportCard);
		wait.elementToBeClickable(Activity_Preview);
		if(Activity_Preview.isDisplayed())
		{
			js.executeScript("arguments[0].click();", close_btn);
			System.out.println("User able to see the Activity in preview screen");
		}
		else
		{
			System.out.println("Unable to see the Activity Preview Screen !!!!!");
		}

	}
	public void export_And_Print_the_Report_Table()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Report_card_ellipse);
		js.executeScript("arguments[0].click();", Report_card_ellipse);
		
		js.executeScript("arguments[0].click();", Export_Report_Card);
		StaticWait(2);
		
		
		try {
			Path downloadDir = Paths.get(System.getProperty("user.home"), "Downloads");
			Optional<Path> latestFile = Files.list(downloadDir)
					.filter(Files::isRegularFile)
					.max(Comparator.comparingLong(p -> p.toFile().lastModified()));

			if (latestFile.isPresent()) {
				Path source = latestFile.get();
				System.out.println("Latest file found: " + source.toString());
				String filePath = source.toAbsolutePath().toString();
				String fileLink = "<a href='file:///" + filePath + "' target='_blank'>Download Report Card File</a>";
				ExtentCucumberAdapter.addTestStepLog("Latest file found: " + source.toString() + " - " + fileLink);
			} else {
				System.out.println("No files found in the Downloads directory.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	

	}
}
