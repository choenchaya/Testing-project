package extensions;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import java.util.List;
import static org.testng.Assert.*;

public class Verifications extends CommonOps  {
    @Step("verify Text In web Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }
    @Step("verify List Length")
    public static void verifyListLength(List<String> list,int expected) {
        assertEquals(list.size(),expected);
    }
    @Step("verify Text In mobile Element")
    public static void verifyTextInElementOfMobile(MobileElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }
    @Step("verify Text Whit Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("verify Number Whit Number")
    public static void verifyNumber(int actual, int expected) {
        assertEquals(actual, expected);
    }

    @Step("verify Element Is Enabled")
    public static void verifyElementIsEnabled (WebElement element) {

        assertTrue(element.isEnabled());

    }
    @Step("verify Element From List")
    public static void verifyElementFromList (List<WebElement> ListOfElem,String expected){

            assertEquals(ListOfElem.get(0).getText(),expected);

    }
    @Step("verify Element Appears")
    public static void verifyElementAppears (WebElement elementTested ,String message){

       assertTrue(elementTested.isDisplayed(),message);
    }
    @Step("Visibility Of Elements")
    public static void VisibilityOfElements (List<WebElement>elems) {

        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed());
        }

    softAssert.assertAll();

    }
    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName){
        try {
            screen.find(getData("ImageRepo")+expectedImageName);
        } catch (FindFailed e) {
            e.printStackTrace();
            fail();

        }
    }
}


