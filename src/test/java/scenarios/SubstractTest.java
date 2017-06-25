package scenarios;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import scenarios.helpers.BaseTest;

public class SubstractTest extends BaseTest {

    @DataProvider(name = "testData")
    public static Object[][] primeNumbers() {
        return new Object[][] {
                {"2", "1", "1.00"},
                {"2", "3", "-1.00"},
                {"4", " ", "Please, fill the input fields correctly"},
                {" ", "2", "Please, fill the input fields correctly"},
                {" ", " ", "Please, fill the input fields correctly"}
        };
    }

    @Test(dataProvider = "testData")
    public void substractTest(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.subtractOperation();
        Assert.assertNotEquals(result, mainPage.checkResult());
    }
}

