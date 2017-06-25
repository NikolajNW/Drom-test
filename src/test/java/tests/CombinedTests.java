package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.helpers.BaseTest;

import java.util.ArrayList;

public class CombinedTests extends BaseTest {

    @Test()
    public void additionAndResetTest(){
        mainPage.setValue("2", "3");
        mainPage.summOperation();
        ArrayList appResult  = mainPage.checkResult();
        Assert.assertEquals("2.00", appResult.get(0));
        Assert.assertEquals("3.00", appResult.get(1));
        Assert.assertEquals("5.00", appResult.get(2));

        mainPage.reset();
        Assert.assertEquals("", mainPage.checkInputFieldLeft());
        Assert.assertEquals("", mainPage.checkInputFieldLeft());
    }

    @Test()
    public void multiplicationAndDivisionTest(){
        mainPage.setValue("2", "2");
        mainPage.multiplicationOperation();
        ArrayList appResult1  = mainPage.checkResult();
        Assert.assertEquals("2.00", appResult1.get(0));
        Assert.assertEquals("2.00", appResult1.get(1));
        Assert.assertEquals("4.00", appResult1.get(2));

        mainPage.divisionOperation();
        ArrayList appResult2  = mainPage.checkResult();
        Assert.assertEquals("2.00", appResult2.get(0));
        Assert.assertEquals("2.00", appResult2.get(1));
        Assert.assertEquals("1.00", appResult2.get(2));
    }
}

