package com.Examcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Examcenter.Utils.ActionType;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class Location_pom extends ActionType {
	private WebDriver driver;
	
//	private By ChangepwdClose= By.xpath("//mat-icon[text()='close']");
	private By Administrationbtn= By.xpath("//span[text()='Administration']");
	private By Locationtab= By.xpath("//a[text()='Locations']");
	private By AddNewbutton=By.xpath("//span[text()=' Add New ']");
	private By LocationNamefield= By.xpath("(//input[@type='text'])[1]");
	private By Addressfield=By.xpath("(//input[@type='text'])[2]");
	private By LocationSave= By.xpath("//span[text()=' Save ']");
	
	//private By LocationEditIcon= By.xpath("//td[text()=' Focalpoint 01']/following-sibling::td/button/span/mat-icon");
	private By EditLocationName=By.xpath("(//input[@type='text'])[1]");
	private By EditSaveLocation=By.xpath("//span[text()=' Save ']");
	
	public Location_pom(WebDriver driver) {
		this.driver=driver;
	}
	
//	public void Change_password_closeIcon() {
//		
//		driver.findElement(ChangepwdClose).click();
//		StaticWait(4);
//	}
	public void Adminstarationbtn()
    {
		waitForElement(Administrationbtn);
        waitForPageLoad();
		StaticWait(2);
		Actions a=new Actions(driver);
		WebElement L=driver.findElement(Administrationbtn);
		a.moveToElement(L).click().build().perform();	
    }
	
	public void Location_tab() {
		StaticWait(2);
		Actions a=new Actions(driver);
		WebElement L=driver.findElement(Locationtab);
		a.moveToElement(L).click().build().perform();
	}
	public void Addnew_location() {
		StaticWait(1);
		driver.findElement(AddNewbutton).click();
	}
	public void Location_Name_field(String locationnametxtfield) {
		driver.findElement(LocationNamefield).sendKeys(locationnametxtfield);
	}
	public void Address_field(String Addresstext) {
		driver.findElement(Addressfield).sendKeys(Addresstext);
	}
	public void Location_Save() {
		driver.findElement(LocationSave).click();
		StaticWait(1);
		ExtentCucumberAdapter.addTestStepLog("Location Saved Successfully");
	}
	
	public void Location_Edit_Icon(String locationnametxtfield) {
		StaticWait(2);
		WebElement Edit=driver.findElement(By.xpath("//td[text()=' "+locationnametxtfield+"']/../td[2]/button/span/mat-icon"));
		Actions a=new Actions(driver);
		a.moveToElement(Edit).build().perform();
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()",Edit);
		
	}
	public void Edit_Location_name(String Editlocationname) {
		StaticWait(2);
		WebElement E1= driver.findElement(EditLocationName);
		E1.click();
		E1.clear();
		E1.sendKeys(Editlocationname);
	
	}
	public void Edit_Save_Location() {
		driver.findElement(EditSaveLocation).click();
		
	}
	
}
