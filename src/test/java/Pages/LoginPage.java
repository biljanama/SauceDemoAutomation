package Pages;


import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(BaseTest.driver, this);
    }


    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy (id = "password")
    public WebElement passwordField;

    @FindBy (id = "login-button")
    public WebElement loginButton;

    @FindBy (css = ".error-message-container.error")
    public WebElement errorMessage;

    @FindBy (className = "error_icon")
    public List<WebElement> xIconList;

    @FindBy (className = "Username")
    public WebElement placeholderUsername;

    @FindBy (className = "Password")
    public WebElement placeholderPassword;

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void inputUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }


}
