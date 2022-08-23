package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extensions.Verifications;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

public class SauceDemoWebDB extends CommonOps {

    @Test(description ="test01 Login & LogOut with DB Credentials")
    @Description("This Test of Login & LogOut with DB Credentials and verifies it")
    public void test01_LogOutUseDB(){

        WebFlows.loginWhitDB();
        Verifications.verifyElementAppears(SauceDemoLogin.BotColumn,"LogOut is OK");
    }
}
