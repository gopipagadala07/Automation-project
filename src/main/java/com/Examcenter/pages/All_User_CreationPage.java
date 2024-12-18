package com.Examcenter.pages;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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

public class All_User_CreationPage extends ActionType
{
	private WebDriver driver;
	private Wait wait;
	public static String ControllerF_Name;
	public static String ControllerL_Name;
	public static String ProctorF_Name;
	public static String ProctorL_Name;
	public static String ExamTakerF_Name;
	public static String ExamTakerL_Name;
	static int Idtxt;
	static String Email;
	CommonPages cp=new CommonPages(Base.getDriver());

	/*
	 * Common Xpath
	 */	
	@FindBy(how=How.XPATH,using = "//mat-icon[text()=' settings ']") private WebElement Adminstrationbtn;
	@FindBy(how=How.XPATH,using = "//span[text()=' Create New Login ']") private WebElement createloginbtn;
	@FindBy(how=How.XPATH,using = "//span[text()=' Add New ']") private WebElement Addnewbtn;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[1]") private WebElement Emailtxt;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[2]") private WebElement Firstnametxt;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[3]") private WebElement Lastnametxt;
	@FindBy(how=How.XPATH,using = "(//input[@type='text'])[4]") private WebElement IDtxt;
	@FindBy(how=How.XPATH,using = "//mat-icon[text()='edit']") private WebElement Editbtn;
	@FindBy(how=How.XPATH,using = "//a[text()='Provisioning']") private WebElement provisioning;
	@FindBy(how=How.XPATH,using = "//span[text()=' Reset ']") private WebElement reset;
	@FindBy(how=How.XPATH,using = "//span[text()=' Reset Password ']") private WebElement resetbtn;
	@FindBy(how=How.XPATH,using = "//input[@data-placeholder='search here']") private WebElement searchtxt;
	@FindBy(how=How.XPATH,using = "//button[text()='Reset']") private WebElement yes;
	/*
	 * Controller Creation
	 */
	@FindBy(how=How.XPATH,using = "//a[text()='Controllers']") private WebElement Controllerbtn;
	@FindBy(how=How.XPATH,using = "//span[text()='Is Admin ']") private WebElement isAdminChkBox;
	/*
	 * Proctor Creation
	 */
	@FindBy(how=How.XPATH,using = "//div[text()='PROCTORS']") private WebElement Proctorbtn;
	@FindBy(how=How.XPATH,using = "//fp-textbox[@controlname='localStateID']/../div") private WebElement proctorLoc;
	@FindBy(how=How.XPATH,using = "//h2[text()='Add/Edit Proctor']") private WebElement proctor;
	/*
	 * Exam Taker Creation
	 */
	@FindBy(how=How.XPATH,using = "//div[text()='EXAM TAKERS']") private WebElement Examtakerbtn;
	@FindBy(how=How.XPATH,using = "//button[@aria-label='Open calendar']") private WebElement DOB;

	public All_User_CreationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}
	public void Addnewbtn()
	{
		wait.elementToBeClickable(Addnewbtn);
		int retries = 10;
		while (retries > 0) {
			try {
				Addnewbtn.click();
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException. Retrying...");
				retries--;
				wait.elementToBeClickable(Addnewbtn);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Addnewbtn);
			}
			
		}
	}
	public void Adminstarationbtn()
	{
		wait.elementToBeClickable(Adminstrationbtn);
		WebElement e1=Adminstrationbtn;
		Actions a=new Actions(driver);
		a.moveToElement(e1).click().build().perform();
	}
	public void Controllerbtn()
	{
		wait.elementToBeClickable(Controllerbtn);
		WebElement e=Controllerbtn;
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", e);
	}
	public void Create_Controller_User(String UserRole) {
		wait.elementToBeClickable(Emailtxt);
		wait.visibilityOf(Emailtxt);
		Email =randomEmailIdGenerator(UserRole).toLowerCase();
		Emailtxt.sendKeys(Email);
		ControllerF_Name = "FPKController".toLowerCase();
		Firstnametxt.sendKeys(ControllerF_Name);
		ControllerL_Name = String.valueOf(randomNumberGenerator());
		Lastnametxt.sendKeys(ControllerL_Name);
		Idtxt = randomNumberGenerator();
		IDtxt.sendKeys(String.valueOf(Idtxt));
	}
	public void isAdminChkBox()
	{
		isAdminChkBox.click();
	}

	public void Create_Examtaker_User(String UserRole,String Location) {
		wait.elementToBeClickable(Emailtxt);
		wait.visibilityOf(Emailtxt);
		Email =randomEmailIdGenerator(UserRole).toLowerCase();
		Emailtxt.sendKeys(Email);
		ExamTakerF_Name = "FPK"+UserRole.toLowerCase();
		Firstnametxt.sendKeys(ExamTakerF_Name);
		ExamTakerL_Name = String.valueOf(randomNumberGenerator());
		Lastnametxt.sendKeys(ExamTakerL_Name);
		Idtxt = randomNumberGenerator();
		IDtxt.sendKeys(String.valueOf(Idtxt));
		PLoc(Location);		
		//		DOBtxt(Yeartext, Monthtext, Datetext);
		cp.selectCurrentDate(DOB);

	}

	public void Create_proctor_User(String UserRole,String Location) {
		wait.elementToBeClickable(Emailtxt);
		wait.visibilityOf(Emailtxt);
		Email =randomEmailIdGenerator(UserRole).toLowerCase();
		Emailtxt.sendKeys(Email);
		ProctorF_Name = "FPK"+UserRole.toLowerCase();
		Firstnametxt.sendKeys(ProctorF_Name);
		ProctorL_Name = String.valueOf(randomNumberGenerator());
		Lastnametxt.sendKeys(ProctorL_Name);
		Idtxt = randomNumberGenerator();
		IDtxt.sendKeys(String.valueOf(Idtxt));
		PLoc(Location);
	}
	public void createloginbtn()
	{
		wait.elementToBeClickable(createloginbtn);
		createloginbtn.click();
	}
	public void Editbtn()
	{
		wait.elementToBeClickable(Editbtn);
		int retries = 10;
		while (retries > 0) {
			try {
				Editbtn.click();
				break; 
			} catch (ElementClickInterceptedException e) {
				System.out.println("Click intercepted. Retrying...");
				retries--;
				wait.elementToBeClickable(Editbtn);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Editbtn);
			}
		}
	}
	public void Examtakersbtn()
	{
		int retries = 10;
		while (retries > 0) {
			try {
				Examtakerbtn.click();
				break;
			} catch (ElementClickInterceptedException e) {
				System.out.println("Click intercepted. Retrying...");
				retries--;
				wait.elementToBeClickable(Examtakerbtn);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Examtakerbtn);
			}
		}
	}
	public void PLoc(String Location)
	{
		proctorLoc.click();
		WebElement e=driver.findElement(By.xpath("//span[text()='"+Location+"']"));
		wait.elementToBeClickable(e);
		JavascriptExecutor j=(JavascriptExecutor)getDriver();
		j.executeScript("arguments[0].click()", e);
	}
	public void proctor()
	{
		Actions a=new Actions(driver);
		a.moveToElement(proctor).click().build().perform();
	}
	public void Proctorbtn()
	{
		int retries = 10;
		while (retries > 0) {
			try {
				Proctorbtn.click();
				break; 
			} catch (ElementClickInterceptedException e) {
				System.out.println("Click intercepted. Retrying...");
				retries--;
				wait.elementToBeClickable(Proctorbtn);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Proctorbtn);
			}
		}
	}
	public void provisioning()
	{
		wait.elementToBeClickable(provisioning);
		JavascriptExecutor j=(JavascriptExecutor)getDriver();
		j.executeScript("arguments[0].click()", provisioning);
	}
	public void reset()
	{
		wait.elementToBeClickable(reset);
		reset.click();
	}
	public void resetbtn()
	{
		wait.elementToBeClickable(resetbtn);
		resetbtn.click();
	}
	public void savebtn()
	{
		cp.Save();
	}
	public void searchtxt(String L_Name, String F_Name) 
	{   
		wait.elementToBeClickable(searchtxt);
		cp.searchField(L_Name+" "+F_Name);
		WebElement EN=driver.findElement(By.xpath("//span[text()='"+L_Name+" "+F_Name+"']"));
		Actions a=new Actions(driver);
		a.moveToElement(EN).click().build().perform();
	}
	public void Yes()
	{
		wait.elementToBeClickable(yes);
		yes.click();

	}
	public void insertUsersData() throws Exception
	{
		String filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "ExcelFiles", "User_Details.xlsx").toString();
		cp.InsertmultipledataIntoExcel(filePath, getSheetEnv(), ControllerF_Name, ControllerL_Name,ProctorF_Name, ProctorL_Name, ExamTakerF_Name, ExamTakerL_Name);
	}

}
