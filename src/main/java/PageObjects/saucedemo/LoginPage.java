package PageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class LoginPage {
    @FindBy(how = How.CLASS_NAME, using ="login_logo")
    public WebElement  logo;

    @FindBy(how = How.ID , using ="user-name")
    public WebElement  UserName;

    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    @FindBy(how = How.ID,using = "login-button")
    public WebElement LoginButton;

    @FindBy(how = How.CLASS_NAME, using = "bot_column")
    public WebElement BotColumn ;

    @FindBy(how = How.ID, using = "login_credentials")
    public WebElement LoginCredentials;

    @FindBy(how = How.CLASS_NAME, using = "error-button")
    public WebElement errorButton ;
}
