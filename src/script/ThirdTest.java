package script;

import java.net.MalformedURLException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThirdTest {
	protected WebDriverWait wait;
	String browser = "chrome";

	// Do the test setup
	@BeforeMethod
	public void setupTest() throws MalformedURLException {
		// Set & Get ThreadLocal Driver with Browser
		DriverFactory.setTLDriver(browser);
        System.out.println("Test Started! " + Thread.currentThread().getId());
	}
	@Test
    public void GOOGLE0() throws Exception {
        DriverFactory.getTLDriver().navigate().to("http://www.google.com");
        System.out.println("Google0 Test's Page title is: " + DriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(DriverFactory.getTLDriver().getTitle(), "Google");
    }
	@Test
    public void GOOGLE1() throws Exception {
        DriverFactory.getTLDriver().navigate().to("http://www.google.com");
        System.out.println("Google0 Test's Page title is: " + DriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(DriverFactory.getTLDriver().getTitle(), "Google");
    }
	@Test
    public void GOOGLE2() throws Exception {
        DriverFactory.getTLDriver().navigate().to("http://www.google.com");
        System.out.println("Google0 Test's Page title is: " + DriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(DriverFactory.getTLDriver().getTitle(), "Google");
    }
	@Test
    public void GOOGLE3() throws Exception {
        DriverFactory.getTLDriver().navigate().to("http://www.google.com");
        System.out.println("Google0 Test's Page title is: " + DriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(DriverFactory.getTLDriver().getTitle(), "Google");
    }
	@Test
    public void GOOGLE4() throws Exception {
        DriverFactory.getTLDriver().navigate().to("http://www.google.com");
        System.out.println("Google0 Test's Page title is: " + DriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(DriverFactory.getTLDriver().getTitle(), "Google");
    }

	@AfterMethod
    public synchronized void tearDown() throws Exception {
        System.out.println("Test Ended " + Thread.currentThread().getId());
		//DriverFactory.resetDriver();
		DriverFactory.getTLDriver().quit();
		System.out.println("Browser closed" + Thread.currentThread().getId());
	}
}
