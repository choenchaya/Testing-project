package PageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.*;
import java.util.List;

public class MainPage {

    @FindBy(how = How.CLASS_NAME, using = "app_logo")
    public  WebElement AppLogo;

    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_link")
    public WebElement shoppingCartLink;

    @FindBy(how = How.CLASS_NAME, using = "bm-burger-button")
    public WebElement LeftMenuButton;

    @FindBy(how = How.CLASS_NAME,using = "peek")
    public WebElement peek;

    @FindBy (how = How.XPATH,using = "//div[@class='inventory_container']/div")
    public List<WebElement> InventoryList;

    @FindBy(how = How.CLASS_NAME, using = "title")
    public WebElement Title;

    @FindBy(how = How.CLASS_NAME, using = "product_sort_container")
    public WebElement select_container;

    @FindBy (how = How.TAG_NAME,using = "button")
    public List<WebElement>AddsToCart;

    @FindBy (how = How.CLASS_NAME,using = "button")
    public List<WebElement>Removes;

    @FindBy (how = How.CLASS_NAME,using = "inventory_item_price")
    public List<WebElement> price;

    @FindBy (how = How.CLASS_NAME,using = "inventory_item_img")
    public List<WebElement> img;

    @FindBy (how = How.ID,using = "add-to-cart-sauce-labs-bike-light")
    public WebElement AddToCart ;

    @FindBy (how = How.ID,using = "remove-sauce-labs-bike-light")
    public WebElement Remove ;

    @FindBy (how = How.CLASS_NAME, using = "shopping_cart_badge")
    public WebElement ShoppingCartBadge;






}
