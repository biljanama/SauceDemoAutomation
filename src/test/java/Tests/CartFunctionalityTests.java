package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartFunctionalityTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }


    @Test
    public void userCanAddItemFromSelectedItemPage() {
        productPage.sLBItemName.click();
        productPage.addToCartItemPage.click();
        Assert.assertTrue(productPage.removeLBItemFromCart.isDisplayed());
        Assert.assertEquals(productPage.shoppingCartNumber.getText(), "1");
        productPage.removeLBItemFromCart.click();
    }

    @Test
    public void userCanRemoveItemFromCart() {
        productPage.sauceLabBackpackItemAddButton.click();
        productPage.cart.click();
        cartPage.removeButton.click();
        Assert.assertFalse(elementIsDisplayed(productPage.boltTshirtName));
        Assert.assertFalse(elementIsDisplayed(productPage.sLBItemName));
    }

    public boolean elementIsDisplayed(WebElement element) {
        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return isDisplayed;
    }


    @Test
    public void userCanPlaceAnOrder() {
        productPage.clickOnSLBItemAddButton();
        productPage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillTheInfoForm();
        checkoutOverviewPage.clickOnFinishButton();
        Assert.assertTrue(checkoutCompletePage.backHomeButton.isDisplayed());
        Assert.assertEquals(checkoutCompletePage.checkoutCompleteTitle.getText(), "Checkout: Complete!");
        Assert.assertEquals(checkoutCompletePage.orderConfirmationTitle.getText(), "Thank you for your order!");
        String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }


    @Test
    public void userCanProceedFromCartToCheckout() {
        productPage.clickOnSLBItemAddButton();
        productPage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutPage.firstNameField.isDisplayed());
        Assert.assertTrue(checkoutPage.lastNameField.isDisplayed());
        Assert.assertTrue(checkoutPage.postalCodeField.isDisplayed());
        Assert.assertTrue(checkoutPage.cancelButton.isDisplayed());
        Assert.assertTrue(checkoutPage.continueButton.isDisplayed());
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void userCanProceedFromCheckoutToCheckoutOverview() {
        productPage.clickOnSLBItemAddButton();
        productPage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillTheInfoForm();
        Assert.assertTrue(checkoutOverviewPage.cancelShoppingButton.isDisplayed());
        Assert.assertTrue(checkoutOverviewPage.finishButton.isDisplayed());
        String expectedURL = "https://www.saucedemo.com/checkout-step-two.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test
    public void userCannotProceedToCheckoutWithoutFillingMandatoryFields() {
        productPage.clickOnSLBItemAddButton();
        productPage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(checkoutPage.error.isDisplayed());
        Assert.assertEquals(checkoutPage.xButton.size(), 3);
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void addedItemsAreInTheCartAfterLogout() throws InterruptedException {
        productPage.clickOnSLBItemAddButton();
        productPage.boltTShirtAddTOCartProductsPage.click();
        productPage.burgerMenuButton.click();
        Thread.sleep(2000);
        productPage.logoutField.click();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(productPage.shoppingCartNumber.isDisplayed());
        Assert.assertEquals(productPage.shoppingCartNumber.getText(), "2");

    }


}
