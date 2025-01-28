package com.LearningTree.pages;

import com.Utils.ActionType;
import com.Utils.Base;

import com.Utils.Wait;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import org.openqa.selenium.support.How;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LTAnnouncements_pages extends ActionType {

	CommonPages cp=new CommonPages(Base.getDriver());

	static String announcementName;
	static	List<String> announcementNames = new ArrayList<>();

	public WebDriver driver;
	private Wait wait;


	@FindBy(how = How.XPATH,using = "//span[text()='Learning']")private WebElement LearningTab;
	@FindBy(how = How.XPATH,using = "//a[text()='Courses']")private WebElement CoursesTab;
	@FindBy(how=How.XPATH,using="//*[text()='search here']/parent::label/parent::span/preceding-sibling::input")private WebElement searchHere;
	@FindBy(how=How.XPATH,using="//*[local-name()='svg' and @matTooltip='Announcements']")private WebElement AnnouncementTab;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='add ']")private WebElement AddNewAnnouncement;
	@FindBy(how=How.XPATH,using="//input[@type='text']/parent::div")private WebElement TitleField;
	@FindBy(how=How.XPATH,using="//h3[text()='Create New Announcement']/following::p[@class='ck-placeholder']")private WebElement DescriptionField;
	@FindBy(how=How.XPATH,using="(//button[@aria-label='Open calendar'])[1]")private WebElement EventDate;
	@FindBy(how=How.XPATH,using="(//button[@aria-label='Open calendar'])[2]")private WebElement PublishDate;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='save']/parent::span")private WebElement SaveButton;
	@FindBy(how=How.XPATH,using="//span[text()='search here']/ancestor::div[1]")private WebElement searchhereAnnouncements;//searchfield for announcements
	@FindBy(how=How.XPATH,using="//mat-icon[text()='clear']")private WebElement ClearSearch;
	@FindBy(how=How.XPATH,using="//button[@aria-label='Next page']/child::span/child::*[local-name()='svg']")private WebElement nextpage;
	@FindBy(how=How.XPATH,using="//button[@aria-label='Last page']")private WebElement lastPage;
	@FindBy(how=How.XPATH,using="//button[@aria-label='Previous page']")private WebElement PreviousPage;
	@FindBy(how=How.XPATH,using="//button[@aria-label='First page']")private WebElement FirstPage;
	@FindBy(how=How.XPATH,using="(//div[@role='tab'])[1]")private WebElement Hometab;


	@FindBy(how = How.XPATH,using = "//a[text()='Learning Tree']")private WebElement LearningTree_Tab;

	@FindBy(how=How.XPATH,using="(//a[text()='Courses']/following::li[2]")private WebElement course;//to scroll page upto course 


	public  LTAnnouncements_pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}




	public void LTAnnouncementTab() {
		wait.elementToBeClickable(AnnouncementTab);
		wait.visibilityOf(AnnouncementTab);
		AnnouncementTab.click();
	}

	public void AddNewAnnouncement_LT() {

		for (int i = 0; i < 15; i++) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;

				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(AddNewAnnouncement));
				js.executeScript("arguments[0].scrollIntoView(true);", AddNewAnnouncement);
				wait.until(ExpectedConditions.elementToBeClickable(AddNewAnnouncement));
				StaticWait(1);
				AddNewAnnouncement.click();
				

				wait.until(ExpectedConditions.visibilityOf(TitleField));
				wait.until(ExpectedConditions.elementToBeClickable(TitleField));
				TitleField.click();

				announcementName = "Announcement" + randomNumberGenerator(); 
				//ExtentCucumberAdapter.addTestStepLog("Announcement Name: " + announcementName);
				announcementNames.add(announcementName);

				Actions actions = new Actions(driver);
				actions.moveToElement(TitleField).click().sendKeys(announcementName).perform();
				StaticWait(1);

