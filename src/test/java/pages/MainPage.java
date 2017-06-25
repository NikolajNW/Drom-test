package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    By additionButton = By.id("additionButton");

    By subtractButton = By.id("subtractButton");

    By multiplicationButton = By.id("multiplicationButton");

    By divisionButton = By.id("divisionButton");

    By resetButton = By.id("resetButton");

    By resultTextView = By.id("resultTextView");

    By inputFieldLeft = By.id("inputFieldLeft");

    By inputFieldRight = By.id("inputFieldRight");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void setValue(String first, String Second){
        sendKeys(inputFieldLeft, first);
        sendKeys(inputFieldRight, Second);
    }

    public void summOperation(){
        clickElement(additionButton);
    }

    public void subtractOperation(){
        clickElement(subtractButton);
    }

    public void multiplicationOperation(){
        clickElement(multiplicationButton);
    }

    public void divisionOperation(){
        clickElement(divisionButton);
    }

    public void reset(){
        clickElement(resetButton);
    }

    public String checkResult(){
        String result = getText(resultTextView);
        return result;
    }

    public String checkInputFieldLeft(){
        String result = getText(inputFieldLeft);
        return result;
    }

    public String checknIputFieldRight(){
        String result = getText(inputFieldLeft);
        return result;
    }
}
