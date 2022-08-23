package utilities;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;

import java.lang.reflect.Method;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    public static String getData(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
        fXmlFile = new File("./Configuration/DateConfig.xml");
         dbFactory = DocumentBuilderFactory.newInstance();
         dBuilder = dbFactory.newDocumentBuilder();
         doc = dBuilder.parse(fXmlFile);
         doc.getDocumentElement().normalize();
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
       finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    public static void intBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = intChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = intFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = intIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initSauceDemo();
        action= new Actions(driver);

    }
    public static WebDriver intFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }
    public static WebDriver intChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
        public static WebDriver intIEDriver (){
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        return driver;
    }
    public static void intMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APPPACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APPACTIVITY"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Unable to connect to server, see details: "+e);
        }
       ManagePages.initMetricConversions();

        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver,Long.parseLong(getData("Timeout")));
        action= new Actions(driver);


    }
    public static void intAPI(){
        RestAssured.baseURI=getData("urlAPI");
        httpRequest=RestAssured.given();

    }
    public static void intElectron(){
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt =new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initToDo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
        action= new Actions(driver);

    }
    public static void intDesktop(){
        dc.setCapability("app",getData("AppSignature"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")),dc);
        } catch (MalformedURLException e) {
            System.out.println("Can not connect to Apium Driver See details: "+ e);
        }
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
        action= new Actions(driver);
        ManagePages.initCalc();

    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName){
        Platform = PlatformName;
        if (Platform.equalsIgnoreCase("web"))
            intBrowser(getData("BrowserName"));
        else if (Platform.equalsIgnoreCase("mobile"))
            intMobile();
        else if (Platform.equalsIgnoreCase("api"))
            intAPI();
        else if (Platform.equalsIgnoreCase("electron"))
            intElectron();
        else if (Platform.equalsIgnoreCase("desktop"))
            intDesktop();
        else
           throw new RuntimeException("Invalid platform name");

        softAssert= new SoftAssert();
        screen=new Screen();
        ManageDB.OpenConnection(getData("DBURL"),getData("DBUserName"),getData("DBPassword"));
    }
    @AfterClass
    public void closeSession(){
        ManageDB.CloseConnection();
        if (!Platform.equalsIgnoreCase("api")) {

            if (!Platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

    @AfterMethod
    public void afterMethod(){
        if (Platform.equalsIgnoreCase("web"))
            driver.get(getData("url"));
        else if (Platform.equalsIgnoreCase("electron"))
            ElectronFlows.DeleteList();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!Platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}




