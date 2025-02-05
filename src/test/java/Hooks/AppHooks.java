package Hooks;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.Utils.ActionType;
import com.Utils.Base;
import com.Utils.Logs;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks extends Base {

	ActionType a=new ActionType();
	private WebDriver driver;
	private Base driverFactory;

	@After(order = 0)
	public void afterScenarioFinish() {
		Logs.info("-----------------End of Scenario-----------------");
	}
	@Before(order = 2)
	public void beforeScenarioStart() {
		Logs.info("-----------------Start of Scenario-----------------");

	}

	@Before(order = 0)
	public void getProperty() {
		initProperties();
	}


	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		Logs.info("Browser value is: " + browserName.toUpperCase());
		driverFactory = new Base();
		driver = driverFactory.init_driver(browserName);
		driver.manage().deleteAllCookies();

	}

	@After(order = 1)
	public void quitBrowser() {
		a.StaticWait(2);
		driver.quit();
	}

	@After(order = 2)
	public void tearDown(Scenario scenario) {

		/*
		 * Capturing Application Logs
		 */
//		try {
//			if (driver != null) {
//				LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
//				StringBuilder logBuilder = new StringBuilder();
//
//				for (LogEntry entry : logs) {
//					logBuilder.append("[").append(entry.getLevel()).append("] ")
//					.append(entry.getMessage()).append("\n");
//				}
//
//				String consoleLogs = logBuilder.toString();
//				if (!consoleLogs.isEmpty()) {
//					scenario.attach(consoleLogs.getBytes(), "text/plain", "Application Console Logs");
//					ExtentCucumberAdapter.getCurrentStep().info("Captured Application Console Logs:\n" + consoleLogs);
//				}
//			}
//		} catch (Exception e) {
//			System.err.println("Error capturing application console logs: " + e.getMessage());
//		}

		if (scenario.isFailed()) {
			// take screenshot:
			a.StaticWait(1);
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}