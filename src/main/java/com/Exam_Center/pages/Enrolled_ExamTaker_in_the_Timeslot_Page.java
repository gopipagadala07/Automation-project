package com.Exam_Center.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.FP_Examcenter.util.ActionType;

public class Enrolled_ExamTaker_in_the_Timeslot_Page extends ActionType
{
	private WebDriver driver;
	
	private By Unassigned_Toggle = By.xpath("(//input[@type='search'])[1]/../../../../../../following-sibling::div/mat-slide-toggle/label/span/span");
	private By Add = By.xpath("//mat-icon[text()='add']");
	private By Comment = By.xpath("//mat-icon[text()='comment']");
	private By Comment_Textbox = By.xpath("//div[@role='textbox']");
	private By Save_button = By.xpath("//span[text()=' Save ']");
	private By remove_button = By.xpath("//mat-icon[text()='remove']");
	
	public Enrolled_ExamTaker_in_the_Timeslot_Page(WebDriver driver)
	{
		this.driver = driver;
	}

	public void add_Examtaker()
	{
		StaticWait(3);
		driver.findElement(Unassigned_Toggle).click();
		StaticWait(1);
		if(driver.findElement(Add).isEnabled())
		{
			driver.findElement(Add).click();
		}	
	}
	public void p_comment()
	{
		StaticWait(1);
		driver.findElement(Comment).click();
		StaticWait(1);
		driver.findElement(Comment_Textbox).sendKeys("Procter comment");
		driver.findElement(Save_button).click();
	}
	public void remove_the_examtaker()
	{
		driver.findElement(remove_button).click();
	}
	
}
