package script;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DriverFactory {

	public static String ChromeDriverKey = "webdriver.chrome.driver";
    public static String ChromeDriverPath = "lib/chromedriver.exe";
    public static String FireFoxDriverKey = "webdriver.gecko.driver";
    public static String FireFoxDriverPath = "lib/geckodriver.exe";
    public static String IEDriverKey = "webdriver.ie.driver";
    public static String IEDriverPath = "lib/IEDriverServer.exe";
    
	private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();
	
	public synchronized static void setTLDriver(String browser) {
		System.setProperty(ChromeDriverKey, ChromeDriverPath);
		System.setProperty(FireFoxDriverKey, FireFoxDriverPath);
		System.setProperty(IEDriverKey, IEDriverPath);

		if (browser.equals("firefox")) {
			tDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(getFirefoxOptions()));
		} else if (browser.equals("chrome")) {
			tDriver = ThreadLocal.withInitial(() -> new ChromeDriver(getChromeOptions()));
		} else if (browser.equals("ie")) {
			tDriver = ThreadLocal.withInitial(() -> new InternetExplorerDriver(getInternetExplorerOptions()));
		} else {
			System.out.println("Driver Factory: Browser not specified");
			return;
		}
	}

	public synchronized static WebDriver getTLDriver() {
		tDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tDriver.get().manage().window().maximize();
		tDriver.get().manage().deleteAllCookies();
		return tDriver.get();
	}

	public synchronized static void resetDriver() {
		if (DriverFactory.getTLDriver() != null) {
			DriverFactory.getTLDriver().quit();
			System.out.println("Driver closed 2");
		}
	}

	//Get Chrome Options
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return options;
    }

    //Get Firefox Options
    public static FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("network.proxy.type", 0);
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    private static InternetExplorerOptions getInternetExplorerOptions() {
    	InternetExplorerOptions options = new InternetExplorerOptions();
   		options.introduceFlakinessByIgnoringSecurityDomains();
   		options.requireWindowFocus();
   		options.enableNativeEvents();
   		options.ignoreZoomSettings();
   		options.enablePersistentHovering();
    	return options;
    }
}
