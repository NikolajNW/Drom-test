
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.BaseTest;

public class ResetTest extends BaseTest {

    @DataProvider(name = "testData")
    public static Object[][] testData() {
        return new Object[][] {
                {" ", "2"},
                {"2.1", ""},
                {"1", "2.00"}
        };
    }

    @Test(dataProvider = "testData")
    public void checkInputFieldResetTest(String firstValue, String secondValue) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.reset();
        Assert.assertEquals(mainPage.checkInputFieldLeft(), "");
        Assert.assertEquals(mainPage.checkInputFieldLeft(), "");
    }
}

