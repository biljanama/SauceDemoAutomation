package Pages;


import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

    public CheckoutOverviewPage() {
        PageFactory.initElements(BaseTest.driver, this);
    }


    @FindBy (id = "cancel")
    public WebElement cancelShoppingButton;

    @FindBy (id = "finish")
    public WebElement finishButton;

    public void clickOnCancelShoppingButton() {
        cancelShoppingButton.click();

    }

    public void clickOnFinishButton() {
        finishButton.click();
    }


}
