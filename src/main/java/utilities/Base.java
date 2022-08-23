package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import PageObjects.saucedemo.*;
import PageObjects.MetricConversions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {

    //General

    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static  String Platform;

    //Web
    protected static WebDriver driver;

    //Mobile

    protected static AppiumDriver mobileDriver;
    public static DesiredCapabilities dc = new DesiredCapabilities();

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Database

    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;



    //PageObjects - Web
    protected static  LoginPage SauceDemoLogin;
    protected static  PageObjects.saucedemo.MainPage SauceDemoMaim;
    protected static  LeftMenuPage SauceDemoLeftMenu;
    protected static  AboutPage SauceDemoAbout;
    protected static  AboutUsPage SauceDemoAboutUs;

    //PageObjects - Mobile

    protected static  PageObjects.MetricConversions.MainPage metricConversionsMainPage;
    protected static  PageObjects.MetricConversions.TimeConversions metricConversionsTimeConversions;

    //PageObjects - Electron

    protected static  PageObjects.ToDo.MainPage ToDoMainPage;

    //PageObjects - Desktop

    protected static  PageObjects.WindowsCalculator.MainPage CalcMainPage;











}
