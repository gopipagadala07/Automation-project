package com.Exam_Center.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Exam_Center.util.ActionType;

public class Login_page extends ActionType
{
	private WebDriver driver;

	private By User_name= By.xpath("//input[@id='Username']");
	private By Password = By.xpath("//input[@id='Password']");
	private By Login_btn=By.xpath("//button[@value='login']");
	private By C_password=By.xpath("//h3[text()='Change Password']");
	private By close=By.xpath("//mat-icon[text()='close']");
	public Login_page(WebDriver driver) 
	{

		this.driver = driver;
	}
	public void enterUsername(String un) {
		driver.findElement(User_name).sendKeys(un);

	}
	public void enterPassword(String pwd) {
		driver.findElement(Password).sendKeys(pwd);

	}
	public void clickOnLogin() {
		driver.findElement(Login_btn).click();;

	}
	public void Close_popup()
	{

		//WebElement Cp1 = driver.findElement(C_password);
//		
//		if(driver.findElement(C_password).isDisplayed())
//		{
//			driver.findElement(close).click();
//		}
//		
	}
	public void user_login(String un, String pwd ) {
		enterUsername(un);
		enterPassword(pwd);
		clickOnLogin();
		Close_popup();
	}


}
