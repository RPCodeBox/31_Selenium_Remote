package com;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;

/**
 * Created by ONUR on 03.12.2016.
 */
public class TestBase {
	protected WebDriverWait wait;
	
	// Do the test setup
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setupTest(@Optional String browser) throws MalformedURLException {
		// Set & Get ThreadLocal Driver with Browser
		TLDriverFactory.setTLDriver(browser);
		wait = new WebDriverWait(TLDriverFactory.getTLDriver(), 15);
	}

	@AfterMethod
    public synchronized void tearDown() throws Exception {
		TLDriverFactory.getTLDriver().quit();

		/*
		List<WebDriver> driversToCleanup = Collections.synchronizedList(new ArrayList<WebDriver>());
		Iterator<WebDriver> iterator = driversToCleanup.iterator();
		while (iterator.hasNext()) {
			WebDriver driver = iterator.next();
			driver.quit();
			iterator.remove();
			System.out.println("Driver closed");
		}
		*/
	}
}
