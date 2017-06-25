package scenarios;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import scenarios.helpers.BaseTest;

public class ResetTest extends BaseTest {

    @Test()
    public void checkInputFieldLeftTest() throws InterruptedException {
        mainPage.setValue("1", "1");
        mainPage.reset();
        Assert.assertNotEquals("1", mainPage.checkInputFieldLeft());
    }

    @Test()
    public void checknIputFieldRightTest() throws InterruptedException {
        mainPage.setValue("1", "1");
        mainPage.reset();
        Assert.assertNotEquals("1", mainPage.checknIputFieldRight());
    }
}

