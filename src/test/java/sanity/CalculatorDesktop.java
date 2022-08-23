package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extensions.Verifications;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;
import workflows.ElectronFlows;


@Listeners(utilities.LISTENERS.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "test01_multiply")
    @Description("This Test verify multiply")
    public void test01_DeleteTasks(){
        DesktopFlows.CalculateMultiplication();
        Verifications.verifyTextInElement(CalcMainPage.CalculatorResults,"Display is 2");


    }


}
