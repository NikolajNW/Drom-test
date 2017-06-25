package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.helpers.BaseTest;

import java.util.ArrayList;

public class MultiplicationTest extends BaseTest {

    @DataProvider(name = "testData")
    public static Object[][] validValue() {
        return new Object[][] {
                {"2", "2", "4.00"},
                {"2.1", "2", "4.20"},
        };
    }

    @Test(dataProvider = "testData")
    public void multiplicationOperationTest(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.multiplicationOperation();
        ArrayList appResult  = mainPage.checkResult();
        Assert.assertEquals(result, appResult.get(2));
    }

    @DataProvider(name = "testDataError")
    public static Object[][] invalidValue() {
        return new Object[][] {
                {"4", " ", "Please, fill the input fields correctly"},
                {" ", "2", "Please, fill the input fields correctly"},
                {" ", " ", "Please, fill the input fields correctly"}
        };
    }

    @Test(dataProvider = "testDataError")
    public void multiplicationOperationErrorTest(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.multiplicationOperation();
        Assert.assertNotEquals(result, mainPage.checkError());
    }
}

