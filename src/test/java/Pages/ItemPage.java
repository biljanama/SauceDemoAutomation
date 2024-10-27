package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {

    public ItemPage() {
        PageFactory.initElements(BaseTest.driver, this);
    }

    @FindBy (css = ".inventory_details_name.large_size")
    public WebElement sLBItemName;

    @FindBy (className = "inventory_details_price")
    public WebElement sLBItemPrice;

    @FindBy (id = "add-to-cart")
    public WebElement sLBItemAddToCartButton;

    @FindBy (id = "remove")
    public WebElement slBItemRemoveButton;

    public void clickOnAddToCart() {
        sLBItemAddToCartButton.click();
    }

    public void clickONSLBItemName() {
        sLBItemName.click();
    }

    public void clickOnRemoveSLBItemButton() {
        slBItemRemoveButton.click();
    }


}
