package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.helpers.BaseTest;

import java.util.ArrayList;

public class AdditionTest extends BaseTest {

    @DataProvider(name = "testData")
    public static Object[][] validValue() {
        return new Object[][] {
                {"2", "2", "4.00"},
                {"2.1", "2.0", "4.10"},
                {"99999991", "1", "99999992.00"}
        };
    }

    @Test(dataProvider = "testData")
    public void additionTest(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.summOperation();
        ArrayList appResult  = mainPage.checkResult();
        Assert.assertEquals(appResult.get(2), result);
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
    public void additionErrorTest(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.summOperation();
        Assert.assertEquals(mainPage.checkError(), result);
    }
}

