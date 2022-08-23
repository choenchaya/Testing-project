package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Checking the value input for conversion")
    public static void Conversions(String value){
        MobileActions.tap(metricConversionsMainPage.Time);
        MobileActions.tap(metricConversionsTimeConversions.Seconds);
        MobileActions.tap(metricConversionsTimeConversions.Minutes);
        MobileActions.tap(metricConversionsTimeConversions.ValueForConversion);
        MobileActions.updateText(metricConversionsTimeConversions.ValueForConversion,value);
        MobileActions.tap(metricConversionsTimeConversions.ButtonConvert);

    }
}
