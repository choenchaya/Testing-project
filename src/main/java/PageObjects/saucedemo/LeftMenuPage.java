package PageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LeftMenuPage {


    @FindBy(how = How.XPATH, using = "//a[@class='bm-item menu-item'][1]")
    public WebElement AllItems;

    @FindBy(how = How.XPATH, using = "//a[@class='bm-item menu-item'][2]")
    public WebElement About;

    @FindBy(how = How.XPATH, using = "//a[@class='bm-item menu-item'][3]")
    public WebElement Logout;

    @FindBy(how = How.XPATH, using = "//a[@class='bm-item menu-item'][4]")
    public WebElement ResetAppState;

    @FindBy (how = How.CLASS_NAME,using = "bm-item menu-item")
    public List<WebElement> MenuItem;

}
