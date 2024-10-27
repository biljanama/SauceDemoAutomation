package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Base.BaseTest.driver;

public class CheckoutCompletePage {

    public CheckoutCompletePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "back-to-products")
    public WebElement backHomeButton;

    @FindBy (className = "complete-header")
    public WebElement orderConfirmationTitle;

    @FindBy (className = "title")
    public WebElement checkoutCompleteTitle;

}
