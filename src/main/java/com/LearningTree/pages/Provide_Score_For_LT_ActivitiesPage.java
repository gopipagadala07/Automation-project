package com.LearningTree.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Base;
import com.Utils.Wait;

public class Provide_Score_For_LT_ActivitiesPage
{
	private WebDriver driver;
	private Wait wait;
	CommonPages cp=new CommonPages(Base.getDriver());
	
	@FindBy(how = How.XPATH,using = "//button[@mattooltip='Activites To Grade']")private WebElement TitleName;

	
	
	public Provide_Score_For_LT_ActivitiesPage(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}
	public void click_on_Overal_Speed_Grader()
	{
		
	}
}
