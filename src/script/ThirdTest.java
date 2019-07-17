package script;

import java.net.MalformedURLException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TLDriverFactory;

public class ThirdTest {
	protected WebDriverWait wait;
	String browser = "chrome";

	// Do the test setup
	@BeforeMethod
	public void setupTest() throws MalformedURLException {
		// Set & Get ThreadLocal Driver with Browser
		DriverFactory.setTLDriver(browser);
	}
	@Test
    public void GOOGLE0() throws Exception {
        System.out.println("Google0 Test Started! " + Thread.currentThread().getId());
        DriverFactory.getTLDriver().navigate().to("http://www.google.com");
        System.out.println("Google0 Test's Page title is: " + TLDriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(TLDriverFactory.getTLDriver().getTitle(), "Google");
        System.out.println("Google0 Test Ended! " + Thread.currentThread().getId());
    }
	@Test
    public void GOOGLE1() throws Exception {
        System.out.println("Google0 Test Started! " + Thread.currentThread().getId());
        DriverFactory.getTLDriver().navigate().to("http://www.google.com");
        System.out.println("Google0 Test's Page title is: " + TLDriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(TLDriverFactory.getTLDriver().getTitle(), "Google");
        System.out.println("Google0 Test Ended! " + Thread.currentThread().getId());
    }
	@Test
    public void GOOGLE2() throws Exception {
        System.out.println("Google0 Test Started! " + Thread.currentThread().getId());
        DriverFactory.getTLDriver().navigate().to("http://www.google.com");
        System.out.println("Google0 Test's Page title is: " + TLDriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(TLDriverFactory.getTLDriver().getTitle(), "Google");
        System.out.println("Google0 Test Ended! " + Thread.currentThread().getId());
    }
	@Test
    public void GOOGLE3() throws Exception {
        System.out.println("Google0 Test Started! " + Thread.currentThread().getId());
        DriverFactory.getTLDriver().navigate().to("http://www.google.com");
        System.out.println("Google0 Test's Page title is: " + TLDriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(TLDriverFactory.getTLDriver().getTitle(), "Google");
        System.out.println("Google0 Test Ended! " + Thread.currentThread().getId());
    }
	@Test
    public void GOOGLE4() throws Exception {
        System.out.println("Google0 Test Started! " + Thread.currentThread().getId());
        DriverFactory.getTLDriver().navigate().to("http://www.google.com");
        System.out.println("Google0 Test's Page title is: " + TLDriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(TLDriverFactory.getTLDriver().getTitle(), "Google");
        System.out.println("Google0 Test Ended! " + Thread.currentThread().getId());
    }

	@AfterMethod
    public synchronized void tearDown() throws Exception {
		//DriverFactory.resetDriver();
		DriverFactory.getTLDriver().quit();
	}
}
