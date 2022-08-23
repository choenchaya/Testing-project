package workflows;


import extensions.DBActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.List;


public class WebFlows extends CommonOps {

    @Step("Login Whit user&pass")
    public static void login(String user, String pass){
        UIActions.updateText(SauceDemoLogin.UserName, user);
        UIActions.updateText(SauceDemoLogin.password, pass);
        UIActions.click(SauceDemoLogin.LoginButton);
    }
    @Step("login $ logout White Date")
    public static void loginWhiteDate(String users, String password){
        UIActions.updateText(SauceDemoLogin.UserName, users);
        UIActions.updateText(SauceDemoLogin.password, password);
        UIActions.click(SauceDemoLogin.LoginButton);
        LogOut();
    }

    @Step("login $ logout White DB Credentials")
    public static void loginWhitDB(){
        String query = "SELECT UserName, password FROM User WHERE id='3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(SauceDemoLogin.UserName, cred.get(0));
        UIActions.updateText(SauceDemoLogin.password, cred.get(1));
        UIActions.click(SauceDemoLogin.LoginButton);
        LogOut();
    }


    @Step("Filter")
    public static void Filter(){
        UIActions.updateDropDown(SauceDemoMaim.select_container, "lohi");

    }

    @Step("Log Out")
    public static void LogOut(){
        UIActions.click(SauceDemoMaim.LeftMenuButton);
        UIActions.click(SauceDemoLeftMenu.Logout);

    }
    @Step("Get to Abut page")
    public static void Abut() {

        UIActions.click(SauceDemoMaim.LeftMenuButton);
        UIActions.click(SauceDemoLeftMenu.About);
        UIActions.MouseHover(SauceDemoAbout.CompanyMouseHover,SauceDemoAbout.AboutUsMouseHover);
    }

    @Step("buttons of Shopping Cart")
    public static void ShoppingCart(WebElement elem) {
        UIActions.click(elem);

    }
    }