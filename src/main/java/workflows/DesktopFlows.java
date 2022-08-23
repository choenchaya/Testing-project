package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Calculate multiplication")
    public static void CalculateMultiplication(){
        UIActions.click(CalcMainPage.Clear);
        UIActions.click(CalcMainPage.btnOne);
        UIActions.click(CalcMainPage.MultiplyBy);
        UIActions.click(CalcMainPage.btnTow);
        UIActions.click(CalcMainPage.Equal);
    }
}
