package Grid;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements Utilities.Constants {

    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public CapabilityFactory capabilityFactory = new CapabilityFactory();

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setup (String browser) throws MalformedURLException {
        //Set Browser to ThreadLocalMap
		System.setProperty(ChromeDriverKey, ChromeDriverPath);
		System.setProperty(FireFoxDriverKey, FireFoxDriverPath);
		System.setProperty(IEDriverKey, IEDriverPath);
        driver.set(new RemoteWebDriver(new URL("http://10.60.68.143:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
    }

    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterClass void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }
}