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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.ActionType;
import com.Utils.Wait;

public class QuizSubmissionPages extends ActionType{
	private Wait wait;

	@FindBy(how = How.XPATH,using = "//mat-icon[@mattooltip='Launch Activity']")private WebElement launchicon;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Begin Test')]")private WebElement Begintestbtn;
	@FindBy(how = How.XPATH,using = "//div[@class='qti_item']/mat-card")private WebElement Questionelement;
	@FindBy(how = How.XPATH,using = "(//div[@class='mdc-radio'])[2]")private WebElement Singlechoice;
	@FindBy(how = How.XPATH,using = "//div[@role='textbox']")private WebElement ExtendedAnswer;
	@FindBy(how = How.XPATH,using = "//input[@type='text']")private WebElement FillintheblankAnswer;
	@FindBy(how = How.XPATH,using = "//div[@id='navigationSideMenu']/ul/li/div/button")private WebElement Questioncnt;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Finish')]")private WebElement Finishbtn;
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Submit')]")private WebElement submitbtn;
	@FindBy(how = How.XPATH,using = "//mat-icon[text()='close']")private WebElement close;

	public QuizSubmissionPages(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new Wait(driver);
	}

	public void Launchicon()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement matIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[@mattooltip='Launch Activity']")));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", matIcon);
	}
	public void Begintest() {
		StaticWait(2);
		driver.switchTo().frame(0);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement BeginTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Begin Test')]")));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", BeginTest);
	}


	public void QuestionsAnswers() {
		List<WebElement> countQ = driver.findElements(By.xpath("//div[@id='navigationSideMenu']/ul/li/div/button"));
		int count = countQ.size();
		System.out.println(count);

		for (int i = 0; i < count; i++) {
			int min = 0;
			int max = 5;
			while (min < max) {
				try {
					WebElement ele = driver.findElement(By.xpath("//*[contains(@responseidentifier, 'RESPONSE')]"));
					String tagName = ele.getTagName();
					System.out.println(tagName);
					StaticWait(1);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					if (tagName.equalsIgnoreCase("choiceinteraction")) {
						WebElement ChoiceValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mdc-radio'])[2]")));
						Actions a = new Actions(driver);
						a.moveToElement(ChoiceValue);
						a.click().build().perform();
					} else if (tagName.equalsIgnoreCase("extendedtextinteraction")) {
						WebElement ExtendedValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='ck-placeholder']")));
						ExtendedValue.sendKeys(generateRandomString());
					} else if (tagName.equalsIgnoreCase("textentryinteraction")) {
						WebElement FillInTheBlankValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEditorInteraction")));
						StaticWait(1);
						FillInTheBlankValue.sendKeys(String.valueOf(randomNumberGenerator()));        
					}
					WebElement Nextbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@mattooltip='Next']")));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", Nextbtn);
					StaticWait(2);
					break;
				} catch (StaleElementReferenceException e) {
					System.out.println("Attempt " + (min + 1) + " - StaleElementReferenceException encountered. Retrying...");
					min++;
				}
			}
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement Finishbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Finish')]")));
			Finishbtn.click();
			WebElement Submitbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Submit')]")));
			Submitbtn.click();
			WebElement closeicon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[text()='close']")));
			closeicon.click();
		}
	}



	public void SubmitExam()
	{
		wait.elementToBeClickable(Finishbtn);
		Finishbtn.click();
		wait.elementToBeClickable(submitbtn);
		submitbtn.click();
		wait.elementToBeClickable(close);
		close.click();
	}


	public void LaunchandSubmitQuiz()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));		
		WebElement Allbtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=' All ']")));
		Allbtn.click();
		List<WebElement> LaunchIcon = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-icon[@mattooltip='Launch Activity']")));
		int LaunchIconcount=LaunchIcon.size();
		System.out.println(LaunchIconcount);

		for(int i=0;i<=LaunchIconcount;i++)
		{
			LaunchIcon.get(i).click();
			StaticWait(2);
			driver.switchTo().frame(0);
			WebElement BeginTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Begin Test')]")));
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", BeginTest);
			List<WebElement> countQ = driver.findElements(By.xpath("//div[@id='navigationSideMenu']/ul/li/div/button"));
			int count = countQ.size();
			System.out.println(count);

			for (int j = 0; j < count; j++) {
				int min = 0;
				int max = 5;
				while (min < max) {
					try {
						WebElement ele = driver.findElement(By.xpath("//*[contains(@responseidentifier, 'RESPONSE')]"));
						String tagName = ele.getTagName();
						System.out.println(tagName);
						StaticWait(1);

						if (tagName.equalsIgnoreCase("choiceinteraction")) {
							WebElement ChoiceValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mdc-radio'])[2]")));
							Actions a = new Actions(driver);
							a.moveToElement(ChoiceValue);
							a.click().build().perform();
						} else if (tagName.equalsIgnoreCase("extendedtextinteraction")) {
							WebElement ExtendedValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='ck-placeholder']")));
							ExtendedValue.sendKeys(generateRandomString());
						} else if (tagName.equalsIgnoreCase("textentryinteraction")) {
							WebElement FillInTheBlankValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEditorInteraction")));
							StaticWait(1);
							FillInTheBlankValue.sendKeys(String.valueOf(randomNumberGenerator()));        
						}
						WebElement Nextbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@mattooltip='Next']")));

						js.executeScript("arguments[0].click();", Nextbtn);
						StaticWait(2);
						break;
					} catch (StaleElementReferenceException e) {
						System.out.println("Attempt " + (min + 1) + " - StaleElementReferenceException encountered. Retrying...");
						min++;
					}
				}
				WebElement Finishbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Finish')]")));
				Finishbtn.click();
				WebElement Submitbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Submit')]")));
				Submitbtn.click();
				WebElement closeicon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[text()='close']")));
				closeicon.click();
			}
		}
	}

}