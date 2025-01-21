package com.LearningTree.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Provide_Score_For_LT_ActivitiesPage extends ActionType
{
	private WebDriver driver;
	private Wait wait;
	CommonPages cp=new CommonPages(Base.getDriver());

	@FindBy(how = How.XPATH,using = "//button[@mattooltip='Activites To Grade']")private WebElement Overal_Speed_Grader_btn;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Communities')]")private WebElement All_CommunitiesDropDown;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Activity Types')]")private WebElement All_Activity_TypesDropDown;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Activities')]")private WebElement All_ActivitiesDropDown;
	@FindBy(how = How.XPATH,using = "//mat-label[contains(text(), 'All Members')]")private WebElement All_MembersDropDown;
	@FindBy(how = How.XPATH,using = "(//mat-icon[text()=' score'])[1]")private WebElement Score;
	@FindBy(how = How.XPATH,using = "(//mat-icon[text()='close'])[2]")private WebElement closeicon;
	@FindBy(how = How.XPATH,using = "(//input[@type='number'])[2]")private WebElement Provide_Score;
	@FindBy(how = How.XPATH,using = "//*[contains(text(), 'Candidate Response')]/following::div[3]/div/following::span/span/descendant::input")private WebElement Provide_Score1;
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='save']")private WebElement Save_Score;
	@FindBy(how = How.XPATH,using = "//div[@class='activities_name_icon']")private List<WebElement> A_Score;
	@FindBy(how = How.XPATH,using = "//span[text()=' Award Badge ']")private  WebElement Award_Badge;
	@FindBy(how = How.XPATH,using = "//h3[text()='Activities To Grade ']/following-sibling::button")private  WebElement Activities_To_Grade_Close_btn;
	@FindBy(how = How.XPATH,using = "//span[text()='Progress']")private WebElement Progress;
	@FindBy(how = How.XPATH,using = "//span[text()='Details']")private WebElement Details;
	@FindBy(how = How.XPATH,using = "//div[@role='textbox']")private WebElement Provide_Feedback;
	@FindBy(how = How.XPATH,using = "//span[text()='Submit Scoring']")private WebElement Submit_score;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Sub-Topic')]/parent::span/parent::div/parent::div/parent::div/following::div/descendant::span[@class='assessment_icon_wrapper']/parent::div/parent::div/following-sibling::div/descendant::mat-icon[text()='more_vert']")
	private WebElement SubTopic_Activities_ellipses;
	@FindBy(how = How.XPATH,using = "(//mat-toolbar[@id='appHeader']/child::div[@fxlayoutalign='space-between']/child::div)[1]")private WebElement Activity_Title_Name;
	@FindBy(how=How.XPATH,using="//div[text()=' All ']/parent::div")private WebElement All;
	@FindBy(how=How.XPATH,using="(//mat-icon[text()=' chevron_right '])[1]")private WebElement Topic;
	@FindBy(how=How.XPATH,using="//mat-icon[text()=' chevron_right ']")private WebElement SubTopic;

	public Provide_Score_For_LT_ActivitiesPage(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}
	public void click_on_Overal_Speed_Grader()
	{
		wait.elementToBeClickable(Overal_Speed_Grader_btn);
		Overal_Speed_Grader_btn.click();
		StaticWait(1);
	}
	public void select_Community(String CourseName)
	{
		int attempts = 0;
		while (attempts < 3) {
			try {
				cp.FPdropdown(All_CommunitiesDropDown, CourseName);
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);	       
			}
		}		
	}
	public void all_Activity_TypesDropDown(String Activity_Type)
	{
		int attempts = 0;
		while (attempts < 3) {
			try {
				cp.FPdropdown(All_Activity_TypesDropDown, Activity_Type);
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);	       
			}
		}			
	}
	public void all_ActivitiesDropDown()
	{
		int attempts = 0;
		while (attempts < 3) {
			try {
				cp.FPdropdown(All_ActivitiesDropDown, "All Activities");
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);	       
			}
		}
	}
	public void All_MembersDropDown(String LastName,String FirstName)
	{
		String StudentName = LastName + " " + FirstName;
		int attempts = 0;
		while (attempts < 3) {
			try {
				cp.FPdropdown(All_MembersDropDown, StudentName);
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);	       
			}
		}	
	}
	public void Provide_Score_Overal_Speed_Grader_Level() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Dynamic wait
		wait.until(ExpectedConditions.elementToBeClickable(All_Activity_TypesDropDown));
		Actions actions = new Actions(driver);
		actions.moveToElement(All_Activity_TypesDropDown).click().build().perform();
		StaticWait(1);
		List<WebElement> Activity_Type = driver.findElements(By.xpath("//mat-option[@role='option']/child::span"));
		if (Activity_Type.isEmpty()) {
			System.out.println("No activity types found!");
			return; 
		}
		int count = Activity_Type.size();
		System.out.println("Found " + count + " activity types.");
		driver.findElement(By.xpath("//span[text()='All Activity Types']")).click();

		for (int i = 1; i < count; i++) 
		{ 
			StaticWait(1);
			WebElement Act_lookup = driver.findElement(By.xpath("(//th[@mat-sort-header='GoalName']/ancestor::table/parent::div/preceding-sibling::div/descendant::mat-select/child::div/child::div/span)[2]"));
			js.executeScript("arguments[0].click();", Act_lookup);
			List<WebElement> Activity_Type1 = driver.findElements(By.xpath("//mat-option[@role='option']/child::span"));
			int attempts = 0;
			while (attempts < 5) 
			{
				try
				{
					StaticWait(1);
					WebElement Acti = Activity_Type1.get(i);
					System.out.println("Clicked on: " + Acti.getText());
					js.executeScript("arguments[0].click();", Acti);
					break;
				} 
				catch (StaleElementReferenceException e) 
				{
					attempts++;
					System.out.println("------StaleElementReferenceException, retrying...");
				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(Score));
			js.executeScript("arguments[0].click();", Score);
			String Activity_Title = Activity_Title_Name.getText();
			
			 if (Activity_Title.toLowerCase().contains("assessment".toLowerCase()))
			{
				Provide_the_Score_for_Assessment();
				System.out.println("Provide Score for Assessment Activity");
			}
			 else if (Activity_Title.toLowerCase().contains("assignment".toLowerCase()) || Activity_Title.toLowerCase().contains("discussion".toLowerCase())) {
				Provide_the_Score_for_Assignment_and_Discussion();
				System.out.println("Provide Score for " + (Activity_Title.toLowerCase().contains("assignment".toLowerCase()) ? "Assignment" : "Discussion") + " Activity");
			}
		}
	}
	public void close_the_Overal_Speed_Grader_Screen()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Activities_To_Grade_Close_btn);
	}
	public void activities_to_Garde()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int count = A_Score.size()-4; 
		System.out.println("count: "+count);
		System.out.println("Total Activities for Scoring: " + count);
		for (int i = 0; i < count; i++) {
			StaticWait(1);
			js.executeScript("arguments[0].click();", A_Score.get(i));
			StaticWait(1);
			String Activity_Title = Activity_Title_Name.getText();
			if (Activity_Title.toLowerCase().contains("assignment".toLowerCase()) || Activity_Title.toLowerCase().contains("discussion".toLowerCase())) {
				Provide_the_Score_for_Assignment_and_Discussion();
				System.out.println("Provide Score for " + (Activity_Title.toLowerCase().contains("assignment".toLowerCase()) ? "Assignment" : "Discussion") + " Activity");
			}
			else if (Activity_Title.toLowerCase().contains("assessment".toLowerCase()))
			{
				Provide_the_Score_for_Assessment();
				System.out.println("Provide Score for Assessment Activity");
			}
			if(i==count)
			{
				break;
			}
		}
		driver.navigate().refresh();
	}

	public void Provide_the_Score_in_Activity_Progress_screen(String SLastname)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		All.click();
		StaticWait(1);
		js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");
		js.executeScript("arguments[0].scrollIntoView(true);", Topic);
		js.executeScript("arguments[0].click();", Topic);
		StaticWait(1);
		js.executeScript("arguments[0].scrollIntoView(true);", SubTopic);
		js.executeScript("arguments[0].click();", SubTopic);
		StaticWait(1);
		List<WebElement> Need_toProvide_Score_Activities = driver.findElements(By.xpath("//div[@class='learning__details__nested-tree-node']/descendant::span[text()='1']/ancestor::div[@class='learning__details__nested-tree-node']/following-sibling::div/descendant::mat-icon[text()='more_vert']"));
		int count1 = Need_toProvide_Score_Activities.size();    
		System.out.println("Total Activities for Scoring in Activity Progress screen: " + count1);
		for (int i = 0; i < count1; i++) 
		{	
			StaticWait(1);	
			List<WebElement> Need_toProvide_Score_Activities1 = driver.findElements(By.xpath("//div[@class='learning__details__nested-tree-node']/descendant::span[text()='1']/ancestor::div[@class='learning__details__nested-tree-node']/following-sibling::div/descendant::mat-icon[text()='more_vert']"));
			int j = Need_toProvide_Score_Activities1.size();
			int attempts = 10;
			while (attempts > 0) 
			{
				try
				{
					WebElement ellipse = Need_toProvide_Score_Activities1.get(j-1);					
					wait.elementToBeClickable(ellipse);
					js.executeScript("arguments[0].click();", ellipse);
					break;
				} 
				catch (StaleElementReferenceException e) 
				{
					System.out.println("------StaleElementReferenceException, retrying...");
					StaticWait(1);
					attempts--;		
				}
			}
			wait.elementToBeClickable(Progress);
			wait.visibilityOf(Progress);
			Progress.click();

			WebElement Student_ellipse = driver.findElement(By.xpath("//h5[contains(normalize-space(text()), '"+SLastname+"')]/parent::div/parent::div/parent::div/descendant::mat-icon")); 
			Student_ellipse.click();
			Details.click();
			StaticWait(1);
			String Activity_Title = Activity_Title_Name.getText();
			if (Activity_Title.toLowerCase().contains("assignment".toLowerCase()) || Activity_Title.toLowerCase().contains("discussion".toLowerCase())) {
				Provide_the_Score_for_Assignment_and_Discussion();
				System.out.println("Provide Score for " + (Activity_Title.toLowerCase().contains("assignment".toLowerCase()) ? "Assignment" : "Discussion") + " Activity");
			}
			else if (Activity_Title.toLowerCase().contains("assessment".toLowerCase()))
			{
				Provide_the_Score_for_Assessment();
				System.out.println("Provide Score for Assessment Activity");
			}
			WebElement e= driver.findElement(By.xpath("//h3[text()='Activity Progress']/parent::div/child::button"));
			js.executeScript("arguments[0].click();", e);
			StaticWait(1);
			if(j==1)
			{
				break;
			}
		}    

	}
	public void Provide_the_Score_for_Assignment_and_Discussion()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Provide_Score.sendKeys("70");
		js.executeScript("arguments[0].click();", Save_Score);
		int attempts = 0;
		while (attempts < 3) {
			try {
				Award_Badge.click();
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);	       
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()=' Credit Awarded']")));
		StaticWait(1);
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-icon[text()='keyboard_arrow_left']/ancestor::button/following-sibling::button[2]")));
		js.executeScript("arguments[0].click();", e);
		StaticWait(1);
	}
	public void Provide_the_Score_for_Assessment()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		StaticWait(1);
		driver.switchTo().frame(0);
		Provide_Score1.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		Provide_Score1.sendKeys(Keys.chord(Keys.CONTROL,"x"));
		Provide_Score1.sendKeys("4");
		String randomString = generateRandomString();
		Provide_Feedback.sendKeys(randomString);
		StaticWait(1);
		Submit_score.click();
		driver.switchTo().defaultContent();
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-icon[text()='keyboard_arrow_left']/ancestor::button/following-sibling::button[2]")));
		js.executeScript("arguments[0].click();", e);
		StaticWait(1);
	}
}
