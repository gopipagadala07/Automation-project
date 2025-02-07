package com.LearningTree.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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
import com.Utils.CommonPages;
import com.Utils.Wait;

public class Student_Activity_Submit_pages extends ActionType {

	private WebDriver driver;
	private Wait wait;
	public String LearningTree_Name;

	CommonPages cp=new CommonPages(Base.getDriver());

	@FindBy(how = How.XPATH,using = "//span[text()='Learning']")private WebElement LearningTab;
	@FindBy(how = How.XPATH,using = "//a[text()='Learning Tree']")private WebElement LearningTree_Tab;
	@FindBy(how = How.XPATH,using = "//input[@type='search']")private WebElement SearchHere;
	@FindBy(how = How.XPATH,using = "//span[@mattooltip='Learning']")private WebElement Learning;
	@FindBy(how = How.XPATH,using = "//input[@type='search']")private WebElement search;	
	@FindBy(how=How.XPATH,using="//div[text()=' All ']/parent::div")private WebElement All;
	@FindBy(how=How.XPATH,using="(//mat-icon[text()=' chevron_right '])[1]")private WebElement Topic;
	@FindBy(how=How.XPATH,using="//mat-icon[text()=' chevron_right ']")private WebElement SubTopic;
	@FindBy(how=How.XPATH,using="//a[text()='Courses']")private WebElement ScrollTop;	
	@FindBy(how=How.XPATH,using="//div[text()='Assignment']")private WebElement Assignment_Tab;
	@FindBy(how=How.XPATH,using="//div[text()='Discussion']")private WebElement Discussion_Tab;
	@FindBy(how=How.XPATH,using="//div[text()='Assessment']")private WebElement Assessment_tab;
	@FindBy(how=How.XPATH,using="//div[text()='Resources']")private WebElement Resources_tab;
	@FindBy(how=How.XPATH,using="//div[text()='Details']")private WebElement Details_tab;
	@FindBy(how=How.XPATH,using="//div[text()='Content']")private WebElement Content_tab;	
	@FindBy(how=How.XPATH,using="//div[text()='Notes']")private WebElement Notes_tab;
	//Launching Discussion
	@FindBy(how=How.XPATH,using="//span[text()=' New Post ']")private WebElement NewPost;
	@FindBy(how=How.XPATH,using="//div[@role='textbox']")private WebElement TypehereText;
	@FindBy(how=How.XPATH,using="//span[text()=' Post ']")private WebElement Postbutton;
	@FindBy(how=How.XPATH,using="//span[text()=' Reply ']")private WebElement Replybutton;
	@FindBy(how=How.XPATH,using="//span[text()='Submit Discussion']")private WebElement SubmitDiscussion;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='close']/parent::span")private WebElement CloseIcon;
	//Launching Assignment
	@FindBy(how=How.XPATH,using="//span[text()='Submit Assignment']")private WebElement SubmitAssignment;
	//Launching Assessment
	@FindBy(how=How.XPATH,using="//span[text()=' Begin Test ']")private WebElement BeginTest;
	@FindBy(how=How.XPATH,using="//iframe[@class='iframe-styling ng-star-inserted']")private WebElement iFrame;
	@FindBy(how=How.XPATH,using="(//div[@class=\"mdc-radio\"])[1]")private WebElement McqAnswer;
	@FindBy(how=How.XPATH,using="//input[@type='text']")private WebElement FillAndExtended;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='chevron_right']")private WebElement NextQ;
	@FindBy(how=How.XPATH,using="//span[text()='Finish']")private WebElement Finish;
	@FindBy(how=How.XPATH,using="//span[text()='Submit']")private WebElement Submit;	
	//Launching Resources
	@FindBy(how=How.XPATH,using="//span[text()='Launch']")private WebElement Launchbutton;	
	//Launching Externaltool
	@FindBy(how=How.XPATH,using="//button[@class='m-l-5 ng-star-inserted']")private WebElement Deeplinkingbutton;

	public Student_Activity_Submit_pages(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}
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
	public void search_Course(String LearningTree_Name) 
	{
		search.sendKeys(LearningTree_Name);
		search.sendKeys(Keys.BACK_SPACE);
		StaticWait(1);
		search.sendKeys(Keys.CONTROL + "z");
	}	
	public void click_on_Course(String LearningTree_Name)
	{
		int attempts = 0;
		while (attempts < 3) {
			try {

				WebElement community=driver.findElement(By.xpath("//b[text()='"+LearningTree_Name+"']"));
				community.click();
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);	       
			}
		}
	}
	public void learningTab()
	{
		try {
			wait.elementToBeClickable(Learning);
			Learning.click();
			StaticWait(1);
			All.click();
			JavascriptExecutor s = (JavascriptExecutor) driver;
			StaticWait(1);
			s.executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement topic= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//mat-icon[text()=' chevron_right '])[1]")));
			s.executeScript("arguments[0].scrollIntoView(true);", topic);
			s.executeScript("arguments[0].click();", topic);
			StaticWait(1);
			WebElement subtopic= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//mat-icon[text()=' chevron_right ']")));
			s.executeScript("arguments[0].scrollIntoView(true);", subtopic);
			s.executeScript("arguments[0].click();", subtopic);
			StaticWait(1);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void performActivities()
	{
		JavascriptExecutor s = (JavascriptExecutor) driver;

		List<WebElement> matIcons = driver.findElements(By.xpath("//mat-icon[text()='launch']"));
		System.out.println("Total Activities Found: " + matIcons.size());
		for (int targetIndex = 0; targetIndex < matIcons.size(); targetIndex++) {
			int retry = 0;
			int maxRetry = 5;
			while (retry < maxRetry) {
				matIcons = driver.findElements(By.xpath("//mat-icon[text()='launch']"));
				WebElement currentIcon = matIcons.get(targetIndex);
				StaticWait(1);
				int retries = 10;
				while (retries > 0) {
					try {
						s.executeScript("arguments[0].scrollIntoView(true);", currentIcon);

						s.executeScript("arguments[0].click();", currentIcon);	
						break;
					} catch (StaleElementReferenceException e) {

						System.out.println("StaleElementReferenceException. Retrying...");
						StaticWait(1);
						retries--;
					}	
				}

				StaticWait(1);	
				String Activity_Title = driver.findElement(By.xpath("//mat-toolbar[@id='appHeader']/child::div[@fxlayoutalign='space-between']/child::div")).getText();
				StaticWait(1);			                
				System.out.println("Activity Title : "+targetIndex+Activity_Title);		                

				if(Activity_Title.toLowerCase().contains("assessment".toLowerCase()))
				{
					performAssessmentActivity();
				}
				else if(Activity_Title.toLowerCase().contains("discussion".toLowerCase()))
				{
					performDiscussionActivity();
				}
				else if(Activity_Title.toLowerCase().contains("assignment".toLowerCase()))
				{
					performAssignmentActivity();
				}
				else if(Activity_Title.toLowerCase().contains("resources".toLowerCase()))
				{
					performResourcesActivity();
				}

				else if(Activity_Title.toLowerCase().contains("Content".toLowerCase()))
				{
					performContentActivity();
				}
				//							 else if(Activity_Title.toLowerCase().contains("ExternalTool".toLowerCase()))
				//								{
				//									 performExternalToolActivity();
				//								}
				//						
				//							 else if(Activity_Title.toLowerCase().contains("LTI Content Provider".toLowerCase()))
				//								{
				//									 performLTI_Content_Provider_Activity();
				//								}
				else if(Activity_Title.toLowerCase().contains("Epublication".toLowerCase()))
				{
					performEpublicationActivity();
				}

				StaticWait(1);
				break;
			}
			if (retry == maxRetry) {
				System.out.println("Failed to process Activity icon at index: " + targetIndex + " after " + maxRetry + " retries.");
			}
		}
	}


	public void CloseIcon()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", CloseIcon);
		js.executeScript("arguments[0].click();", CloseIcon); 
	}

	public void performAssignmentActivity() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Performing Assignment activity...");
		wait.elementToBeClickable(Assignment_Tab);

		Assignment_Tab.click();
		wait.elementToBeClickable(TypehereText);

		js.executeScript("arguments[0].click();", Assignment_Tab);

		wait.elementToBeClickable(TypehereText);
		TypehereText.sendKeys(generateRandomString());

		wait.elementToBeClickable(SubmitAssignment);
		js.executeScript("arguments[0].scrollIntoView(true);", SubmitAssignment);
		js.executeScript("arguments[0].click();", SubmitAssignment);
		StaticWait(1);
		js.executeScript("arguments[0].click();", Notes_tab);
		StaticWait(1);
		TypehereText.sendKeys("StudentNotesforAssignment"+randomNumberGenerator());
		cp.Save();

		CloseIcon();
		StaticWait(1);
		System.out.println("Assignment completed successfully.");
	}
	public void performDiscussionActivity() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Performing Discussion activity...");

		Discussion_Tab.click();
		//js.executeScript("arguments[0].click();", NewPost);
		NewPost.click();

		wait.elementToBeClickable(Discussion_Tab);
		js.executeScript("arguments[0].click();", Discussion_Tab);
		WebElement Newpost = driver.findElement(By.xpath("//mat-icon[text()='add']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(Newpost).click().perform();
		TypehereText.sendKeys(generateRandomString());
		js.executeScript("arguments[0].scrollIntoView(true);", Postbutton);
		js.executeScript("arguments[0].click();", Postbutton);
		js.executeScript("arguments[0].scrollIntoView(true);", Replybutton);
		js.executeScript("arguments[0].click();", Replybutton);
		TypehereText.sendKeys(generateRandomString());
		js.executeScript("arguments[0].scrollIntoView(true);", Postbutton);
		Postbutton.click();
		StaticWait(1);		
		js.executeScript("arguments[0].scrollIntoView(true);", SubmitDiscussion);
		js.executeScript("arguments[0].click();", SubmitDiscussion);
		js.executeScript("arguments[0].click();", Notes_tab);
		StaticWait(1);
		TypehereText.sendKeys("StudentNotesforDiscussion"+randomNumberGenerator());
		cp.Save();

		CloseIcon();
		StaticWait(2);
		System.out.println("Discussion completed successfully.");
	}
	public void performAssessmentActivity() {
		System.out.println("Performing Assessment activity...");

		driver.switchTo().frame(0);
		StaticWait(2);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement beginTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Begin Test')]")));
		js.executeScript("arguments[0].click();", beginTest);	
		StaticWait(2);

		List<WebElement> questions = driver.findElements(By.xpath("//div[@id='navigationSideMenu']/ul/li/div/button"));
		int numberOfQuestions = questions.size();

		for (int i = 0; i < numberOfQuestions; i++) {
			int questionAttempts = 0;
			int questionMaxAttempts = 5;

			while (questionAttempts < questionMaxAttempts) {
				try {
					WebElement question = driver.findElement(By.xpath("//*[contains(@responseidentifier, 'RESPONSE')]"));
					String tagName = question.getTagName();
					StaticWait(1);

					if (tagName.equalsIgnoreCase("choiceinteraction")) {
						WebElement choiceValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mdc-radio'])[2]")));
						new Actions(driver).moveToElement(choiceValue).click().perform();
						StaticWait(1);
					} else if (tagName.equalsIgnoreCase("extendedtextinteraction")) {
						WebElement extendedValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='ck-placeholder']")));
						StaticWait(1);
						extendedValue.sendKeys(generateRandomString());
						StaticWait(1);
					} else if (tagName.equalsIgnoreCase("textentryinteraction")) {
						WebElement fillInTheBlankValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEditorInteraction")));
						fillInTheBlankValue.click();
						fillInTheBlankValue.sendKeys(generateRandomString());
					}
					WebElement nextBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@mattooltip='Next']")));
					js.executeScript("arguments[0].click();", nextBtn);
					StaticWait(2);
					break;
				} catch (StaleElementReferenceException e) {
					System.out.println("Attempt " + (questionAttempts + 1) + " - StaleElementReferenceException encountered. Retrying...");
					questionAttempts++;
				}
			}
		}

		WebElement finish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Finish']")));
		js.executeScript("arguments[0].click();", finish);
		StaticWait(1);

		WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Submit']")));
		js.executeScript("arguments[0].click();", submit);
		StaticWait(2);
		driver.switchTo().defaultContent();
		WebElement closeAfterSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[@mattooltip='Close']")));
		js.executeScript("arguments[0].click();", closeAfterSubmit);
		StaticWait(1);
		System.out.println("Assessment completed successfully.");

	}
	public void performResourcesActivity() {
		System.out.println("Performing Resources activity...");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Resources_tab)).click();

		wait.until(ExpectedConditions.elementToBeClickable(Launchbutton)).click();  
		String originalWindow = driver.getWindowHandle(); 
		Set<String> allWindows = driver.getWindowHandles();
		StaticWait(1);
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		driver.close();
		driver.switchTo().window(originalWindow);	
		StaticWait(1);


		StaticWait(2);
		Notes_tab.click();
		TypehereText.sendKeys("StudentNotesresources"+randomNumberGenerator());
		cp.Save();
		CloseIcon();	
		System.out.println("Resources completed successfully.");
	}	
	public void performContentActivity() {
		System.out.println("Performing Content activity...");			
		Details_tab.click();
		StaticWait(1);	
		Notes_tab.click();
		TypehereText.sendKeys("StudentNotesforcontent"+randomNumberGenerator());
		cp.Save();
		CloseIcon();
		System.out.println("Content completed successfully.");
	}
	public void performExternalToolActivity() {
		System.out.println("Performing ExternalTool activity...");			 
		Content_tab.click();
		//Deeplinkingbutton.click();		
		//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//		    wait.until(ExpectedConditions.elementToBeClickable(Content_tab)).click();

		//		    StaticWait(1);
		//		    wait.until(ExpectedConditions.elementToBeClickable(Deeplinkingbutton)).click();
		//		    StaticWait(1);
		//		    String originalWindow = driver.getWindowHandle(); 
		//		    Set<String> allWindows = driver.getWindowHandles();
		//
		//		    for (String windowHandle : allWindows) {
		//		        if (!windowHandle.equals(originalWindow)) {
		//		            driver.switchTo().window(windowHandle); 
		//		            break;
		//		        }
		//		    }
		//		    driver.close();
		//		    driver.switchTo().window(originalWindow);	    
		//		StaticWait(1);
		//		Notes_tab.click();
		//		TypehereText.sendKeys("StudentNotesExternalTool"+randomNumberGenerator());
		//		cp.Save();
		CloseIcon();

		System.out.println("Externaltool completed successfully.");
	}

	public void performLTI_Content_Provider_Activity() {
		System.out.println("Performing LTI_Content_Provider_Activity...");			
		Content_tab.click();		
		//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//		    wait.until(ExpectedConditions.elementToBeClickable(Content_tab)).click();

		//		    StaticWait(1);
		//		    wait.until(ExpectedConditions.elementToBeClickable(Deeplinkingbutton)).click();
		//		    StaticWait(1);
		//		    String originalWindow = driver.getWindowHandle(); 
		//		    Set<String> allWindows = driver.getWindowHandles();
		//		    for (String windowHandle : allWindows) {
		//		        if (!windowHandle.equals(originalWindow)) {
		//		            driver.switchTo().window(windowHandle); 
		//		            break;
		//		        }}
		//		    driver.close();
		//		    driver.switchTo().window(originalWindow);		    
		StaticWait(1);	    	
		//Notes_tab.click();
		//TypehereText.sendKeys("StudentNotesforLTI"+randomNumberGenerator());

		cp.Save();
		CloseIcon();

		System.out.println("LTI Activity completed successfully.");
	}	
	public void performEpublicationActivity() {
		System.out.println("Performing Epublication activity...");		
		Details_tab.click();
		StaticWait(1);
		Notes_tab.click();
		TypehereText.sendKeys("StudentNotesforEpublication"+randomNumberGenerator());
		cp.Save();

		CloseIcon();

		System.out.println("Epublication completed successfully.");
	}
}