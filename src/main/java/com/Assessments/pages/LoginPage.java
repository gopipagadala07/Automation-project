package com.Assessments.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Utils.ActionType;
import com.Utils.Wait;


public class LoginPage extends ActionType{

	private Wait wait;
	private By close=By.xpath("//button[@type='button']");
	private By changepwd=By.xpath("//h3[text()='Change Password']");
	private By coun=By.xpath("//mat-toolbar[@id='appHeader']");
	private WebDriver driver;
	private	By forgotPassword=By.xpath("//a[text()='Forgot password']");
	private By fp=By.xpath("//span[text()='FocalPoint']");
	private	By Login=By.xpath("//button[@value='login']");
	private	By loginToAppText = By.xpath("//div[@class='text-center m-b-md']/h3");
	private By menu=By.xpath("//a[@routerlinkactive='selected']");
	private	By password=By.xpath("//input[@id='Password']");
	private	By rememeberchkbox=By.xpath("//input[@type='checkbox']");
	private	By username=By.xpath("//input[@id='Username']");
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;

		this.wait=new Wait(driver);
	}

	public void allFieldsDispayed() {
		waitForPageLoad();
		isElementPresent(loginToAppText, "Login to app text");
		isElementPresent(forgotPassword, "Forgot password");
		isElementPresent(rememeberchkbox, "Remember my login");
	}

	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	public void enterUsername(String FT,String LT, String Tid)
	{
		driver.findElement(username).sendKeys(FT+"."+LT+"."+Tid);
	}

	public void header()

    {
        WebElement cls=driver.findElement(close);
            wait.elementToBeClickable(cls);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", cls);     

    }
	public void loginbtn()
	{
		driver.findElement(Login).click();
	}
	public void User_login(String FT,String LT, String Tid, String password)
	{
		enterUsername(FT,LT,Tid);
		enterPassword(password);
		loginbtn();
		StaticWait(4);
	}
}
