package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.security.Key;
import java.util.List;


public class UIActions extends CommonOps {
    @Step("Click on element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step ("SendKeys to element")
    public static void updateText(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }
    @Step ("SendKeys to element")
    public static void insetKey(WebElement elem, Keys value){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    @Step("update DropDown element")
    public static void updateDropDown(WebElement elem,String text){
        Select  dropDown= new Select(elem);
        dropDown.selectByValue(text);
    }

    @Step("MouseHover element")
    public static void MouseHover(WebElement elem1, WebElement elem2){
        wait.until(ExpectedConditions.urlToBe("https://saucelabs.com/"));
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();

    }
    @Step("MouseHover element")
    public static void MouseHover(WebElement elem1){
        action.moveToElement(elem1).click().build().perform();

    }
}
