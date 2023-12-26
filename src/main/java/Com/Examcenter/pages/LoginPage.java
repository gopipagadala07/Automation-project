package Com.Examcenter.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Com.Examcenter.Utils.ActionType;


public class LoginPage extends ActionType{

	private WebDriver driver;
	
	private	By loginToAppText = By.xpath("//div[@class='text-center m-b-md']/h3");
	private	By username=By.xpath("//input[@id='Username']");
	private	By password=By.xpath("//input[@id='Password']");
	private	By Login=By.xpath("//button[@value='login']");
	private	By forgotPassword=By.xpath("//a[text()='Forgot password']");
	private	By rememeberchkbox=By.xpath("//input[@type='checkbox']");
	private By header=By.xpath("//h2[@class='page-title section-header m-0']");
	
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
		StaticWait(4);
	}
	public void header()
	{
		StaticWait(4);
		waitForElement(header);
		WebElement Header=driver.findElement(header);
		String text=Header.getText();
		
		if(text.equals("Manage Exam Center"))
		{
			System.out.println("Controller login is working Successfully..!!");
		}
		else if(text.equals("Enrollments")) 
		{
			System.out.println("Proctor login is working Successfully..!!");
		}
		else if(text.equals("Examinations"))
		{
			System.out.println("Examtaker login is working Successfully..!!");
		}
	}
	public void allFieldsDispayed() {
		isElementPresent(loginToAppText, "Login to app text");
		isElementPresent(forgotPassword, "Forgot password");
		isElementPresent(rememeberchkbox, "Remember my login");
	}
}
