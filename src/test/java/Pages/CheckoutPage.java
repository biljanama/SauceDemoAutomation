package Pages;


import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {

    public CheckoutPage() {
        PageFactory.initElements(BaseTest.driver, this);
    }


    @FindBy (id = "first-name")
    public WebElement firstNameField;

    @FindBy (id = "last-name")
    public WebElement lastNameField;

    @FindBy (id = "postal-code")
    public WebElement postalCodeField;

    @FindBy (id = "cancel")
    public WebElement cancelButton;

    @FindBy (id = "continue")
    public WebElement continueButton;

    @FindBy (css = ".error-message-container.error")
    public WebElement error;

    @FindBy (css = ".svg-inline--fa.fa-times-circle.fa-w-16.error_icon")
    public List<WebElement> xButton;

    public void inputFirstName(String firstname) {
        firstNameField.clear();
        firstNameField.sendKeys(firstname);
    }

    public void inputLastName(String lastname) {
        lastNameField.clear();
        lastNameField.sendKeys(lastname);
    }

    public void clickOnCancelButton () {
        cancelButton.click();
    }

    public void clickOnContinueButton () {
        continueButton.click();
    }

    public void fillTheInfoForm () {
        firstNameField.sendKeys("Jane");
        lastNameField.sendKeys("Dawn");
        postalCodeField.sendKeys("110000");
        clickOnContinueButton();
    }





}
