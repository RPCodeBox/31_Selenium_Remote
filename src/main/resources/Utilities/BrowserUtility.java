package Utilities;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.*;
import org.testng.Reporter;

public abstract class BrowserUtility implements Constants {
	public static boolean setZoom = true;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setWebDriver(WebDriver Driver) {
		driver.set(Driver);
	}

	public static WebDriver SetBrowser() throws Exception {
		WebDriver driver;
		String Browser = CSVUtility.getConfigValue("Browser");
    	int ImplicitWait = Integer.parseInt(CSVUtility.getConfigValue("ImplicitWait"));
		if(Browser.isEmpty()){
			System.out.println("BrowserUtility: Browser value is null");
			return null;
		}
		System.setProperty(ChromeDriverKey, ChromeDriverPath);
		System.setProperty(FireFoxDriverKey, FireFoxDriverPath);
		System.setProperty(IEDriverKey, IEDriverPath);
		if (Browser.equalsIgnoreCase("CHROME")) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");
	        options.addArguments("--ignore-certificate-errors");
	        options.addArguments("--disable-popup-blocking");
			options.addArguments("disable-infobars");
		    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		    capabilities.merge(options);
			driver = new ChromeDriver(options);
		} else if (Browser.equalsIgnoreCase("FIREFOX")) {
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, FireFoxLogFile);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			FirefoxProfile profile = new FirefoxProfile();
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			capabilities.setCapability("screenResolution", "1280x1024");
			capabilities.setCapability("marionette", true);
			capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("IE")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("BrowserUtility: Browser not initiated");
			return null;
		}
		driver.manage().timeouts().implicitlyWait(ImplicitWait, TimeUnit.SECONDS);
		System.out.println("BrowserUtility: Browser launched - " + Browser);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("BrowserUtility: Browser maximised and Deleted cookies");
		if(setZoom==true) {
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, "0"));
		}
		Reporter.log("BrowserUtility: Browser initiated - " + Browser);
		System.out.println("BrowserUtility: Browser initiated - " + Browser);
		return driver;
	}
}
