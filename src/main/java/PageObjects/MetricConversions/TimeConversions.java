package PageObjects.MetricConversions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class TimeConversions {

  private AppiumDriver mobileDriver;

  public TimeConversions(AppiumDriver mobileDriver){
        this.mobileDriver= mobileDriver;
    PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
}

    @AndroidFindBy(xpath = "//*[@id='unit_row_layout' and ./*[@text='Seconds']]")
    public AndroidElement Seconds;

    @AndroidFindBy(xpath = "//*[@id='unit_row_layout' and ./*[@text='Minutes']]")
    public AndroidElement Minutes;

    @AndroidFindBy(xpath = "//*[@id='unit_row_layout' and ./*[@text='Hour']]")
    public AndroidElement Hour;

    @AndroidFindBy(xpath = "//*[@id='unit_row_layout' and ./*[@text='Day']]")
    public AndroidElement Day;

    @AndroidFindBy(id = "arg1")
    public AndroidElement ValueForConversion;

    @AndroidFindBy(id = "button_convert")
    public AndroidElement ButtonConvert;

    @AndroidFindBy(id = "question_and_answer_text")
    public AndroidElement ConversionOutput;

}
