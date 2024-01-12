package com.Fp_Examcenter.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	//private By C_password=By.xpath("//h3[text()='Change Password']");
	//private By close=By.xpath("//mat-icon[text()='close']");
	
public EC_Loginpage(WebDriver driver) {
		this.driver = driver;
	}

	public void pleaselogintoapp() {
	}
	
	public void enterUsername(String un) {
		driver.findElement(Enterusername).sendKeys(un);
		generateInfoReport("Username : " + un);
	}
	
//	public void enterUsername(String firstname,String lastname,String tenantid) {
//		driver.findElement(Enterusername).sendKeys(firstname);
//		driver.findElement(Enterusername).sendKeys(lastname);
//		driver.findElement(Enterusername).sendKeys(tenantid);	
//	}

	public void enterPassword(String pwd) {
		driver.findElement(EnterPassword).sendKeys(pwd);
		generateInfoReport("Password : " + pwd);		
	}
	
	public void clickOnLogin() {
		driver.findElement(Loginbutton).click();
	}
	
//	public void changepassword_closepopup() 
//	{ 
//	WebElement Cp1 = driver.findElement(C_password);
//	
//	if(driver.findElement(C_password).isDisplayed())
//	{
//		driver.findElement(close).click();
//	}
//	else {
//		
//	}	
//}

	public void login(String un, String pwd) {
		enterUsername(un);
		enterPassword(pwd);
		clickOnLogin();
	}
//	public void login(String firstname, String lastname, String tenantid, String pwd) {
//		enterUsername(firstname, lastname, tenantid);
//		enterPassword(pwd);
//		clickOnLogin();
//		changepassword_closepopup();
//	}

	public void allFieldsDispayed() {
		isElementPresent(pleaselogintoapp, "Please Login to app");
		isElementPresent(Forgotpassword, "Forgot password link");
		isElementPresent(Remembermylogincheckbox, "Checkbox");
		isElementPresent(focalpointlogo, "Focalpoint logo");
	}
}