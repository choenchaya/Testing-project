package PageObjects.WindowsCalculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.NAME, using ="Clear")
    public WebElement Clear;

    @FindBy(how = How.NAME, using ="One")
    public WebElement btnOne;

    @FindBy(how = How.NAME, using ="Two")
    public WebElement btnTow;

    @FindBy(how = How.NAME, using ="Multiply by")
    public WebElement MultiplyBy;

    @FindBy(how = How.NAME, using ="Equals")
    public WebElement Equal;

    @FindBy(how = How.XPATH, using ="//*[@AutomationId='CalculatorResults']")
    public WebElement CalculatorResults;



}
