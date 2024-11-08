package com.Assessments.pages;

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

public class Benchmark_Scoring extends ActionType{

	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;
	static String ClassroomName;
	static String SectionName;
	static int DLastName;
	static int TLastName;
	static int SLastName;
	static String DFirstName;
	static String TFirstName;
	static String SFirstName;

	/*
	 * Activate & Deactivate toggles
	 */

	private By Learningtab = By.xpath("//span[contains(text(),'Learning')]");
	private By AssessmentTab = By.xpath("//a[contains(text(),'Assessment Center')]");

	@FindBy(how=How.XPATH,using = "//*[local-name()='svg' and @matTooltip='Benchmarks'] /*[name()='g']")private WebElement Benchmarktab;

	@FindBy(how = How.XPATH,using = "//button[@mattooltip='Schedule']")private WebElement Schedule;

	@FindBy(how=How.XPATH,using = "//span[text()='Progress']")private WebElement progress;

	private By close = By.xpath("//mat-icon[normalize-space()='close']");

	@FindBy(how=How.XPATH,using = "//div[@class='table_body_item']/*[text()='Score']")private WebElement scorebnd;
	@FindBy(how=How.XPATH,using = "//div[@class='table_body_item']/child::label/child::small")private WebElement bandstatus;
	@FindBy(how=How.XPATH,using = "//input[@type='number']")private WebElement score;
	@FindBy(how=How.XPATH,using = "//iframe[@class='dashboard-report']")private WebElement iframe;
	
	


	public Benchmark_Scoring(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void learning()
	{

		WebElement AC = driver.findElement(AssessmentTab);
		if(AC.isDisplayed())
		{
			AC.click();
		}
		else
		{
			driver.findElement(Learningtab).click();
			AC.click();
		}
	}

	public WebElement getCommunityNameElement(String ClassroomName) {
		String xpath = "//span[(text()='"+ClassroomName+"')]/parent::div/parent::mat-card-content/preceding-sibling::mat-card-header/child::div/mat-card-title/child::span";
		return driver.findElement(By.xpath(xpath));
	}

	public void AssessmentCentre(String ClassroomName, String SectionName, String TLastName, String TFirstName)
	{
		cp.searchField(ClassroomName + "(" + SectionName + ")-"+ TLastName + " " + TFirstName);
		StaticWait(2);
		wait.visibilityOf(getCommunityNameElement(ClassroomName));
		wait.elementToBeClickable(getCommunityNameElement(ClassroomName));
		Actions a=new Actions(driver);
		a.moveToElement(getCommunityNameElement(ClassroomName)).click().build().perform();
		//      JavascriptExecutor js=(JavascriptExecutor) driver;
		//      js.executeScript("arguments[0].click();", getCommunityNameElement(ClassroomName));



		//wait.elementToBeClickable(Assessmentcourse);
		//Assessmentcourse.click();
		StaticWait(2);

	}

	public void benchmarktab(){

		StaticWait(2);
		wait.elementToBeClickable(Benchmarktab);
		Benchmarktab.click();
	}

	public void Activityprogress(){

		StaticWait(2);
		wait.elementToBeClickable(Schedule);
		Schedule.click();


		StaticWait(2);
		wait.elementToBeClickable(progress);
		progress.click();
	}
	public void Scoringscreen(){

		StaticWait(2);
		wait.elementToBeClickable(scorebnd);
		scorebnd.click();

	}

	public void Submitscore(){
		
		driver.switchTo().frame(0);
		
		StaticWait(5);
		wait.elementToBeClickable(score);
		score.sendKeys("3");
		
	}	


	public void bandstatus(){

		String statusText = bandstatus.getText();

		System.out.println("Band Status: " + statusText);

		//wait.elementToBeClickable(closebtn);
		//closebtn.click();

	}

}