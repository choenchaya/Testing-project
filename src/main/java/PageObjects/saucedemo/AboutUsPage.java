package PageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AboutUsPage {
    @FindBy(how = How.CSS, using = "#entry-3zE2XinivioBmMs7zu8eMO > div > div > div.column.is-6.reference-container > div > h3")
    public WebElement AboutSauceLabs;
}
