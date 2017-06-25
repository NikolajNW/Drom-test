package scenarios;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import scenarios.helpers.BaseTest;

public class DivisionTest extends BaseTest {

    @DataProvider(name = "testData")
    public static Object[][] primeNumbers() {
        return new Object[][] {
                {"2", "2", "4.00"},
                {"2.1", "2.0", "4.10"},
                {"1", "0", "Infinity"},
                {"0", "1", "0.00"},
                {"2", "4", "0.50"},
                {"4", " ", "Please, fill the input fields correctly"},
                {" ", "2", "Please, fill the input fields correctly"},
                {" ", " ", "Please, fill the input fields correctly"}
        };
    }

    @Test(dataProvider = "testData")
    public void divisionTest(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.divisionOperation();
        Assert.assertNotEquals(result, mainPage.checkResult());
    }
}

