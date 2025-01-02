package com.Utils;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
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
import org.openqa.selenium.TimeoutException;
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
import com.Utils.Wait;


public class CommonPages extends ActionType{
	private Wait wait;
	public static int currentHour;
	public static String formattedMin;;
	static int Ehour;
	static int EfutureMinute;
	

	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Save')]")
	public WebElement Savebtn;
	@FindBy(how = How.XPATH,using="//input[@type='search']")private WebElement searchInputs;
	@FindBy(how = How.XPATH,using="//button[@aria-label='Choose month and year']")
	public WebElement yearSelection;
	@FindBy(how = How.XPATH,using="//button[@aria-label='Choose date']")
	public WebElement MonthSelection;
	@FindBy(how = How.XPATH,using="//input[@form='pageIndex']")
	public WebElement searchforTest;

	public WebElement DateValue(String ValueSelection)
	{
		String xpath="//div[text()=' "+ValueSelection+" ' ]";
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
		Name.sendKeys(Value);
	}
	public void searchField(String value) {
		wait.visibilityOf(searchInputs);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(searchInputs));
		wait.until(ExpectedConditions.visibilityOf(searchInputs));
		searchInputs.sendKeys(value);
		searchInputs.clear();
		StaticWait(1);
		searchInputs.sendKeys(value);
		StaticWait(1);
	}
	public void SearchTestname (String TestName) {
		wait.elementToBeClickable(searchforTest);
		searchforTest.sendKeys(TestName);
	}
	  public void FPdropdown(WebElement element, String visibleText) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	            Actions actions = new Actions(driver);
	            actions.moveToElement(element).perform();
	            StaticWait(1);
                JavascriptExecutor js = (JavascriptExecutor) driver;
