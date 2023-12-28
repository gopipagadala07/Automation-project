package Com.Examcenter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Com.Examcenter.Utils.ActionType;

public class ExamtakerSubmissionPage extends ActionType{

	private WebDriver driver;
	
	By examinationbtn=By.xpath("//span[text()='Examinations']");
	By searchheretxt=By.xpath("//input[@type='search']");
	By launchbtn=By.xpath("//span[text()=' Launch ']");
	By tokentxt=By.xpath("//input[@type='password']");
	By validatebtn=By.xpath("//button[@aria-label='Validate']");
	By begintest=By.xpath("//button[@aria-label='Begin Test']");
	By Qcount=By.xpath("//div[@id='navigationSideMenu']/ul/li/p/button");
//	By Answer=By.xpath("//li[contains(@id,'B')]");
	By Answer=By.xpath("//li[@class='qti_readaloud blackColorScheme normalFontSize'][2]");
	By nextbtn=By.xpath("//button[@aria-label='Next']");
	By finish=By.xpath("(//button[text()='Finish'])[3]");
	By Submit=By.xpath("//button[text()='Submit']");
	By close=By.xpath("//mat-icon[text()='close']");
	By statusband=By.xpath("//b[text()='Performance']/../span/span");
	By logout=By.xpath("//span[text()='logout']");
	By returnbtn=By.xpath("//button[@value='login']");
	public ExamtakerSubmissionPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void examinationbtn()
	{
		waitForElement(examinationbtn);
		driver.findElement(examinationbtn).click();
	}
	public void searchheretxt(String Examname, String ScheduleName)
	{
		waitForElement(searchheretxt);
		driver.findElement(searchheretxt).sendKeys(Examname+" - "+ScheduleName);
		StaticWait(2);
		WebElement element=driver.findElement(By.xpath("//b[text()='"+Examname+" - "+ScheduleName+"']"));
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()",element);
		
	}
	public void launchbtn()
	{
		waitForElement(launchbtn);
		WebElement e1=driver.findElement(launchbtn);
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()",e1);
		driver.switchTo().frame(0);
	}
	public void tokentxt(String Token)
	{
		waitForElement(tokentxt);
		driver.findElement(tokentxt).sendKeys(Token);
	}
	public void validatebtn()
	{
		waitForElement(validatebtn);
		driver.findElement(validatebtn).click();
	}
	public void begintest()
	{
		waitForElement(begintest);
		driver.findElement(begintest).click();		
	}
	public void Answers()
	{
		List<WebElement> Count = driver.findElements(Qcount);
		//System.out.println(Count.size());
		for(int i=1;i<=Count.size();i++)
		{
			waitForElement(Answer);
			WebElement e=driver.findElement(Answer);
			JavascriptExecutor j=(JavascriptExecutor) driver;
			j.executeScript("arguments[0].click()",e);
			StaticWait(1);
			driver.findElement(nextbtn).click();
		}
	}
	public void Finish()
	{
		driver.findElement(finish).click();
		waitForElement(Submit);
		StaticWait(1);
		driver.findElement(Submit).click();
		StaticWait(1);
	}
	public void close()
	{
		driver.switchTo().defaultContent();
		driver.findElement(close).click();
	}
	public void statusband()
	{
		String band=driver.findElement(statusband).getText();
		System.out.println(band);
	}
	public void logout()
	{
		driver.findElement(logout).click();
		driver.findElement(returnbtn).click();
	}
}
