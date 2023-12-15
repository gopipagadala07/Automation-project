package Com.Examcenter.Utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Com.Examcenter.Utils.Logs;
import Com.Examcenter.Utils.ReadProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class is to initialize the webdriver and read the properties file
 * 
 * @author anamika.p
 *
 */
public class Base {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static ReadProperties readProp;
	public static Properties prop;
	public static String env;

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("internetExplorer")) {
			WebDriverManager.iedriver().setup();
			tlDriver.set(new InternetExplorerDriver());
		} else {
			Logs.warn("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return tlDriver.get();

	}

	/**
	 * This method is to load and initialize the properties file
	 * 
	 */
	public void initProperties() {
		ReadProperties readProp = new ReadProperties();
		prop = readProp.loadConfig();
		env = prop.getProperty("env");
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}