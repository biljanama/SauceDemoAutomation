package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Base.BaseTest.driver;

public class ProductsPage {

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy (id = "react-burger-menu-btn")
    public WebElement burgerMenuButton;

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    public WebElement sauceLabBackpackItemAddButton;

    @FindBy (id = "item_4_title_link")
    public WebElement sLBItemName;

    @FindBy (id = "add-to-cart")
    public WebElement addToCartItemPage;

    @FindBy (id = "remove-sauce-labs-backpack")
    public WebElement removeLBItemFromCart;

    @FindBy (id = "item_1_title_link")
    public WebElement boltTshirtName;

    @FindBy (id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement boltTShirtAddTOCartProductsPage;

    @FindBy (id = "remove-sauce-labs-bolt-t-shirt")
    public WebElement removeBoltThirtProductsPage;

    @FindBy (className = "shopping_cart_link")
    public WebElement cart;

    @FindBy (id = "logout_sidebar_link")
    public WebElement logoutField;

    @FindBy (className = "title")
    public WebElement productPageTitle;

    @FindBy (className = "shopping_cart_badge")
    public WebElement shoppingCartNumber;

    public void clickOnRemoveItemFromCart () {
        removeSauceLabsBackpack.click();
    }


    @FindBy (id = "remove-sauce-labs-backpack")
    public WebElement removeSauceLabsBackpack;

    @FindBy (className = "bm-menu")
    public WebElement burgerMenu;

    @FindBy (id = "about_sidebar_link")
    public WebElement aboutPageLink;

    public void clickOnBurgerMenu() {
        burgerMenuButton.click();
    }

    public void clickOnCart() {
        cart.click();
    }

    public void clickOnSLBItemAddButton() {
        sauceLabBackpackItemAddButton.click();
    }






}
