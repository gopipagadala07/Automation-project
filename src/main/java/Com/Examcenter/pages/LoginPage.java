package Com.Examcenter.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Com.Examcenter.Utils.ActionType;


public class LoginPage extends ActionType{

	private WebDriver driver;

	private	By loginToAppText = By.xpath("//div[@class='text-center m-b-md']/h3");
	private	By username=By.xpath("//input[@id='Username']");
	private	By password=By.xpath("//input[@id='Password']");
	private	By Login=By.xpath("//button[@value='login']");
	private	By forgotPassword=By.xpath("//a[text()='Forgot password']");
	private	By rememeberchkbox=By.xpath("//input[@type='checkbox']");
	private By menu=By.xpath("//a[@routerlinkactive='selected']");
	private By changepwd=By.xpath("//h3[text()='Change Password']");
	private By coun=By.xpath("//mat-toolbar[@id='appHeader']");
	private By close=By.xpath("//mat-icon[text()='close']");
	private By fp=By.xpath("//span[text()='FocalPoint']");
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void enterUsername(String FT,String LT, String Tid)
	{
		driver.findElement(username).sendKeys(FT+"."+LT+"."+Tid);
	}

	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
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
	public void header()
	{
		List<WebElement> Header=driver.findElements(menu);
		WebElement cng=driver.findElement(changepwd);
		WebElement cls=driver.findElement(close);
		
		if(cng.isDisplayed())
		{
			cls.click();
			StaticWait(3);
		}
		else
		{
			
		}
		waitForElement(menu);

		int n=Header.size();

		if(n==8)
		{
			System.out.println("Controller login is working Successfully..!!");
		}
		else if(n==4) 
		{
			System.out.println("Proctor login is working Successfully..!!");
		}
		else if(n==1)
		{
			System.out.println("Examtaker login is working Successfully..!!");
		}

	}
	public void allFieldsDispayed() {
		waitForPageLoad();
		isElementPresent(loginToAppText, "Login to app text");
		isElementPresent(forgotPassword, "Forgot password");
		isElementPresent(rememeberchkbox, "Remember my login");
	}
}
