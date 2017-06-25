package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

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

    public ArrayList checkResult(){
        String appResult = getText(resultTextView);
        String regExp = "[+, =, \\s]";
        String[] result = appResult.split(regExp);

        ArrayList finalResult = new ArrayList();

        for(int i = 0; i < result.length; i++){
            if (!result[i].equals("")) {
                String d = result[i];
                finalResult.add(d);
            }
        }

        return finalResult;
    }

    public String checkError(){
        String error = getText(resultTextView);
        return error;
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
