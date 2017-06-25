package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {


    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    protected void sendKeys(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    protected String getText(By locator) {
        String text = driver.findElement(locator).getText();
        return text;
    }

}
