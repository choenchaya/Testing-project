package PageObjects.MetricConversions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MainPage {

    private AppiumDriver mobileDriver;

   public MainPage(AppiumDriver mobileDriver){
      this.mobileDriver= mobileDriver;
       PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);

    }

    @AndroidFindBy(xpath = "//*[@contentDescription='Favorites']")
    public AndroidElement Favorites;

    @AndroidFindBy(xpath = "//*[@contentDescription='Convert']")
    public AndroidElement convert;

    @AndroidFindBy(xpath = "//*[@contentDescription='History']")
    public AndroidElement History;

    @AndroidFindBy(xpath = "//*[@contentDescription='About']")
    public AndroidElement About;

    @AndroidFindBy(xpath = "//*[@id='type_row_layout' and ./*[@text='Temperature']]")
    public AndroidElement Temperature;

    @AndroidFindBy(xpath = "//*[@id='type_row_layout' and ./*[@text='Length']]")
    public AndroidElement Length;

    @AndroidFindBy(xpath = "//*[@id='type_row_layout' and ./*[@text='Area']]")
    public AndroidElement Area;

    @AndroidFindBy(xpath = "//*[@id='type_row_layout' and ./*[@text='Volume']]")
    public AndroidElement Volume;

    @AndroidFindBy(xpath = "//*[@id='type_row_layout' and ./*[@text='Weight']]")
    public AndroidElement Weight;

    @AndroidFindBy(xpath = "//*[@id='type_row_layout' and ./*[@text='Time']]")
    public AndroidElement Time;

    @AndroidFindBy(xpath = "//*[@id='type_row_layout' and ./*[@text='Currency']]")
    public AndroidElement Currency;

    @AndroidFindBy(xpath = "//*[@id='type_row_layout' and ./*[@text='Angle']]")
    public AndroidElement Angle;

    @AndroidFindBy(xpath = "//*[@id='type_row_layout' and ./*[@text='Pressure']]")
    public AndroidElement Pressure;

    @AndroidFindBy(xpath = "//*[@id='type_row_layout' and ./*[@text='Energy and Power']]")
    public AndroidElement EnergyAndPower;


}
