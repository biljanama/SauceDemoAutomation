package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsPageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    @Test
    public void userCanAddItemFromProductsPage() {
        productPage.sauceLabBackpackItemAddButton.click();
        Assert.assertTrue(productPage.removeSauceLabsBackpack.isDisplayed());
        Assert.assertTrue(productPage.shoppingCartNumber.isDisplayed());
        Assert.assertEquals(productPage.shoppingCartNumber.getText(), "1");
        productPage.clickOnRemoveItemFromCart();

    }

    @Test
    public void userCanRemoveItemFromProductsPage() {
        productPage.sauceLabBackpackItemAddButton.click();
        productPage.removeSauceLabsBackpack.click();
        Assert.assertTrue(productPage.sauceLabBackpackItemAddButton.isDisplayed());
    }

    @Test
    public void userCanClickOnCollapsedMenuButton() {
        productPage.clickOnBurgerMenu();
        Assert.assertTrue(productPage.burgerMenu.isDisplayed());
    }

    @Test
    public void userCanGoOnAboutPageFromDropdownMenu() throws InterruptedException {
        productPage.clickOnBurgerMenu();
        Thread.sleep(2000);
        productPage.aboutPageLink.click();
        String expectedURL = "https://saucelabs.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test
    public void userCanClickOnItemName() {
        productPage.sLBItemName.click();
        String expectedURL = "https://www.saucedemo.com/inventory-item.html?id=4";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(itemPage.sLBItemName.isDisplayed());
        Assert.assertTrue(itemPage.sLBItemPrice.isDisplayed());
        Assert.assertTrue(itemPage.sLBItemAddToCartButton.isDisplayed());
    }

    @Test
    public void userCanAddMultipleItemsToCart() {
        productPage.clickOnSLBItemAddButton();
        productPage.boltTShirtAddTOCartProductsPage.click();
        Assert.assertEquals(productPage.shoppingCartNumber.getText(), "2");
        Assert.assertTrue(productPage.removeLBItemFromCart.isDisplayed());
        Assert.assertTrue(productPage.removeBoltThirtProductsPage.isDisplayed());
    }


}
