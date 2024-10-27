package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static WebDriver driver;
    public LoginPage loginPage;
    public CartPage cartPage;
    public ProductsPage productPage;
    public CheckoutPage checkoutPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public ItemPage itemPage;
    public CheckoutCompletePage checkoutCompletePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage();
        cartPage = new CartPage();
        productPage = new ProductsPage();
        checkoutPage = new CheckoutPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
        itemPage = new ItemPage();
        checkoutCompletePage = new CheckoutCompletePage();

    }





}
