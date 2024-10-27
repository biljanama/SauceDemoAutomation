package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Base.BaseTest.driver;


public class CartPage  {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy (id = "checkout")
    public WebElement checkoutButton;

    @FindBy (className = "shopping_cart_badge")
    public WebElement shoppingCartNumber;

    @FindBy (id ="remove-sauce-labs-backpack")
    public WebElement removeButton;

    @FindBy (id = "remove-sauce-labs-bolt-t-shirt")
    public WebElement removeBoltTshirtFromCart;

    public void clickONRemoveSLBItem() {
        removeButton.click();
    }

    public void clickOnRemoveBTshirtItem() {
        removeBoltTshirtFromCart.click();
    }

    public void clickOnContinueShopping () {
        continueShoppingButton.click();
    }

    public void clickOnCheckoutButton () {
        checkoutButton.click();
    }












}
