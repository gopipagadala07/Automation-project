package com.PortfolioCenter.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.Utils.ActionType;
import com.Utils.Base;
//import com.cucumber.utility.Wait;

import com.Utils.Wait;


public class CommonPages extends ActionType{
	private Wait wait;

	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Save')]")
	public WebElement Savebtn;
    @FindBy(how = How.XPATH,using="//input[contains(@type, 'search')]")private WebElement searchInputs;
    @FindBy(how = How.XPATH,using="(//input[contains(@type, 'search')])[1]")private WebElement searchInput1;
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
	
	public void Screensize() {
		Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL) 
               .sendKeys(Keys.SUBTRACT)
               .keyUp(Keys.CONTROL)
               .perform(); 
		
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
	}
	public void Name(String Value)
	{
		wait.elementToBeClickable(Name);
		StaticWait(2);
		Name.sendKeys(Value);
	}
	public void searchField(String value) {
        wait.visibilityOf(searchInputs);
        searchInputs.sendKeys(value);
        StaticWait(1);
    }
	
	public void searchField2(String value) {
        wait.visibilityOf(searchInput1);
        searchInput1.sendKeys(value);
        StaticWait(1);
    }
	
	public void SearchTestname (String TestName) {
		wait.elementToBeClickable(searchforTest);
		searchforTest.sendKeys(TestName);
	}
	public void FPdropdown(WebElement element, String visibleText) {
		try {
			
			wait.elementToBeClickable(element);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			List<WebElement> options =element.findElements(By.xpath("following::div[@role='listbox']/mat-option"));
			for(WebElement option:options) {
				String actual = option.getText().trim();
					//System.out.println(actual);
				if(actual.contains(visibleText)) {
					Actions a=new Actions(driver);
					a.moveToElement(option);
					option.click();
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
	public void getRandomDate(WebElement element) {
	    int maxRetries = 3; 
	    int attempt = 0;
	    boolean success = false;

	    while (attempt < maxRetries && !success) {
	        try {
	            attempt++;
	            LocalDate currentDate = LocalDate.now();
	            Random random = new Random();
	            int randomYear = currentDate.getYear() + 1 + random.nextInt(5);
	            int randomMonth = 1 + random.nextInt(12);
	            LocalDate randomFutureDate = LocalDate.of(randomYear, randomMonth, 1);
	            int randomDay = 1 + random.nextInt(randomFutureDate.lengthOfMonth());
	            element.click(); 
	            yearSelection.click();

	            WebElement yearElement = DateValue(String.valueOf(randomYear));
	            yearElement.click();

	            WebElement monthElement = DateValue(getMonthName(randomMonth));
	            monthElement.click();

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            WebElement dayElement = DateValue(String.valueOf(randomDay));
	            wait.until(ExpectedConditions.elementToBeClickable(dayElement));
	            wait.until(ExpectedConditions.visibilityOf(dayElement));

	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click()", dayElement);
	            success = true;
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("ElementClickInterceptedException on attempt " + attempt + ": " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Exception on attempt " + attempt + ": " + e.getMessage());
	        }

	        if (!success && attempt < maxRetries) {
	            System.out.println("Retrying... Attempt " + (attempt + 1));
	        }
	    }

	    if (!success) {
	        throw new RuntimeException("Failed to select a random date after " + maxRetries + " attempts.");
	    }
	}

	public void CurrentDate(WebElement element) {
		
		try {
			LocalDate currentDate = LocalDate.now();
	        int currentYear=currentDate.getYear();
	        int CurrentMonth=currentDate.getMonthValue();
	        int CurrentDate=currentDate.getDayOfMonth();
	        element.click();
			yearSelection.click();
		
			DateValue(String.valueOf(currentYear)).click();
			//MonthSelection.click();
			
			DateValue(getMonthName(CurrentMonth)).click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
			wait.until(ExpectedConditions.elementToBeClickable(DateValue(String.valueOf(CurrentDate))));
			wait.until(ExpectedConditions.visibilityOf(DateValue(String.valueOf(CurrentDate))));
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", DateValue(String.valueOf(CurrentDate)));

		} catch (ElementClickInterceptedException e) {
			System.out.println("e");
		}
	        
	}
	public void scrollWithRobot() throws AWTException {
	    try {
	        Robot robot = new Robot();
	        for (int i = 0; i < 20; i++) { 
	            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	            robot.keyRelease(KeyEvent.VK_PAGE_DOWN); 
	        }
	    } catch (ElementClickInterceptedException e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void scrollToElementWithRetry(WebElement element) {
	    int retries = 10;
	    while (retries > 0) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].scrollIntoView(true);", element);
	            break; // Exit the loop if the scroll is successful
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Stale Element, retrying...");
	            retries--;
	            if (retries == 0) {
	                System.out.println("Element is stale after retries, failing.");
	            }
	        }
	    }
	}

	
	
	public void scrollToBottomAndClick(WebElement targetElement) {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        int scrollCount = 0;
	        int maxScrollCount = 5;
	        boolean isScrollComplete = false;

	        while (!isScrollComplete && scrollCount < maxScrollCount) {
	         
	            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	            StaticWait(2);

	            try {
	                wait.until(ExpectedConditions.elementToBeClickable(targetElement));
	                js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
	                targetElement.click();
	                isScrollComplete = true;
	            } catch (StaleElementReferenceException e) {
	               
	                System.out.println("StaleElementReferenceException caught, retrying scroll...");
	                scrollCount++;
	            } catch (Exception e) {
	                System.out.println("Exception while clicking the target element: " + e.getMessage());
	                break;
	            }
	        }	       
	        if (!isScrollComplete) {
	            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	            StaticWait(2);
	        }
	    } catch (Exception e) {
	        System.out.println("Error during scroll to bottom: " + e.getMessage());
	    }
	}





public void PortfolioCourseNameInsertmultipledataIntoExcel(String Path, String Sheet/*, String Schoolname, String ClassroomName, String SectionName*/) throws Exception
{
	List<String[]> dataToInsert = new ArrayList<>();
	dataToInsert.add(new String[]{PortfolioCenterCoursePages.PortfolioCourseName});

	FileInputStream f=new FileInputStream(Path);
	Workbook wb = WorkbookFactory.create(f);
	Sheet sh=wb.getSheet(Sheet);
	for (int i = 0; i < dataToInsert.size(); i++) {
		String[] rowData = dataToInsert.get(i);
		Row row = sh.getRow(i + 1);
		if(row==null)
		{
			row = sh.createRow(i + 1);
		}
		for (int j = 0; j < rowData.length; j++) {
			Cell cell = row.getCell(j + 12);
			if (cell == null) {
				cell = row.createCell(j + 12);
			}
			cell.setCellValue(rowData[j]);
		}
	}

	FileOutputStream fileOut = new FileOutputStream(Path);
	wb.write(fileOut);

}




public void PortfolioAssignmentnameInsertmultipledataIntoExcel(String Path, String Sheet/*, String Schoolname, String ClassroomName, String SectionName*/) throws Exception
{
	List<String[]> dataToInsert = new ArrayList<>();
	dataToInsert.add(new String[]{PortfolioCenterCoursePages.assignmentname});

	FileInputStream f=new FileInputStream(Path);
	Workbook wb = WorkbookFactory.create(f);
	Sheet sh=wb.getSheet(Sheet);
	for (int i = 0; i < dataToInsert.size(); i++) {
		String[] rowData = dataToInsert.get(i);
		Row row = sh.getRow(i + 1);
		if(row==null)
		{
			row = sh.createRow(i + 1);
		}
		for (int j = 0; j < rowData.length; j++) {
			Cell cell = row.getCell(j + 14);
			if (cell == null) {
				cell = row.createCell(j + 14);
			}
			cell.setCellValue(rowData[j]);
		}
	}

	FileOutputStream fileOut = new FileOutputStream(Path);
	wb.write(fileOut);

}

public void multiPortfolioCourseNameInsertmultipledataIntoExcel(String Path, String Sheet/*, String Schoolname, String ClassroomName, String SectionName*/) throws Exception
{
	List<String[]> dataToInsert = new ArrayList<>();
	dataToInsert.add(new String[]{MultiScoringPortfolioCoursePages.MultiPortfolioCourseName});

	FileInputStream f=new FileInputStream(Path);
	Workbook wb = WorkbookFactory.create(f);
	Sheet sh=wb.getSheet(Sheet);
	for (int i = 0; i < dataToInsert.size(); i++) {
		String[] rowData = dataToInsert.get(i);
		Row row = sh.getRow(i + 1);
		if(row==null)
		{
			row = sh.createRow(i + 1);
		}
		for (int j = 0; j < rowData.length; j++) {
			Cell cell = row.getCell(j + 16);
			if (cell == null) {
				cell = row.createCell(j + 16);
			}
			cell.setCellValue(rowData[j]);
		}
	}

	FileOutputStream fileOut = new FileOutputStream(Path);
	wb.write(fileOut);

}

public void MultiassignmentnameNameInsertmultipledataIntoExcel(String Path, String Sheet/*, String Schoolname, String ClassroomName, String SectionName*/) throws Exception
{
	List<String[]> dataToInsert = new ArrayList<>();
	dataToInsert.add(new String[]{MultiScoringPortfolioCoursePages.Multiassignmentname});

	FileInputStream f=new FileInputStream(Path);
	Workbook wb = WorkbookFactory.create(f);
	Sheet sh=wb.getSheet(Sheet);
	for (int i = 0; i < dataToInsert.size(); i++) {
		String[] rowData = dataToInsert.get(i);
		Row row = sh.getRow(i + 1);
		if(row==null)
		{
			row = sh.createRow(i + 1);
		}
		for (int j = 0; j < rowData.length; j++) {
			Cell cell = row.getCell(j + 20);
			if (cell == null) {
				cell = row.createCell(j + 20);
			}
			cell.setCellValue(rowData[j]);
		}
	}

	FileOutputStream fileOut = new FileOutputStream(Path);
	wb.write(fileOut);

}



public void InsertdataIntoExcelOne(String path, String sheetName, String Value,int cellnum) throws Exception {
    FileInputStream fis = new FileInputStream(path);
    Workbook wb = WorkbookFactory.create(fis);
    CellStyle cs = wb.createCellStyle();
    cs.setVerticalAlignment(VerticalAlignment.CENTER);
    cs.setAlignment(HorizontalAlignment.CENTER);
    cs.setBorderBottom(BorderStyle.THIN);
    cs.setBorderRight(BorderStyle.THIN);

    Sheet sheet = wb.getSheet(sheetName);
    if (sheet == null) {
        sheet = wb.createSheet(sheetName);
    }

    // Insert data into the specified row and column
    String[] data = {Value};
    for (int i = 0; i < data.length; i++) {
        Row row = sheet.getRow(i + 1); // Row offset (+1 to skip header, if any)
        if (row == null) {
            row = sheet.createRow(i + 1);
        }

        // Insert data into a specific column
        Cell cell = row.getCell(cellnum); // Hardcoded column index 12
        if (cell == null) {
            cell = row.createCell(cellnum);
        }
        cell.setCellValue(data[i]);
        cell.setCellStyle(cs);
    }

    // Write changes back to the Excel file
    FileOutputStream fos = new FileOutputStream(path);
    wb.write(fos);

    // Close resources
    fos.close();
    wb.close();
    fis.close();


}




}






