//				wait.until(ExpectedConditions.elementToBeClickable(EventDate));
//				wait.until(ExpectedConditions.visibilityOf(EventDate));
//				cp.getRandomDate(EventDate);
//
//				wait.until(ExpectedConditions.elementToBeClickable(PublishDate));
//				wait.until(ExpectedConditions.visibilityOf(PublishDate));
//				cp.selectCurrentDate(PublishDate);

				StaticWait(1);
				
				js.executeScript("arguments[0].scrollIntoView(true);", DescriptionField);
				Actions actions1 = new Actions(driver);
				actions1.moveToElement(DescriptionField).click().perform();
				DescriptionField.sendKeys(generateRandomString());

				//				js.executeScript("arguments[0].scrollIntoView(true);", course);


				js.executeScript("arguments[0].scrollIntoView(true);", SaveButton);
				js.executeScript("arguments[0].click();", SaveButton);
				//				wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
				//				SaveButton.click();
				StaticWait(1);

			} catch (ElementClickInterceptedException e) {
				System.out.println("Element click intercepted, retrying...");
				StaticWait(1);
				i--; 
			} 
			//			catch (Exception e) {
			//				System.out.println("Error while adding new announcement: " + e.getMessage());
			//			}
		}}


	public void Announcement_Search() {

		String an=announcementNames.get(0);
		wait.elementToBeClickable(searchhereAnnouncements);
		wait.visibilityOf(searchhereAnnouncements);
		Actions actions2 = new Actions(driver);
		cp.searchField(an);
//		StaticWait(1);
//		wait.elementToBeClickable(ClearSearch);
//		wait.visibilityOf(ClearSearch);
//		ClearSearch.click();
//		StaticWait(1);
	}

	public void PagiNation() throws AWTException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		StaticWait(1);
		wait.elementToBeClickable(nextpage);
		wait.visibilityOf(nextpage);
		js.executeScript("arguments[0].scrollIntoView(true);", nextpage);
		Actions a=new Actions(driver);
		if(nextpage.isEnabled())
		{
			
			a.moveToElement(nextpage).build().perform();
			a.click().build().perform();
			StaticWait(1);
		}
		else
		{
			System.out.println("Next page is in Disabled Position..!!");
		}
//		wait.elementToBeClickable(lastPage);
//		wait.visibilityOf(lastPage);
//		lastPage.click();
//		StaticWait(2);
//		wait.elementToBeClickable(PreviousPage);
//		wait.visibilityOf(PreviousPage);
//		a.moveToElement(PreviousPage).build().perform();
//		js.executeScript("arguments[0].click();", PreviousPage);
//		PreviousPage.click();
//		wait.elementToBeClickable(FirstPage);
//		wait.visibilityOf(FirstPage);
//		FirstPage.click();
	}

	
	/*
	 * Student side verification
	 */

	public void click_on_LearningtreeTab()
	{ 
		if(LearningTree_Tab.isDisplayed())
		{
			wait.elementToBeClickable(LearningTree_Tab);
			LearningTree_Tab.click();
		}
		else
		{
			wait.elementToBeClickable(LearningTab);
			LearningTab.click();
			wait.elementToBeClickable(LearningTree_Tab);
			LearningTree_Tab.click();
		}
	}
	public void StudentAnnouncementFromHomeTab() throws AWTException {
		List<String> announcementNames = new ArrayList<>();
		String Aname=announcementNames.get(1);
		String an1=Aname;
		System.out.println("Announcement:" + an1);
		WebElement announcementElement = driver.findElement(By.xpath("//a[contains(text(),'" + an1 + "')]"));
		//		Actions a=new Actions(driver);
		//		a.moveToElement(announcementElement).click().perform(); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", announcementElement);

		//		if (announcementElement.isDisplayed()) {
		//			Actions a=new Actions(driver);
		//			a.moveToElement(announcementElement).click().perform();
		//		} else {
		//			JavascriptExecutor js = (JavascriptExecutor) driver;
		//			js.executeScript("arguments[0].click();", announcementElement);
		//		}
	}
}