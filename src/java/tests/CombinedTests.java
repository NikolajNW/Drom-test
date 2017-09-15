package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import support.BaseTest;

import java.util.ArrayList;

public class CombinedTests extends BaseTest {

    @Test()
    public void additionAndResetTest(){
        mainPage.setValue("2", "3");
        mainPage.summOperation();
        ArrayList appResult  = mainPage.checkResult();
        Assert.assertEquals(appResult.get(0), "2.00");
        Assert.assertEquals(appResult.get(1), "3.00");
        Assert.assertEquals(appResult.get(2), "5.00");

        mainPage.reset();
        Assert.assertEquals(mainPage.checkInputFieldLeft(), "");
        Assert.assertEquals(mainPage.checkInputFieldLeft(), "");
    }

    @Test()
    public void multiplicationAndDivisionTest(){
        mainPage.setValue("2", "2");
        mainPage.multiplicationOperation();
        ArrayList appResult1  = mainPage.checkResult();
        Assert.assertEquals(appResult1.get(0), "2.00");
        Assert.assertEquals(appResult1.get(1), "2.00");
        Assert.assertEquals(appResult1.get(2), "4.00");

        mainPage.divisionOperation();
        ArrayList appResult2  = mainPage.checkResult();
        Assert.assertEquals(appResult2.get(0), "2.00");
        Assert.assertEquals(appResult2.get(1), "2.00");
        Assert.assertEquals(appResult2.get(2), "1.00");
    }
}

