package PageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AboutPage {
    @FindBy(how = How.CSS, using ="#headerMainNav > div > nav > ul > li.nav-menu-list-container > ul:nth-child(2) > li:nth-child(5) > div.nav-menu > div > a")
    public WebElement CompanyMouseHover;
    @FindBy(how = How.CSS, using ="#headerMainNav > div > nav > ul > li.nav-menu-list-container > ul:nth-child(2) > li:nth-child(5) > div.nav-menu-link-group-row-list-wrapper > div > div > div > ul > li > div > ul > li > div > ul > li:nth-child(1) > div > ul > li > a" )
    public WebElement AboutUsMouseHover;
    @FindBy (how = How.CSS, using = "#entry-3zE2XinivioBmMs7zu8eMO > div > div > div.column.is-6.reference-container > div > h3")
    public WebElement AboutSauceLabs;
}
