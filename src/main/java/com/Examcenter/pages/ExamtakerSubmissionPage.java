package com.Examcenter.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Utils.ActionType;
import com.Utils.Base;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class ExamtakerSubmissionPage extends ActionType{

	By begintest=By.xpath("//button[@aria-label='Begin Test']");
	By blankAnswer=By.xpath("//input[@id='txtEditorInteraction']");
	By close=By.xpath("//mat-icon[text()='close']");
	private WebDriver driver;
	By examinationbtn=By.xpath("//span[text()='Examinations']");
	By ExtendedTypeAnswer=By.xpath("//body[@contenteditable='true']");
	By finish=By.xpath("(//button[text()='Finish'])[3]");
	By frame=By.xpath("//iframe[@frameborder='0']");
	By launchbtn=By.xpath("//span[text()=' Launch ']");
	By logout=By.xpath("//span[text()='logout']");
	By mcqAnswer=By.xpath("//li[@class='qti_readaloud blackColorScheme normalFontSize'][1]");
	By nextbtn=By.xpath("//button[@aria-label='Next']");
	By Qcount=By.xpath("//div[@id='navigationSideMenu']/ul/li/p/button");
	By returnbtn=By.xpath("//button[@value='login']");
	By searchheretxt=By.xpath("//input[@type='search']");
	By statusband=By.xpath("//b[text()='Performance']/../span/span");
	By Submit=By.xpath("//button[text()='Submit']");
	By tokentxt=By.xpath("//input[@type='password']");
	By validatebtn=By.xpath("//button[@aria-label='Validate']");
	public ExamtakerSubmissionPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void Answers()
	{
		List<WebElement> Count = driver.findElements(Qcount);
		//System.out.println(Count.size());
		for(int i=1;i<=Count.size();i++)
		{
			waitForElement(mcqAnswer);
			WebElement e=driver.findElement(mcqAnswer);
			JavascriptExecutor j=(JavascriptExecutor) driver;
			j.executeScript("arguments[0].click()",e);
			StaticWait(1);
			driver.findElement(nextbtn).click();
		}
	}
	public void begintest()
	{
		waitForElement(begintest);
		WebElement e=driver.findElement(begintest);	
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()",e);
	}
	public void close()
	{
		driver.switchTo().defaultContent();
		driver.findElement(close).click();
	}
	public void examinationbtn()
	{
		waitForElement(examinationbtn);
		driver.findElement(examinationbtn).click();
	}
	public void Finish()
	{
		driver.findElement(finish).click();
		waitForElement(Submit);
		StaticWait(1);
		driver.findElement(Submit).click();
		StaticWait(2);
	}
	public void launchbtn()
	{
		waitForElement(launchbtn);
		StaticWait(2);
		WebElement e1=driver.findElement(launchbtn);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].click()",e1);
		driver.switchTo().frame(0);
	}
	public void logout()
	{
		driver.findElement(logout).click();
		WebElement e=driver.findElement(returnbtn);
		e.click();
	}

	public void searchheretxt(String Examname, String ScheduleName)
	{
		waitForElement(searchheretxt);
		driver.findElement(searchheretxt).sendKeys(Examname+" - "+ScheduleName);
		StaticWait(2);
		WebElement element=driver.findElement(By.xpath("//b[text()='"+Examname+" - "+ScheduleName+"']"));
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()",element);

	}
	public void statusband()
	{
		StaticWait(2);
		String band=driver.findElement(statusband).getText();
		ExtentCucumberAdapter.addTestStepLog(band);
		StaticWait(2);
	}
	public void tokentxt(String Token)
	{
		waitForElement(tokentxt);
		driver.findElement(tokentxt).sendKeys(Token);
	}
	public void validatebtn()
	{
		waitForElement(validatebtn);
		driver.findElement(validatebtn).click();
	}
}
