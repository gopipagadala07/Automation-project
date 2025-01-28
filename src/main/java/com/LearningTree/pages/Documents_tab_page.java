package com.LearningTree.pages;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Comparator;
import java.util.Optional;

import org.openqa.selenium.By;

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

public class Documents_tab_page extends ActionType {

	private WebDriver driver;
	private Wait wait; 

	public String LearningTree_Name;

	public String Folder_name;


	CommonPages cp=new CommonPages(Base.getDriver());

	@FindBy(how = How.XPATH,using = "//span[text()='Learning']")private WebElement LearningTab;
	@FindBy(how = How.XPATH,using = "//a[text()='Courses']")private WebElement CoursesTab;
	@FindBy(how = How.XPATH,using = "//*[text()='search here']/parent::label/parent::span/preceding-sibling::input")private WebElement SearchHere;

	@FindBy(how=How.XPATH,using="//*[local-name()='svg' and @matTooltip='Documents']")private WebElement DocumentsTab;
	@FindBy(how=How.XPATH,using="//mat-icon[text()='add']")private WebElement AddRootFolder;
	@FindBy(how=How.XPATH,using="//mat-icon[@mattooltip='Add-SubFolder']")private WebElement Add_Sub_Folder;

	@FindBy(how = How.XPATH,using = "//input[@type='text']")private WebElement FolderName;
	@FindBy(how = How.XPATH,using = "//label[contains(text(),'Description')]/parent::div/descendant::p")private WebElement Description;


	@FindBy(how = How.XPATH,using = "//mat-icon[text()='cloud_upload']")private WebElement Upload_File;

	@FindBy(how = How.XPATH,using = "//a[text()='Learning Tree']")private WebElement LearningTree_Tab;

	
	@FindBy(how = How.XPATH,using = "//mat-icon[@mattooltip='Download File']")private WebElement DownloadFile;



	public Documents_tab_page(WebDriver driver)
	{
		this.driver=driver; 
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void click_on_CoursesTab()
	{ 
		if(CoursesTab.isDisplayed())
		{
			wait.elementToBeClickable(CoursesTab);
			CoursesTab.click();
		}
		else
		{
			wait.elementToBeClickable(LearningTab);
			LearningTab.click();
			wait.elementToBeClickable(CoursesTab);
			CoursesTab.click();
		}
	}

	public void search_Course(String LearningTree_Name)
	{
		cp.searchField(LearningTree_Name);
		StaticWait(1);
	}

	public void click_on_Course(String LearningTree_Name)
	{
		int attempts = 0;
		while (attempts < 3) {
			try {

				WebElement community=driver.findElement(By.xpath("//b[text()='"+LearningTree_Name+"']"));
				StaticWait(1);
				community.click();
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				StaticWait(1);        
			}
		}
	}
	public void DocumentsTab()
	{
		wait.elementToBeClickable(DocumentsTab);
		DocumentsTab.click(); 
	}
	public void create_Folders()
	{
		wait.elementToBeClickable(AddRootFolder);
		AddRootFolder.click();
		folderinputfields();
		wait.elementToBeClickable(Add_Sub_Folder);
		Add_Sub_Folder.click();
		folderinputfields();
	}

	public void folderinputfields()
	{
		wait.elementToBeClickable(FolderName);
		FolderName.click();
		Folder_name="LTDocuments"+randomNumberGenerator();
		FolderName.sendKeys(Folder_name);
		Description.sendKeys("FolderDescription"+generateRandomString());
		cp.Save(); 
	}

	public void fileupload() throws IOException  {

		int retries = 10;
		while (retries > 0)
		{
			try {

				WebElement fileInputRootFolder = driver.findElement(By.xpath("(//mat-icon[@mattooltip='Upload File']/preceding-sibling::input)[1]"));
				fileInputRootFolder.sendKeys(new File("src/test/resources/ExcelFiles/LearningTree.xlsx").getCanonicalPath());		         
				WebElement fileInputSubFolder = driver.findElement(By.xpath("(//mat-icon[@mattooltip='Upload File']/preceding-sibling::input)[2]"));
				fileInputSubFolder.sendKeys(new File("src/test/resources/ExcelFiles/LT.txt").getCanonicalPath());
				break;
			}

			catch (StaleElementReferenceException e)
			{
				System.out.println("Caught StaleElementReferenceException. Retrying...");
				retries--;
			}  
		}
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
	public void downloadfile()
	{
//		wait.elementToBeClickable(DownloadFile);
//		DownloadFile.click();	
		
		WebElement RootdownloadFile = driver.findElement(By.xpath("(//mat-icon[@mattooltip='Download File'])[1]"));
		RootdownloadFile.click();
		StaticWait(2);
		WebElement SubdownloadFile = driver.findElement(By.xpath("(//mat-icon[@mattooltip='Download File'])[2]"));
		SubdownloadFile.click();
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
				String fileLink = "<a href='file:///" + filePath + "' target='_blank'>Download LearningTree File</a>";
				ExtentCucumberAdapter.addTestStepLog("Latest file found: " + source.toString() + " - " + fileLink);
			} else {
				System.out.println("No files found in the Downloads directory.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}