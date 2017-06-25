package scenarios.helpers;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.MainPage;
import support.ReadProperty;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nikolaj on 25.06.2017.
 */
public class BaseTest{

    protected MainPage mainPage;
    protected AndroidDriver driver;
    private String appium_version = ReadProperty.property("appiumVersion");
    private String platformName = ReadProperty.property("platformName");
    private String platformVersion = ReadProperty.property("platformVersion");
    private String deviceName = ReadProperty.property("deviceName");
    private String app = ReadProperty.property("app");
    private String url = ReadProperty.property("url");

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        mainPage = new MainPage(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    protected void prepareAndroidForAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", appium_version);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("app", app);
        driver = new AndroidDriver(new URL(url), capabilities);
    }
}
