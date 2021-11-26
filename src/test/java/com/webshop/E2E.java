package test.java.com.webshop;

import com.webshop.pages.*;
import main.java.com.webshop.pages.Registration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class E2E {

    private WebDriver driver;

    @BeforeTest
    public void setupDriver(){

        this.driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void openWebShopApplication(){
        Common common = new Common(driver);

        common.openApplication();
    }

    @Test(priority = 2)
    public void successfulRegistration(){
        LandingPage landingPage = new LandingPage(driver);
        Registration registration = new Registration(driver);

        landingPage.goToRegisterPage();
        registration.fillInTheRegistrationFormAndClickRegisterButton();
        registration.verifyThatRegistrationIsSuccessful();
        registration.clickContinueButton();
    }

    @Test(priority = 3)
    public void successfulLogout(){
        LandingPage landingPage = new LandingPage(driver);

        landingPage.clickLogoutLink();
        landingPage.verifyThatUserHasSuccessfullyLoggedOut();
    }

    @Test(priority = 4)
    public void successfulLogin(){
        LandingPage landingPage = new LandingPage(driver);
        Login login = new Login(driver);

        landingPage.goToLoginPage();
        login.fillInTheLoginFormAndClickLoginButton();
        login.verifyThatUserHasSuccessfullyLoggedIn();
    }

    @Test(priority = 5)
    public void searchProduct(){
        Shop shop = new Shop(driver);

        shop.searchProductItem();
    }

    @Test(priority = 6)
    public void inputProductDetailsAndAddToCart(){
        Shop shop = new Shop(driver);

        shop.selectProductImage();
        shop.inputItemQuantity();
        shop.clickAddToCartButton();
    }

    @Test(priority = 7)
    public void selectProductsToCheckoutAndAgreeToTermsAndService() throws InterruptedException {
        ShoppingCart shoppingCart = new ShoppingCart(driver);

        shoppingCart.clickShoppingCartLink();
        shoppingCart.tickItemCheckbox();
        shoppingCart.tickTermsOfServiceCheckbox();
        shoppingCart.clickCheckoutButton();
    }

    @Test(priority = 8)
    public void checkoutProduct() throws InterruptedException {
        Checkout checkout = new Checkout(driver);

        checkout.fillInBillingAddressForm();
        checkout.selectAndAddNewShippingAddress();
        checkout.selectShippingMethod();
        checkout.selectPaymentMethod();
        checkout.reviewPaymentInformation();
        checkout.confirmOrder();
        checkout.verifyThatOrderHasBeenSuccessfullyProcessed();
    }

    @Test(priority = 9)
    public void closeWebShopApplication(){
        Common common = new Common(driver);

        common.closeApplication();
    }
}
