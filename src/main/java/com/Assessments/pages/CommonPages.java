package com.Assessments.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import com.Utils.ActionType;
import com.Utils.Wait;

public class CommonPages extends ActionType{
	private Wait wait;

	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Save')]")
	public WebElement Savebtn;
    @FindBy(how = How.XPATH,using="//input[contains(@type, 'search')]")private WebElement searchInputs;
	@FindBy(how = How.XPATH,using="//button[@aria-label='Choose month and year']")
	public WebElement yearSelection;
	@FindBy(how = How.XPATH,using="//button[@aria-label='Choose date']")
	public WebElement MonthSelection;
	@FindBy(how = How.XPATH,using="//input[@form='pageIndex']")
	public WebElement searchforTest;

	public WebElement DateValue(String ValueSelection)
	{
		String xpath="//div[contains(text(),' "+ValueSelection+" ' )]";
		return driver.findElement(By.xpath(xpath));
	}
	@FindBy(how=How.XPATH,using = "//fp-textbox[@placeholder='Name']/div/mat-form-field/div/div/div/input")
	private WebElement Name;
	
	public CommonPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new Wait(driver);
	}
	public void Save()
	{
		wait.elementToBeClickable(Savebtn);
		wait.visibilityOf(Savebtn);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", Savebtn);
		//Savebtn.click();
	}
	public void Name(String Value)
	{
		wait.elementToBeClickable(Name);
		Name.sendKeys(Value);
	}
	public void searchField(String value) {
        wait.visibilityOf(searchInputs);
        searchInputs.sendKeys(value);
        StaticWait(1);
    }
	public void SearchTestname (String TestName) {
		wait.elementToBeClickable(searchforTest);
		searchforTest.sendKeys(TestName);
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
	public void InsertdataIntoExcel(String Path, String Sheet, String Schoolname, String ClassroomName, String SectionName) throws Exception, IOException
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
	private static String getMonthName(int month) {
		String[] monthNames = {
				"JAN", "FEB", "MAR", "APR",
				"MAY", "JUN", "JUL", "AUG",
				"SEP", "OCT", "NOV", "DEC"
		};
		return monthNames[month - 1];
	}
	public void getRandomDate(WebElement element)
	{
		LocalDate currentDate = LocalDate.now();
		Random random = new Random();
		int randomYear = currentDate.getYear() + 1 + random.nextInt(5);
		int randomMonth = 1 + random.nextInt(12); 
		LocalDate randomFutureDate = LocalDate.of(randomYear, randomMonth, 1);
		int randomDay = 1 + random.nextInt(randomFutureDate.lengthOfMonth());
		element.click();
		yearSelection.click();
		DateValue(String.valueOf(randomYear)).click();
		//MonthSelection.click();
		DateValue(getMonthName(randomMonth)).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", DateValue(String.valueOf(randomDay)));
		//DateValue(String.valueOf(randomDay)).click();

	}
}
