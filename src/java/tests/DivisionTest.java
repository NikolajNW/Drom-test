package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.BaseTest;

import java.util.ArrayList;

public class DivisionTest extends BaseTest {

    @DataProvider(name = "testData")
    public static Object[][] valideValue() {
        return new Object[][] {
                {"2", "2", "1.00"},
                {"2.1", "2.0", "1.05"},
                {"0", "1", "0.00"},
                {"2", "4", "0.50"},
                {"1", "0", "Infinity"},
        };
    }

    @Test(dataProvider = "testData")
    public void divisionTest(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.divisionOperation();
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
    public void divisionErrorTest(String firstValue, String secondValue, String result) throws InterruptedException {
        mainPage.setValue(firstValue, secondValue);
        mainPage.divisionOperation();
        Assert.assertEquals(mainPage.checkError(), result);
    }
}

