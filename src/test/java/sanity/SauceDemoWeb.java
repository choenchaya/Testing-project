package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extensions.Verifications;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.LISTENERS.class)
public class SauceDemoWeb extends CommonOps {

    @Test(description = "test01_verifyLogin")
    @Description("This Test of Login")
    public void test01_verifyLogin(){

        WebFlows.login("standard_user", "secret_sauce");
        Verifications.VisibilityOfElements(SauceDemoMaim.InventoryList);
    }

    @Test(description = "test02_ShoppingCartButtons")
    @Description("This Test of the Shopping Buttons")
    public void test02_ShoppingCartButtons(){

        WebFlows.login("standard_user", "secret_sauce");
        WebFlows.ShoppingCart(SauceDemoMaim.AddToCart);
        Verifications.verifyTextInElement(SauceDemoMaim.ShoppingCartBadge,"1");
        WebFlows.ShoppingCart(SauceDemoMaim.Remove);
    }

    @Test(description = "test03_RemoveShoppingCartButtons")
    @Description("This Test of the enabled of remove button")
    public void test03_RemoveShoppingCartButtons(){

        WebFlows.login("standard_user", "secret_sauce");
        WebFlows.ShoppingCart(SauceDemoMaim.AddToCart);
        Verifications.verifyElementIsEnabled(SauceDemoMaim.Remove);
    }

    @Test(description = "test04_verifyFilter")
    @Description("This Test The Filter")
    public void test04_verifyFilter(){

        WebFlows.login("standard_user", "secret_sauce");
        WebFlows.Filter();
        Verifications.verifyElementFromList(SauceDemoMaim.price, "$7.99");

    }

    @Test(description ="test05_LogOut", dataProvider = "data-Provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test of LogOut")
    public void test05_LogOut(String users, String password){

        WebFlows.loginWhiteDate(users, password);
        Verifications.verifyElementAppears(SauceDemoLogin.BotColumn,"LogOut is OK");
    }

    @Test(description = "test06_AboutUseMouseover")
    @Description("this test verifies abut page by using mouseover")
    public void test06_About(){

        WebFlows.login("standard_user", "secret_sauce");
        WebFlows.Abut();
        Verifications.verifyTextInElement(SauceDemoAboutUs.AboutSauceLabs, "ABOUT SAUCE LABS");
    }
    @Test(description = "test07_Verify image")
    @Description("this test of verifies Image")
    public void test07_VerifyImage(){
        Verifications.visualElement("imeg.JPG");
    }
}
