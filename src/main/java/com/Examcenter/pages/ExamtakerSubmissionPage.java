package com.Examcenter.pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class ExamtakerSubmissionPage extends ActionType{
	private WebDriver driver;
	private Wait wait;
	CommonPages cp=new CommonPages(Base.getDriver());
	
	@FindBy(how = How.XPATH,using="//button[@aria-label='Begin Test']")private WebElement begintest;
	@FindBy(how = How.XPATH,using="//input[@id='txtEditorInteraction']")private WebElement blankAnswer;
	@FindBy(how = How.XPATH,using="//mat-icon[text()='close']")private WebElement close;
	@FindBy(how = How.XPATH,using="//span[text()='Examinations']")private WebElement examinationbtn;	
	@FindBy(how = How.XPATH,using="//body[@contenteditable='true']")private WebElement ExtendedTypeAnswer;
	@FindBy(how = How.XPATH,using="//span[text()='Finish']")private WebElement finish;
	@FindBy(how = How.XPATH,using="//span[text()=' Launch ']")private WebElement launchbtn;
	@FindBy(how = How.XPATH,using="//iframe[@frameborder='0']")private WebElement frame;	
	@FindBy(how = How.XPATH,using="//span[text()='logout']")private WebElement logout;
	@FindBy(how = How.XPATH,using="(//div[@class='mdc-radio'])[3]")private WebElement mcqAnswer;
	@FindBy(how = How.XPATH,using="//mat-icon[text()='chevron_right']")private WebElement nextbtn;
	@FindBy(how = How.XPATH,using="//div[@id='navigationSideMenu']/ul/li/div/button")private List<WebElement> Qcount;
	@FindBy(how = How.XPATH,using="//button[@value='login']")private WebElement returnbtn;
	@FindBy(how = How.XPATH,using="//input[@type='search']")private WebElement searchheretxt;
	@FindBy(how = How.XPATH,using="//b[text()='Status']/parent::div/span")private WebElement statusband;
	@FindBy(how = How.XPATH,using="//span[text()='Submit']")private WebElement Submit;
	@FindBy(how = How.XPATH,using="//input[@type='password']")private WebElement tokentxt;
	@FindBy(how = How.XPATH,using="//button[@aria-label='Validate']")private WebElement validatebtn;
	@FindBy(how = How.XPATH,using="//span[text()='Examinations']")private WebElement Examinations;

	public ExamtakerSubmissionPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void Answers()
	{
        StaticWait(2);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement beginTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Begin Test')]")));
        js.executeScript("arguments[0].click();", beginTest);

        List<WebElement> questions = driver.findElements(By.xpath("//div[@id='navigationSideMenu']/ul/li/div/button"));
        int numberOfQuestions = questions.size();
       //System.out.println("Total number of questions: " + numberOfQuestions);
        for (int i = 0; i < numberOfQuestions; i++) {
            int questionAttempts = 0;
            int questionMaxAttempts = 5;

            while (questionAttempts < questionMaxAttempts) {
                try {
                    WebElement question = driver.findElement(By.xpath("//*[contains(@responseidentifier, 'RESPONSE')]"));
                    String tagName = question.getTagName();
                    StaticWait(1);

                    if (tagName.equalsIgnoreCase("choiceinteraction")) {
                        WebElement choiceValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mdc-radio'])[4]")));
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
//                        fillInTheBlankValue.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//                        fillInTheBlankValue.sendKeys(Keys.BACK_SPACE);
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
        wait.until(ExpectedConditions.elementToBeClickable(finish));
        js.executeScript("arguments[0].click();", finish);
        StaticWait(1);

        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Submit']")));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        js.executeScript("arguments[0].click();", submit);
        StaticWait(2);

        driver.switchTo().defaultContent();

        WebElement closeAfterSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[text()='close']")));
        wait.until(ExpectedConditions.elementToBeClickable(closeAfterSubmit));
        js.executeScript("arguments[0].click();", closeAfterSubmit);
        StaticWait(1);
	}

	public void launchbtn()
	{
		wait.elementToBeClickable(launchbtn);
		StaticWait(2);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].click()",launchbtn);
	}

	public void logout()
	{
		wait.elementToBeClickable(logout);
		StaticWait(2);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].click()",logout);
	}
	public void searchheretxt(String Examname, String ScheduleName) throws InterruptedException
	{

		try {
            WebElement idServerAllow = driver.findElement(By.xpath("//button[@value='yes']"));
            if (idServerAllow.isDisplayed()) {
            	JavascriptExecutor js = (JavascriptExecutor) driver;
            	js.executeScript("arguments[0].scrollIntoView(true);", idServerAllow);  
            	js.executeScript("arguments[0].click();", idServerAllow);
                //idServerAllow.click();
            }
        } catch (NoSuchElementException e) {
          
        }	

		wait.elementToBeClickable(Examinations);
		Examinations.click();
		cp.searchField(Examname+" - "+ScheduleName);

		int retries = 0;
		int maxretry=3;
		boolean success = false;
		while (retries < maxretry) {
		    try {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[text()='"+Examname+" - "+ScheduleName+"']")));
				wait.until(ExpectedConditions.visibilityOf(element));
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);
				success=true;
		        break;
		    } catch (StaleElementReferenceException e) {
		        System.out.println("Page reloaded. Retrying...");
		        retries++;
		        Thread.sleep(2000);
		    }
		}
		if (!success) {
		    throw new RuntimeException("Failed to interact with the element after retries.");
		}
	}
	public void statusband()
	{
		String band=statusband.getText();
		ExtentCucumberAdapter.addTestStepLog(band);
	}
	public void tokentxt(String Token)
	{
		wait.elementToBeClickable(tokentxt);
		tokentxt.sendKeys(Token);
	}
	public void validatebtn()
	{
		wait.elementToBeClickable(validatebtn);
		validatebtn.click();
	}
}
