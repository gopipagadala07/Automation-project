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
	@FindBy(how=How.XPATH,using = "//label[@for='mat-slide-toggle-11-input']//span[@class='mat-slide-toggle-thumb']")private WebElement teststatus;
	
	@FindBy(how = How.XPATH,using = "//div[@class='table_body_item ng-star-inserted']/child::mat-slide-toggle/child::label/child::span/child::input")private WebElement studentstatus;
	
	@FindBy(how=How.XPATH,using = "//div[@class='table_body_item']/child::label/child::small")private WebElement bandstatus;
	@FindBy(how=How.XPATH,using = "//mat-icon[contains(@class, 'mat-icon') and contains(text(), 'close')]")private WebElement closebtn;
	@FindBy(how=How.XPATH,using = "//*[local-name()='svg' and @matTooltip='Grades'] /*[name()='g']")private WebElement Gradetab;
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

	@FindBy(how = How.XPATH, using = "//div[@role='tab' and @id='mat-tab-label-0-0']")
	private WebElement hometab;

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



	//public void AssessmentCentre()
	//{
	//	wait.elementToBeClickable(Assessmentcentre);

	//	Assessmentcentre.click();

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
	public void CheckStdToggle()
	{
		StaticWait(2);
		wait.elementToBeClickable(teststatus);
		teststatus.click();}

	public void enableMainToggle() {
		if (!teststatus.isSelected()) {
			
		}
	}

	public boolean isMainToggleEnabled() {
		return teststatus.isSelected();
	}

	public boolean isStudentToggleActivated() {
		return studentstatus.isSelected();

	}


	public void bandstatus()

	{
		
		String statusText = bandstatus.getText();
		
		System.out.println("Band Status: " + statusText);

		wait.elementToBeClickable(closebtn);
		closebtn.click();


	}


	public void Grade()
	{
		StaticWait(2);
		wait.elementToBeClickable(Gradetab);
		Gradetab.click();

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
		StaticWait(5);
		hometab.click();

	}

/*	public void printCounts() {

		List<WebElement> Benchmarkcount=driver.findElements(By.xpath("//h3[contains(text(),'Benchmarks')]/parent::div/parent::div/following-sibling::div/child::mat-list/mat-list-item"));
		//app-assessmentcenter-bechmarklist//mat-list  
		//List<WebElement> Benchmarkcount=driver.findElements(By.xpath("//app-assessmentcenter-bechmarklist//mat-list"));

		List<WebElement> Homecount=driver.findElements(By.xpath("//div[contains(text(),'EXAM')]/parent::div/parent::div/parent::div/parent::div/parent::mat-tab-header/following-sibling::div/mat-tab-body[2]/div/mat-list"));

		int benchmarkCount = Benchmarkcount.size();
		int examCount = Homecount.size();

		// Print the counts
		System.out.println("Benchmark Count: " + benchmarkCount);
		System.out.println("Exam Count: " + examCount);
	}*/

	public int getListCount(By locator) {
	    List<WebElement> elements = driver.findElements(locator);
	    return elements.size();
	}

	public void printCounts() {
	    By benchmarkLocator = By.xpath("//app-assessmentcenter-bechmarklist//mat-list");
	//    By benchmarkLocator = By.xpath("//h3[contains(text(),'Benchmarks')]/parent::div/parent::div/following-sibling::div/child::mat-list/mat-list-item");

	    By examLocator = By.xpath("//div[contains(text(),'EXAM')]/parent::div/parent::div/parent::div/parent::div/parent::mat-tab-header/following-sibling::div/mat-tab-body[2]/div/mat-list");

	    
	    int benchmarkCount = getListCount(benchmarkLocator);
	    int examCount = getListCount(examLocator);
	    
	    // Print the counts
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