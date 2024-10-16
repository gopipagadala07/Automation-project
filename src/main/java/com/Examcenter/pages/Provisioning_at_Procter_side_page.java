package com.Examcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Utils.ActionType;

public class Provisioning_at_Procter_side_page extends ActionType
{
private WebDriver driver;
	
	By Adminstrationbtn=By.xpath("//mat-icon[text()=' settings ']");
	By provisioning=By.xpath("//a[text()='Provisioning']");
	By Examtakerbtn=By.xpath("//div[text()='EXAM TAKERS']");
	By Addnewbtn=By.xpath("//span[text()=' Add New ']");
	By Emailtxt=By.xpath("(//input[@type='text'])[1]");
    By Firstnametxt=By.xpath("(//input[@type='text'])[2]");
    By Lastnametxt=By.xpath("(//input[@type='text'])[3]");
    By IDtxt=By.xpath("(//input[@type='text'])[4]");
    By DOBtxt=By.xpath("//button[@aria-label='Open calendar']");
    By year=By.xpath("//button[@aria-label='Choose month and year']");
    By savebtn=By.xpath("//span[text()=' Save ']");
    By searchtxt=By.xpath("//input[@data-placeholder='search here']");
    By Editbtn=By.xpath("//mat-icon[text()='edit']");
    By createloginbtn=By.xpath("//span[text()=' Create New Login ']");
    By resetbtn=By.xpath("//span[text()=' Reset Password ']");
    By reset=By.xpath("//span[text()=' Reset ']");
    By yes=By.xpath("//button[text()='Reset']");
    By editsavebtn=By.xpath("//span[text()=' Save ']");
    By EC_Loc=By.xpath("//fp-textbox[@controlname='localStateID']/../div");    
    public Provisioning_at_Procter_side_page(WebDriver driver)
    {
    	this.driver=driver;
    }
    
    public void Adminstarationbtn()
    {
    	driver.findElement(Adminstrationbtn).click();
    	StaticWait(1);
    	
    }
    public void provisioning()
    {
    	waitForElement(provisioning);
    	driver.findElement(provisioning).click();
    }

    public void Examtakersbtn()
    {
    	waitForElement(Examtakerbtn);
    	driver.findElement(Examtakerbtn).click();
    }
    public void E_Loc(String Location)
    {
    	driver.findElement(EC_Loc).click();
    	WebElement e=driver.findElement(By.xpath("//span[text()='"+Location+"']"));
        StaticWait(1);
        JavascriptExecutor j=(JavascriptExecutor)getDriver();
        j.executeScript("arguments[0].click()", e);
    }
    public void Addnewbtn()
    {
    	waitForElement(Addnewbtn);
    	StaticWait(1);
    	driver.findElement(Addnewbtn).click();
    }
    public void Emailtxt(String Emailtext)
    {
    	StaticWait(1);
    	driver.findElement(Emailtxt).sendKeys(Emailtext);
    }
    public void DOBtxt(String Yeartxt, String Monthtxt, String Datetxt)
    {
    	StaticWait(1);
    	driver.findElement(DOBtxt).click();
    	StaticWait(1);
    	driver.findElement(year).click();
    	WebElement y=driver.findElement(By.xpath("//div[text()=' "+Yeartxt+" ']"));
    	y.click();
    	WebElement m=driver.findElement(By.xpath("//div[text()=' "+Monthtxt+" ']"));
    	m.click();
    	WebElement d=driver.findElement(By.xpath("//div[text()=' "+Datetxt+" ']"));
    	d.click();
    	
    }
    public void Firstnametxt(String Firstnametext)
    {
    	StaticWait(1);
    	driver.findElement(Firstnametxt).sendKeys(Firstnametext);
    }
    public void Lastnametxt(String Lastnametext)
    {
    	StaticWait(1);
    	driver.findElement(Lastnametxt).sendKeys(Lastnametext);
    }
    public void IDtxt(String IDtext)
    {
    	StaticWait(1);
    	driver.findElement(IDtxt).sendKeys(IDtext);
    }

    public void savebtn()
    {
    	driver.findElement(savebtn).click();
    }
    public void searchtxt(String Firstnametext,String Lastnametext) 
    {   
    	StaticWait(2);
    	WebElement e = driver.findElement(searchtxt);
    	e.click();
    	StaticWait(1);
    	e.sendKeys(Lastnametext+" "+Firstnametext);
    	e.sendKeys(Keys.ENTER);
    }
    public void Editbtn()
    {
    	StaticWait(5);
    	waitForElement(Editbtn);
    	driver.findElement(Editbtn).click();
    }
    public void createloginbtn()
    {
    	StaticWait(2);
    	waitForElement(createloginbtn);
    	driver.findElement(createloginbtn).click();
    }
    public void resetbtn()
    {
    	waitForElement(resetbtn);
    	driver.findElement(resetbtn).click();
    }
    public void reset()
    {
    	waitForElement(reset);
    	driver.findElement(reset).click();
    }
    public void Yes()
    {
    	waitForElement(yes);
    	driver.findElement(yes).click();
    }
    public void editsavebtn()
    {
    	waitForElement(editsavebtn);
    	 StaticWait(2);
    	driver.findElement(editsavebtn).click();
    	 StaticWait(2);
    }
    

    public void Create_Exataker_User(String Emailtext,String Firstnametext,String Lastnametext,String IDtext, String Location, String Yeartext, String Monthtext, String Datetext ) {
    	Emailtxt(Emailtext);
    	Firstnametxt(Firstnametext);
    	Lastnametxt(Lastnametext);
    	IDtxt(IDtext);
    	E_Loc(Location);
    	DOBtxt(Yeartext, Monthtext, Datetext);
    	
    }
}
