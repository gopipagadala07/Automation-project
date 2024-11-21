package com.Assessments.pages;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.Wait;

import io.cucumber.java.lu.an;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

public class LaunchValidationPages extends ActionType {

	CommonPages cp=new CommonPages(Base.getDriver());
	public WebDriver driver;
	private Wait wait;

	@FindBy(how=How.XPATH,using="//span[@mattooltip='Assessments']")private WebElement AssessmentTab;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='launch']/parent::span")private WebElement LaunchIcon;
	@FindBy(how=How.XPATH,using="//span[text()=' Begin Test ']")private WebElement BeginTest;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='close']/parent::span")private WebElement CloseIcon;
	@FindBy(how=How.XPATH,using="//iframe[@class='iframe-styling ng-star-inserted']")private WebElement iFrame;

	@FindBy(how=How.XPATH,using="//div[contains(text(),'EXAM')]")private WebElement ExamTab;



	@FindBy(how = How.XPATH, using = "//cdk-nested-tree-node[@role='treeitem']/child::div/child::div[2]/cdk-nested-tree-node/child::div/child::small/following::div/child::span/child::mat-icon")
	private List<WebElement> Quizzeslist;

	@FindBy(how = How.XPATH, using = "//small[@class='announce__list--icon']")
	private List<WebElement> examsList;


	public LaunchValidationPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver); 
	}


	public void clickEachQuizAndClose() {
		System.out.println("Total Quizzes: " + Quizzeslist.size());

		for (int i = 0; i < Quizzeslist.size(); i++) {
			WebElement quiz = Quizzeslist.get(i);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", quiz);
			StaticWait(2);
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].click()", CloseIcon);
				StaticWait(1); }
		
	}
	public void clickEachExamAndClose() {
		System.out.println("Total exams: " + examsList.size());
		ExamTab.click();
		for (int i = 0; i < examsList.size(); i++) {
			WebElement quiz = examsList.get(i);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", quiz);
			StaticWait(2);

				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].click()", CloseIcon);
				StaticWait(1); }
		
	}
	}








