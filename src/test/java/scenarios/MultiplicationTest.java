package scenarios;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import scenarios.helpers.BaseTest;

public class MultiplicationTest extends BaseTest {

    @DataProvider(name = "testData")
    public static Object[][] primeNumbers() {
        return new Object[][] {
                {"2", "2", "4.00"},
                {"2.1", "2", "4.20"},
                {"4", " ", "Please, fill the input fields correctly"},
                {" ", "2", "Please, fill the input fields correctly"},
                {" ", " ", "Please, fill the input fields correctly"}
        };
    }

    @Test(dataProvider = "testData")
    public void multiplicationOperation(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.multiplicationOperation();
        Assert.assertNotEquals(result, mainPage.checkResult());
    }
}

