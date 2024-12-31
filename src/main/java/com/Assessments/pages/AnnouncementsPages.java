package com.Assessments.pages;
import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.CommonPages;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnnouncementsPages extends ActionType {

	CommonPages cp=new CommonPages(Base.getDriver());
	static String announcementName;
	static	List<String> announcementNames = new ArrayList<>();
	static String sectionName;
	public WebDriver driver;
	private Wait wait;

	@FindBy(how=How.XPATH,using="//mat-icon[contains(text(),' school ')]")private WebElement LearningTab;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Assessment Center')]")private WebElement AssessmentcenterTab;
	@FindBy(how=How.XPATH,using="//span[text()='search here']")private WebElement searchHere;//search for community/classroom
	@FindBy(how=How.XPATH,using="(//div[@role='tab'])[4]")private WebElement AnnouncementTab;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='add ']")private WebElement ADdNewAnnouncement;
	@FindBy(how=How.XPATH,using="//input[@type='text']/parent::div")private WebElement TitleField;
	@FindBy(how=How.XPATH,using="//h3[text()='Create New Announcement']/following::p[@class='ck-placeholder']")private WebElement DescriptionField;
	@FindBy(how=How.XPATH,using="(//button[@aria-label='Open calendar'])[1]")private WebElement EventDate;
	@FindBy(how=How.XPATH,using="(//button[@aria-label='Open calendar'])[2]")private WebElement PublishDate;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='save']/parent::span")private WebElement SaveButton;
	@FindBy(how=How.XPATH,using="//span[text()='search here']/ancestor::div[1]")private WebElement searchhereAnnouncements;//searchfield for announcements
	@FindBy(how=How.XPATH,using="//mat-icon[text()='clear']")private WebElement ClearSearch;
	@FindBy(how=How.XPATH,using="//button[@aria-label='Next page']")private WebElement nextpage;
	@FindBy(how=How.XPATH,using="//button[@aria-label='Last page']")private WebElement lastPage;
	@FindBy(how=How.XPATH,using="//button[@aria-label='Previous page']")private WebElement PreviousPage;
	@FindBy(how=How.XPATH,using="//button[@aria-label='First page']")private WebElement FirstPage;
	@FindBy(how=How.XPATH,using="(//div[@role='tab'])[1]")private WebElement Hometab;
	@FindBy(how=How.XPATH,using="//a[text()='Assessment Center']/following::li[2]")private WebElement course;//to scroll page upto course 



	public WebElement getCommunityNameElement(String ClassroomName) {
		String xpath = "//span[(text()='"+ClassroomName+"')]/parent::div/parent::mat-card-content/preceding-sibling::mat-card-header/child::div/mat-card-title/child::span";
		return driver.findElement(By.xpath(xpath));
	}

	public void communityClick(String ClassroomName, String SectionName, String TLastName, String TFirstName)
	{
		cp.searchField(ClassroomName + "(" + SectionName + ")-"+ TLastName + " " + TFirstName);
		StaticWait(2);
		wait.visibilityOf(getCommunityNameElement(ClassroomName));
		wait.elementToBeClickable(getCommunityNameElement(ClassroomName));
		Actions a=new Actions(driver);
		a.moveToElement(getCommunityNameElement(ClassroomName)).click().build().perform();
		StaticWait(2);
	}

	public AnnouncementsPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}

	public void ClickOnLearningaAndAssessmentCenter() {
		wait.elementToBeClickable(LearningTab);
		LearningTab.click();

		wait.elementToBeClickable(AssessmentcenterTab);
		AssessmentcenterTab.click();
	}

	public void ClickOnAnnouncementTab() {
		wait.elementToBeClickable(AnnouncementTab);
		wait.visibilityOf(AnnouncementTab);
		AnnouncementTab.click();
	}

	public void ClickOnAddNewAnnouncement() {

		for (int i = 0; i < 4; i++) {
			try {

				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOf(ADdNewAnnouncement));
				wait.until(ExpectedConditions.elementToBeClickable(ADdNewAnnouncement));
				ADdNewAnnouncement.click();
				StaticWait(1);

				wait.until(ExpectedConditions.visibilityOf(TitleField));
				wait.until(ExpectedConditions.elementToBeClickable(TitleField));
				TitleField.click();

				announcementName = "Announcement" + randomNumberGenerator(); 
				ExtentCucumberAdapter.addTestStepLog("Announcement Name: " + announcementName);
				announcementNames.add(announcementName);

				Actions actions = new Actions(driver);
				actions.moveToElement(TitleField).click().sendKeys(announcementName).perform();
				StaticWait(1);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", DescriptionField);
				Actions actions1 = new Actions(driver);
				actions1.moveToElement(DescriptionField).click().sendKeys(generateRandomString()).perform();

				js.executeScript("arguments[0].scrollIntoView(true);", course);

				StaticWait(1);
				wait.until(ExpectedConditions.elementToBeClickable(EventDate));
				wait.until(ExpectedConditions.visibilityOf(EventDate));
				StaticWait(1);
				cp.getRandomDate(EventDate);


				wait.until(ExpectedConditions.elementToBeClickable(PublishDate));
				StaticWait(1);
				wait.until(ExpectedConditions.visibilityOf(PublishDate));
				cp.selectCurrentDate(PublishDate);

				wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
				SaveButton.click();
				StaticWait(2);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Element click intercepted, retrying...");
				StaticWait(1);
				i--; 
			} catch (Exception e) {
				System.out.println("Error while adding new announcement: " + e.getMessage());
			}}}


	public void AnnouncementsSearch() {

		String an=announcementNames.get(0);
		wait.elementToBeClickable(searchhereAnnouncements);
		wait.visibilityOf(searchhereAnnouncements);
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(searchhereAnnouncements).click().sendKeys(an).perform();
		StaticWait(2);
		wait.elementToBeClickable(ClearSearch);
		wait.visibilityOf(ClearSearch);
		ClearSearch.click();
		StaticWait(2);
	}


	public void PageNation() throws AWTException {

		cp.scrollWithRobot();
		cp.scrollWithRobot();
		StaticWait(2);
		cp.Screensize();
		StaticWait(2);
		wait.elementToBeClickable(nextpage);
		wait.visibilityOf(nextpage);
		//		Dimension d=new Dimension(1920,1080);
		//		driver.manage().window().setSize(d);
		nextpage.click();
		StaticWait(2);

		//		wait.elementToBeClickable(lastPage);
		//		wait.visibilityOf(lastPage);
		//		lastPage.click();
		//		StaticWait(2);

		wait.elementToBeClickable(PreviousPage);
		wait.visibilityOf(PreviousPage);
		PreviousPage.click();
		StaticWait(2);}
	//		cp.scrollWithRobot();
	//
	//		wait.elementToBeClickable(FirstPage);
	//		wait.visibilityOf(FirstPage);
	//		FirstPage.click();
	//		StaticWait(2);


	public void ClickOnHomeTab() {
		wait.elementToBeClickable(Hometab);
		wait.visibilityOf(Hometab);
		Hometab.click();
	}

	public void ClickOnAddAndSave() {
		wait.elementToBeClickable(ADdNewAnnouncement);
		wait.visibilityOf(ADdNewAnnouncement);
		ADdNewAnnouncement.click();
		StaticWait(1);
		wait.elementToBeClickable(SaveButton);
		wait.visibilityOf(SaveButton);
		SaveButton.click();

		//		try {
		//			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		//			wait.until(ExpectedConditions.alertIsPresent());  
		//			Alert alert = driver.switchTo().alert(); 
		//			String popupMessage = alert.getText(); 
		//			System.out.println("-------------Popup Message:-------- " + popupMessage);
		//		} catch (NoAlertPresentException e) {
		//			System.out.println("No alert present: " + e.getMessage());
		//		}


	}
	/*
	 * Student side verification
	 */

	public void ClickOnAnnouncementFromHomeTab() throws AWTException {
		//List<String> announcementNames = new ArrayList<>();
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



