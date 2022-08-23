package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {
    public static void initSauceDemo(){

        //Web
        SauceDemoLogin = PageFactory.initElements(driver, PageObjects.saucedemo.LoginPage.class);
        SauceDemoMaim = PageFactory.initElements(driver, PageObjects.saucedemo.MainPage.class);
        SauceDemoLeftMenu = PageFactory.initElements(driver, PageObjects.saucedemo.LeftMenuPage.class);
        SauceDemoAbout= PageFactory.initElements(driver,PageObjects.saucedemo.AboutPage.class);
        SauceDemoAboutUs= PageFactory.initElements(driver,PageObjects.saucedemo.AboutUsPage.class);


    }

    public static void initMetricConversions(){
       metricConversionsMainPage = new PageObjects.MetricConversions.MainPage(mobileDriver);
       metricConversionsTimeConversions= new PageObjects.MetricConversions.TimeConversions(mobileDriver);

    }
    public static void initToDo(){
        ToDoMainPage= PageFactory.initElements(driver, PageObjects.ToDo.MainPage.class);
    }
    public static void initCalc(){
        CalcMainPage= PageFactory.initElements(driver, PageObjects.WindowsCalculator.MainPage.class);
    }


    }


