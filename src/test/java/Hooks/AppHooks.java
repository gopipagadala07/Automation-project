package Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Assessments.Utils.ActionType;
import com.Assessments.Utils.Base;
import com.Assessments.Utils.Logs;

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
//		driver.quit();
	}

	@After(order = 2)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
           a.StaticWait(1);
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}