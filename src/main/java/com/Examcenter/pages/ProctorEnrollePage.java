package com.Examcenter.pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;

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
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
public class ProctorEnrollePage extends ActionType{

	public WebDriver driver;
	private Wait wait;
	CommonPages cp=new CommonPages(Base.getDriver());
	@FindBy(how=How.XPATH,using = "//span[text()='Enrollees']") private WebElement enrolleTab;
	@FindBy(how=How.XPATH,using = "//div[@class='fw-bold']") private WebElement ExamtakerName;
	@FindBy(how=How.ID,using = "printTestSummary") private WebElement printtestanalytics;
	public ProctorEnrollePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void EnrolleTab()
	{
		Actions a=new Actions(driver);
		a.moveToElement(enrolleTab).build().perform();
		a.doubleClick().perform();
		//		JavascriptExecutor js=(JavascriptExecutor) driver;
		//		js.executeScript("arguments[0].click();", enrolleTab);
	}
	public void select_the_Examination(String ExamName, String ScheduleName) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String fullExamScheduleName = ExamName + "-" + ScheduleName;
		WebElement ExaminationLookupText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-label[text()='Examination ']/parent::label/parent::span/preceding-sibling::mat-select/parent::div")));
		StaticWait(1);
		cp.FPdropdown(ExaminationLookupText, fullExamScheduleName);
		//		System.out.println(fullExamScheduleName);
	}

	public void TestAnalytics(String ExamName, String ScheduleName)
	{
		int maxretry=5;
		for(int retry=0;retry<=maxretry;retry++)
		{
			try {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' "+ExamName+"-"+ScheduleName+" ']/parent::td/parent::tr/child::td[7]/child::span/child::span/child::button[1]")));
				JavascriptExecutor js=(JavascriptExecutor) driver;
				StaticWait(1);
				js.executeScript("arguments[0].click();", e);
				driver.switchTo().frame(0);	
				break;
			}catch (StaleElementReferenceException e) {
				if (retry == maxretry) {
					System.out.println("Max retries reached, unable to find the element.");
					break;
				}
				System.out.println("StaleElementReferenceException, retrying... Attempt: " + (retry + 1));
			}
			catch (Exception e) {
				System.out.println("Exception occurred: " + e.getMessage());
				break;
			}
		}   
	}
	public void printExamtakerName(String Examtaker)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement e=wait.until(ExpectedConditions.elementToBeClickable(ExamtakerName));
		wait.until(ExpectedConditions.visibilityOf(ExamtakerName));
		StaticWait(5);
		String s=e.getText();
		ExtentCucumberAdapter.addTestStepLog(s);
		if(s.equalsIgnoreCase(Examtaker))
		{
			System.out.println("Test Analytics Previewed Successfully..!");
			ExtentCucumberAdapter.addTestStepLog("Test Analytics Previewed Successfully..!");
		}
		else {
			System.out.println("Test Analytics Not able to see..!");
			ExtentCucumberAdapter.addTestStepLog("Test Analytics Not able to see..!");
		}
		wait.until(ExpectedConditions.visibilityOf(printtestanalytics));
		StaticWait(2);
		printtestanalytics.click();
		StaticWait(2);
	}
	public void attachDownloadedFileToReport() {
	    try {
	        Path downloadDir = Paths.get(System.getProperty("user.home"), "Downloads");
	        Optional<Path> latestFile = Files.list(downloadDir)
	            .filter(Files::isRegularFile)
	            .max(Comparator.comparingLong(p -> p.toFile().lastModified()));

	        if (latestFile.isPresent()) {
	            Path source = latestFile.get();
	            System.out.println("Latest file found: " + source.toString());
	            String filePath = source.toAbsolutePath().toString();
	            String fileLink = "<a href='file:///" + filePath + "' target='_blank'>Download Grades File</a>";
	            ExtentCucumberAdapter.addTestStepLog("Latest file found: " + source.toString() + " - " + fileLink);
	        } else {
	            System.out.println("No files found in the Downloads directory.");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