//                js.executeScript("arguments[0].click();", element);
                actions.click().build().perform();
	            StaticWait(1);
	            List<WebElement> options = element.findElements(By.xpath("following::div[@role='listbox']/mat-option"));
	            for (WebElement option : options) {
	                String actual = option.getText().trim();
	                if (actual.contains(visibleText)) {
	                    try {
	                        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(option));
	                        js.executeScript("arguments[0].scrollIntoView(true);", e);
	                        js.executeScript("arguments[0].click();", e);
	                        break;
	                    } catch (ElementClickInterceptedException ex) {
	                        js.executeScript("arguments[0].scrollIntoView(true);", option);
	                        js.executeScript("arguments[0].click();", option);
	                        break;
	                    }
	                }
	            }
	        } catch (Exception e) {
	            SoftAssert soft = new SoftAssert();
	            soft.fail();
	            e.printStackTrace();
	        }
	    }

	public void InsertdataIntoExcel(String Path, String Sheet, String Value, int colNum) throws Exception, IOException {

		FileInputStream f = new FileInputStream(Path);
		Workbook wb = WorkbookFactory.create(f);
		CellStyle cs = wb.createCellStyle();
		cs.setVerticalAlignment(VerticalAlignment.CENTER);
		cs.setAlignment(HorizontalAlignment.CENTER);
		cs.setBorderBottom(BorderStyle.THIN);
		cs.setBorderRight(BorderStyle.THIN);

		Sheet sh = wb.getSheet(Sheet);
		if (sh == null) {
			sh = wb.createSheet(Sheet);
		}
		Row row = sh.getRow(1); 
		if (row == null) {
			row = sh.createRow(1); 
		}
		Cell cell = row.createCell(colNum);
		cell.setCellValue(Value);
		cell.setCellStyle(cs);

		FileOutputStream fileOut = new FileOutputStream(Path);
		wb.write(fileOut);

		fileOut.close();
		wb.close();
		f.close();       
		System.out.println("Data inserted successfully...!!!");
	}
	public void insertData(String FileName, String Value, int Colnum) throws Exception
	{
		String filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "ExcelFiles", FileName).toString();
		InsertdataIntoExcel(filePath, getSheetEnv(), Value,Colnum);
	}
	public void InsertmultipledataIntoExcel(String Path, String Sheet, String Value1, int Value2, String Value3,int Value4, String Value5, int Value6) throws Exception
	{
		List<String[]> dataToInsert = new ArrayList<>();
		//dataToInsert.add(new String[]{Schoolname, ClassroomName, SectionName});
		dataToInsert.add(new String[]{Value1,String.valueOf(Value2)});
		dataToInsert.add(new String[]{Value3,String.valueOf(Value4)});
		dataToInsert.add(new String[]{Value5,String.valueOf(Value6)});	

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

	public void selectCurrentDate(WebElement element) {
		int maxRetries = 5; 
		int attempt = 0;
		boolean success = false;

		while (attempt < maxRetries && !success) {
			try {
				LocalDate currentDate = LocalDate.now();
				int currentYear = currentDate.getYear();
				int currentMonth = currentDate.getMonthValue();
				int currentDay = currentDate.getDayOfMonth();
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);
				StaticWait(1);
				yearSelection.click();

				WebElement yearElement = DateValue(String.valueOf(currentYear));
				yearElement.click();

				WebElement monthElement = DateValue(getMonthName(currentMonth));
				monthElement.click();

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				WebElement dayElement = DateValue(String.valueOf(currentDay));
				wait.until(ExpectedConditions.elementToBeClickable(dayElement));
				wait.until(ExpectedConditions.visibilityOf(dayElement));

				js.executeScript("arguments[0].click()", dayElement);
				success = true;
			} catch (ElementClickInterceptedException e) {
				System.out.println("ElementClickInterceptedException: " + e.getMessage());
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException: " + e.getMessage());
			} catch (TimeoutException e) {
				System.out.println("TimeoutException: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}

			if (!success) {
				attempt++;
				if (attempt < maxRetries) {
					System.out.println("Retrying... Attempt " + (attempt + 1));
				} else {
					throw new RuntimeException("Failed to select the current date after " + maxRetries + " attempts.");
				}
			}
		}
	}

//	public void selectCurrentTime(WebElement timePickerElement) {
//	    int maxRetries = 3;
//	    int attempt = 0;
//	    boolean success = false;
//
//	    while (attempt < maxRetries && !success) {
//	        try {
//	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	            JavascriptExecutor js = (JavascriptExecutor) driver;
//	            LocalTime currentTime = LocalTime.now();
//	            currentHour = currentTime.getHour();
//	            int currentMinute = currentTime.getMinute();
//	            String formattedMinute = String.format("%02d", currentMinute);
//
//	            System.out.println("Current Time: Hour - " + currentHour + ", Minute - " + formattedMinute);
//	            WebElement e = wait.until(ExpectedConditions.elementToBeClickable(timePickerElement));
//	            js.executeScript("arguments[0].click();", e);
//	            StaticWait(1);
//	            int hourDegree = currentHour * 30;
//	            String hourDegreeTransform = "rotateZ(-" + hourDegree + "deg)";
//	            String hourXpath = "//button[contains(@style,'transform: " + hourDegreeTransform + ";')]";
//	            WebElement hourElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(hourXpath)));
//	            Actions a = new Actions(driver);
//	            a.moveToElement(hourElement).perform();
//	            a.click().build().perform();
//	            StaticWait(1);
//	            int min = (1 + currentMinute) % 60;
//	            formattedMin = String.format("%02d", min);
//	            int minuteDegree = min * 6;
//	            String minuteDegreeTransform = "rotateZ(-" + minuteDegree + "deg)";
//	            String minuteXpath = "//button[contains(@style,'transform: " + minuteDegreeTransform + ";')]";
//	            WebElement minuteElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(minuteXpath)));
//	            a.moveToElement(minuteElement).perform();
//	            a.click().build().perform();
//	            success = true;
//	            System.out.println("Selected Hour: " + currentHour + ", Minute: " + formattedMin);
//	        } catch (ElementClickInterceptedException e) {
//	            System.out.println("ElementClickInterceptedException: " + e.getMessage());
//	        } catch (StaleElementReferenceException e) {
//	            System.out.println("StaleElementReferenceException: " + e.getMessage());
//	        } catch (TimeoutException e) {
//	            System.out.println("TimeoutException: " + e.getMessage());
//	        } catch (Exception e) {
//	            System.out.println("Exception: " + e.getMessage());
//	        }
//
//	        if (!success) {
//	            attempt++;
//	            if (attempt < maxRetries) {
//	                System.out.println("Retrying... Attempt " + (attempt + 1));
//	            } else {
//	                throw new RuntimeException("Failed to select the current time after " + maxRetries + " attempts.");
//	            }
//	        }
//	    }
//	}


	public void selectCurrentTime(WebElement timePickerElement, boolean useIST) {
	    int maxRetries = 3;
	    int attempt = 0;
	    boolean success = false;

	    while (attempt < maxRetries && !success) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            
	            ZonedDateTime currentTime;
	            if (useIST) {
	                currentTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
	                System.out.println("Current IST Time: Hour - " + currentTime.getHour() + ", Minute - " + currentTime.getMinute());
	            } else {
	                currentTime = ZonedDateTime.now(ZoneOffset.UTC);
	                System.out.println("Current UTC Time: Hour - " + currentTime.getHour() + ", Minute - " + currentTime.getMinute());
	            }
	            
	            currentHour = currentTime.getHour();
	            int currentMinute = currentTime.getMinute();
	            String formattedMinute = String.format("%02d", currentMinute);

	            WebElement e = wait.until(ExpectedConditions.elementToBeClickable(timePickerElement));
	            js.executeScript("arguments[0].click();", e);
	            StaticWait(1);
	            
	            int hourDegree = currentHour * 30;
	            String hourDegreeTransform = "rotateZ(-" + hourDegree + "deg)";
	            String hourXpath = "//button[contains(@style,'transform: " + hourDegreeTransform + ";')]";
	            WebElement hourElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(hourXpath)));
	            Actions a = new Actions(driver);
	            a.moveToElement(hourElement).perform();
	            a.click().build().perform();
	            StaticWait(1);
	            
	            int min = (1 + currentMinute) % 60;
	            formattedMin = String.format("%02d", min);
	            int minuteDegree = min * 6;
	            String minuteDegreeTransform = "rotateZ(-" + minuteDegree + "deg)";
	            String minuteXpath = "//button[contains(@style,'transform: " + minuteDegreeTransform + ";')]";
	            WebElement minuteElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(minuteXpath)));
	            a.moveToElement(minuteElement).perform();
	            a.click().build().perform();
	            
	            success = true;
	            System.out.println("Selected Hour: " + currentHour + ", Minute: " + formattedMin);
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("ElementClickInterceptedException: " + e.getMessage());
	        } catch (StaleElementReferenceException e) {
	            System.out.println("StaleElementReferenceException: " + e.getMessage());
	        } catch (TimeoutException e) {
	            System.out.println("TimeoutException: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Exception: " + e.getMessage());
	        }

	        if (!success) {
	            attempt++;
	            if (attempt < maxRetries) {
	                System.out.println("Retrying... Attempt " + (attempt + 1));
	            } else {
	                throw new RuntimeException("Failed to select the current time after " + maxRetries + " attempts.");
	            }
	        }
	    }
	}


	public void selectFutureRandomTime(WebElement timePickerElement, boolean useIST) {
	    int maxRetries = 3;
	    int attempt = 0;
	    boolean success = false;

	    while (attempt < maxRetries && !success) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            Random random = new Random();

	            int additionalMinutes = random.nextInt(60) + 1;
	            ZonedDateTime currentTime;
	            if (useIST) {
	                currentTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
	                System.out.println("Current IST Time: Hour - " + currentTime.getHour() + ", Minute - " + currentTime.getMinute());
	            } else {
	                currentTime = ZonedDateTime.now(ZoneOffset.UTC);
	                System.out.println("Current UTC Time: Hour - " + currentTime.getHour() + ", Minute - " + currentTime.getMinute());
	            }

	            ZonedDateTime futureTime = currentTime.plus(additionalMinutes, ChronoUnit.MINUTES);
	            int futureHour = futureTime.getHour();
	            EfutureMinute = futureTime.getMinute();

	            System.out.println("Future Time: Hour - " + futureHour + ", Minute - " + EfutureMinute);
	            WebElement e = wait.until(ExpectedConditions.elementToBeClickable(timePickerElement));
	            js.executeScript("arguments[0].click();", e);
	            StaticWait(1);
	            Ehour = 1 + futureHour;
	            int hourDegree = Ehour * 30;
	            String hourDegreeTransform = "rotateZ(-" + hourDegree + "deg)";
	            String hourXpath = "//button[contains(@style,'transform: " + hourDegreeTransform + ";')]";
	            WebElement hourElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(hourXpath)));
	            Actions a = new Actions(driver);
	            a.moveToElement(hourElement).perform();
	            a.click().build().perform();
	            StaticWait(1);
	            int minuteDegree = EfutureMinute * 6;
	            String minuteDegreeTransform = "rotateZ(-" + minuteDegree + "deg)";
	            String minuteXpath = "//button[contains(@style,'transform: " + minuteDegreeTransform + ";')]";
	            WebElement minuteElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(minuteXpath)));
	            a.moveToElement(minuteElement).perform();
	            a.click().build().perform();

	            success = true;
	            System.out.println("Selected Future Hour: " + futureHour + ", Minute: " + EfutureMinute);
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("ElementClickInterceptedException: " + e.getMessage());
	        } catch (StaleElementReferenceException e) {
	            System.out.println("StaleElementReferenceException: " + e.getMessage());
	        } catch (TimeoutException e) {
	            System.out.println("TimeoutException: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Exception: " + e.getMessage());
	        }

	        if (!success) {
	            attempt++;
	            if (attempt < maxRetries) {
	                System.out.println("Retrying... Attempt " + (attempt + 1));
	            } else {
	                throw new RuntimeException("Failed to select the future random time after " + maxRetries + " attempts.");
	            }
	        }
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
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale Element, retrying...");
				retries--;
				if (retries == 0) {
					System.out.println("Element is stale after retries, failing.");
				}
			}
		}
	}
}