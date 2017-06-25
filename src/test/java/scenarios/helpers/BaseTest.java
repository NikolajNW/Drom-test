package scenarios.helpers;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nikolaj on 25.06.2017.
 */
public class BaseTest{

    protected MainPage mainPage;
    protected AndroidDriver driver;

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
        capabilities.setCapability("appium-version", "1.6.5");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("deviceName", "Test");
        capabilities.setCapability("app", "/Projects/AppiumDemo/apps/app-debug.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }
}
