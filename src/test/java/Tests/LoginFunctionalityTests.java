package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginFunctionalityTests extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void userCanLoginWithValidCredentials () {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(productPage.productPageTitle.isDisplayed());
        Assert.assertTrue(productPage.cart.isDisplayed());
    }

    @Test
    public void userCannotLoginWithValidUsernameAndInvalidPassword() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secretsauce");
        loginPage.clickOnLoginButton();
        String expectedURL = "https://www.saucedemo.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginPage.xIconList.size(), 2);

    }

    @Test
    public void userCannotLoginWithInvalidUsernameAndValidPassword() {
        loginPage.inputUsername("standar_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        String expectedURL = "https://www.saucedemo.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginPage.xIconList.size(), 2);

    }

    @Test
    public void userCantLoginWithEmptyPasswordField() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secretsauce");
        loginPage.clickOnLoginButton();
        String expectedURL = "https://www.saucedemo.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginPage.xIconList.size(), 2);
    }


}
