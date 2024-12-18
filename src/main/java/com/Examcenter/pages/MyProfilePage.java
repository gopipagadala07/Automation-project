package com.Examcenter.pages;
import java.util.List;
import org.openqa.selenium.support.How;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Utils.ActionType;

public class MyProfilePage extends ActionType{

	By changepwd=By.xpath("//mat-icon[text()='edit']");
	
	private WebDriver driver;
	By Editemail=By.xpath("(//input[@type='text'])[1]");
	By file=By.xpath("//h3[text()='Please Select a picture to upload']/../div/input");
	By minimize=By.xpath("//span[@class='fa fa-search-minus']");
	By Newpwd=By.xpath("(//input[@type='password'])[1]");
	By oldpwd=By.xpath("(//input[@type='text'])[5]");
	By profile=By.xpath("//div[@role='textbox']");
	By profilelogo=By.xpath("//a[@mattooltip='My Profile']");
	By profilesave=By.xpath("//mat-icon[text()='save']");
	By reenterpwd=By.xpath("(//input[@type='password'])[2]");
	By savebtn=By.xpath("//span[text()=' Save ']");
	By saveimg=By.xpath("//span[text()=' Save Profile Picture ']");
	By upload=By.xpath("//mat-icon[text()='backup']");
	By zoomid=By.xpath("(//input[@type='text'])[4]");
	
	public MyProfilePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void changepwd(String OldPwd,String NewPwd,String CnfmPwd)
	{
		driver.findElement(changepwd).click();
		waitForElement(oldpwd);
		StaticWait(2);
		driver.findElement(oldpwd).sendKeys(OldPwd);
		driver.findElement(Newpwd).sendKeys(NewPwd);
		driver.findElement(reenterpwd).sendKeys(CnfmPwd);
		waitForElement(savebtn);
		StaticWait(1);
		driver.findElement(savebtn).click();
	}
	public void edtEmail(String Email)
	{
		waitForElement(Editemail);
		StaticWait(2);
		driver.findElement(Editemail).sendKeys(Keys.CONTROL,"a",Keys.CLEAR);
		StaticWait(1);
		driver.findElement(Editemail).sendKeys(Email);
	}
	public void logo()
	{
		waitForElement(profilelogo);
		driver.findElement(profilelogo).click();
	}
	public void profiledesc(String Description)
	{
		waitForElement(profile);
		driver.findElement(profile).sendKeys(Keys.CONTROL,"a",Keys.CLEAR);
		StaticWait(1);
//		WebElement d=driver.findElement(profile);
//		if(d.isDisplayed())
//		{
//			d.sendKeys(Description);
//		}
//		else
//		{
//			System.out.println("No Profile Description");
//		}
		
	}
	public void profileSave()
	{
		StaticWait(1);
		driver.findElement(profilesave).click();
		StaticWait(1);
	}
	public void uploadProfile(String path)
	{
		driver.findElement(upload).click();
		waitForElement(file);
		StaticWait(1);
		driver.findElement(file).sendKeys(path);
		StaticWait(1);
	    driver.findElement(minimize).click();
		WebElement e1=driver.findElement(saveimg);
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()",e1);
		e1.click();
	
	}
	public void zoomid(String ID) {
		waitForElement(zoomid);
		driver.findElement(zoomid).sendKeys(Keys.CONTROL,"a",Keys.CLEAR);
		StaticWait(1);
	    driver.findElement(zoomid).sendKeys(ID);;
	}
}
