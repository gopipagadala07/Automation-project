package com.Utils;


import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.Utils.UtilityMethods.getException;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;


/**
 * This class has common utility methods
 * 
 * @author anamika.p
 *
 */
public class ActionType extends Base {


	/**
	 * Return env
	 * 
	 * @return
	 */
	public static String getSheetEnv() {

		return env.replace(".", "").toUpperCase();

	}

	public WebDriverWait wait;

	/**
	 * This method used to wait until the required element located in DOM.
	 */
	public boolean fluentWait(final By by) {
		generateInfoReport("	Waiting for element ... " + by.toString());
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofMinutes(2))
					.pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);
			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					WebElement element = driver.findElement(by);
					return element.isDisplayed();
				}
			};
			wait.until(function);
			return getDriver().findElement(by).isDisplayed();
		} catch (Exception e) {
			generateInfoReport("Element not located ... " + by.toString());
			return false;
		}
	}

	public void generateFailReport(boolean condition, String text) {
		Assert.assertTrue(false);
		Logs.error("Failed: " + text);
	}

	public void generateFailReport(String text) {
		Assert.assertTrue(false);
		Logs.error("Failed: " + text);
	}

	public void generateInfoReport(String text) {
		Logs.info("Info: " + text);
	}

	/**
	 * Logs generating methods
	 * 
	 * @param text
	 */
	public void generatePassReport(boolean condition, String text) {
		Assert.assertTrue(true);
		Logs.info("Passed: " + text);
	}

	public void generatePassReport(String text) {
		Assert.assertTrue(true);
		Logs.info("Passed: " + text);
	}

	private void generateReport(boolean status, String text) {
		if (status) {
			generatePassReport(text);
		} else {
			generateFailReport(text);
		}
	}

	/**
	 * Generates pass or fail report based on status flag
	 * 
	 * @param status
	 * @param passText
	 * @param failText
	 */
	public void generateReport(boolean status, String passText, String failText) {
		if (status) {
			generatePassReport(passText);
		} else {
			generateFailReport(failText);

		}
	}

	public void generateWarnReport(String text) {
		Logs.warn("Warning: " + text);
	}

	/**
	 * It return attribute value if object exists otherwise return exception message
	 * 
	 * @param string
	 */
	public String getAttributeValue(By locator, String attributeName) {
		try {
			return getDriver().findElement(locator).getAttribute(attributeName);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * It returns value from property file based on key value
	 * 
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {

		if (prop == null) {
			generateFailReport("Error: Prop should be initialized");
			try {
				initProperties();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return prop.getProperty(key);
	}

	/**
	 * Returns text on element if exists, otherwise returns empty string
	 * 
	 * @param by
	 * @param locator
	 * @return
	 */
	public String getText(By by, String locator) {

		return getText(by, locator, true);
	}

	private String getText(By by, String locator, boolean scrollRequired) {
		try {
			waitForElement(by);
			String text = getDriver().findElement(by).getText().trim();
			generateInfoReport("Text on " + locator + ":" + text);
			return text;
		} catch (Exception e) {
			generateInfoReport("Text on " + locator + " :");
			return "";
		}
	}

	/**
	 * Access application url
	 * 
	 * @param url
	 */
	public void getURL(String url) {

		try {
			Logs.info("Loading URL ... " + url);
			getDriver().get(url);
			waitForPageLoad();
		} catch (Exception e) {
			System.out.println("Failed to load url :" + url + "<br><br>" + getException(e));
		}

	}

	/**
	 * 
	 * @return window title
	 */
	public String getWindowTitle() {
		String title = getDriver().getTitle().trim();
		return title;
	}

	/**
	 * returns true when element is checked on screen Generates report
	 * 
	 * @param by
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean isElementChecked(By by, String locatorName) {
		try {
			fluentWait(by);
			String isChecked = getDriver().findElement(by).getAttribute("checked");
			if (isChecked.equalsIgnoreCase("checked")) {
				generatePassReport(locatorName + " is checked");
				return true;
			} else {
				generateFailReport(locatorName + " not checked");
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * returns true when element is disabled on screen Generates report
	 * 
	 * @param by
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public void isElementDisabled(By by, String locatorName) {
		boolean flag = false;
		try {
			fluentWait(by);
			flag = getDriver().findElement(by).isEnabled();
			if (flag) {
				generatePassReport(locatorName + " is Disabled");
			} else {
				generateFailReport(locatorName + " is Enabled");
			}
		} catch (Exception e) {
			generateFailReport(locatorName + " is Enabled");
		}
	}

	/**
	 * returns true when element is enabled on screen Generates report
	 * 
	 * @param by
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean isElementEnable(By by, String locatorName) {
		boolean flag = false;
		try {
			fluentWait(by);
			flag = getDriver().findElement(by).isEnabled();
			generateReport(flag, "Verifing the element is enabled or not :" + locatorName + "<br>Locator :" + by
					+ "<br>Expected:" + locatorName + " should be enabled<br>Actual: " + flag);
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	/**
	 * If element not present it return true, otherwise returns false and generates
	 * report
	 * 
	 * @param by
	 * @param locatorName
	 * @return
	 */
	public boolean isElementNotPresent(By by, String locatorName) {
		boolean flag = false;
		try {
			getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			flag = getDriver().findElement(by).isDisplayed();
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				generateFailReport(locatorName + " is present in the page but should not visible<br>Locator: " + by);

			} else {
				generatePassReport(locatorName + " is not present on the page as expected<br>Locator: " + by);

			}
		}
		return flag;
	}

	/**
	 * If element presents, it return true, otherwise returns false and generates
	 * report
	 * 
	 * @param by
	 * @param locatorName
	 * @return
	 */
	public boolean isElementPresent(By by, String locatorName) {
		boolean flag = true;
		try {
			getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			flag = getDriver().findElement(by).isDisplayed();
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				generatePassReport(locatorName + " is present in the page as expected<br>Locator: " + by);

			} else {
				generateFailReport(locatorName + " is not present on the page<br>Locator: " + by);

			}
		}
		return flag;
	}

	/**
	 * returns true when element is selected on screen Generates report
	 * 
	 * @param by
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean isElementSelected(By by, String locatorName) {
		boolean flag = false;
		try {
			fluentWait(by);
			flag = getDriver().findElement(by).isSelected();
			generateReport(flag, "Verifing the element is selected or not :" + locatorName + "<br>Locator :" + by
					+ "<br>Expected:" + locatorName + " should be selected<br>Actual: " + flag);
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	/**
	 * Validate page title if expected page title contains some string of actual
	 * page title
	 * 
	 * @param expectedPageTitle
	 * @param pageName
	 * @return true or false
	 */
	public boolean isTitlecontains(String expectedPageTitle, String pageName) {

		try {
			String text = getWindowTitle();
			generateReport(text.contains(expectedPageTitle), "Page Title verification for " + pageName + "<br>Actual:"
					+ text + "<br>Expected:" + expectedPageTitle);
			return text.contains(expectedPageTitle);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Validate page title if expected page title is same as actual page title
	 * 
	 * @param expectedPageTitle
	 * @param pageName
	 * @return true or false
	 */
	public boolean isTitleMatched(String expectedPageTitle, String pageName) {

		try {
			String text = getWindowTitle();
			generateReport(text.equals(expectedPageTitle.trim()), "Page Title verification for " + pageName
					+ "<br>Actual:" + text + "<br>Expected:" + expectedPageTitle);
			return text.equals(expectedPageTitle.trim());
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * return unique email id for new user registration
	 * @param User 
	 * @return 
	 */
	public String randomEmailIdGenerator(String User) {
		int randomNumber = randomNumberGenerator();
		//		String generatedString = RandomStringUtils.randomNumeric(5);
		String randomEmailId = User+"automation" + randomNumber + "@fpk12.com";
		generateInfoReport("Email Id: " + randomEmailId);
		return randomEmailId;

	}

	/**
	 * return unique email id for registration
	 * @return 
	 */
	public int randomNumberGenerator() {
		Random random = new Random();
		int randomNumber=random.nextInt(100000);
	        return randomNumber;
		
	}

	
	public static int randomNumberGeneratorstatic() {
		Random random = new Random();
		int randomNumber=random.nextInt(100000);
	        return randomNumber;
		
	}
	
	
	
	
	/*
	 * return random String for registration
	 */
//		public static String generateRandomString(int length) {
//	        String characters = "abcdefghijklmnopqrstuvwxyz";
//	        StringBuilder randomString = new StringBuilder();
//
//	        Random random = new Random();
//	        for (int i = 0; i < length; i++) {
//	            int index = random.nextInt(characters.length());
//	            randomString.append(characters.charAt(index));
//	        }
//
//	        return randomString.toString();
//	    }
		
	public String generateRandomString()
	{
		Random r=new Random();
		String randomstring = RandomStringUtils.random(6, "abcdefghijklmnopqrstuvwxyz");
		return randomstring;
	}
//		public String generateRandomString(String type, int length) {
//			String candidateChars=null;
//			StringBuilder sb = new StringBuilder ();
//			Random random = new Random ();
//			switch (type.toLowerCase()) {
//			case "word":
//				candidateChars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//				for (int i = 0; i < length; i ++) {
//		            sb.append (candidateChars.charAt (random.nextInt (candidateChars
//		                    .length ())));
//		        }
//				break;
//			case "number":
//				candidateChars="0123456789";
//				for (int i = 0; i < length; i ++) {
//		            sb.append (candidateChars.charAt (random.nextInt (candidateChars
//		                    .length ())));
//		        }
//				break;
//			default:
//				System.out.println("Mention type properly");
//				break;
//			}
//			return sb.toString();
//			
//		}


	/**
	 * Thread.sleep
	 * 
	 * @param i :no of seconds like 10 for 10 seconds
	 */
	public void StaticWait(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (Exception e) {
		}
	}

	/**
	 * Switch to frame using By element
	 * 
	 * @param by
	 * @param locator
	 */
	public void switchToFrame(By by, String locator) {
		try {
			getDriver().switchTo().frame(getDriver().findElement(by));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public void switchToFrame(WebElement Element) {
		try {
			getDriver().switchTo().frame(Element);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	/**
	 * Window index starts from 0
	 * 
	 * @param windowNum
	 */
	public void switchToWindow(int windowNum) {
		try {
			Thread.sleep(1000);
			Set<String> handles = getDriver().getWindowHandles();
			ArrayList<String> ar = new ArrayList<>(handles);
			getDriver().switchTo().window(ar.get(windowNum));
			generateInfoReport(
					"Switched to window at index " + windowNum + "<br>Window title :" + getDriver().getTitle());
		} catch (Exception e) {
			generateWarnReport("failed to switch to window at index " + windowNum + "<br>" + getException(e));
		}
	}

	/**
	 * 
	 * @param by
	 * @param scrollRequired
	 * @return
	 */
	public boolean waitForElement(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(),
					Duration.ofSeconds(10));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * It will wait till the object is located within the given time
	 * 
	 * @param by      :example By.xpath("//")
	 * @param seconds : example 5
	 * @return true or false
	 */
	public boolean waitForElement(By by, int seconds) {
		return waitForElement(by, seconds);
	}

	@SuppressWarnings("deprecation")
	public void waitForPageLoad() {
		getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(getProperty("pageLoadTimeOut")),
				TimeUnit.SECONDS);

	}

	/**
	 * Wait for the given time to load the page
	 * 
	 * @param seconds
	 */
	public void waitForPageLoaded(int seconds) {
		waitForPageLoad();
	}

	/**
	 * If element is not visible it returns true, otherwise false and generate
	 * report
	 * 
	 * @param by
	 * @param seconds
	 * @return
	 */
	public boolean waitTillElementInVisible(By by, Duration seconds) {
		try {
			generateInfoReport("Waiting for element to be disappeared :" + by);
			return new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (Exception e) {
			generateInfoReport("Element is appeared :" + by);
			return true;
		}
	}
}