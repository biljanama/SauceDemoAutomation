package Tests;


import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void userCanLogout() throws InterruptedException {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        productPage.burgerMenuButton.click();
        Thread.sleep(2000);
        productPage.logoutField.click();
        String expectedURL = "https://www.saucedemo.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
