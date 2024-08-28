package com.Examcenter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Examcenter.Utils.ActionType;

public class Users_CreationPage extends ActionType{

	By Addnewbtn=By.xpath("//span[text()=' Add New ']");

	By Adminstrationbtn=By.xpath("//mat-icon[text()=' settings ']");
	//By Userstab=By.xpath("//div[text()='USERS']");
	By Controllerbtn=By.xpath("//a[text()='Controllers']");
	By createloginbtn=By.xpath("//span[text()=' Create New Login ']");
	By data=By.xpath("//input[@type='search']/../../../../../../following-sibling::div[1]/div");
	By DOBtxt=By.xpath("//button[@aria-label='Open calendar']");
	private WebDriver driver;
	By Editbtn=By.xpath("//mat-icon[text()='edit']");
	By editsavebtn=By.xpath("//span[text()=' Save ']");
	By Emailtxt=By.xpath("(//input[@type='text'])[1]");
	By Examtakerbtn=By.xpath("//div[text()='EXAM TAKERS']");
	By Firstnametxt=By.xpath("(//input[@type='text'])[2]");
	By IDtxt=By.xpath("(//input[@type='text'])[4]");
	By isAdminChkBox=By.xpath("//span[text()='Is Admin ']");
	By Lastnametxt=By.xpath("(//input[@type='text'])[3]");
	By proctor=By.xpath("//h2[text()='Add/Edit Proctor']");
	By Proctorbtn=By.xpath("//div[text()='PROCTORS']");
	By proctorLoc=By.xpath("//fp-textbox[@controlname='localStateID']/../div");
	By provisioning=By.xpath("//a[text()='Provisioning']");
	By reset=By.xpath("//span[text()=' Reset ']");
	By resetbtn=By.xpath("//span[text()=' Reset Password ']");
	By savebtn=By.xpath("//span[text()=' Save ']");
	By searchtxt=By.xpath("//input[@data-placeholder='search here']");
	By year=By.xpath("//button[@aria-label='Choose month and year']");
	By yes=By.xpath("//button[text()='Reset']");

	public Users_CreationPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void Addnewbtn()
	{
		waitForElement(Addnewbtn);
		StaticWait(1);
		driver.findElement(Addnewbtn).click();
	}
	public void Adminstarationbtn()
	{
		waitForElement(Adminstrationbtn);
		StaticWait(3);
		WebElement e1=driver.findElement(Adminstrationbtn);
		Actions a=new Actions(driver);
		a.moveToElement(e1).click().build().perform();
		StaticWait(1);
		//waitForElement(Userstab);
		//driver.findElement(Userstab).click();

	}
	public void Controllerbtn()
	{
		waitForElement(Controllerbtn);
		WebElement e=driver.findElement(Controllerbtn);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", e);
	}
	public void Create_Controller_User(String Emailtext,String Firstnametext,String Lastnametext,String IDtext ) {
		Emailtxt(Emailtext);
		Firstnametxt(Firstnametext);
		Lastnametxt(Lastnametext);
		IDtxt(IDtext);
		isAdminChkBox();
	}
	public void Create_Exataker_User(String Emailtext,String Firstnametext,String Lastnametext,String IDtext, String Location, String Yeartext, String Monthtext, String Datetext ) {
		Emailtxt(Emailtext);
		Firstnametxt(Firstnametext);
		Lastnametxt(Lastnametext);
		IDtxt(IDtext);
		PLoc(Location);
		DOBtxt(Yeartext, Monthtext, Datetext);

	}
	public void Create_proctor_User(String Emailtext,String Firstnametext,String Lastnametext,String IDtext, String Location ) {
		Emailtxt(Emailtext);
		Firstnametxt(Firstnametext);
		Lastnametxt(Lastnametext);
		IDtxt(IDtext);
		PLoc(Location);
	}
	public void createloginbtn()
	{
		StaticWait(1);
		waitForElement(createloginbtn);
		driver.findElement(createloginbtn).click();
	}
	public void DOBtxt(String Yeartxt, String Monthtxt, String Datetxt)
	{
		driver.findElement(DOBtxt).click();
		driver.findElement(year).click();
		WebElement y=driver.findElement(By.xpath("//div[text()=' "+Yeartxt+" ']"));
		y.click();
		WebElement m=driver.findElement(By.xpath("//div[text()=' "+Monthtxt+" ']"));
		m.click();
		WebElement d=driver.findElement(By.xpath("//div[text()=' "+Datetxt+" ']"));
		d.click();

	}
	public void Editbtn()
	{
		StaticWait(1);
		waitForElement(Editbtn);
		driver.findElement(Editbtn).click();
	}
	public void editsavebtn()
	{
		waitForElement(editsavebtn);
		StaticWait(1);
		WebElement e=driver.findElement(editsavebtn);
		Actions a=new Actions(driver);
		a.moveToElement(e).click().build().perform();
		StaticWait(2);
	}
	public void Emailtxt(String Emailtext)
	{
		StaticWait(1);
		driver.findElement(Emailtxt).sendKeys(Emailtext);
	}
	public void Examtakersbtn()
	{
		waitForElement(Examtakerbtn);
		driver.findElement(Examtakerbtn).click();
	}
	public void Firstnametxt(String Firstnametext)
	{
		driver.findElement(Firstnametxt).sendKeys(Firstnametext);
	}
	public void IDtxt(String IDtext)
	{
		StaticWait(1);
		driver.findElement(IDtxt).sendKeys(IDtext);
	}
	public void isAdminChkBox()
	{
		driver.findElement(isAdminChkBox).click();;
	}
	public void Lastnametxt(String Lastnametext)
	{
		driver.findElement(Lastnametxt).sendKeys(Lastnametext);
	}
	public void PLoc(String Location)
	{
		driver.findElement(proctorLoc).click();
		WebElement e=driver.findElement(By.xpath("//span[text()='"+Location+"']"));
		StaticWait(1);
		JavascriptExecutor j=(JavascriptExecutor)getDriver();
		j.executeScript("arguments[0].click()", e);
	}
	public void proctor()
	{
		WebElement e1=driver.findElement(proctor);
		Actions a=new Actions(driver);
		a.moveToElement(e1).click().build().perform();
	}
	public void Proctorbtn()
	{
		waitForElement(Proctorbtn);
		driver.findElement(Proctorbtn).click();
	}
	public void provisioning()
	{
		WebElement e = driver.findElement(provisioning);
		JavascriptExecutor j=(JavascriptExecutor)getDriver();
		j.executeScript("arguments[0].click()", e);
	}
	public void reset()
	{
		waitForElement(reset);
		driver.findElement(reset).click();
	}

	public void resetbtn()
	{
		waitForElement(resetbtn);
		driver.findElement(resetbtn).click();
	}
	public void savebtn()
	{
		driver.findElement(savebtn).click();
		waitForPageLoad();
		StaticWait(2);
	}
	public void searchtxt(String Firstnametext,String Lastnametext) 
	{   
		waitForElement(searchtxt);
		WebElement e = driver.findElement(searchtxt);
		JavascriptExecutor j=(JavascriptExecutor)getDriver();
		j.executeScript("arguments[0].click()", e);
		StaticWait(1);
		e.sendKeys(Lastnametext+" ");
		StaticWait(2);
		e.sendKeys(Firstnametext);
		StaticWait(2);
		WebElement EN=driver.findElement(By.xpath("//span[text()='"+Lastnametext+" "+Firstnametext+"']"));
		Actions a=new Actions(driver);
		a.moveToElement(EN).click().build().perform();
	}
	public void Yes()
	{
		waitForElement(yes);
		driver.findElement(yes).click();
	}
}
