package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extensions.Verifications;
import org.testng.annotations.Test;
import utilities.CommonOps;
import org.testng.annotations.Listeners;
import workflows.MobileFlows;
import workflows.WebFlows;

@Listeners(utilities.LISTENERS.class)
public class MetricConversionsMobile extends CommonOps {

    @Test(description = "test01_Checking the value input for conversion")
    @Description("This Test of conversion")
    public void test01_verifyLogin(){

        MobileFlows.Conversions("60");
        Verifications.verifyTextInElementOfMobile(metricConversionsTimeConversions.ConversionOutput,"60s= 1min 0.00000000s");

    }
}
