package Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Com.Examcenter.Utils.Base;
import Com.Examcenter.Utils.Logs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base {

	private Base driverFactory;
	private WebDriver driver;

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

	@Before(order = 2)
	public void beforeScenarioStart() {
		Logs.info("-----------------Start of Scenario-----------------");

	}

	@After(order = 0)
	public void afterScenarioFinish() {
		Logs.info("-----------------End of Scenario-----------------");
	}

	@After(order = 1)
	public void quitBrowser() {
		//driver.quit();
	}

	@After(order = 2)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}