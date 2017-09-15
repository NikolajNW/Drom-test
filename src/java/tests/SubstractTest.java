package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.BaseTest;

import java.util.ArrayList;

public class SubstractTest extends BaseTest {

    @DataProvider(name = "testData")
    public static Object[][] validValue() {
        return new Object[][] {
                {"2", "1", "1.00"},
                {"2", "3", "-1.00"},
        };
    }

    @Test(dataProvider = "testData")
    public void substractTest(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.subtractOperation();
        ArrayList appResult = mainPage.checkResult();
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
    public void substractErrorTest(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.subtractOperation();
        Assert.assertEquals(mainPage.checkError(), result);
    }
}

