package com.Fp_Examcenter.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Fp_Examcenter.Utils.ActionType;


public class EC_Loginpage extends ActionType {
   
	private WebDriver driver;
	
    private By pleaselogintoapp =By.xpath("//div[@class='text-center m-b-md']");
    private By Enterusername =By.xpath("//input[@id='Username']");
    private	By EnterPassword = By.xpath("//input[@id='Password']");
    private By Loginbutton =By.xpath("//button[@value='login']");
    private By Forgotpassword = By.linkText("Forgot password");
    private By Remembermylogincheckbox =By.xpath("//input[@type='checkbox']");
	private By focalpointlogo = By.xpath("//img[@alt='FocalpointK12 inc.']");
	
public EC_Loginpage(WebDriver driver) {
		this.driver = driver;
	}

	public void pleaselogintoapp() {
	
	}
	
	public void enterUsername(String un) {
		driver.findElement(Enterusername).sendKeys(un);
		generateInfoReport("Username : " + un);
	}

//	public void enterUsername(String un, String user) {
//		driver.findElement(Enterusername).sendKeys(un);
//		generateInfoReport(user + " enters username as: " + un);
//	}

	public void enterPassword(String pwd) {
		driver.findElement(EnterPassword).sendKeys(pwd);
		generateInfoReport("Password : " + pwd);
		
	}
//	public void enterPassword(String pwd, String user) {
//		driver.findElement(EnterPassword).sendKeys(pwd);
//		generateInfoReport(user + " enters password as: " + pwd);
//	}
	
	public void clickOnLogin() {
		driver.findElement(Loginbutton).click();
	}
//	public void clickOnLogin(String user) {
//		driver.findElement(Loginbutton).click();
//		generateInfoReport(user + " click on login in button.");
//	}
	
//	public void user_login(String un, String pwd, String user) {
//		enterUsername(un, user);
//		enterPassword(pwd, user);
//		clickOnLogin(user);
//	//	return new HomePage(driver);
//	}
//	
	public  void login(String un, String pwd) {
		enterUsername(un);
		enterPassword(pwd);
		clickOnLogin();
	//	return new HomePage(driver);
	}
//	public String getPageTitle() {
//		return driver.getTitle();
//	}
//	public void allFieldsDispayed() {
//		isElementPresent(pleaselogintoapp, "Please Login to app");
//		isElementPresent(Forgotpassword, "Forgot password link");
//		isElementPresent(Remembermylogincheckbox, "Checkbox");
//		isElementPresent(focalpointlogo, "Focalpoint logo");
//	}
}