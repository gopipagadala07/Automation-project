package com.Assessments.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Benchmark_TeacherPage extends ActionType{

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
	private By AsseementTab = By.xpath("//a[contains(text(),'Assessment Center')]");
	//@FindBy(how=How.XPATH,using = "//span[@class='mat-tooltip-trigger cursor-Pointer ng-star-inserted']")private WebElement Assessmentcourse;
	@FindBy(how=How.XPATH,using = "//*[local-name()='svg' and @matTooltip='Benchmarks'] /*[name()='g']")private WebElement Benchmarktab;
	@FindBy(how = How.XPATH,using = "//button[@mattooltip='Schedule']")private WebElement Schedule;

	@FindBy(how=How.XPATH,using = "//span[text()='Progress']")private WebElement progress;
	//@FindBy(how=How.XPATH,using = "//b[normalize-space()='Test Status']")private WebElement teststatus;
	//mat-slide-toggle[@id='mat-slide-toggle-9']/child::label/child::span/child::input
	@FindBy(how=How.XPATH,using = "//h3[text()='AutoBenchmark3205']/following::div[2]/div/div/h5/following::mat-slide-toggle/label/span/child::input/following-sibling::span[1]")private WebElement teststatus;

	@FindBy(how = How.XPATH,using = "//div[@class='table_body_item ng-star-inserted']/child::mat-slide-toggle/child::label/child::span/child::input")private WebElement studentstatus;

	@FindBy(how=How.XPATH,using = "//div[@class='table_body_item']/child::label/child::small")private WebElement bandstatus;
	@FindBy(how=How.XPATH,using = "//mat-icon[contains(@class, 'mat-icon') and contains(text(), 'close')]")private WebElement closebtn;
	@FindBy(how=How.XPATH,using = "//*[local-name()='svg' and @matTooltip='Grades'] /*[name()='g']/*[name()='path'][1]")private WebElement Gradetab;
	@FindBy(how=How.XPATH,using = "//mat-icon[@role='img' and contains(@class, 'mat-icon') and text()='print']")private WebElement print;
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'By Standard')]")private WebElement bystandard;
	@FindBy(how=How.XPATH,using = "//mat-icon[@role='img' and contains(@class, 'mat-icon') and text()='print']")private WebElement stdprint;

	//@FindBy(how = How.XPATH, using = "//div[contains(text(),'EXAM')]")
	//private List<WebElement> examcount;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'EXAM')]")
	private List<WebElement> examcount;

	@FindBy(how=How.XPATH,using = "(//a[contains(text(),'Assessment Center')])[2]")private WebElement landpage;

	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Benchmarks')]/parent::div/parent::div/following-sibling::div/child::mat-list/mat-list-item/span")
	private List<WebElement> bmcount; // Using List to get all matches

//	@FindBy(how = How.XPATH, using = "//div[@role='tab' and @id='mat-tab-label-0-0']")
//	private WebElement hometab;

	@FindBy(how = How.XPATH,using="//input[contains(@type,'search')]")
	public WebElement Searchhere;

	public Benchmark_TeacherPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void learning()
	{

		WebElement AC = driver.findElement(AsseementTab);
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
		StaticWait(2);
	}

	public void benchmarktab()
	{
		StaticWait(2);
		wait.elementToBeClickable(Benchmarktab);
		Benchmarktab.click();

		wait.elementToBeClickable(Schedule);
		Schedule.click();
	}

	public void Activatetoggle()
	{
		wait.elementToBeClickable(progress);
		progress.click();


	}
	public void CheckStdToggle() {
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.elementToBeClickable(teststatus));
			wait.until(ExpectedConditions.visibilityOf(teststatus));
			if (teststatus.isEnabled()) {
				System.out.println("Test Status was already enabled");
			} else {
				wait.until(ExpectedConditions.elementToBeClickable(teststatus));
				wait.until(ExpectedConditions.visibilityOf(teststatus));
				teststatus.click();
			}
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

	public void bandstatus()
	{
		String statusText = bandstatus.getText();

		System.out.println("Band Status: " + statusText);

		wait.elementToBeClickable(closebtn);
		closebtn.click();
		StaticWait(3);
	}

	public void Grade()
	{
		
		wait.elementToBeClickable(Gradetab);
		JavascriptExecutor js=(JavascriptExecutor) driver;
        Actions a=new Actions(driver);
        a.moveToElement(Gradetab).click().build().perform();
		StaticWait(2);
		wait.elementToBeClickable(print);
		print.click();
	}
	public void standard()
	{
		StaticWait(2);
		wait.elementToBeClickable(bystandard);
		bystandard.click();

		StaticWait(2);
		wait.elementToBeClickable(stdprint);
		stdprint.click();
		//StaticWait(5);
		//hometab.click();

	}

	public int getListCount(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		return elements.size();
	}

	public void printCounts() {
		By benchmarkLocator = By.xpath("//app-assessmentcenter-bechmarklist//mat-list");

		By examLocator = By.xpath("//div[contains(text(),'EXAM')]/parent::div/parent::div/parent::div/parent::div/parent::mat-tab-header/following-sibling::div/mat-tab-body[2]/div/mat-list");


		int benchmarkCount = getListCount(benchmarkLocator);
		int examCount = getListCount(examLocator);

		System.out.println("Benchmark Count: " + benchmarkCount);
		System.out.println("Exam Count: " + examCount);
	}

	public void landpage()
	{
		StaticWait(2);
		wait.elementToBeClickable(landpage);
		landpage.click();

	}



}