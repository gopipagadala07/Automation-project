package com.Examcenter.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Utils.ActionType;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Scenario;

public class ProctorEnrollePage extends ActionType{

	public WebDriver driver;
	
	By enrolleTab=By.xpath("//span[text()='Enrollees']");
	By examinationsdropdown=By.xpath("//div[text()='ENROLLEES']/../../../../../../../preceding-sibling::div/div/mat-form-field/div/div[1]");
	By search=By.xpath("//input[@type='search']");
	By ExamtakerName=By.xpath("//div[@class='fw-bold']");
	
	public ProctorEnrollePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void EnrolleTab()
	{
		driver.findElement(enrolleTab).click();
	}
	
	public void ExaminationsDropdown()
	{
		waitForElement(examinationsdropdown);
		StaticWait(1);
		WebElement e=driver.findElement(examinationsdropdown);
		JavascriptExecutor j=(JavascriptExecutor)getDriver();
		j.executeScript("arguments[0].click()", e);
	}
	
	public void ExaminationsSelect(String ExamName, String ScheduleName)
	{
		StaticWait(2);
		WebElement e=driver.findElement(By.xpath("(//span[text()=' "+ExamName+"-"+ScheduleName+" '])[2]"));
		e.click();
	}
	public void examtakerSearch(String LastName, String FirstName)
	{
		WebElement e=driver.findElement(search);
		e.click();
		e.sendKeys(FirstName+" ");
		StaticWait(1);
		e.sendKeys(LastName);
	}
	public void TestAnalytics(String ExamName, String ScheduleName)
	{
		StaticWait(5);
		WebElement e=driver.findElement(By.xpath("//span[text()=' "+ExamName+"-"+ScheduleName+" ']/../../td[7]/span/span/button"));
		Dimension d=new Dimension(1920,1080);
		driver.manage().window().setSize(d);
		StaticWait(1);	
		e.click();
	    driver.switchTo().frame(0);	    
	}
	public void printExamtakerName()
	{
		WebElement e1=driver.findElement(ExamtakerName);
	    String s=e1.getText();
	    ExtentCucumberAdapter.addTestStepLog(s);
	}
	public void Capturescreenshot() throws Exception
	{
		//String screenshotName = scenario.getName().replaceAll(" ", "_");
		File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("./test-output/Reports/Screenshots/TestAnalytics.png");
		FileUtils.copyFile(sourcePath, dest);
		//ExtentCucumberAdapter.addTestStepScreenCaptureFromPath("/test-output/Reports/TestAnalytics.png");
	}
}
