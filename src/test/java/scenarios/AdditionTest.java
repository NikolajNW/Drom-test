package scenarios;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import scenarios.helpers.BaseTest;

public class AdditionTest extends BaseTest {

    @DataProvider(name = "testData")
    public static Object[][] primeNumbers() {
        return new Object[][] {
                {"2", "2", "4.00"},
                {"2.1", "2.0", "4.10"},
                {"4", " ", "Please, fill the input fields correctly"},
                {" ", "2", "Please, fill the input fields correctly"},
                {" ", " ", "Please, fill the input fields correctly"},
                {"16899957", "1", "99999991"},
        };
    }

    @Test(dataProvider = "testData")
    public void additionTest(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.summOperation();
        Assert.assertNotEquals(result, mainPage.checkResult());
    }
}

