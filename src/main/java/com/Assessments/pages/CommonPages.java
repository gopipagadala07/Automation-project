package com.Assessments.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.Wait;

public class CommonPages extends ActionType{
	//SISProvisioningPage provisioning=new SISProvisioningPage(Base.getDriver());
	private Wait wait;

	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Save')]")
	public WebElement Savebtn;
	@FindBy(how = How.XPATH,using="//input[contains(@type,'search')]")
	public WebElement Searchhere;

	public CommonPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}

	public void FPdropdown(WebElement element, String visibleText) {
		try {
			wait.elementToBeClickable(element);
			element.click();
			List<WebElement> options =element.findElements(By.xpath("following::div[@role='listbox']/mat-option"));
			for(WebElement option:options) {
				String actual = option.getText().trim();
				//	System.out.println(actual);
				if(actual.equals(visibleText)) {
					Actions a=new Actions(driver);
					a.moveToElement(option);
					option.click();
					//option.sendKeys(Keys.TAB);
					break;
				}		
			}
		} catch (Exception e) {
			SoftAssert soft =new SoftAssert();
			soft.fail();
			e.printStackTrace();
		}	
	}

	public void Save()
	{
		wait.elementToBeClickable(Savebtn);
		StaticWait(1);
		Savebtn.click();
	}
	public void searchField(String Value)
	{
		StaticWait(1);
		wait.visibilityOf(Searchhere);
		Searchhere.sendKeys(Value);
		StaticWait(2);
	}
	public void InsertdataIntoExcel(String Path, String Sheet, String Schoolname, String ClassroomName, String SectionName) throws Exception
	{
		FileInputStream f=new FileInputStream(Path);
		Workbook wb = WorkbookFactory.create(f);
		CellStyle cs=wb.createCellStyle();
		cs.setVerticalAlignment(VerticalAlignment.CENTER);
		cs.setAlignment(HorizontalAlignment.CENTER);
		cs.setBorderBottom(BorderStyle.THIN);
		cs.setBorderRight(BorderStyle.THIN);
		Sheet sh=wb.getSheet(Sheet);
		String[] data = {Schoolname, ClassroomName, SectionName};
		Row row = sh.getRow(1); 
		for (int colNum = 0; colNum < data.length; colNum++) {
			Cell cell = row.createCell(colNum);	                      
			cell.setCellValue(data[colNum]);  
			cell.setCellStyle(cs); 
		}
		FileOutputStream fileOut = new FileOutputStream(Path);
		wb.write(fileOut);

	}
	public void InsertmultipledataIntoExcel(String Path, String Sheet/*, String Schoolname, String ClassroomName, String SectionName*/) throws Exception
	{
		List<String[]> dataToInsert = new ArrayList<>();
		//dataToInsert.add(new String[]{Schoolname, ClassroomName, SectionName});
		dataToInsert.add(new String[]{SISProvisioningPage.DFirstName,String.valueOf(SISProvisioningPage.DLastName)});
		dataToInsert.add(new String[]{SISProvisioningPage.TFirstName,String.valueOf(SISProvisioningPage.TLastName)});
		dataToInsert.add(new String[]{SISProvisioningPage.SFirstName,String.valueOf(SISProvisioningPage.SLastName)});	
		
		FileInputStream f=new FileInputStream(Path);
		Workbook wb = WorkbookFactory.create(f);
		Sheet sh=wb.getSheet(Sheet);
		for (int i = 0; i < dataToInsert.size(); i++) {
			String[] rowData = dataToInsert.get(i);
			Row row = sh.getRow(i + 2);
		if(row==null)
		{
			row = sh.createRow(i + 2);
		}
			for (int j = 0; j < rowData.length; j++) {
				Cell cell = row.getCell(j + 3);
				if (cell == null) {
					cell = row.createCell(j + 3);
				}
				cell.setCellValue(rowData[j]);
			}
		}

		FileOutputStream fileOut = new FileOutputStream(Path);
		wb.write(fileOut);

	}
}
