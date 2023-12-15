package Com.Examcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Com.Examcenter.Utils.ActionType;

public class LoginPage extends ActionType{

	private WebDriver driver;
	
	private	By loginToAppText = By.xpath("//div[@class='text-center m-b-md']/h3");
	private	By username=By.xpath("//input[@id='Username']");
	private	By password=By.xpath("//input[@id='Password']");
	private	By Login=By.xpath("//button[@value='login']");
	private	By forgotPassword=By.xpath("//a[text()='Forgot password']");
	private	By rememeberchkbox=By.xpath("//input[@type='checkbox']");
	private By Logo=By.xpath("//span[text()='FocalPoint']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUsername(String un)
	{
		driver.findElement(username).sendKeys(un);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	public void loginbtn()
	{
		driver.findElement(Login).click();
	}
	
	public void User_login(String username, String password)
	{
		enterUsername(username);
		enterPassword(password);
		loginbtn();
	}
	public void Logo()
	{
		StaticWait(3);
		driver.findElement(Logo).getText();
	}
	public void allFieldsDispayed() {
		isElementPresent(loginToAppText, "Login to app text");
		isElementPresent(forgotPassword, "Forgot password");
		isElementPresent(rememeberchkbox, "Remember my login");
	}
}
