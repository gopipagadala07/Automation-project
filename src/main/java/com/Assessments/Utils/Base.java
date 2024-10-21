package com.Assessments.Utils;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class is to initialize the webdriver and read the properties file
 * 
 * @author anamika.p
 *
 */
public class Base {

	public static String env;

	public static Properties prop;

	public static ReadProperties readProp;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	

	public WebDriver driver;

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
//     		options.addArguments("--headless");
//			//options.addArguments("--window-size=1920,1080");
			options.addArguments("--remote-allow-origins=*");
			tlDriver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("internetExplorer")) {
			WebDriverManager.iedriver().setup();
			tlDriver.set(new InternetExplorerDriver());
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless");
			tlDriver.set(new EdgeDriver(options));
		} else {
			Logs.warn("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

}