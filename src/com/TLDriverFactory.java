package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by onurb on 19-Dec-16.
 */
public class TLDriverFactory implements Constants {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public synchronized static void setTLDriver(String browser) {
		System.setProperty(ChromeDriverKey, ChromeDriverPath);
		System.setProperty(FireFoxDriverKey, FireFoxDriverPath);
		System.setProperty(IEDriverKey, IEDriverPath);

		if (browser.equals("firefox")) {
			tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(OptionsManager.getFirefoxOptions()));
		} else if (browser.equals("chrome")) {
			tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(OptionsManager.getChromeOptions()));
		} else if (browser.equals("ie")) {
			tlDriver = ThreadLocal.withInitial(() -> new InternetExplorerDriver());
		}
	}

	public synchronized static WebDriver getTLDriver() {
		return tlDriver.get();
	}

}
