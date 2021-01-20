package Utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class GridUtility implements Utilities.Constants {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	static boolean setZoom = false;
    
    public static ThreadLocal<RemoteWebDriver> GridDriver() throws MalformedURLException, Exception {
    	String Browser = CSVUtility.getConfigValue("Browser");
    	String HubURL = CSVUtility.getConfigValue("HubURL");
    	int ImplicitWait = Integer.parseInt(CSVUtility.getConfigValue("ImplicitWait"));
    	driver.set(new RemoteWebDriver(new URL(HubURL), getCapabilities(Browser)));
		System.out.println("GridUtility: Browser launched - " + Browser);
		driver.get().manage().timeouts().implicitlyWait(ImplicitWait, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().manage().deleteAllCookies();
		System.out.println("GridUtility: Browser maximised and Deleted cookies");
		if(setZoom==true) {
			WebElement html = driver.get().findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, "0"));
		}
		Reporter.log("GridBrowserUtility: Browser initiated - " + Browser);
		System.out.println("GridBrowserUtility: Browser initiated - " + Browser);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
    
    private static Capabilities getCapabilities (String browser) {
        Capabilities capabilities = null;
        if (browser.equalsIgnoreCase("chrome")) {
        	capabilities = getChromeOptions();
        } else if(browser.equalsIgnoreCase("firefox")) {
            capabilities = getFirefoxOptions();
        } else if(browser.equalsIgnoreCase("ie")) {
        	capabilities = getIEOptions();
        } else {
        	System.out.println("Grid Utility: Browser not defined!!!");
        }
        return capabilities;
    }
    
    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("disable-infobars");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        return options;
    }

    private static FirefoxOptions getFirefoxOptions () {
    	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, FireFoxLogFile);
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("network.proxy.type", 0);
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    private static Capabilities getIEOptions() {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		return capabilities;
    }
}
