package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCart {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "cart-label")
    private WebElement shoppingCartLink;

    @FindBy(name = "removefromcart")
    private WebElement itemCheckbox;

    @FindBy(id = "termsofservice")
    private WebElement termsOfServiceCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkOutButton;


    public ShoppingCart(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void clickShoppingCartLink() throws InterruptedException {
        Thread.sleep(5000);
        this.shoppingCartLink.click();
    }

    public void tickItemCheckbox(){
        this.itemCheckbox.click();
    }

    public void tickTermsOfServiceCheckbox(){
        this.termsOfServiceCheckbox.click();
    }

    public void clickCheckoutButton(){
        this.checkOutButton.click();
    }
}