package com.Examcenter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Examcenter.Utils.ActionType;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class Enrolled_ExamTaker_in_the_Timeslot_Page extends ActionType
{
	private WebDriver driver;
	//private By Unassigned_Toggle = By.xpath("(//input[@type='search'])[1]/../../../../../../following-sibling::div/mat-slide-toggle/label/span/span");
	private By Add = By.xpath("//mat-icon[text()='add']");
	
	private By close_bttn = By.xpath("//button[@aria-label='close dialog']");
	private By Comment = By.xpath("//div[@class='matFabIcons']/button[1]");
	private By Comment_Textbox = By.xpath("//fp-ckeditor[@editorid='descriptionField']/div/div/div[2]");

	private By ET_Entry_details_button= By.xpath("//mat-icon[text()='computer']");
	private By List_cells= By.xpath("//table[@id='tblEntryDetails']/tbody/tr[1]/td");
	private By List_rows = By.xpath("//table[@id='tblEntryDetails']/tbody/tr");
	private By remove_button = By.xpath("//mat-icon[text()='remove']");
	private By Reset_buttton = By.xpath("//mat-icon[text()='settings_backup_restore']");
	private By Save_button = By.xpath("//span[text()=' Save ']");
	private By Token_no = By.xpath("(//input[@type='search'])[2]/../../../../../../../following-sibling::div/mat-list/div/mat-list-item/span/div/div/div/small/small");
	private By Yes_buttton = By.xpath("//button[text()='Yes, Please Reset!']");
	
	
	
	public Enrolled_ExamTaker_in_the_Timeslot_Page(WebDriver driver)
	{
		this.driver = driver;
	}

	public void add_Examtaker()
	{
//		StaticWait(3);
//		driver.findElement(Unassigned_Toggle).click();
		StaticWait(1);
		if(driver.findElement(Add).isEnabled())
		{
			driver.findElement(Add).click();
			StaticWait(2);
		}	
	}
	public void ET_Entry_details()
	{
		StaticWait(1);
		driver.findElement(ET_Entry_details_button).click();
		List<WebElement> rows =  driver.findElements(List_rows);
		int ri = rows.size();
		//System.out.println(ri);
		if(ri>1)				
		{
				String s = null;
				for (int i = 1;i<=ri;i++) 
				{
					List<WebElement> cells = driver.findElements(List_cells);
					int di = cells.size();
					ExtentCucumberAdapter.addTestStepLog("Ip Address and Entry/Reentry Times : ");
					//System.out.println("Ip Address and Entry/Reentry Times : ");
							for (int j = 1;j<=di;j++)
							{
								s=driver.findElement(By.xpath("//table[@id='tblEntryDetails']/tbody/tr["+i+"]/td["+j+"]")).getText();
								//System.out.print("Ip Address and Entry/Reentry Times : "+s+ "   ");							
							}
							String Ed = (s+" ---- "+s);
							//System.out.println("**************************");
							ExtentCucumberAdapter.addTestStepLog(Ed+ "   ");
				}
		}
		else 
		{
			//System.out.println("Exam Taker still not started the Exam !!!!!!!!");
			ExtentCucumberAdapter.addTestStepLog("!!!!!!!!!  Exam Taker still not started the Exam  !!!!!!!!");
		}		
		StaticWait(1);
		WebElement ele = driver.findElement(close_bttn);
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();		
	}
	public void p_comment(String Procter_comment)
	{
		StaticWait(1);	
		WebElement ele=driver.findElement(Comment);
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
		StaticWait(2);
		WebElement e=driver.findElement(Comment_Textbox);
		act.moveToElement(e).build().perform();
		act.click(e).build().perform();
		StaticWait(2);
		e.sendKeys(Procter_comment);
		driver.findElement(Save_button).click();
	}
	public void remove_the_examtaker()
	{
		driver.findElement(remove_button).click();
	}
	public void Reset_the_Examination()
	{
		
		String Token_number1= driver.findElement(Token_no).getText();
		//System.out.println("The Previous Token Number: "+Token_number);
		ExtentCucumberAdapter.addTestStepLog("The Previous Token Number: "+Token_number1);		
		driver.findElement(Reset_buttton).click();
		driver.findElement(Yes_buttton).click();
		StaticWait(2);
		String Token_number2= driver.findElement(Token_no).getText();
		//System.out.println("The Current Token Number: "+Token_number);
		ExtentCucumberAdapter.addTestStepLog("The Current Token Number: "+Token_number2);
	}
}
