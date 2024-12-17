package com.Examcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Utils.ActionType;


public class LoginPage extends ActionType{


	private WebDriver driver;
	private	By forgotPassword=By.xpath("//a[text()='Forgot password']");
	private	By Login=By.xpath("//button[@value='login']");
	private	By loginToAppText = By.xpath("//div[@class='text-center m-b-md']/h3");
	private	By password=By.xpath("//input[@id='Password']");
	private	By rememeberchkbox=By.xpath("//input[@type='checkbox']");
	private	By username=By.xpath("//input[@id='Username']");
	
	//private	By GotIt=By.xpath("//a[text()='Got it!']");
	//private	By YesAllow=By.xpath("//button[text()='Yes, Allow']");
	//private	By closeIcon=By.xpath("//mat-icon[text()='close']");////button[@type='button']
	

	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
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

	public void header() {
		try {
            WebElement idServerAllow = driver.findElement(By.xpath("//button[@value='yes']"));
            if (idServerAllow.isDisplayed()) {
            	JavascriptExecutor js = (JavascriptExecutor) driver;
            	js.executeScript("arguments[0].scrollIntoView(true);", idServerAllow);  
            	js.executeScript("arguments[0].click();", idServerAllow);
                //idServerAllow.click();
            }
        } catch (NoSuchElementException e) {
          
        }
        WebElement cls = driver.findElement(By.xpath("//button[@type='button']"));
        cls.click();
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
